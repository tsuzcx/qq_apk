package com.tencent.qqmail.model.mail;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$13
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$13(QMMailCGIManager paramQMMailCGIManager, QMFolderManager.FolderOperationType paramFolderOperationType, String paramString, int paramInt, FolderOperationCallback paramFolderOperationCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkResponse = new QMFolder();
    int i;
    if ((this.val$type == QMFolderManager.FolderOperationType.ADD_FOLDER) || (this.val$type == QMFolderManager.FolderOperationType.ADD_TAG))
    {
      paramQMNetworkResponse.parseWithDictionary(paramQMNetworkRequest);
      if (this.val$name != null)
      {
        paramQMNetworkResponse.setName(this.val$name);
        paramQMNetworkResponse.setAccountId(this.val$accountId);
      }
      if (this.val$type != QMFolderManager.FolderOperationType.ADD_TAG) {
        break label108;
      }
      i = 1;
      if (i == 0) {
        break label113;
      }
      paramQMNetworkResponse.setType(14);
    }
    for (;;)
    {
      paramQMNetworkResponse.setOverdue(true);
      if (this.val$callback != null) {
        this.val$callback.onSuccess(paramQMNetworkResponse);
      }
      return;
      label108:
      i = 0;
      break;
      label113:
      paramQMNetworkResponse.setType(12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.13
 * JD-Core Version:    0.7.0.1
 */