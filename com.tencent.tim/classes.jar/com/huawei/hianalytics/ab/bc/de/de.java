package com.huawei.hianalytics.ab.bc.de;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.bc.ef;
import com.huawei.hianalytics.ab.ef.cd;
import java.util.HashMap;
import java.util.Map;

public class de
{
  public static ef ab()
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "generate UploadData");
    gh.ab().bc();
    if (TextUtils.isEmpty(gh.ab().de()))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "event chifer is empty");
      return null;
    }
    return new ef(gh.ab().cd());
  }
  
  public static com.huawei.hianalytics.ab.ef.ab ab(String paramString1, String paramString2)
  {
    com.huawei.hianalytics.ab.ef.ab localab = new com.huawei.hianalytics.ab.ef.ab();
    localab.ab(com.huawei.hianalytics.ab.cd.bc.ab.ab().de(paramString1, paramString2));
    return localab;
  }
  
  public static com.huawei.hianalytics.ab.ef.bc ab(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.huawei.hianalytics.ab.ef.bc localbc = new com.huawei.hianalytics.ab.ef.bc();
    localbc.fg(paramString1);
    localbc.ab(com.huawei.hianalytics.ab.ab.bc.ef());
    localbc.cd(paramString2);
    localbc.ef(paramString4);
    paramString1 = new StringBuffer("hmshi");
    paramString1.append(paramString3).append("qrt");
    localbc.de(paramString1.toString());
    return localbc;
  }
  
  public static cd ab(String paramString1, String paramString2, String paramString3)
  {
    cd localcd = new cd();
    localcd.ab(com.huawei.hianalytics.ab.ab.bc.bc());
    localcd.bc(com.huawei.hianalytics.ab.ab.bc.de());
    localcd.cd(paramString3);
    localcd.de(com.huawei.hianalytics.ab.cd.bc.ab.ab().ef(paramString2, paramString1));
    return localcd;
  }
  
  public static Map<String, String> bc(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("App-Id", com.huawei.hianalytics.ab.ab.bc.ef());
    localHashMap.put("App-Ver", com.huawei.hianalytics.ab.ab.bc.fg());
    localHashMap.put("Sdk-Name", "hianalytics");
    localHashMap.put("Sdk-Ver", "2.2.0.303");
    localHashMap.put("Device-Type", Build.MODEL);
    localHashMap.put("servicetag", paramString1);
    com.huawei.hianalytics.ab.bc.ef.ab.ab("hmsSdk", "sendData RequestId : %s", new Object[] { paramString2 });
    localHashMap.put("Request-Id", paramString2);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.de.de
 * JD-Core Version:    0.7.0.1
 */