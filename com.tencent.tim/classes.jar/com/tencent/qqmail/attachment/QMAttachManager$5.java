package com.tencent.qqmail.attachment;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import org.apache.commons.lang3.StringUtils;

class QMAttachManager$5
  implements QMCallback.ISuccessCallback
{
  QMAttachManager$5(QMAttachManager paramQMAttachManager, String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, Runnable paramRunnable) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    bool5 = true;
    bool4 = true;
    RequestFilter.resetRequestRunningState(this.val$req);
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    try
    {
      if (!this.val$lock) {
        break label250;
      }
      paramQMNetworkResponse = paramQMNetworkRequest.getString("lockstatus");
      if (paramQMNetworkResponse == null) {
        break label250;
      }
      bool1 = paramQMNetworkResponse.equals("0");
      if (!bool1) {
        break label250;
      }
      bool1 = true;
    }
    catch (Exception paramQMNetworkRequest)
    {
      for (;;)
      {
        try
        {
          QMSettingManager.sharedInstance().setAttachFolderLockStatus(this.val$accountId, bool1);
          bool3 = bool5;
          paramQMNetworkResponse = paramQMNetworkRequest.getString("svrmd5val");
          bool2 = bool4;
          bool3 = bool5;
          if (!StringUtils.isEmpty(paramQMNetworkResponse))
          {
            bool3 = bool5;
            String str = QMSettingManager.sharedInstance().getAttachFolderListSyncToken(this.val$accountId);
            bool2 = bool4;
            bool3 = bool5;
            if (!StringUtils.isEmpty(str))
            {
              bool2 = bool4;
              bool3 = bool5;
              if (str.equals(paramQMNetworkResponse)) {
                bool2 = false;
              }
            }
          }
          bool3 = bool2;
          if (!this.val$checkUpdate)
          {
            bool3 = bool2;
            QMSettingManager.sharedInstance().setAttachFolderListSyncToken(this.val$accountId, paramQMNetworkResponse);
          }
          bool3 = bool2;
          if (!this.val$checkUpdate)
          {
            bool3 = bool2;
            QMAttachManager.access$300(this.this$0, this.val$accountId, paramQMNetworkRequest);
          }
          if (this.val$onComplete != null) {
            this.val$onComplete.run();
          }
          QMWatcherCenter.triggerLoadAttachFolderListSuccess(this.val$accountId, bool1, this.val$checkUpdate, bool2);
          return;
        }
        catch (Exception paramQMNetworkRequest)
        {
          boolean bool3;
          boolean bool2 = bool3;
          continue;
        }
        paramQMNetworkRequest = paramQMNetworkRequest;
        bool2 = true;
        boolean bool1 = false;
        paramQMNetworkRequest.printStackTrace();
        continue;
        bool1 = false;
      }
    }
    bool3 = bool5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.5
 * JD-Core Version:    0.7.0.1
 */