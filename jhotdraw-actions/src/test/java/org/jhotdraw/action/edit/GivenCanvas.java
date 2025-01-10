package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class GivenCanvas extends Stage<GivenCanvas> {
    @ProvidedScenarioState
    JTextComponent textComponent;

    public GivenCanvas a_canvas_with_objects(String text) {
        textComponent = new JTextArea();
        textComponent.setText(text);
        return self();
    }

    public GivenCanvas a_canvas_with_selected_objects(String text) {
        textComponent = new JTextArea();
        textComponent.setText(text);
        textComponent.selectAll();
        return self();
    }
}