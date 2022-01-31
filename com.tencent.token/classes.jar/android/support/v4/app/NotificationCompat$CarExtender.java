package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

public final class NotificationCompat$CarExtender
  implements NotificationCompat.Extender
{
  private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
  private static final String EXTRA_COLOR = "app_color";
  private static final String EXTRA_CONVERSATION = "car_conversation";
  private static final String EXTRA_LARGE_ICON = "large_icon";
  private static final String KEY_AUTHOR = "author";
  private static final String KEY_MESSAGES = "messages";
  private static final String KEY_ON_READ = "on_read";
  private static final String KEY_ON_REPLY = "on_reply";
  private static final String KEY_PARTICIPANTS = "participants";
  private static final String KEY_REMOTE_INPUT = "remote_input";
  private static final String KEY_TEXT = "text";
  private static final String KEY_TIMESTAMP = "timestamp";
  private int mColor = 0;
  private Bitmap mLargeIcon;
  private NotificationCompat.CarExtender.UnreadConversation mUnreadConversation;
  
  public NotificationCompat$CarExtender() {}
  
  public NotificationCompat$CarExtender(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      if (NotificationCompat.getExtras(paramNotification) == null) {}
      for (paramNotification = null; paramNotification != null; paramNotification = NotificationCompat.getExtras(paramNotification).getBundle("android.car.EXTENSIONS"))
      {
        this.mLargeIcon = ((Bitmap)paramNotification.getParcelable("large_icon"));
        this.mColor = paramNotification.getInt("app_color", 0);
        this.mUnreadConversation = getUnreadConversationFromBundle(paramNotification.getBundle("car_conversation"));
        return;
      }
    }
  }
  
  @RequiresApi(21)
  private static Bundle getBundleForUnreadConversation(@NonNull NotificationCompat.CarExtender.UnreadConversation paramUnreadConversation)
  {
    int i = 0;
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (paramUnreadConversation.getParticipants() != null)
    {
      localObject = arrayOfParcelable;
      if (paramUnreadConversation.getParticipants().length > 1) {
        localObject = paramUnreadConversation.getParticipants()[0];
      }
    }
    arrayOfParcelable = new Parcelable[paramUnreadConversation.getMessages().length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", paramUnreadConversation.getMessages()[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = paramUnreadConversation.getRemoteInput();
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((RemoteInput)localObject).getResultKey()).setLabel(((RemoteInput)localObject).getLabel()).setChoices(((RemoteInput)localObject).getChoices()).setAllowFreeFormInput(((RemoteInput)localObject).getAllowFreeFormInput()).addExtras(((RemoteInput)localObject).getExtras()).build());
    }
    localBundle1.putParcelable("on_reply", paramUnreadConversation.getReplyPendingIntent());
    localBundle1.putParcelable("on_read", paramUnreadConversation.getReadPendingIntent());
    localBundle1.putStringArray("participants", paramUnreadConversation.getParticipants());
    localBundle1.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
    return localBundle1;
  }
  
  @RequiresApi(21)
  private static NotificationCompat.CarExtender.UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle paramBundle)
  {
    int k = 0;
    if (paramBundle == null) {
      return null;
    }
    Object localObject = paramBundle.getParcelableArray("messages");
    String[] arrayOfString1;
    int i;
    int j;
    if (localObject != null)
    {
      arrayOfString1 = new String[localObject.length];
      i = 0;
      if (i < arrayOfString1.length) {
        if (!(localObject[i] instanceof Bundle))
        {
          j = k;
          label50:
          if (j == 0) {
            break label212;
          }
        }
      }
    }
    for (;;)
    {
      PendingIntent localPendingIntent1 = (PendingIntent)paramBundle.getParcelable("on_read");
      PendingIntent localPendingIntent2 = (PendingIntent)paramBundle.getParcelable("on_reply");
      localObject = (android.app.RemoteInput)paramBundle.getParcelable("remote_input");
      String[] arrayOfString2 = paramBundle.getStringArray("participants");
      if ((arrayOfString2 == null) || (arrayOfString2.length != 1)) {
        break;
      }
      if (localObject != null) {}
      for (localObject = new RemoteInput(((android.app.RemoteInput)localObject).getResultKey(), ((android.app.RemoteInput)localObject).getLabel(), ((android.app.RemoteInput)localObject).getChoices(), ((android.app.RemoteInput)localObject).getAllowFreeFormInput(), ((android.app.RemoteInput)localObject).getExtras(), null);; localObject = null)
      {
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString1, (RemoteInput)localObject, localPendingIntent2, localPendingIntent1, arrayOfString2, paramBundle.getLong("timestamp"));
        arrayOfString1[i] = ((Bundle)localObject[i]).getString("text");
        j = k;
        if (arrayOfString1[i] == null) {
          break label50;
        }
        i += 1;
        break;
      }
      j = 1;
      break label50;
      label212:
      break;
      arrayOfString1 = null;
    }
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramBuilder;
    }
    Bundle localBundle = new Bundle();
    if (this.mLargeIcon != null) {
      localBundle.putParcelable("large_icon", this.mLargeIcon);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.mUnreadConversation != null) {
      localBundle.putBundle("car_conversation", getBundleForUnreadConversation(this.mUnreadConversation));
    }
    paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    return paramBuilder;
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mColor;
  }
  
  public Bitmap getLargeIcon()
  {
    return this.mLargeIcon;
  }
  
  public NotificationCompat.CarExtender.UnreadConversation getUnreadConversation()
  {
    return this.mUnreadConversation;
  }
  
  public CarExtender setColor(@ColorInt int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public CarExtender setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  public CarExtender setUnreadConversation(NotificationCompat.CarExtender.UnreadConversation paramUnreadConversation)
  {
    this.mUnreadConversation = paramUnreadConversation;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.CarExtender
 * JD-Core Version:    0.7.0.1
 */