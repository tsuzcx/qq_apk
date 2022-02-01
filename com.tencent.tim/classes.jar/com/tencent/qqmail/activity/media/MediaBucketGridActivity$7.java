package com.tencent.qqmail.activity.media;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.protocol.DataCollector;

class MediaBucketGridActivity$7
  implements AdapterView.OnItemClickListener
{
  MediaBucketGridActivity$7(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent;
    if (MediaBucketGridActivity.access$1000(this.this$0) == QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR)
    {
      localIntent = ImageCropActivity.createIntent(((MediaItemInfo)MediaBucketGridActivity.access$700(this.this$0).getItem(paramInt)).getDataPath());
      this.this$0.startActivityForResult(localIntent, 1);
      if ((MediaBucketGridActivity.access$800(this.this$0) == 1) || (MediaBucketGridActivity.access$800(this.this$0) == 2)) {
        DataCollector.logEvent("Event_ClickAdd_From_VirtualFolder");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      DataCollector.logEvent("Event_ClickAdd_NotFrom_VirtualFolder");
      continue;
      if ((MediaBucketGridActivity.access$700(this.this$0).getItemViewType(paramInt) == 1) && (paramInt == 0))
      {
        if (MediaBucketGridActivity.access$500(this.this$0)) {
          MediaBucketGridActivity.access$600(this.this$0);
        } else {
          MediaBucketGridActivity.access$1100(this.this$0);
        }
      }
      else
      {
        paramInt -= MediaBucketGridActivity.access$700(this.this$0).getCameraCnt();
        localIntent = MeidaBigBucketSelectActivity.createIntent(MediaBucketGridActivity.access$1000(this.this$0), MediaBucketGridActivity.access$1200(this.this$0), paramInt, null, MediaBucketGridActivity.access$1300(this.this$0));
        this.this$0.startActivityForResult(localIntent, 2);
        this.this$0.overridePendingTransition(0, 0);
        DataCollector.logEvent("Event_Enter_Preview_Album");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.7
 * JD-Core Version:    0.7.0.1
 */