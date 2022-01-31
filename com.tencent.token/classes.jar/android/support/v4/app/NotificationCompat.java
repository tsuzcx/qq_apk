package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;

public class NotificationCompat
{
  public static final int BADGE_ICON_LARGE = 2;
  public static final int BADGE_ICON_NONE = 0;
  public static final int BADGE_ICON_SMALL = 1;
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_REMINDER = "reminder";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  @ColorInt
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_MESSAGES = "android.messages";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  public static final int GROUP_ALERT_ALL = 0;
  public static final int GROUP_ALERT_CHILDREN = 2;
  public static final int GROUP_ALERT_SUMMARY = 1;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;
  
  public static NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    Object localObject = null;
    Notification.Action localAction = null;
    if (Build.VERSION.SDK_INT >= 20) {
      localObject = getActionCompatFromAction(paramNotification.actions[paramInt]);
    }
    do
    {
      return localObject;
      if (Build.VERSION.SDK_INT >= 19)
      {
        localAction = paramNotification.actions[paramInt];
        SparseArray localSparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
        paramNotification = (Notification)localObject;
        if (localSparseArray != null) {
          paramNotification = (Bundle)localSparseArray.get(paramInt);
        }
        return NotificationCompatJellybean.readAction(localAction.icon, localAction.title, localAction.actionIntent, paramNotification);
      }
      localObject = localAction;
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getAction(paramNotification, paramInt);
  }
  
  @RequiresApi(20)
  static NotificationCompat.Action getActionCompatFromAction(Notification.Action paramAction)
  {
    boolean bool = false;
    android.app.RemoteInput[] arrayOfRemoteInput1 = paramAction.getRemoteInputs();
    RemoteInput[] arrayOfRemoteInput;
    if (arrayOfRemoteInput1 == null) {
      arrayOfRemoteInput = null;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        if ((!paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies")) && (!paramAction.getAllowGeneratedReplies())) {}
      }
      for (bool = true;; bool = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies"))
      {
        return new NotificationCompat.Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool);
        arrayOfRemoteInput = new RemoteInput[arrayOfRemoteInput1.length];
        int i = 0;
        while (i < arrayOfRemoteInput1.length)
        {
          android.app.RemoteInput localRemoteInput = arrayOfRemoteInput1[i];
          arrayOfRemoteInput[i] = new RemoteInput(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras(), null);
          i += 1;
        }
      }
    }
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramNotification.actions != null) {
        i = paramNotification.actions.length;
      }
    }
    while (Build.VERSION.SDK_INT < 16) {
      return i;
    }
    return NotificationCompatJellybean.getActionCount(paramNotification);
  }
  
  public static int getBadgeIconType(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getBadgeIconType();
    }
    return 0;
  }
  
  public static String getCategory(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramNotification.category;
    }
    return null;
  }
  
  public static String getChannelId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getChannelId();
    }
    return null;
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification);
    }
    return null;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getGroup();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.groupKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey");
    }
    return null;
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getGroupAlertBehavior();
    }
    return 0;
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 20) {
      if ((paramNotification.flags & 0x100) != 0) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        return paramNotification.extras.getBoolean("android.support.localOnly");
      }
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly");
  }
  
  static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Notification[])) || (arrayOfParcelable == null)) {
      return (Notification[])arrayOfParcelable;
    }
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    int i = 0;
    while (i < arrayOfParcelable.length)
    {
      arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
      i += 1;
    }
    paramBundle.putParcelableArray(paramString, arrayOfNotification);
    return arrayOfNotification;
  }
  
  public static String getShortcutId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getShortcutId();
    }
    return null;
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getSortKey();
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras.getString("android.support.sortKey");
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey");
    }
    return null;
  }
  
  public static long getTimeoutAfter(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getTimeoutAfter();
    }
    return 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 20) {
      if ((paramNotification.flags & 0x200) != 0) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        return paramNotification.extras.getBoolean("android.support.isGroupSummary");
      }
    } while (Build.VERSION.SDK_INT < 16);
    return NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.7.0.1
 */