package com.tencent.qqmail.attachment.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qqmail.attachment.util.AttachFolderHelper;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

public class AttachFolderThumbListener
  implements ImageDownloadListener
{
  private int mAccountId;
  private Context mContext;
  private int mPosition;
  private String mTag;
  private ImageView mThumbImage;
  private UpdateTime mUpdateTime;
  private View mView;
  
  public AttachFolderThumbListener(String paramString, Context paramContext, int paramInt1, View paramView, ImageView paramImageView, int paramInt2, UpdateTime paramUpdateTime)
  {
    this.mAccountId = paramInt1;
    this.mView = paramView;
    this.mThumbImage = paramImageView;
    this.mPosition = paramInt2;
    this.mTag = paramString;
    this.mContext = paramContext;
    this.mUpdateTime = paramUpdateTime;
  }
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if ((this.mUpdateTime != null) && (this.mUpdateTime.needRefreshImage(this.mView, this.mPosition))) {
      AttachFolderHelper.setDefaultThumbByType(this.mThumbImage, "image");
    }
    if ((paramObject != null) && ((paramObject instanceof QMNetworkError)))
    {
      paramString = (QMNetworkError)paramObject;
      if ((paramString.code == 302) && (!StringUtils.isEmpty(paramString.url)))
      {
        QMLog.log(5, this.mTag, "get thumb error 302 url: " + paramString.url);
        paramObject = new DownloadInfo();
        paramObject.setAccountId(this.mAccountId);
        paramObject.setUrl(paramString.url);
        paramObject.setImageDownloadListener(this);
        ImageDownloadManager.shareInstance().fetchImage(paramObject);
      }
    }
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString2 = ImageDownloadManager.shareInstance().getThumbBitmapFromDiskCache(paramString1);
    if ((paramString2 != null) && (paramString2.length() > 35000L)) {
      if ((paramString2 != null) && (paramString2.exists())) {
        ImageCompresser.getInstance().compressImage(paramString1, paramString2.getAbsolutePath(), paramString2.getAbsolutePath(), 3, new AttachFolderThumbListener.1(this, paramString2));
      }
    }
    do
    {
      do
      {
        return;
        QMLog.log(5, this.mTag, "get thumb success in main thread bitmap: " + paramBitmap);
      } while ((paramBitmap == null) || (this.mUpdateTime == null) || (!this.mUpdateTime.needRefreshImage(this.mView, this.mPosition)));
      QMLog.log(4, this.mTag, "get thumb success url: " + paramString1);
    } while (this.mContext == null);
    paramString1 = new BitmapDrawable(this.mContext.getResources(), paramBitmap);
    this.mThumbImage.setImageDrawable(paramString1);
  }
  
  public static abstract interface UpdateTime
  {
    public abstract boolean needRefreshImage(View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.view.AttachFolderThumbListener
 * JD-Core Version:    0.7.0.1
 */