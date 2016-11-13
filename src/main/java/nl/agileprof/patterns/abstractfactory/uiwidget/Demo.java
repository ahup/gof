package nl.agileprof.patterns.abstractfactory.uiwidget;

/**
 * @author ahup
 * @since 13/11/2016
 */
public class Demo
{

	public static void main(String[] args)
	{
		GUIBuilder builder = new GUIBuilder();
		AbstractWidgetFactory widgetFactory = null;
		//check what platform we're on
		if (System.getProperty("os.name") == "MACOSX")
		{
			widgetFactory = new MacWidgetFactory();
		}
		else
		{
			widgetFactory = new MSWindowsWidgetFactory();
		}
		builder.buildWindow(widgetFactory);
	}
}
