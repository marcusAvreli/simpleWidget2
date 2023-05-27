package simpleWidget2.widget;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import viewcore.annotation.Controllers;
import viewcore.annotation.Controller;
import viewcore.core.view.DefaultViewContainer;
import viewswing.swing.builder.SwingBuilder;
import viewswing.swing.builder.layout.GridBagConstraintsBuilder;

//https://github.com/mariogarcia/viewa/blob/c39f7f46dc39908bd23cd4ded0b60c5f555617b8/widget/src/test/java/org/viewaframework/widget/swing/builder/util/SwingBuilderView.java
@Controllers({
	@Controller(type=TestController.class,pattern="certification"),
	@Controller(type=TestController.class,pattern="customApplicationBtn"),
	
})
public class SwingBuilderView extends DefaultViewContainer{
	public SwingBuilderView(){
		super("SwingBuilderViewId",
			new SwingBuilder().layout(new BorderLayout()).component(
					new SwingBuilder().
					layout(new GridBagLayout()).
					 /* (1) label-component */
						label(new GridBagConstraintsBuilder().row(0).col(0).gridWidth(2).build()).
							setName("fromLabel").setText("From").swingBuilder().
						button(new GridBagConstraintsBuilder().
									row(6).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
								setName("customApplicationBtn").setText("Custom Application").setPreferredSize(new Dimension(180,25)).swingBuilder().
								button(new GridBagConstraintsBuilder().
										row(7).col(0).gridWidth(3).anchor(GridBagConstraints.EAST).fill(GridBagConstraints.NONE).insets(20,0,0,0).build()).
									setName("certification").setText("Certification").setPreferredSize(new Dimension(180,25)).swingBuilder().
						getTarget()
							,JPanel.class,BorderLayout.NORTH).
						swingBuilder().setPreferredSize(new Dimension(400,0)).getTarget());
	}
}