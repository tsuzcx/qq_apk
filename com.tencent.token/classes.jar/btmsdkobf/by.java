package btmsdkobf;

import android.content.Context;
import android.os.Build;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.utils.PhoneInfoFetcher;
import com.tmsdk.base.utils.PhoneInfoFetcher.SizeInfo;
import com.tmsdk.base.utils.SDKUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class by
  extends cl
{
  private static by gZ;
  private boolean gW = true;
  private boolean gX = false;
  private boolean gY = false;
  
  public static by aw()
  {
    if (gZ == null) {
      try
      {
        if (gZ == null) {
          gZ = new by();
        }
      }
      finally {}
    }
    return gZ;
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidToPhone() guid: ");
    localStringBuilder.append(paramString);
    eg.f("SharkOutlet", localStringBuilder.toString());
    bw.ah().n(paramString);
  }
  
  public void a(HashMap<String, String> paramHashMap) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.gW = paramBoolean1;
    this.gX = paramBoolean2;
    this.gY = paramBoolean3;
  }
  
  public cs.b aA()
  {
    return bw.ah().ai();
  }
  
  public String aB()
  {
    String str = bw.ah().aj();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidFromPhone() guid: ");
    localStringBuilder.append(str);
    eg.f("SharkOutlet", localStringBuilder.toString());
    return str;
  }
  
  public String aC()
  {
    return null;
  }
  
  public boolean aD()
  {
    return true;
  }
  
  public void aE() {}
  
  public String aF()
  {
    return bw.ah().ak();
  }
  
  public String aG()
  {
    return bw.ah().al();
  }
  
  public an aH()
  {
    eg.f("SharkOutlet", "onGetInfoSavedOfGuid()");
    return bw.ah().an();
  }
  
  public long aI()
  {
    return -1L;
  }
  
  public long aJ()
  {
    long l = bw.ah().am();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetGuidUpdateCheckTimeMillis() tm: ");
    localStringBuilder.append(l);
    eg.f("SharkOutlet", localStringBuilder.toString());
    return l;
  }
  
  public boolean aK()
  {
    return bw.ah().ao();
  }
  
  public v aL()
  {
    return bw.ah().aq();
  }
  
  public int aM()
  {
    return -1;
  }
  
  public void aN() {}
  
  public String aO()
  {
    return bc.o().getOpenIdTicket();
  }
  
  public boolean ax()
  {
    return this.gW;
  }
  
  public boolean ay()
  {
    return this.gX;
  }
  
  public boolean az()
  {
    return this.gY;
  }
  
  public void b(an paraman)
  {
    eg.f("SharkOutlet", "onSaveInfoOfGuid()");
    bw.ah().a(paraman);
  }
  
  public void b(cs.b paramb)
  {
    if (paramb == null) {
      return;
    }
    bw.ah().a(paramb);
  }
  
  public void b(v paramv)
  {
    bw.ah().a(paramv);
  }
  
  public void b(String paramString, long paramLong, List<String> paramList)
  {
    bw.ah().a(paramString, paramLong, paramList);
  }
  
  public void b(String paramString, boolean paramBoolean) {}
  
  public void c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveGuidUpdateCheckTimeMillis() timeMillis: ");
    localStringBuilder.append(paramLong);
    eg.f("SharkOutlet", localStringBuilder.toString());
    bw.ah().b(paramLong);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    bw.ah().o(paramString);
  }
  
  public an d(boolean paramBoolean)
  {
    Context localContext = bc.n();
    an localan = new an();
    localan.cO = bc.o().getDeviceId1();
    localan.cP = bc.o().getDeviceId2();
    localan.cQ = bc.o().getDeviceId3();
    localan.cR = bc.o().getDeviceId4();
    if (bc.o().isAllowImei())
    {
      localan.imei = PhoneInfoFetcher.getIMEI(localContext);
      localObject = PhoneInfoFetcher.getImeiAndMeid(localContext);
      localan.cL = ((String)((Map)localObject).get("imei1"));
      localan.cM = ((String)((Map)localObject).get("imei2"));
      localan.cN = ((String)((Map)localObject).get("meid"));
    }
    if (bc.o().isAllowMac())
    {
      localObject = ea.j(localContext);
      if (localObject == null) {
        localObject = "";
      }
      localan.mac = ((String)localObject);
    }
    if (bc.o().isAllowImsi())
    {
      localan.imsi = PhoneInfoFetcher.getIMSI(localContext);
      localan.co = "";
      localan.bU = 1;
    }
    if (bc.o().isAllowAndroidID()) {
      localan.androidid = PhoneInfoFetcher.getAndoidId(localContext);
    }
    if (bc.o().isAllowOther())
    {
      int j = PhoneInfoFetcher.getScreenWidth(localContext);
      int i = PhoneInfoFetcher.getScreenHeight(localContext);
      int k;
      if (j < i)
      {
        k = i;
      }
      else
      {
        k = j;
        j = i;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("*");
      ((StringBuilder)localObject).append(j);
      localan.bY = ((StringBuilder)localObject).toString();
      localan.bV = Build.CPU_ABI;
      localan.cy = Build.CPU_ABI2;
      localan.bW = PhoneInfoFetcher.getMaxCpuFreq();
      localan.bX = PhoneInfoFetcher.getCpuNum();
      localan.cc = Build.BRAND;
      localan.cz = Build.FINGERPRINT;
      localan.cE = PhoneInfoFetcher.getSystemProperties("ro.mediatek.platform");
      localan.cj = PhoneInfoFetcher.getSystemProperties("ro.sf.lcd_density");
      localan.cf = Build.PRODUCT;
      localan.cF = PhoneInfoFetcher.getKernelVersion();
    }
    localan.bZ = PhoneInfoFetcher.getTotalMemery();
    localan.ca = PhoneInfoFetcher.getSystemAndDataSize();
    Object localObject = new PhoneInfoFetcher.SizeInfo();
    PhoneInfoFetcher.getStorageCardSize((PhoneInfoFetcher.SizeInfo)localObject);
    localan.cb = ((PhoneInfoFetcher.SizeInfo)localObject).totalSize;
    localObject = new PhoneInfoFetcher.SizeInfo();
    PhoneInfoFetcher.getPhoneStorageSize((PhoneInfoFetcher.SizeInfo)localObject);
    localan.cD = ((PhoneInfoFetcher.SizeInfo)localObject).totalSize;
    localan.ch = Build.MANUFACTURER;
    try
    {
      localan.pkgname = bc.n().getPackageName();
      label470:
      localan.ua = Build.MODEL;
      localan.bT = SDKUtil.getSDKVersion();
      localan.lang = 2052;
      localan.version = bc.o().getVersion();
      localan.cs = 1;
      localan.cA = PhoneInfoFetcher.getSystemProperties("ro.product.locale.language");
      localan.cB = PhoneInfoFetcher.getSystemProperties("ro.product.locale.region");
      localan.cg = PhoneInfoFetcher.getSystemProperties("ro.build.version.release");
      localan.cm = false;
      localan.cG = 0;
      localan.cI = PhoneInfoFetcher.getSDCid(true);
      localan.cJ = PhoneInfoFetcher.getSDCid(false);
      localan.qq = "0";
      localan.phone = "0";
      localan.product = bc.o().getProductId();
      localan.lc = bc.o().getLC();
      localan.buildno = bc.o().getBuildNo();
      localan.channelid = bc.getChannel();
      localan.bR = 2;
      localan.subplatform = 201;
      localan.bS = false;
      return localan;
    }
    catch (Throwable localThrowable)
    {
      break label470;
    }
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    bw.ah().p(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    bw.ah().c(paramBoolean);
  }
  
  public void f(int paramInt1, int paramInt2) {}
  
  public void g(int paramInt1, int paramInt2) {}
  
  public void h(int paramInt1, int paramInt2) {}
  
  public void i(int paramInt1, int paramInt2) {}
  
  public cg.a r(String paramString)
  {
    return bw.ah().q(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.by
 * JD-Core Version:    0.7.0.1
 */