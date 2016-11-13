package nl.agileprof.patterns.abstractfactory.uiwidget;

/**
 * @author ahup
 * @since 13/11/2016
 */
//Client
public class GUIBuilder{
	public GUIBuilder buildWindow(AbstractWidgetFactory widgetFactory){
		Window window = widgetFactory.createWindow();
		window.setTitle("New Window");
		return this;
	}
}
