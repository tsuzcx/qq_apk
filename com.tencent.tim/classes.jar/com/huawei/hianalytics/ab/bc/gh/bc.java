package com.huawei.hianalytics.ab.bc.gh;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.bc.ab;
import com.huawei.hianalytics.ab.bc.ab.fg;

public class bc
{
  private static bc ab;
  private String bc;
  private String cd;
  
  public static bc ab()
  {
    if (ab == null) {
      de();
    }
    return ab;
  }
  
  private boolean ab(String paramString)
  {
    com.huawei.hianalytics.ab.bc.ef.ab.bc("RootKeyManager", "refresh sp aes key");
    paramString = com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(bc.ab.ab).bc(fg(), paramString);
    if (TextUtils.isEmpty(paramString))
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("RootKeyManager", "refreshLocalKey(): encrypted key is empty");
      return false;
    }
    com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "Privacy_MY", "PrivacyData", paramString);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    return true;
  }
  
  private static void de()
  {
    try
    {
      if (ab == null) {
        ab = new bc();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String ef()
  {
    Object localObject = com.huawei.hianalytics.ab.bc.ij.ab.bc(com.huawei.hianalytics.ab.ab.bc.ik(), "Privacy_MY", "PrivacyData", "");
    com.huawei.hianalytics.ab.bc.ab.bc localbc = com.huawei.hianalytics.ab.bc.ab.bc.ab();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = localbc.bc(bc.ab.ab);
      ab((String)localObject);
    }
    String str;
    do
    {
      return localObject;
      str = localbc.ab(bc.ab.ab).ab(fg(), (String)localObject);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    localObject = localbc.bc(bc.ab.ab);
    ab((String)localObject);
    return localObject;
  }
  
  private String fg()
  {
    if (TextUtils.isEmpty(this.cd)) {
      this.cd = new ab().ab();
    }
    return this.cd;
  }
  
  public void bc()
  {
    String str = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(bc.ab.ab);
    if (ab(str)) {
      this.bc = str;
    }
  }
  
  public String cd()
  {
    if (TextUtils.isEmpty(this.bc)) {
      this.bc = ef();
    }
    return this.bc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.gh.bc
 * JD-Core Version:    0.7.0.1
 */