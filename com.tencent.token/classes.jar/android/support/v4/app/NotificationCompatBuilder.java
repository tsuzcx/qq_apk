package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class NotificationCompatBuilder
  implements NotificationBuilderWithBuilderAccessor
{
  private final List mActionExtrasList = new ArrayList();
  private RemoteViews mBigContentView;
  private final Notification.Builder mBuilder;
  private final NotificationCompat.Builder mBuilderCompat;
  private RemoteViews mContentView;
  private final Bundle mExtras = new Bundle();
  private int mGroupAlertBehavior;
  private RemoteViews mHeadsUpContentView;
  
  NotificationCompatBuilder(NotificationCompat.Builder paramBuilder)
  {
    this.mBuilderCompat = paramBuilder;
    Object localObject1;
    Object localObject2;
    label138:
    label158:
    label178:
    PendingIntent localPendingIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder = new Notification.Builder(paramBuilder.mContext, paramBuilder.mChannelId);
      localObject1 = paramBuilder.mNotification;
      localObject2 = this.mBuilder.setWhen(((Notification)localObject1).when).setSmallIcon(((Notification)localObject1).icon, ((Notification)localObject1).iconLevel).setContent(((Notification)localObject1).contentView).setTicker(((Notification)localObject1).tickerText, paramBuilder.mTickerView).setVibrate(((Notification)localObject1).vibrate).setLights(((Notification)localObject1).ledARGB, ((Notification)localObject1).ledOnMS, ((Notification)localObject1).ledOffMS);
      if ((((Notification)localObject1).flags & 0x2) == 0) {
        break label397;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
      if ((((Notification)localObject1).flags & 0x8) == 0) {
        break label402;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
      if ((((Notification)localObject1).flags & 0x10) == 0) {
        break label407;
      }
      bool = true;
      localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(((Notification)localObject1).defaults).setContentTitle(paramBuilder.mContentTitle).setContentText(paramBuilder.mContentText).setContentInfo(paramBuilder.mContentInfo).setContentIntent(paramBuilder.mContentIntent).setDeleteIntent(((Notification)localObject1).deleteIntent);
      localPendingIntent = paramBuilder.mFullScreenIntent;
      if ((((Notification)localObject1).flags & 0x80) == 0) {
        break label412;
      }
    }
    label397:
    label402:
    label407:
    label412:
    for (boolean bool = true;; bool = false)
    {
      ((Notification.Builder)localObject2).setFullScreenIntent(localPendingIntent, bool).setLargeIcon(paramBuilder.mLargeIcon).setNumber(paramBuilder.mNumber).setProgress(paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate);
      if (Build.VERSION.SDK_INT < 21) {
        this.mBuilder.setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioStreamType);
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label537;
      }
      this.mBuilder.setSubText(paramBuilder.mSubText).setUsesChronometer(paramBuilder.mUseChronometer).setPriority(paramBuilder.mPriority);
      localObject2 = paramBuilder.mActions.iterator();
      while (((Iterator)localObject2).hasNext()) {
        addAction((NotificationCompat.Action)((Iterator)localObject2).next());
      }
      this.mBuilder = new Notification.Builder(paramBuilder.mContext);
      break;
      bool = false;
      break label138;
      bool = false;
      break label158;
      bool = false;
      break label178;
    }
    if (paramBuilder.mExtras != null) {
      this.mExtras.putAll(paramBuilder.mExtras);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (paramBuilder.mLocalOnly) {
        this.mExtras.putBoolean("android.support.localOnly", true);
      }
      if (paramBuilder.mGroupKey != null)
      {
        this.mExtras.putString("android.support.groupKey", paramBuilder.mGroupKey);
        if (!paramBuilder.mGroupSummary) {
          break label754;
        }
        this.mExtras.putBoolean("android.support.isGroupSummary", true);
      }
    }
    for (;;)
    {
      if (paramBuilder.mSortKey != null) {
        this.mExtras.putString("android.support.sortKey", paramBuilder.mSortKey);
      }
      this.mContentView = paramBuilder.mContentView;
      this.mBigContentView = paramBuilder.mBigContentView;
      label537:
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mBuilder.setShowWhen(paramBuilder.mShowWhen);
        if ((Build.VERSION.SDK_INT < 21) && (paramBuilder.mPeople != null) && (!paramBuilder.mPeople.isEmpty())) {
          this.mExtras.putStringArray("android.people", (String[])paramBuilder.mPeople.toArray(new String[paramBuilder.mPeople.size()]));
        }
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.mBuilder.setLocalOnly(paramBuilder.mLocalOnly).setGroup(paramBuilder.mGroupKey).setGroupSummary(paramBuilder.mGroupSummary).setSortKey(paramBuilder.mSortKey);
        this.mGroupAlertBehavior = paramBuilder.mGroupAlertBehavior;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label776;
      }
      this.mBuilder.setCategory(paramBuilder.mCategory).setColor(paramBuilder.mColor).setVisibility(paramBuilder.mVisibility).setPublicVersion(paramBuilder.mPublicVersion).setSound(((Notification)localObject1).sound, ((Notification)localObject1).audioAttributes);
      localObject1 = paramBuilder.mPeople.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.mBuilder.addPerson((String)localObject2);
      }
      label754:
      this.mExtras.putBoolean("android.support.useSideChannel", true);
    }
    this.mHeadsUpContentView = paramBuilder.mHeadsUpContentView;
    label776:
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mBuilder.setExtras(paramBuilder.mExtras).setRemoteInputHistory(paramBuilder.mRemoteInputHistory);
      if (paramBuilder.mContentView != null) {
        this.mBuilder.setCustomContentView(paramBuilder.mContentView);
      }
      if (paramBuilder.mBigContentView != null) {
        this.mBuilder.setCustomBigContentView(paramBuilder.mBigContentView);
      }
      if (paramBuilder.mHeadsUpContentView != null) {
        this.mBuilder.setCustomHeadsUpContentView(paramBuilder.mHeadsUpContentView);
      }
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mBuilder.setBadgeIconType(paramBuilder.mBadgeIcon).setShortcutId(paramBuilder.mShortcutId).setTimeoutAfter(paramBuilder.mTimeout).setGroupAlertBehavior(paramBuilder.mGroupAlertBehavior);
      if (paramBuilder.mColorizedSet) {
        this.mBuilder.setColorized(paramBuilder.mColorized);
      }
      if (!TextUtils.isEmpty(paramBuilder.mChannelId)) {
        this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
  }
  
  private void addAction(NotificationCompat.Action paramAction)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      if (paramAction.getRemoteInputs() != null)
      {
        localObject = RemoteInput.fromCompat(paramAction.getRemoteInputs());
        j = localObject.length;
        i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(localObject[i]);
          i += 1;
        }
      }
      if (paramAction.getExtras() != null)
      {
        localObject = new Bundle(paramAction.getExtras());
        ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24) {
          localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
        }
        localBuilder.addExtras((Bundle)localObject);
        this.mBuilder.addAction(localBuilder.build());
      }
    }
    while (Build.VERSION.SDK_INT < 16) {
      for (;;)
      {
        Notification.Action.Builder localBuilder;
        int j;
        int i;
        return;
        Object localObject = new Bundle();
      }
    }
    this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, paramAction));
  }
  
  private void removeSoundAndVibration(Notification paramNotification)
  {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  public Notification build()
  {
    NotificationCompat.Style localStyle = this.mBuilderCompat.mStyle;
    if (localStyle != null) {
      localStyle.apply(this);
    }
    Object localObject;
    Notification localNotification;
    if (localStyle != null)
    {
      localObject = localStyle.makeContentView(this);
      localNotification = buildInternal();
      if (localObject == null) {
        break label134;
      }
      localNotification.contentView = ((RemoteViews)localObject);
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (localStyle != null))
      {
        localObject = localStyle.makeBigContentView(this);
        if (localObject != null) {
          localNotification.bigContentView = ((RemoteViews)localObject);
        }
      }
      if ((Build.VERSION.SDK_INT >= 21) && (localStyle != null))
      {
        localObject = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
        if (localObject != null) {
          localNotification.headsUpContentView = ((RemoteViews)localObject);
        }
      }
      if ((Build.VERSION.SDK_INT >= 16) && (localStyle != null))
      {
        localObject = NotificationCompat.getExtras(localNotification);
        if (localObject != null) {
          localStyle.addCompatExtras((Bundle)localObject);
        }
      }
      return localNotification;
      localObject = null;
      break;
      label134:
      if (this.mBuilderCompat.mContentView != null) {
        localNotification.contentView = this.mBuilderCompat.mContentView;
      }
    }
  }
  
  protected Notification buildInternal()
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 26) {
      localObject1 = this.mBuilder.build();
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return localObject1;
                              if (Build.VERSION.SDK_INT < 24) {
                                break;
                              }
                              localObject2 = this.mBuilder.build();
                              localObject1 = localObject2;
                            } while (this.mGroupAlertBehavior == 0);
                            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (this.mGroupAlertBehavior == 2)) {
                              removeSoundAndVibration((Notification)localObject2);
                            }
                            localObject1 = localObject2;
                          } while (((Notification)localObject2).getGroup() == null);
                          localObject1 = localObject2;
                        } while ((((Notification)localObject2).flags & 0x200) != 0);
                        localObject1 = localObject2;
                      } while (this.mGroupAlertBehavior != 1);
                      removeSoundAndVibration((Notification)localObject2);
                      return localObject2;
                      if (Build.VERSION.SDK_INT < 21) {
                        break;
                      }
                      this.mBuilder.setExtras(this.mExtras);
                      localObject2 = this.mBuilder.build();
                      if (this.mContentView != null) {
                        ((Notification)localObject2).contentView = this.mContentView;
                      }
                      if (this.mBigContentView != null) {
                        ((Notification)localObject2).bigContentView = this.mBigContentView;
                      }
                      if (this.mHeadsUpContentView != null) {
                        ((Notification)localObject2).headsUpContentView = this.mHeadsUpContentView;
                      }
                      localObject1 = localObject2;
                    } while (this.mGroupAlertBehavior == 0);
                    if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (this.mGroupAlertBehavior == 2)) {
                      removeSoundAndVibration((Notification)localObject2);
                    }
                    localObject1 = localObject2;
                  } while (((Notification)localObject2).getGroup() == null);
                  localObject1 = localObject2;
                } while ((((Notification)localObject2).flags & 0x200) != 0);
                localObject1 = localObject2;
              } while (this.mGroupAlertBehavior != 1);
              removeSoundAndVibration((Notification)localObject2);
              return localObject2;
              if (Build.VERSION.SDK_INT < 20) {
                break;
              }
              this.mBuilder.setExtras(this.mExtras);
              localObject2 = this.mBuilder.build();
              if (this.mContentView != null) {
                ((Notification)localObject2).contentView = this.mContentView;
              }
              if (this.mBigContentView != null) {
                ((Notification)localObject2).bigContentView = this.mBigContentView;
              }
              localObject1 = localObject2;
            } while (this.mGroupAlertBehavior == 0);
            if ((((Notification)localObject2).getGroup() != null) && ((((Notification)localObject2).flags & 0x200) != 0) && (this.mGroupAlertBehavior == 2)) {
              removeSoundAndVibration((Notification)localObject2);
            }
            localObject1 = localObject2;
          } while (((Notification)localObject2).getGroup() == null);
          localObject1 = localObject2;
        } while ((((Notification)localObject2).flags & 0x200) != 0);
        localObject1 = localObject2;
      } while (this.mGroupAlertBehavior != 1);
      removeSoundAndVibration((Notification)localObject2);
      return localObject2;
      if (Build.VERSION.SDK_INT < 19) {
        break;
      }
      localObject1 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localObject1 != null) {
        this.mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
      }
      this.mBuilder.setExtras(this.mExtras);
      localObject2 = this.mBuilder.build();
      if (this.mContentView != null) {
        ((Notification)localObject2).contentView = this.mContentView;
      }
      localObject1 = localObject2;
    } while (this.mBigContentView == null);
    ((Notification)localObject2).bigContentView = this.mBigContentView;
    return localObject2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject1 = this.mBuilder.build();
      localObject2 = NotificationCompat.getExtras((Notification)localObject1);
      Bundle localBundle = new Bundle(this.mExtras);
      Iterator localIterator = this.mExtras.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((Bundle)localObject2).containsKey(str)) {
          localBundle.remove(str);
        }
      }
      ((Bundle)localObject2).putAll(localBundle);
      localObject2 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (localObject2 != null) {
        NotificationCompat.getExtras((Notification)localObject1).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject2);
      }
      if (this.mContentView != null) {
        ((Notification)localObject1).contentView = this.mContentView;
      }
      if (this.mBigContentView != null) {
        ((Notification)localObject1).bigContentView = this.mBigContentView;
      }
      return localObject1;
    }
    return this.mBuilder.getNotification();
  }
  
  public Notification.Builder getBuilder()
  {
    return this.mBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatBuilder
 * JD-Core Version:    0.7.0.1
 */