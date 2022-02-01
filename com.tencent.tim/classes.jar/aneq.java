import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.feed_info;
import NS_UNDEAL_COUNT.single_count;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet.4;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet.5;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public class aneq
  extends MSFServlet
  implements avzi
{
  public static long akG;
  private static aczc.b b;
  public static boolean cFc;
  private static LbsDataV2.GpsInfo gpsInfo;
  private static SosoInterface.a h;
  private static long hj;
  private static long hk = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
  private static long hl;
  public static long receiveTime;
  private MqqHandler L;
  public long akE = 180000L;
  public long akF = 5000L;
  private Runnable hx = new QZoneNotifyServlet.5(this);
  
  private static void Qs(String paramString)
  {
    if ((cFc) && (b == null))
    {
      b = new aner(paramString, false);
      try
      {
        hl = System.currentTimeMillis();
        if ((Build.VERSION.SDK_INT < 23) || (BaseApplication.getContext() == null) || (BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))
        {
          aczc.a(b);
          return;
        }
        QZLog.w("QZLog", "[QZ_LBS_MODULE]定位有版本或权限限制");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onCreate startLocation exception " + paramString);
      }
    }
  }
  
  public static void Qt(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - hj < hk) {
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE] mIsGettingLocation = , (now - mLastGetLocationTime) ) = " + (l - hj) / 1000L + ", so return");
    }
    do
    {
      return;
      hj = l;
    } while (b == null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZoneNotifyServlet.4());
  }
  
  private static void UK(int paramInt)
  {
    if (paramInt == 2)
    {
      hk *= 10L;
      return;
    }
    if (paramInt == 0)
    {
      hk = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
      return;
    }
    hk *= 2L;
  }
  
  public static LbsDataV2.GpsInfo a(String paramString)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a(paramString);
    if (localSosoLbsInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      avzj.bf(bool, paramString);
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getGpsInfo");
      if (localSosoLbsInfo == null) {
        break;
      }
      return LbsDataV2.convertFromSoso(localSosoLbsInfo.a);
    }
    return null;
  }
  
  private void dPc()
  {
    getSubThreadHandler().removeCallbacks(this.hx);
    getSubThreadHandler().postDelayed(this.hx, this.akE);
  }
  
  private MqqHandler getSubThreadHandler()
  {
    if (this.L == null) {}
    try
    {
      if (this.L == null)
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QZONE_UNDEALCOUNT", 0);
        localHandlerThread.start();
        this.L = new MqqHandler(localHandlerThread.getLooper());
      }
      return this.L;
    }
    finally {}
  }
  
  public void onCreate()
  {
    super.onCreate();
    avzf.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (h != null) {
      SosoInterface.c(h);
    }
    h = null;
    if (b != null) {
      aczc.b(b);
    }
    b = null;
    avzf.a().b(this);
    if (this.L != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "QZoneNotifyServlet onDestroy" + System.currentTimeMillis());
      }
      this.L.removeCallbacks(this.hx);
      this.L.getLooper().quit();
    }
    this.L = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = getAppRuntime();
    if (localObject == null) {}
    while (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    receiveTime = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onReceive onReceive: " + receiveTime);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      ands.a(paramIntent, paramFromServiceMsg, (QQAppInterface)localObject, this);
      return;
    }
    ands.a((QQAppInterface)localObject, paramIntent, paramFromServiceMsg, this);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.begin.");
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        Qs("qzone_little_video_enter");
      } while (!"Qzone_Get_NewAndUnread_Count".equals(paramIntent.getAction()));
      localObject1 = getAppRuntime();
    } while ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface)));
    Object localObject1 = (QQAppInterface)localObject1;
    int i = 3;
    int k = paramIntent.getIntExtra("scene", 102);
    int j = paramIntent.getIntExtra("qzone_send_by_time", 4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "QzoneNotifyServlet onSend byTimeType:" + j + ",isBackground_Pause:" + ((QQAppInterface)localObject1).isBackground_Pause);
    }
    long l1;
    if (j == 2)
    {
      i = 2;
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "GETFEEDUNREADTYPE_SWITCHTOFORGROUND nowtime: " + l1 + ",lastGetFeedTime:" + akG + ",lastGetFeedTime:" + akG + "difference: " + (l1 - akG));
      }
      if (l1 - akG < this.akF)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.interval time is not enough,schedule task.byTimeType:2");
        }
        dPc();
        return;
      }
    }
    long l2;
    if (((j == 1) || (j == 4) || (j == 5) || (j == 6) || (j == 7) || (j == 8)) && (((QQAppInterface)localObject1).isBackground_Pause))
    {
      l2 = akG;
      l1 = l2;
      if (l2 == 0L) {
        l1 = LocalMultiProcConfig.getLong("qzone_lastgetfeedtime", 0L);
      }
      if (System.currentTimeMillis() - l1 < QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_lastgetfeedtime", 43200000))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend app.isBackground_Pause: " + ((QQAppInterface)localObject1).isBackground_Pause + " not send request,schedule task");
        }
        dPc();
        return;
      }
    }
    if (j == 3) {
      i = 4;
    }
    for (;;)
    {
      if (j == 1) {
        i = 1;
      }
      if (j == 4) {
        i = 3;
      }
      if (j == 2) {
        i = 2;
      }
      if (j == 5) {
        i = 5;
      }
      if (j == 6) {
        i = 6;
      }
      if (j == 7) {
        i = 7;
      }
      if (j == 8) {
        i = 8;
      }
      for (;;)
      {
        int m = ((QQAppInterface)localObject1).getApp().getResources().getDisplayMetrics().widthPixels;
        int n = ((QQAppInterface)localObject1).getApp().getResources().getDisplayMetrics().heightPixels;
        ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
        ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
        Object localObject2 = (aneo)((QQAppInterface)localObject1).getManager(10);
        Object localObject3;
        if (localObject2 != null)
        {
          paramIntent = ((aneo)localObject2).T;
          if (paramIntent != null)
          {
            localObject3 = ands.b(paramIntent);
            int i1 = ((List)localObject3).size();
            j = 0;
            Object localObject4;
            Object localObject5;
            if (j < i1)
            {
              int i2 = ((Integer)((List)localObject3).get(j)).intValue();
              localObject4 = (avsd)((aneo)localObject2).T.get(Integer.valueOf(i2));
              ArrayList localArrayList;
              if (localObject4 != null)
              {
                localObject5 = new single_count(((avsd)localObject4).uCount, (byte)((avsd)localObject4).iControl);
                localArrayList = new ArrayList();
                if ((((avsd)localObject4).ES == null) || (((avsd)localObject4).ES.size() <= 0)) {
                  break label765;
                }
              }
              label765:
              for (paramIntent = new feed_host_info(((QZoneCountUserInfo)((avsd)localObject4).ES.get(0)).uin, "", ((avsd)localObject4).cNl, null, null, null);; paramIntent = new feed_host_info(0L, "", ((avsd)localObject4).cNl, null, null, null))
              {
                localArrayList.add(paramIntent);
                localConcurrentHashMap1.put(Integer.valueOf(i2), new count_info((single_count)localObject5, localArrayList, ((avsd)localObject4).trace_info, ((avsd)localObject4).eyn, ((avsd)localObject4).iconUrl, ((avsd)localObject4).strShowMsg, ((avsd)localObject4).cNn, ((avsd)localObject4).cTime, ((avsd)localObject4).iShowLevel));
                j += 1;
                break;
              }
            }
            paramIntent = (avsd)((aneo)localObject2).T.get(Integer.valueOf(56));
            if (paramIntent != null)
            {
              localObject2 = new single_count(paramIntent.uCount, (byte)paramIntent.iControl);
              localObject3 = new ArrayList();
              l2 = 0L;
              l1 = l2;
              if (paramIntent.ES != null)
              {
                l1 = l2;
                if (paramIntent.ES.size() > 0)
                {
                  localObject4 = paramIntent.ES.iterator();
                  l1 = 0L;
                  if (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (QZoneCountUserInfo)((Iterator)localObject4).next();
                    ((ArrayList)localObject3).add(new feed_host_info(((QZoneCountUserInfo)localObject5).uin, ((QZoneCountUserInfo)localObject5).nickName, null, ((QZoneCountUserInfo)localObject5).vec_feedInfos, null, null));
                    if ((l1 != 0L) || (localObject5 == null) || (((QZoneCountUserInfo)localObject5).vec_feedInfos == null) || (((QZoneCountUserInfo)localObject5).vec_feedInfos.size() <= 0)) {
                      break label1277;
                    }
                    l1 = ((feed_info)((QZoneCountUserInfo)localObject5).vec_feedInfos.get(0)).uOrgFeedTime;
                  }
                }
              }
            }
          }
        }
        label1277:
        for (;;)
        {
          break;
          if ((paramIntent.hasShow) && (l1 > 0L)) {
            localConcurrentHashMap2.put(Long.valueOf(56L), Long.valueOf(l1));
          }
          localConcurrentHashMap1.put(Integer.valueOf(56), new count_info((single_count)localObject2, (ArrayList)localObject3, paramIntent.trace_info, paramIntent.eyn, paramIntent.iconUrl, paramIntent.strShowMsg, paramIntent.cNn, paramIntent.cTime, paramIntent.iShowLevel));
          paramIntent = LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject1).getLongAccountUin());
          paramIntent = ands.a(Long.valueOf(((QQAppInterface)localObject1).getCurrentAccountUin()).longValue(), null, m, n, i, k, localConcurrentHashMap1, paramIntent, localConcurrentHashMap2);
          if (paramIntent == null)
          {
            paramIntent = new byte[4];
            notifyObserver(null, 1000, false, new Bundle(), akln.class);
          }
          for (;;)
          {
            dPc();
            return;
            paramPacket.setTimeout(30000L);
            if (QLog.isDevelopLevel()) {
              QLog.d("NavigatorBar.Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "onSend cmd: " + "SQQzoneSvc." + "getUndealCount" + " iVisitQZoneType: " + i);
            }
            paramPacket.setSSOCommand("SQQzoneSvc." + "getUndealCount");
            paramPacket.putSendData(paramIntent);
            akG = System.currentTimeMillis();
            LocalMultiProcConfig.putLong("qzone_lastgetfeedtime", akG);
            if (QLog.isColorLevel()) {
              QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend send success,send request time: " + akG);
            }
          }
        }
      }
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      i = paramBundle.getInt("param.preget_seqid");
      paramString = getAppRuntime();
    } while ((paramString == null) || (!(paramString instanceof QQAppInterface)));
    paramBundle = Long.valueOf(paramBundle.getLong("param.preget_undealcount", -1L));
    QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onWebEvent undealcount" + paramBundle);
    ands.a((QQAppInterface)paramString, i, paramBundle);
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      long l = paramIntent.getLongExtra("notify_type", -1L);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putLong("notify_type", l);
      notifyObserver(null, 1000, true, paramIntent, akln.class);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:call notify observer");
      }
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aneq
 * JD-Core Version:    0.7.0.1
 */