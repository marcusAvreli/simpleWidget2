package simpleWidget2.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import viewapi.view.ViewContainer;
import viewapi.view.event.ViewContainerEvent;
import viewapi.view.event.ViewContainerEventController;
import viewcore.annotation.Listener;
import viewcore.annotation.Listeners;
import viewswing.swing.DynamicTable;
import viewswing.swing.builder.component.DynamicTableBuilder;
import viewswing.swing.table.DynamicTableModel;
import  viewcore.core.util.ComponentFinder;
import static viewcore.core.util.ComponentFinder.find;




public class CertificationListener implements ViewContainerEventController{
	private static final Logger logger = LoggerFactory.getLogger(CertificationListener.class);
	private void debugJustInCase(String message) {
		if (logger.isDebugEnabled()) {
			logger.info(message);
		}
	}

	
	@Override
	public void onViewClose(ViewContainerEvent arg0) {
		// TODO Auto-generated method stub
		debugJustInCase("CertificationListener_onViewClose");
	}

	@Override
	public void onViewFinalUIState(ViewContainerEvent arg0) {
		// TODO Auto-generated method stub
		debugJustInCase("CertificationListener_onViewFinalUIState");
		ViewContainer view = arg0.getSource();
		debugJustInCase("the_map:"+view.getViewControllerMap());
		//debugJustInCase("the_map:"+view.getComponentByName("certificationTable"));
		debugJustInCase("the_map:"+view.getNamedComponents());
	}

	@Override
	public void onViewInit(ViewContainerEvent arg0) {
		// TODO Auto-generated method stub
		debugJustInCase("CertificationListener_onViewInit");
		ViewContainer view = arg0.getSource();
		
		debugJustInCase("the_map:"+view.getViewControllerMap());
		
		debugJustInCase("the_map:"+view.getNamedComponents());
		
	}

	@Override
	public void onViewInitBackActions(ViewContainerEvent arg0) {
		// TODOdebugJustInCase("TableListener"); Auto-generated method stub
	
		debugJustInCase("CertificationListener_onViewInitBackActions");
		ViewContainer view = arg0.getSource();
		debugJustInCase("the_map:"+view.getViewControllerMap());
		//debugJustInCase("the_map:"+view.getComponentByName("certificationTable"));
		debugJustInCase("the_map:"+view.getNamedComponents());
	}

	@Override
	public void onViewInitUIState(ViewContainerEvent arg0) {
		// TODO Auto-generated method stub
		debugJustInCase("TableListener_onViewInitUIState");
		ViewContainer view = arg0.getSource();
		debugJustInCase("the_map:"+view.getViewControllerMap());
		//debugJustInCase("the_map:"+view.getComponentByName("certificationTable"));
		debugJustInCase("the_map:"+view.getNamedComponents());
		List<Certification> 
		memberList = Arrays.asList(
				new Certification("Joe","0392jr"),
				new Certification("Janet","323rr"),
				new Certification("Blackham","3r23r"),
				new Certification("Erikka","234f2"),
				new Certification("Moira","23d23d"),
				new Certification("Ulrich","23f23f")
			);
		DynamicTable<Certification> field= find(DynamicTable.class).in(view).named("certificationTable");
		if(null != field) {
			DynamicTableModel model = (DynamicTableModel) field.getModel();
			for (Certification bean : memberList){
				model.addRow(bean);
			}
		}
		
		
	}

}
