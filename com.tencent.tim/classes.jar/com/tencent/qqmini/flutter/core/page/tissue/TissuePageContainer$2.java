package com.tencent.qqmini.flutter.core.page.tissue;

import com.tencent.qqmini.flutter.core.NativeAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.util.URL;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class TissuePageContainer$2
  implements BasicMessageChannel.MessageHandler
{
  TissuePageContainer$2(TissuePageContainer paramTissuePageContainer) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply paramReply)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if ((paramObject.containsKey("messageType")) && ("__tissue_bridge_ready_".equals((String)paramObject.get("messageType"))))
      {
        QMLog.w("miniapp-start-TISSUE", " tissue initialization done");
        MiniAppReportManager2.reportLaunchPiecewise(214, "", TissuePageContainer.access$000(this.this$0).getMiniAppInfo());
        TissuePageContainer.access$100(this.this$0);
      }
      if (paramObject.containsKey("method"))
      {
        localObject2 = paramObject.get("method").toString();
        if (!((String)localObject2).equals("publishHandler")) {
          break label258;
        }
        paramReply = (Map)paramObject.get("data");
        String str = paramReply.get("event").toString();
        localObject2 = (Integer)paramReply.get("pageID");
        paramObject = localObject1;
        if (paramReply.containsKey("dataForEvent")) {
          paramObject = (Map)paramReply.get("dataForEvent");
        }
        paramReply = (BasicMessageChannel.Reply)localObject2;
        if (localObject2 == null)
        {
          paramReply = (BasicMessageChannel.Reply)localObject2;
          if (paramObject != null)
          {
            paramReply = (BasicMessageChannel.Reply)localObject2;
            if (paramObject.containsKey("pageID")) {
              paramReply = (Integer)paramObject.get("pageID");
            }
          }
        }
        localObject1 = "null";
        if (paramObject != null) {
          localObject1 = new JSONObject(paramObject).toString();
        }
        TissuePageContainer.access$200(this.this$0).onWebViewEvent(str, (String)localObject1, paramReply.intValue());
      }
    }
    return;
    label258:
    if (((String)localObject2).equals("onAppRoute"))
    {
      paramObject = (Map)paramObject.get("data");
      localObject2 = paramObject.get("path").toString();
      paramReply = (Integer)paramObject.get("pageID");
      localObject1 = (String)paramObject.get("openType");
      if (!paramObject.containsKey("query")) {
        break label1256;
      }
    }
    label1243:
    label1251:
    label1256:
    for (paramObject = (Map)paramObject.get("query");; paramObject = null)
    {
      paramObject = new URL((String)localObject2, paramObject);
      TissuePageContainer.access$200(this.this$0).onAppRoute((String)localObject1, paramObject.getFullUrl(), paramReply.intValue());
      return;
      if (((String)localObject2).equals("onAppRouteDone"))
      {
        paramObject = (Map)paramObject.get("data");
        localObject2 = paramObject.get("path").toString();
        paramReply = (Integer)paramObject.get("pageID");
        localObject1 = (String)paramObject.get("openType");
        if (!paramObject.containsKey("query")) {
          break label1251;
        }
      }
      for (paramObject = (Map)paramObject.get("query");; paramObject = null)
      {
        paramObject = new URL((String)localObject2, paramObject);
        TissuePageContainer.access$200(this.this$0).onAppRouteDone((String)localObject1, paramObject.getFullUrl(), paramReply.intValue());
        return;
        if ("viewDidAppear".equals(localObject2))
        {
          TissuePageContainer.access$000(this.this$0).performAction(AppStateEvent.obtain(11));
          if ((!paramObject.containsKey("data")) || (!(paramObject.get("data") instanceof Map))) {
            break label1243;
          }
          paramObject = (Map)paramObject.get("data");
          if ((!paramObject.containsKey("pageID")) || (!(paramObject.get("pageID") instanceof Integer))) {
            break label1243;
          }
        }
        for (paramObject = (Integer)paramObject.get("pageID");; paramObject = Integer.valueOf(0))
        {
          QMLog.w("miniapp-start-TISSUE", "flutter page " + paramObject + " shown" + System.currentTimeMillis());
          if (TissuePageContainer.access$300(this.this$0)) {
            break;
          }
          if (TissuePageContainer.access$400(this.this$0)) {}
          for (paramObject = "1";; paramObject = "0")
          {
            MiniAppReportManager2.reportLaunchPiecewise(216, paramObject, TissuePageContainer.access$000(this.this$0).getMiniAppInfo());
            TissuePageContainer.access$302(this.this$0, true);
            return;
          }
          if ("invokeHandler".equals(localObject2))
          {
            paramReply = (Map)paramObject.get("data");
            paramObject = (String)paramReply.get("event");
            if ("invokeMiniProgramAPI".equals(paramObject))
            {
              int i = ((Integer)paramReply.get("pageID")).intValue();
              TissuePageContainer.access$200(this.this$0).onWebViewEvent("onWebInvokeAppService", (String)paramReply.get("param"), i);
            }
            paramReply = new JSONObject(paramReply).toString();
            TissuePageContainer.access$200(this.this$0).onWebViewNativeRequest(paramObject, paramReply, ((NativeAppBrandRuntime)TissuePageContainer.access$000(this.this$0)).getJsService(), 0);
            return;
          }
          if ("timeCostReport".equals(localObject2))
          {
            localObject2 = (Map)paramObject.get("data");
            if (localObject2 == null) {
              break;
            }
            paramObject = (Integer)((Map)localObject2).get("matchTimeCost");
            paramReply = (Integer)((Map)localObject2).get("setDataTimeCost");
            localObject1 = (Integer)((Map)localObject2).get("renderTimeCost");
            localObject2 = (Integer)((Map)localObject2).get("totalTimeCost");
            if (paramObject != null) {
              MiniReportManager.reportEventType(TissuePageContainer.access$000(this.this$0).getMiniAppInfo(), 217, "0", paramObject.intValue());
            }
            if (paramReply != null) {
              MiniReportManager.reportEventType(TissuePageContainer.access$000(this.this$0).getMiniAppInfo(), 218, "0", paramReply.intValue());
            }
            if (localObject1 != null) {
              MiniReportManager.reportEventType(TissuePageContainer.access$000(this.this$0).getMiniAppInfo(), 219, "0", ((Integer)localObject1).intValue());
            }
            if (localObject2 == null) {
              break;
            }
            MiniReportManager.reportEventType(TissuePageContainer.access$000(this.this$0).getMiniAppInfo(), 220, "0", ((Integer)localObject2).intValue());
            return;
          }
          if ("getAbsolutePath".equals(localObject2))
          {
            paramObject = (String)((Map)paramObject.get("data")).get("filePath");
            paramReply.reply(((MiniAppFileManager)TissuePageContainer.access$000(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(paramObject));
            return;
          }
          if (!"getWebConfiguration".equals(localObject2)) {
            break;
          }
          localObject1 = QUAUtil.getWebViewUA() + " tissue";
          localObject2 = new HashMap();
          if ((TissuePageContainer.access$000(this.this$0) instanceof NativeAppBrandRuntime))
          {
            paramObject = ((NativeAppBrandRuntime)TissuePageContainer.access$000(this.this$0)).getBaselibContent();
            if (paramObject == null) {}
          }
          for (paramObject = paramObject.miniappWebviewStr;; paramObject = "")
          {
            ((Map)localObject2).put("customUserAgent", localObject1);
            QMLog.w("miniapp-start-TISSUE", "systemUA" + (String)localObject1);
            QMLog.w("miniapp-start-TISSUE", " miniapp launch" + TissuePageContainer.access$500(this.this$0).appId);
            paramReply.reply(new TissuePageContainer.2.1(this, (String)localObject1, paramObject));
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.TissuePageContainer.2
 * JD-Core Version:    0.7.0.1
 */