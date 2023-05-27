package simpleWidget2.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import viewapi.controller.BackgroundException;
import viewapi.view.ViewContainer;
import viewapi.view.ViewException;
import viewapi.view.event.ViewContainerEventController;
import viewapi.view.perspective.PerspectiveConstraint;
import viewcore.controller.AbstractViewController;
import viewswing.swing.DynamicTable;
import viewswing.swing.table.DynamicTableColumn;
import viewswing.swing.table.DynamicTableModel;

/**
 * @author Mario Garcia
 * @since 1.0.2
 * 
 */

///https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/core/src/test/java/org/viewaframework/common/TestController.java
public class TestController extends AbstractViewController<ActionListener, ActionEvent> {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.viewaframework.controller.ViewController#getSupportedClass()
	 */
	public Class<ActionListener> getSupportedClass() {
		return ActionListener.class;
	}

	private void debugJustInCase(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}
	public void handleView(ViewContainer view, ActionEvent eventObject) throws BackgroundException{
		debugJustInCase("handleView_called");
	/*	Map<String,List<Component>> map = view.getNamedComponents();
		debugJustInCase("handleView_called"+map);
		Map<Object,ViewContainer> viewMap = view.getApplication().getViewManager().getViews();
		debugJustInCase("view_container_map:"+viewMap);
		*/
		//ViewContainer viewContainer = viewMap.get("TableViewId");
		//Map<String,List<Component>> map2 = viewContainer.getNamedComponents();
	//	JLabel field = ComponentFinder.find(JLabel.class).in(viewContainer).named("toLabel");
		//field.setText("hello");
	
		//view.getApplication().getViewManager().getPerspective().removeView(viewContainer);
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.viewaframework.controller.AbstractViewController#postHandlingView
	 * (org.viewaframework.view.ViewContainer, java.util.EventObject)
	 */
	@Override
	public void postHandlingView(ViewContainer view, ActionEvent eventObject) throws ViewException {
		debugJustInCase("processing_view:"+view.getId());
		String actionCommand = eventObject.getActionCommand();
		List<ViewContainerEventController> listeners = view.getViewContainerListeners();
		if (null != listeners && !listeners.isEmpty()) {
			debugJustInCase("listeners:" + listeners.size());
			ViewContainerEventController listener = listeners.get(0);

		} else {
			debugJustInCase("listeners_is_empty");
		}

		debugJustInCase("action_command:"+actionCommand);
		/*Object object = eventObject.getSource();
		if (null != object) {
			debugJustInCase("post_handling_view:" + object.getClass().getSimpleName());
		}
		debugJustInCase("post_handling_view:" + view.getNamedComponents());
		*/
		// JTextField field =
		// ComponentFinder.find(JTextField.class).in(view).named("text");
		// field.setText("Hey it worked");
		Map<Object,ViewContainer> views = view.getApplication().getViewManager().getViews();
		debugJustInCase("map_of_views:"+views.keySet());
		if(actionCommand.equals("Certification")) {
			List<Certification> 
			memberList = Arrays.asList(
					new Certification("Joe","0392jr"),
					new Certification("Janet","323rr"),
					new Certification("Blackham","3r23r"),
					new Certification("Erikka","234f2"),
					new Certification("Moira","23d23d"),
					new Certification("Ulrich","23f23f")
				);
			
			
			ViewContainer tabContainer = new CertificationView(memberList); 
			try {
		
				ViewContainer viewToRemove = views.get("CustomApplicationView");
				
				view.getApplication().getViewManager().getPerspective().removeView(viewToRemove);
				view.getApplication().getViewManager().addView(tabContainer, PerspectiveConstraint.RIGHT);
				views.remove("CustomApplicationView");
			} catch (ViewException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(actionCommand.equals("Custom Application")) {
			ViewContainer customApp = new CustomApplicationView(); 
			try {
				
				ViewContainer viewToRemove = views.get("CertificationView");
				if(null != viewToRemove) {
					
					view.getApplication().getViewManager().getPerspective().removeView(viewToRemove);
					debugJustInCase("certification view removed");
					view.getApplication().getViewManager().addView(customApp, PerspectiveConstraint.RIGHT);
					views.remove("CertificationView");
				}
			} catch (ViewException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}