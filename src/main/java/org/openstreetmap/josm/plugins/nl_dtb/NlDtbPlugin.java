package org.openstreetmap.josm.plugins.nl_dtb;

import javax.swing.JMenu;

import org.openstreetmap.josm.gui.MainApplication;
import org.openstreetmap.josm.gui.util.GuiHelper;
import org.openstreetmap.josm.plugins.Plugin;
import org.openstreetmap.josm.plugins.PluginInformation;
import org.openstreetmap.josm.plugins.nl_dtb.gui.DtbDownloadAction;

public class NlDtbPlugin extends Plugin {
    @SuppressWarnings("unused")
    private boolean debugMode;

    private final JMenu menu;

    public NlDtbPlugin(PluginInformation info) {
        super(info);
        menu = MainApplication.getMenu().dataMenu;

        new Thread(() -> {
            // Add menu in EDT
            GuiHelper.runInEDT(this::buildMenu);
        }).start();
    }
    
    private void buildMenu() {
        JMenu brtMenu = new JMenu("NL DTB");
        brtMenu.add(new DtbDownloadAction());
        menu.add(brtMenu);
    }
}