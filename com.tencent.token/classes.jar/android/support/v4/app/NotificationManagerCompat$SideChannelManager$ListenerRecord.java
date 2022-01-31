package android.support.v4.app;

import android.content.ComponentName;
import java.util.ArrayDeque;

class NotificationManagerCompat$SideChannelManager$ListenerRecord
{
  boolean bound = false;
  final ComponentName componentName;
  int retryCount = 0;
  INotificationSideChannel service;
  ArrayDeque taskQueue = new ArrayDeque();
  
  NotificationManagerCompat$SideChannelManager$ListenerRecord(ComponentName paramComponentName)
  {
    this.componentName = paramComponentName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat.SideChannelManager.ListenerRecord
 * JD-Core Version:    0.7.0.1
 */