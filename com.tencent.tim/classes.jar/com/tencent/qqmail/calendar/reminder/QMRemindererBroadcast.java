package com.tencent.qqmail.calendar.reminder;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class QMRemindererBroadcast
  extends BroadcastReceiver
{
  public static Queue<Integer> calendarRemindIdQueue;
  public static Queue<String> calendarSubjectQueue;
  public static ArrayList<Integer> myCalendarPushNotifyList = new ArrayList();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = SafeIntent.createSafeIntet(paramIntent);
    if (localObject1 != null)
    {
      paramIntent = ((Intent)localObject1).getAction();
      QMLog.log(4, "QMReminder", "QMCalendarAlarmBroadCast#onReceive: " + paramIntent);
      if (!QMReminderer.Action.SENTINEL.toString().equals(paramIntent)) {
        break label59;
      }
      QMReminderer.assignReminderMissions();
    }
    label59:
    do
    {
      return;
      if (QMReminderer.Action.EVENT.toString().equals(paramIntent))
      {
        paramIntent = QMNotificationConstructor.getInstance();
        ArrayList localArrayList = ((Intent)localObject1).getIntegerArrayListExtra("ids");
        localObject1 = ((Intent)localObject1).getStringArrayListExtra("names");
        int i;
        int j;
        if ((localArrayList != null) && (localObject1 != null) && (localArrayList.size() == ((ArrayList)localObject1).size()))
        {
          int k = localArrayList.size();
          i = 0;
          j = 0;
          if (j < k)
          {
            if (QMCalendarManager.getInstance().getScheduleByReminderId(((Integer)localArrayList.get(i)).intValue()) == null)
            {
              localArrayList.remove(i);
              ((ArrayList)localObject1).remove(i);
            }
            for (;;)
            {
              j += 1;
              break;
              i += 1;
            }
          }
        }
        if ((localArrayList != null) && (localObject1 != null) && (localArrayList.size() == ((ArrayList)localObject1).size())) {
          i = 0;
        }
        for (;;)
        {
          if (i < localArrayList.size())
          {
            if (AppStatusUtil.isAppOnForeground()) {
              QMWatcherCenter.triggerCalendarNotifyWatcher(localArrayList.size(), localArrayList, (ArrayList)localObject1);
            }
          }
          else
          {
            QMReminderer.assignReminderMissions();
            return;
          }
          Object localObject2 = localArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            j = ((Integer)((Iterator)localObject2).next()).intValue();
            myCalendarPushNotifyList.add(Integer.valueOf(j));
          }
          localObject2 = LaunchWebPush.createCalendarReminderIntent(((Integer)localArrayList.get(i)).intValue());
          localObject2 = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), ((Integer)localArrayList.get(i)).intValue(), (Intent)localObject2, 134217728);
          paramIntent.notifyCalendarReminder(((Integer)localArrayList.get(i)).intValue(), paramContext.getString(2131691102), (String)((ArrayList)localObject1).get(i), null, (PendingIntent)localObject2);
          i += 1;
        }
      }
    } while (QMReminderer.Action.TICK.toString().equals(paramIntent));
    Log.d("QMReminder", "Unknown Action: " + paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.reminder.QMRemindererBroadcast
 * JD-Core Version:    0.7.0.1
 */