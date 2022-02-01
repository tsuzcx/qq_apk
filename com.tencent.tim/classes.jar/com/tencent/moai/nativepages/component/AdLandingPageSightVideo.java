package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentSightVideoInfo;
import com.tencent.moai.nativepages.util.FileUtil;
import com.tencent.moai.nativepages.view.VideoView;

public class AdLandingPageSightVideo
  extends AdLandingPageBaseComp
  implements ALLandingAutoPlay
{
  private static final int AUTO_HANDLE_DO_NOTING = 0;
  private static final int AUTO_HANDLE_PAUSE = 2;
  private static final int AUTO_HANDLE_START = 1;
  private static final int USER_HANDLE_PAUSE = 4;
  private static final int USER_HANDLE_START = 3;
  private ALLandingAutoPlayListener autoPlayListener;
  private boolean bNoVoice = true;
  private TextView errorTv;
  private int handleType = 0;
  private boolean hasStopByFirst = false;
  private int inScreenHeight = 0;
  private int index;
  private boolean isAutoPlaying = false;
  private boolean isFirstTimeCallBackAppeared = true;
  private boolean isNativeAdMode = false;
  private boolean isUserHandleVoice = false;
  private boolean lastCallBackIsOverHalfScreen = false;
  private ProgressBar progressBar;
  private VideoView videoView;
  private int viewHeight = 0;
  
  public AdLandingPageSightVideo(Context paramContext, AdLandingPageComponentSightVideoInfo paramAdLandingPageComponentSightVideoInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentSightVideoInfo, paramViewGroup);
  }
  
  private void closeVoice()
  {
    this.videoView.soundOn(false);
    this.bNoVoice = true;
  }
  
  private void openVoice()
  {
    this.videoView.soundOn(true);
    this.bNoVoice = false;
  }
  
  private void pausePlay()
  {
    if (!this.videoView.isPlaying()) {
      return;
    }
    this.videoView.pause();
  }
  
  private void startDownloadAndPlayVideo()
  {
    if (FileUtil.fileExists(AdLandingPagesDownloadResourceHelper.getPathForVideo(getInfo().sightVideoUrl))) {
      return;
    }
    AdLandingPagesDownloadResourceHelper.downloadSightForAdLandingPages(getInfo().sightVideoUrl, new AdLandingPageSightVideo.1(this));
  }
  
  private void startPlay()
  {
    if (this.videoView.isPlaying()) {
      return;
    }
    Object localObject = AdLandingPagesDownloadResourceHelper.getPathForVideo(getInfo().sightVideoUrl);
    if (FileUtil.fileExists((String)localObject))
    {
      this.videoView.play((String)localObject);
      localObject = this.videoView;
      if (this.bNoVoice) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      ((VideoView)localObject).soundOn(bool);
      return;
      this.videoView.play(getInfo().sightVideoUrl);
      break;
    }
  }
  
  public View createView()
  {
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int i = ((WindowManager)localObject1).getDefaultDisplay().getWidth();
    int k = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    localObject1 = this.contentView;
    ViewGroup localViewGroup = (ViewGroup)((View)localObject1).findViewById(2131378537);
    int j;
    if (getInfo().sightVideoDisplayType == 0) {
      if ((int)getInfo().width > 0)
      {
        j = (int)getInfo().height * i / (int)getInfo().width;
        if (j <= k) {
          break label401;
        }
        j = k;
        if ((int)getInfo().height > 0)
        {
          i = (int)getInfo().width * k / (int)getInfo().height;
          j = k;
        }
      }
    }
    label401:
    for (;;)
    {
      Object localObject2 = new RelativeLayout.LayoutParams(i, j);
      localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((View)localObject1).setPadding((int)getInfo().paddingLeft, (int)getInfo().paddingTop, (int)getInfo().paddingRight, (int)getInfo().paddingBottom);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      for (;;)
      {
        this.errorTv = ((TextView)((View)localObject1).findViewById(2131366500));
        this.errorTv.setText(this.context.getString(2131692941));
        this.progressBar = ((ProgressBar)((View)localObject1).findViewById(2131373700));
        this.progressBar.setVisibility(8);
        this.videoView = new VideoView(this.context);
        this.videoView.hideControlArea();
        localObject2 = new LinearLayout.LayoutParams(-1, -1);
        localViewGroup.addView(this.videoView, 0, (ViewGroup.LayoutParams)localObject2);
        startDownloadAndPlayVideo();
        this.contentView = ((View)localObject1);
        return localObject1;
        localObject2 = new RelativeLayout.LayoutParams(i, k);
        localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        continue;
        localObject2 = new RelativeLayout.LayoutParams(i, k);
        localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setPadding((int)getInfo().paddingLeft, (int)getInfo().paddingTop, (int)getInfo().paddingRight, (int)getInfo().paddingBottom);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  protected void fillItem() {}
  
  public int getIndex()
  {
    return this.index;
  }
  
  public AdLandingPageComponentSightVideoInfo getInfo()
  {
    return (AdLandingPageComponentSightVideoInfo)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563099;
  }
  
  public boolean isAutoPlaying()
  {
    return this.isAutoPlaying;
  }
  
  public boolean isNativeAdMode()
  {
    return this.isNativeAdMode;
  }
  
  public void setALLandingAutoPlayListener(ALLandingAutoPlayListener paramALLandingAutoPlayListener, int paramInt, boolean paramBoolean)
  {
    this.autoPlayListener = paramALLandingAutoPlayListener;
    this.index = paramInt;
    this.isNativeAdMode = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bNoVoice = paramBoolean;
      return;
    }
  }
  
  public void setSilence(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.hasStopByFirst) {
        return;
      }
      this.hasStopByFirst = true;
    }
    closeVoice();
    this.isUserHandleVoice = true;
    this.isAutoPlaying = false;
  }
  
  public void viewAppeared(int paramInt1, int paramInt2, int paramInt3)
  {
    super.viewAppeared(paramInt1, paramInt2, paramInt3);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.inScreenHeight = paramInt1;
              this.viewHeight = paramInt2;
            } while (paramInt1 < 0);
            if (paramInt1 < 0.5F * paramInt2) {
              break;
            }
          } while ((this.lastCallBackIsOverHalfScreen) && (!this.isFirstTimeCallBackAppeared));
          this.isAutoPlaying = false;
          this.isFirstTimeCallBackAppeared = false;
          this.lastCallBackIsOverHalfScreen = true;
          if (this.handleType == 0)
          {
            if (!this.isUserHandleVoice) {
              if (this.isNativeAdMode)
              {
                openVoice();
                this.isAutoPlaying = true;
                this.autoPlayListener.onAutoPlay(this, false);
              }
            }
            for (;;)
            {
              this.handleType = 1;
              startPlay();
              return;
              closeVoice();
              continue;
              if (this.bNoVoice)
              {
                closeVoice();
              }
              else
              {
                openVoice();
                this.isAutoPlaying = true;
                this.autoPlayListener.onAutoPlay(this, false);
              }
            }
          }
          if (this.handleType == 1)
          {
            if (!this.isUserHandleVoice) {
              if (this.isNativeAdMode)
              {
                openVoice();
                this.isAutoPlaying = true;
                this.autoPlayListener.onAutoPlay(this, false);
              }
            }
            for (;;)
            {
              this.handleType = 1;
              startPlay();
              return;
              closeVoice();
              continue;
              if (this.bNoVoice)
              {
                closeVoice();
              }
              else
              {
                openVoice();
                this.isAutoPlaying = true;
                this.autoPlayListener.onAutoPlay(this, false);
              }
            }
          }
          if (this.handleType == 2)
          {
            if (!this.isUserHandleVoice) {
              if (this.isNativeAdMode)
              {
                openVoice();
                this.isAutoPlaying = true;
                this.autoPlayListener.onAutoPlay(this, false);
              }
            }
            for (;;)
            {
              this.handleType = 1;
              startPlay();
              return;
              closeVoice();
              continue;
              if (this.bNoVoice)
              {
                closeVoice();
              }
              else
              {
                openVoice();
                this.isAutoPlaying = true;
                this.autoPlayListener.onAutoPlay(this, false);
              }
            }
          }
        } while (this.handleType != 3);
        if (!this.isUserHandleVoice) {
          if (this.isNativeAdMode)
          {
            openVoice();
            this.isAutoPlaying = true;
            this.autoPlayListener.onAutoPlay(this, false);
          }
        }
        for (;;)
        {
          startPlay();
          return;
          closeVoice();
          continue;
          if (this.bNoVoice)
          {
            closeVoice();
          }
          else
          {
            openVoice();
            this.isAutoPlaying = true;
            this.autoPlayListener.onAutoPlay(this, false);
          }
        }
        this.isAutoPlaying = false;
      } while ((!this.lastCallBackIsOverHalfScreen) && (!this.isFirstTimeCallBackAppeared));
      this.isFirstTimeCallBackAppeared = false;
      this.lastCallBackIsOverHalfScreen = false;
      pausePlay();
      if (this.handleType == 1) {
        this.handleType = 2;
      }
    } while (this.handleType != 3);
    this.handleType = 4;
  }
  
  public void viewWillDestroy()
  {
    super.viewWillDestroy();
    this.videoView.stop();
  }
  
  public void viewWillDisappear()
  {
    super.viewWillDisappear();
    pausePlay();
    this.isAutoPlaying = false;
    if ((!this.lastCallBackIsOverHalfScreen) && (!this.isFirstTimeCallBackAppeared)) {}
    do
    {
      return;
      this.isFirstTimeCallBackAppeared = false;
      this.lastCallBackIsOverHalfScreen = false;
      if (this.handleType == 1) {
        this.handleType = 2;
      }
    } while (this.handleType != 3);
    this.handleType = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageSightVideo
 * JD-Core Version:    0.7.0.1
 */