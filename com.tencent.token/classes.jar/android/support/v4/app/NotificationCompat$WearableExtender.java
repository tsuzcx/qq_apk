package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class NotificationCompat$WearableExtender
  implements NotificationCompat.Extender
{
  private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
  private static final int DEFAULT_FLAGS = 1;
  private static final int DEFAULT_GRAVITY = 80;
  private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
  private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
  private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
  private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
  private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
  private static final int FLAG_HINT_HIDE_ICON = 2;
  private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
  private static final int FLAG_START_SCROLL_BOTTOM = 8;
  private static final String KEY_ACTIONS = "actions";
  private static final String KEY_BACKGROUND = "background";
  private static final String KEY_BRIDGE_TAG = "bridgeTag";
  private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
  private static final String KEY_CONTENT_ICON = "contentIcon";
  private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
  private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
  private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
  private static final String KEY_DISMISSAL_ID = "dismissalId";
  private static final String KEY_DISPLAY_INTENT = "displayIntent";
  private static final String KEY_FLAGS = "flags";
  private static final String KEY_GRAVITY = "gravity";
  private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
  private static final String KEY_PAGES = "pages";
  public static final int SCREEN_TIMEOUT_LONG = -1;
  public static final int SCREEN_TIMEOUT_SHORT = 0;
  public static final int SIZE_DEFAULT = 0;
  public static final int SIZE_FULL_SCREEN = 5;
  public static final int SIZE_LARGE = 4;
  public static final int SIZE_MEDIUM = 3;
  public static final int SIZE_SMALL = 2;
  public static final int SIZE_XSMALL = 1;
  public static final int UNSET_ACTION_INDEX = -1;
  private ArrayList mActions = new ArrayList();
  private Bitmap mBackground;
  private String mBridgeTag;
  private int mContentActionIndex = -1;
  private int mContentIcon;
  private int mContentIconGravity = 8388613;
  private int mCustomContentHeight;
  private int mCustomSizePreset = 0;
  private String mDismissalId;
  private PendingIntent mDisplayIntent;
  private int mFlags = 1;
  private int mGravity = 80;
  private int mHintScreenTimeout;
  private ArrayList mPages = new ArrayList();
  
  public NotificationCompat$WearableExtender() {}
  
  public NotificationCompat$WearableExtender(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    NotificationCompat.Action[] arrayOfAction;
    int i;
    if (paramNotification != null)
    {
      paramNotification = paramNotification.getBundle("android.wearable.EXTENSIONS");
      if (paramNotification == null) {
        return;
      }
      localObject = paramNotification.getParcelableArrayList("actions");
      if ((Build.VERSION.SDK_INT < 16) || (localObject == null)) {
        break label184;
      }
      arrayOfAction = new NotificationCompat.Action[((ArrayList)localObject).size()];
      i = 0;
      label103:
      if (i >= arrayOfAction.length) {
        break label171;
      }
      if (Build.VERSION.SDK_INT < 20) {
        break label145;
      }
      arrayOfAction[i] = NotificationCompat.getActionCompatFromAction((Notification.Action)((ArrayList)localObject).get(i));
    }
    for (;;)
    {
      i += 1;
      break label103;
      paramNotification = null;
      break;
      label145:
      if (Build.VERSION.SDK_INT >= 16) {
        arrayOfAction[i] = NotificationCompatJellybean.getActionFromBundle((Bundle)((ArrayList)localObject).get(i));
      }
    }
    label171:
    Collections.addAll(this.mActions, (NotificationCompat.Action[])arrayOfAction);
    label184:
    this.mFlags = paramNotification.getInt("flags", 1);
    this.mDisplayIntent = ((PendingIntent)paramNotification.getParcelable("displayIntent"));
    Object localObject = NotificationCompat.getNotificationArrayFromBundle(paramNotification, "pages");
    if (localObject != null) {
      Collections.addAll(this.mPages, (Object[])localObject);
    }
    this.mBackground = ((Bitmap)paramNotification.getParcelable("background"));
    this.mContentIcon = paramNotification.getInt("contentIcon");
    this.mContentIconGravity = paramNotification.getInt("contentIconGravity", 8388613);
    this.mContentActionIndex = paramNotification.getInt("contentActionIndex", -1);
    this.mCustomSizePreset = paramNotification.getInt("customSizePreset", 0);
    this.mCustomContentHeight = paramNotification.getInt("customContentHeight");
    this.mGravity = paramNotification.getInt("gravity", 80);
    this.mHintScreenTimeout = paramNotification.getInt("hintScreenTimeout");
    this.mDismissalId = paramNotification.getString("dismissalId");
    this.mBridgeTag = paramNotification.getString("bridgeTag");
  }
  
  @RequiresApi(20)
  private static Notification.Action getActionFromActionCompat(NotificationCompat.Action paramAction)
  {
    Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    if (paramAction.getExtras() != null) {}
    for (Bundle localBundle = new Bundle(paramAction.getExtras());; localBundle = new Bundle())
    {
      localBundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
      }
      localBuilder.addExtras(localBundle);
      paramAction = paramAction.getRemoteInputs();
      if (paramAction == null) {
        break;
      }
      paramAction = RemoteInput.fromCompat(paramAction);
      int j = paramAction.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.addRemoteInput(paramAction[i]);
        i += 1;
      }
    }
    return localBuilder.build();
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags |= paramInt;
      return;
    }
    this.mFlags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public WearableExtender addAction(NotificationCompat.Action paramAction)
  {
    this.mActions.add(paramAction);
    return this;
  }
  
  public WearableExtender addActions(List paramList)
  {
    this.mActions.addAll(paramList);
    return this;
  }
  
  public WearableExtender addPage(Notification paramNotification)
  {
    this.mPages.add(paramNotification);
    return this;
  }
  
  public WearableExtender addPages(List paramList)
  {
    this.mPages.addAll(paramList);
    return this;
  }
  
  public WearableExtender clearActions()
  {
    this.mActions.clear();
    return this;
  }
  
  public WearableExtender clearPages()
  {
    this.mPages.clear();
    return this;
  }
  
  public WearableExtender clone()
  {
    WearableExtender localWearableExtender = new WearableExtender();
    localWearableExtender.mActions = new ArrayList(this.mActions);
    localWearableExtender.mFlags = this.mFlags;
    localWearableExtender.mDisplayIntent = this.mDisplayIntent;
    localWearableExtender.mPages = new ArrayList(this.mPages);
    localWearableExtender.mBackground = this.mBackground;
    localWearableExtender.mContentIcon = this.mContentIcon;
    localWearableExtender.mContentIconGravity = this.mContentIconGravity;
    localWearableExtender.mContentActionIndex = this.mContentActionIndex;
    localWearableExtender.mCustomSizePreset = this.mCustomSizePreset;
    localWearableExtender.mCustomContentHeight = this.mCustomContentHeight;
    localWearableExtender.mGravity = this.mGravity;
    localWearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
    localWearableExtender.mDismissalId = this.mDismissalId;
    localWearableExtender.mBridgeTag = this.mBridgeTag;
    return localWearableExtender;
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    Bundle localBundle = new Bundle();
    if (!this.mActions.isEmpty())
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label379;
      }
      ArrayList localArrayList = new ArrayList(this.mActions.size());
      Iterator localIterator = this.mActions.iterator();
      while (localIterator.hasNext())
      {
        NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
        if (Build.VERSION.SDK_INT >= 20) {
          localArrayList.add(getActionFromActionCompat(localAction));
        } else if (Build.VERSION.SDK_INT >= 16) {
          localArrayList.add(NotificationCompatJellybean.getBundleForAction(localAction));
        }
      }
      localBundle.putParcelableArrayList("actions", localArrayList);
    }
    for (;;)
    {
      if (this.mFlags != 1) {
        localBundle.putInt("flags", this.mFlags);
      }
      if (this.mDisplayIntent != null) {
        localBundle.putParcelable("displayIntent", this.mDisplayIntent);
      }
      if (!this.mPages.isEmpty()) {
        localBundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
      }
      if (this.mBackground != null) {
        localBundle.putParcelable("background", this.mBackground);
      }
      if (this.mContentIcon != 0) {
        localBundle.putInt("contentIcon", this.mContentIcon);
      }
      if (this.mContentIconGravity != 8388613) {
        localBundle.putInt("contentIconGravity", this.mContentIconGravity);
      }
      if (this.mContentActionIndex != -1) {
        localBundle.putInt("contentActionIndex", this.mContentActionIndex);
      }
      if (this.mCustomSizePreset != 0) {
        localBundle.putInt("customSizePreset", this.mCustomSizePreset);
      }
      if (this.mCustomContentHeight != 0) {
        localBundle.putInt("customContentHeight", this.mCustomContentHeight);
      }
      if (this.mGravity != 80) {
        localBundle.putInt("gravity", this.mGravity);
      }
      if (this.mHintScreenTimeout != 0) {
        localBundle.putInt("hintScreenTimeout", this.mHintScreenTimeout);
      }
      if (this.mDismissalId != null) {
        localBundle.putString("dismissalId", this.mDismissalId);
      }
      if (this.mBridgeTag != null) {
        localBundle.putString("bridgeTag", this.mBridgeTag);
      }
      paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
      return paramBuilder;
      label379:
      localBundle.putParcelableArrayList("actions", null);
    }
  }
  
  public List getActions()
  {
    return this.mActions;
  }
  
  public Bitmap getBackground()
  {
    return this.mBackground;
  }
  
  public String getBridgeTag()
  {
    return this.mBridgeTag;
  }
  
  public int getContentAction()
  {
    return this.mContentActionIndex;
  }
  
  public int getContentIcon()
  {
    return this.mContentIcon;
  }
  
  public int getContentIconGravity()
  {
    return this.mContentIconGravity;
  }
  
  public boolean getContentIntentAvailableOffline()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  public int getCustomContentHeight()
  {
    return this.mCustomContentHeight;
  }
  
  public int getCustomSizePreset()
  {
    return this.mCustomSizePreset;
  }
  
  public String getDismissalId()
  {
    return this.mDismissalId;
  }
  
  public PendingIntent getDisplayIntent()
  {
    return this.mDisplayIntent;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  public boolean getHintAmbientBigPicture()
  {
    return (this.mFlags & 0x20) != 0;
  }
  
  public boolean getHintAvoidBackgroundClipping()
  {
    return (this.mFlags & 0x10) != 0;
  }
  
  public boolean getHintContentIntentLaunchesActivity()
  {
    return (this.mFlags & 0x40) != 0;
  }
  
  public boolean getHintHideIcon()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  public int getHintScreenTimeout()
  {
    return this.mHintScreenTimeout;
  }
  
  public boolean getHintShowBackgroundOnly()
  {
    return (this.mFlags & 0x4) != 0;
  }
  
  public List getPages()
  {
    return this.mPages;
  }
  
  public boolean getStartScrollBottom()
  {
    return (this.mFlags & 0x8) != 0;
  }
  
  public WearableExtender setBackground(Bitmap paramBitmap)
  {
    this.mBackground = paramBitmap;
    return this;
  }
  
  public WearableExtender setBridgeTag(String paramString)
  {
    this.mBridgeTag = paramString;
    return this;
  }
  
  public WearableExtender setContentAction(int paramInt)
  {
    this.mContentActionIndex = paramInt;
    return this;
  }
  
  public WearableExtender setContentIcon(int paramInt)
  {
    this.mContentIcon = paramInt;
    return this;
  }
  
  public WearableExtender setContentIconGravity(int paramInt)
  {
    this.mContentIconGravity = paramInt;
    return this;
  }
  
  public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
  {
    setFlag(1, paramBoolean);
    return this;
  }
  
  public WearableExtender setCustomContentHeight(int paramInt)
  {
    this.mCustomContentHeight = paramInt;
    return this;
  }
  
  public WearableExtender setCustomSizePreset(int paramInt)
  {
    this.mCustomSizePreset = paramInt;
    return this;
  }
  
  public WearableExtender setDismissalId(String paramString)
  {
    this.mDismissalId = paramString;
    return this;
  }
  
  public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
  {
    this.mDisplayIntent = paramPendingIntent;
    return this;
  }
  
  public WearableExtender setGravity(int paramInt)
  {
    this.mGravity = paramInt;
    return this;
  }
  
  public WearableExtender setHintAmbientBigPicture(boolean paramBoolean)
  {
    setFlag(32, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean)
  {
    setFlag(64, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintHideIcon(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintScreenTimeout(int paramInt)
  {
    this.mHintScreenTimeout = paramInt;
    return this;
  }
  
  public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
  {
    setFlag(4, paramBoolean);
    return this;
  }
  
  public WearableExtender setStartScrollBottom(boolean paramBoolean)
  {
    setFlag(8, paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.WearableExtender
 * JD-Core Version:    0.7.0.1
 */