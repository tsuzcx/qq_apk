package com.tencent.qqmail.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.tencent.qqmail.widget.calendar.CalendarWidgetRemoteViewsFactory;
import com.tencent.qqmail.widget.inbox.InboxWidgetRemoteViewsFactory;
import com.tencent.qqmail.widget.notelist.NoteWidgetRemoteViewsFactory;

public class QMWidgetService
  extends RemoteViewsService
{
  private static final String FROM = "from";
  private static final String FROM_CALENDAR_WIDGET = "FROM_CALENDAR_WIDGET";
  private static final String FROM_INBOX_WIDGET = "FROM_INBOX_WIDGET";
  private static final String FROM_NOTE_LIST_WIDGET = "FROM_NOTE_LIST_WIDGET";
  public static final String SIZE = "SIZE";
  private static final String TAG = "QMWidgetService";
  
  public static Intent createIntentForCalendarWidget(Context paramContext, int paramInt)
  {
    paramContext = createIntentForWidget(paramContext, paramInt);
    paramContext.putExtra("from", "FROM_CALENDAR_WIDGET");
    return paramContext;
  }
  
  public static Intent createIntentForInboxWidget(Context paramContext, int paramInt)
  {
    paramContext = createIntentForWidget(paramContext, paramInt);
    paramContext.putExtra("from", "FROM_INBOX_WIDGET");
    paramContext.putExtra("SIZE", 4);
    return paramContext;
  }
  
  public static Intent createIntentForInboxWidget(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = createIntentForWidget(paramContext, paramInt1);
    paramContext.putExtra("from", "FROM_INBOX_WIDGET");
    paramContext.putExtra("SIZE", paramInt2);
    return paramContext;
  }
  
  public static Intent createIntentForNoteListWidget(Context paramContext, int paramInt)
  {
    paramContext = createIntentForWidget(paramContext, paramInt);
    paramContext.putExtra("from", "FROM_NOTE_LIST_WIDGET");
    return paramContext;
  }
  
  private static Intent createIntentForWidget(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, QMWidgetService.class);
    paramContext.putExtra("appWidgetId", paramInt);
    paramContext.setData(Uri.parse(paramContext.toUri(1)));
    return paramContext;
  }
  
  public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent)
  {
    Log.v("QMWidgetService", "onGetViewFactory");
    String str = paramIntent.getStringExtra("from");
    if (str.equals("FROM_CALENDAR_WIDGET")) {
      return new CalendarWidgetRemoteViewsFactory(getApplicationContext(), paramIntent);
    }
    if (str.equals("FROM_NOTE_LIST_WIDGET")) {
      return new NoteWidgetRemoteViewsFactory(getApplicationContext(), paramIntent);
    }
    if (str.equals("FROM_INBOX_WIDGET")) {
      return new InboxWidgetRemoteViewsFactory(getApplicationContext(), paramIntent);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.QMWidgetService
 * JD-Core Version:    0.7.0.1
 */