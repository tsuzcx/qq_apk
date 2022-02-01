package com.tencent.qqmail.activity.media;

import android.view.View;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class ImagePagerAdapter$5$3
  implements Runnable
{
  ImagePagerAdapter$5$3(ImagePagerAdapter.5 param5, Object paramObject, String paramString) {}
  
  public void run()
  {
    if ((this.val$error != null) && ((this.val$error instanceof QMCancelError))) {}
    while ((this.val$error == null) || (!(this.val$error instanceof String)) || (!((String)this.val$error).equals("downloading")))
    {
      if (this.this$1.val$layout.getParent() != null)
      {
        ImagePagerAdapter.TagData localTagData = (ImagePagerAdapter.TagData)this.this$1.val$layout.getTag();
        ImagePagerAdapter.access$700(this.this$1.this$0, localTagData.tvProgress);
        if (this.val$url.equals(localTagData.imageUrl))
        {
          localTagData.bitmap = null;
          localTagData.layout = this.this$1.val$layout;
          ImagePagerAdapter.access$900(this.this$1.this$0, localTagData);
          QMWatcherCenter.triggerLoadImageError(0, 0L, StringExtention.hashKeyForDisk(this.this$1.val$imageUrl), this.this$1.val$imageUrl, -1, "");
          if (ImagePagerAdapter.access$800(this.this$1.this$0) != null) {
            ImagePagerAdapter.access$800(this.this$1.this$0).handleDownError(this.val$url, "", -2);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.5.3
 * JD-Core Version:    0.7.0.1
 */