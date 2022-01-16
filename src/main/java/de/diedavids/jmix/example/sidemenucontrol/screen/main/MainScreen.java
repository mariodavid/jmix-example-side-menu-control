package de.diedavids.jmix.example.sidemenucontrol.screen.main;

import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenTools;
import io.jmix.ui.component.AppWorkArea;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Window;
import io.jmix.ui.component.mainwindow.Drawer;
import io.jmix.ui.component.mainwindow.SideMenu;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.MessageBundle;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiControllerUtils;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@UiController("MainScreen")
@UiDescriptor("main-screen.xml")
@Route(path = "main", root = true)
public class MainScreen extends Screen implements Window.HasWorkArea {

    @Autowired
    private ScreenTools screenTools;

    @Autowired
    private AppWorkArea workArea;
    @Autowired
    private Drawer drawer;
    @Autowired
    private Button collapseDrawerButton;
    @Autowired
    private SideMenu sideMenu;
    @Autowired
    private MessageBundle messageBundle;
    @Autowired
    private Notifications notifications;


    @Override
    public AppWorkArea getWorkArea() {
        return workArea;
    }

    @Subscribe("collapseDrawerButton")
    private void onCollapseDrawerButtonClick(Button.ClickEvent event) {
        drawer.toggle();
        if (drawer.isCollapsed()) {
            collapseDrawerButton.setIconFromSet(JmixIcon.CHEVRON_RIGHT);
        } else {
            collapseDrawerButton.setIconFromSet(JmixIcon.CHEVRON_LEFT);
        }
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        screenTools.openDefaultScreen(
                UiControllerUtils.getScreenContext(this).getScreens());

        screenTools.handleRedirect();
    }

    @Subscribe("generateMenuItem")
    public void onGenerateMenuItemClick(Button.ClickEvent event) {
        final UUID randomId = UUID.randomUUID();
        final SideMenu.MenuItem helloWorld = sideMenu.createMenuItem("helloWorld" + randomId);

        helloWorld.setCaption(messageBundle.formatMessage("helloWorld", randomId));
        helloWorld.setCommand(menuItem -> {
            notifications.create(Notifications.NotificationType.TRAY)
                    .withCaption(messageBundle.formatMessage("hello", randomId))
                    .show();
        });

        sideMenu.addMenuItem(helloWorld);
    }
}
