package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
  private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ArrayList mActions = new ArrayList();
  int mBadgeIcon = 0;
  RemoteViews mBigContentView;
  String mCategory;
  String mChannelId;
  int mColor = 0;
  boolean mColorized;
  boolean mColorizedSet;
  CharSequence mContentInfo;
  PendingIntent mContentIntent;
  CharSequence mContentText;
  CharSequence mContentTitle;
  RemoteViews mContentView;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public Context mContext;
  Bundle mExtras;
  PendingIntent mFullScreenIntent;
  int mGroupAlertBehavior = 0;
  String mGroupKey;
  boolean mGroupSummary;
  RemoteViews mHeadsUpContentView;
  Bitmap mLargeIcon;
  boolean mLocalOnly = false;
  Notification mNotification = new Notification();
  int mNumber;
  @Deprecated
  public ArrayList mPeople;
  int mPriority;
  int mProgress;
  boolean mProgressIndeterminate;
  int mProgressMax;
  Notification mPublicVersion;
  CharSequence[] mRemoteInputHistory;
  String mShortcutId;
  boolean mShowWhen = true;
  String mSortKey;
  NotificationCompat.Style mStyle;
  CharSequence mSubText;
  RemoteViews mTickerView;
  long mTimeout;
  boolean mUseChronometer;
  int mVisibility = 0;
  
  @Deprecated
  public NotificationCompat$Builder(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NotificationCompat$Builder(@NonNull Context paramContext, @NonNull String paramString)
  {
    this.mContext = paramContext;
    this.mChannelId = paramString;
    this.mNotification.when = System.currentTimeMillis();
    this.mNotification.audioStreamType = -1;
    this.mPriority = 0;
    this.mPeople = new ArrayList();
  }
  
  protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() <= 5120) {
      return paramCharSequence;
    }
    return paramCharSequence.subSequence(0, 5120);
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localNotification = this.mNotification;
      localNotification.flags |= paramInt;
      return;
    }
    Notification localNotification = this.mNotification;
    localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public Builder addAction(NotificationCompat.Action paramAction)
  {
    this.mActions.add(paramAction);
    return this;
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.mExtras == null) {
        this.mExtras = new Bundle(paramBundle);
      }
    }
    else {
      return this;
    }
    this.mExtras.putAll(paramBundle);
    return this;
  }
  
  public Builder addPerson(String paramString)
  {
    this.mPeople.add(paramString);
    return this;
  }
  
  public Notification build()
  {
    return new NotificationCompatBuilder(this).build();
  }
  
  public Builder extend(NotificationCompat.Extender paramExtender)
  {
    paramExtender.extend(this);
    return this;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews getBigContentView()
  {
    return this.mBigContentView;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getColor()
  {
    return this.mColor;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews getContentView()
  {
    return this.mContentView;
  }
  
  public Bundle getExtras()
  {
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    return this.mExtras;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews getHeadsUpContentView()
  {
    return this.mHeadsUpContentView;
  }
  
  @Deprecated
  public Notification getNotification()
  {
    return build();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getPriority()
  {
    return this.mPriority;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public long getWhenIfShowing()
  {
    if (this.mShowWhen) {
      return this.mNotification.when;
    }
    return 0L;
  }
  
  public Builder setAutoCancel(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public Builder setBadgeIconType(int paramInt)
  {
    this.mBadgeIcon = paramInt;
    return this;
  }
  
  public Builder setCategory(String paramString)
  {
    this.mCategory = paramString;
    return this;
  }
  
  public Builder setChannelId(@NonNull String paramString)
  {
    this.mChannelId = paramString;
    return this;
  }
  
  public Builder setColor(@ColorInt int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public Builder setColorized(boolean paramBoolean)
  {
    this.mColorized = paramBoolean;
    this.mColorizedSet = true;
    return this;
  }
  
  public Builder setContent(RemoteViews paramRemoteViews)
  {
    this.mNotification.contentView = paramRemoteViews;
    return this;
  }
  
  public Builder setContentInfo(CharSequence paramCharSequence)
  {
    this.mContentInfo = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.mContentIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setContentText(CharSequence paramCharSequence)
  {
    this.mContentText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setContentTitle(CharSequence paramCharSequence)
  {
    this.mContentTitle = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setCustomBigContentView(RemoteViews paramRemoteViews)
  {
    this.mBigContentView = paramRemoteViews;
    return this;
  }
  
  public Builder setCustomContentView(RemoteViews paramRemoteViews)
  {
    this.mContentView = paramRemoteViews;
    return this;
  }
  
  public Builder setCustomHeadsUpContentView(RemoteViews paramRemoteViews)
  {
    this.mHeadsUpContentView = paramRemoteViews;
    return this;
  }
  
  public Builder setDefaults(int paramInt)
  {
    this.mNotification.defaults = paramInt;
    if ((paramInt & 0x4) != 0)
    {
      Notification localNotification = this.mNotification;
      localNotification.flags |= 0x1;
    }
    return this;
  }
  
  public Builder setDeleteIntent(PendingIntent paramPendingIntent)
  {
    this.mNotification.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setExtras(Bundle paramBundle)
  {
    this.mExtras = paramBundle;
    return this;
  }
  
  public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    this.mFullScreenIntent = paramPendingIntent;
    setFlag(128, paramBoolean);
    return this;
  }
  
  public Builder setGroup(String paramString)
  {
    this.mGroupKey = paramString;
    return this;
  }
  
  public Builder setGroupAlertBehavior(int paramInt)
  {
    this.mGroupAlertBehavior = paramInt;
    return this;
  }
  
  public Builder setGroupSummary(boolean paramBoolean)
  {
    this.mGroupSummary = paramBoolean;
    return this;
  }
  
  public Builder setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  public Builder setLights(@ColorInt int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    this.mNotification.ledARGB = paramInt1;
    this.mNotification.ledOnMS = paramInt2;
    this.mNotification.ledOffMS = paramInt3;
    Notification localNotification;
    if ((this.mNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0))
    {
      paramInt1 = 1;
      localNotification = this.mNotification;
      paramInt2 = this.mNotification.flags;
      if (paramInt1 == 0) {
        break label88;
      }
    }
    label88:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localNotification.flags = (paramInt2 & 0xFFFFFFFE | paramInt1);
      return this;
      paramInt1 = 0;
      break;
    }
  }
  
  public Builder setLocalOnly(boolean paramBoolean)
  {
    this.mLocalOnly = paramBoolean;
    return this;
  }
  
  public Builder setNumber(int paramInt)
  {
    this.mNumber = paramInt;
    return this;
  }
  
  public Builder setOngoing(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  public Builder setOnlyAlertOnce(boolean paramBoolean)
  {
    setFlag(8, paramBoolean);
    return this;
  }
  
  public Builder setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
  
  public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mProgressMax = paramInt1;
    this.mProgress = paramInt2;
    this.mProgressIndeterminate = paramBoolean;
    return this;
  }
  
  public Builder setPublicVersion(Notification paramNotification)
  {
    this.mPublicVersion = paramNotification;
    return this;
  }
  
  public Builder setRemoteInputHistory(CharSequence[] paramArrayOfCharSequence)
  {
    this.mRemoteInputHistory = paramArrayOfCharSequence;
    return this;
  }
  
  public Builder setShortcutId(String paramString)
  {
    this.mShortcutId = paramString;
    return this;
  }
  
  public Builder setShowWhen(boolean paramBoolean)
  {
    this.mShowWhen = paramBoolean;
    return this;
  }
  
  public Builder setSmallIcon(int paramInt)
  {
    this.mNotification.icon = paramInt;
    return this;
  }
  
  public Builder setSmallIcon(int paramInt1, int paramInt2)
  {
    this.mNotification.icon = paramInt1;
    this.mNotification.iconLevel = paramInt2;
    return this;
  }
  
  public Builder setSortKey(String paramString)
  {
    this.mSortKey = paramString;
    return this;
  }
  
  public Builder setSound(Uri paramUri)
  {
    this.mNotification.sound = paramUri;
    this.mNotification.audioStreamType = -1;
    if (Build.VERSION.SDK_INT >= 21) {
      this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    }
    return this;
  }
  
  public Builder setSound(Uri paramUri, int paramInt)
  {
    this.mNotification.sound = paramUri;
    this.mNotification.audioStreamType = paramInt;
    if (Build.VERSION.SDK_INT >= 21) {
      this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(paramInt).build();
    }
    return this;
  }
  
  public Builder setStyle(NotificationCompat.Style paramStyle)
  {
    if (this.mStyle != paramStyle)
    {
      this.mStyle = paramStyle;
      if (this.mStyle != null) {
        this.mStyle.setBuilder(this);
      }
    }
    return this;
  }
  
  public Builder setSubText(CharSequence paramCharSequence)
  {
    this.mSubText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence)
  {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
  {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    this.mTickerView = paramRemoteViews;
    return this;
  }
  
  public Builder setTimeoutAfter(long paramLong)
  {
    this.mTimeout = paramLong;
    return this;
  }
  
  public Builder setUsesChronometer(boolean paramBoolean)
  {
    this.mUseChronometer = paramBoolean;
    return this;
  }
  
  public Builder setVibrate(long[] paramArrayOfLong)
  {
    this.mNotification.vibrate = paramArrayOfLong;
    return this;
  }
  
  public Builder setVisibility(int paramInt)
  {
    this.mVisibility = paramInt;
    return this;
  }
  
  public Builder setWhen(long paramLong)
  {
    this.mNotification.when = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Builder
 * JD-Core Version:    0.7.0.1
 */