package org.jhotdraw.action.edit;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class CanvasActionBDDTest extends ScenarioTest<GivenCanvas, WhenUserPerformsAction, ThenCanvasShouldReflectAction> {

    @Test
    public void all_objects_should_be_selected_when_select_all_action_is_performed() {
        given().a_canvas_with_objects("Object1 Object2 Object3");
        when().the_user_performs_the_select_all_action();
        then().all_objects_should_be_selected();
    }

    @Test
    public void no_objects_should_be_selected_when_deselect_all_action_is_performed() {
        given().a_canvas_with_selected_objects("Object1 Object2 Object3");
        when().the_user_performs_the_deselect_all_action();
        then().no_objects_should_be_selected();
    }
}