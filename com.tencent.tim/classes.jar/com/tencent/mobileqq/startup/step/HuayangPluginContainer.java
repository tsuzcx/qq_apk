package com.tencent.mobileqq.startup.step;

import aibx;
import aifl;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.widget.Toast;
import aolf;
import aqqv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import java.io.File;
import mqq.app.MobileQQ;

public class HuayangPluginContainer
  extends Step
{
  private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
  
  protected boolean doStep()
  {
    if (new File("/data/local/tmp/troophomework.debug").exists())
    {
      Toast.makeText(BaseApplicationImpl.getContext(), "waitForDebugger", 1).show();
      Debug.waitForDebugger();
    }
    LoggerFactory.setILoggerFactory(aibx.a());
    BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(PluginProcessService.getActivityHolder());
    DynamicRuntime.recoveryRuntime(BaseApplicationImpl.getContext());
    aifl.dsq();
    a locala = new a(BaseApplicationImpl.getApplication());
    URLDrawable.init(BaseApplicationImpl.getApplication(), locala);
    new InitUrlDrawable().step();
    new InitMemoryCache().step();
    return true;
  }
  
  public static class a
    extends URLDrawableParams
  {
    private ProtocolDownloader a;
    
    public a(MobileQQ paramMobileQQ)
    {
      super();
    }
    
    public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
    {
      if ((("http".equals(paramString)) || ("https".equals(paramString))) && (this.a == null)) {
        this.a = new aolf();
      }
      return this.a;
    }
    
    public String doGetLocalFilePath(String paramString)
    {
      return null;
    }
    
    public ApngSoLoader getApngSoLoader()
    {
      return aqqv.a();
    }
    
    public Drawable getDefaultLoadingDrawable()
    {
      return BaseApplicationImpl.getContext().getResources().getDrawable(2130848704);
    }
    
    public Drawable getDefualtFailedDrawable()
    {
      return BaseApplicationImpl.getContext().getResources().getDrawable(2130848704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HuayangPluginContainer
 * JD-Core Version:    0.7.0.1
 */