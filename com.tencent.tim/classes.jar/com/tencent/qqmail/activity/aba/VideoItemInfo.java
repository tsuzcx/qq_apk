package com.tencent.qqmail.activity.aba;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Video.Thumbnails;
import android.widget.ImageView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader.QMImageLoaderCallback;

public class VideoItemInfo
  implements interfaceMediaClass, Cloneable
{
  private static final String TAG = "VideoItemInfo";
  public int accountId;
  public Attach attach;
  public String dataPath;
  public String fileName;
  public long fileSize;
  public int id;
  public long mailId;
  public String sourcePath;
  public Bitmap thumbnail;
  
  private Bitmap loadThumbnail(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    Bitmap localBitmap;
    for (int i = 3;; i = 1)
    {
      localBitmap = MediaStore.Video.Thumbnails.getThumbnail(QMApplicationContext.sharedInstance().getContentResolver(), this.id, i, null);
      if ((!paramBoolean2) || (localBitmap != null)) {
        break;
      }
      localBitmap = ThumbnailUtils.createVideoThumbnail(this.dataPath, i);
      i = DeviceUtil.dip2px(64.0F);
      return ThumbnailUtils.extractThumbnail(localBitmap, i, i, 2);
    }
    return localBitmap;
  }
  
  protected Object clone()
    throws RuntimeException
  {
    VideoItemInfo localVideoItemInfo = new VideoItemInfo();
    localVideoItemInfo.mailId = this.mailId;
    localVideoItemInfo.id = this.id;
    localVideoItemInfo.accountId = this.accountId;
    localVideoItemInfo.thumbnail = null;
    localVideoItemInfo.dataPath = this.dataPath;
    localVideoItemInfo.sourcePath = this.sourcePath;
    localVideoItemInfo.fileName = this.fileName;
    localVideoItemInfo.fileSize = this.fileSize;
    return localVideoItemInfo;
  }
  
  public Bitmap getThumbnail()
  {
    if (this.thumbnail == null) {}
    try
    {
      this.thumbnail = loadThumbnail(true, false);
      return this.thumbnail;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
      }
    }
  }
  
  public Bitmap getThumbnail(boolean paramBoolean)
  {
    if (this.thumbnail == null) {}
    try
    {
      this.thumbnail = loadThumbnail(true, paramBoolean);
      return this.thumbnail;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
      }
    }
  }
  
  public void loadPreviewThumbnail(ImageView paramImageView, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = this.dataPath;
    Object localObject = null;
    if (paramBoolean1) {
      localObject = new VideoItemInfo.1(this, paramBoolean2, paramImageView);
    }
    paramImageView.setId(this.id);
    localObject = QMImageLoader.getInstance().loadImage(str, (QMImageLoader.QMImageLoaderCallback)localObject);
    if (localObject != null)
    {
      paramImageView.setImageBitmap((Bitmap)localObject);
      return;
    }
    paramImageView.setImageResource(2130841141);
  }
  
  public void setThumbnail(Bitmap paramBitmap)
  {
    this.thumbnail = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.VideoItemInfo
 * JD-Core Version:    0.7.0.1
 */