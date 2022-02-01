package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.hms.utils.ResourceLoaderUtil;

public final class j
{
  static abstract class a
    extends b
  {
    public AlertDialog a()
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(f(), g());
      localBuilder.setMessage(h());
      localBuilder.setPositiveButton(i(), new j.a.1(this));
      return localBuilder.create();
    }
    
    protected abstract int h();
    
    protected int i()
    {
      return ResourceLoaderUtil.getStringId("hms_confirm");
    }
  }
  
  public static class b
    extends j.a
  {
    public b()
    {
      super();
    }
    
    protected int h()
    {
      return ResourceLoaderUtil.getStringId("hms_check_failure");
    }
  }
  
  public static class c
    extends j.a
  {
    public c()
    {
      super();
    }
    
    protected int h()
    {
      return ResourceLoaderUtil.getStringId("hms_download_failure");
    }
  }
  
  public static class d
    extends j.a
  {
    public d()
    {
      super();
    }
    
    protected int h()
    {
      return ResourceLoaderUtil.getStringId("hms_download_no_space");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.j
 * JD-Core Version:    0.7.0.1
 */