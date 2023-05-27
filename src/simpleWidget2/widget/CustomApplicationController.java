package simpleWidget2.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import viewapi.controller.BackgroundException;
import viewapi.view.ViewContainer;
import viewapi.view.ViewException;
import viewcore.controller.AbstractViewController;

public class CustomApplicationController extends AbstractViewController<ActionListener, ActionEvent> {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Override
	public Class<ActionListener> getSupportedClass() {
		// TODO Auto-generated method stub
		return ActionListener.class;
	}
	private void debugJustInCase(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}
	public void handleView(ViewContainer view, ActionEvent eventObject) throws BackgroundException{
		debugJustInCase("certification report_handle view");
	
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.viewaframework.controller.AbstractViewController#postHandlingView
	 * (org.viewaframework.view.ViewContainer, java.util.EventObject)
	 */
	@Override
	public void postHandlingView(ViewContainer view, ActionEvent eventObject) throws ViewException {
		debugJustInCase("certification report_post_handling_view");
		
	}
}
