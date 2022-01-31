package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public class NotificationCompat$Action
{
  public PendingIntent actionIntent;
  public int icon;
  private boolean mAllowGeneratedReplies;
  private final RemoteInput[] mDataOnlyRemoteInputs;
  final Bundle mExtras;
  private final RemoteInput[] mRemoteInputs;
  public CharSequence title;
  
  public NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true);
  }
  
  NotificationCompat$Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean)
  {
    this.icon = paramInt;
    this.title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.actionIntent = paramPendingIntent;
    if (paramBundle != null) {}
    for (;;)
    {
      this.mExtras = paramBundle;
      this.mRemoteInputs = paramArrayOfRemoteInput1;
      this.mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
      this.mAllowGeneratedReplies = paramBoolean;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public PendingIntent getActionIntent()
  {
    return this.actionIntent;
  }
  
  public boolean getAllowGeneratedReplies()
  {
    return this.mAllowGeneratedReplies;
  }
  
  public RemoteInput[] getDataOnlyRemoteInputs()
  {
    return this.mDataOnlyRemoteInputs;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public int getIcon()
  {
    return this.icon;
  }
  
  public RemoteInput[] getRemoteInputs()
  {
    return this.mRemoteInputs;
  }
  
  public CharSequence getTitle()
  {
    return this.title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action
 * JD-Core Version:    0.7.0.1
 */