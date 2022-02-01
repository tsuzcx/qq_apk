package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyBeaconReport;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyGuard;
import java.util.Properties;

public class VsReporter
{
  public static final String GUARD_JAR_VERSION = "guard_jar_version";
  public static final String GUARD_SO_VERSION = "guard_so_version";
  private static final String TAG = "VsReporter";
  public static final String VS_JAR_VERSION = "vs_jar_version";
  public static final String VS_REP_BSGUID = "vs_bsguid";
  public static final String VS_REP_ECODE = "vs_ecode";
  public static final String VS_REP_PKG = "vs_pkgmame";
  public static final String VS_REP_PLAT = "vs_platform";
  public static final String VS_REP_QIMEI = "vs_qimei";
  public static final String VS_REP_SDT = "vs_sdtfrom";
  public static final String VS_REP_VSGUID = "vs_vsguid";
  public static final String VS_REP_VSKEY = "vs_vskey";
  public static final String VS_SO_VERSION = "vs_so_version";
  
  public static void propInit(Properties paramProperties, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "nil";
    }
    paramProperties.put("vs_platform", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "nil";
    }
    paramProperties.put("vs_sdtfrom", paramString1);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "nil";
    }
    paramProperties.put("vs_vsguid", paramString1);
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "nil";
    }
    paramProperties.put("vs_bsguid", paramString1);
    if ((paramString5 == null) || (paramString5.isEmpty())) {
      paramProperties.put("vs_qimei", "0");
    }
    for (;;)
    {
      CKeyFacade.instance();
      paramProperties.put("vs_so_version", CKeyFacade.getSoVersion());
      CKeyFacade.instance();
      paramProperties.put("vs_jar_version", CKeyFacade.getJarVersion());
      paramProperties.put("guard_so_version", CKeyGuard.getSoVersion());
      paramProperties.put("guard_jar_version", CKeyGuard.getJarVersion());
      paramProperties.put("vs_uin", CKeyFacade.instance().getmUin());
      paramProperties.put("vs_openid", CKeyFacade.instance().getmOpenID());
      paramProperties.put("vs_vuid", CKeyFacade.instance().getmVuid());
      paramProperties.put("vs_extinfo", CKeyFacade.instance().getmExtInfo());
      return;
      paramProperties.put("vs_qimei", paramString5);
    }
  }
  
  public static void reportCKey(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, long paramLong, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    paramString3 = CKeyBeaconReport.getRequiredReportValue();
    propInit(paramString3, paramString1, paramString2, paramString4, paramString5, paramString6);
    paramString3.put("bs_platform", paramString8);
    paramString3.put("bs_sdtfrom", paramString9);
    paramString3.put("bs_vid", paramString10);
    paramString3.put("bs_time", String.valueOf(paramLong));
    paramString3.put("com/tencent/qqlive/ckey", paramString11);
    paramString3.put("vs_caller", paramString12);
    paramString3.put("bs_extinfo", paramString13);
    paramString3.put("bs_guard", paramString14);
    CKeyBeaconReport.trackCustomKVEvent(paramContext, "vs_ckey", paramString3);
  }
  
  public static void reportInit(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    paramString3 = CKeyBeaconReport.getRequiredReportValue();
    propInit(paramString3, paramString1, paramString2, paramString4, paramString5, paramString6);
    CKeyBeaconReport.trackCustomKVEvent(paramContext, "vs_init", paramString3);
  }
  
  public static void reportSign(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    Properties localProperties = CKeyBeaconReport.getRequiredReportValue();
    propInit(localProperties, paramString1, paramString2, paramString3, paramString4, paramString5);
    localProperties.put("bs_ts", String.valueOf(paramInt));
    CKeyBeaconReport.trackCustomKVEvent(paramContext, "vs_taskenc", localProperties);
  }
  
  public static void reportTaskEncrypt(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Properties localProperties = CKeyBeaconReport.getRequiredReportValue();
    propInit(localProperties, paramString1, paramString2, paramString3, paramString4, paramString5);
    localProperties.put("bs_seq", paramString6);
    localProperties.put("bs_vid", paramString7);
    localProperties.put("bs_omgid", paramString8);
    localProperties.put("bs_guid", paramString9);
    localProperties.put("bs_uin", paramString10);
    localProperties.put("bs_type", String.valueOf(paramInt1));
    localProperties.put("bs_sys", String.valueOf(paramInt2));
    localProperties.put("bs_taskid", String.valueOf(paramInt3));
    localProperties.put("bs_ts", String.valueOf(paramInt4));
    localProperties.put("bs_rand", String.valueOf(paramInt5));
    CKeyBeaconReport.trackCustomKVEvent(paramContext, "vs_taskenc", localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsReporter
 * JD-Core Version:    0.7.0.1
 */