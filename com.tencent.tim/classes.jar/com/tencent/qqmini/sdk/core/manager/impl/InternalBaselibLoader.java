package com.tencent.qqmini.sdk.core.manager.impl;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;
import java.io.File;

public class InternalBaselibLoader
  extends BaselibLoader
{
  public static final String TAG = "InternalBaselibLoader";
  
  public void loadBaselib(Context paramContext, BaselibLoader.OnLoadBaselibListener paramOnLoadBaselibListener)
  {
    for (;;)
    {
      BaselibLoader.BaselibContent localBaselibContent;
      try
      {
        if (isBaseLibInit())
        {
          if (paramOnLoadBaselibListener != null) {
            paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
          }
          return;
        }
        localBaselibContent = new BaselibLoader.BaselibContent();
        localBaselibContent.waWebviewJsStr = FileUtils.readFileFromAssets(paramContext, "mini/QView.js");
        File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js");
        if ((localFile.exists()) && (localFile.isFile()))
        {
          Log.i("InternalBaselibLoader", "load ServiceJs from " + localFile.getAbsolutePath());
          localBaselibContent.waServiceJsStr = FileUtils.readFileToStr(localFile);
          localBaselibContent.waServicePath = localFile.getAbsolutePath();
          localBaselibContent.waConsoleJsStr = FileUtils.readFileFromAssets(paramContext, "mini/QVConsole.js");
          localBaselibContent.waRemoteDebugStr = FileUtils.readFileFromAssets(paramContext, "mini/QRemoteDebug.js");
          localBaselibContent.miniappWebviewStr = FileUtils.readFileFromAssets(paramContext, "mini/QWebview.js");
          localBaselibContent.waWorkerStr = FileUtils.readFileFromAssets(paramContext, "mini/QWorker.js");
          setBaselib(localBaselibContent);
          if (paramOnLoadBaselibListener == null) {
            continue;
          }
          if (!isBaseLibInit()) {
            break label256;
          }
          paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
          continue;
        }
        Log.i("InternalBaselibLoader", "load ServiceJs from assets");
      }
      finally {}
      localBaselibContent.waServiceJsStr = FileUtils.readFileFromAssets(paramContext, "mini/QLogic.js");
      localBaselibContent.waServicePath = "assets://mini/QLogic.js";
      continue;
      label256:
      paramOnLoadBaselibListener.onResult(-1, "基础库加载失败", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.impl.InternalBaselibLoader
 * JD-Core Version:    0.7.0.1
 */