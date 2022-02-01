package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;

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
      paramContext = new StringBuilder("[cu_guid]GuidCertifier, clean guid for server change(isTest?): ");
      paramContext.append(paramBoolean);
      paramContext.append(" -> ");
      paramContext.append(this.hi);
      eh.f("GuidCertifier", paramContext.toString());
      this.hF.bL().a("", false);
      this.hF.bL().b("", false);
    }
    else
    {
      eh.f("GuidCertifier", "[cu_guid]GuidCertifier: no need to clean guid");
    }
    ba();
  }
  
  private void a(final an paraman, String paramString)
  {
    Object localObject = new StringBuilder("[cu_guid]updateGuid(), for: ");
    ((StringBuilder)localObject).append(this.hH);
    eh.f("GuidCertifier", ((StringBuilder)localObject).toString());
    final int i = cu.bu().bm();
    localObject = b(paraman, paramString);
    paramString = new as();
    paramString.dc = i;
    paramString.bM = 2;
    paramString.data = cd.a(this.mContext, (JceStruct)localObject, 2, paramString);
    if (paramString.data == null)
    {
      eh.g("GuidCertifier", "[cu_guid]updateGuid(), jceStruct2DataForSend failed");
      return;
    }
    localObject = new StringBuilder("[cu_guid]updateGuid(), cur info: ");
    ((StringBuilder)localObject).append(c(paraman));
    eh.f("GuidCertifier", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    cv.by().a(paramString.dc, -1L, null);
    this.hF.a(0, 0L, false, (ArrayList)localObject, new cy.b()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
      {
        eh.e("GuidCertifier", "updateGuid() retCode: ".concat(String.valueOf(paramAnonymousInt1)));
        if (paramAnonymousInt1 != 0)
        {
          eh.h("GuidCertifier", "[cu_guid]updateGuid() ESharkCode.ERR_NONE != retCode, retCode: ".concat(String.valueOf(paramAnonymousInt1)));
          paramAnonymousArrayList = cv.by();
        }
        for (paramAnonymousInt2 = i;; paramAnonymousInt2 = i)
        {
          paramAnonymousArrayList.a("GuidCertifier", 10002, paramAnonymousInt2, null, 30, paramAnonymousInt1);
          cv.by().x(i);
          return;
          Object localObject;
          if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
            localObject = paramAnonymousArrayList.iterator();
          }
          while (((Iterator)localObject).hasNext())
          {
            paramAnonymousArrayList = (ba)((Iterator)localObject).next();
            if ((paramAnonymousArrayList != null) && (10002 == paramAnonymousArrayList.bM))
            {
              if (paramAnonymousArrayList.df != 0)
              {
                localObject = new StringBuilder("[cu_guid]updateGuid(), mazu error: ");
                ((StringBuilder)localObject).append(paramAnonymousArrayList.df);
                eh.h("GuidCertifier", ((StringBuilder)localObject).toString());
                paramAnonymousInt1 = paramAnonymousArrayList.df;
                break label303;
              }
              if (paramAnonymousArrayList.dg != 0)
              {
                localObject = new StringBuilder("[cu_guid]updateGuid(), dataRetCode: ");
                ((StringBuilder)localObject).append(paramAnonymousArrayList.dg);
                eh.h("GuidCertifier", ((StringBuilder)localObject).toString());
                paramAnonymousInt1 = -21300000;
                break label303;
              }
              paramAnonymousArrayList = new StringBuilder("[cu_guid]updateGuid(), succ, save info to db, mGuid: ");
              paramAnonymousArrayList.append(cf.c(cf.this));
              eh.e("GuidCertifier", paramAnonymousArrayList.toString());
              paramAnonymousArrayList = cf.this;
              cf.a(paramAnonymousArrayList, cf.c(paramAnonymousArrayList), paraman, false);
              paramAnonymousInt1 = 0;
              break label303;
              eh.h("GuidCertifier", "[cu_guid]updateGuid(), no sashimi, serverSashimis: ".concat(String.valueOf(paramAnonymousArrayList)));
            }
          }
          paramAnonymousInt1 = -21250000;
          label303:
          paramAnonymousArrayList = cv.by();
        }
      }
    });
  }
  
  private void a(String paramString, an paraman, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str;
    if (paramString != null) {
      str = paramString;
    } else {
      str = "";
    }
    this.hH = str;
    this.hG = true;
    this.hF.bL().e(this.hi);
    this.hF.bL().a(paramString, true);
    this.hF.bL().b(paramString, true);
    this.hF.bL().b(paraman);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 != paramBoolean2;
  }
  
  private an b(boolean paramBoolean, String paramString)
  {
    if (aY())
    {
      paramString = new StringBuilder("[cu_guid]getCurInfoOfGuidIfNeed(), should register, donnot update, mGuid: ");
      paramString.append(this.hH);
      paramString.append(" fromPhone: ");
      paramString.append(this.hG);
      eh.f("GuidCertifier", paramString.toString());
      return null;
    }
    if (!f(paramBoolean)) {
      return null;
    }
    paramBoolean = TextUtils.isEmpty(paramString);
    int i = 1;
    if ((!paramBoolean) && (paramString.compareTo("yunzhiling_realinfo") == 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    an localan = g(paramBoolean);
    if (localan == null)
    {
      eh.g("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), null == realInfo");
      return null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      eh.g("GuidCertifier", "[cu_guid_p]getCurInfoOfGuidIfNeed(), refreshKey is not empty, server requires update guid: ".concat(String.valueOf(paramString)));
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
    Object localObject = this.hF.bL().aC();
    String str = getGuid();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals(str))) {
      i = 0;
    }
    if ((i | paramBoolean | false | bool1 | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29 | bool30 | bool31 | bool32 | bool33 | bool34 | bool35 | bool36 | bool37 | bool38 | bool39 | bool40 | bool41 | bool42 | bool43 | bool44 | bool45 | bool46 | bool47 | bool48 | bool49 | bool50 | bool51 | bool52) == 0)
    {
      eh.f("GuidCertifier", "[cu_guid]getCurInfoOfGuidIfNeed(), info not changed, no need");
      return null;
    }
    localObject = new StringBuilder("[cu_guid]getCurInfoOfGuidIfNeed(), yes, |savedInfo|");
    ((StringBuilder)localObject).append(c(paramString));
    eh.i("GuidCertifier", ((StringBuilder)localObject).toString());
    paramString = new StringBuilder("[cu_guid]getCurInfoOfGuidIfNeed(), yes, |realInfo|");
    paramString.append(c(localan));
    eh.i("GuidCertifier", paramString.toString());
    return localan;
  }
  
  private ap b(an paraman, String paramString)
  {
    ap localap = new ap();
    localap.cU = paraman;
    localap.cV = getGuid();
    localap.cW = this.hF.bL().aC();
    localap.cX = paramString;
    paraman = new StringBuilder("[cu_guid_p]getCSUpdateRegist(), sdGuid: ");
    paraman.append(localap.cW);
    paraman.append(" curGuid: ");
    paraman.append(localap.cV);
    paraman.append(" refreshKey: ");
    paraman.append(paramString);
    eh.f("GuidCertifier", paraman.toString());
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
      eh.a("GuidCertifier", "[cu_guid]sendBroadcast(): ".concat(String.valueOf(paramContext)), paramContext);
    }
  }
  
  private boolean b(long paramLong1, long paramLong2)
  {
    return paramLong1 != paramLong2;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return true;
    }
    return !paramString1.equals(paramString2);
  }
  
  private String c(an paraman)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("|imei|");
    localStringBuilder2.append(paraman.imei);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|imsi|");
    localStringBuilder2.append(paraman.imsi);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|imsi_2|");
    localStringBuilder2.append(paraman.co);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|mac|");
    localStringBuilder2.append(paraman.mac);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|com.qq|");
    localStringBuilder2.append(paraman.qq);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|phone|");
    localStringBuilder2.append(paraman.phone);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|product|");
    localStringBuilder2.append(paraman.product);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|lc|");
    localStringBuilder2.append(paraman.lc);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|buildno|");
    localStringBuilder2.append(paraman.buildno);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|channelid|");
    localStringBuilder2.append(paraman.channelid);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|platform|");
    localStringBuilder2.append(paraman.bR);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|subplatform|");
    localStringBuilder2.append(paraman.subplatform);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|isbuildin|");
    localStringBuilder2.append(paraman.bS);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|pkgname|");
    localStringBuilder2.append(paraman.pkgname);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|ua|");
    localStringBuilder2.append(paraman.ua);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|sdkver|");
    localStringBuilder2.append(paraman.bT);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|androidid|");
    localStringBuilder2.append(paraman.androidid);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|lang|");
    localStringBuilder2.append(paraman.lang);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|simnum|");
    localStringBuilder2.append(paraman.bU);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|cpu|");
    localStringBuilder2.append(paraman.bV);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|cpu_abi2|");
    localStringBuilder2.append(paraman.cy);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|cpufreq|");
    localStringBuilder2.append(paraman.bW);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|cpunum|");
    localStringBuilder2.append(paraman.bX);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|resolution|");
    localStringBuilder2.append(paraman.bY);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|ram|");
    localStringBuilder2.append(paraman.bZ);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|rom|");
    localStringBuilder2.append(paraman.ca);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|sdcard|");
    localStringBuilder2.append(paraman.cb);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|inner_storage|");
    localStringBuilder2.append(paraman.cD);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|build_brand|");
    localStringBuilder2.append(paraman.cc);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|build_version_incremental|");
    localStringBuilder2.append(paraman.cd);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|build_version_release|");
    localStringBuilder2.append(paraman.ce);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|version|");
    localStringBuilder2.append(paraman.version);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|extSdkVer|");
    localStringBuilder2.append(paraman.cs);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|pkgkey|");
    localStringBuilder2.append(paraman.cu);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|manufactory|");
    localStringBuilder2.append(paraman.ch);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|cam_pix|");
    localStringBuilder2.append(paraman.ck);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|front_cam_pix|");
    localStringBuilder2.append(paraman.cl);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|product_device|");
    localStringBuilder2.append(paraman.cv);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|product_board|");
    localStringBuilder2.append(paraman.cw);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|build_product|");
    localStringBuilder2.append(paraman.cx);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|rom_fingerprint|");
    localStringBuilder2.append(paraman.cz);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|product_lanuage|");
    localStringBuilder2.append(paraman.cA);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|product_region|");
    localStringBuilder2.append(paraman.cB);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|build_radiover|");
    localStringBuilder2.append(paraman.cC);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|board_platform|");
    localStringBuilder2.append(paraman.ci);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|board_platform_mtk|");
    localStringBuilder2.append(paraman.cE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|screen_pdi|");
    localStringBuilder2.append(paraman.cj);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|romname|");
    localStringBuilder2.append(paraman.cf);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|romversion|");
    localStringBuilder2.append(paraman.cg);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|kernel_ver|");
    localStringBuilder2.append(paraman.cF);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|isdual|");
    localStringBuilder2.append(paraman.cm);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|rom_manufactory_version|");
    localStringBuilder2.append(paraman.cH);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|insideCid|");
    localStringBuilder2.append(paraman.cI);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|outsideCid|");
    localStringBuilder2.append(paraman.cJ);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|registCount|");
    localStringBuilder2.append(paraman.cK);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|imei1|");
    localStringBuilder2.append(paraman.cL);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|imei2|");
    localStringBuilder2.append(paraman.cM);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|meid|");
    localStringBuilder2.append(paraman.cN);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|deviceId1|");
    localStringBuilder2.append(paraman.cO);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|deviceId2|");
    localStringBuilder2.append(paraman.cP);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|deviceId3|");
    localStringBuilder2.append(paraman.cQ);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("|deviceId4|");
    localStringBuilder2.append(paraman.cR);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
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
      eh.b("GuidCertifier", "[cu_guid]requestSendProcessRegisterGuid(): ".concat(String.valueOf(paramContext)), paramContext);
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
    if (this.hI <= 0L) {}
    for (String str = "[cu_guid]shouldCheckUpdate(), [mem] first check after boot, continue check...";; str = "[cu_guid]shouldCheckUpdate(), [mem] more than 1h, continue check...")
    {
      eh.f("GuidCertifier", str);
      this.hI = l1;
      break;
      if (!dy.a(l1, this.hI, 60)) {
        break label165;
      }
    }
    long l2 = this.hF.bL().aJ();
    if (l2 <= 0L)
    {
      eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [file] first check, just record the time");
      this.hF.bL().c(l1);
      return false;
    }
    if (dy.a(l1, l2, 720))
    {
      eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [file] more than 12h, should check");
      this.hF.bL().c(l1);
      return true;
    }
    eh.f("GuidCertifier", "[cu_guid]shouldCheckUpdate(), [file] less than 12h, donnot check");
    label165:
    return false;
  }
  
  private an g(boolean paramBoolean)
  {
    an localan = this.hF.bL().d(paramBoolean);
    if (localan != null)
    {
      if (localan.imei == null) {
        localan.imei = "";
      }
      return localan;
    }
    throw new RuntimeException("onGetRealInfoOfGuid() return null");
  }
  
  private boolean j(int paramInt1, int paramInt2)
  {
    return paramInt1 != paramInt2;
  }
  
  public void a(final a parama)
  {
    eh.f("GuidCertifier", "[cu_guid]registerGuid()");
    if (!aY())
    {
      parama = new StringBuilder("[cu_guid]registerGuid(), not necessary, mGuid: ");
      parama.append(this.hH);
      eh.e("GuidCertifier", parama.toString());
      return;
    }
    this.hF.bL().aN();
    final an localan = g(false);
    as localas = new as();
    final int i = cu.bu().bm();
    localas.dc = i;
    localas.bM = 1;
    localas.data = cd.a(this.mContext, localan, 1, localas);
    if (localas.data == null)
    {
      eh.g("GuidCertifier", "[cu_guid]registerGuid(), jceStruct2DataForSend failed");
      parama.a(i, 1, -20001500, null);
      return;
    }
    Object localObject = new StringBuilder("[cu_guid]registerGuid(), cur info: ");
    ((StringBuilder)localObject).append(c(localan));
    eh.f("GuidCertifier", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).add(localas);
    cv.by().a(localas.dc, -1L, null);
    this.hF.b((ArrayList)localObject, new cy.b()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, ArrayList<ba> paramAnonymousArrayList)
      {
        if (paramAnonymousInt1 != 0)
        {
          eh.h("GuidCertifier", "[cu_guid]registerGuid(), retCode: ".concat(String.valueOf(paramAnonymousInt1)));
          parama.a(i, 1, paramAnonymousInt1, null);
          return;
        }
        if (paramAnonymousArrayList == null)
        {
          eh.h("GuidCertifier", "[cu_guid]registerGuid(), null == serverSashimis");
          parama.a(i, 1, -21250000, null);
          return;
        }
        if (paramAnonymousArrayList.size() <= 0)
        {
          eh.h("GuidCertifier", "[cu_guid]registerGuid(), serverSashimis.size() <= 0");
          parama.a(i, 1, -21250000, null);
          return;
        }
        paramAnonymousArrayList = (ba)paramAnonymousArrayList.get(0);
        if (paramAnonymousArrayList == null)
        {
          eh.h("GuidCertifier", "[cu_guid]registerGuid(), serverSashimi is null");
          parama.a(i, 1, -21250000, null);
          return;
        }
        if (paramAnonymousArrayList.df != 0)
        {
          localObject1 = new StringBuilder("[cu_guid]registerGuid(), mazu error: ");
          ((StringBuilder)localObject1).append(paramAnonymousArrayList.df);
          eh.h("GuidCertifier", ((StringBuilder)localObject1).toString());
          parama.a(i, 1, paramAnonymousArrayList.df, null);
          return;
        }
        if (paramAnonymousArrayList.dg != 0)
        {
          localObject1 = new StringBuilder("[cu_guid]registerGuid(), dataRetCode: ");
          ((StringBuilder)localObject1).append(paramAnonymousArrayList.dg);
          eh.h("GuidCertifier", ((StringBuilder)localObject1).toString());
          parama.a(i, 1, -21300000, null);
          return;
        }
        Object localObject1 = paramAnonymousArrayList.data;
        if (localObject1 == null)
        {
          eh.h("GuidCertifier", "[cu_guid]registerGuid(), null == respData");
          parama.a(i, 1, -21000005, null);
          return;
        }
        Object localObject2 = new StringBuilder("[cu_guid]registerGuid() rs.data.length: ");
        ((StringBuilder)localObject2).append(paramAnonymousArrayList.data.length);
        eh.e("GuidCertifier", ((StringBuilder)localObject2).toString());
        localObject2 = new aw();
        try
        {
          paramAnonymousArrayList = cd.a(cf.a(cf.this), cf.b(cf.this).ai().is.getBytes(), (byte[])localObject1, (JceStruct)localObject2, false, paramAnonymousArrayList.di);
          if (paramAnonymousArrayList == null)
          {
            eh.h("GuidCertifier", "[cu_guid]registerGuid(), decode jce failed: null");
            parama.a(i, 1, -21000400, null);
            return;
          }
          paramAnonymousArrayList = (aw)paramAnonymousArrayList;
          localObject1 = new StringBuilder("[cu_guid]registerGuid(), guid got: ");
          ((StringBuilder)localObject1).append(paramAnonymousArrayList.guid);
          eh.e("GuidCertifier", ((StringBuilder)localObject1).toString());
          cf.a(cf.this, paramAnonymousArrayList.guid, localan, true);
          parama.a(i, 1, 0, paramAnonymousArrayList.guid);
          return;
        }
        catch (Exception paramAnonymousArrayList)
        {
          eh.h("GuidCertifier", "[cu_guid]registerGuid(), decode jce exception: ".concat(String.valueOf(paramAnonymousArrayList)));
          parama.a(i, 1, -21000400, null);
        }
      }
    });
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!cx.ax())
    {
      eh.f("GuidCertifier", "[cu_guid] checUpdateGuid(), not send process, ignore!");
      return;
    }
    an localan = b(paramBoolean, paramString);
    if (localan == null) {
      return;
    }
    a(localan, paramString);
  }
  
  public boolean aY()
  {
    if (!cx.ax()) {
      return false;
    }
    return (TextUtils.isEmpty(getGuid())) || (!this.hG);
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
    else
    {
      this.hG = true;
    }
    StringBuilder localStringBuilder = new StringBuilder("[cu_guid]refreshGuid(), mGuid: ");
    localStringBuilder.append(this.hH);
    localStringBuilder.append(" fromPhone: ");
    localStringBuilder.append(this.hG);
    eh.f("GuidCertifier", localStringBuilder.toString());
  }
  
  public String getGuid()
  {
    if (this.hH != null) {
      return this.hH;
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cf
 * JD-Core Version:    0.7.0.1
 */