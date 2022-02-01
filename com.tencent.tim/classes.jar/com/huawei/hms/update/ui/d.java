package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.hms.utils.ResourceLoaderUtil;

public final class d
{
  static abstract class a
    extends b
  {
    public AlertDialog a()
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(f(), g());
      localBuilder.setMessage(h());
      localBuilder.setPositiveButton(i(), new d.a.1(this));
      localBuilder.setNegativeButton(j(), new d.a.2(this));
      return localBuilder.create();
    }
    
    protected abstract int h();
    
    protected abstract int i();
    
    protected abstract int j();
  }
  
  public static class b
    extends d.a
  {
    public b()
    {
      super();
    }
    
    protected int h()
    {
      return ResourceLoaderUtil.getStringId("hms_update_nettype");
    }
    
    protected int i()
    {
      return ResourceLoaderUtil.getStringId("hms_update_continue");
    }
    
    protected int j()
    {
      return ResourceLoaderUtil.getStringId("hms_cancel");
    }
  }
  
  public static class c
    extends d.a
  {
    public c()
    {
      super();
    }
    
    protected int h()
    {
      return ResourceLoaderUtil.getStringId("hms_download_retry");
    }
    
    protected int i()
    {
      return ResourceLoaderUtil.getStringId("hms_retry");
    }
    
    protected int j()
    {
      return ResourceLoaderUtil.getStringId("hms_cancel");
    }
  }
  
  public static class d
    extends d.a
  {
    public d()
    {
      super();
    }
    
    protected int h()
    {
      return ResourceLoaderUtil.getStringId("hms_abort_message");
    }
    
    protected int i()
    {
      return ResourceLoaderUtil.getStringId("hms_abort");
    }
    
    protected int j()
    {
      return ResourceLoaderUtil.getStringId("hms_cancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.d
 * JD-Core Version:    0.7.0.1
 */