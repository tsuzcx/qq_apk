package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;

public class VideoPreviewPresent
  extends BasePreviewPresent
  implements VideoPlayerCallback
{
  private static final String TAG = "VideoPreviewPresent";
  private static final long id = 1000L;
  private ImageView mCenterPlayBtn;
  private ImageView mCover;
  private FrameLayout mVideoLayout;
  private BaseVideoView mVideoView;
  
  public VideoPreviewPresent(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  private void initVideoView(Context paramContext)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mVideoPath = this.mBean.getPath();
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mCallback = this;
    this.mVideoView = generateVideoView(paramContext, 1000L, localVideoPlayParam, null);
    this.mVideoView.setVideoParam(localVideoPlayParam);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.mVideoView.setLayoutParams(paramContext);
    this.mVideoView.setVisibility(0);
    this.mVideoLayout.addView(this.mVideoView);
  }
  
  private void updatePlayStateView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mCenterPlayBtn.setVisibility(8);
      return;
    }
    this.mCenterPlayBtn.setVisibility(0);
  }
  
  private void updateState(boolean paramBoolean)
  {
    if (this.mVideoView != null)
    {
      boolean bool = this.mVideoView.isPlaying();
      if (bool != paramBoolean)
      {
        if (!bool) {
          break label37;
        }
        this.mVideoView.pause();
      }
    }
    for (;;)
    {
      updatePlayStateView(paramBoolean);
      return;
      label37:
      this.mVideoView.play();
    }
  }
  
  protected BaseVideoView generateVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return (BaseVideoView)VideoViewFactory.createBaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public Drawable getCoverDrawable(String paramString, int paramInt1, int paramInt2, LocalMediaInfo paramLocalMediaInfo)
  {
    VideoPreviewPresent.1 local1 = new VideoPreviewPresent.1(this, Color.rgb(214, 214, 214), paramInt2, paramInt1);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, local1, local1);
        localURLDrawable.setTag(paramLocalMediaInfo);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception paramLocalMediaInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoPreviewPresent", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, paramLocalMediaInfo);
        }
      }
    }
    return local1;
  }
  
  protected URL getFileUrl(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return QAlbumUtil.generateAlbumVideoThumbURL(paramFile.getPath(), "VIDEO");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup.getContext();
    paramView = ((LayoutInflater)((Context)localObject).getSystemService("layout_inflater")).inflate(2131561544, null);
    paramView.setTag(2131296400, Boolean.valueOf(true));
    paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    this.mCover = ((ImageView)paramView.findViewById(2131373580));
    this.mCenterPlayBtn = ((ImageView)paramView.findViewById(2131373579));
    this.mVideoLayout = ((FrameLayout)paramView.findViewById(2131373582));
    initVideoView((Context)localObject);
    localObject = this.mBean.getMediaInfo();
    int i = paramViewGroup.getWidth();
    paramInt = paramViewGroup.getHeight();
    if (((LocalMediaInfo)localObject).mediaWidth > ((LocalMediaInfo)localObject).mediaHeight)
    {
      i = paramViewGroup.getHeight();
      paramInt = paramViewGroup.getWidth();
    }
    paramViewGroup = QAlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject, "FLOW_THUMB");
    if (paramViewGroup != null)
    {
      paramViewGroup = getCoverDrawable(paramViewGroup.toString(), i, paramInt, (LocalMediaInfo)localObject);
      this.mCover.setImageDrawable(paramViewGroup);
      return paramView;
    }
    QLog.d("VideoPreviewPresent", 2, "url  is null ");
    return paramView;
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
  }
  
  public void onDestroyView()
  {
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
  }
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    this.mCover.post(new VideoPreviewPresent.3(this));
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mVideoView != null)
    {
      if (this.mVideoView.isPlaying()) {
        updateState(false);
      }
    }
    else {
      return;
    }
    updateState(true);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPause()
  {
    updateState(false);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoPreviewPresent", 2, "onStateChange , state = " + paramInt);
    }
    if (paramInt == 4) {}
    while (paramInt != 8) {
      return;
    }
    updatePlayStateView(false);
    this.mCover.post(new VideoPreviewPresent.2(this));
  }
  
  public void onViewDetached()
  {
    updateState(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.VideoPreviewPresent
 * JD-Core Version:    0.7.0.1
 */