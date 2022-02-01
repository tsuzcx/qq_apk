package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.protocol.DataCollector;
import java.util.List;

class MediaBucketGridActivity$6
  implements MediaBucketGridAdapter.ClickCheckBoxListener
{
  MediaBucketGridActivity$6(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public boolean canCheck(int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) && (MediaBucketGridActivity.access$500(this.this$0)))
    {
      MediaBucketGridActivity.access$600(this.this$0);
      return false;
    }
    return true;
  }
  
  public void onClick(int paramInt, boolean paramBoolean)
  {
    MediaItemInfo localMediaItemInfo = (MediaItemInfo)MediaBucketGridActivity.access$700(this.this$0).getItem(paramInt);
    if (((MediaBucketGridActivity.access$800(this.this$0) == 1) || (MediaBucketGridActivity.access$800(this.this$0) == 2)) && (paramBoolean)) {
      DataCollector.logEvent("Event_ClickAdd_From_VirtualFolder");
    }
    for (;;)
    {
      MediaData.selectItem(localMediaItemInfo, paramBoolean);
      MediaBucketGridActivity.access$900(this.this$0);
      return;
      if ((paramBoolean) && (MediaData.getSelectedInfoList().size() == 0)) {
        DataCollector.logEvent("Event_ClickAdd_NotFrom_VirtualFolder");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.6
 * JD-Core Version:    0.7.0.1
 */