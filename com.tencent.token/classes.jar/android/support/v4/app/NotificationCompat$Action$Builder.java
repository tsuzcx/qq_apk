package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class NotificationCompat$Action$Builder
{
  private boolean mAllowGeneratedReplies = true;
  private final Bundle mExtras;
  private final int mIcon;
  private final PendingIntent mIntent;
  private ArrayList mRemoteInputs;
  private final CharSequence mTitle;
  
  public NotificationCompat$Action$Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, true);
  }
  
  private NotificationCompat$Action$Builder(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean)
  {
    this.mIcon = paramInt;
    this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
    this.mIntent = paramPendingIntent;
    this.mExtras = paramBundle;
    if (paramArrayOfRemoteInput == null) {}
    for (paramCharSequence = null;; paramCharSequence = new ArrayList(Arrays.asList(paramArrayOfRemoteInput)))
    {
      this.mRemoteInputs = paramCharSequence;
      this.mAllowGeneratedReplies = paramBoolean;
      return;
    }
  }
  
  public NotificationCompat$Action$Builder(NotificationCompat.Action paramAction)
  {
    this(paramAction.icon, paramAction.title, paramAction.actionIntent, new Bundle(paramAction.mExtras), paramAction.getRemoteInputs(), paramAction.getAllowGeneratedReplies());
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mExtras.putAll(paramBundle);
    }
    return this;
  }
  
  public Builder addRemoteInput(RemoteInput paramRemoteInput)
  {
    if (this.mRemoteInputs == null) {
      this.mRemoteInputs = new ArrayList();
    }
    this.mRemoteInputs.add(paramRemoteInput);
    return this;
  }
  
  public NotificationCompat.Action build()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (this.mRemoteInputs != null)
    {
      Iterator localIterator = this.mRemoteInputs.iterator();
      while (localIterator.hasNext())
      {
        RemoteInput localRemoteInput = (RemoteInput)localIterator.next();
        if (localRemoteInput.isDataOnly()) {
          ((List)localObject1).add(localRemoteInput);
        } else {
          ((List)localObject2).add(localRemoteInput);
        }
      }
    }
    if (((List)localObject1).isEmpty())
    {
      localObject1 = null;
      if (!((List)localObject2).isEmpty()) {
        break label157;
      }
    }
    label157:
    for (localObject2 = null;; localObject2 = (RemoteInput[])((List)localObject2).toArray(new RemoteInput[((List)localObject2).size()]))
    {
      return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, (RemoteInput[])localObject2, (RemoteInput[])localObject1, this.mAllowGeneratedReplies);
      localObject1 = (RemoteInput[])((List)localObject1).toArray(new RemoteInput[((List)localObject1).size()]);
      break;
    }
  }
  
  public Builder extend(NotificationCompat.Action.Extender paramExtender)
  {
    paramExtender.extend(this);
    return this;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public Builder setAllowGeneratedReplies(boolean paramBoolean)
  {
    this.mAllowGeneratedReplies = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Action.Builder
 * JD-Core Version:    0.7.0.1
 */