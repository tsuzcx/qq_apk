package com.huawei.hianalytics.ab.cd.bc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.ab.de;

public abstract class bc
{
  private com.huawei.hianalytics.ab.cd.ab.ab ab(int paramInt, Context paramContext)
  {
    if (((paramInt & 0x4) != 0) && ((paramInt & 0x1) != 0)) {
      return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, ab(bc(paramContext)));
    }
    String str1;
    if ((paramInt & 0x1) != 0)
    {
      String str2 = bc(paramContext);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.cd, str2);
      }
    }
    else
    {
      str1 = "";
    }
    if ((paramInt & 0x2) != 0)
    {
      paramContext = cd(paramContext);
      return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.ab, paramContext);
    }
    return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.de, str1);
  }
  
  private com.huawei.hianalytics.ab.cd.ab.ab bc(int paramInt, Context paramContext)
  {
    Object localObject = "";
    if (paramInt != 0)
    {
      localObject = fg();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, (String)localObject);
      }
    }
    if ((paramInt & 0x2) != 0)
    {
      String str = cd(paramContext);
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.ab, str);
      }
    }
    if ((paramInt & 0x1) != 0)
    {
      paramContext = bc(paramContext);
      return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.cd, paramContext);
    }
    return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.de, (String)localObject);
  }
  
  private String bc(Context paramContext)
  {
    de localde = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd();
    if (TextUtils.isEmpty(localde.de())) {
      localde.ab(cd.fg(paramContext));
    }
    return localde.de();
  }
  
  private String cd(Context paramContext)
  {
    de localde = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd();
    if (TextUtils.isEmpty(localde.gh())) {
      localde.de(cd.ef(paramContext));
    }
    return localde.gh();
  }
  
  private boolean ef()
  {
    de localde = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd();
    if (TextUtils.isEmpty(localde.fg())) {
      localde.cd(cd.ab());
    }
    return !TextUtils.isEmpty(localde.fg());
  }
  
  private String fg()
  {
    de localde = com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd();
    if (TextUtils.isEmpty(localde.hi())) {
      localde.ef(cd.cd());
    }
    return localde.hi();
  }
  
  public com.huawei.hianalytics.ab.cd.ab.ab ab(Context paramContext)
  {
    String str = ab();
    if (!TextUtils.isEmpty(str)) {
      return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, str);
    }
    str = bc();
    if (!TextUtils.isEmpty(str)) {
      return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.ab, str);
    }
    boolean bool = ef();
    str = cd();
    if (!TextUtils.isEmpty(str))
    {
      if (bool) {
        return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.cd, str);
      }
      return new com.huawei.hianalytics.ab.cd.ab.ab(com.huawei.hianalytics.ab.cd.ab.bc.bc, ab(str));
    }
    if (bool) {
      return bc(de(), paramContext);
    }
    return ab(de(), paramContext);
  }
  
  public abstract String ab();
  
  public abstract String ab(String paramString);
  
  public abstract String bc();
  
  public abstract String cd();
  
  public abstract int de();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.cd.bc.bc
 * JD-Core Version:    0.7.0.1
 */