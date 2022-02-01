package com.tencent.qqmail.activity.media;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;

class ImagePagerAdapter$5$2
  implements Runnable
{
  ImagePagerAdapter$5$2(ImagePagerAdapter.5 param5, File paramFile, String paramString1, String paramString2) {}
  
  public void run()
  {
    Bitmap localBitmap = ImageUtil.memSafeScaleImage(this.val$file.getAbsolutePath(), 1, 1.0F);
    if (this.this$1.val$layout.getParent() != null)
    {
      ImagePagerAdapter.TagData localTagData = (ImagePagerAdapter.TagData)this.this$1.val$layout.getTag();
      if ((localTagData != null) && (this.val$url.equals(localTagData.imageUrl)))
      {
        localTagData.bitmap = localBitmap;
        localTagData.layout = this.this$1.val$layout;
        String str = this.val$file.getAbsolutePath();
        this.this$1.val$finalInfo.setSourcePath(str);
        if (this.this$1.val$finalInfo.getAttach() != null) {
          this.this$1.val$finalInfo.getAttach().getPreview().setMyDisk(str);
        }
        ImagePagerAdapter.access$600(this.this$1.this$0, localTagData, this.this$1.val$finalInfo);
        ImagePagerAdapter.access$700(this.this$1.this$0, localTagData.tvProgress);
        QMWatcherCenter.triggerLoadImageSuccess(0, 0L, StringExtention.hashKeyForDisk(this.this$1.val$imageUrl), this.this$1.val$imageUrl, str, localBitmap, false);
        if (ImagePagerAdapter.access$800(this.this$1.this$0) != null) {
          ImagePagerAdapter.access$800(this.this$1.this$0).handleDownSuccess(this.val$url, this.this$1.val$finalAttachId, this.val$copyPath);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.5.2
 * JD-Core Version:    0.7.0.1
 */