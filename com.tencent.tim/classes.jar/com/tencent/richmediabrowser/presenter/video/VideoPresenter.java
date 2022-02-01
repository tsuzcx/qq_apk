package com.tencent.richmediabrowser.presenter.video;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.video.VideoView;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPresenter
  extends BrowserBasePresenter
{
  private static final String TAG = "VideoPresenter";
  public ConcurrentHashMap<Integer, URLDrawable> mActiveThumbDrawable = new ConcurrentHashMap();
  public VideoView videoView;
  
  public static Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void buildPresenter() {}
  
  public void dealVideoAutoPlay(String paramString, boolean paramBoolean) {}
  
  public void dealVideoMutePlay(String paramString, boolean paramBoolean) {}
  
  public boolean isAutoPlay(String paramString)
  {
    return false;
  }
  
  public boolean isMutePlay(String paramString)
  {
    return false;
  }
  
  public void loadShortVideoCover(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3) {}
  
  public void notifyProgress(String paramString, int paramInt)
  {
    super.notifyProgress(paramString, paramInt);
    if (this.videoView != null) {
      this.videoView.updateUI();
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    super.notifyResult(paramString, paramInt);
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoPresenter", 4, "notifyResult id = " + paramString + " ,resutlt = " + paramInt);
    if (this.videoView != null) {
      this.videoView.updateUI();
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof VideoView)) {
      this.videoView = ((VideoView)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.video.VideoPresenter
 * JD-Core Version:    0.7.0.1
 */