package org.jhotdraw.action.edit;

import org.jhotdraw.api.gui.EditableComponent;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SelectAllActionTest {

    private SelectAllAction selectAllAction;
    private JComponent target;
    private EditableComponent editableComponent;

    @Before
    public void setUp() {
        target = mock(JComponent.class);
        editableComponent = mock(EditableComponent.class);
    }

    // test to check if selectAll works for JTextComponent
    @Test
    public void testSelectAll_OnJTextComponent() {
        System.out.println("Test: SelectAll on JTextComponent");

        // creating a test JTextComponent
        JTextComponent textComponent = new JTextArea();
        textComponent.setText("Sample text");
        textComponent.select(0, 0); // deselecting all text

        // creating the action
        SelectAllAction action = new SelectAllAction(textComponent);

        // clling the actionPerformed method
        action.actionPerformed(new ActionEvent(textComponent, ActionEvent.ACTION_PERFORMED, null));

        // checking that all text is selected
        assertEquals("All text should be selected", textComponent.getText().length(), textComponent.getSelectionEnd() - textComponent.getSelectionStart());
    }

    // Test to check if selectAll works for EditableComponent
    @Test
    public void testSelectAll_OnEditableComponent() {
        System.out.println("Test: SelectAll on EditableComponent");

        // creating  mock class that implements EditableComponent and JComponent
        class EditableJComponent extends JComponent implements EditableComponent {
            private boolean allSelected = false;

            @Override
            public void selectAll() {
                allSelected = true;
                System.out.println("selectAll() called on EditableComponent");
            }

            @Override
            public void clearSelection() {
                allSelected = false;
            }

            @Override
            public void duplicate() {
                // Implement duplicate logic here
            }

            @Override
            public void delete() {
                // Implement delete logic here
            }

            @Override
            public boolean isSelectionEmpty() {
                // Implement isSelectionEmpty logic here
                return !allSelected;
            }

            public boolean isAllSelected() {
                return allSelected;
            }
        }

        // creating an instance of the mock class
        EditableJComponent editableJComponent = new EditableJComponent();

        // Creating the action
        SelectAllAction action = new SelectAllAction(editableJComponent);

        // calling the actionPerformed method
        action.actionPerformed(new ActionEvent(editableJComponent, ActionEvent.ACTION_PERFORMED, null));

        // chcecking if selectAll was called
        assertTrue("All items should be selected", editableJComponent.isAllSelected());
    }

    // Test to check if selectAll does not work for non-editable component
    @Test
    public void testSelectAll_OnNonEditableComponent() {
        System.out.println("Test: SelectAll on Non-Editable Component");

        // creating a test non-editable component
        JComponent nonEditableComponent = new JButton();

        // creating the action
        SelectAllAction action = new SelectAllAction(nonEditableComponent);

        // calling the actionPerformed method
        action.actionPerformed(new ActionEvent(nonEditableComponent, ActionEvent.ACTION_PERFORMED, null));

        // chcecking if selectAll was not called
        // JButton doesnt have selectAll method so 
        // the action should complete without exceptions
        assertTrue("Action should complete without exceptions", true);
    }

    // test to check if selectAll doesnt work when the component is disabled
    @Test
    public void testSelectAll_WhenComponentIsDisabled() {
        System.out.println("Test: SelectAll when Component is Disabled");

        // create a test JTextComponent
        JTextComponent textComponent = new JTextArea();
        textComponent.setText("Sample text");
        textComponent.setEnabled(false); // Disable the component

        // create the action
        SelectAllAction action = new SelectAllAction(textComponent);

        // call the actionPerformed method
        action.actionPerformed(new ActionEvent(textComponent, ActionEvent.ACTION_PERFORMED, null));

        // checking if no text is selected
        assertEquals("No text should be selected", 0, textComponent.getSelectionEnd() - textComponent.getSelectionStart());
    }

   
}