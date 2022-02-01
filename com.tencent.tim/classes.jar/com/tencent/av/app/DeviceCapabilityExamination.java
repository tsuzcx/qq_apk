package com.tencent.av.app;

import acfp;
import aeif;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import aoll;
import aolm;
import aolm.b;
import aomg;
import aomh;
import aqhq;
import aqiw;
import com.tencent.av.VideoController;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.videoeffect.VideoEffectTest;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ige;
import igi;
import igi.b;
import igi.c;
import ihw;
import ihw.a;
import ihw.a.a;
import ihx;
import ihz;
import imf;
import imh;
import imm;
import ioc;
import ioe;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import jlu;
import jly;

public class DeviceCapabilityExamination
{
  static a a;
  public VideoAppInterface mApp;
  
  public DeviceCapabilityExamination(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    paramVideoAppInterface = new MyTestRunnable(this);
    this.mApp.getHandler().postDelayed(paramVideoAppInterface, 5000L);
  }
  
  static void P(int paramInt, String paramString)
  {
    if (AudioHelper.isDev())
    {
      QLog.w("DeviceCapabilityExamination", 1, "delSampleFile, 测试版本不删除样本, codec[" + paramInt + "], md5[" + paramString + "]");
      return;
    }
    Q(paramInt, paramString);
  }
  
