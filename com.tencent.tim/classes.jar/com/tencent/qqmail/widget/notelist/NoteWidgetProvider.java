package com.tencent.qqmail.widget.notelist;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.widget.QMWidgetProvider;
import com.tencent.qqmail.widget.QMWidgetService;
import com.tencent.qqmail.widget.WidgetEventService;
import com.tencent.qqmail.widget.WidgetGesturePswActivity;
import java.util.Arrays;

public class NoteWidgetProvider
  extends QMWidgetProvider
{
  private static final String TAG = NoteWidgetProvider.class.getName();
  private RemoteViews remoteViews;
  
  public RemoteViews buildLayout(Context paramContext, int paramInt)
  {
    this.remoteViews = new RemoteViews(paramContext.getPackageName(), 2131563365);
    Object localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 1);
    ((Intent)localObject).putExtra("EVENT_TYPE", 10);
    localObject = PendingIntent.getService(paramContext, paramInt + 3001, (Intent)localObject, 134217728);
    this.remoteViews.setOnClickPendingIntent(2131362226, (PendingIntent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 1);
    ((Intent)localObject).putExtra("EVENT_TYPE", 11);
    localObject = PendingIntent.getService(paramContext, paramInt + 3003, (Intent)localObject, 134217728);
    this.remoteViews.setOnClickPendingIntent(2131362228, (PendingIntent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 1);
    ((Intent)localObject).putExtra("EVENT_TYPE", 12);
    localObject = PendingIntent.getService(paramContext, paramInt + 3004, (Intent)localObject, 134217728);
    this.remoteViews.setOnClickPendingIntent(2131362229, (PendingIntent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 1);
    ((Intent)localObject).putExtra("EVENT_TYPE", 13);
    localObject = PendingIntent.getService(paramContext, paramInt + 3002, (Intent)localObject, 134217728);
    this.remoteViews.setOnClickPendingIntent(2131362227, (PendingIntent)localObject);
    localObject = QMWidgetService.createIntentForNoteListWidget(paramContext, paramInt);
    this.remoteViews.setRemoteAdapter(paramInt, 2131372500, (Intent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 1);
    paramContext = PendingIntent.getService(paramContext, paramInt, (Intent)localObject, 134217728);
    this.remoteViews.setPendingIntentTemplate(2131372500, paramContext);
    return this.remoteViews;
  }
  
  public Intent createGesturePswIntent(Context paramContext)
  {
    return WidgetGesturePswActivity.createNoteListGesturePswIntent(paramContext);
  }
  
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    super.onAppWidgetOptionsChanged(paramContext, paramAppWidgetManager, paramInt, paramBundle);
    int i = paramBundle.getInt("appWidgetMinWidth");
    int j = NoteWidgetManager.getInstance().getWidgetSize(i);
    QMLog.log(4, TAG, "onAppWidgetOptionsChanged widgetSize = " + j);
    QMLog.log(4, TAG, "onAppWidgetOptionsChanged widget_min_width = " + i);
    NoteWidgetManager.getInstance().putSizeWithID(paramInt, j);
    paramAppWidgetManager.notifyAppWidgetViewDataChanged(paramInt, 2131372500);
  }
  
  public void onDisabled(Context paramContext)
  {
    super.onDisabled(paramContext);
    NoteWidgetManager.getInstance().release();
  }
  
  public void onEnabled(Context paramContext)
  {
    super.onEnabled(paramContext);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    QMLog.log(4, TAG, "onUpdate appWidgetIds = " + Arrays.toString(paramArrayOfInt));
  }
  
  public void updateData()
  {
    NoteWidgetManager.getInstance().loadNoteList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.notelist.NoteWidgetProvider
 * JD-Core Version:    0.7.0.1
 */