import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

public class asth
{
  public static class a
  {
    public static String WEIYUN_PROCESS_NAME;
    private asth.a.a a;
    
    public a(IMiniAppContext paramIMiniAppContext)
    {
      WEIYUN_PROCESS_NAME = BaseApplicationImpl.getApplication().getQQProcessName();
      this.a = asth.a.a.a();
      if (this.a != null) {
        this.a.setMiniAppContext(paramIMiniAppContext);
      }
    }
    
    protected void a(String paramString, RequestEvent paramRequestEvent)
    {
      this.a.a(paramRequestEvent);
      paramRequestEvent = new Bundle();
      paramRequestEvent.putString("downloadId", paramString);
      QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Pause", paramRequestEvent, null);
    }
    
    protected void a(JSONObject paramJSONObject, String paramString, RequestEvent paramRequestEvent)
    {
      this.a.a(paramRequestEvent);
      try
      {
        this.a.registerModule(paramString);
        paramRequestEvent = new Bundle();
        paramRequestEvent.putString("downloadId", paramString);
        paramRequestEvent.putString("process", WEIYUN_PROCESS_NAME);
        paramRequestEvent.putString("file_id", (String)paramJSONObject.get("file_id"));
        paramRequestEvent.putString("filename", (String)paramJSONObject.get("filename"));
        paramRequestEvent.putString("pdir_key", (String)paramJSONObject.get("pdir_key"));
        QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Download", paramRequestEvent, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    
    protected void b(String paramString, RequestEvent paramRequestEvent)
    {
      this.a.a(paramRequestEvent);
      this.a.unregisterModule(paramString);
      paramRequestEvent = new Bundle();
      paramRequestEvent.putString("downloadId", paramString);
      QIPCClientHelper.getInstance().callServer("Module_WeiyunDownloadService", "WeiyunDownloadServiceIPC_Action__Cancel", paramRequestEvent, null);
    }
    
    protected boolean isLegal(JSONObject paramJSONObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      try
      {
        if (!TextUtils.isEmpty(paramJSONObject.getString("file_id")))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramJSONObject.getString("filename")))
          {
            boolean bool3 = TextUtils.isEmpty(paramJSONObject.getString("pdir_key"));
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      catch (JSONException paramJSONObject) {}
      return false;
    }
    
    public static class a
      extends QIPCModule
    {
      private CopyOnWriteArraySet<String> downloadIdList = new CopyOnWriteArraySet();
      private IMiniAppContext miniAppContext;
      private WeakReference<RequestEvent> weiyunDownloadFileJsContextWeakReference;
      
      private a()
      {
        super();
      }
      
      public static a a()
      {
        return asth.a.a.a.b();
      }
      
      public void a(RequestEvent paramRequestEvent)
      {
        this.weiyunDownloadFileJsContextWeakReference = new WeakReference(paramRequestEvent);
      }
      
      public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
      {
        arwt.d("WeiyunDownloadClientIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
        if (paramBundle == null) {}
        for (;;)
        {
          return null;
          Object localObject1;
          Object localObject2;
          if (paramString.equals("WeiyunDownloadClientIPC_Action__Suc"))
          {
            try
            {
              paramString = paramBundle.getString("filePath");
              localObject1 = new JSONObject();
              localObject2 = new File(paramString);
              ((JSONObject)localObject1).put("taskId", paramBundle.get("taskId"));
              ((JSONObject)localObject1).put("eventName", "onProgressUpdate");
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("progress", 100);
              localJSONObject.put("writtenBytes", ((File)localObject2).length());
              localJSONObject.put("totalBytes", ((File)localObject2).length());
              ((JSONObject)localObject1).put("data", localJSONObject);
              localObject2 = (RequestEvent)this.weiyunDownloadFileJsContextWeakReference.get();
              if (localObject2 != null) {
                ((RequestEvent)localObject2).jsService.evaluateSubscribeJS("onWeiyunDownLoadEvent", ((JSONObject)localObject1).toString(), 0);
              }
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("taskId", paramBundle.get("taskId"));
              ((JSONObject)localObject1).put("eventName", "success");
              paramBundle = new JSONObject();
              paramBundle.put("statusCode", 200);
              if (this.miniAppContext != null) {
                paramBundle.put("tempFilePath", ((IMiniAppFileManager)this.miniAppContext.getManager(IMiniAppFileManager.class)).getWxFilePath(paramString));
              }
              ((JSONObject)localObject1).put("data", paramBundle);
              if (localObject2 == null) {
                continue;
              }
              ((RequestEvent)localObject2).jsService.evaluateSubscribeJS("onWeiyunDownLoadEvent", ((JSONObject)localObject1).toString(), 0);
              return null;
            }
            catch (JSONException paramString)
            {
              QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onDownloadSuc--onWeiyunDownLoadEvent fail---");
              return null;
            }
          }
          else if (paramString.equals("WeiyunDownloadClientIPC_Action__Fail"))
          {
            paramString = new JSONObject();
            try
            {
              localObject1 = paramBundle.getString("errCode");
              localObject2 = paramBundle.getString("errMsg");
              paramString.put("taskId", paramBundle.get("taskId"));
              paramString.put("eventName", "fail");
              paramBundle = new JSONObject();
              paramBundle.put("errCode", localObject1);
              paramBundle.put("errMsg", localObject2);
              paramString.put("data", paramBundle);
              paramBundle = (RequestEvent)this.weiyunDownloadFileJsContextWeakReference.get();
              if (paramBundle == null) {
                continue;
              }
              paramBundle.jsService.evaluateSubscribeJS("onWeiyunDownLoadEvent", paramString.toString(), 0);
              return null;
            }
            catch (Exception paramString)
            {
              QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
              return null;
            }
          }
          else
          {
            if (paramString.equals("WeiyunDownloadClientIPC_Action__Complete"))
            {
              paramString = new JSONObject();
              try
              {
                paramInt = paramBundle.getInt("retCode");
                localObject1 = paramBundle.getString("retMsg");
                paramString.put("taskId", paramBundle.get("taskId"));
                paramString.put("eventName", "complete");
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("retCode", paramInt);
                ((JSONObject)localObject2).put("retMsg", localObject1);
                paramString.put("data", localObject2);
                localObject1 = (RequestEvent)this.weiyunDownloadFileJsContextWeakReference.get();
                if (localObject1 != null) {
                  ((RequestEvent)localObject1).jsService.evaluateSubscribeJS("onWeiyunDownLoadEvent", paramString.toString(), 0);
                }
                unregisterModule(paramBundle.getString("taskId"));
                return null;
              }
              catch (Exception paramString)
              {
                QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
                return null;
              }
            }
            if (paramString.equals("WeiyunDownloadClientIPC_Action__Progress"))
            {
              paramString = new JSONObject();
              try
              {
                paramInt = paramBundle.getInt("progress");
                long l1 = paramBundle.getLong("currSize");
                long l2 = paramBundle.getLong("totalSize");
                paramString.put("taskId", paramBundle.get("taskId"));
                paramString.put("eventName", "onProgressUpdate");
                paramBundle = new JSONObject();
                paramBundle.put("progress", paramInt);
                paramBundle.put("writtenBytes", l1);
                paramBundle.put("totalBytes", l2);
                paramString.put("data", paramBundle);
                paramBundle = (RequestEvent)this.weiyunDownloadFileJsContextWeakReference.get();
                if (paramBundle != null)
                {
                  paramBundle.jsService.evaluateSubscribeJS("onWeiyunDownLoadEvent", paramString.toString(), 0);
                  return null;
                }
              }
              catch (Exception paramString)
              {
                QLog.e("WeiyunDownloadClientIPC", 1, "WeiyunDownload--onProgressUpdate--onWeiyunDownLoadEvent fail---");
              }
            }
          }
        }
        return null;
      }
      
      public void registerModule(String paramString)
      {
        try
        {
          if (this.downloadIdList.size() == 0) {
            QIPCClientHelper.getInstance().register(this);
          }
          this.downloadIdList.add(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", paramString);
        }
      }
      
      public void setMiniAppContext(IMiniAppContext paramIMiniAppContext)
      {
        this.miniAppContext = paramIMiniAppContext;
      }
      
      public void unregisterModule(String paramString)
      {
        try
        {
          this.downloadIdList.remove(paramString);
          if (this.downloadIdList.size() == 0) {
            QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
          }
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("WeiyunDownloadClientIPC", 1, "register ipc module error.", paramString);
        }
      }
      
      static class a
      {
        private static asth.a.a b = new asth.a.a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asth
 * JD-Core Version:    0.7.0.1
 */