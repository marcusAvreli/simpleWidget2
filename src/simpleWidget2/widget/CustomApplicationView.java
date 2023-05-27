package simpleWidget2.widget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import viewcore.annotation.Controller;
import viewcore.annotation.Controllers;
import viewcore.core.view.DefaultViewContainer;
import viewswing.swing.builder.SwingBuilder;
import viewswing.swing.builder.layout.GridBagConstraintsBuilder;

/*
@Listeners({
	@Listener(
		type=TableListener.class,id="start2Button"
	)
})
*/
@Controllers({
	@Controller(type=CustomApplicationController.class,pattern="searchButton"),
	
})
public class CustomApplicationView extends DefaultViewContainer{
	public CustomApplicationView(){
		super("CustomApplicationView",
			new SwingBuilder().layout(new BorderLayout()).component(
					new SwingBuilder().
					layout(new GridBagLayout()).
					 /* (1) label-component */
						label(new GridBagConstraintsBuilder().row(0).col(0).gridWidth(2).build()).
							setName("toLabel").setText("To").swingBuilder()
							.button(new GridBagConstraintsBuilder().
									row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
								setName("searchButton").setText("CustomApplication").setPreferredSize(new Dimension(180,25)).
						 /* Returning the container to add it to the frame */
					swingBuilder().getTarget()
							,JPanel.class,BorderLayout.NORTH).
						swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
	}
}
