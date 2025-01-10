package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;

public class WhenUserPerformsAction extends Stage<WhenUserPerformsAction> {
    @ProvidedScenarioState
    JTextComponent textComponent;

    public WhenUserPerformsAction the_user_performs_the_select_all_action() {
        SelectAllAction action = new SelectAllAction(textComponent);
        action.actionPerformed(new ActionEvent(textComponent, ActionEvent.ACTION_PERFORMED, null));
        return self();
    }

    public WhenUserPerformsAction the_user_performs_the_deselect_all_action() {
        ClearSelectionAction action = new ClearSelectionAction(textComponent);
        action.actionPerformed(new ActionEvent(textComponent, ActionEvent.ACTION_PERFORMED, null));
        return self();
    }
}