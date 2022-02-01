package com.huawei.hms.a;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

public abstract class b
  extends a
{
  protected String c(Context paramContext)
  {
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramContext);
    }
    return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
  }
  
  protected String d(Context paramContext)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.a.b
 * JD-Core Version:    0.7.0.1
 */