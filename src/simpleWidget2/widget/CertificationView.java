package simpleWidget2.widget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import viewapi.view.ViewContainer;
import viewapi.view.event.ViewContainerEvent;
import viewcore.annotation.Controller;
import viewcore.annotation.Controllers;
import viewcore.annotation.Listener;
import viewcore.annotation.Listeners;
import viewcore.core.view.DefaultViewContainer;
import viewcore.core.view.event.DefaultViewContainerEventController;
import viewswing.swing.DynamicTable;
import viewswing.swing.builder.SwingBuilder;
import viewswing.swing.builder.layout.GridBagConstraintsBuilder;
import viewswing.swing.table.DynamicTableModel;
@Controllers({
	@Controller(type=CertificationController.class,pattern="getReportBtn"),
	
	
	
})
@Listeners({
	@Listener(
		type=CertificationListener.class,id="start2Button"
	)
})
public class CertificationView extends DefaultViewContainer{
	private static final Logger logger = LoggerFactory.getLogger(CertificationView.class);
	private void debugJustInCase(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}
	public CertificationView() {
		super("CertificationView",
				new SwingBuilder().layout(new BorderLayout()).component(
						new SwingBuilder().
						layout(new GridBagLayout()).
						 /* (1) label-component */
							label(new GridBagConstraintsBuilder().row(0).col(0).gridWidth(2).build()).
								setName("certificationLbl").setText("Certification").swingBuilder()
								.dynamicTable(Certification.class,new GridBagConstraintsBuilder().row(1).col(0).gridWidth(2).build()).setName("certificationTable")
										.swingBuilder()
								.button(new GridBagConstraintsBuilder().
										row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
									setName("getReportBtn").setText("Get Report").setPreferredSize(new Dimension(180,25)).
							 /* Returning the container to add it to the frame */
						swingBuilder().getTarget()
								,JPanel.class,BorderLayout.NORTH).
							swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
		
		debugJustInCase("certification_view_called");
		fireViewFinalUIState(null);
		//getComponentByName("certificationTable");
		debugJustInCase (""+getNamedComponents());
	}
	public CertificationView(List<Certification> dynamicTableModel){
		super("CertificationView",
			new SwingBuilder().layout(new BorderLayout()).component(
					new SwingBuilder().
					layout(new GridBagLayout()).
					 /* (1) label-component */
						label(new GridBagConstraintsBuilder().row(0).col(0).gridWidth(2).build()).
							setName("certificationLbl").setText("Certification").swingBuilder()
							.dynamicTable(Certification.class,new GridBagConstraintsBuilder().row(1).col(0).gridWidth(2).build()).setName("certificationTable").rows(
									dynamicTableModel).swingBuilder()
							.button(new GridBagConstraintsBuilder().
									row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
								setName("getReportBtn").setText("Get Report").setPreferredSize(new Dimension(180,25)).
						 /* Returning the container to add it to the frame */
					swingBuilder().getTarget()
							,JPanel.class,BorderLayout.NORTH).
						swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
	}
	private List<Certification> initView() {
		List<Certification> 
		memberList = Arrays.asList(
				new Certification("Joe","0392jr"),
				new Certification("Janet","323rr"),
				new Certification("Blackham","3r23r"),
				new Certification("Erikka","234f2"),
				new Certification("Moira","23d23d"),
				new Certification("Ulrich","23f23f")
			);
		return memberList;
	}
}
