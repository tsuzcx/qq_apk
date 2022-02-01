package com.tencent.qqmini.sdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import java.util.Map;

public abstract class BaseRuntimeImpl
  extends BaseRuntime
{
  protected Context mContext;
  
  public BaseRuntimeImpl(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = new MiniAppFileManager();
    this.mManagerMap.put(MiniAppFileManager.class, paramContext);
    this.mManagerMap.put(IMiniAppFileManager.class, paramContext);
    paramContext = new BaselibProvider();
    this.mManagerMap.put(BaselibProvider.class, paramContext);
    paramContext = new MiniAppRealTimeLogReporter();
    this.mManagerMap.put(MiniAppRealTimeLogReporter.class, paramContext);
    paramContext = new ObserverManager();
    this.mManagerMap.put(ObserverManager.class, paramContext);
  }
  
  public class BaselibProvider
  {
    private BaselibLoader.BaselibContent mBaselibContent;
    
    public BaselibProvider() {}
    
    public String getBasePageFrameStr()
    {
      if ((this.mBaselibContent != null) && (!TextUtils.isEmpty(this.mBaselibContent.pageFrameStr))) {
        return this.mBaselibContent.pageFrameStr;
      }
      return "<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" /><meta http-equiv=\"Content-Security-Policy\" content=\"script-src 'self' 'unsafe-inline' 'unsafe-eval'\"><link rel=\"icon\" href=\"data:image/ico;base64,aWNv\"><script></script></head><body><div></div></body></html>";
    }
    
    public BaselibLoader.BaselibContent getBaselibContent()
    {
      return this.mBaselibContent;
    }
    
    public void setBaseLib(BaselibLoader.BaselibContent paramBaselibContent)
    {
      this.mBaselibContent = paramBaselibContent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.BaseRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */