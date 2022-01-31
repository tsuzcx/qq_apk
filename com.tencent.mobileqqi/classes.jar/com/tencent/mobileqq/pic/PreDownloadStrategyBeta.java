package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.PredownloadTest.ConfigInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class PreDownloadStrategyBeta
  extends BaseStrategy
{
  public static final String A = "AMaxWFlow3G";
  public static final String B = "AMaxPDFlow3G";
  public static final String C = "AFBFlowHit3G";
  public static final String D = "AFBFlowMiss3G";
  public static final String E = "APicAvgSize";
  public static final String F = "APicMaxSize";
  private static final String G = "PIC_TAG_PRELOAD.PreDownloadStrategyBeta";
  public static final String h = "xgFlowPre";
  public static final String i = "xgFlowWaste";
  public static final String j = "xgPreDownCount";
  public static final String k = "xgHitCount";
  public static final String l = "xgMissCount";
  public static final String m = "xgManulClickCount";
  public static final String n = "wifiPreDownCout";
  public static final String o = "wifiHitCount";
  public static final String p = "wifiMissCount";
  public static final String q = "wifiManulClickCount";
  public static final String r = "accFlowPreTotal";
  public static final String s = "accFlowWasteTotal";
  public static final String t = "accDays";
  public static final String u = "accStartDay";
  public static final String v = "lastDayTime";
  public static final String w = "xgFlowWasteBalance";
  public static final String x = "isOverLimit";
  public static final String y = "lastPicSize";
  public static final String z = "PicDPy471";
  public long A;
  public long B;
  public long C;
  public float a;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q = -1L;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.o;
      l1 = paramLong;
      if (QLog.isColorLevel())
      {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l1 = paramLong;
      }
    }
    return l1;
  }
  
  private void a(MessageForPic paramMessageForPic, long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.A += 1L;
      PicPreDownloadUtils.a("wifiHitCount", this.A);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt + ",wifiHitCount:" + this.A + ",uniseq:" + paramMessageForPic.uniseq);
      }
      paramMessageForPic.preDownState = 2;
      a(paramMessageForPic);
    }
    do
    {
      return;
      paramLong = a(paramLong);
      this.q += this.l * paramLong / 100L;
      if (this.q > this.j) {
        this.q = this.j;
      }
      this.r -= paramLong;
      this.t -= paramLong;
      if (this.r < 0L) {
        this.r = 0L;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "picSize:" + paramLong + ",flowPre:" + this.q + ",flowWaste:" + this.r);
      }
      paramMessageForPic.preDownState = 2;
      a(paramMessageForPic);
      this.w += 1L;
      PicPreDownloadUtils.a("xgFlowPre", this.q);
      PicPreDownloadUtils.a("xgFlowWaste", this.r);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.t);
      PicPreDownloadUtils.a("xgHitCount", this.w);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt + ",xgHitCount:" + this.w + ",uniseq:" + paramMessageForPic.uniseq);
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "accFlowPreTotal:" + this.s + ",accFlowWasteTotal:" + this.t);
  }
  
  public static void a(MessageForPic paramMessageForPic, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageForPic == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMessageForPic.previewed == 1);
        int i1 = paramMessageForPic.preDownNetworkType;
        paramMessageForPic.previewed = 1;
        paramMessageForPic.serial();
        if (i1 != 0) {
          break;
        }
      } while (paramMessageForPic.subMsgId != MessageForPic.defaultSuMsgId);
      PicPreDownloadUtils.a("wifiManulClickCount", PicPreDownloadUtils.a("wifiManulClickCount", 0L) + 1L);
      paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
      return;
    } while (paramMessageForPic.subMsgId != MessageForPic.defaultSuMsgId);
    PicPreDownloadUtils.a("xgManulClickCount", PicPreDownloadUtils.a("xgManulClickCount", 0L) + 1L);
    paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.B += 1L;
      PicPreDownloadUtils.a("wifiMissCount", this.B);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt + ",wifiMissCount:" + this.B + ",uniseq:" + paramMessageForPic.uniseq);
      paramMessageForPic.preDownState = 3;
      a(paramMessageForPic);
    }
    do
    {
      return;
      this.q += this.m;
      if (this.q > this.j) {
        this.q = this.j;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "picSize:" + paramLong + ",flowPre:" + this.q + ",flowWaste:" + this.r);
      }
      paramMessageForPic.preDownState = 3;
      a(paramMessageForPic);
      this.x += 1L;
      PicPreDownloadUtils.a("xgFlowPre", this.q);
      PicPreDownloadUtils.a("xgMissCount", this.x);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt + ",xgMissCount:" + this.x + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      PicPreDownloadUtils.a("wifiHitCount", this.A);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt + ",wifiHitCount:" + this.A + ",uniseq:" + paramMessageForPic.uniseq);
      }
      paramMessageForPic.preDownState = 5;
      a(paramMessageForPic);
    }
    do
    {
      return;
      this.q += this.n;
      if (this.q > this.j) {
        this.q = this.j;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "picSize:" + paramLong + ",flowPre:" + this.q + ",flowWaste:" + this.r + ",uniseq:" + paramMessageForPic.uniseq);
      }
      paramMessageForPic.preDownState = 5;
      a(paramMessageForPic);
      PicPreDownloadUtils.a("xgFlowPre", this.q);
      PicPreDownloadUtils.a("xgHitCount", this.w);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt + ",xgHitCount:" + this.w + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      PicPreDownloadUtils.a("wifiHitCount", this.A);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt + ",wifiHitCount:" + this.A + ",uniseq:" + paramMessageForPic.uniseq);
      }
      paramMessageForPic.preDownState = 6;
      a(paramMessageForPic);
    }
    do
    {
      return;
      this.q += this.n;
      if (this.q > this.j) {
        this.q = this.j;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "picSize:" + paramLong + ",flowPre:" + this.q + ",flowWaste:" + this.r + ",uniseq:" + paramMessageForPic.uniseq);
      }
      paramMessageForPic.preDownState = 6;
      a(paramMessageForPic);
      PicPreDownloadUtils.a("xgFlowPre", this.q);
      PicPreDownloadUtils.a("xgHitCount", this.w);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt + ",xgHitCount:" + this.w + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void e()
  {
    this.A = PicPreDownloadUtils.a("wifiHitCount", this.A);
    this.B = PicPreDownloadUtils.a("wifiMissCount", this.B);
    this.C = PicPreDownloadUtils.a("wifiManulClickCount", this.C);
    this.z = PicPreDownloadUtils.a("wifiPreDownCout", this.z);
    this.r = PicPreDownloadUtils.a("xgFlowWaste", this.r);
    this.w = PicPreDownloadUtils.a("xgHitCount", this.w);
    this.x = PicPreDownloadUtils.a("xgMissCount", this.x);
    this.y = PicPreDownloadUtils.a("xgManulClickCount", this.y);
    this.v = PicPreDownloadUtils.a("xgPreDownCount", this.v);
    this.s = PicPreDownloadUtils.a("accFlowPreTotal", this.s);
    this.t = PicPreDownloadUtils.a("accFlowWasteTotal", this.t);
  }
  
  public PredownloadTest.ConfigInfo a()
  {
    PredownloadTest.ConfigInfo localConfigInfo = new PredownloadTest.ConfigInfo();
    localConfigInfo.a = this.k;
    localConfigInfo.b = this.j;
    localConfigInfo.d = this.q;
    localConfigInfo.c = this.r;
    localConfigInfo.e = this.l;
    localConfigInfo.f = this.m;
    return localConfigInfo;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    long l1 = PicPreDownloadUtils.a("xgFlowPre", this.q);
    long l2 = PicPreDownloadUtils.a("xgFlowWaste", this.r);
    long l3 = PicPreDownloadUtils.a("accFlowPreTotal", this.s);
    long l4 = PicPreDownloadUtils.a("xgPreDownCount", this.v);
    long l5 = PicPreDownloadUtils.a("xgHitCount", this.w);
    long l6 = PicPreDownloadUtils.a("xgMissCount", this.x);
    long l7 = PicPreDownloadUtils.a("wifiPreDownCout", this.z);
    long l8 = PicPreDownloadUtils.a("wifiHitCount", this.A);
    long l9 = PicPreDownloadUtils.a("wifiMissCount", this.B);
    long l10 = PicPreDownloadUtils.a("xgManulClickCount", this.y);
    long l11 = PicPreDownloadUtils.a("wifiManulClickCount", this.C);
    if (PicPreDownloadUtils.a("isOverLimit", 0L) == 1L) {}
    for (boolean bool = true;; bool = false)
    {
      long l12 = PicPreDownloadUtils.a("lastPicSize", 0L);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", "\n|- spFlowPre:" + l1 + "\n|-  spFlowWaste：" + l2 + "\n|-  spFlowPreTotal:" + l3 + "\n|-  spXgPreDownCount：" + l4 + "\n|-  spXgHitCount:" + l5 + "\n|-  spXgMissCount：" + l6 + "\n|-  spWifiPreDownCount:" + l7 + "\n|-  spWifiHitCount：" + l8 + "\n|-  spWifiMissCount:" + l9 + "\n|-  spXgManulClickCount：" + l10 + "\n|-  spWifiManulClickCount:" + l11);
      }
      localHashMap.put("xgFlowPre", String.valueOf(l1));
      localHashMap.put("xgFlowWaste", String.valueOf(l2));
      if ((l5 != 0L) || (l6 != 0L) || (l4 != 0L))
      {
        localHashMap.put("accFlowPreTotal", String.valueOf(l3));
        localHashMap.put("xgPreDownCount", String.valueOf(l4));
        localHashMap.put("xgHitCount", String.valueOf(l5));
        localHashMap.put("xgMissCount", String.valueOf(l4 - l5));
        localHashMap.put("xgManulClickCount", String.valueOf(l10));
        localHashMap.put("xgFlowWasteBalance", String.valueOf(this.k - l2));
      }
      localHashMap.put("wifiPreDownCout", String.valueOf(l7));
      localHashMap.put("wifiHitCount", String.valueOf(l8));
      localHashMap.put("wifiMissCount", String.valueOf(l9));
      localHashMap.put("wifiManulClickCount", String.valueOf(l11));
      localHashMap.put("isOverLimit", String.valueOf(bool));
      localHashMap.put("lastPicSize", String.valueOf(l12));
      return localHashMap;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.z += 1L;
      PicPreDownloadUtils.a("wifiPreDownCout", this.z);
    }
    do
    {
      return;
      paramLong = a(paramLong);
      this.q -= paramLong;
      this.r += paramLong;
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize:" + paramLong + ",flowPre:" + this.q + ",flowWaste:" + this.r);
      }
      this.s += paramLong;
      this.t = (paramLong + this.t);
      this.v += 1L;
      PicPreDownloadUtils.a("xgFlowPre", this.q);
      PicPreDownloadUtils.a("xgFlowWaste", this.r);
      PicPreDownloadUtils.a("accFlowPreTotal", this.s);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.t);
      PicPreDownloadUtils.a("xgPreDownCount", this.v);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + paramInt + ",wifiPreDownCout:" + this.z + ",xgPreDownCout:" + this.v);
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "accFlowPreTotal:" + this.s + ",accFlowWasteTotal:" + this.t);
  }
  
  public void a(PredownloadTest.ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo.a != -1L) {
      this.k = paramConfigInfo.a;
    }
    if (paramConfigInfo.b != -1L) {
      this.j = paramConfigInfo.b;
    }
    if (paramConfigInfo.d != -1L)
    {
      this.q = paramConfigInfo.d;
      PicPreDownloadUtils.a("xgFlowPre", this.q);
    }
    if (paramConfigInfo.c != -1L)
    {
      this.r = paramConfigInfo.c;
      PicPreDownloadUtils.a("xgFlowWaste", this.r);
    }
    if (paramConfigInfo.e != -1L) {
      this.l = paramConfigInfo.e;
    }
    if (paramConfigInfo.f != -1L) {
      this.m = paramConfigInfo.f;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    this.q = PicPreDownloadUtils.a("xgFlowPre", this.q);
    this.r = PicPreDownloadUtils.a("xgFlowWaste", this.r);
    long l1 = PicPreDownloadUtils.a("lastDayTime", 0L);
    c();
    e();
    if (this.q == -1L) {
      this.q = this.j;
    }
    long l2 = System.currentTimeMillis();
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a();; paramQQAppInterface = null)
    {
      if (l2 - l1 > 86400000L)
      {
        PicPreDownloadUtils.a("lastDayTime", l2);
        PicReporter.a(paramQQAppInterface, a());
        d();
        PicReporter.b(paramQQAppInterface, b());
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
      }
      return;
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    PicPreDownloadUtils.a(this.a, paramMessageForPic);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if (paramMessageForPic.isSendFromLocal()) {}
    do
    {
      do
      {
        return;
      } while (paramMessageForPic.subVersion < 5);
      if (paramMessageForPic.preDownState == 1)
      {
        a(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType);
        return;
      }
      if (paramMessageForPic.preDownState == 0)
      {
        if (a(PicPreDownloadUtils.a(this.a, paramMessageForPic.istroop, paramMessageForPic.frienduin), paramMessageForPic.preDownNetworkType)[1] == 0)
        {
          d(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType);
          return;
        }
        b(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType);
        return;
      }
    } while (paramMessageForPic.preDownState != 4);
    c(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType);
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    boolean bool2 = super.a(paramLong, paramInt1, paramInt2);
    if (bool2) {
      bool1 = bool2;
    }
    do
    {
      return bool1;
      if (paramInt2 == 0)
      {
        PicPreDownloadUtils.a("isOverLimit", 0L);
        PicPreDownloadUtils.a("lastPicSize", paramLong);
        return false;
      }
      paramLong = a(paramLong);
    } while ((this.q - paramLong >= 0L) && (this.r + paramLong < this.k));
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + true + ",xgFloWaste +picSize=" + (this.r + paramLong) + ",xgFlowWasteLimit：" + this.k + ",flowPre:" + this.q + ",picSize:" + paramLong + ",flowWaste:" + this.r + ",uinType:" + paramInt1 + ",networkType:" + paramInt2);
    }
    PicPreDownloadUtils.a("isOverLimit", 1L);
    PicPreDownloadUtils.a("lastPicSize", paramLong);
    return true;
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i1 = PicPreDownloadUtils.a(paramInt2, paramInt1, 0);
    int i2 = PicPreDownloadUtils.a(paramInt2, paramInt1, 1);
    boolean bool1;
    if ((this.i >> i1 & 1L) == 1L)
    {
      bool1 = true;
      if ((this.i >> i2 & 1L) != 1L) {
        break label148;
      }
    }
    label148:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2 + ",xGPreDownPolicy:" + this.i);
      }
      return new boolean[] { bool1, bool2 };
      bool1 = false;
      break;
    }
  }
  
  public HashMap b()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    int i1 = ((Calendar)localObject).get(6);
    localObject = new HashMap();
    long l2 = PicPreDownloadUtils.a("accDays", 0L);
    long l3 = PicPreDownloadUtils.a("accFlowPreTotal", this.s);
    long l4 = PicPreDownloadUtils.a("accFlowWasteTotal", this.t);
    long l1 = PicPreDownloadUtils.a("accStartDay", i1);
    ((HashMap)localObject).put("accDays", String.valueOf(l2));
    ((HashMap)localObject).put("accFlowPreTotal", String.valueOf(l3));
    ((HashMap)localObject).put("accFlowWasteTotal", String.valueOf(l4));
    l2 = i1 - l1;
    PicPreDownloadUtils.a("accDays", l2);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "" + l2);
    }
    if ((l2 >= 30L) || (l2 < 0L))
    {
      this.s = 0L;
      this.t = 0L;
      PicPreDownloadUtils.a("accStartDay", i1);
      PicPreDownloadUtils.a("accDays", 0L);
      PicPreDownloadUtils.a("accFlowPreTotal", 0L);
      PicPreDownloadUtils.a("accFlowWasteTotal", 0L);
    }
    for (;;)
    {
      if (l2 < 0L) {
        localObject = null;
      }
      return localObject;
      if (l1 == i1) {
        PicPreDownloadUtils.a("accStartDay", i1);
      }
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      a(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType != 0) {}
    }
    else
    {
      return;
    }
    long l1 = this.o - paramLong;
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter start", "fixSize:" + paramLong + "xgFlowWaste :" + this.r + ",xgFlowPre:" + this.q + ",uniseq:" + paramMessageForPic.uniseq);
    }
    this.r -= l1;
    this.q += l1;
    this.s -= l1;
    this.t -= l1;
    if (this.r < 0L)
    {
      this.r = 0L;
      if (this.q <= this.j) {
        break label398;
      }
      this.q = this.j;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter end", "fixSize:" + paramLong + "xgFlowWaste :" + this.r + ",xgFlowPre:" + this.q + ",detaSize:" + l1 + ",uniseq:" + paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.s + ",accFlowWasteTotal:" + this.t);
      }
      PicPreDownloadUtils.a("xgFlowPre", this.q);
      PicPreDownloadUtils.a("xgFlowWaste", this.r);
      PicPreDownloadUtils.a("accFlowPreTotal", this.s);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.t);
      return;
      if (this.r <= this.k) {
        break;
      }
      this.r = this.k;
      break;
      label398:
      if (this.q < 0L) {
        this.q = 0L;
      }
    }
  }
  
  public void c()
  {
    this.i = PicPreDownloadUtils.a(this.a, "PicDPy471", 1374942199L);
    this.l = PicPreDownloadUtils.a(this.a, "AFBFlowHit3G", 150L);
    this.m = PicPreDownloadUtils.a(this.a, "AFBFlowMiss3G", 40960L);
    this.n = this.m;
    this.j = PicPreDownloadUtils.a(this.a, "AMaxPDFlow3G", 307200L);
    this.k = PicPreDownloadUtils.a(this.a, "AMaxWFlow3G", 512000L);
    this.o = PicPreDownloadUtils.a(this.a, "APicAvgSize", 71680L);
    this.p = PicPreDownloadUtils.a(this.a, "APicMaxSize", 204800L);
  }
  
  public void d()
  {
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.z = 0L;
    this.r = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.v = 0L;
    PicPreDownloadUtils.a("wifiHitCount", this.A);
    PicPreDownloadUtils.a("wifiMissCount", this.B);
    PicPreDownloadUtils.a("wifiManulClickCount", this.C);
    PicPreDownloadUtils.a("wifiPreDownCout", this.z);
    PicPreDownloadUtils.a("xgFlowWaste", this.r);
    PicPreDownloadUtils.a("xgHitCount", this.w);
    PicPreDownloadUtils.a("xgMissCount", this.x);
    PicPreDownloadUtils.a("xgManulClickCount", this.y);
    PicPreDownloadUtils.a("xgPreDownCount", this.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PreDownloadStrategyBeta
 * JD-Core Version:    0.7.0.1
 */