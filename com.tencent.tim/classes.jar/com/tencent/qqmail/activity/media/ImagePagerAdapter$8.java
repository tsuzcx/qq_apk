package com.tencent.qqmail.activity.media;

import android.view.View;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.HashMap;

class ImagePagerAdapter$8
  implements QMCallback.ISuccessCallback
{
  ImagePagerAdapter$8(ImagePagerAdapter paramImagePagerAdapter, String paramString1, MediaItemInfo paramMediaItemInfo, String paramString2, View paramView) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = paramQMNetworkResponse.getResponseString().trim();
    ImagePagerAdapter.access$1200(this.this$0).put(this.val$imageKey, paramQMNetworkRequest);
    ImagePagerAdapter.access$1300(this.this$0, this.val$info, this.val$imageKey, this.val$imageUrl, this.val$layout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.8
 * JD-Core Version:    0.7.0.1
 */