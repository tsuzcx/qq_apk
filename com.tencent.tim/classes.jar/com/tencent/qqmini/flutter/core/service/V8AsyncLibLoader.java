package com.tencent.qqmini.flutter.core.service;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.SoLoaderOption;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.tissue.v8rt.engine.LibLoader;
import java.io.File;

public class V8AsyncLibLoader
  implements LibLoader
{
  public static final String LOG_TAG = "V8JsLoader";
  
  public boolean loadSo()
  {
    if (AppLoaderFactory.g().getCommonManager() == null)
    {
      QMLog.i("V8JsLoader", "tissueEnv is null");
      return false;
    }
    Object localObject = AppLoaderFactory.g().getCommonManager().getTissueSoPath();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QMLog.i("V8JsLoader", "libsDir is empty");
      return false;
    }
    try
    {
      System.loadLibrary("v8jni");
      ChannelProxy localChannelProxy = (ChannelProxy)AppLoaderFactory.g().getProxyManager().get(ChannelProxy.class);
      if ((localChannelProxy != null) && (localChannelProxy.getTissueSoLoaderOption() != null)) {
        localChannelProxy.getTissueSoLoaderOption().onBeforeLoadSo();
      }
      localObject = new File((String)localObject, "libtv8rt.so");
      if ((!((File)localObject).isFile()) || (!((File)localObject).canRead())) {
        throw new UnsatisfiedLinkError("libtv8rt.so is broken");
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("V8JsLoader", "errload", localThrowable);
      localThrowable.printStackTrace();
      return false;
    }
    QMLog.i("V8JsLoader", "libtv8rt len:" + localThrowable.length() + "," + localThrowable.getPath() + " classloader:" + getClass().getClassLoader());
    System.load(localThrowable.getAbsolutePath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.service.V8AsyncLibLoader
 * JD-Core Version:    0.7.0.1
 */