  public static void Q(int paramInt, String paramString)
  {
    try
    {
      String str = de(paramString);
      File localFile = new File(str);
      boolean bool = localFile.exists();
      aqhq.cn(str);
      QLog.w("DeviceCapabilityExamination", 1, "delSampleFile, codec[" + paramInt + "], md5[" + paramString + "], exists[" + bool + "->" + localFile.exists() + "]");
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static c a(int paramInt1, int paramInt2, long paramLong1, String paramString1, String paramString2, int paramInt3, long paramLong2)
  {
    c localc = new c();
    localc.uin = Long.parseLong(VideoController.a().mApp.getCurrentAccountUin());
    localc.amp = paramInt1;
    localc.codecName = paramString2;
    localc.MF = paramString1;
    localc.result = paramInt2;
    localc.amq = ((int)paramLong2);
    localc.delay = ((int)paramLong1);
    return localc;
  }
  
  private static igi.b a(igi.c paramc)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramc.cv != null)
    {
      if (paramc.cv.size() != 0) {
        break label30;
      }
      localObject2 = localObject3;
    }
    label30:
    do
    {
      return localObject2;
      localObject3 = getSP();
      localObject2 = ((SharedPreferences)localObject3).getString(getKey(paramc.akU, "md5"), null);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = (igi.b)paramc.cv.get(localObject2);
      }
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty(((igi.b)localObject1).url));
    int i = paramc.cv.size();
    i = (int)(System.currentTimeMillis() % i);
    localObject1 = (String)paramc.cv.keySet().toArray()[i];
    localObject2 = (igi.b)paramc.cv.get(localObject1);
    localObject3 = ((SharedPreferences)localObject3).edit();
    ((SharedPreferences.Editor)localObject3).putString(getKey(paramc.akU, "md5"), (String)localObject1);
    ((SharedPreferences.Editor)localObject3).commit();
    return localObject2;
  }
  
  public static String a(int paramInt, igi.b paramb)
  {
    String str = "enc_[w" + paramb.w + "h" + paramb.h + "fYUV420]_";
    paramb = de(paramb.md5) + str + paramb.bitrate + "_" + paramb.fps + "_" + paramb.w + "x" + paramb.h;
    if ((paramInt == 1) || (paramInt == 2)) {
      return paramb + ".264";
    }
    return paramb + ".265";
  }
  
  public static ArrayList<Integer[]> a(TreeMap<Integer, Integer[]> paramTreeMap, String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramTreeMap.keySet().iterator();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      Integer[] arrayOfInteger = (Integer[])paramTreeMap.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
      if ((arrayOfInteger[2].intValue() == paramInt1) && (arrayOfInteger[3].intValue() == paramInt2))
      {
        localArrayList.add(arrayOfInteger);
        if (QLog.isDevelopLevel()) {
          QLog.w("DeviceCapabilityExamination", 1, "getBitRateTable, md5[" + paramString + "], w[" + paramInt1 + "], h[" + paramInt2 + "], bitrate[" + arrayOfInteger[1] + "], fps[" + arrayOfInteger[4] + "]");
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      QLog.w("DeviceCapabilityExamination", 1, "getBitRateTable, 没找到对应的码表, md5[" + paramString + "], w[" + paramInt1 + "], h[" + paramInt2 + "]");
      localArrayList.add(new Integer[] { Integer.valueOf(32), Integer.valueOf(2000), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    }
    return localArrayList;
  }
  
  public static TreeMap<Integer, Integer[]> a()
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put(Integer.valueOf(1), new Integer[] { Integer.valueOf(1), Integer.valueOf(425), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(2), new Integer[] { Integer.valueOf(2), Integer.valueOf(450), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(3), new Integer[] { Integer.valueOf(3), Integer.valueOf(500), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(4), new Integer[] { Integer.valueOf(4), Integer.valueOf(550), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(12), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(5), new Integer[] { Integer.valueOf(5), Integer.valueOf(600), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(6), new Integer[] { Integer.valueOf(6), Integer.valueOf(650), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(7), new Integer[] { Integer.valueOf(7), Integer.valueOf(700), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(8), new Integer[] { Integer.valueOf(8), Integer.valueOf(750), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(9), new Integer[] { Integer.valueOf(9), Integer.valueOf(800), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(10), new Integer[] { Integer.valueOf(10), Integer.valueOf(850), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(11), new Integer[] { Integer.valueOf(11), Integer.valueOf(900), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(12), new Integer[] { Integer.valueOf(12), Integer.valueOf(1000), Integer.valueOf(640), Integer.valueOf(480), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(13), new Integer[] { Integer.valueOf(13), Integer.valueOf(800), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(14), new Integer[] { Integer.valueOf(14), Integer.valueOf(850), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(15), new Integer[] { Integer.valueOf(15), Integer.valueOf(900), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(16), new Integer[] { Integer.valueOf(16), Integer.valueOf(1000), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(17), new Integer[] { Integer.valueOf(17), Integer.valueOf(1100), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(18), new Integer[] { Integer.valueOf(18), Integer.valueOf(1200), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(19), new Integer[] { Integer.valueOf(19), Integer.valueOf(1300), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(20), new Integer[] { Integer.valueOf(20), Integer.valueOf(1400), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(21), new Integer[] { Integer.valueOf(21), Integer.valueOf(1500), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(22), new Integer[] { Integer.valueOf(22), Integer.valueOf(1600), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(23), new Integer[] { Integer.valueOf(23), Integer.valueOf(1700), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(24), new Integer[] { Integer.valueOf(24), Integer.valueOf(1800), Integer.valueOf(1280), Integer.valueOf(720), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(25), new Integer[] { Integer.valueOf(25), Integer.valueOf(2000), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(26), new Integer[] { Integer.valueOf(26), Integer.valueOf(2100), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(27), new Integer[] { Integer.valueOf(27), Integer.valueOf(2200), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(28), new Integer[] { Integer.valueOf(28), Integer.valueOf(2300), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(15), Integer.valueOf(1), Integer.valueOf(15), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(29), new Integer[] { Integer.valueOf(29), Integer.valueOf(2400), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(30), new Integer[] { Integer.valueOf(30), Integer.valueOf(2600), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    localTreeMap.put(Integer.valueOf(31), new Integer[] { Integer.valueOf(31), Integer.valueOf(2800), Integer.valueOf(1920), Integer.valueOf(1080), Integer.valueOf(20), Integer.valueOf(1), Integer.valueOf(20), Integer.valueOf(5) });
    return localTreeMap;
  }
  
  public static void a(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    jlu.a(paramVideoAppInterface);
    jlu.a("DeviceCapabilityExamination", paramVideoAppInterface);
    ThreadManager.excute(new DeviceCapabilityExamination.1(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  public static void a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt, igi.b paramb, ihw.a parama)
  {
    long l = System.currentTimeMillis();
    VideoController localVideoController = paramVideoAppInterface.b();
    ihw.a.a locala = new ihw.a.a();
    locala.akU = paramInt;
    locala.MF = paramb.md5;
    locala.MG = df(paramb.md5);
    locala.MI = a(paramInt, paramb);
    locala.aml = paramb.bitrate;
    locala.amk = paramb.fps;
    locala.MH = paramb.LO;
    ihw.a(paramLong, localVideoController, locala, new ihx(l, paramInt, locala, paramb, paramVideoAppInterface, paramLong, parama));
  }
  
  public static void a(c paramc, int paramInt1, int paramInt2)
  {
    ClientLogReport.instance().callbackSendLog(paramc.uin, 5274, paramc.gJ().getBytes());
    AudioHelper.UB(acfp.m(2131704962) + paramInt1 + "], resultCode:" + paramInt2);
    br(paramInt1, paramInt2);
    P(paramInt1, paramc.MF);
  }
  
  public static void a(igi.c paramc, String paramString1, String paramString2)
  {
    if (!aqiw.isWifiConnected(null))
    {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, no wifi");
      return;
    }
    try
    {
      if (a == null) {
        a = new a();
      }
      if (a.v(paramString1, paramString2))
      {
        QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, 下载中 , md5[" + paramString1 + "]");
        return;
      }
    }
    finally {}
    if (AudioHelper.aCz()) {
      QLog.w("DeviceCapabilityExamination", 1, "startDownloadTestResource, md5[" + paramString1 + "]");
    }
    paramc = new aoll();
    paramc.f = new b();
    paramc.bZ = paramString2;
    paramc.mHttpMethod = 0;
    paramc.atY = (de(paramString1) + "sample.zip");
    paramc.mMsgId = paramString1;
    paramc.bw(paramString1);
    ige.a().a(paramc);
  }
  
  public static boolean a(igi.c paramc, boolean paramBoolean)
  {
    if (paramc == null) {}
    igi.b localb;
    do
    {
      do
      {
        return false;
      } while (ioe.a(paramc) == 0);
      localb = a(paramc);
      if (localb == null)
      {
        QLog.w("DeviceCapabilityExamination", 1, "checkCondition, 无样本, codec[" + paramc.akU + "]");
        return false;
      }
      String str = df(localb.md5);
      if (new File(str).exists()) {
        break;
      }
      QLog.w("DeviceCapabilityExamination", 1, "checkCondition, 样本未下载, codec[" + paramc.akU + "], path[" + str + "], downloadRes[" + paramBoolean + "]");
    } while (!paramBoolean);
    a(paramc, localb.md5, localb.url);
    return false;
    return true;
  }
  
  static Integer[] a(TreeMap<Integer, Integer[]> paramTreeMap, String paramString, int paramInt1, int paramInt2)
  {
    paramTreeMap = a(paramTreeMap, paramString, paramInt1, paramInt2);
    return (Integer[])paramTreeMap.get((int)(System.currentTimeMillis() % paramTreeMap.size()));
  }
  
  private void amu()
  {
    b(this.mApp);
    amv();
  }
  
  private void amv()
  {
    if (AudioHelper.aCz()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed");
    }
    Object localObject = imh.R(this.mApp.getApp());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (AudioHelper.aCz()) {
        QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test config: \n" + (String)localObject);
      }
      localObject = new imf((String)localObject);
      if (new jly().a((imf)localObject) == 1)
      {
        localObject = this.mApp.getApp().getSharedPreferences("qav_sp_video_effect", 0);
        if (((SharedPreferences)localObject).getBoolean("qav_key_test_executed", false)) {
          break label161;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("qav_key_test_executed", true);
        ((SharedPreferences.Editor)localObject).commit();
        new VideoEffectTest(new ihz(this)).execute();
      }
    }
    label161:
    while (!AudioHelper.aCz())
    {
      do
      {
        return;
      } while (!AudioHelper.aCz());
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test executed.");
      return;
    }
    QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed do not need test.");
  }
  
  public static void b(int paramInt, VideoAppInterface paramVideoAppInterface)
  {
    ThreadManager.excute(new DeviceCapabilityExamination.3(paramInt, paramVideoAppInterface), 16, null, true);
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, begin");
    }
    if (cg(1)) {
      b(1, paramVideoAppInterface);
    }
    do
    {
      return;
      if (cg(4))
      {
        b(4, paramVideoAppInterface);
        return;
      }
      if (cg(2))
      {
        a(2, paramVideoAppInterface);
        return;
      }
      if (cg(8))
      {
        a(8, paramVideoAppInterface);
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, no");
  }
  
  private static void bq(int paramInt1, int paramInt2)
  {
    Object localObject = getSP();
    int i = ((SharedPreferences)localObject).getInt(getKey(paramInt1, "test_ver"), 0);
    if (i == paramInt2) {
      return;
    }
    long l1 = ((SharedPreferences)localObject).getLong(getKey(paramInt1, "doneTime"), 0L);
    long l2 = ((SharedPreferences)localObject).getLong(getKey(paramInt1, "finishTime"), 0L);
    String str = ((SharedPreferences)localObject).getString(getKey(paramInt1, "md5"), null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(getKey(paramInt1, "md5"));
    ((SharedPreferences.Editor)localObject).remove(getKey(paramInt1, "doneTime"));
    ((SharedPreferences.Editor)localObject).remove(getKey(paramInt1, "finishTime"));
    ((SharedPreferences.Editor)localObject).remove(getKey(paramInt1, "result"));
    ((SharedPreferences.Editor)localObject).putInt(getKey(paramInt1, "test_ver"), paramInt2);
    ((SharedPreferences.Editor)localObject).commit();
    QLog.w("DeviceCapabilityExamination", 1, "checkSPVer, codec[" + paramInt1 + "], ver[" + i + "->" + paramInt2 + "], doneFlagTime[" + l1 + "], finishFlagTime[" + l2 + "], md5[" + str + "]");
  }
  
  static void br(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = getSP().edit();
    localEditor.putInt(getKey(paramInt1, "result"), paramInt2);
    localEditor.putLong(getKey(paramInt1, "finishTime"), System.currentTimeMillis());
    localEditor.commit();
  }
  
  static boolean cg(int paramInt)
  {
    igi.c localc = igi.a(paramInt);
    if ((localc == null) || (System.currentTimeMillis() > localc.kz)) {}
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      do
      {
        return false;
        bq(localc.akU, localc.akX);
        localSharedPreferences = getSP();
        l1 = localSharedPreferences.getLong(getKey(paramInt, "doneTime"), 0L);
        if (l1 != 0L) {
          break;
        }
      } while (!a(localc, true));
      if (((paramInt == 8) || (paramInt == 2)) && (TextUtils.isEmpty(AVSoUtils.Ag())))
      {
        QLog.w("DeviceCapabilityExamination", 1, "runTest, cannot find libTcHevcDec2.so for hardware encode detect!!");
        return false;
      }
      kB(localc.akU);
      return true;
    } while (!AudioHelper.aCz());
    int i = localSharedPreferences.getInt(getKey(paramInt, "result"), -99);
    long l2 = localSharedPreferences.getLong(getKey(paramInt, "finishTime"), 0L);
    QLog.w("DeviceCapabilityExamination", 1, "runTest, done, codec[" + paramInt + "], result[" + i + "], doneFlagTime[" + l1 + "], finishFlagTime[" + l2 + "]");
    return false;
  }
  
  private static String de(String paramString)
  {
    return gI() + paramString + "/";
  }
  
  public static String df(String paramString)
  {
    return de(paramString) + "sample";
  }
  
  public static String gI()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null) {
      return "";
    }
    return localFile.getParent() + "/qav/sample/";
  }
  
  public static String getKey(int paramInt, String paramString)
  {
    return "DT_" + paramInt + "_" + paramString;
  }
  
  public static SharedPreferences getSP()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("DeviceCapabilityExamination", 4);
  }
  
  private static void kB(int paramInt)
  {
    long l = System.currentTimeMillis();
    QLog.w("DeviceCapabilityExamination", 1, "setTestDone, codec[" + paramInt + "], doneFlagTime[" + l + "]");
    Object localObject1 = getSP().edit();
    ((SharedPreferences.Editor)localObject1).putLong(getKey(paramInt, "doneTime"), l);
    ((SharedPreferences.Editor)localObject1).commit();
    int i = aeif.a().q(431, "");
    localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof VideoAppInterface))
    {
      Object localObject2 = (VideoAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((VideoAppInterface)localObject2).getCurrentAccountUin());
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = igi.a(paramInt);
      if (localObject2 != null)
      {
        i = ioe.a((igi.c)localObject2);
        ((HashMap)localObject1).put("test" + paramInt, "1");
        ((HashMap)localObject1).put("test" + paramInt + "_ver", ((igi.c)localObject2).akX + "");
        ((HashMap)localObject1).put("test" + paramInt + "_flag", i + "");
      }
      UserAction.onUserAction("qav_codec_done", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  static class MyTestRunnable
    implements Runnable
  {
    WeakReference<DeviceCapabilityExamination> mRef;
    
    MyTestRunnable(DeviceCapabilityExamination paramDeviceCapabilityExamination)
    {
      this.mRef = new WeakReference(paramDeviceCapabilityExamination);
    }
    
    public void run()
    {
      DeviceCapabilityExamination localDeviceCapabilityExamination = (DeviceCapabilityExamination)this.mRef.get();
      if (localDeviceCapabilityExamination != null) {
        DeviceCapabilityExamination.a(localDeviceCapabilityExamination);
      }
    }
  }
  
  static class a
  {
    HashMap<String, String> cy = new HashMap();
    HashMap<String, Long> cz = new HashMap();
    
    void N(String paramString, boolean paramBoolean)
    {
      QLog.w("DeviceCapabilityExamination", 1, "setDownloadFinish, md5[" + paramString + "], suc[" + paramBoolean + "], time[" + this.cz.get(paramString) + "]");
      AudioHelper.UB(acfp.m(2131704963) + paramBoolean);
      this.cy.remove(paramString);
      this.cz.remove(paramString);
    }
    
    boolean isEmpty()
    {
      return this.cy.isEmpty();
    }
    
    boolean v(String paramString1, String paramString2)
    {
      if (this.cy.get(paramString1) != null)
      {
        QLog.w("DeviceCapabilityExamination", 1, "isDownloading, md5[" + paramString1 + "], time[" + this.cz.get(paramString1) + "]");
        return true;
      }
      this.cy.put(paramString1, paramString2);
      this.cz.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      return false;
    }
  }
  
  static class b
    implements aolm.b
  {
    public void onResp(aomh paramaomh)
    {
      boolean bool = false;
      String str1 = (String)paramaomh.b.U();
      if (paramaomh.mResult == 0) {
        bool = true;
      }
      try
      {
        if (DeviceCapabilityExamination.a != null)
        {
          DeviceCapabilityExamination.a.N(str1, bool);
          if (DeviceCapabilityExamination.a.isEmpty()) {
            DeviceCapabilityExamination.a = null;
          }
        }
        if (!bool)
        {
          QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str1 + "], resp.mResult[" + paramaomh.mResult + "]");
          return;
        }
      }
      finally {}
      try
      {
        String str2 = DeviceCapabilityExamination.de(str1);
        aqhq.W(paramaomh.b.atY, str2, false);
        aqhq.deleteFile(paramaomh.b.atY);
        paramaomh = new File(DeviceCapabilityExamination.df(str1));
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str1 + "], exists[" + paramaomh.exists() + "]");
        return;
      }
      catch (Exception paramaomh)
      {
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str1 + "]");
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static class c
  {
    public String MF = "";
    public String MK = Build.HARDWARE;
    public String ML = imm.gU();
    public String MM = "";
    public int amA;
    public int amB;
    public int amC;
    public int amD;
    public int amo = Build.VERSION.SDK_INT;
    public int amp;
    public int amq;
    public int amr;
    public int ams;
    public int amt;
    public int amu;
    public int amv;
    public int amw;
    public int amx;
    public int amy;
    public int amz;
    public String codecName = "";
    public int delay;
    public String fingerprint = Build.FINGERPRINT;
    public long lf;
    public String manufacturer = Build.MANUFACTURER;
    public String model = Build.MODEL;
    public String product = Build.PRODUCT;
    public int result;
    public long totalMemory;
    public long uin;
    
    public String gJ()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.MK).append("|");
      localStringBuilder.append(this.manufacturer).append("|");
      localStringBuilder.append(this.model).append("|");
      localStringBuilder.append(this.product).append("|");
      localStringBuilder.append(this.fingerprint).append("|");
      localStringBuilder.append(this.ML).append("|");
      localStringBuilder.append(this.amo).append("|");
      localStringBuilder.append(this.uin).append("|");
      localStringBuilder.append(this.amp).append("|");
      localStringBuilder.append(this.codecName).append("|");
      localStringBuilder.append(this.MF).append("|");
      localStringBuilder.append(this.result).append("|");
      localStringBuilder.append(this.amq).append("|");
      localStringBuilder.append(this.delay).append("|");
      localStringBuilder.append(this.amr).append("|");
      localStringBuilder.append(this.ams).append("|");
      localStringBuilder.append(this.amt).append("|");
      localStringBuilder.append(this.amu).append("|");
      localStringBuilder.append(this.amv).append("|");
      localStringBuilder.append(this.MM).append("|");
      this.amw = imm.getNumCores();
      this.lf = (imm.getMaxCpuFreq() / 1024L);
      this.totalMemory = (imm.bD() / 1024L);
      this.amx = ioc.lm();
      this.amy = NativeCodec.mH264EncBaseLineLevel;
      this.amz = NativeCodec.mH264DecBaseLineLevel;
      this.amA = NativeCodec.mH264EncHighProfileLevel;
      this.amB = NativeCodec.mH264DecHighProfileLevel;
      this.amC = NativeCodec.mH265EncLevel;
      this.amD = NativeCodec.mH265DecLevel;
      localStringBuilder.append(this.amw).append("|");
      localStringBuilder.append(this.lf).append("|");
      localStringBuilder.append(this.totalMemory).append("|");
      localStringBuilder.append(this.amx).append("|");
      localStringBuilder.append(this.amy).append("|");
      localStringBuilder.append(this.amz).append("|");
      localStringBuilder.append(this.amA).append("|");
      localStringBuilder.append(this.amB).append("|");
      localStringBuilder.append(this.amC).append("|");
      localStringBuilder.append(this.amD).append("|");
      QLog.i("DeviceCapabilityExamination", 1, "ReportData:" + localStringBuilder.toString());
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination
 * JD-Core Version:    0.7.0.1
 */