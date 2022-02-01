import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;

public class afde
{
  RecentItemVoteData a;
  QQAppInterface app;
  MessageForText b;
  
  public afde(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private Intent d(Context paramContext)
  {
    String str = String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10002&from_type=0&mode=2&source_id=1001&uid=%s&PUSH_CONTENT=%s", new Object[] { this.app.getCurrentAccountUin(), this.a.mTitleName });
    paramContext = new Intent(paramContext, JumpActivity.class);
    paramContext.setData(Uri.parse(str));
    return paramContext;
  }
  
  private void hZ()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    boolean bool = aqlr.isScreenLocked(localBaseApplication);
    Object localObject1;
    if ((this.app.isBackground_Pause) || (this.app.isBackground_Stop) || (bool))
    {
      Object localObject2 = aqcu.decodeResource(localBaseApplication.getResources(), 2130846243);
      localObject1 = new NotificationCompat.Builder(localBaseApplication).setContentTitle(this.a.mTitleName).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker(this.a.mTitleName).setWhen(System.currentTimeMillis());
      if (localObject2 != null) {
        ((NotificationCompat.Builder)localObject1).setLargeIcon((Bitmap)localObject2);
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject1).setSmallIcon(2130846243);
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject2 = new RemoteViews(localBaseApplication.getPackageName(), 2131561297);
        ((NotificationCompat.Builder)localObject1).setContent((RemoteViews)localObject2);
        ((RemoteViews)localObject2).setCharSequence(2131379769, "setText", this.a.mTitleName);
        ((RemoteViews)localObject2).setCharSequence(2131379661, "setText", aqmu.a(System.currentTimeMillis(), true, "yyyy-MM-dd"));
      }
      localObject2 = d(localBaseApplication);
      ((Intent)localObject2).putExtra("param_notifyid", 240);
      ((NotificationCompat.Builder)localObject1).setContentIntent(PendingIntent.getActivity(localBaseApplication, 0, (Intent)localObject2, 134217728));
      localObject1 = ((NotificationCompat.Builder)localObject1).build();
      ((Notification)localObject1).flags |= 0x10;
      ((Notification)localObject1).defaults |= 0x1;
      ((Notification)localObject1).defaults |= 0x4;
      ((Notification)localObject1).icon = 2130846243;
      localObject2 = QQNotificationManager.getInstance();
      if (localObject2 != null)
      {
        ((QQNotificationManager)localObject2).cancel("nearby_like_notification_tag", 240);
        ((QQNotificationManager)localObject2).notify("nearby_like_notification_tag", 240, (Notification)localObject1);
      }
      anot.a(this.app, "CliOper", "", "", "0X80053CD", "0X80053CD", 0, 0, "", "", "", "");
    }
    if (bool)
    {
      localObject1 = (aizf)this.app.getManager(72);
      if (SettingCloneUtil.readValue(localBaseApplication, this.app.getCurrentAccountUin(), localBaseApplication.getString(2131695500), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface VoteEventMgr.notifyVoteEvent");
        }
        ((aizf)localObject1).a(this.app, acbn.blc, 1012, false, aizb.a(acbn.blc, 1012, null));
      }
      this.app.b().notifyObservers(b());
    }
  }
  
  public MessageForText a(RecentBaseData paramRecentBaseData)
  {
    paramRecentBaseData = (RecentItemVoteData)paramRecentBaseData;
    if (this.b == null)
    {
      this.b = ((MessageForText)anbi.d(-1000));
      this.b.msgtype = -1000;
      this.b.istroop = 1012;
      this.b.isread = false;
      this.b.selfuin = this.app.getCurrentAccountUin();
      this.b.senderuin = acbn.bkY;
      this.b.frienduin = acbn.bkY;
      this.b.msg = paramRecentBaseData.mTitleName;
      this.b.time = paramRecentBaseData.time;
    }
    if ((this.b.msg == null) || (!this.b.msg.equals(paramRecentBaseData.mTitleName))) {
      this.b.msg = paramRecentBaseData.mTitleName;
    }
    if (this.b.time != paramRecentBaseData.time) {
      this.b.time = paramRecentBaseData.time;
    }
    return this.b;
  }
  
  public void a(SubMsgType0x6f.MCardNotificationLike paramMCardNotificationLike)
  {
    String str2 = "";
    String str1 = str2;
    if (paramMCardNotificationLike != null)
    {
      str1 = str2;
      if (paramMCardNotificationLike.str_wording.has()) {
        str1 = paramMCardNotificationLike.str_wording.get();
      }
    }
    if (TextUtils.isEmpty(str1)) {}
    long l;
    do
    {
      return;
      l = anaz.gQ();
      if (this.a == null)
      {
        paramMCardNotificationLike = new RecentUser(acbn.blc, 1012);
        paramMCardNotificationLike.msgType = 1012;
        this.a = new RecentItemVoteData(paramMCardNotificationLike);
        this.a.init(str1, l);
        hZ();
        return;
      }
    } while ((this.a.mTitleName.equals(str1)) && (this.a.time == l));
    this.a.init(str1, l);
    hZ();
  }
  
  public void aIH()
  {
    this.a = null;
    BaseApplicationImpl.getContext();
    QQNotificationManager.getInstance().cancel("nearby_like_notification_tag", 240);
  }
  
  public RecentBaseData b()
  {
    return this.a;
  }
  
  public int getUnreadCount()
  {
    if (this.a == null) {
      return 0;
    }
    return 1;
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.getContext();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null) {
      localQQNotificationManager.cancel("nearby_like_notification_tag", 240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afde
 * JD-Core Version:    0.7.0.1
 */