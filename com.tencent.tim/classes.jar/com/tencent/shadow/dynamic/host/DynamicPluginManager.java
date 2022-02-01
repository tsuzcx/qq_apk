package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.proguard.k;
import java.io.File;

public final class DynamicPluginManager
  implements PluginManager
{
  private static final Logger d = LoggerFactory.getLogger(DynamicPluginManager.class);
  private final PluginManagerUpdater a;
  private PluginManagerImpl b;
  private long c;
  
  public DynamicPluginManager(PluginManagerUpdater paramPluginManagerUpdater)
  {
    if (paramPluginManagerUpdater.getLatest() == null) {
      throw new IllegalArgumentException("构造DynamicPluginManager时传入的PluginManagerUpdater必须已经已有本地文件，即getLatest()!=null");
    }
    this.a = paramPluginManagerUpdater;
  }
  
  public final void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (d.isInfoEnabled()) {
      d.info("enter fromId:" + paramLong + " callback:" + paramEnterCallback);
    }
    Object localObject1 = this.a.getLatest();
    long l = ((File)localObject1).lastModified();
    Object localObject2;
    boolean bool;
    if (d.isInfoEnabled())
    {
      localObject2 = d;
      StringBuilder localStringBuilder = new StringBuilder("mLastModified != lastModified : ");
      if (this.c != l)
      {
        bool = true;
        ((Logger)localObject2).info(bool);
      }
    }
    else if (this.c != l)
    {
      localObject2 = new k(paramContext, (File)localObject1).b();
      if (this.b == null) {
        break label234;
      }
      localObject1 = new Bundle();
      this.b.onSaveInstanceState((Bundle)localObject1);
      this.b.onDestroy();
    }
    for (;;)
    {
      ((PluginManagerImpl)localObject2).onCreate((Bundle)localObject1);
      this.b = ((PluginManagerImpl)localObject2);
      this.c = l;
      this.b.enter(paramContext, paramLong, paramBundle, paramEnterCallback);
      this.a.update();
      return;
      bool = false;
      break;
      label234:
      localObject1 = null;
    }
  }
  
  public final PluginManager getManagerImpl()
  {
    return this.b;
  }
  
  public final void release()
  {
    if (d.isInfoEnabled()) {
      d.info("release");
    }
    if (this.b != null)
    {
      this.b.onDestroy();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicPluginManager
 * JD-Core Version:    0.7.0.1
 */