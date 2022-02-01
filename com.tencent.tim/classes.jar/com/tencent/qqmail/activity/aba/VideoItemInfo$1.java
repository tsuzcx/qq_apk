package com.tencent.qqmail.activity.aba;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader.QMImageLoaderCallback;
import com.tencent.qqmail.utilities.imageextention.QMImageLoaderTask;

class VideoItemInfo$1
  implements QMImageLoader.QMImageLoaderCallback
{
  VideoItemInfo$1(VideoItemInfo paramVideoItemInfo, boolean paramBoolean, ImageView paramImageView) {}
  
  public void handleFinishLoadingImage(QMImageLoaderTask paramQMImageLoaderTask)
  {
    if ((paramQMImageLoaderTask.result != null) && (this.val$imageView.getId() == this.this$0.id)) {
      this.val$imageView.setImageBitmap(paramQMImageLoaderTask.result);
    }
  }
  
  public void loadImageInBackground(QMImageLoaderTask paramQMImageLoaderTask)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = VideoItemInfo.access$000(this.this$0, this.val$useSmallestSize, true);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        paramQMImageLoaderTask.isOOME = true;
      }
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    paramQMImageLoaderTask.result = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.VideoItemInfo.1
 * JD-Core Version:    0.7.0.1
 */