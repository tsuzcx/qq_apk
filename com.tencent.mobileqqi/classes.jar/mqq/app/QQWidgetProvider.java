package mqq.app;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class QQWidgetProvider
  extends AppWidgetProvider
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    ((MobileQQ)paramContext.getApplicationContext()).onActivityCreate(null, paramIntent);
    onReceive(((MobileQQ)paramContext.getApplicationContext()).waitAppRuntime(null), paramContext, paramIntent);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.QQWidgetProvider
 * JD-Core Version:    0.7.0.1
 */