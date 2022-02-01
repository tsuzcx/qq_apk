package com.tencent.mobileqq.msf.core.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qphone.base.util.c;
import java.util.ArrayList;
import java.util.HashMap;

public class a
{
  public static final String a = "BigTReportUtil";
  public static final String b = "dc04272";
  
  private static String a()
  {
    int i = c.b();
    long l = c.c() / 1024L / 1024L;
    long[] arrayOfLong = c.d();
    Object localObject2 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkOperator();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = String.format("%.2f", new Object[] { Double.valueOf(c.f()) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i).append(";").append(l).append(";").append(arrayOfLong[0]).append(";").append(arrayOfLong[1]).append(";").append(((String)localObject1).replaceAll(";", "")).append(";").append(str).append(";").append(c.b).append(";").append(c.c).append(";");
    localObject1 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.d("BigTReportUtil", 2, "getExtraDeviceInfo=" + (String)localObject1);
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    String str = NetConnInfoCenter.getSystemNetStateString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTime()).append("|").append(BaseApplication.getContext().getAppId()).append("|").append("android").append("|").append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append(paramString4).append("|").append(paramString5).append("|").append(paramInt).append("|").append(paramString6).append("|").append(c.a()).append("|").append("|").append(Build.MANUFACTURER).append("|").append(Build.MODEL).append("|").append(str).append("|").append(Build.VERSION.RELEASE).append("|").append(ROMUtil.getRomDetailInfo()).append("|").append(paramString7).append("|").append(paramString8).append("|").append(paramString9).append("|").append(paramString10).append("|").append(paramString11).append("|").append(paramString12).append("|").append(paramString13).append("|").append(paramString14).append("|");
    paramString1 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("BigTReportUtil", 2, "getDC04272ReportDetail=" + paramString1);
    }
    return paramString1;
  }
  
  public static void a(MsfCore paramMsfCore, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(paramString2.getBytes("UTF-8"));
      paramString2 = new HashMap();
      paramString2.put(paramString1, localArrayList);
      paramMsfCore.configManager.a(new HashMap(paramString2), "");
      return;
    }
    catch (Exception paramMsfCore)
    {
      paramMsfCore.printStackTrace();
    }
  }
  
  public static void a(MsfCore paramMsfCore, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    String str = a();
    a(paramMsfCore, "dc04272", a(paramMsfCore.getMainAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, str, "", "", "", "", "", "", ""));
  }
  
  public static void a(MsfCore paramMsfCore, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    String str = a();
    a(paramMsfCore, "dc04272", a(paramMsfCore.getMainAccount(), paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, str, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.a
 * JD-Core Version:    0.7.0.1
 */