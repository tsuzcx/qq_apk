import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laonh;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class aojn
  implements aolm.b, aoqm.a, aqoi, ProtoReqManager.b
{
  private static ArrayList<aook> Bn;
  protected static aolm.a b;
  public static String cle;
  static ConcurrentHashMap<String, Integer> iD = new ConcurrentHashMap();
  private static Object lock;
  protected List<ProxyIpManager.ProxyIp> Ha;
  StringBuilder W = new StringBuilder();
  public aojm a;
  protected aojn.a a;
  protected aomg a;
  protected aomy a;
  protected aona.d a;
  protected aoql.a a;
  protected AppInterface app;
  long aps = 0L;
  long apt = 0L;
  long apu = 0L;
  protected long apv;
  protected aojn.a b;
  public aoko b;
  private int brX;
  protected aojn.a c;
  public aolm c;
  protected boolean cLT = false;
  protected boolean cLU = false;
  protected boolean cLV;
  private boolean cLW;
  boolean cLX = false;
  boolean cLY = false;
  boolean cLZ = false;
  boolean cMa = true;
  String clc = "P";
  String cld = "Q";
  protected aojn.a d = new aojn.a();
  int dOR = -9528;
  int dOS = -9529;
  int dOT = -9530;
  int dOU = -9531;
  int dOV = -9532;
  int dOW = -9533;
  int dOX = -1;
  protected int dOY = 0;
  protected int dOZ = 0;
  protected int dPa;
  public int errCode = 9001;
  public String errDesc = "";
  public aool h;
  private String key;
  protected long mEndTime;
  boolean mIsCancel = false;
  boolean mIsPause = false;
  protected HashMap<String, String> mM = new HashMap();
  protected int mProgress;
  public long mStartTime;
  private int mState;
  public String reason = "";
  
  static
  {
    Bn = new ArrayList();
    lock = new Object();
    cle = "param_reason";
    jdField_b_of_type_Aolm$a = new aojo();
  }
  
  public aojn()
  {
    this.jdField_a_of_type_Aomy = new aomy();
    this.jdField_a_of_type_Aojn$a = new aojn.a();
    this.jdField_b_of_type_Aojn$a = new aojn.a();
    this.jdField_c_of_type_Aojn$a = new aojn.a();
  }
  
  public aojn(aojm paramaojm, aool paramaool)
  {
    this.jdField_a_of_type_Aomy = new aomy();
    this.jdField_a_of_type_Aojn$a = new aojn.a();
    this.jdField_b_of_type_Aojn$a = new aojn.a();
    this.jdField_c_of_type_Aojn$a = new aojn.a();
    this.app = paramaojm.app;
    this.mStartTime = System.nanoTime();
    akxe.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.mStartTime + "ns,Processor = " + this);
    this.jdField_b_of_type_Aoko = new aoko();
    this.jdField_a_of_type_Aojm = paramaojm;
    this.h = paramaool;
    this.jdField_b_of_type_Aoko.fileType = this.h.mFileType;
    this.jdField_b_of_type_Aoko.uniseq = this.h.mUniseq;
    this.jdField_b_of_type_Aoko.uinType = this.h.mUinType;
    this.jdField_b_of_type_Aoko.friendUin = this.h.mPeerUin;
    paramaojm = this.jdField_b_of_type_Aoko;
    if (this.h.cNy) {
      i = 0;
    }
    paramaojm.actionType = i;
    this.jdField_c_of_type_Aolm = this.app.getNetEngine(0);
    dVb();
  }
  
  public aojn(aooi paramaooi)
  {
    this.jdField_a_of_type_Aomy = new aomy();
    this.jdField_a_of_type_Aojn$a = new aojn.a();
    this.jdField_b_of_type_Aojn$a = new aojn.a();
    this.jdField_c_of_type_Aojn$a = new aojn.a();
    this.jdField_a_of_type_Aojm = paramaooi;
    this.app = paramaooi.mApp;
    this.jdField_b_of_type_Aoko = new aoko();
    this.mStartTime = System.nanoTime();
  }
  
  public aojn(String paramString1, String paramString2, boolean paramBoolean, aooi paramaooi)
  {
    this.jdField_a_of_type_Aomy = new aomy();
    this.jdField_a_of_type_Aojn$a = new aojn.a();
    this.jdField_b_of_type_Aojn$a = new aojn.a();
    this.jdField_c_of_type_Aojn$a = new aojn.a();
    this.jdField_a_of_type_Aojm = paramaooi;
    this.app = paramaooi.mApp;
    this.mStartTime = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_b_of_type_Aoko = new aoko(paramString1, paramString2, i);
      this.jdField_b_of_type_Aoko.jdField_a_of_type_Aojn = this;
      return;
      i = 1;
    }
  }
  
  public static void a(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (lock)
    {
      if ((Bn != null) && (!Bn.isEmpty()))
      {
        Iterator localIterator = Bn.iterator();
        aook localaook;
        Object localObject2;
        do
        {
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localaook = (aook)localIterator.next();
              localObject2 = localaook.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localaook.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localaook.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  public static boolean a(int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt == -9530) || (paramInt == -9532) || (paramInt == -9533) || (paramInt == -9531))
    {
      paramHashMap.put(cle, x("Q", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    if ((paramInt == -9528) || (paramInt == -9529))
    {
      paramHashMap.put(cle, x("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    return false;
  }
  
  private void adc()
  {
    if (this.cLW)
    {
      int i = KK();
      if (i > this.mProgress) {
        this.mProgress = i;
      }
    }
  }
  
  public static String bH(long paramLong)
  {
    return "T_" + paramLong;
  }
  
  public static String bI(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static void c(aook paramaook)
  {
    synchronized (lock)
    {
      if (!Bn.contains(paramaook)) {
        Bn.add(paramaook);
      }
      return;
    }
  }
  
  public static void d(aook paramaook)
  {
    synchronized (lock)
    {
      Bn.remove(paramaook);
      return;
    }
  }
  
  private void dVa()
  {
    if (this.jdField_b_of_type_Aoko != null)
    {
      if (this.jdField_b_of_type_Aoko.actionType == 0) {
        VR(1002);
      }
    }
    else {
      return;
    }
    VR(2002);
  }
  
  public static String e(int paramInt, long paramLong)
  {
    return "H_" + paramInt + "_" + paramLong;
  }
  
  public static String f(Exception paramException)
  {
    return aoja.e(paramException);
  }
  
  private void h(aomh paramaomh)
  {
    long l1 = 0L;
    if ((paramaomh.reqCost != 0L) && (this.cMa)) {
      if (paramaomh.nR.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i = Integer.parseInt((String)paramaomh.nR.get("X-httime"));; i = 0)
    {
      if (paramaomh.nR.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramaomh.nR.get("X-piccachetime"));
      }
      long l2 = i - l1;
      long l3 = paramaomh.reqCost - i;
      this.apt += l3;
      this.aps += l2;
      this.apu += l1;
      this.W.append("s").append(this.dPa).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.dPa += 1;
      this.apv = paramaomh.apv;
      return;
      label219:
      this.cMa = false;
    }
  }
  
  static boolean m(List<ProxyIpManager.ProxyIp> paramList, List<aonh> paramList1)
  {
    if ((paramList1 == null) || (paramList == null) || (paramList.isEmpty()) || (paramList1.contains(paramList.get(0)))) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProxyIpManager.ProxyIp localProxyIp = (ProxyIpManager.ProxyIp)paramList.next();
      Object localObject = paramList1.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aonh localaonh = (aonh)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localaonh.mIp)) && (localProxyIp.port == localaonh.port)) {
          paramList1.remove(localaonh);
        }
      }
      localObject = new aonh();
      ((aonh)localObject).mIp = localProxyIp.ip;
      ((aonh)localObject).port = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static String or(String paramString)
  {
    return "C_" + paramString;
  }
  
  public static String x(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  protected String AJ()
  {
    return null;
  }
  
  public int EN()
  {
    return 0;
  }
  
  public void Hp(String paramString) {}
  
  public int KH()
  {
    return 0;
  }
  
  public int KK()
  {
    int j = 0;
    int i = j;
    if (this.jdField_b_of_type_Aoko != null)
    {
      i = j;
      if (this.jdField_b_of_type_Aoko.fileSize > 0L)
      {
        j = (int)(this.jdField_b_of_type_Aoko.transferedSize * 100L / this.jdField_b_of_type_Aoko.fileSize);
        i = j;
        if (this.jdField_b_of_type_Aoko.actionType == 0) {
          if (this.jdField_b_of_type_Aoko.fileType != 1)
          {
            i = j;
            if (this.jdField_b_of_type_Aoko.fileType != 131075) {}
          }
          else
          {
            i = j;
            if (j == 100)
            {
              i = j;
              if (this.jdField_b_of_type_Aoko.status != 1003) {
                i = 99;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  @Deprecated
  public void L(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      aoko.a locala = a(paramInt1);
      if (locala != null)
      {
        locala.errCode = paramInt2;
        locala.errDesc = paramString;
        locala.result = false;
        VQ(paramInt1);
      }
      dN(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  public void P(boolean paramBoolean, long paramLong)
  {
    int j = 0;
    this.mM.put("ipStackType", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
    this.mM.put("msfConnIPType", String.valueOf(MsfServiceSdk.get().getConnectedIPFamily()));
    aoji localaoji;
    HashMap localHashMap;
    if ((this instanceof aojr))
    {
      this.mM.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getInstance().mBdhStrategy));
      if ((this instanceof aoji))
      {
        localaoji = (aoji)this;
        if (localaoji.cLN) {
          this.mM.put("param_is_ipv6", String.valueOf(1));
        }
        localHashMap = this.mM;
        if (!localaoji.mHasIpv6List) {
          break label272;
        }
      }
    }
    label272:
    for (int i = 1;; i = 0)
    {
      localHashMap.put("param_hasV6List", String.valueOf(i));
      localHashMap = this.mM;
      i = j;
      if (localaoji.cLN) {
        i = 1;
      }
      localHashMap.put("param_ipv6First", String.valueOf(i));
      if ((this.mM.get("param_is_ipv6") != null) && (((String)this.mM.get("param_is_ipv6")).equals(String.valueOf(1)))) {
        anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ() + "_ipv6", paramBoolean, paramLong, 0L, this.mM, "");
      }
      return;
      this.mM.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getInstance().mRMDownStrategy));
      break;
    }
  }
  
  public void QV(boolean paramBoolean) {}
  
  public void QW(boolean paramBoolean)
  {
    this.cLW = paramBoolean;
  }
  
  protected void QX(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.errCode == 0)) {
      QLog.d("BaseTransProcessor", 1, new Throwable().getStackTrace());
    }
    this.mM.put("param_check_result", String.valueOf(paramBoolean));
    this.mM.put("param_check_FailCode", String.valueOf(this.errCode));
  }
  
  @Deprecated
  public void VP(int paramInt)
  {
    bW(paramInt, false);
  }
  
  @Deprecated
  public void VQ(int paramInt)
  {
    try
    {
      aoko.a locala = a(paramInt);
      if (locala != null) {
        locala.finishTime = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  protected void VR(int paramInt)
  {
    aq(paramInt, 0L);
  }
  
  public void VS(int paramInt)
  {
    this.jdField_b_of_type_Aoko.setFileType(paramInt);
  }
  
  @Deprecated
  public aoko.a a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_b_of_type_Aoko.jdField_a_of_type_Aoko$a;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_b_of_type_Aoko.jdField_b_of_type_Aoko$a;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_b_of_type_Aoko.jdField_a_of_type_Aoko$b;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_b_of_type_Aoko.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_b_of_type_Aoko.jdField_b_of_type_Aoko$b;
      }
    }
  }
  
  aool a()
  {
    return this.h;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, aojn.a parama)
  {
    this.errCode = paramInt;
    this.reason = paramString2;
    this.errDesc = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.mM.put("param_reason", paramString2);
    }
    if (parama != null)
    {
      parama.dVg();
      parama.result = 0;
    }
  }
  
  public void a(aojn.a parama, aomh paramaomh, boolean paramBoolean)
  {
    if ((parama == null) || (paramaomh == null)) {
      return;
    }
    this.mM.put("param_Server", paramaomh.nR.get("serverip"));
    if (paramBoolean)
    {
      this.mM.put("serverip", paramaomh.nR.get("serverip"));
      parama.dPb += 1;
      parama.dPc += paramaomh.dPH - 1;
      parama.dVg();
      parama.result = 1;
      this.mM.remove("param_url");
      this.mM.remove("param_rspHeader");
      return;
    }
    this.mM.put("serverip", paramaomh.nR.get("firstserverip"));
    parama.dPc += paramaomh.dPH;
    if (paramaomh.mErrCode == -9527) {}
    for (String str = (String)paramaomh.nR.get("netresp_param_reason");; str = null)
    {
      a(paramaomh.mErrCode, paramaomh.clO, str, parama);
      this.mM.put("param_url", paramaomh.nR.get("param_url"));
      this.mM.put("param_rspHeader", paramaomh.nR.get("param_rspHeader"));
      if ((paramaomh.mErrCode == -9527) && ("H_404_-124".equals(str))) {
        this.mM.put("param_reqHeader", paramaomh.nR.get("param_reqHeader"));
      }
      parama.result = 0;
      return;
    }
  }
  
  public void a(aojn.a parama, aoql.b.m paramm)
  {
    if ((parama != null) && (paramm != null))
    {
      parama.dVg();
      parama.dPb = paramm.successCount;
      parama.dPc = paramm.failCount;
      if (paramm.result == 0) {
        parama.result = 1;
      }
    }
    else
    {
      return;
    }
    parama.result = 0;
    a(paramm.errCode, paramm.errStr, paramm.reason, parama);
  }
  
  public void a(aojn.a parama, boolean paramBoolean1, boolean paramBoolean2, achq.a parama1)
  {
    if (parama1 == null) {
      return;
    }
    parama.dVg();
    if (paramBoolean2)
    {
      parama.dPc = (parama1.retryCount - 1);
      parama.dPb = 1;
      parama.result = 1;
      return;
    }
    String str;
    if (parama1.errCode == 2900)
    {
      i = -9527;
      if (!paramBoolean1) {}
      for (str = bI(parama1.Qw);; str = bH(parama1.Qw))
      {
        a(i, "", str, parama);
        parama.dPc = parama1.retryCount;
        parama.dPb = 0;
        parama.result = 0;
        return;
      }
    }
    if ((parama1.errCode == 1002) || (parama1.errCode == 1013))
    {
      if (!paramBoolean1) {}
      for (i = 9350;; i = 9311)
      {
        str = parama1.timeoutReason;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i = 9351;; i = 9044)
    {
      str = parama1.timeoutReason;
      break;
    }
  }
  
  public void a(aoql.a parama, aoql.b paramb) {}
  
  public void a(aqog paramaqog1, aqog paramaqog2) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc) {}
  
  void a(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {
      dN(9039, paramIOException);
    }
    do
    {
      return;
      if (paramIOException.contains("ENOSPC"))
      {
        dN(9040, paramIOException);
        return;
      }
      if (paramIOException.contains("Read-only"))
      {
        dN(9039, paramIOException);
        return;
      }
    } while ("mounted".equals(str));
    dN(9039, paramIOException);
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    return true;
  }
  
  protected void aq(int paramInt, long paramLong)
  {
    j(paramInt, 0, paramLong);
  }
  
  public boolean azP()
  {
    return this.cLX;
  }
  
  protected boolean azQ()
  {
    return (this.app.isRunning()) && (this.app.isLogin());
  }
  
  protected boolean azR()
  {
    return (!this.mIsCancel) && (!this.mIsPause);
  }
  
  public aoko b()
  {
    return this.jdField_b_of_type_Aoko;
  }
  
  @Deprecated
  public void b(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      aoko.b localb = this.jdField_b_of_type_Aoko.jdField_a_of_type_Aoko$b;
      localb.errCode = paramInt1;
      localb.result = false;
      localb.errDesc = paramString;
      localb.cRn = paramInt2;
      localb.apL = paramLong;
      dN(localb.errCode, localb.errDesc);
      VQ(2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2) {}
  
  @Deprecated
  public void bW(int paramInt, boolean paramBoolean)
  {
    try
    {
      aoko.a locala = a(paramInt);
      if ((locala != null) && ((locala.startTime == 0L) || (paramBoolean))) {
        locala.startTime = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void cZ(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aomy.mReason == null) {
      this.jdField_a_of_type_Aomy.mReason = this.reason;
    }
    if (this.jdField_a_of_type_Aomy.clO == null) {
      this.jdField_a_of_type_Aomy.clO = this.errDesc;
    }
    this.jdField_a_of_type_Aomy.cmb = (this.h.mUinType + "");
    this.jdField_a_of_type_Aomy.cmc = (this.h.mPeerUin + "");
    if ((this instanceof aojr)) {}
    for (this.jdField_a_of_type_Aomy.dPX = Ipv6Config.getInstance().mBdhStrategy;; this.jdField_a_of_type_Aomy.dPX = Ipv6Config.getInstance().mRMDownStrategy)
    {
      if ((this.jdField_b_of_type_Aojn$a != null) && (this.jdField_b_of_type_Aojn$a.startTime > 0L)) {
        this.jdField_a_of_type_Aomy.mTimeCost = ((System.nanoTime() - this.jdField_b_of_type_Aojn$a.startTime) / 1000000L);
      }
      this.jdField_a_of_type_Aomy.da(paramString, paramBoolean);
      return;
    }
  }
  
  public int cancel()
  {
    if (this.h != null) {
      if (!this.h.cNy) {
        break label195;
      }
    }
    label195:
    for (int i = 1004;; i = 2004)
    {
      VR(i);
      this.mIsCancel = true;
      if ((QLog.isColorLevel()) && (this.h != null)) {
        hM("cancel", "");
      }
      if (this.jdField_a_of_type_Aoql$a != null)
      {
        aoqm.d(this.jdField_a_of_type_Aoql$a);
        this.jdField_a_of_type_Aoql$a = null;
      }
      if (this.jdField_a_of_type_Aomg != null)
      {
        this.jdField_c_of_type_Aolm.b(this.jdField_a_of_type_Aomg);
        this.jdField_a_of_type_Aomg = null;
      }
      this.jdField_a_of_type_Aojm.oy(getKey());
      try
      {
        if (this.h != null)
        {
          aoom localaoom = this.h.a;
          if (localaoom != null)
          {
            localaoom.mResult = -1;
            localaoom.aqr = 9037L;
            localaoom.i = this.h;
          }
        }
        if (this.h != null) {
          hM("cancel", "");
        }
        notifyAll();
        if (this.h != null) {
          hM("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public void dN(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void dUR() {}
  
  protected void dUZ()
  {
    if (this.jdField_b_of_type_Aoko != null)
    {
      adc();
      dVa();
    }
  }
  
  public void dVb()
  {
    boolean bool = false;
    Integer localInteger = (Integer)iD.get(this.h.getKey());
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      this.dOZ = i;
      if (this.h.dQF < 3) {
        bool = true;
      }
      this.cLT = bool;
      return;
    }
  }
  
  public void dVc()
  {
    iD.put(this.h.getKey(), Integer.valueOf(this.dOZ));
    if (iD.size() > 2000) {
      iD.clear();
    }
  }
  
  protected void dVd()
  {
    this.errCode = 0;
    this.errDesc = "";
    this.mM.clear();
  }
  
  protected void dVe() {}
  
  protected void doReport(boolean paramBoolean) {}
  
  public long fF()
  {
    return this.jdField_b_of_type_Aoko.transferedSize;
  }
  
  public int getCurrentProgress()
  {
    return this.brX;
  }
  
  public long getFileSize()
  {
    return this.jdField_b_of_type_Aoko.fileSize;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getProgress()
  {
    int j = 0;
    int i;
    if (this.cLW) {
      i = this.mProgress;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.jdField_b_of_type_Aoko == null);
      i = j;
    } while (this.jdField_b_of_type_Aoko.fileSize <= 0L);
    return (int)(this.jdField_b_of_type_Aoko.transferedSize * 100L / this.jdField_b_of_type_Aoko.fileSize);
  }
  
  public void hM(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_Aoko == null) {
      akxe.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof aonn)) {
        break;
      }
    } while (this.h == null);
    aonc.a("T", aonc.fG(this.h.mUinType), aonc.fH(this.jdField_b_of_type_Aoko.fileType), String.valueOf(this.jdField_b_of_type_Aoko.uniseq), paramString1, paramString2, null);
    return;
    int i = -1;
    if (this.h != null) {
      i = this.h.mUinType;
    }
    if ((this instanceof aojs))
    {
      i = 0;
      if (this.h == null) {
        break label162;
      }
      bool = this.h.cNy;
    }
    for (;;)
    {
      aonc.b(aonc.fG(i), bool, aonc.fH(this.jdField_b_of_type_Aoko.fileType), String.valueOf(this.jdField_b_of_type_Aoko.uniseq), paramString1, paramString2);
      return;
      if (!(this instanceof aojv)) {
        break;
      }
      i = 0;
      break;
      label162:
      if (this.jdField_b_of_type_Aoko.actionType == 0) {
        bool = true;
      }
    }
  }
  
  public long hh()
  {
    return this.jdField_b_of_type_Aoko.status;
  }
  
  public long hi()
  {
    return this.jdField_b_of_type_Aoko.dOx;
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  protected String j(String paramString, List<aonh> paramList)
  {
    Object localObject1 = null;
    if ((this.Ha == null) || (this.Ha.isEmpty()))
    {
      paramList = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("PROXY_IP", 2, "[HTTP] proxy Ip List is empty use common conn!");
        paramList = paramString;
      }
    }
    aonh localaonh;
    do
    {
      return paramList;
      localaonh = aonc.a(paramString);
      if (localaonh != null) {
        break;
      }
      paramList = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip fail, host is domain");
    return paramString;
    Object localObject2 = this.Ha.iterator();
    int i = 0;
    label88:
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ProxyIpManager.ProxyIp)((Iterator)localObject2).next();
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localaonh.mIp)) || (((ProxyIpManager.ProxyIp)localObject3).port != localaonh.port)) {
        break label617;
      }
      i = 1;
    }
    label617:
    for (;;)
    {
      break label88;
      if (i == 0)
      {
        localObject1 = (ProxyIpManager.ProxyIp)this.Ha.get(0);
        paramList = paramString;
        if (paramString == null) {
          break;
        }
        if (paramString.startsWith("http://")) {
          paramList = "http://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/";
        }
      }
      for (;;)
      {
        paramString = aonc.bJ(paramString, paramList);
        paramString = paramString + "&bHost=" + localaonh.mIp + "&bPort=" + localaonh.port;
        paramList = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port);
        return paramString;
        if (paramString.startsWith("https://"))
        {
          paramList = "https://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/";
          continue;
          localObject3 = paramList.iterator();
          paramList = (List<aonh>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (aonh)((Iterator)localObject3).next();
            Iterator localIterator = this.Ha.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((aonh)localObject2).mIp.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((aonh)localObject2).port == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<aonh>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((aonh)localObject2).mIp + "&bPort=" + ((aonh)localObject2).port;
          }
          paramList = (List<aonh>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localaonh.mIp + ":" + localaonh.port);
          return localObject1;
        }
        paramList = null;
      }
    }
  }
  
  protected void j(int paramInt1, int paramInt2, long paramLong)
  {
    hM("updateUiState", "state:" + paramInt1 + " ret:" + paramInt2 + " currentProgress:" + this.brX + " mProgress:" + this.mProgress);
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.errCode == 9001))
    {
      String str = aoja.e(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
    }
    this.mEndTime = System.currentTimeMillis();
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    boolean bool;
    if ((l > 60000L) || (paramInt1 == 1005))
    {
      bool = true;
      if (l <= 60000L) {
        break label209;
      }
      aonc.aN(true, "image_sending_too_long");
    }
    for (;;)
    {
      k(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      aonc.aN(bool, "image_sending_" + this.errCode + "_" + this.errDesc);
    }
  }
  
  protected void k(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mIsCancel) {
      return;
    }
    synchronized (lock)
    {
      this.mState = paramInt1;
      if ((Bn != null) && (!Bn.isEmpty()))
      {
        Iterator localIterator = Bn.iterator();
        aook localaook;
        do
        {
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localaook = (aook)localIterator.next();
              localObject3 = localaook.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localaook.obtainMessage();
        this.jdField_b_of_type_Aoko.dOx = this.jdField_b_of_type_Aoko.status;
        this.jdField_b_of_type_Aoko.status = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_b_of_type_Aoko;
        ((Message)localObject4).arg1 = paramInt2;
        localaook.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void k(ArrayList<aonh> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramString != null))
    {
      aonh localaonh = new aonh();
      localaonh.mIp = paramString;
      localaonh.cNn = true;
      paramArrayList.add(localaonh);
    }
  }
  
  public String n(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, acbn.SDCARD_PATH + this.app.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + aoko.vd() + ".amr");
  }
  
  protected void onError()
  {
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    if ((!this.app.isLogin()) || (!this.app.isRunning())) {
      dN(9366, "account switch");
    }
    hM("onError", "elapsed:" + l + " errCode:" + this.errCode + " errDesc:" + this.errDesc + " reason:" + (String)this.mM.get("param_reason"));
    doReport(false);
    this.jdField_a_of_type_Aojm.oy(getKey());
  }
  
  public void onResp(aomh paramaomh)
  {
    h(paramaomh);
  }
  
  protected void onSuccess()
  {
    long l = (System.nanoTime() - this.mStartTime) / 1000000L;
    hM("onSuccess", "elapsed:" + l + ",key:" + getKey());
    doReport(true);
    this.jdField_a_of_type_Aojm.oy(getKey());
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  
  public void pause() {}
  
  public void setCurrentProgress(int paramInt)
  {
    this.brX = paramInt;
  }
  
  public void setId(long paramLong)
  {
    this.jdField_b_of_type_Aoko.lG(paramLong);
  }
  
  protected void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void start() {}
  
  public void stop() {}
  
  public static class a
  {
    public int dPb;
    public int dPc;
    public long finishTime;
    public int result = -1;
    public long startTime;
    
    public void dVf()
    {
      if (this.startTime == 0L) {
        this.startTime = System.nanoTime();
      }
    }
    
    void dVg()
    {
      long l = System.nanoTime();
      if (l > this.finishTime) {
        this.finishTime = l;
      }
    }
    
    public String fB(int paramInt)
    {
      long l2 = 0L;
      long l1 = l2;
      if (this.result != -1)
      {
        l1 = l2;
        if (this.startTime != 0L)
        {
          l1 = l2;
          if (this.finishTime != 0L) {
            l1 = (this.finishTime - this.startTime) / 1000000L;
          }
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt).append("_").append(this.result).append("_").append(this.dPb).append("_").append(this.dPc).append("_").append(l1);
      return localStringBuilder.toString();
    }
    
    public long hj()
    {
      if ((this.startTime != 0L) && (this.finishTime != 0L)) {}
      for (long l = (this.finishTime - this.startTime) / 1000000L;; l = 0L)
      {
        if (l < 0L) {
          return 0L;
        }
        return l;
      }
    }
    
    public void lF(long paramLong)
    {
      if (paramLong >= this.finishTime) {
        this.startTime = 0L;
      }
      while (paramLong <= this.startTime) {
        return;
      }
      this.startTime = paramLong;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("startTime: ").append(this.startTime).append(" finishTime: ").append(this.finishTime);
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojn
 * JD-Core Version:    0.7.0.1
 */