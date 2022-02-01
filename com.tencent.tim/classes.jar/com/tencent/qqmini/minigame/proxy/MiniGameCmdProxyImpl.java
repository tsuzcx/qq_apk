package com.tencent.qqmini.minigame.proxy;

import android.os.Bundle;
import com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

@ProxyService(proxy=CmdProxy.class)
public class MiniGameCmdProxyImpl
  implements CmdProxy
{
  public void handleMiniAppCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (("cmd_queue_mini_process_load_apkg".equals(paramString)) || ("cmd_remove_mini_process_load_apkg".equals(paramString)) || ("cmd_main_process_load_pkg".equals(paramString)) || ("cmd_main_process_download_pkg".equals(paramString)) || ("cmd_update_triton_engine".equals(paramString))) {
      ApkgMainProcessManager.handleMiniAppCmd(paramString, paramBundle, paramMiniCmdCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.proxy.MiniGameCmdProxyImpl
 * JD-Core Version:    0.7.0.1
 */