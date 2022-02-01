package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.ab.bc.ab;
import com.huawei.hianalytics.ab.bc.ab.fg;

public class ab
{
  private static ab ab = new ab();
  private final Object bc = new Object();
  private String cd;
  
  public static ab ab()
  {
    return ab;
  }
  
  private String cd()
  {
    String str1 = com.huawei.hianalytics.ab.bc.gh.bc.ab().cd();
    String str2 = com.huawei.hianalytics.ab.bc.ij.ab.bc(com.huawei.hianalytics.ab.ab.bc.ik(), "global_v2", "common_prop", "");
    return com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(bc.ab.ab).ab(str1, str2);
  }
  
  private void de()
  {
    String str = com.huawei.hianalytics.ab.bc.gh.bc.ab().cd();
    str = com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(bc.ab.ab).bc(str, this.cd);
    com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "global_v2", "common_prop", str);
  }
  
  public void ab(String paramString)
  {
    synchronized (this.bc)
    {
      this.cd = paramString;
      de();
      return;
    }
  }
  
  public String bc()
  {
    synchronized (this.bc)
    {
      if (TextUtils.isEmpty(this.cd)) {
        this.cd = cd();
      }
      String str = this.cd;
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.de.ab
 * JD-Core Version:    0.7.0.1
 */