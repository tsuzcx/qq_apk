package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04902;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager;
import com.tencent.mobileqq.minigame.manager.GameEnvManager;
import com.tencent.qphone.base.util.QLog;

public class MiniAppCmdServlet
{
  public static final String CMD_DC_REPORT_LOG_KEY_DATA = "cmd_dc_report_log_key_data";
  public static final String CMD_EXIT_QQ = "cmd_exit_qq";
  public static final String CMD_NOTIFY_EVENT_INFO = "cmd_notify_event_info";
  public static final String CMD_ON_PRELOAD_GAME_BASELIB = "cmd_on_preload_game_baselib";
  public static final String CMD_REBIND_ENGINE_CHANNEL = "cmd_rebind_engine_channel";
  public static final String CMD_REBIND_ENGINE_CHANNEL_NEW = "cmd_rebind_engine_channel_new";
  public static final String CMD_SHARE_ARK_ASYNC_MESSAGE = "cmd_share_ark_async_message";
  public static final String CMD_UPDATE_APP_FOR_MINI_GAME = "cmd_update_app_for_mini_game";
  public static final String CMD_UPDATE_BASELIB = "cmd_update_baselib";
  public static final String CMD_UPDATE_PULL_DOWN_ENTRY_LIST = "cmd_update_pull_down_entry_list";
  public static final String CMD_UPDATE_TRITON_ENGINE = "cmd_update_triton_engine";
  public static final String CMD_UPLOAD_ARK_SHARE_IMAGE = "cmd_upload_ark_share_image";
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_BUNDLE_APP_TYPE = "bundle_key_app_type";
  public static final String KEY_BUNDLE_PRELOAD_GAME_BASELIB_VERSION = "bundle_key_preload_game_baselib_version";
  public static final String KEY_BUNDLE_PROCESS_NAME = "bundle_key_process_name";
  public static final String KEY_EVENT = "key_event";
  public static final String KEY_SCENE = "key_scene";
  public static final String KEY_TIMESTAMP = "key_timestamp";
  public static final String KEY_VIA = "key_via";
  private static final String TAG = "MiniAppCmdServlet";
  private static MiniAppCmdServlet instance;
  private static byte[] lock = new byte[0];
  
  public static MiniAppCmdServlet g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniAppCmdServlet();
      }
      return instance;
    }
  }
  
  private void notifyEventInfo(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramString = paramBundle.getString("key_appid", "");
      int i = paramBundle.getInt("key_scene", 9999);
      String str1 = paramBundle.getString("key_via", "");
      String str2 = paramBundle.getString("key_event", "");
      long l = paramBundle.getLong("key_timestamp", 0L);
      MiniAppNotify.g.notify(paramString, i, str1, str2, l);
    }
  }
  
  public void onMiniAppCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    int j = 2;
    int i = -1;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("MiniAppCmdServlet", 2, "sendCmd cmd=" + paramString);
          if (paramBundle != null) {
            ApkgMainProcessManager.handleMiniAppCmd(paramString, paramBundle, paramCmdCallback);
          }
          if ("cmd_exit_qq".equals(paramString))
          {
            Process.killProcess(Process.myPid());
            return;
          }
          if ("cmd_update_baselib".equals(paramString))
          {
            if (paramBundle != null) {
              paramBundle.getString("version");
            }
            BaseLibManager.g().forceUpdateBaseLib(new MiniAppCmdServlet.1(this, paramCmdCallback, paramString));
            return;
          }
          if ("cmd_upload_ark_share_image".equals(paramString))
          {
            if (paramBundle != null)
            {
              MiniArkShareAsyncManager.performUploadArkShareImage(paramBundle.getString("filePath"), paramCmdCallback);
              return;
            }
            QLog.e("MiniAppCmdServlet", 1, "onMiniAppCmd cmd = " + paramString + ", bundle is null");
            return;
          }
          if ("cmd_share_ark_async_message".equals(paramString))
          {
            if (paramBundle != null)
            {
              MiniArkShareAsyncManager.performShareArkAsyncMessage(paramBundle, paramCmdCallback);
              return;
            }
            QLog.e("MiniAppCmdServlet", 1, "onMiniAppCmd cmd = " + paramString + ", bundle is null");
            return;
          }
          if ("cmd_dc_report_log_key_data".equals(paramString))
          {
            MiniProgramLpReportDC04902.reportToServer(paramBundle);
            return;
          }
          if (!"cmd_rebind_engine_channel".equals(paramString)) {
            break;
          }
          if (paramBundle != null) {
            i = paramBundle.getInt("bundle_key_app_type", -1);
          }
          QLog.i("MiniAppCmdServlet", 1, "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
        } while ((i != 0) && (i != 1));
        paramBundle = new Bundle();
        localObject = com.tencent.mobileqq.minigame.manager.EngineManager.g();
        if (i == 1) {}
        for (i = 2;; i = 3)
        {
          paramBundle.putParcelable("engineChannel", ((com.tencent.mobileqq.minigame.manager.EngineManager)localObject).getChannelForType(i));
          if (paramCmdCallback == null) {
            break;
          }
          try
          {
            paramCmdCallback.onCmdResult(true, paramBundle);
            return;
          }
          catch (RemoteException paramBundle)
          {
            QLog.e("MiniAppCmdServlet", 1, "cmd response exception. cmd=" + paramString, paramBundle);
            return;
          }
        }
        if (!"cmd_rebind_engine_channel_new".equals(paramString)) {
          break;
        }
        if (paramBundle != null) {
          i = paramBundle.getInt("bundle_key_app_type", -1);
        }
        QLog.i("MiniAppCmdServlet", 1, "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i);
      } while ((i != 0) && (i != 1));
      paramBundle = new Bundle();
      Object localObject = com.tencent.qqmini.sdk.manager.EngineManager.g();
      if (i == 1) {}
      for (i = j;; i = 3)
      {
        paramBundle.putParcelable("engineChannel", ((com.tencent.qqmini.sdk.manager.EngineManager)localObject).getChannelForType(i));
        if (paramCmdCallback == null) {
          break;
        }
        try
        {
          paramCmdCallback.onCmdResult(true, paramBundle);
          return;
        }
        catch (RemoteException paramBundle)
        {
          QLog.e("MiniAppCmdServlet", 1, "cmd response exception. cmd=" + paramString, paramBundle);
          return;
        }
      }
      if ("cmd_update_pull_down_entry_list".equals(paramString))
      {
        if (paramBundle != null)
        {
          MiniAppUtils.handlePullDownEntryListData(paramBundle, paramCmdCallback);
          return;
        }
        QLog.e("MiniAppCmdServlet", 1, "onMiniAppCmd cmd = " + paramString + ", bundle is null");
        return;
      }
      if ("cmd_update_app_for_mini_game".equals(paramString))
      {
        JsApiUpdateManager.handleUpdateAppForMiniGame(paramBundle);
        return;
      }
      if ("cmd_update_triton_engine".equals(paramString))
      {
        GameEnvManager.checkTritonUpdate();
        return;
      }
    } while (!"cmd_notify_event_info".equals(paramString));
    notifyEventInfo(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppCmdServlet
 * JD-Core Version:    0.7.0.1
 */