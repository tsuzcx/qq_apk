import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import mqq.app.MSFServlet;

public class amzo
  extends amzq
{
  private aefh a = new amzp(this);
  private QQAppInterface app;
  private boolean cEx;
  public boolean cEy;
  boolean cEz = true;
  private QQNotificationManager d;
  private int dEI;
  private Random random = new Random();
  
  public amzo(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    init();
  }
  
  private void PC(boolean paramBoolean) {}
  
  private void Q(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    paramToServiceMsg = a((Intent)paramToServiceMsg.extraData.getParcelable("intent"), localBitmap, arrayOfString[1], arrayOfString[2]);
    paramToServiceMsg.flags = 34;
    init();
    QLog.i("MobileQQService", 1, "showNotCancelNotification nf=" + paramToServiceMsg);
    a(275, paramToServiceMsg, this.app.getCurrentUin(), 0);
  }
  
  private void R(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Intent localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    boolean bool = localIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    Object localObject1;
    int j;
    String str;
    int i;
    if (!aqoq.cVi)
    {
      paramToServiceMsg = aqoo.a().a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2], this.cEx, this.app);
      paramToServiceMsg.deleteIntent = a(localIntent);
      init();
      localObject1 = localIntent.getStringExtra("param_fromuin");
      j = localIntent.getIntExtra("uintype", -1);
      str = localIntent.getStringExtra("KEY_FRIEND_UIN");
      if (j != -1) {
        break label373;
      }
      i = localIntent.getIntExtra("param_uinType", -1);
      label149:
      if (!SettingCloneUtil.readValue(BaseApplication.getContext(), this.app.getCurrentAccountUin(), BaseApplication.getContext().getString(2131718988), "qqsetting_notify_showcontent_key", true)) {
        break label1228;
      }
      if (j != 1008) {
        break label378;
      }
      if (this.d != null) {
        this.d.cancel("MobileQQService.showMsgNotification", 267);
      }
      a(267, paramToServiceMsg, (String)localObject1, i);
    }
    label1228:
    for (;;)
    {
      paramToServiceMsg = new Intent("com.tencent.msg.newmessage");
      paramToServiceMsg.setPackage("com.tencent.tim");
      paramToServiceMsg.putExtra("cmds", arrayOfString);
      paramToServiceMsg.putExtra("intent", localIntent);
      paramToServiceMsg.putExtra("type", 0);
      paramToServiceMsg.putExtra("bitmap", localBitmap);
      this.app.getApp().sendBroadcast(paramToServiceMsg);
      return;
      if (aqoq.cVq)
      {
        localObject1 = a(localIntent, null, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        i = this.app.cr("icon");
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (i <= 0) {
          break;
        }
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (((Notification)localObject1).contentView == null) {
          break;
        }
        ((Notification)localObject1).contentView.setImageViewBitmap(i, localBitmap);
        paramToServiceMsg = (ToServiceMsg)localObject1;
        break;
      }
      paramToServiceMsg = a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      break;
      label373:
      i = j;
      break label149;
      label378:
      if ((bool) && (j == 1010))
      {
        if (this.d != null) {
          this.d.cancel("MobileQQService.showMsgNotification", 272);
        }
        a(272, paramToServiceMsg, (String)localObject1, i);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_DATE_UNREAD notify");
        }
      }
      else if (((bool) && (j == 1001)) || (j == 10002))
      {
        if (this.d != null) {
          this.d.cancel("MobileQQService.showMsgNotification", 268);
        }
        a(268, paramToServiceMsg, (String)localObject1, i);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_LBS_FRIEND_UNREAD notify");
        }
      }
      else if (localIntent.getBooleanExtra("qav_notify_flag", false))
      {
        if (this.d != null) {
          this.d.cancel("MobileQQService.showMsgNotification", 236);
        }
        a(236, paramToServiceMsg, (String)localObject1, i);
      }
      else if (j == 3001)
      {
        if (this.d != null) {
          this.d.cancel("MobileQQService.showMsgNotification", 271);
        }
        a(271, paramToServiceMsg, (String)localObject1, i);
      }
      else if ((j == 1037) || (j == 1044) || (j == 1045))
      {
        if (this.d != null)
        {
          this.d.cancel("MobileQQService.showMsgNotification", 275);
          this.d.cancel("MobileQQService.showMsgNotification", 266);
        }
        a(266, paramToServiceMsg, (String)localObject1, i);
      }
      else if (localIntent.getBooleanExtra("activepull_push_flag", false))
      {
        if (this.d != null) {
          this.d.cancel("MobileQQService.showMsgNotification", 269);
        }
        a(269, paramToServiceMsg, (String)localObject1, i);
      }
      else if (j == 1030)
      {
        str = localIntent.getStringExtra("campus_notice_tag");
        j = localIntent.getIntExtra("campus_notice_id", 0);
        Object localObject2 = new anop.a();
        ((anop.a)localObject2).Ur = "0X800923F";
        ((anop.a)localObject2).Uq = "Android系统通知曝光";
        if (QLog.isColorLevel()) {
          QLog.d("CampusNoticeManager", 2, new Object[] { "notification url :", localIntent.getStringExtra("url") });
        }
        anop.a(localIntent.getStringExtra("url"), (anop.a)localObject2);
        anop.a(this.app, (anop.a)localObject2);
        localObject2 = (aeam)this.app.getManager(240);
        a(str, j, paramToServiceMsg, (String)localObject1, i);
        if (QLog.isColorLevel()) {
          QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "show campus_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
        }
      }
      else if ((j == 1035) || (j == 1041) || (j == 1042))
      {
        str = localIntent.getStringExtra("push_notice_tag");
        j = localIntent.getIntExtra("param_notifyid", 0);
        aizd.a(this.app, localIntent.getStringExtra("push_notice_service_id"), localIntent.getStringExtra("push_notice_content_id"), localIntent.getStringExtra("url"), "0X800923F", "Android系统通知曝光");
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, new Object[] { "notification url :", localIntent.getStringExtra("url") });
        }
        a(str, j, paramToServiceMsg, (String)localObject1, i);
        if (Build.VERSION.SDK_INT >= 19) {
          this.app.cLD();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, String.format(Locale.getDefault(), "show push_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
        }
      }
      else if (j == 7225)
      {
        a(localIntent.getStringExtra("push_notice_tag"), localIntent.getIntExtra("param_notifyid", 0), paramToServiceMsg, (String)localObject1, i);
      }
      else
      {
        if ((j == 0) && (localIntent.getBooleanExtra("key_reactive_push_tip", false))) {
          anot.a(this.app, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
        }
        if ((ausb.ne(j)) && (ausb.tb(str)))
        {
          j = localIntent.getIntExtra("param_notifyid", 0);
          UF(275);
          a(j, paramToServiceMsg, (String)localObject1, i);
        }
        else
        {
          if (this.d != null)
          {
            this.d.cancel("MobileQQService.showMsgNotification", 265);
            this.d.cancel("MobileQQService.showMsgNotification", 275);
          }
          a(265, paramToServiceMsg, (String)localObject1, i);
          continue;
          if (localIntent.getBooleanExtra("qav_notify_flag", false))
          {
            if (this.d != null) {
              this.d.cancel("MobileQQService.showMsgNotification", 236);
            }
            a(236, paramToServiceMsg, (String)localObject1, i);
          }
          else if (j == 1030)
          {
            str = localIntent.getStringExtra("campus_notice_tag");
            j = localIntent.getIntExtra("campus_notice_id", 0);
            if (QLog.isColorLevel()) {
              QLog.d("MobileQQService", 2, String.format(Locale.getDefault(), "show campus_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
            }
            a(str, j, paramToServiceMsg, (String)localObject1, i);
          }
          else if ((j == 1035) || (j == 1041) || (j == 1042))
          {
            str = localIntent.getStringExtra("push_notice_tag");
            j = localIntent.getIntExtra("param_notifyid", 0);
            aizd.a(this.app, localIntent.getStringExtra("push_notice_service_id"), localIntent.getStringExtra("push_notice_content_id"), localIntent.getStringExtra("url"), "0X800923F", "Android系统通知曝光");
            if (QLog.isColorLevel()) {
              QLog.d("MobileQQService", 2, String.format(Locale.getDefault(), "show push_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
            }
            a(str, j, paramToServiceMsg, (String)localObject1, i);
            if (Build.VERSION.SDK_INT >= 19) {
              this.app.cLD();
            }
          }
          else if ((j == 1037) || (j == 1045) || (j == 1044))
          {
            if (this.d != null) {
              this.d.cancel("MobileQQService.showMsgNotification", 266);
            }
            a(266, paramToServiceMsg, (String)localObject1, i);
          }
          else
          {
            if ((j == 0) && (localIntent.getBooleanExtra("key_reactive_push_tip", false))) {
              anot.a(this.app, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
            }
            if ((ausb.ne(j)) && (ausb.tb(str)))
            {
              j = localIntent.getIntExtra("param_notifyid", 0);
              UF(275);
              a(j, paramToServiceMsg, (String)localObject1, i);
            }
            else
            {
              if (this.d != null)
              {
                this.d.cancel("MobileQQService.showMsgNotification", 265);
                this.d.cancel("MobileQQService.showMsgNotification", 275);
              }
              a(265, paramToServiceMsg, (String)localObject1, i);
            }
          }
        }
      }
    }
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    paramIntent.putExtra("param_notifyid", 275);
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_HIDE_BADGE").setSmallIcon(2130842268).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
    localBuilder.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramIntent);
    if (paramBitmap != null) {
      localBuilder.setLargeIcon(paramBitmap);
    }
    return localBuilder.build();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = this.app.abi();
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    PendingIntent localPendingIntent;
    int j;
    if ((i >= 512) && (i <= 522))
    {
      localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 134217728);
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "buildNotification by getActivity. contentIntent=" + localPendingIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification url :", paramIntent.getStringExtra("url") });
      }
      j = paramIntent.getIntExtra("uintype", -1);
      if (j != 1008) {
        break label494;
      }
      if (acbn.bkr.equals(paramIntent.getStringExtra("uin"))) {
        break label752;
      }
      if (!paramIntent.getBooleanExtra("activepull_push_flag", false)) {
        break label482;
      }
      i = 2130842268;
      paramIntent = "CHANNEL_ID_SHOW_BADGE";
    }
    for (;;)
    {
      label168:
      Object localObject;
      if ((j == 1037) || (j == 1045) || (j == 1044))
      {
        localObject = "CHANNEL_ID_LIMIT_CHAT";
        label197:
        paramIntent = NotificationFactory.createNotificationCompatBuilder((String)localObject).setSmallIcon(i).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
        if ((j != 1030) && (j != 1035) && (j != 1041) && (j != 1042) && (bool)) {
          paramIntent.setOngoing(true);
        }
        if (aqem.c(BaseApplication.getContext(), this.app))
        {
          Calendar.getInstance().get(11);
          paramIntent.setLights(-16711936, 2000, 2000);
        }
        if (!this.cEx) {
          break label722;
        }
        if (paramBitmap != null) {
          paramIntent.setLargeIcon(paramBitmap);
        }
        paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
      }
      for (;;)
      {
        if (!this.cEy)
        {
          this.cEy = true;
          this.cEz = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).getBoolean(this.app.getAccount() + "_" + "heads_up_notify_switch", true);
          if (QLog.isColorLevel()) {
            QLog.i("MobileQQService", 2, "notify init priority flag, " + this.cEz);
          }
        }
        if ((Build.VERSION.SDK_INT >= 24) || (this.cEz)) {
          paramIntent.setPriority(1).setVibrate(new long[0]);
        }
        return paramIntent.build();
        localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
        break;
        label482:
        i = 2130842599;
        paramIntent = "CHANNEL_ID_SHOW_BADGE";
        break label168;
        label494:
        if (j == 1030)
        {
          i = paramIntent.getIntExtra("campus_notice_id", 100);
          paramBitmap = aqcu.decodeResource(BaseApplication.getContext().getResources(), 2130840732);
          localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 268435456);
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_CAMPUS_NOTICE url :", paramIntent.getStringExtra("url") });
          }
          i = 2130842268;
          paramIntent = "CHANNEL_ID_SHOW_BADGE";
          break label168;
        }
        if ((j != 1035) && (j != 1041) && (j != 1042)) {
          break label752;
        }
        i = paramIntent.getIntExtra("param_notifyid", 100);
        paramBitmap = BaseApplication.getContext();
        localObject = "CHANNEL_ID_OTHER";
        paramBitmap = aqcu.decodeResource(paramBitmap.getResources(), 2130840732);
        localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 268435456);
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_PUSH_NOTICE url :", paramIntent.getStringExtra("url") });
        }
        i = 2130842268;
        paramIntent = (Intent)localObject;
        break label168;
        localObject = paramIntent;
        if (j != 1) {
          break label197;
        }
        localObject = paramIntent;
        if (!SdkInfoUtil.isAndroidQ()) {
          break label197;
        }
        localObject = paramIntent;
        break label197;
        label722:
        paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
        if (paramBitmap != null) {
          paramIntent.setLargeIcon(paramBitmap);
        }
      }
      label752:
      i = 2130842268;
      paramIntent = "CHANNEL_ID_SHOW_BADGE";
    }
  }
  
  private PendingIntent a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    paramIntent = new Intent(BaseApplication.getContext(), NotificationDeleteReceiver.class);
    paramIntent.putExtra("uin", str);
    paramIntent.putExtra("param_notifyid", i);
    return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, paramIntent, 268435456);
  }
  
  void UF(int paramInt)
  {
    if ((this.d != null) && (this.app.getApplication() != null)) {}
    try
    {
      this.d.cancel("MobileQQService.stopForegroundCompat", paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void a(int paramInt1, Notification paramNotification, String paramString, int paramInt2)
  {
    a(null, paramInt1, paramNotification, paramString, paramInt2);
  }
  
  void a(String paramString1, int paramInt1, Notification paramNotification, String paramString2, int paramInt2)
  {
    int k = 0;
    if (this.d != null) {}
    int j;
    for (;;)
    {
      try
      {
        QQMessageFacade localQQMessageFacade = this.app.b();
        alkm localalkm = this.app.a();
        if (localalkm == null) {
          break label305;
        }
        i = localalkm.HD();
        if (localQQMessageFacade == null) {
          break label299;
        }
        j = localQQMessageFacade.bl();
        if (!TextUtils.isEmpty(paramString1)) {
          break label362;
        }
        if (paramInt1 == 265) {
          break;
        }
        if ((paramInt1 < 512) || (paramInt1 > 522)) {
          break label355;
        }
      }
      catch (Throwable paramString1)
      {
        if (!QLog.isColorLevel()) {
          break label354;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BadgeUtilImpl", 2, "startForegroundCompat changeMI6Badge count=" + i);
      }
      if (auqw.isSupportBadge(BaseApplicationImpl.getApplication().getApplicationContext())) {
        auqw.setMIUI6Badge(this.app.getApp(), i, paramNotification);
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        this.d.notifyUseTag("MobileQQService.startForegroundCompat", paramString1, paramNotification, this.d.createNotifyBundle(paramInt1, paramString2, paramInt2));
        return;
      }
      this.d.notify("MobileQQService.startForegroundCompat", paramNotification, this.d.createNotifyBundle(paramInt1, paramString2, paramInt2));
      return;
      QLog.i("MobileQQService", 2, "startForegroundCompat exception. id=" + paramInt1 + ", mNM=" + this.d, paramString1);
      return;
      if (!QLog.isColorLevel()) {
        break label354;
      }
      QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt1 + ", mNM=" + this.d);
      return;
      label292:
      i = j;
      continue;
      label299:
      j = 0;
      continue;
      label305:
      i = 0;
    }
    int i = j;
    for (;;)
    {
      j = i;
      if (paramInt1 >= 482)
      {
        j = i;
        if (paramInt1 <= 511) {
          j = 0;
        }
      }
      if (paramInt1 != 266) {
        break label292;
      }
      i = k;
      break;
      label354:
      return;
      label355:
      if (paramInt1 != 236) {
        label362:
        i = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = this.app.getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if ((paramException == null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && ("ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))) {
        this.app.a.cNp();
      }
    }
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  protected void aTq()
  {
    try
    {
      super.aTq();
      a(new axbh(this.app));
      a(new andj(this.app));
      a(new anai(this.app));
      a(new anbj(this.app));
      a(new anau(this.app));
      a(new andq());
      andl localandl = new andl();
      a(localandl);
      localandl.a(this.a);
      a(new anad());
      a(new andu());
      a(new anah());
      a(new amzv(this.app));
      a(new anaa());
      a(new anac());
      a(new jot(this.app));
      a(new andn());
      a(new ando());
      a(new amzz());
      a(new andm());
      a(new andy(this.app));
      super.dOJ();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, aefh paramaefh, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return;
      paramClass = paramToServiceMsg.getServiceCmd();
      if (!"CMD_SHOW_NOTIFIYCATION".equals(paramClass)) {
        break;
      }
      if (!((PhoneContactManagerImp)this.app.getManager(11)).Un())
      {
        R(paramToServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MobileQQService", 2, "pcm blocked msg notification");
    return;
    if ("CMD_IDLE_NOTIFIYCATION".equals(paramClass))
    {
      this.app.cLN();
      Q(paramToServiceMsg);
      return;
    }
    if ("CMD_STOP_NOTIFIYCATION".equals(paramClass))
    {
      this.app.cLN();
      UF(275);
      return;
    }
    if ("CMD_CANCLE_NOTIFIYCATION".equals(paramClass))
    {
      cancelNotification(275);
      return;
    }
    super.b(paramToServiceMsg, paramaefh, aefj.class);
  }
  
  void cancelNotification(int paramInt)
  {
    if (this.d != null) {
      this.d.cancel("MobileQQService.cancelNotification", paramInt);
    }
  }
  
  public void destroy()
  {
    PC(false);
    UF(275);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    this.a = null;
    super.destroy();
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg, this.a, aefj.class);
  }
  
  public AppInterface getAppInterface()
  {
    return this.app;
  }
  
  protected void i(FromServiceMsg paramFromServiceMsg)
  {
    aiyy.a().a(paramFromServiceMsg, this.app);
  }
  
  public void init()
  {
    if ((this.d == null) && (this.dEI < 3)) {}
    try
    {
      this.cEx = aqgz.aCC();
      PC(true);
      this.d = QQNotificationManager.getInstance();
      if (this.d == null) {
        this.d = QQNotificationManager.getInstance();
      }
      seq = Math.abs(this.random.nextInt());
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "MobileQQService has created. mNM=" + this.d);
      }
      this.dEI += 1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "e = " + localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     amzo
 * JD-Core Version:    0.7.0.1
 */