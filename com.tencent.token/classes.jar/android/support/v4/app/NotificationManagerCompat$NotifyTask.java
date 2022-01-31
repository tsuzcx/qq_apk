package android.support.v4.app;

import android.app.Notification;

class NotificationManagerCompat$NotifyTask
  implements NotificationManagerCompat.Task
{
  final int id;
  final Notification notif;
  final String packageName;
  final String tag;
  
  NotificationManagerCompat$NotifyTask(String paramString1, int paramInt, String paramString2, Notification paramNotification)
  {
    this.packageName = paramString1;
    this.id = paramInt;
    this.tag = paramString2;
    this.notif = paramNotification;
  }
  
  public void send(INotificationSideChannel paramINotificationSideChannel)
  {
    paramINotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
    localStringBuilder.append("packageName:").append(this.packageName);
    localStringBuilder.append(", id:").append(this.id);
    localStringBuilder.append(", tag:").append(this.tag);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat.NotifyTask
 * JD-Core Version:    0.7.0.1
 */