package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class cf
{
  private cy hF;
  private volatile boolean hG = false;
  private volatile String hH = "";
  private volatile long hI = 0L;
  private boolean hi = false;
  private Context mContext;
  
  public cf(Context paramContext, cy paramcy, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.hF = paramcy;
    this.hi = paramBoolean;
    paramContext = this.hF.bL().aB();
    paramBoolean = this.hF.bL().aK();
    if ((this.hi != paramBoolean) && (!TextUtils.isEmpty(paramContext)))
    {
      eh.f("GuidCertifier", "[cu_guid]GuidCertifier, clean guid for server change(isTest?): " + paramBoolean + " -> " + this.hi);
      this.hF.bL().a("", false);
      this.hF.bL().b("", false);
    }
    for (;;)
    {
      ba();
      return;
      eh.f("GuidCertifier", "[cu_guid]GuidCertifier: no need to clean guid");
    }
  }
  
  private void a(an paraman, String paramString)
  {
    eh.f("GuidCertifier", "[cu_guid]updateGuid(), for: " + this.hH);
    int i = cu.bu().bm();
    Object localObject = b(paraman, paramString);
    paramString = new as();
    paramString.dc = i;
    paramString.bM = 2;
    paramString.data = cd.a(this.mContext, (JceStruct)localObject, 2, paramString);
    if (paramString.data == null)
    {
      eh.g("GuidCertifier", "[cu_guid]updateGuid(), jceStruct2DataForSend failed");
      return;
    }
    eh.f("GuidCertifier", "[cu_guid]updateGuid(), cur info: " + c(paraman));
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    cv.by().a(paramString.dc, -1L, null);
    this.hF.a(0, 0L, false, (ArrayList)localObject, new fq(this, i, paraman));
  }
  
  private void a(String paramString, an paraman, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString != null) {}
    for (String str = paramString;; str = "")
    {
      this.hH = str;
      this.hG = true;
      this.hF.bL().e(this.hi);
      this.hF.bL().a(paramString, true);
      this.hF.bL().b(paramString, true);
      this.hF.bL().b(paraman);
      return;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 != paramBoolean2;
  }
  
  private an b(boolean paramBoolean, String paramString)
  {
    int i = 1;
    if (aY())
    {
      eh.f("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), should register, donnot update, mGuid: " + this.hH + " fromPhone: " + this.hG);
      return null;
    }
    if (!f(paramBoolean)) {
      return null;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.compareTo("yunzhiling_realinfo") == 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      an localan = g(paramBoolean);
      if (localan == null)
      {
        eh.g("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), null == realInfo");
        return null;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        eh.g("GuidCertifier", "[cu_guid_p]getCurInfoOfGuidIfNeed(), refreshKey is not empty, server requires update guid: " + paramString);
        return localan;
      }
      paramString = this.hF.bL().aH();
      if (paramString == null)
      {
        eh.g("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), null == savedInfo");
        return null;
      }
      paramBoolean = b(localan.imei, paramString.imei);
      boolean bool1 = b(localan.imsi, paramString.imsi);
      boolean bool2 = b(localan.co, paramString.co);
      boolean bool3 = b(localan.mac, paramString.mac);
      boolean bool4 = b(localan.qq, paramString.qq);
      boolean bool5 = b(localan.phone, paramString.phone);
      boolean bool6 = j(localan.product, paramString.product);
      boolean bool7 = b(localan.lc, paramString.lc);
      boolean bool8 = j(localan.buildno, paramString.buildno);
      boolean bool9 = b(localan.channelid, paramString.channelid);
      boolean bool10 = j(localan.bR, paramString.bR);
      boolean bool11 = j(localan.subplatform, paramString.subplatform);
      boolean bool12 = a(localan.bS, paramString.bS);
      boolean bool13 = b(localan.pkgname, paramString.pkgname);
      boolean bool14 = b(localan.ua, paramString.ua);
      boolean bool15 = j(localan.bT, paramString.bT);
      boolean bool16 = b(localan.androidid, paramString.androidid);
      boolean bool17 = j(localan.lang, paramString.lang);
      boolean bool18 = j(localan.bU, paramString.bU);
      boolean bool19 = b(localan.bV, paramString.bV);
      boolean bool20 = b(localan.cy, paramString.cy);
      boolean bool21 = b(localan.bW, paramString.bW);
      boolean bool22 = j(localan.bX, paramString.bX);
      boolean bool23 = b(localan.bY, paramString.bY);
      boolean bool24 = b(localan.bZ, paramString.bZ);
      boolean bool25 = b(localan.ca, paramString.ca);
      boolean bool26 = b(localan.cb, paramString.cb);
      boolean bool27 = b(localan.cD, paramString.cD);
      boolean bool28 = b(localan.cc, paramString.cc);
      boolean bool29 = b(localan.version, paramString.version);
      boolean bool30 = j(localan.cs, paramString.cs);
      boolean bool31 = b(localan.cu, paramString.cu);
      boolean bool32 = b(localan.ch, paramString.ch);
      boolean bool33 = b(localan.cz, paramString.cz);
      boolean bool34 = b(localan.cA, paramString.cA);
      boolean bool35 = b(localan.cB, paramString.cB);
      boolean bool36 = b(localan.cE, paramString.cE);
      boolean bool37 = b(localan.cj, paramString.cj);
      boolean bool38 = b(localan.cf, paramString.cf);
      boolean bool39 = b(localan.cg, paramString.cg);
      boolean bool40 = b(localan.cF, paramString.cF);
      boolean bool41 = a(localan.cm, paramString.cm);
      boolean bool42 = j(localan.cG, paramString.cG);
      boolean bool43 = b(localan.cH, paramString.cH);
      boolean bool44 = b(localan.cI, paramString.cI);
      boolean bool45 = b(localan.cJ, paramString.cJ);
      boolean bool46 = b(localan.cL, paramString.cL);
      boolean bool47 = b(localan.cM, paramString.cM);
      boolean bool48 = b(localan.cN, paramString.cN);
      boolean bool49 = b(localan.cO, paramString.cO);
      boolean bool50 = b(localan.cP, paramString.cP);
      boolean bool51 = b(localan.cQ, paramString.cQ);
      boolean bool52 = b(localan.cR, paramString.cR);
      String str1 = this.hF.bL().aC();
      String str2 = getGuid();
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {}
      while ((i | paramBoolean | false | bool1 | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29 | bool30 | bool31 | bool32 | bool33 | bool34 | bool35 | bool36 | bool37 | bool38 | bool39 | bool40 | bool41 | bool42 | bool43 | bool44 | bool45 | bool46 | bool47 | bool48 | bool49 | bool50 | bool51 | bool52) == 0)
      {
        eh.f("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), info not changed, no need");
        return null;
        i = 0;
      }
      eh.i("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), yes, |savedInfo|" + c(paramString));
      eh.i("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), yes, |realInfo|" + c(localan));
      return localan;
    }
  }
  
  private ap b(an paraman, String paramString)
  {
    ap localap = new ap();
    localap.cU = paraman;
    localap.cV = getGuid();
    localap.cW = this.hF.bL().aC();
    localap.cX = paramString;
    eh.f("GuidCertifier", "[cu_guid_p]getCSUpdateRegist(), sdGuid: " + localap.cW + " curGuid: " + localap.cV + " refreshKey: " + paramString);
    return localap;
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(String.format("action.guid.got:%s", new Object[] { paramContext.getPackageName() }));
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.putExtra("k.rc", paramInt);
      localIntent.putExtra("k.g", paramString);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      eh.a("GuidCertifier", "[cu_guid]sendBroadcast(): " + paramContext, paramContext);
    }
  }
  
  private boolean b(long paramLong1, long paramLong2)
  {
    return paramLong1 != paramLong2;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString2));
      bool1 = bool2;
    } while (!paramString1.equals(paramString2));
    return false;
  }
  
  private String c(an paraman)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|imei|" + paraman.imei);
    localStringBuilder.append("|imsi|" + paraman.imsi);
    localStringBuilder.append("|imsi_2|" + paraman.co);
    localStringBuilder.append("|mac|" + paraman.mac);
    localStringBuilder.append("|com.qq|" + paraman.qq);
    localStringBuilder.append("|phone|" + paraman.phone);
    localStringBuilder.append("|product|" + paraman.product);
    localStringBuilder.append("|lc|" + paraman.lc);
    localStringBuilder.append("|buildno|" + paraman.buildno);
    localStringBuilder.append("|channelid|" + paraman.channelid);
    localStringBuilder.append("|platform|" + paraman.bR);
    localStringBuilder.append("|subplatform|" + paraman.subplatform);
    localStringBuilder.append("|isbuildin|" + paraman.bS);
    localStringBuilder.append("|pkgname|" + paraman.pkgname);
    localStringBuilder.append("|ua|" + paraman.ua);
    localStringBuilder.append("|sdkver|" + paraman.bT);
    localStringBuilder.append("|androidid|" + paraman.androidid);
    localStringBuilder.append("|lang|" + paraman.lang);
    localStringBuilder.append("|simnum|" + paraman.bU);
    localStringBuilder.append("|cpu|" + paraman.bV);
    localStringBuilder.append("|cpu_abi2|" + paraman.cy);
    localStringBuilder.append("|cpufreq|" + paraman.bW);
    localStringBuilder.append("|cpunum|" + paraman.bX);
    localStringBuilder.append("|resolution|" + paraman.bY);
    localStringBuilder.append("|ram|" + paraman.bZ);
    localStringBuilder.append("|rom|" + paraman.ca);
    localStringBuilder.append("|sdcard|" + paraman.cb);
    localStringBuilder.append("|inner_storage|" + paraman.cD);
    localStringBuilder.append("|build_brand|" + paraman.cc);
    localStringBuilder.append("|build_version_incremental|" + paraman.cd);
    localStringBuilder.append("|build_version_release|" + paraman.ce);
    localStringBuilder.append("|version|" + paraman.version);
    localStringBuilder.append("|extSdkVer|" + paraman.cs);
    localStringBuilder.append("|pkgkey|" + paraman.cu);
    localStringBuilder.append("|manufactory|" + paraman.ch);
    localStringBuilder.append("|cam_pix|" + paraman.ck);
    localStringBuilder.append("|front_cam_pix|" + paraman.cl);
    localStringBuilder.append("|product_device|" + paraman.cv);
    localStringBuilder.append("|product_board|" + paraman.cw);
    localStringBuilder.append("|build_product|" + paraman.cx);
    localStringBuilder.append("|rom_fingerprint|" + paraman.cz);
    localStringBuilder.append("|product_lanuage|" + paraman.cA);
    localStringBuilder.append("|product_region|" + paraman.cB);
    localStringBuilder.append("|build_radiover|" + paraman.cC);
    localStringBuilder.append("|board_platform|" + paraman.ci);
    localStringBuilder.append("|board_platform_mtk|" + paraman.cE);
    localStringBuilder.append("|screen_pdi|" + paraman.cj);
    localStringBuilder.append("|romname|" + paraman.cf);
    localStringBuilder.append("|romversion|" + paraman.cg);
    localStringBuilder.append("|kernel_ver|" + paraman.cF);
    localStringBuilder.append("|isdual|" + paraman.cm);
    localStringBuilder.append("|rom_manufactory_version|" + paraman.cH);
    localStringBuilder.append("|insideCid|" + paraman.cI);
    localStringBuilder.append("|outsideCid|" + paraman.cJ);
    localStringBuilder.append("|registCount|" + paraman.cK);
    localStringBuilder.append("|imei1|" + paraman.cL);
    localStringBuilder.append("|imei2|" + paraman.cM);
    localStringBuilder.append("|meid|" + paraman.cN);
    localStringBuilder.append("|deviceId1|" + paraman.cO);
    localStringBuilder.append("|deviceId2|" + paraman.cP);
    localStringBuilder.append("|deviceId3|" + paraman.cQ);
    localStringBuilder.append("|deviceId4|" + paraman.cR);
    return localStringBuilder.toString();
  }
  
  static void f(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent(String.format("action.reg.guid:%s", new Object[] { paramContext.getPackageName() }));
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      eh.b("GuidCertifier", "[cu_guid]requestSendProcessRegisterGuid(): " + paramContext, paramContext);
    }
  }
  
  private boolean f(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean)
    {
      eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), forceCheck, true");
      this.hI = l1;
      this.hF.bL().c(l1);
      return true;
    }
    boolean bool = false;
    long l2;
    if (this.hI <= 0L)
    {
      eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [mem] first check after boot, continue check...");
      this.hI = l1;
      l2 = this.hF.bL().aJ();
      if (l2 > 0L) {
        break label131;
      }
      eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [file] first check, just record the time");
      this.hF.bL().c(l1);
      paramBoolean = bool;
    }
    for (;;)
    {
      return paramBoolean;
      paramBoolean = bool;
      if (dy.a(l1, this.hI, 60))
      {
        eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [mem] more than 1h, continue check...");
        this.hI = l1;
        break;
        label131:
        if (dy.a(l1, l2, 720))
        {
          eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [file] more than 12h, should check");
          this.hF.bL().c(l1);
          paramBoolean = true;
        }
        else
        {
          eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [file] less than 12h, donnot check");
          paramBoolean = bool;
        }
      }
    }
  }
  
  private an g(boolean paramBoolean)
  {
    an localan = this.hF.bL().d(paramBoolean);
    if (localan == null) {
      throw new RuntimeException("onGetRealInfoOfGuid() return null");
    }
    if (localan.imei == null) {
      localan.imei = "";
    }
    return localan;
  }
  
  private boolean j(int paramInt1, int paramInt2)
  {
    return paramInt1 != paramInt2;
  }
  
  public void a(cf.a parama)
  {
    eh.f("GuidCertifier", "[cu_guid]registerGuid()");
    if (!aY())
    {
      eh.e("GuidCertifier", "[cu_guid]registerGuid(), not necessary, mGuid: " + this.hH);
      return;
    }
    this.hF.bL().aN();
    an localan = g(false);
    as localas = new as();
    int i = cu.bu().bm();
    localas.dc = i;
    localas.bM = 1;
    localas.data = cd.a(this.mContext, localan, 1, localas);
    if (localas.data == null)
    {
      eh.g("GuidCertifier", "[cu_guid]registerGuid(), jceStruct2DataForSend failed");
      parama.a(i, 1, -20001500, null);
      return;
    }
    eh.f("GuidCertifier", "[cu_guid]registerGuid(), cur info: " + c(localan));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localas);
    cv.by().a(localas.dc, -1L, null);
    this.hF.b(localArrayList, new fp(this, parama, i, localan));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!cx.ax()) {
      eh.f("GuidCertifier", "[cu_guid] checUpdateGuid(), not send process, ignore!");
    }
    an localan;
    do
    {
      return;
      localan = b(paramBoolean, paramString);
    } while (localan == null);
    a(localan, paramString);
  }
  
  public boolean aY()
  {
    if (!cx.ax()) {}
    while ((!TextUtils.isEmpty(getGuid())) && (this.hG)) {
      return false;
    }
    return true;
  }
  
  public boolean aZ()
  {
    return (TextUtils.isEmpty(getGuid())) || (!this.hG);
  }
  
  public void ba()
  {
    this.hH = this.hF.bL().aB();
    if (TextUtils.isEmpty(this.hH))
    {
      this.hG = false;
      this.hH = this.hF.bL().aC();
      if (this.hH == null) {
        this.hH = "";
      }
    }
    for (;;)
    {
      eh.f("GuidCertifier", "[cu_guid]refreshGuid(), mGuid: " + this.hH + " fromPhone: " + this.hG);
      return;
      this.hG = true;
    }
  }
  
  public String getGuid()
  {
    if (this.hH != null) {
      return this.hH;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cf
 * JD-Core Version:    0.7.0.1
 */