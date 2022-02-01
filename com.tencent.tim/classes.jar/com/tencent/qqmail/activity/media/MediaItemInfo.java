package com.tencent.qqmail.activity.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.aba.interfaceMediaClass;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader.QMImageLoaderCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class MediaItemInfo
  implements interfaceMediaClass, Cloneable
{
  public static final int ARG_DOWN_DEFAULT = 1;
  public static final int ARG_DOWN_PROTOCOL = 4;
  public static final int ARG_DOWN_QQFTN = 3;
  public static final int ARG_DOWN_QQNORMAL = 2;
  private static final String TAG = "MediaItemInfo";
  private int accountId;
  private Attach attach;
  private String bucketName;
  private String dataPath;
  private String fileName;
  private long fileSize;
  private int id;
  private int imageType = 1;
  private boolean isVideo = false;
  private long mailId;
  private long modifyDate;
  private String oriDataPath;
  private String orientation;
  private String sourcePath;
  private Bitmap thumbnail;
  
  private Bitmap loadThumbnail(boolean paramBoolean)
  {
    try
    {
      Object localObject1;
      if (isVideo()) {
        localObject1 = MediaStore.Video.Thumbnails.getThumbnail(QMApplicationContext.sharedInstance().getContentResolver(), this.id, 1, null);
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (paramBoolean)
        {
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject1).inSampleSize = 4;
            localObject1 = BitmapFactory.decodeFile(this.dataPath, (BitmapFactory.Options)localObject1);
            int i = DeviceUtil.dip2px(64.0F);
            localObject3 = ImageUtil.createThumbnailImage((Bitmap)localObject1, i, i);
          }
        }
        return localObject3;
        if (TextUtils.isEmpty(getOriDataPath())) {
          localObject1 = MediaStore.Images.Thumbnails.getThumbnail(QMApplicationContext.sharedInstance().getContentResolver(), this.id, 1, null);
        } else {
          localObject1 = ImageUtil.memSafeScaleImage(getDataPath(), 1, 1.0F);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "MediaItemInfo", "loadThumbnail failed: " + localException.toString());
        Object localObject2 = null;
      }
    }
  }
  
  protected Object clone()
    throws RuntimeException
  {
    MediaItemInfo localMediaItemInfo = new MediaItemInfo();
    localMediaItemInfo.mailId = this.mailId;
    localMediaItemInfo.id = this.id;
    localMediaItemInfo.accountId = this.accountId;
    localMediaItemInfo.thumbnail = null;
    localMediaItemInfo.dataPath = this.dataPath;
    localMediaItemInfo.sourcePath = this.sourcePath;
    localMediaItemInfo.fileName = this.fileName;
    localMediaItemInfo.bucketName = this.bucketName;
    localMediaItemInfo.fileSize = this.fileSize;
    localMediaItemInfo.orientation = this.orientation;
    localMediaItemInfo.oriDataPath = this.oriDataPath;
    return localMediaItemInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof MediaItemInfo))) {}
    do
    {
      return false;
      paramObject = (MediaItemInfo)paramObject;
    } while ((!StringExtention.isNotNullAndEqual(paramObject.getDataPath(), getDataPath())) && (!StringExtention.isNotNullAndEqual(paramObject.getDataPath(), getOriDataPath())) && (!StringExtention.isNotNullAndEqual(paramObject.getOriDataPath(), getDataPath())));
    return true;
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public Attach getAttach()
  {
    return this.attach;
  }
  
  public String getBucketName()
  {
    return this.bucketName;
  }
  
  public String getDataPath()
  {
    return this.dataPath;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getImageType()
  {
    return this.imageType;
  }
  
  public long getMailId()
  {
    return this.mailId;
  }
  
  public long getModifyDate()
  {
    return this.modifyDate;
  }
  
  public String getOriDataPath()
  {
    return this.oriDataPath;
  }
  
  public String getOrientation()
  {
    return this.orientation;
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public Bitmap getThumbnail()
  {
    if (this.thumbnail == null) {}
    try
    {
      this.thumbnail = loadThumbnail(false);
      label16:
      return this.thumbnail;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
      }
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  public Bitmap getThumbnail(boolean paramBoolean)
  {
    if (this.thumbnail == null) {}
    try
    {
      this.thumbnail = loadThumbnail(paramBoolean);
      label16:
      return this.thumbnail;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        System.gc();
      }
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  public boolean isVideo()
  {
    return this.isVideo;
  }
  
  public void loadPreviewThumbnail(ImageView paramImageView, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = this.dataPath;
    Object localObject = null;
    if (paramBoolean1) {
      localObject = new MediaItemInfo.1(this, paramImageView);
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
  
  public void setAccountId(int paramInt)
  {
    this.accountId = paramInt;
  }
  
  public void setAttach(Attach paramAttach)
  {
    this.attach = paramAttach;
  }
  
  public void setBucketName(String paramString)
  {
    this.bucketName = paramString;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setImageType(int paramInt)
  {
    this.imageType = paramInt;
  }
  
  public void setIsVideo(boolean paramBoolean)
  {
    this.isVideo = paramBoolean;
  }
  
  public void setMailId(long paramLong)
  {
    this.mailId = paramLong;
  }
  
  public void setModifyDate(long paramLong)
  {
    this.modifyDate = paramLong;
  }
  
  public void setOriDataPath(String paramString)
  {
    this.oriDataPath = paramString;
  }
  
  public void setOrientation(String paramString)
  {
    this.orientation = paramString;
  }
  
  public void setSourcePath(String paramString)
  {
    this.sourcePath = paramString;
  }
  
  public void setThumbnail(Bitmap paramBitmap)
  {
    this.thumbnail = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaItemInfo
 * JD-Core Version:    0.7.0.1
 */