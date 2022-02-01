import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.mini.push.MiniAppPushControl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

public class aneb
  extends MSFServlet
  implements avzi
{
  public static volatile List<avyv> Gt;
  private static final String[] gy = { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
  public static volatile HashMap<Integer, anfd> ni = new HashMap();
  
  private void UI(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultcode", String.valueOf(paramInt));
    localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
    anpc.a(BaseApplication.getContext()).collectPerformance(localQQAppInterface.getAccount(), "callqzonefrompushv2", true, 0L, 0L, localHashMap, null, true);
  }
  
  private void a(anfd paramanfd)
  {
    QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {}
    while ((paramanfd == null) || (paramanfd.data == null)) {
      return;
    }
    if ((paramanfd.data != null) && (paramanfd.data.get("utime") != null) && (LocalMultiProcConfig.getInt4Uin("qzone_preget_passive_open", 0, localQQAppInterface.getLongAccountUin()) == 1))
    {
      String str = (String)paramanfd.data.get("utime");
      if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", localQQAppInterface.getLongAccountUin()).equals(str))
      {
        paramanfd.cFd = true;
        int i = avzf.a().a().ax(localQQAppInterface.getLongAccountUin());
        ni.put(Integer.valueOf(i), paramanfd);
      }
    }
    b(paramanfd);
  }
  
  public static void a(anfd paramanfd, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramanfd == null) {
      return;
    }
    if (paramQQAppInterface != null) {}
    for (long l1 = Long.parseLong(paramQQAppInterface.getAccount());; l1 = 0L)
    {
      long l2 = paramLong;
      NewIntent localNewIntent;
      if (paramanfd.addTime != 0L)
      {
        l2 = paramLong;
        if (l1 != 0L)
        {
          localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), anet.class);
          localNewIntent.putExtra("timestamp", paramanfd.addTime);
          localNewIntent.putExtra("hostuin", l1);
          if (!paramanfd.cFe) {
            break label220;
          }
        }
      }
      label220:
      for (paramLong = 1L | paramLong;; paramLong = 0xFFFFFFFE & paramLong)
      {
        String str2 = paramanfd.mark;
        String str1;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (!str2.equals("0")) {}
        }
        else
        {
          str1 = str2;
          if (paramanfd.data != null) {
            str1 = (String)paramanfd.data.get("pushstatkey");
          }
        }
        localNewIntent.putExtra("mark", str1);
        localNewIntent.putExtra("flag", paramLong);
        paramQQAppInterface.startServlet(localNewIntent);
        l2 = paramLong;
        QLog.e("CliNotifyPush", 1, "sentQzoneMsfPushAck: localTimeStamp=" + paramanfd.addTime + " uin=" + l1 + " flag=" + l2);
        return;
      }
    }
  }
  
  private void a(anfd paramanfd, boolean paramBoolean)
  {
    if ((paramanfd == null) || (paramanfd.data == null)) {
      QLog.e("CliNotifyPush", 1, "showRedTouch failed sm=null");
    }
    Object localObject1;
    aneo localaneo;
    do
    {
      return;
      localObject1 = (QQAppInterface)getAppRuntime();
      if (localObject1 == null)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed app=null");
        return;
      }
      localaneo = (aneo)((QQAppInterface)localObject1).getManager(10);
    } while (localaneo == null);
    for (;;)
    {
      int m;
      try
      {
        int k = Integer.parseInt((String)paramanfd.data.get("pushtype"));
        QLog.i("CliNotifyPush", 1, "showRedTouch type:" + k + ",uin:" + paramanfd.opUin + ",isBackground_Pause:" + ((QQAppInterface)localObject1).isBackground_Pause);
        if ((k != 1) && (k != 300) && (k != 302)) {
          break;
        }
        localObject1 = (String)paramanfd.data.get("conent");
        m = Integer.parseInt((String)paramanfd.data.get("count"));
        l = paramanfd.opUin;
        int i = 0;
        try
        {
          boolean bool = paramanfd.data.containsKey("opuin_qzoneVipLevel");
          if (!bool) {
            break label669;
          }
          i = 1;
          ArrayList localArrayList;
          Object localObject3;
          Object localObject4;
          QZoneCountUserInfo localQZoneCountUserInfo;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label641;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            j = Integer.parseInt((String)paramanfd.data.get("opuin_qzoneVipLevel"));
            i = 1;
            localArrayList = new ArrayList();
            localObject2 = new QZoneCountUserInfo();
            ((QZoneCountUserInfo)localObject2).uin = l;
            ((QZoneCountUserInfo)localObject2).iYellowLevel = j;
            ((QZoneCountUserInfo)localObject2).iYellowType = i;
            paramanfd.extBuffer = awck.Q(paramanfd.extBuffer);
            if (paramanfd.extBuffer != null)
            {
              localObject3 = (PassiveFeedsPush)awck.decodeWup(PassiveFeedsPush.class, paramanfd.extBuffer);
              if ((localObject3 != null) && (((PassiveFeedsPush)localObject3).stBubbleSkin != null) && (((PassiveFeedsPush)localObject3).stBubbleSkin.lUin == l)) {
                ((QZoneCountUserInfo)localObject2).a = ((PassiveFeedsPush)localObject3);
              }
            }
            localArrayList.add(localObject2);
            localObject2 = (String)paramanfd.data.get("shcemaUrlAnd");
          }
          catch (Exception localException2)
          {
            Object localObject2;
            continue;
          }
          try
          {
            paramanfd = (String)paramanfd.data.get("psv_tab_textlist");
            if (!TextUtils.isEmpty(paramanfd))
            {
              paramanfd = new JSONObject(paramanfd);
              paramanfd.getJSONObject("psv_tab_list");
              paramanfd = paramanfd.getJSONObject("psv_tab_list").getJSONArray("text_data");
              i = 0;
              if (i < paramanfd.length())
              {
                localObject4 = (JSONObject)paramanfd.get(i);
                l = ((JSONObject)localObject4).getLong("uin");
                localObject3 = ((JSONObject)localObject4).getString("nk");
                localObject4 = new feed_info(0L, 0L, 0L, ((JSONObject)localObject4).getString("text"));
                localQZoneCountUserInfo = new QZoneCountUserInfo();
                localQZoneCountUserInfo.nickName = ((String)localObject3);
                localQZoneCountUserInfo.uin = l;
                localObject3 = new ArrayList();
                ((ArrayList)localObject3).add(localObject4);
                localQZoneCountUserInfo.vec_feedInfos = ((ArrayList)localObject3);
                localArrayList.add(localQZoneCountUserInfo);
                i += 1;
                continue;
                localException1 = localException1;
                i = 0;
                QLog.i("CliNotifyPush", 2, "parse vip level error");
                j = 0;
              }
            }
          }
          catch (Exception paramanfd)
          {
            QLog.e("CliNotifyPush", 1, "psv_tab_textlist failed" + paramanfd);
            if (k != 302) {
              break label641;
            }
          }
        }
        localaneo.a(1, m, localException1, (String)localObject1, paramBoolean, true, (String)localObject2);
        return;
      }
      catch (Exception paramanfd)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed");
        return;
      }
      label641:
      long l = m;
      localaneo.a(1, l, localException1, (String)localObject1, paramBoolean, true, "");
      return;
      label669:
      int j = 0;
    }
  }
  
  private boolean a(anfd paramanfd)
  {
    boolean bool = false;
    int i = Integer.parseInt((String)paramanfd.data.get("pushtype"));
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject;
    avyv localavyv2;
    if (i == 301) {
      if ((Gt != null) && (Gt.size() > 0))
      {
        localObject = (String)paramanfd.data.get("live_roomid");
        if (localObject != null)
        {
          localavyv2 = (avyv)Gt.get(Gt.size() - 1);
          if ((localavyv2 == null) || (!((String)localObject).equals(localavyv2.roomId))) {
            break label256;
          }
          Gt.remove(localavyv2);
          if (Gt.size() != 0) {
            break label186;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = QQNotificationManager.getInstance();
        if (localObject != null) {
          ((QQNotificationManager)localObject).cancel("CliNotifyPush.clearLivePush", 242);
        }
      }
      catch (Exception localException)
      {
        QLog.e("CliNotifyPush", 1, "NotificationManager cancel exception");
        continue;
      }
      a(paramanfd, localQQAppInterface, 16L);
      bool = true;
      return bool;
      label186:
      avyv localavyv1 = (avyv)Gt.get(Gt.size() - 1);
      if (localavyv1 != null)
      {
        avyt.a().a(localQQAppInterface, 0, null, localavyv1.bbl, null, null, localavyv1.dpv, localavyv1.ezv, localavyv1.actionUrl, localavyv1.pushstatkey, false, false);
        continue;
        label256:
        if (Gt.size() > 1)
        {
          i = 0;
          while (i < Gt.size() - 1)
          {
            localavyv2 = (avyv)Gt.get(i);
            if ((localavyv2 != null) && (localavyv1.equals(localavyv2.roomId))) {
              Gt.remove(localavyv2);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static boolean ac(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  private void an(Map<String, String> paramMap)
  {
    Intent localIntent = new Intent("com.qzone.live.MicLogic.processMicMsg");
    if ((paramMap != null) && ((paramMap instanceof HashMap))) {
      localIntent.putExtra("mic_msg", (HashMap)paramMap);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
  }
  
  public static long b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0);
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + ":" + paramInt, 0L);
        }
      }
    }
    return l1;
  }
  
  private void b(anfd paramanfd)
  {
    QLog.e("CliNotifyPush", 1, "showPush()");
    if ((paramanfd.cFd) && (paramanfd.dFg == 0)) {
      paramanfd.dFg += 1;
    }
    QQAppInterface localQQAppInterface;
    int m;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      m = Integer.parseInt((String)paramanfd.data.get("pushtype"));
      QLog.e("CliNotifyPush", 1, "pushType:" + m);
      if (m == 10000)
      {
        c(paramanfd.data, localQQAppInterface.getAccount());
        a(paramanfd, localQQAppInterface, 16L);
        return;
      }
      if (m == 10100)
      {
        d(paramanfd.data, localQQAppInterface.getAccount());
        a(paramanfd, localQQAppInterface, 16L);
        return;
      }
      if (m == 350)
      {
        a(paramanfd, localQQAppInterface, 16L);
        c(paramanfd);
        return;
      }
    } while (a(paramanfd));
    if (m == 100)
    {
      a(paramanfd, localQQAppInterface, 16L);
      return;
    }
    String str1 = (String)paramanfd.data.get("conent");
    String str2 = (String)paramanfd.data.get("pushstatkey");
    String str3 = (String)paramanfd.data.get("shcemaUrlAnd");
    String str4 = (String)paramanfd.data.get("title");
    String str5 = (String)paramanfd.data.get("fake_push");
    String str6 = (String)paramanfd.data.get("icon_type");
    String str7 = (String)paramanfd.data.get("icon_url");
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, new Object[] { "showPush: invoked. ", " iconType: ", str6, " title: ", str4, " message: ", str1 });
    }
    long l = paramanfd.opUin;
    if (paramanfd.data.get("count") != null) {
      QLog.i("CliNotifyPush", 1, "showPush receive push time:" + paramanfd.addTime + ",unreadCount=" + 1 + ",uin=" + l + ",type=" + m);
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        int j = Integer.parseInt((String)paramanfd.data.get("count"));
        i = j;
        if (j < 1) {
          i = 1;
        }
        int k;
        bool3 = localQQAppInterface.abm();
      }
      catch (Exception localException2)
      {
        try
        {
          j = Integer.parseInt((String)paramanfd.data.get("CtrlFlag"));
          if (QLog.isColorLevel())
          {
            QLog.i("CliNotifyPush", 2, "qzone redtypeinfo:receive push time:" + paramanfd.addTime + "=unreadCount=" + i + "=uin=" + l + "=type=" + m + "=CtrlFlag=" + j + "=message=" + str1);
            if (j != 1) {
              continue;
            }
            bool1 = true;
            a(paramanfd, bool1);
          }
        }
        catch (Exception localException2)
        {
          try
          {
            k = Integer.parseInt((String)paramanfd.data.get("show_level"));
            if ((!localQQAppInterface.isBackground_Pause) && (!bj(k, 1))) {
              break label1058;
            }
            if (!n(localQQAppInterface, m))
            {
              a(paramanfd, localQQAppInterface, 16L);
              return;
              localException1 = localException1;
              i = 1;
              continue;
              localException2 = localException2;
              j = 0;
              continue;
              QLog.i("CliNotifyPush", 1, "qzone redtypeinfo:receive push time:" + paramanfd.addTime + "=unreadCount=" + i + "=uin=" + l + "=type=" + m + "=CtrlFlag=" + j);
              continue;
              bool1 = false;
            }
          }
          catch (Exception localException3)
          {
            k = 4;
            continue;
            if (j == 1)
            {
              QLog.e("CliNotifyPush", 1, "not show push, existDL = " + j);
              a(paramanfd, localQQAppInterface, 128L);
              return;
            }
            if ((!aqlr.isScreenLocked(localQQAppInterface.getApp())) && (bz(localQQAppInterface)) && (!bj(k, 0)))
            {
              a(paramanfd, localQQAppInterface, 64L);
              return;
            }
            if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext()))
            {
              a(paramanfd, localQQAppInterface, 512L);
              return;
            }
            if (str1 == null) {
              break label1048;
            }
          }
        }
      }
      boolean bool3;
      if (!bool3) {
        str1 = localQQAppInterface.getApp().getApplicationContext().getString(2131718126) + i + localQQAppInterface.getApp().getApplicationContext().getString(2131718127);
      }
      for (;;)
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (paramanfd.data != null)
        {
          bool1 = bool2;
          if (paramanfd.data.get("daemonShow") != null) {
            bool1 = "1".equals(paramanfd.data.get("daemonShow"));
          }
        }
        if (bool1)
        {
          avyt.a().a(localQQAppInterface, 1, str4, str1, str6, str7, bool3, m, str3, str2, true, "1".equals(str5));
          a(paramanfd, localQQAppInterface, 4L);
        }
        QLog.e("CliNotifyPush", 1, "show push: XXX");
        return;
        label1048:
        a(paramanfd, localQQAppInterface, 256L);
        return;
        label1058:
        a(paramanfd, localQQAppInterface, 32L);
        return;
      }
      int i = 1;
    }
  }
  
  private void c(anfd paramanfd)
  {
    if (paramanfd == null) {
      return;
    }
    QLog.e("CliNotifyPush", 1, "recv Qzone Push: Feed实时更新Push");
    Intent localIntent = new Intent("com.qzone.push_feed_update");
    if ((paramanfd.extBuffer != null) && (paramanfd.extBuffer.length > 0)) {
      localIntent.putExtra("update_feeds_buffer", paramanfd.extBuffer);
    }
    for (;;)
    {
      BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
      return;
      if ((paramanfd.data != null) && ((paramanfd.data instanceof HashMap))) {
        localIntent.putExtra("update_feeds", (HashMap)paramanfd.data);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface + ":" + paramInt, paramLong);
      }
      localEditor.commit();
    }
  }
  
  private void c(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      awcy.a locala = new awcy.a();
      locala.cmd = Integer.parseInt((String)paramMap.get("key_ctrl_cmd"));
      locala.data.putAll(paramMap);
      awcy.a(paramString).a(locala);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  private void d(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, data is null.");
    }
    for (;;)
    {
      return;
      try
      {
        String str = (String)paramMap.get("maappid");
        int i = Integer.valueOf((String)paramMap.get("reddotcount")).intValue();
        if ((!TextUtils.isEmpty(str)) && (i > 0))
        {
          paramMap = new MiniAppRedDotEntity(str, 0, i);
          paramQQAppInterface = (adag)paramQQAppInterface.getBusinessHandler(148);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.notifyUI(9, true, paramMap);
            return;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, exception: " + paramQQAppInterface.toString());
      }
    }
  }
  
  private void d(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      MiniAppControlInfo localMiniAppControlInfo = new MiniAppControlInfo();
      localMiniAppControlInfo.cmd = ((String)paramMap.get("key_ctrl_cmd"));
      localMiniAppControlInfo.data.putAll(paramMap);
      MiniAppPushControl.getInstance(paramString).processControlInfo(localMiniAppControlInfo);
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("CliNotifyPush", 1, "decodeMiniAppCtrlPush failed:", paramMap);
    }
  }
  
  private void dQ(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("CliNotifyPush", 1, "handleQQCirclePush " + paramQQAppInterface.isBackground_Pause + ", " + paramQQAppInterface.isBackground_Stop);
    if ((paramQQAppInterface.isBackground_Pause) && (paramQQAppInterface.isBackground_Stop))
    {
      paramQQAppInterface = (acks)paramQQAppInterface.getBusinessHandler(87);
      if (paramQQAppInterface != null)
      {
        QLog.i("CliNotifyPush", 1, "handleQQCirclePush sendRedpointReq");
        paramQQAppInterface.bJ(true, false);
      }
    }
    paramQQAppInterface = new Intent();
    paramQQAppInterface.setAction("action_receive_message_push");
    BaseApplication.getContext().sendBroadcast(paramQQAppInterface);
  }
  
  private boolean n(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 10000) {}
    do
    {
      return false;
      if ((8 == paramInt) || (4 == paramInt) || (366 == paramInt)) {
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
    } while ((paramInt != 1) && (paramInt != 300));
    return LocalMultiProcConfig.getBool(paramQQAppInterface.getApp().getApplicationContext().getString(2131718976) + paramQQAppInterface.getAccount(), true);
  }
  
  public static long o(QQAppInterface paramQQAppInterface)
  {
    return b(paramQQAppInterface, 0);
  }
  
  public static void r(QQAppInterface paramQQAppInterface, long paramLong)
  {
    c(paramQQAppInterface, 0, paramLong);
  }
  
  private void report(int paramInt)
  {
    QLog.e("CliNotifyPush", 1, "report resultCode:" + paramInt);
    UI(paramInt);
    avpw.a((QQAppInterface)getAppRuntime(), "qzonenewservice.callqzonev2", paramInt, "CliNotifyPush", 1, System.currentTimeMillis());
  }
  
  public Map<Integer, anfd> a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    System.arraycopy(localObject1, 4, localObject1, 0, localObject1.length - 4);
    paramFromServiceMsg = new PushInfo();
    localObject1 = new JceInputStream((byte[])localObject1);
    ((JceInputStream)localObject1).setServerEncoding("utf-8");
    paramFromServiceMsg.readFrom((JceInputStream)localObject1);
    Object localObject2 = paramFromServiceMsg.vecMsg;
    localObject1 = new HashMap();
    long l3 = o(localQQAppInterface);
    localObject2 = ((ArrayList)localObject2).iterator();
    long l1 = l3;
    SingleMsg localSingleMsg;
    int i;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localSingleMsg = (SingleMsg)((Iterator)localObject2).next();
        if (localSingleMsg != null) {
          if (localSingleMsg.data.containsKey("pushtype")) {
            i = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
          }
        }
      }
    }
    for (;;)
    {
      long l2;
      if ((i == 1) || (i == 2) || (i == 4) || (i == 301) || (i == 8) || (i == 300) || (i == 10000) || (i == 10100) || (i == 302) || (i == 350) || (i == 100) || (i == 366))
      {
        l2 = b(localQQAppInterface, i);
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PushDeduplication", 1) == 1)
        {
          if (localSingleMsg.addTime > l2) {
            break label554;
          }
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new anfd(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          report(2014);
          break;
          if (!localSingleMsg.data.containsKey("type")) {
            break label1017;
          }
          i = Integer.parseInt((String)localSingleMsg.data.get("type"));
          continue;
        }
        if (localSingleMsg.addTime < l2)
        {
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new anfd(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
          report(2014);
          break;
        }
        label554:
        if (((Map)localObject1).containsKey(Integer.valueOf(i)))
        {
          anfd localanfd = (anfd)((Map)localObject1).get(Integer.valueOf(i));
          if ((localanfd != null) && (localanfd.addTime < localSingleMsg.addTime))
          {
            ((Map)localObject1).put(Integer.valueOf(i), new anfd(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer));
            QLog.e("CliNotifyPush", 1, "PushDeduplication: msg localTimeStap:" + localSingleMsg.addTime + " sm newTimeStap:" + localanfd.addTime + " msg:" + (String)localanfd.data.get("conent"));
            a(localanfd, localQQAppInterface, 8L);
            label725:
            c(localQQAppInterface, i, localSingleMsg.addTime);
            l2 = l1;
            if (l1 < localSingleMsg.addTime) {
              l2 = localSingleMsg.addTime;
            }
            if (i == 366) {
              dQ(localQQAppInterface);
            }
            l1 = l2;
          }
        }
      }
      for (;;)
      {
        break;
        QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
        a(new anfd(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 8L);
        break;
        ((Map)localObject1).put(Integer.valueOf(i), new anfd(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer));
        break label725;
        if (i == 7066) {
          an(localSingleMsg.data);
        } else if (i == 200) {
          d(localQQAppInterface, localSingleMsg.data);
        } else {
          a(new anfd(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface, 256L);
        }
      }
      if (l3 < l1) {
        r(localQQAppInterface, l1);
      }
      return localObject1;
      label1017:
      i = 0;
    }
  }
  
  public boolean bj(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((1 << paramInt2 & paramInt1) != 0) {}
    for (;;)
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("CliNotifyPush", 2, "checkForegroundShowEnabled showLevel: " + paramInt1 + ",result: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean bz(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = ((ActivityManager)paramQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0)
      {
        paramQQAppInterface = ((ActivityManager.RunningTaskInfo)paramQQAppInterface.get(0)).topActivity.getClassName();
        if ((!"cooperation.qzone.QzoneGPUPluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzonePluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzoneFeedsPluginProxyActivity".equals(paramQQAppInterface))) {
          break label88;
        }
      }
    }
    label88:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return gy;
  }
  
  public void onCreate()
  {
    super.onCreate();
    avzf.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    avzf.a().b(this);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).getBusinessHandler(0)).onReceive(null, paramFromServiceMsg, localSvcMsgPush);
    }
    for (;;)
    {
      return;
      if ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess())) {
        break;
      }
      QLog.e("CliNotifyPush", 1, "get qzone push begin");
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.values().iterator();
        while (paramIntent.hasNext()) {
          a((anfd)paramIntent.next());
        }
      }
    }
    QLog.e("CliNotifyPush", 1, "get qzone push error");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramString = paramBundle.getBundle("data");
      i = paramString.getInt("param.preget_seqid");
      paramString = Long.valueOf(paramString.getLong("param.preget_undealcount", -1L));
    } while (ni.get(Integer.valueOf(i)) == null);
    paramBundle = (anfd)ni.get(Integer.valueOf(i));
    if (paramString.longValue() != -1L) {
      paramBundle.data.put("count", paramString + "");
    }
    QLog.e("CliNotifyPush", 1, "onWebEvent showPush count:" + paramString);
    b((anfd)ni.get(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aneb
 * JD-Core Version:    0.7.0.1
 */