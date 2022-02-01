package com.tencent.qqmail.activity.media;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

class MediaFolderSelectActivity$4
  implements AdapterView.OnItemClickListener
{
  MediaFolderSelectActivity$4(MediaFolderSelectActivity paramMediaFolderSelectActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (MediaItemInfo)MediaFolderSelectActivity.access$200(this.this$0).get(paramInt);
    if ((List)MediaData.getBuckets().get(((MediaItemInfo)localObject).getBucketName()) != null)
    {
      localObject = MediaBucketGridActivity.createIntent(MediaFolderSelectActivity.access$300(this.this$0), ((MediaItemInfo)localObject).getBucketName(), MediaFolderSelectActivity.access$400(this.this$0), MediaFolderSelectActivity.access$500(this.this$0));
      this.this$0.startActivityForResult((Intent)localObject, 1);
      this.this$0.overridePendingTransition(2130772422, 2130772430);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaFolderSelectActivity.4
 * JD-Core Version:    0.7.0.1
 */