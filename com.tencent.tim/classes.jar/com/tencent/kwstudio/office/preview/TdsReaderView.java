package com.tencent.kwstudio.office.preview;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.kwstudio.office.base.Global;
import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.debug.Noumenon;
import com.tencent.kwstudio.office.debug.ReportParam;
import com.tencent.kwstudio.office.debug.Reporter;
import java.lang.reflect.Constructor;

public abstract class TdsReaderView
  extends RelativeLayout
{
  private static final String DEFAULT_IMPL_CLASS = "com.tencent.kwstudio.office.preview.facade.TdsReaderViewImpl";
  private static final String TAG = "TdsReaderView";
  protected static volatile IHostInterface sHostInterface;
  
  protected TdsReaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static TdsReaderView impl(OpenCallback paramOpenCallback)
  {
    ReportParam localReportParam = new ReportParam("preview_impl");
    localReportParam.markTime();
    paramOpenCallback = implInner(paramOpenCallback);
    if (paramOpenCallback == null) {}
    for (int i = -1;; i = 0)
    {
      localReportParam.retCode = i;
      localReportParam.endTime();
      Reporter.reportOp(localReportParam);
      return paramOpenCallback;
    }
  }
  
  private static TdsReaderView implInner(OpenCallback paramOpenCallback)
  {
    ClassLoader localClassLoader = TdsReaderHelper.sDexClassLoader;
    if (localClassLoader == null)
    {
      Log.w("TdsReaderView", "classLoader is null");
      return null;
    }
    String str2 = sHostInterface.getConfig("facade_plugin_entry_class");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.kwstudio.office.preview.facade.TdsReaderViewImpl";
    }
    try
    {
      paramOpenCallback = (TdsReaderView)localClassLoader.loadClass(str1).getConstructor(new Class[] { Context.class, OpenCallback.class }).newInstance(new Object[] { Global.getApplicationContext(), paramOpenCallback });
      return paramOpenCallback;
    }
    catch (Exception paramOpenCallback)
    {
      Log.e("TdsReaderView", "impl error", paramOpenCallback);
    }
    return null;
  }
  
  public static void init(IHostInterface paramIHostInterface)
  {
    sHostInterface = paramIHostInterface;
    Log.setLog(paramIHostInterface.createLog());
    Global.setGlobal(paramIHostInterface.createGlobal());
    Noumenon.init(paramIHostInterface);
    TdsReaderHelper.checkFacadePluginAsync();
  }
  
  public static TdsReaderView newInstance(OpenCallback paramOpenCallback)
  {
    TdsReaderHelper.checkFacadePluginAsync();
    return impl(paramOpenCallback);
  }
  
  static void preActivePlugin()
  {
    impl(null);
  }
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onStop();
  
  public abstract boolean openFile(String paramString1, String paramString2);
  
  public abstract boolean preOpen(String paramString);
  
  public static abstract interface OpenCallback
  {
    public static final int ACTION_OPEN_ERROR = 2001;
    public static final String RESULT_ = "result_";
    public static final String RESULT_0 = "result_0";
    public static final String RESULT_1 = "result_1";
    public static final int VIEW_GET_TITLE_BAR_HEIGHT = 1001;
    public static final int VIEW_SET_TITLE_BAR_VISIBILITY = 1002;
    
    public abstract void onCallBackAction(Integer paramInteger, Object paramObject, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.TdsReaderView
 * JD-Core Version:    0.7.0.1
 */