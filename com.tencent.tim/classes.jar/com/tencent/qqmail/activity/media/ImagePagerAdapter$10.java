package com.tencent.qqmail.activity.media;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;
import java.util.List;

class ImagePagerAdapter$10
  implements QMCallback.ISuccessCallback
{
  ImagePagerAdapter$10(ImagePagerAdapter paramImagePagerAdapter, int paramInt, String paramString1, String paramString2, View paramView, MediaItemInfo paramMediaItemInfo) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    String str = paramQMNetworkResponse.getResponseString();
    if ((str != null) && (!str.equals("")))
    {
      paramQMNetworkResponse.setResponseJson(JSONReader.parse(str));
      paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    }
    for (;;)
    {
      if (paramQMNetworkRequest != null)
      {
        paramQMNetworkResponse = (String)paramQMNetworkRequest.get("errcode");
        if (paramQMNetworkResponse.equals("-6"))
        {
          paramQMNetworkRequest = (MailBigAttach)((MediaItemInfo)ImagePagerAdapter.access$1400(this.this$0).get(this.val$position)).getAttach();
          QMAttachManager.sharedInstance().updateBigAttachExpire(paramQMNetworkRequest.getHashId(), -2L);
          QMNotification.postNotification("ftnfailexpired", QMNotification.createNotification(new Object[] { "ftnfailexpired", Long.valueOf(paramQMNetworkRequest.getHashId()) }));
          Threads.runOnMainThread(new ImagePagerAdapter.10.1(this, paramQMNetworkResponse));
          return;
        }
      }
      ImagePagerAdapter.access$1600(this.this$0).put(this.val$imageKey, paramQMNetworkRequest);
      ImagePagerAdapter.access$1300(this.this$0, this.val$info, this.val$imageKey, this.val$imageUrl, this.val$layout);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.10
 * JD-Core Version:    0.7.0.1
 */