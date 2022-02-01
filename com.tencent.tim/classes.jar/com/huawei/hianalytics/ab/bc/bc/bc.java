package com.huawei.hianalytics.ab.bc.bc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.ab.de;

public abstract class bc
{
  public static String ab(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(com.huawei.hianalytics.ab.ab.ab.cd(paramString1, paramString2))) {
      return com.huawei.hianalytics.ab.ab.ab.cd(paramString1, paramString2);
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "getAndroidId(): to getConfigByType()");
    return cd(paramContext, paramString1, paramString2);
  }
  
  public static String bc(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2.equals("oper")) {
      return de(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("maint")) {
      return de(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("diffprivacy")) {
      return de(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("preins")) {
      return de(paramContext, paramString1, paramString2);
    }
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "getChannel(): Invalid type: " + paramString2);
    return "";
  }
  
  private static String cd(Context paramContext, String paramString1, String paramString2)
  {
    if (com.huawei.hianalytics.ab.ab.ab.ij(paramString1, paramString2))
    {
      if (TextUtils.isEmpty(com.huawei.hianalytics.ab.ab.bc.cd()))
      {
        paramContext = com.huawei.hianalytics.ab.cd.bc.cd.cd(paramContext);
        com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().fg(paramContext);
      }
      return com.huawei.hianalytics.ab.ab.bc.cd();
    }
    return "";
  }
  
  private static String de(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(com.huawei.hianalytics.ab.ab.cd.bc(paramString1, paramString2))) {
      return com.huawei.hianalytics.ab.ab.cd.bc(paramString1, paramString2);
    }
    paramString2 = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd();
    if (TextUtils.isEmpty(paramString2.ef()))
    {
      paramString1 = com.huawei.hianalytics.ab.cd.bc.cd.de(paramContext);
      paramContext = paramString1;
      if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("channel", paramString1, 256)) {
        paramContext = "";
      }
      paramString2.bc(paramContext);
    }
    return paramString2.ef();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.bc.bc
 * JD-Core Version:    0.7.0.1
 */