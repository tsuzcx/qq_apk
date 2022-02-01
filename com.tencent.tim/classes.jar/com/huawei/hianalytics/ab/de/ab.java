package com.huawei.hianalytics.ab.de;

import android.util.Pair;
import com.huawei.hianalytics.ab.bc.cd.bc.ef;
import com.huawei.hianalytics.ab.bc.de.gh;
import java.util.List;
import java.util.Map;

public class ab
  extends com.huawei.hianalytics.ab.bc.de.de
{
  public static ef ab(List<com.huawei.hianalytics.ab.bc.cd.bc.de> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "generate UploadData");
    ef localef = com.huawei.hianalytics.ab.bc.de.de.ab();
    if (localef == null) {
      return null;
    }
    localef.ab(bc(gh.ab().de(), paramString1, paramString2, paramString3));
    localef.ab(cd(paramString1, paramString2));
    localef.ab(bc(paramString2, paramString1, paramString4));
    localef.ab(com.huawei.hianalytics.ab.ab.cd.fg(paramString1, paramString2));
    localef.ab(paramList);
    return localef;
  }
  
  protected static com.huawei.hianalytics.ab.ef.bc bc(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = com.huawei.hianalytics.ab.bc.de.de.ab(paramString1, paramString2, paramString3, paramString4);
    paramString2 = com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(com.huawei.hianalytics.ab.ab.cd.kl(paramString2, paramString3));
    long l = System.currentTimeMillis();
    paramString2 = com.huawei.hianalytics.ab.ab.bc.ef() + paramString2 + l;
    paramString2 = com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(paramString2);
    paramString1.bc(String.valueOf(l));
    paramString1.gh(paramString2);
    return paramString1;
  }
  
  protected static com.huawei.hianalytics.ab.ef.cd bc(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = com.huawei.hianalytics.ab.bc.de.de.ab(paramString1, paramString2, paramString3);
    Pair localPair = com.huawei.hianalytics.ab.cd.bc.ab.ab().bc(paramString2, paramString1);
    paramString3.fg((String)localPair.first);
    paramString3.gh((String)localPair.second);
    paramString3.hi(com.huawei.hianalytics.ab.cd.bc.cd.bc());
    paramString3.ef(com.huawei.hianalytics.ab.cd.bc.ab.ab().fg(paramString2, paramString1));
    return paramString3;
  }
  
  protected static com.huawei.hianalytics.ab.ef.ab cd(String paramString1, String paramString2)
  {
    com.huawei.hianalytics.ab.ef.ab localab = com.huawei.hianalytics.ab.bc.de.de.ab(paramString1, paramString2);
    com.huawei.hianalytics.ab.cd.ab.ab localab1 = com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(paramString1, paramString2);
    localab.fg(com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(com.huawei.hianalytics.ab.ab.cd.kl(paramString1, paramString2)));
    localab.de(com.huawei.hianalytics.ab.ab.cd.ab(paramString1, paramString2));
    localab.gh(com.huawei.hianalytics.ab.cd.bc.ab.ab().cd(paramString1, paramString2));
    paramString1 = localab1.ab();
    switch (ab.1.ab[paramString1.ordinal()])
    {
    default: 
      return localab;
    case 1: 
      localab.cd(localab1.bc());
      return localab;
    case 2: 
      localab.bc(localab1.bc());
      return localab;
    }
    localab.ef(localab1.bc());
    return localab;
  }
  
  public static Map<String, String> cd(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = bc(paramString1, paramString3);
    paramString1 = com.huawei.hianalytics.ab.ab.cd.lm(paramString1, paramString2);
    if (paramString1 == null) {
      return paramString3;
    }
    paramString3.putAll(paramString1);
    return paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.de.ab
 * JD-Core Version:    0.7.0.1
 */