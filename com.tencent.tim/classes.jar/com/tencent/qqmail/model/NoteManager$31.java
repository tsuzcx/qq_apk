package com.tencent.qqmail.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

class NoteManager$31
  implements QMCallback.ISuccessCallback
{
  NoteManager$31(NoteManager paramNoteManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    Object localObject = paramQMNetworkRequest.getString("defaultid");
    if (!StringUtils.isEmpty((CharSequence)localObject)) {
      NoteStorage.setDefaultCatId(this.this$0.mCurAccountId, (String)localObject);
    }
    localObject = (List)paramQMNetworkRequest.get("cataloglist");
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramQMNetworkRequest = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JSONObject localJSONObject = (JSONObject)((Iterator)localObject).next();
        paramQMNetworkRequest.add(new QMNNoteCategory(localJSONObject.getString("id"), localJSONObject.getString("name"), localJSONObject.getInteger("pos").intValue()));
      }
      NoteManager.access$200(this.this$0).updateNoteCategory(paramQMNetworkRequest);
    }
    if (this.val$fn != null) {
      this.val$fn.handleSuccess(paramQMNetworkResponse, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.31
 * JD-Core Version:    0.7.0.1
 */