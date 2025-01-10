package org.jhotdraw.action.edit;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.text.JTextComponent;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenCanvasShouldReflectAction extends Stage<ThenCanvasShouldReflectAction> {
    @ProvidedScenarioState
    JTextComponent textComponent;

    public ThenCanvasShouldReflectAction all_objects_should_be_selected() {
        assertThat(textComponent.getSelectionStart()).isEqualTo(0);
        assertThat(textComponent.getSelectionEnd()).isEqualTo(textComponent.getText().length());
        return self();
    }

    public ThenCanvasShouldReflectAction no_objects_should_be_selected() {
        assertThat(textComponent.getSelectionStart()).isEqualTo(textComponent.getSelectionEnd());
        return self();
    }
}