package android.support.v4.app;

class NotificationManagerCompat$CancelTask
  implements NotificationManagerCompat.Task
{
  final boolean all;
  final int id;
  final String packageName;
  final String tag;
  
  NotificationManagerCompat$CancelTask(String paramString)
  {
    this.packageName = paramString;
    this.id = 0;
    this.tag = null;
    this.all = true;
  }
  
  NotificationManagerCompat$CancelTask(String paramString1, int paramInt, String paramString2)
  {
    this.packageName = paramString1;
    this.id = paramInt;
    this.tag = paramString2;
    this.all = false;
  }
  
  public void send(INotificationSideChannel paramINotificationSideChannel)
  {
    if (this.all)
    {
      paramINotificationSideChannel.cancelAll(this.packageName);
      return;
    }
    paramINotificationSideChannel.cancel(this.packageName, this.id, this.tag);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
    localStringBuilder.append("packageName:").append(this.packageName);
    localStringBuilder.append(", id:").append(this.id);
    localStringBuilder.append(", tag:").append(this.tag);
    localStringBuilder.append(", all:").append(this.all);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat.CancelTask
 * JD-Core Version:    0.7.0.1
 */