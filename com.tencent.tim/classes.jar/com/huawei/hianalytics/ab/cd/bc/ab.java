package com.huawei.hianalytics.ab.cd.bc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

public class ab
{
  private static ab bc;
  private Context ab;
  
  public static ab ab()
  {
    try
    {
      if (bc == null) {
        bc = new ab();
      }
      ab localab = bc;
      return localab;
    }
    finally {}
  }
  
  public com.huawei.hianalytics.ab.cd.ab.ab ab(String paramString1, String paramString2)
  {
    return new ab(paramString1, paramString2).ab(this.ab);
  }
  
  public String ab(boolean paramBoolean)
  {
    if (!paramBoolean) {
      localObject = "";
    }
    do
    {
      return localObject;
      str = com.huawei.hianalytics.ab.ab.bc.gh();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    String str = com.huawei.hianalytics.ab.bc.ij.ab.bc(this.ab, "global_v2", "uuid", "");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = UUID.randomUUID().toString().replace("-", "");
      com.huawei.hianalytics.ab.bc.ij.ab.ab(this.ab, "global_v2", "uuid", (String)localObject);
    }
    com.huawei.hianalytics.ab.ab.bc.ab((String)localObject);
    return localObject;
  }
  
  public void ab(Context paramContext)
  {
    if (this.ab == null) {
      this.ab = paramContext;
    }
  }
  
  public Pair<String, String> bc(String paramString1, String paramString2)
  {
    if (com.huawei.hianalytics.ab.ab.ab.fg(paramString1, paramString2))
    {
      paramString1 = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().b();
      paramString2 = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().c();
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        paramString1 = cd.gh(this.ab);
        com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().lm((String)paramString1.first);
        com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().a((String)paramString1.second);
        return paramString1;
      }
      return new Pair(paramString1, paramString2);
    }
    return new Pair("", "");
  }
  
  public String cd(String paramString1, String paramString2)
  {
    return de.bc(paramString1, paramString2);
  }
  
  public String de(String paramString1, String paramString2)
  {
    return de.ab(this.ab, paramString1, paramString2);
  }
  
  public String ef(String paramString1, String paramString2)
  {
    return de.bc(this.ab, paramString1, paramString2);
  }
  
  public String fg(String paramString1, String paramString2)
  {
    return de.ab(paramString1, paramString2);
  }
  
  static class ab
    extends bc
  {
    String ab;
    String bc;
    
    public ab(String paramString1, String paramString2)
    {
      this.ab = paramString1;
      this.bc = paramString2;
    }
    
    public String ab()
    {
      return com.huawei.hianalytics.ab.ab.ab.bc(this.ab, this.bc);
    }
    
    public String ab(String paramString)
    {
      return com.huawei.hianalytics.ab.bc.ab.bc.ab().ab(paramString);
    }
    
    public String bc()
    {
      return com.huawei.hianalytics.ab.ab.ab.ab(this.ab, this.bc);
    }
    
    public String cd()
    {
      return com.huawei.hianalytics.ab.ab.ab.de(this.ab, this.bc);
    }
    
    public int de()
    {
      int k = 0;
      int i;
      if (com.huawei.hianalytics.ab.ab.ab.hi(this.ab, this.bc))
      {
        i = 4;
        if (!com.huawei.hianalytics.ab.ab.ab.gh(this.ab, this.bc)) {
          break label63;
        }
      }
      label63:
      for (int j = 2;; j = 0)
      {
        if (com.huawei.hianalytics.ab.ab.ab.ik(this.ab, this.bc)) {
          k = 1;
        }
        return j | 0x0 | i | k;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.cd.bc.ab
 * JD-Core Version:    0.7.0.1
 */