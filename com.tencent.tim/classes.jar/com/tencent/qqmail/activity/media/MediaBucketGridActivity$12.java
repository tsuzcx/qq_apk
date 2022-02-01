package com.tencent.qqmail.activity.media;

import moai.core.watcher.Watchers;

class MediaBucketGridActivity$12
  implements Runnable
{
  MediaBucketGridActivity$12(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void run()
  {
    MediaBucketGridActivity.access$2300(this.this$0);
    if (MediaBucketGridActivity.access$800(this.this$0) == 1) {
      MediaData.loadImageData(this.this$0, true);
    }
    for (;;)
    {
      MediaData.sortAllBuckets();
      ((MediaFolderSelectActivity.MediaFolderWatcher)Watchers.of(MediaFolderSelectActivity.MediaFolderWatcher.class)).onDataLoad();
      MediaBucketGridActivity.access$2500(this.this$0, new MediaBucketGridActivity.12.1(this));
      return;
      if (MediaBucketGridActivity.access$800(this.this$0) == 2) {
        MediaData.loadImageAndVideo(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.12
 * JD-Core Version:    0.7.0.1
 */