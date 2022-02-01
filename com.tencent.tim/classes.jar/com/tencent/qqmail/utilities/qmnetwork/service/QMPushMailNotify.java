package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.aba.PushWebAttach;
import com.tencent.qqmail.activity.aba.QMAbaActivity;
import com.tencent.qqmail.activity.aba.QMAbaTextManager;
import com.tencent.qqmail.activity.aba.QMAbaTextManager.QMAttachIntentType;
import com.tencent.qqmail.activity.media.MediaFolderSelectActivity;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.trd.guava.Longs;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.badge.BadgeUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import moai.oss.KvHelper;

public class QMPushMailNotify
{
  private static final String CONF_MAIL_CONTENT_DATA = "mail_content_data_v4";
  private static final String KEY_LAST_NOTIFY_OLD_MAIL_TIME = "last_notify_old_mail_time";
  private static final String KEY_LAST_RING_TIME = "last_ring_time";
  private static final long NOTIFY_OLD_MAIL_INTERVAL = 3600000L;
  private static final long POST_MAIL_OLDEST_TIME = 432000L;
  private static final long PROTECT_MORE_PUSH_NOTIFY = 5000L;
  private static final long RING_OLD_MAIL_INTERVAL = 21600000L;
  private static final String TAG = "QMPushMailNotify";
  private static volatile QMPushMailNotify sharedInstance = new QMPushMailNotify();
  private AudioManager mAudioManager = (AudioManager)QMApplicationContext.sharedInstance().getSystemService("audio");
  private Runnable mCancelAllNotifyNewMailTask = new QMPushMailNotify.4(this);
  private CancelMailTask mCancelMailTask = new CancelMailTask(null);
  private final SparseArray<List<PushMailBody>> mContentData = new SparseArray();
  private long mLastPushMailTime;
  private NotificationManager mNotificationManager = (NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification");
  private PostMailTask mPostMailTask = new PostMailTask(null);
  private Set<Integer> mPushMailNotificationIds = Collections.newSetFromMap(new ConcurrentHashMap());
  
  private void cancelMailNotification(long paramLong)
  {
    Threads.runInBackgroundIfNotExist(this.mCancelMailTask, paramLong);
  }
  
  private void checkDuplicatedLocked(List<PushMailBody> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new ArrayList();
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(Long.valueOf(((PushMailBody)((Iterator)localObject2).next()).nMailId));
      }
      localObject2 = QMMailManager.sharedInstance().getSqliteHelper();
      localObject1 = ((QMMailSQLiteHelper)localObject2).mail.getMailIdAndConvType(((QMMailSQLiteHelper)localObject2).getReadableDatabase(), Longs.toArray((Collection)localObject1));
      QMLog.log(3, "QMPushMailNotify", "checkDuplicatedLocked: " + localObject1);
    } while (localObject1 == null);
    Object localObject2 = new SparseArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PushMailBody localPushMailBody = (PushMailBody)paramList.next();
      Object localObject3 = AccountManager.shareInstance().getAccountList().getAccountById(localPushMailBody.accountId);
      if (localObject3 != null)
      {
        int i = (localPushMailBody.subject + localPushMailBody.remoteId + ((Account)localObject3).getEmail()).hashCode();
        if (((SparseArray)localObject2).indexOfKey(i) >= 0)
        {
          localObject3 = (PushMailBody)((SparseArray)localObject2).get(i);
          if ((((Map)localObject1).containsKey(Long.valueOf(((PushMailBody)localObject3).nMailId))) && (((Integer)((Map)localObject1).get(Long.valueOf(((PushMailBody)localObject3).nMailId))).intValue() == 1))
          {
            QMLog.log(5, "QMPushMailNotify", "remove duplicated mail for notification: " + localObject3);
            this.mCancelMailTask.offerCancelMail((PushMailBody)localObject3);
            ((SparseArray)localObject2).put(i, localPushMailBody);
          }
          else if ((((Map)localObject1).containsKey(Long.valueOf(localPushMailBody.nMailId))) && (((Integer)((Map)localObject1).get(Long.valueOf(localPushMailBody.nMailId))).intValue() == 1))
          {
            QMLog.log(5, "QMPushMailNotify", "remove duplicated mail for notification: " + localPushMailBody);
            this.mCancelMailTask.offerCancelMail(localPushMailBody);
          }
        }
        else
        {
          ((SparseArray)localObject2).put(i, localPushMailBody);
        }
      }
    }
    cancelMailNotification(3000L);
  }
  
  private void clearAllMailData()
  {
    if (this.mContentData.size() > 0) {}
    synchronized (this.mContentData)
    {
      this.mContentData.clear();
      QMServiceManager.getWebPushEditor().remove("mail_content_data_v4").apply();
      return;
    }
  }
  
  private void clearMailData(int paramInt)
  {
    updateContentDataFromFile();
    if (this.mContentData.size() > 0) {}
    synchronized (this.mContentData)
    {
      this.mContentData.remove(paramInt);
      saveContentData();
      return;
    }
  }
  
  private void clearMailData(int paramInt, long paramLong)
  {
    updateContentDataFromFile();
    if (this.mContentData.size() == 0) {
      return;
    }
    int j;
    synchronized (this.mContentData)
    {
      j = this.mContentData.size();
      if (j == 0) {
        return;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = (List)this.mContentData.valueAt(i);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          PushMailBody localPushMailBody;
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localPushMailBody = (PushMailBody)((Iterator)localObject2).next();
          } while ((paramInt != localPushMailBody.accountId) || (localPushMailBody.nMailId != paramLong));
          ((Iterator)localObject2).remove();
        }
      }
      else
      {
        saveContentData();
        return;
      }
      i += 1;
    }
  }
  
  private void clearMailData(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      updateContentDataFromFile();
    } while (this.mContentData.size() == 0);
    int j;
    synchronized (this.mContentData)
    {
      j = this.mContentData.size();
      if (j == 0) {
        return;
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = (List)this.mContentData.valueAt(i);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          PushMailBody localPushMailBody;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localPushMailBody = (PushMailBody)((Iterator)localObject).next();
          } while ((paramInt != localPushMailBody.accountId) || (!paramString.equals(localPushMailBody.remoteId)));
          ((Iterator)localObject).remove();
        }
      }
      else
      {
        saveContentData();
        return;
      }
      i += 1;
    }
  }
  
  private PendingIntent createPendingIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QMNotificationService.class);
    localIntent.setData(Uri.parse(paramString));
    return PendingIntent.getService(QMApplicationContext.sharedInstance(), 46, localIntent, 268435456);
  }
  
  private String environment()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("foreground: ").append(AppStatusUtil.isAppOnForeground()).append(", ringerMode: ").append(this.mAudioManager.getRingerMode()).append(", volume: ").append(this.mAudioManager.getStreamVolume(5)).append(", permissionPost: ").append(PermissionUtils.hasNotificationPostPermission()).append(", permissionVolume: ").append(PermissionUtils.hasNotificationVolumePermissoin()).append(", permissionVibrate: ").append(PermissionUtils.hasPermissionVibrate()).append(", notify: ").append(QMSettingManager.sharedInstance().getNotifyNewMail()).append(", soundEnable: ").append(QMSettingManager.sharedInstance().getEnableSoundPushNewMail()).append(", vibrateEnable: ").append(QMSettingManager.sharedInstance().getEnablePushNewMailVibrate()).append(", nightMode: ").append(QMSettingManager.sharedInstance().getUseNightMode()).append(", sound: ").append(QMServiceManager.hasSound()).append(", vibrate: ").append(QMServiceManager.hasVibrate()).append(", notifyAd: ").append(QMSettingManager.sharedInstance().getNotifyAdMail()).append(", vipOnly: ").append(QMSettingManager.sharedInstance().getOnlyNotifyVIP());
    Object localObject1 = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject1).size() > 0)
    {
      localObject1 = ((AccountList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Account)((Iterator)localObject1).next();
        localStringBuilder.append(", {account: ").append(((Account)localObject2).getEmail()).append(", notify: ").append(QMSettingManager.sharedInstance().getNotifyAccountMail(((Account)localObject2).getId())).append(", syncMethod: ").append(QMSyncManager.sharedInstance().getSyncMethod(((Account)localObject2).getId())).append(", pollingInterval: ").append(QMSyncManager.sharedInstance().getPollingInterval(((Account)localObject2).getId())).append("s, inboxOnly: ").append(QMSettingManager.sharedInstance().getPushInboxOnly(((Account)localObject2).getId()));
        localObject2 = QMFolderManager.sharedInstance().getFoldersByAccountId(((Account)localObject2).getId());
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            QMFolder localQMFolder = (QMFolder)((Iterator)localObject2).next();
            switch (localQMFolder.getType())
            {
            default: 
              break;
            case 0: 
            case 1: 
            case 8: 
            case 12: 
            case 15: 
              localStringBuilder.append(", ").append(localQMFolder.getName()).append("/").append(localQMFolder.isPush());
            }
          }
        }
        localStringBuilder.append("}");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static QMPushMailNotify getInstance()
  {
    return sharedInstance;
  }
  
  private int getMailPushNotificationId(long paramLong)
  {
    return 15000000 + Math.abs((int)paramLong) % 1000000;
  }
  
  private String getSenderNickname(PushMailBody paramPushMailBody)
  {
    if ((paramPushMailBody.sender != null) && ((paramPushMailBody.sender.nick != null) || (paramPushMailBody.sender.address != null)))
    {
      if ((paramPushMailBody.sender.nick != null) && (paramPushMailBody.sender.nick.trim().length() > 0)) {
        return paramPushMailBody.sender.nick;
      }
      return paramPushMailBody.sender.address;
    }
    return QMApplicationContext.sharedInstance().getString(2131696450);
  }
  
  private void notifyNewMailWithExpanding(PushMailBody paramPushMailBody, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = QMSettingManager.sharedInstance().getShowMailDetail();
    QMLog.log(4, "QMPushMailNotify", "notifyNewMailWithExpanding, silent: " + paramBoolean1 + ", ticker: " + paramBoolean2 + ", body: " + paramPushMailBody + ", showIcon: " + paramBoolean3 + ", showDetail: " + bool);
    QMPushManager.clearMailNotification(paramPushMailBody.remoteId);
    if (paramPushMailBody.subject == null) {
      paramPushMailBody.subject = QMApplicationContext.sharedInstance().getString(2131695645);
    }
    if (paramBoolean1)
    {
      paramPushMailBody.hasSound = false;
      paramPushMailBody.hasVibrate = false;
    }
    long l = System.currentTimeMillis();
    if (l - this.mLastPushMailTime < 5000L)
    {
      paramPushMailBody.hasSound = false;
      paramPushMailBody.hasVibrate = false;
    }
    int i = getMailPushNotificationId(paramPushMailBody.nMailId);
    this.mPushMailNotificationIds.add(Integer.valueOf(i));
    if ((paramPushMailBody.hasSound) && (paramPushMailBody.hasVibrate)) {
      this.mLastPushMailTime = l;
    }
    PendingIntent localPendingIntent3 = createPendingIntent(String.format(Locale.getDefault(), "%s://%s?%s=%d&%s=%d&%s=%s", new Object[] { "qqmail", "cancel", "accountid", Integer.valueOf(paramPushMailBody.accountId), "notificationid", Integer.valueOf(i), "remoteid", paramPushMailBody.remoteId }));
    PendingIntent localPendingIntent1;
    PendingIntent localPendingIntent2;
    label505:
    int j;
    int k;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label552:
    label562:
    PendingIntent localPendingIntent4;
    if (bool)
    {
      localPendingIntent1 = createPendingIntent(String.format(Locale.getDefault(), "%s://%s?%s=%d&%s=%d&%s=%s&%s=%d&%s=%d", new Object[] { "qqmail", "read", "accountid", Integer.valueOf(paramPushMailBody.accountId), "folderid", Integer.valueOf(paramPushMailBody.folderid), "remoteid", paramPushMailBody.remoteId, "mailid", Long.valueOf(paramPushMailBody.nMailId), "notificationid", Integer.valueOf(i) }));
      if (!bool) {
        break label844;
      }
      localPendingIntent2 = createPendingIntent(String.format(Locale.getDefault(), "%s://%s?%s=%d&%s=%d&%s=%s&%s=%d&%s=%d", new Object[] { "qqmail", "delete", "accountid", Integer.valueOf(paramPushMailBody.accountId), "folderid", Integer.valueOf(paramPushMailBody.folderid), "remoteid", paramPushMailBody.remoteId, "mailid", Long.valueOf(paramPushMailBody.nMailId), "notificationid", Integer.valueOf(i) }));
      if (!paramPushMailBody.fromPush) {
        break label874;
      }
      j = paramPushMailBody.accountId;
      k = paramPushMailBody.folderid;
      l = paramPushMailBody.nMailId;
      localObject2 = paramPushMailBody.remoteId;
      localObject3 = paramPushMailBody.subject;
      if (paramPushMailBody.sender != null) {
        break label850;
      }
      localObject1 = null;
      if (paramPushMailBody.sender != null) {
        break label862;
      }
      str1 = null;
      localObject1 = LaunchWebPush.createOneMailIntentFromPush(j, k, l, (String)localObject2, (String)localObject3, (String)localObject1, str1, true, false);
      localPendingIntent4 = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject1, 134217728);
      localObject1 = getSenderNickname(paramPushMailBody);
      if (!bool) {
        break label962;
      }
      label609:
      if (!bool) {
        break label976;
      }
    }
    label844:
    label976:
    for (String str1 = paramPushMailBody.subject;; str1 = QMApplicationContext.sharedInstance().getString(2131695644))
    {
      String str2 = (String)localObject1 + ": " + str1;
      Object localObject4 = AccountManager.shareInstance().getAccountList();
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramPushMailBody.accountId);
      localObject3 = null;
      localObject2 = localObject3;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject2 = localObject3;
        if (((AccountList)localObject4).size() > 1)
        {
          localObject2 = localObject3;
          if (localAccount != null)
          {
            localObject2 = localObject3;
            if (bool) {
              localObject2 = localAccount.getEmail();
            }
          }
        }
      }
      localObject4 = null;
      localObject3 = localObject4;
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject3 = localObject4;
        if (localObject2 != null) {
          localObject3 = "";
        }
      }
      localObject4 = null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject4 = new ArrayList();
        ((ArrayList)localObject4).add(str1);
      }
      QMNotificationConstructor.getInstance().notifyPushNewMail(i, (String)localObject1, str2, str1, (String)localObject2, paramPushMailBody.hasSound, paramPushMailBody.soundResId, paramPushMailBody.hasVibrate, localPendingIntent4, localPendingIntent3, (String)localObject1, (String)localObject3, (ArrayList)localObject4, localPendingIntent1, localPendingIntent2, paramInt, paramBoolean1, paramBoolean2, 1000L * paramPushMailBody.recvTime, paramBoolean3);
      return;
      localPendingIntent1 = null;
      break;
      localPendingIntent2 = null;
      break label505;
      label850:
      localObject1 = paramPushMailBody.sender.nick;
      break label552;
      label862:
      str1 = paramPushMailBody.sender.address;
      break label562;
      label874:
      j = paramPushMailBody.accountId;
      k = paramPushMailBody.folderid;
      l = paramPushMailBody.nMailId;
      localObject2 = paramPushMailBody.subject;
      if (paramPushMailBody.sender == null)
      {
        localObject1 = null;
        if (paramPushMailBody.sender != null) {
          break label950;
        }
      }
      for (str1 = null;; str1 = paramPushMailBody.sender.address)
      {
        localObject1 = LaunchWebPush.createOneMailIntentNotFromPush(j, k, l, (String)localObject2, (String)localObject1, str1);
        break;
        localObject1 = paramPushMailBody.sender.nick;
        break label908;
      }
      localObject1 = QMApplicationContext.sharedInstance().getString(2131690411);
      break label609;
    }
  }
  
  /* Error */
  private void saveContentData()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 116	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:mContentData	Landroid/util/SparseArray;
    //   6: invokevirtual 342	android/util/SparseArray:size	()I
    //   9: ifne +19 -> 28
    //   12: invokestatic 351	com/tencent/qqmail/utilities/qmnetwork/service/QMServiceManager:getWebPushEditor	()Landroid/content/SharedPreferences$Editor;
    //   15: ldc 14
    //   17: invokeinterface 357 2 0
    //   22: invokeinterface 360 1 0
    //   27: return
    //   28: aload_0
    //   29: getfield 116	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:mContentData	Landroid/util/SparseArray;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 116	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:mContentData	Landroid/util/SparseArray;
    //   41: invokevirtual 342	android/util/SparseArray:size	()I
    //   44: istore 4
    //   46: aconst_null
    //   47: astore 5
    //   49: invokestatic 712	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   52: astore 6
    //   54: aload 6
    //   56: astore 5
    //   58: aload 5
    //   60: iload 4
    //   62: invokevirtual 715	android/os/Parcel:writeInt	(I)V
    //   65: iconst_0
    //   66: istore_1
    //   67: iload_3
    //   68: iload 4
    //   70: if_icmpge +237 -> 307
    //   73: iload_1
    //   74: istore_2
    //   75: aload 5
    //   77: aload_0
    //   78: getfield 116	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:mContentData	Landroid/util/SparseArray;
    //   81: iload_3
    //   82: invokevirtual 718	android/util/SparseArray:keyAt	(I)I
    //   85: invokevirtual 715	android/os/Parcel:writeInt	(I)V
    //   88: iload_1
    //   89: istore_2
    //   90: aload_0
    //   91: getfield 116	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:mContentData	Landroid/util/SparseArray;
    //   94: iload_3
    //   95: invokevirtual 365	android/util/SparseArray:valueAt	(I)Ljava/lang/Object;
    //   98: checkcast 180	java/util/List
    //   101: astore 6
    //   103: aload 6
    //   105: ifnull +15 -> 120
    //   108: iload_1
    //   109: istore_2
    //   110: aload 6
    //   112: invokeinterface 184 1 0
    //   117: ifne +14 -> 131
    //   120: iload_1
    //   121: istore_2
    //   122: aload 5
    //   124: iconst_0
    //   125: invokevirtual 715	android/os/Parcel:writeInt	(I)V
    //   128: goto +302 -> 430
    //   131: iload_1
    //   132: istore_2
    //   133: aload 5
    //   135: aload 6
    //   137: invokeinterface 184 1 0
    //   142: invokevirtual 715	android/os/Parcel:writeInt	(I)V
    //   145: iload_1
    //   146: istore_2
    //   147: aload 6
    //   149: invokeinterface 191 1 0
    //   154: astore 6
    //   156: iload_1
    //   157: istore_2
    //   158: aload 6
    //   160: invokeinterface 197 1 0
    //   165: ifeq +265 -> 430
    //   168: iload_1
    //   169: istore_2
    //   170: aload 6
    //   172: invokeinterface 201 1 0
    //   177: checkcast 203	com/tencent/qqmail/utilities/qmnetwork/service/PushMailBody
    //   180: astore 8
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: iload_1
    //   187: istore_2
    //   188: aload 8
    //   190: aload 5
    //   192: iconst_0
    //   193: invokevirtual 722	com/tencent/qqmail/utilities/qmnetwork/service/PushMailBody:writeToParcel	(Landroid/os/Parcel;I)V
    //   196: goto -40 -> 156
    //   199: astore 6
    //   201: iload_2
    //   202: istore_1
    //   203: aload_0
    //   204: invokespecial 139	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:clearAllMailData	()V
    //   207: invokestatic 351	com/tencent/qqmail/utilities/qmnetwork/service/QMServiceManager:getWebPushEditor	()Landroid/content/SharedPreferences$Editor;
    //   210: ldc 14
    //   212: invokeinterface 357 2 0
    //   217: invokeinterface 360 1 0
    //   222: aload_0
    //   223: getfield 116	com/tencent/qqmail/utilities/qmnetwork/service/QMPushMailNotify:mContentData	Landroid/util/SparseArray;
    //   226: invokevirtual 345	android/util/SparseArray:clear	()V
    //   229: aload 6
    //   231: instanceof 724
    //   234: ifeq +12 -> 246
    //   237: invokestatic 727	java/lang/System:gc	()V
    //   240: ldc2_w 728
    //   243: invokestatic 734	android/os/SystemClock:sleep	(J)V
    //   246: iconst_5
    //   247: ldc 36
    //   249: new 249	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 736
    //   259: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 4
    //   264: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: ldc_w 738
    //   270: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_1
    //   274: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aload 6
    //   282: invokestatic 741	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload 5
    //   287: ifnull +8 -> 295
    //   290: aload 5
    //   292: invokevirtual 744	android/os/Parcel:recycle	()V
    //   295: aload 7
    //   297: monitorexit
    //   298: return
    //   299: astore 5
    //   301: aload 7
    //   303: monitorexit
    //   304: aload 5
    //   306: athrow
    //   307: iload_1
    //   308: istore_2
    //   309: aload 5
    //   311: invokevirtual 748	android/os/Parcel:marshall	()[B
    //   314: astore 6
    //   316: iload_1
    //   317: istore_2
    //   318: invokestatic 351	com/tencent/qqmail/utilities/qmnetwork/service/QMServiceManager:getWebPushEditor	()Landroid/content/SharedPreferences$Editor;
    //   321: ldc 14
    //   323: aload 6
    //   325: aload 6
    //   327: arraylength
    //   328: invokestatic 754	com/tencent/qqmail/utilities/stringextention/StringExtention:base64Encode	([BI)Ljava/lang/String;
    //   331: invokeinterface 758 3 0
    //   336: invokeinterface 360 1 0
    //   341: iload_1
    //   342: istore_2
    //   343: iconst_4
    //   344: ldc 36
    //   346: new 249	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 736
    //   356: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: iload 4
    //   361: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: ldc_w 738
    //   367: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload_1
    //   371: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 268	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   380: aload 5
    //   382: ifnull -87 -> 295
    //   385: aload 5
    //   387: invokevirtual 744	android/os/Parcel:recycle	()V
    //   390: goto -95 -> 295
    //   393: aload 5
    //   395: ifnull +8 -> 403
    //   398: aload 5
    //   400: invokevirtual 744	android/os/Parcel:recycle	()V
    //   403: aload 6
    //   405: athrow
    //   406: astore 6
    //   408: goto -15 -> 393
    //   411: astore 6
    //   413: goto -20 -> 393
    //   416: astore 6
    //   418: iconst_0
    //   419: istore_1
    //   420: goto -217 -> 203
    //   423: astore 6
    //   425: iconst_0
    //   426: istore_1
    //   427: goto -224 -> 203
    //   430: iload_3
    //   431: iconst_1
    //   432: iadd
    //   433: istore_3
    //   434: goto -367 -> 67
    //   437: astore 6
    //   439: aconst_null
    //   440: astore 5
    //   442: goto -49 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	QMPushMailNotify
    //   66	361	1	i	int
    //   74	269	2	j	int
    //   1	433	3	k	int
    //   44	316	4	m	int
    //   47	244	5	localObject1	Object
    //   299	100	5	localObject2	Object
    //   440	1	5	localObject3	Object
    //   52	119	6	localObject4	Object
    //   199	82	6	localThrowable1	Throwable
    //   314	90	6	arrayOfByte	byte[]
    //   406	1	6	localObject5	Object
    //   411	1	6	localObject6	Object
    //   416	1	6	localThrowable2	Throwable
    //   423	1	6	localThrowable3	Throwable
    //   437	1	6	localObject7	Object
    //   32	270	7	localSparseArray	SparseArray
    //   180	9	8	localPushMailBody	PushMailBody
    // Exception table:
    //   from	to	target	type
    //   75	88	199	java/lang/Throwable
    //   90	103	199	java/lang/Throwable
    //   110	120	199	java/lang/Throwable
    //   122	128	199	java/lang/Throwable
    //   133	145	199	java/lang/Throwable
    //   147	156	199	java/lang/Throwable
    //   158	168	199	java/lang/Throwable
    //   170	182	199	java/lang/Throwable
    //   188	196	199	java/lang/Throwable
    //   309	316	199	java/lang/Throwable
    //   318	341	199	java/lang/Throwable
    //   343	380	199	java/lang/Throwable
    //   37	46	299	finally
    //   290	295	299	finally
    //   295	298	299	finally
    //   301	304	299	finally
    //   385	390	299	finally
    //   398	403	299	finally
    //   403	406	299	finally
    //   58	65	406	finally
    //   75	88	406	finally
    //   90	103	406	finally
    //   110	120	406	finally
    //   122	128	406	finally
    //   133	145	406	finally
    //   147	156	406	finally
    //   158	168	406	finally
    //   170	182	406	finally
    //   188	196	406	finally
    //   309	316	406	finally
    //   318	341	406	finally
    //   343	380	406	finally
    //   203	246	411	finally
    //   246	285	411	finally
    //   49	54	416	java/lang/Throwable
    //   58	65	423	java/lang/Throwable
    //   49	54	437	finally
  }
  
  private void updateBadge()
  {
    if (AppStatusUtil.isAppOnForeground()) {
      return;
    }
    BadgeUtil.getInstance().setBadgeAccordingNotification(getSavedMailNum());
  }
  
  private void updateContentDataFromFile()
  {
    if (this.mContentData.size() == 0) {}
    for (;;)
    {
      int i2;
      int j;
      int i1;
      int k;
      Parcel localParcel1;
      Object localObject1;
      synchronized (this.mContentData)
      {
        Object localObject5;
        long l;
        Object localObject4;
        Parcel localParcel2;
        int m;
        int n;
        int i3;
        int i;
        if (this.mContentData.size() == 0)
        {
          localObject5 = QMServiceManager.getWebPushSP().getString("mail_content_data_v4", null);
          if (localObject5 != null)
          {
            l = System.currentTimeMillis() / 1000L;
            localObject4 = null;
            localParcel2 = null;
            i2 = 0;
            m = 0;
            n = 0;
            i3 = 0;
            i = 0;
            j = i3;
            i1 = n;
            k = i2;
            localParcel1 = localParcel2;
            localObject1 = localObject4;
          }
        }
        try
        {
          localObject5 = StringExtention.decode((String)localObject5);
          j = i3;
          i1 = n;
          k = i2;
          localParcel1 = localParcel2;
          localObject1 = localObject4;
          localParcel2 = Parcel.obtain();
          j = i3;
          i1 = n;
          k = i2;
          localParcel1 = localParcel2;
          localObject1 = localParcel2;
          localParcel2.unmarshall((byte[])localObject5, 0, localObject5.length);
          j = i3;
          i1 = n;
          k = i2;
          localParcel1 = localParcel2;
          localObject1 = localParcel2;
          localParcel2.setDataPosition(0);
          j = i3;
          i1 = n;
          k = i2;
          localParcel1 = localParcel2;
          localObject1 = localParcel2;
          i3 = localParcel2.readInt();
          n = 0;
          if (n < i3)
          {
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            int i4 = localParcel2.readInt();
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            int i5 = localParcel2.readInt();
            m += i5;
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            localObject4 = new ArrayList();
            i2 = 0;
            if (i2 < i5)
            {
              j = i;
              i1 = i3;
              k = m;
              localParcel1 = localParcel2;
              localObject1 = localParcel2;
              localObject5 = (PushMailBody)PushMailBody.CREATOR.createFromParcel(localParcel2);
              j = i;
              i1 = i3;
              k = m;
              localParcel1 = localParcel2;
              localObject1 = localParcel2;
              if (l - ((PushMailBody)localObject5).fromtime > 432000L)
              {
                i += 1;
                break label693;
              }
              j = i;
              i1 = i3;
              k = m;
              localParcel1 = localParcel2;
              localObject1 = localParcel2;
              ((List)localObject4).add(localObject5);
              break label693;
            }
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            Collections.sort((List)localObject4, new QMPushMailNotify.5(this));
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            if (((List)localObject4).size() <= 10) {
              break label690;
            }
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            localObject4 = ((List)localObject4).subList(0, 10);
            j = i;
            i1 = i3;
            k = m;
            localParcel1 = localParcel2;
            localObject1 = localParcel2;
            this.mContentData.put(i4, localObject4);
            n += 1;
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          localObject1 = localParcel1;
          clearAllMailData();
          localObject1 = localParcel1;
          QMServiceManager.getWebPushEditor().remove("mail_content_data_v4").apply();
          localObject1 = localParcel1;
          if (!(localThrowable instanceof OutOfMemoryError)) {
            break label601;
          }
          localObject1 = localParcel1;
          System.gc();
          localObject1 = localParcel1;
          SystemClock.sleep(500L);
          localObject1 = localParcel1;
          QMLog.log(5, "QMPushMailNotify", "updateContentDataFromFile, account: " + i1 + ", mails: " + k + ", expired: " + j, localThrowable);
          if (localParcel1 == null) {
            continue;
          }
          localParcel1.recycle();
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        finally
        {
          if (localObject2 == null) {
            break label687;
          }
          localObject2.recycle();
        }
        return;
      }
      label601:
      continue;
      label687:
      label690:
      label693:
      i2 += 1;
    }
  }
  
  public void cancelAllNotifyNewMail()
  {
    Threads.runInBackgroundIfNotExist(this.mCancelAllNotifyNewMailTask, 2000L);
  }
  
  public void cancelNotifyNewMail(int paramInt)
  {
    QMLog.log(4, "QMPushMailNotify", "cancelNotifyNewMail, account: " + paramInt);
    Threads.runInBackground(new QMPushMailNotify.3(this, paramInt));
  }
  
  public void cancelNotifyNewMail(int paramInt, long paramLong)
  {
    QMLog.log(4, "QMPushMailNotify", "delete Mail cancelNotifyNewMail, mailId: " + paramLong);
    Threads.runInBackground(new QMPushMailNotify.1(this, paramLong, paramInt));
  }
  
  void cancelNotifyNewMail(int paramInt1, String paramString, int paramInt2)
  {
    QMLog.log(4, "QMPushMailNotify", "cancelNotifyNewMail, removeId: " + paramString);
    Threads.runInBackground(new QMPushMailNotify.2(this, paramInt2, paramInt1, paramString));
  }
  
  public void clearAllNewMailExpandNotify()
  {
    Iterator localIterator = this.mPushMailNotificationIds.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      QMNotificationConstructor.getInstance().clearNewMailNotify(i);
    }
    this.mPushMailNotificationIds.clear();
  }
  
  public void clearNewMailFoldNotify()
  {
    if (this.mNotificationManager == null) {
      return;
    }
    QMNotificationConstructor.getInstance().clearNewMailNotify(true);
  }
  
  public void clearNewMailNotify(long paramLong)
  {
    int i = getMailPushNotificationId(paramLong);
    this.mPushMailNotificationIds.remove(Integer.valueOf(i));
    QMNotificationConstructor.getInstance().clearNewMailNotify(i);
  }
  
  public int getSavedMailNum()
  {
    updateContentDataFromFile();
    if (this.mContentData.size() == 0) {
      return 0;
    }
    int m;
    synchronized (this.mContentData)
    {
      m = this.mContentData.size();
      if (m == 0) {
        return 0;
      }
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      int k;
      if (i < m)
      {
        List localList = (List)this.mContentData.valueAt(i);
        if (localList == null) {
          k = 0;
        } else {
          k = localList.size();
        }
      }
      else
      {
        return j;
      }
      j += k;
      i += 1;
    }
  }
  
  public void notifyAttachPush(PushWebAttach paramPushWebAttach)
  {
    if (paramPushWebAttach == null) {}
    String str1;
    String str2;
    Object localObject2;
    do
    {
      return;
      localObject1 = QMApplicationContext.sharedInstance();
      str1 = ((Context)localObject1).getString(2131690411);
      str2 = ((Context)localObject1).getString(2131690270);
      localObject1 = QMAbaActivity.createIntent(QMAbaTextManager.QMAttachIntentType.QMAttachIntentType_PUSH);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean(QMAbaTextManager.Attach_FROM_PUSH, true);
      ((Bundle)localObject2).putBoolean(QMAbaTextManager.Attach_FROM_BG_PUSH, true);
      ((Bundle)localObject2).putParcelable("body", paramPushWebAttach);
      ((Intent)localObject1).setFlags(536870912);
      ((Intent)localObject1).addFlags(2);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setAction(String.valueOf(System.currentTimeMillis()));
      localObject2 = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject1, 134217728);
    } while (AppStatusUtil.isAppOnForeground());
    if (AccountManager.shareInstance().getAccountList().size() > 1) {}
    for (Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramPushWebAttach.getAccountId());; localObject1 = null)
    {
      QMNotificationConstructor localQMNotificationConstructor = QMNotificationConstructor.getInstance();
      int i = paramPushWebAttach.getAccountId();
      if (localObject1 == null) {}
      for (paramPushWebAttach = null;; paramPushWebAttach = ((Account)localObject1).getEmail())
      {
        localQMNotificationConstructor.notifyPushImage(i, str1, str2, paramPushWebAttach, (PendingIntent)localObject2);
        return;
      }
    }
  }
  
  public void notifyCreditCardBillReminder(@NonNull CreditCardBill paramCreditCardBill)
  {
    Object localObject = QMApplicationContext.sharedInstance();
    String str1 = ((Context)localObject).getString(2131690411);
    String str2 = ((Context)localObject).getString(2131718764);
    String str3 = ((Context)localObject).getString(2131718771);
    localObject = "****";
    if (paramCreditCardBill.num != null) {
      if (paramCreditCardBill.num.length() > 4) {
        break label117;
      }
    }
    label117:
    for (localObject = paramCreditCardBill.num;; localObject = paramCreditCardBill.num.substring(paramCreditCardBill.num.length() - 4))
    {
      localObject = String.format(str3, new Object[] { paramCreditCardBill.bank, localObject });
      paramCreditCardBill = CalendarFragmentActivity.createIntentForCreditCardBill(paramCreditCardBill);
      paramCreditCardBill = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, paramCreditCardBill, 134217728);
      QMNotificationConstructor.getInstance().notify(12041689, str1, str2, (String)localObject, QMAppInterface.sharedInstance().getNtId(), paramCreditCardBill, false);
      return;
    }
  }
  
  void notifyGmailAuth(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    String str1 = "";
    if (localObject != null) {
      str1 = ((Account)localObject).getEmail();
    }
    localObject = LaunchWebPush.createPasswordErrorIntent();
    PasswordErrHandler.saveStateAndShowErr(paramInt, -6, "");
    str1 = String.format(QMApplicationContext.sharedInstance().getString(2131696441), new Object[] { str1 });
    String str2 = QMApplicationContext.sharedInstance().getString(2131696442);
    localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject, 134217728);
    QMNotificationConstructor.getInstance().notifyPushDeviceError(paramInt, str1, str2, str1, 2130840992, (PendingIntent)localObject);
  }
  
  void notifyGotoFtn(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    String str1 = QMApplicationContext.sharedInstance().getString(2131690411);
    String str2 = String.format(QMApplicationContext.sharedInstance().getString(2131696304), new Object[] { Integer.valueOf(paramInt2) });
    Object localObject1 = LaunchWebPush.createFtnIntent(paramInt1, "from_send_file", paramInt2);
    PendingIntent localPendingIntent = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), paramInt1, (Intent)localObject1, 134217728);
    QMLog.log(4, "webpush", "notify goto ftn!");
    localObject1 = AccountManager.shareInstance().getAccountList();
    Object localObject3;
    if (((AccountList)localObject1).size() >= 1)
    {
      localObject3 = ((AccountList)localObject1).getDefaultFtnAccount();
      Account localAccount = ((AccountList)localObject1).getAccountById(paramInt1);
      localObject1 = localAccount;
      if (localObject3 != null)
      {
        localObject1 = localAccount;
        if (((Account)localObject3).getId() == paramInt1)
        {
          localObject1 = localAccount;
          if (!QMSettingManager.sharedInstance().getFtnDisplay()) {}
        }
      }
    }
    for (localObject1 = localObject3;; localObject1 = null)
    {
      localObject3 = QMNotificationConstructor.getInstance();
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((Account)localObject1).getEmail())
      {
        ((QMNotificationConstructor)localObject3).notifyPushFtn(paramInt1, str1, str2, (String)localObject1, localPendingIntent);
        if (AppStatusUtil.isAppOnForeground()) {
          Threads.runInBackground(new QMPushMailNotify.7(this), 2000L);
        }
        return;
      }
    }
  }
  
  void notifyGotoLogin(int paramInt1, int paramInt2)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if (localAccount == null)
    {
      QMLog.log(6, "webpush", "notifyGotoLogin account_null");
      return;
    }
    Object localObject = LaunchWebPush.createPasswordErrorIntent();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    switch (paramInt2)
    {
    }
    for (;;)
    {
      localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject, 134217728);
      QMNotificationConstructor.getInstance().notifyPushDeviceError(paramInt1, str1, str2, str3, 2130840992, (PendingIntent)localObject);
      return;
      str1 = String.format(QMApplicationContext.sharedInstance().getString(2131696432), new Object[] { localAccount.getName() });
      str2 = QMApplicationContext.sharedInstance().getString(2131696431);
      str3 = localAccount.getEmail();
      SharedPreferenceUtil.setDeviceLockState(paramInt1);
      continue;
      str1 = QMApplicationContext.sharedInstance().getString(2131695546);
      str2 = QMApplicationContext.sharedInstance().getString(2131696460);
      str3 = localAccount.getEmail();
      SharedPreferenceUtil.setAccountPasswordState(paramInt1);
    }
  }
  
  void notifyGotoReadNote(int paramInt, String paramString)
  {
    Object localObject1 = null;
    if (paramString == null)
    {
      QMLog.log(6, "webpush", "notifyGotoReadNote noteId_null");
      return;
    }
    String str1 = QMApplicationContext.sharedInstance().getString(2131690411);
    String str2 = QMApplicationContext.sharedInstance().getString(2131696309);
    paramString = LaunchWebPush.createNoteIntent(paramInt, paramString, "from_send_text", QMApplicationContext.sharedInstance().getString(2131690287));
    PendingIntent localPendingIntent = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), paramInt, paramString, 134217728);
    QMLog.log(4, "webpush", "notify goto read note!");
    Object localObject2;
    if (AccountManager.shareInstance().getAccountList().size() >= 1)
    {
      localObject2 = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      paramString = localAccount;
      if (((Account)localObject2).getId() == paramInt)
      {
        paramString = localAccount;
        if (!QMSettingManager.sharedInstance().getNoteDisplay()) {}
      }
    }
    for (paramString = (String)localObject2;; paramString = null)
    {
      localObject2 = QMNotificationConstructor.getInstance();
      if (paramString == null) {}
      for (paramString = localObject1;; paramString = paramString.getEmail())
      {
        ((QMNotificationConstructor)localObject2).notifyPushNote(paramInt, str1, str2, paramString, localPendingIntent);
        if (!AppStatusUtil.isAppOnForeground()) {
          break;
        }
        Threads.runInBackground(new QMPushMailNotify.6(this), 2000L);
        return;
      }
    }
  }
  
  void notifyImagePush(PushWebAttach paramPushWebAttach)
  {
    if (paramPushWebAttach == null) {}
    String str1;
    String str2;
    Object localObject2;
    do
    {
      return;
      localObject1 = QMApplicationContext.sharedInstance();
      str1 = ((Context)localObject1).getString(2131690411);
      str2 = ((Context)localObject1).getString(2131690271);
      localObject1 = MediaFolderSelectActivity.createIntent(QMAlbumManager.QMMediaIntentType.QMMediaIntentType_PUSH, QMApplicationContext.sharedInstance().getString(2131695697));
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("fromPush", true);
      ((Bundle)localObject2).putBoolean("fromBgPush", true);
      ((Bundle)localObject2).putParcelable("body", paramPushWebAttach);
      ((Intent)localObject1).setFlags(536870912);
      ((Intent)localObject1).addFlags(2);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setAction(String.valueOf(System.currentTimeMillis()));
      localObject2 = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject1, 134217728);
    } while (AppStatusUtil.isAppOnForeground());
    if (AccountManager.shareInstance().getAccountList().size() > 1) {}
    for (Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramPushWebAttach.getAccountId());; localObject1 = null)
    {
      QMNotificationConstructor localQMNotificationConstructor = QMNotificationConstructor.getInstance();
      int i = paramPushWebAttach.getAccountId();
      if (localObject1 == null) {}
      for (paramPushWebAttach = null;; paramPushWebAttach = ((Account)localObject1).getEmail())
      {
        localQMNotificationConstructor.notifyPushImage(i, str1, str2, paramPushWebAttach, (PendingIntent)localObject2);
        return;
      }
    }
  }
  
  public void notifyNewMail(@NonNull PushMailBody paramPushMailBody)
  {
    long l = System.currentTimeMillis() / 1000L - paramPushMailBody.fromtime;
    if (l > 432000L) {
      QMLog.log(5, "QMPushMailNotify", "notifyNewMail, mail is out of time, do not notify, interval: " + l + "s, mailBody: " + paramPushMailBody);
    }
    do
    {
      return;
      QMLog.log(4, "QMPushMailNotify", "notifyNewMail, foreground: " + AppStatusUtil.isAppOnForeground() + ", mailBody: " + paramPushMailBody);
      this.mPostMailTask.offerNewMail(paramPushMailBody);
      showMailNotification();
    } while (!AppStatusUtil.isAppOnForeground());
    this.mCancelMailTask.offerCancelMail(paramPushMailBody);
    cancelMailNotification(3000L);
  }
  
  void notifyScanFilePush(PushWebAttach paramPushWebAttach)
  {
    if (paramPushWebAttach == null) {}
    String str1;
    String str2;
    PendingIntent localPendingIntent;
    do
    {
      return;
      localObject = QMApplicationContext.sharedInstance();
      str1 = ((Context)localObject).getString(2131690411);
      str2 = ((Context)localObject).getString(2131719026);
      localObject = new Intent(QMApplicationContext.sharedInstance(), QMNotificationService.class);
      ((Intent)localObject).setData(Uri.parse(String.format(Locale.getDefault(), "%s://%s", new Object[] { "qqmail", "scan_file" })));
      localPendingIntent = PendingIntent.getService(QMApplicationContext.sharedInstance(), 0, (Intent)localObject, 134217728);
    } while (AppStatusUtil.isAppOnForeground());
    KvHelper.eventScanPushShow(new double[0]);
    if (AccountManager.shareInstance().getAccountList().size() > 1) {}
    for (Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramPushWebAttach.getAccountId());; localObject = null)
    {
      QMNotificationConstructor localQMNotificationConstructor = QMNotificationConstructor.getInstance();
      int i = paramPushWebAttach.getAccountId();
      if (localObject == null) {}
      for (paramPushWebAttach = null;; paramPushWebAttach = ((Account)localObject).getEmail())
      {
        localQMNotificationConstructor.notifyPushScanFile(i, str1, str2, paramPushWebAttach, localPendingIntent);
        return;
      }
    }
  }
  
  void notifySchema(PushSchemaBody paramPushSchemaBody)
  {
    Object localObject = LaunchWebPush.createPushSchemaIntent(paramPushSchemaBody.getSchema());
    localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 0, (Intent)localObject, 134217728);
    QMNotificationConstructor.getInstance().notifyPushSchema(paramPushSchemaBody, (PendingIntent)localObject);
  }
  
  public void showMailNotification()
  {
    Threads.runInBackgroundIfNotExist(this.mPostMailTask, 500L);
  }
  
  public void vibrate()
  {
    if ((QMServiceManager.hasVibrate()) && (this.mAudioManager.getRingerMode() != 0)) {
      ((Vibrator)QMApplicationContext.sharedInstance().getSystemService("vibrator")).vibrate(new long[] { 250L, 250L, 250L, 250L }, -1);
    }
  }
  
  class CancelMailTask
    implements Runnable
  {
    Queue<PushMailBody> mailQueue = new ConcurrentLinkedQueue();
    
    private CancelMailTask() {}
    
    void offerCancelMail(PushMailBody paramPushMailBody)
    {
      this.mailQueue.offer(paramPushMailBody);
    }
    
    public void run()
    {
      while (!this.mailQueue.isEmpty())
      {
        PushMailBody localPushMailBody = (PushMailBody)this.mailQueue.poll();
        QMPushMailNotify.this.cancelNotifyNewMail(localPushMailBody.accountId, localPushMailBody.remoteId, QMPushMailNotify.this.getMailPushNotificationId(localPushMailBody.nMailId));
      }
    }
  }
  
  class PostMailTask
    implements Runnable
  {
    Queue<PushMailBody> mailQueue = new ConcurrentLinkedQueue();
    
    private PostMailTask() {}
    
    void offerNewMail(PushMailBody paramPushMailBody)
    {
      this.mailQueue.offer(paramPushMailBody);
    }
    
    int postNewMail(Set<Integer> paramSet)
    {
      int i = 0;
      for (;;)
      {
        synchronized (QMPushMailNotify.this.mContentData)
        {
          if (!this.mailQueue.isEmpty())
          {
            PushMailBody localPushMailBody = (PushMailBody)this.mailQueue.poll();
            List localList = (List)QMPushMailNotify.this.mContentData.get(localPushMailBody.accountId);
            Object localObject = localList;
            if (localList == null)
            {
              localObject = new ArrayList();
              QMPushMailNotify.this.mContentData.put(localPushMailBody.accountId, localObject);
            }
            ((List)localObject).add(localPushMailBody);
            paramSet.add(Integer.valueOf(localPushMailBody.folderid));
            if (!localPushMailBody.notified) {
              QMPushMailNotify.this.notifyNewMailWithExpanding(localPushMailBody, 1, false, true, true);
            }
          }
          else
          {
            if (i > 0) {
              QMPushMailNotify.this.saveContentData();
            }
            return i;
          }
        }
        i += 1;
      }
    }
    
    int postOldMail(Set<Integer> paramSet, boolean paramBoolean, AtomicBoolean paramAtomicBoolean)
    {
      int j = 0;
      int i = 0;
      long l4 = System.currentTimeMillis();
      long l2 = l4 - QMServiceManager.getWebPushSP().getLong("last_notify_old_mail_time", 0L);
      boolean bool3;
      boolean bool2;
      long l3;
      long l1;
      label84:
      boolean bool1;
      if ((paramBoolean) || (l2 >= 3600000L) || (BrandUtil.isColorOS()))
      {
        bool3 = true;
        bool2 = false;
        l3 = l4 - QMServiceManager.getWebPushSP().getLong("last_ring_time", 0L);
        if (!bool3) {
          break label513;
        }
        if (!BrandUtil.isColorOS()) {
          break label358;
        }
        l1 = 1800000L;
        if (l3 >= l1) {
          break label366;
        }
        bool1 = true;
        label95:
        if (!bool1) {
          QMServiceManager.getWebPushEditor().putLong("last_ring_time", l4).apply();
        }
        QMServiceManager.getWebPushEditor().putLong("last_notify_old_mail_time", l4).apply();
        bool2 = bool1;
        if (QMPushMailNotify.this.mContentData.size() <= 0) {
          break label513;
        }
        l1 = l4 / 1000L;
      }
      for (;;)
      {
        int k;
        PushMailBody localPushMailBody;
        synchronized (QMPushMailNotify.this.mContentData)
        {
          int m = QMPushMailNotify.this.mContentData.size();
          if (m <= 0) {
            break label415;
          }
          k = 0;
          j = i;
          if (k >= m) {
            break label415;
          }
          Object localObject = (List)QMPushMailNotify.this.mContentData.valueAt(k);
          if ((localObject == null) || (((List)localObject).size() <= 0)) {
            break label529;
          }
          localObject = ((List)localObject).iterator();
          j = i;
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break label529;
          }
          localPushMailBody = (PushMailBody)((Iterator)localObject).next();
          paramSet.add(Integer.valueOf(localPushMailBody.folderid));
          l4 = l1 - localPushMailBody.fromtime;
          if (l4 <= 432000L) {
            break label372;
          }
          QMLog.log(5, "QMPushMailNotify", "postOldMail, mail is out of time, do not notify, interval: " + l4 + "s, mailBody: " + localPushMailBody);
        }
        bool3 = false;
        break;
        label358:
        l1 = 21600000L;
        break label84;
        label366:
        bool1 = false;
        break label95;
        label372:
        QMPushMailNotify localQMPushMailNotify = QMPushMailNotify.this;
        if ((!paramBoolean) && (paramAtomicBoolean.getAndSet(false))) {}
        for (bool2 = true;; bool2 = false)
        {
          localQMPushMailNotify.notifyNewMailWithExpanding(localPushMailBody, 1, bool1, false, bool2);
          j += 1;
          break;
          for (;;)
          {
            label415:
            QMLog.log(4, "QMPushMailNotify", "postOldMail, need: " + bool3 + ", hasNewMail: " + paramBoolean + ", silent: " + bool1 + ", (" + l2 + "/" + 3600000L + "ms, " + l3 + "/" + 21600000L + "ms)");
            return j;
            label513:
            j = 0;
            bool1 = bool2;
          }
        }
        label529:
        k += 1;
      }
    }
    
    public void run()
    {
      boolean bool = true;
      Threads.removeCallbackInBackground(this);
      Object localObject = new AtomicBoolean(true);
      QMPushMailNotify.this.updateContentDataFromFile();
      HashSet localHashSet = new HashSet();
      if (!this.mailQueue.isEmpty()) {}
      for (;;)
      {
        int i = postOldMail(localHashSet, bool, (AtomicBoolean)localObject);
        int j = postNewMail(localHashSet);
        QMLog.log(4, "QMPushMailNotify", "post mail notification, total: " + (i + j) + ", new: " + j + ", old: " + i + ", environment: " + QMPushMailNotify.this.environment());
        QMPushMailNotify.this.updateBadge();
        localObject = localHashSet.iterator();
        while (((Iterator)localObject).hasNext())
        {
          i = ((Integer)((Iterator)localObject).next()).intValue();
          QMFolderManager.sharedInstance().setFolderHasNew(i);
        }
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify
 * JD-Core Version:    0.7.0.1
 */