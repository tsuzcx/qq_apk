import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class akxz
  extends akwz
{
  public static String bUN = "PRE_DOWNLOAD_TROOP_STATISTICS_KEY";
  public static String bUO = "PRE_DOWNLOAD_TROOP_STATISTICS_TIME";
  public long Wt;
  public long Wu;
  public long Wv;
  public long Ww;
  public Long Y = Long.valueOf(100L);
  public acol a;
  public akxv a;
  public long aeN;
  public long aeO;
  public long aeP;
  public long aeQ;
  public long aeR;
  public long aeS;
  public long aeT;
  public long aeU;
  public long aeV;
  public long aeW;
  public long aeX;
  public long aeY;
  public long aeZ;
  public long afa;
  public long afb;
  public long afc;
  public long afd = -1L;
  public long afe;
  public long aff;
  public long afg;
  public long afh;
  public long afi;
  public long afj;
  public long afk;
  public long afl;
  public long afm;
  public long afn;
  public long afo;
  public long afp;
  public long afq = 2147483647L;
  public long afr = 2147483647L;
  public long afs = 2147483647L;
  public long aft = 2147483647L;
  public long afu;
  public long[] am;
  public boolean cvd;
  public AtomicBoolean dw = new AtomicBoolean(false);
  private QQAppInterface mApp;
  
  private long P(long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.Wv;
      l = paramLong;
      if (QLog.isColorLevel())
      {
        akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l = paramLong;
      }
    }
    return l;
  }
  
  private void b(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      l2 = this.afb;
      l1 = this.afc;
      this.afb += paramLong1;
      this.afc += paramLong2;
      if (this.afb > this.aeT)
      {
        paramLong1 = this.aeT;
        this.afb = paramLong1;
        if (this.afb >= 0L) {
          break label204;
        }
        paramLong1 = 0L;
        label71:
        this.afb = paramLong1;
        if (this.afc >= 0L) {
          break label212;
        }
      }
      label204:
      label212:
      for (paramLong1 = 0L;; paramLong1 = this.afc)
      {
        this.afc = paramLong1;
        paramLong2 = this.afb;
        paramLong1 = this.afc;
        akxo.m("4gFlowPre", this.afb, false);
        akxo.m("4gFlowWaste", this.afc, paramBoolean);
        if (QLog.isColorLevel()) {
          akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "updateFlow", "networkType=" + paramInt + ", preFlowPre=" + l2 + " preFlowWaste=" + l1 + "flowPre=" + paramLong2 + ", flowWaste:" + paramLong1);
        }
        return;
        paramLong1 = this.afb;
        break;
        paramLong1 = this.afb;
        break label71;
      }
    }
    long l2 = this.afd;
    long l1 = this.afe;
    this.afd += paramLong1;
    this.afe += paramLong2;
    if (this.afd > this.aeZ)
    {
      paramLong1 = this.aeZ;
      label270:
      this.afd = paramLong1;
      if (this.afd >= 0L) {
        break label350;
      }
      paramLong1 = 0L;
      label286:
      this.afd = paramLong1;
      if (this.afe >= 0L) {
        break label358;
      }
    }
    label350:
    label358:
    for (paramLong1 = 0L;; paramLong1 = this.afe)
    {
      this.afe = paramLong1;
      paramLong2 = this.afd;
      paramLong1 = this.afe;
      akxo.m("xgFlowPre", this.afd, false);
      akxo.m("xgFlowWaste", this.afe, paramBoolean);
      break;
      paramLong1 = this.afd;
      break label270;
      paramLong1 = this.afd;
      break label286;
    }
  }
  
  private void dDX()
  {
    this.afb = akxo.i("4gFlowPre", this.aeT);
    this.afc = akxo.i("4gFlowWaste", 0L);
    this.afd = akxo.i("xgFlowPre", this.aeZ);
    this.afe = akxo.i("xgFlowWaste", 0L);
    this.afm = akxo.i("wifiHitCount", this.afm);
    this.afn = akxo.i("wifiMissCount", this.afn);
    this.afo = akxo.i("wifiManulClickCount", this.afo);
    this.afl = akxo.i("wifiPreDownCout", this.afl);
    this.afi = akxo.i("xgHitCount", this.afi);
    this.afj = akxo.i("xgMissCount", this.afj);
    this.afk = akxo.i("xgManulClickCount", this.afk);
    this.afh = akxo.i("xgPreDownCount", this.afh);
    this.aff = akxo.i("accFlowPreTotal", this.aff);
    this.afg = akxo.i("accFlowWasteTotal", this.afg);
    this.afp = akxo.i("requestListOverLimitCount", this.afp);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getLocalConfig(): wifiHitCount=" + this.afm + " wifiMissCount=" + this.afn + " wifiManulClickCount=" + this.afo + " wifiPreDownCout=" + this.afl + " _4gFlowPre=" + this.afb + " _4gFlowWaste=" + this.afc + " xgFlowPre=" + this.afd + " xgFlowWaste=" + this.afe + " xgHitCount=" + this.afi + " xgMissCount=" + this.afj + " xgManulClickCount=" + this.afk + " xgPreDownCout=" + this.afh + " accFlowPreTotal=" + this.aff + " accFlowWasteTotal=" + this.afg + " requestOverLimitCount=" + this.afp);
    }
  }
  
  private void f(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Akxv.aV(paramInt1, paramInt2, paramMessageForPic.mNotPredownloadReason);
    paramMessageForPic.preDownState = 2;
    u(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.afm += 1L;
      akxo.m("wifiHitCount", this.afm, true);
      if (QLog.isColorLevel()) {
        akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",wifiHitCount:" + this.afm + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      paramLong = P(paramLong);
      b(paramInt1, this.Wt * paramLong / 100L, -paramLong, false);
      this.afi += 1L;
      this.afg -= paramLong;
      akxo.m("accFlowWasteTotal", this.afg, false);
      akxo.m("xgHitCount", this.afi, true);
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",xgHitCount:" + this.afi + ",uniseq:" + paramMessageForPic.uniseq);
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "accFlowPreTotal:" + this.aff + ",accFlowWasteTotal:" + this.afg);
  }
  
  private void g(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.mApp != null)
    {
      PicPreDownloader localPicPreDownloader = this.mApp.a();
      if (localPicPreDownloader != null)
      {
        if ((paramMessageForPic.mNotPredownloadReason != 0) && (paramMessageForPic.mNotPredownloadReason != 1)) {
          break label168;
        }
        int i = localPicPreDownloader.b(paramMessageForPic);
        this.jdField_a_of_type_Akxv.jd(paramInt1, i);
        this.jdField_a_of_type_Akxv.iZ(paramInt1, i);
        this.jdField_a_of_type_Akxv.jb(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    u(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.afn += 1L;
      akxo.m("wifiMissCount", this.afn, true);
      akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ",wifiMissCount:" + this.afn + ",uniseq:" + paramMessageForPic.uniseq);
    }
    label168:
    do
    {
      return;
      this.jdField_a_of_type_Akxv.iZ(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
      if (paramMessageForPic.mNotPredownloadReason == -1) {
        break;
      }
      this.jdField_a_of_type_Akxv.jb(paramInt1, paramInt2);
      break;
      b(paramInt1, this.Wu, 0L, false);
      this.afj += 1L;
      akxo.m("xgMissCount", this.afj, true);
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ", xgMissCount:" + this.afj + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void h(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    u(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",wifiHitCount:" + this.afm + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      b(paramInt1, this.aeO, 0L, true);
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",xgHitCount:" + this.afi + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void i(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Akxv.jc(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    u(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",wifiHitCount:" + this.afm + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      b(paramInt1, this.aeO, 0L, true);
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",xgHitCount:" + this.afi + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void initConfig()
  {
    Object localObject1 = akxo.bp("flowCombination", "12000|600|20000|400|6000|300|20000|200");
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPredownloadFlow=" + (String)localObject1);
    }
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length == 8) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): Error, use Server config");
      }
      this.aeV = akxo.b(this.mApp, "AMaxPDFlow3G", 614400L);
      this.aeW = akxo.b(this.mApp, "AMaxWFlow3G", 716800L);
      this.aeX = 0L;
      this.aeY = 0L;
      this.aeP = this.aeV;
      this.aeR = 0L;
      this.aeQ = this.aeW;
      this.aeS = 0L;
      this.aeT = (this.aeP + this.aeR);
      this.aeU = (this.aeQ + this.aeS);
      this.aeZ = (this.aeV + this.aeX);
      this.afa = (this.aeW + this.aeY);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig():_4gFlowPreLimit=" + this.aeP + " _4gFlowWasteLimit=" + this.aeQ + " _4gFlowPreFloatLimit" + this.aeR + " _4gFlowWasteFloatLimit=" + this.aeS + " xgFlowPreLimit=" + this.aeV + " xgFlowWasteLimit=" + this.aeW + " xgFlowPreFloatLimit=" + this.aeX + " xgFlowWasteFloatLimit=" + this.aeY);
      }
      localObject1 = akxo.bp("troopCombination", "20|10|50|10");
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initConfig(): PicPredownloadConfig=" + (String)localObject1);
      }
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        if (!"".equals(localObject1))
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 4) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPredownloadConfig Error, use default config");
        }
      }
      catch (Exception localException)
      {
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localException.getMessage());
        continue;
        Object localObject2 = new StringBuilder();
        int i = 0;
        if (i >= j) {
          continue;
        }
        ((StringBuilder)localObject2).append(String.valueOf(this.am[i])).append("-").append(String.valueOf(this.am[(i + 1)])).append(" ");
        i += 2;
        continue;
        localObject2 = ((StringBuilder)localObject2).toString();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initConfig(): troopDefaultCount=" + this.afq + ", troopIncreaseCountEnterAIO=" + this.afr + ", troopMaxCount=" + this.afs + ", troopMinPicSize=" + this.aft);
      }
      this.Y = Long.valueOf(akxo.i("maxRequest", 100L));
      this.aeN = akxo.i("xGPreDownPolicy", 1374942199L);
      this.Wt = akxo.i("AFBFlowHitXG", 150L);
      this.Wu = akxo.i("AFBFlowMissXG", 40960L);
      this.aeO = this.Wu;
      this.Wv = akxo.i("APicAvgSize", 71680L);
      this.Ww = akxo.i("APicMaxSize", 204800L);
      this.cvd = akxo.a("enablePeakFlow", Boolean.valueOf(false)).booleanValue();
      this.am = akxo.j();
      this.afu = akxo.i("PeakFlowMaxPicSize", 921600L);
      if (QLog.isColorLevel())
      {
        j = this.am.length;
        if ((j != 0) && ((j & 0x1) == 0)) {
          continue;
        }
        localObject1 = "Error(Length=" + j + ")";
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): xGPreDownPolicy=" + this.aeN + " xgFlowHitFeedback=" + this.Wt + " XgFlowMissFeedback=" + this.Wu + " XgFlowLeftRightFeddback=" + this.aeO + " pisSizeAvg=" + this.Wv + " pisSizeMax=" + this.Ww + " mEnablePeakFlow=" + this.cvd + " mPeakFlowTimePeriod=" + (String)localObject1 + " mPeakFlowMaxPicSize=" + this.afu + ", mRequestListMaxSize=" + this.Y);
      }
      return;
      this.aeP = (Integer.valueOf(localObject1[0]).intValue() * 1024);
      this.aeR = (Integer.valueOf(localObject1[1]).intValue() * 1024);
      this.aeQ = (Integer.valueOf(localObject1[2]).intValue() * 1024);
      this.aeS = (Integer.valueOf(localObject1[3]).intValue() * 1024);
      this.aeV = (Integer.valueOf(localObject1[4]).intValue() * 1024);
      this.aeX = (Integer.valueOf(localObject1[5]).intValue() * 1024);
      this.aeW = (Integer.valueOf(localObject1[6]).intValue() * 1024);
      this.aeY = (Integer.valueOf(localObject1[7]).intValue() * 1024);
      break;
      this.afq = Long.parseLong(localObject1[0]);
      this.afr = Long.parseLong(localObject1[1]);
      this.afs = Long.parseLong(localObject1[2]);
      this.aft = (Long.parseLong(localObject1[3]) * 1024L);
      this.dw.set(true);
    }
  }
  
  public void NU(String paramString)
  {
    if (this.jdField_a_of_type_Acol == null) {}
    TroopStatisticsInfo localTroopStatisticsInfo;
    do
    {
      do
      {
        return;
        if (this.dw.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      return;
      localTroopStatisticsInfo = this.jdField_a_of_type_Acol.a(paramString);
      if (localTroopStatisticsInfo == null) {
        break label139;
      }
      paramString = Long.valueOf(localTroopStatisticsInfo.count - 1L);
      if (paramString.longValue() >= 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = 0");
    return;
    localTroopStatisticsInfo.count = paramString.longValue();
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_Acol.addCache(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = " + paramString.count);
      return;
      label139:
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = (this.afq - 1L);
    }
  }
  
  public void NV(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.w("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO() troopid is null");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Acol == null);
      if (this.dw.get()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
    return;
    TroopStatisticsInfo localTroopStatisticsInfo = this.jdField_a_of_type_Acol.a(paramString);
    long l1;
    if (localTroopStatisticsInfo != null)
    {
      long l2 = localTroopStatisticsInfo.count + this.afr;
      l1 = l2;
      if (l2 > this.afs) {
        l1 = this.afs;
      }
      localTroopStatisticsInfo.count = l1;
    }
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_Acol.updateCache(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO troopRemainCount=" + l1);
      return;
      l1 = this.afq;
      l1 = this.afr + l1;
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = l1;
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (i != 0) {
      paramInt1 = i;
    }
    do
    {
      boolean bool;
      do
      {
        return paramInt1;
        i = 0;
        bool = asR();
        if (QLog.isColorLevel()) {
          akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "NetworkType:" + paramInt2 + " isInDPCWhiteList:" + bool);
        }
        if (paramInt2 != 0) {
          break;
        }
        paramInt1 = i;
      } while (!QLog.isColorLevel());
      akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "Wifi, result=" + 0);
      return 0;
      if ((!bool) || (paramInt2 == 3)) {
        break;
      }
      paramInt1 = i;
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "InDPCWhiteList, result=" + 0);
    return 0;
    long l3 = P(paramLong);
    long l1;
    label211:
    long l2;
    if (paramBoolean) {
      if (paramInt2 == 1)
      {
        paramLong = this.aeQ;
        if (paramInt2 != 1) {
          break label388;
        }
        l1 = this.afb - this.aeR;
        if (paramInt2 != 1) {
          break label402;
        }
        l2 = this.afc;
        label223:
        if ((l1 >= l3) && (l2 + l3 < paramLong)) {
          break label482;
        }
        if (l1 >= l3) {
          break label475;
        }
        i = -9;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + i + ",FlowWaste +picSize=" + (l2 + l3) + ",FlowWasteLimit：" + paramLong + ",FlowPre:" + l1 + ",picSize:" + l3 + ",FlowWaste:" + l2 + ",uinType:" + paramInt1 + ",networkType:" + paramInt2 + ",isDynamic:" + paramBoolean);
      }
      return i;
      paramLong = this.aeW;
      break;
      label388:
      l1 = this.afd - this.aeX;
      break label211;
      label402:
      l2 = this.afe;
      break label223;
      if (paramInt2 == 1)
      {
        paramLong = this.aeU;
        label422:
        if (paramInt2 != 1) {
          break label457;
        }
        l1 = this.afb;
        label434:
        if (paramInt2 != 1) {
          break label466;
        }
      }
      label457:
      label466:
      for (l2 = this.afc;; l2 = this.afe)
      {
        break;
        paramLong = this.afa;
        break label422;
        l1 = this.afd;
        break label434;
      }
      label475:
      i = -10;
      continue;
      label482:
      if ((!paramBoolean) && (l1 - l3 < this.aeR)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    boolean bool1;
    if ((asR()) && (paramInt2 != 3))
    {
      j = akxo.o(0, paramInt1, 0);
      i = akxo.o(0, paramInt1, 1);
      if ((this.aeN >> j & 1L) != 1L) {
        break label172;
      }
      bool1 = true;
      label44:
      if ((this.aeN >> i & 1L) != 1L) {
        break label178;
      }
    }
    label172:
    label178:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        akxe.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2 + ",xGPreDownPolicy:" + this.aeN);
      }
      return new boolean[] { bool1, bool2 };
      j = akxo.o(paramInt2, paramInt1, 0);
      i = akxo.o(paramInt2, paramInt1, 1);
      break;
      bool1 = false;
      break label44;
    }
  }
  
  public void aM(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.afl += 1L;
      akxo.m("wifiPreDownCout", this.afl, true);
    }
    do
    {
      return;
      paramLong = P(paramLong);
      b(paramInt, -paramLong, paramLong, false);
      this.aff += paramLong;
      this.afg += paramLong;
      this.afh += 1L;
      akxo.m("accFlowPreTotal", this.aff, false);
      akxo.m("accFlowWasteTotal", this.afg, false);
      akxo.m("xgPreDownCount", this.afh, true);
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + paramInt + ",wifiPreDownCout:" + this.afl + ",xgPreDownCout:" + this.afh);
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "accFlowPreTotal:" + this.aff + ",accFlowWasteTotal:" + this.afg);
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      u(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType != 0) {
        break label55;
      }
    }
    label55:
    do
    {
      return;
      paramLong = this.Wv - paramLong;
      b(paramMessageForPic.preDownNetworkType, paramLong, -paramLong, false);
      this.aff -= paramLong;
      this.afg -= paramLong;
      akxo.m("accFlowPreTotal", this.aff, false);
      akxo.m("accFlowWasteTotal", this.afg, true);
    } while (!QLog.isColorLevel());
    akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.aff + ",accFlowWasteTotal:" + this.afg);
  }
  
  public void c(MessageForPic paramMessageForPic, long paramLong)
  {
    if (this.jdField_a_of_type_Akxv == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((paramMessageForPic.isSendFromLocal()) || (paramMessageForPic.subVersion < 5));
      i = akxo.b(this.mApp, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramMessageForPic.preDownState == 1)
      {
        f(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
        return;
      }
      if (paramMessageForPic.preDownState == 0)
      {
        if (a(i, paramMessageForPic.preDownNetworkType)[1] == 0)
        {
          i(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
          return;
        }
        g(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
        return;
      }
    } while (paramMessageForPic.preDownState != 4);
    h(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
  }
  
  public void dDY()
  {
    this.afp = 0L;
    this.afm = 0L;
    this.afn = 0L;
    this.afo = 0L;
    this.afl = 0L;
    this.afc = 0L;
    this.afe = 0L;
    this.afi = 0L;
    this.afj = 0L;
    this.afk = 0L;
    this.afh = 0L;
    akxo.m("requestListOverLimitCount", this.afp, false);
    akxo.m("wifiHitCount", this.afm, false);
    akxo.m("wifiMissCount", this.afn, false);
    akxo.m("wifiManulClickCount", this.afo, false);
    akxo.m("wifiPreDownCout", this.afl, false);
    akxo.m("4gFlowWaste", this.afc, false);
    akxo.m("xgFlowWaste", this.afe, false);
    akxo.m("xgHitCount", this.afi, false);
    akxo.m("xgMissCount", this.afj, false);
    akxo.m("xgManulClickCount", this.afk, false);
    akxo.m("xgPreDownCount", this.afh, true);
  }
  
  public boolean f(MessageForPic paramMessageForPic)
  {
    if (akxo.b(this.mApp, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {}
    label346:
    for (;;)
    {
      return true;
      if (!this.cvd)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime(): Peek Flow is disable[true]");
          return true;
        }
      }
      else
      {
        if (this.am == null) {}
        for (int i = 0; (i == 0) || ((i & 0x1) != 0); i = this.am.length)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime():  The length(" + i + ") of PeakFlowTimePeriod is error![false]");
          }
          return false;
        }
        int k = Calendar.getInstance().get(11);
        int j = 0;
        for (;;)
        {
          if (j >= i) {
            break label346;
          }
          if ((k >= this.am[j]) && (k < this.am[(j + 1)]))
          {
            if (paramMessageForPic.size > this.afu)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "picSize=" + paramMessageForPic.size + " is larger than PeakFlowMaxPicSize(" + this.afu + ")[false]");
              }
              return false;
            }
            if ((paramMessageForPic.size > this.aft) && (getNetworkType() == 0))
            {
              if (!nR(paramMessageForPic.frienduin)) {
                return false;
              }
              if (!paramMessageForPic.hasBigFile())
              {
                NU(paramMessageForPic.frienduin);
                return true;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download because the pic.size=" + paramMessageForPic.size + " < troopMinPicSize=" + this.aft);
            }
          }
          j += 2;
        }
      }
    }
  }
  
  int getNetworkType()
  {
    return akxo.Hi();
  }
  
  public HashMap<String, String> getReportInfo()
  {
    HashMap localHashMap = new HashMap();
    long l1 = akxo.i("4gFlowPre", this.afb);
    long l2 = akxo.i("4gFlowWaste", this.afc);
    long l3 = akxo.i("xgFlowPre", this.afd);
    long l4 = akxo.i("xgFlowWaste", this.afe);
    long l5 = akxo.i("accFlowPreTotal", this.aff);
    long l6 = akxo.i("xgPreDownCount", this.afh);
    long l7 = akxo.i("xgHitCount", this.afi);
    long l8 = akxo.i("xgMissCount", this.afj);
    long l9 = akxo.i("wifiPreDownCout", this.afl);
    long l10 = akxo.i("wifiHitCount", this.afm);
    long l11 = akxo.i("wifiMissCount", this.afn);
    long l12 = akxo.i("xgManulClickCount", this.afk);
    long l13 = akxo.i("wifiManulClickCount", this.afo);
    long l14 = akxo.i("requestListOverLimitCount", this.afp);
    if (QLog.isColorLevel()) {
      akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", "\n|- sp4gFlowPre:" + l1 + "\n|- sp4gFlowWaste:" + l2 + "\n|- spXgFlowPre:" + l3 + "\n|-  spXgFlowWaste：" + l4 + "\n|-  spFlowPreTotal:" + l5 + "\n|-  spXgPreDownCount：" + l6 + "\n|-  spXgHitCount:" + l7 + "\n|-  spXgMissCount：" + l8 + "\n|-  spWifiPreDownCount:" + l9 + "\n|-  spWifiHitCount：" + l10 + "\n|-  spWifiMissCount:" + l11 + "\n|-  spXgManulClickCount：" + l12 + "\n|-  spWifiManulClickCount:" + l13 + "\n|-  spRequestOverLimitCount:" + l14);
    }
    localHashMap.put("4gFlowPre", String.valueOf(l1));
    localHashMap.put("4gFlowWaste", String.valueOf(l2));
    localHashMap.put("xgFlowPre", String.valueOf(l3));
    localHashMap.put("xgFlowWaste", String.valueOf(l4));
    if ((l7 != 0L) || (l8 != 0L) || (l6 != 0L))
    {
      localHashMap.put("accFlowPreTotal", String.valueOf(l5));
      localHashMap.put("xgPreDownCount", String.valueOf(l6));
      localHashMap.put("xgHitCount", String.valueOf(l7));
      localHashMap.put("xgMissCount", String.valueOf(l6 - l7));
      localHashMap.put("xgManulClickCount", String.valueOf(l12));
      localHashMap.put("xgFlowWasteBalance", String.valueOf(this.aeW - l4));
    }
    localHashMap.put("wifiPreDownCout", String.valueOf(l9));
    localHashMap.put("wifiHitCount", String.valueOf(l10));
    localHashMap.put("wifiMissCount", String.valueOf(l11));
    localHashMap.put("wifiManulClickCount", String.valueOf(l13));
    localHashMap.put("requestListOverLimitCount", String.valueOf(this.afp));
    return localHashMap;
  }
  
  public boolean nR(String paramString)
  {
    if (this.jdField_a_of_type_Acol == null) {}
    do
    {
      do
      {
        return true;
        if (this.dw.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      return true;
      paramString = this.jdField_a_of_type_Acol.a(paramString);
    } while ((paramString == null) || (paramString.count - 1L >= 0L));
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "don't predownload because troopRemainCount = 0");
    }
    return false;
  }
  
  public void u(MessageForPic paramMessageForPic)
  {
    akxo.b(this.mApp, paramMessageForPic);
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    super.z(paramQQAppInterface);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Akxv = ((akxv)this.mApp.getManager(73));
    this.jdField_a_of_type_Acol = ((acol)this.mApp.a().getCache(3));
    initConfig();
    dDX();
    long l = System.currentTimeMillis();
    if (l - akxo.i("lastDayTime", 0L) > 86400000L)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      akxo.m("lastDayTime", l, true);
      akxp.k(str, getReportInfo());
      dDY();
      ((akxv)paramQQAppInterface.getManager(73)).cRT();
    }
    if (QLog.isColorLevel()) {
      akxe.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxz
 * JD-Core Version:    0.7.0.1
 */