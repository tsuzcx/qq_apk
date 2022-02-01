package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.util.DataUtil;

public class AdLandingPageImagePure
  extends AdLandingPageBaseComp
{
  private ImageView imageView;
  private ProgressBar progressBar;
  private int screenHeight;
  private int screenWidth;
  private WindowManager wm;
  
  public AdLandingPageImagePure(Context paramContext, AdLandingPageComponentPureImageInfo paramAdLandingPageComponentPureImageInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentPureImageInfo, paramViewGroup);
  }
  
  public View createView()
  {
    this.imageView = ((ImageView)this.contentView.findViewById(2131378539));
    this.progressBar = ((ProgressBar)this.contentView.findViewById(2131373700));
    return this.contentView;
  }
  
  protected void fillItem()
  {
    this.wm = ((WindowManager)this.context.getSystemService("window"));
    this.screenWidth = this.wm.getDefaultDisplay().getWidth();
    this.screenHeight = this.wm.getDefaultDisplay().getHeight();
    float f1 = getInfo().paddingTop;
    f1 = getInfo().paddingBottom;
    f1 = getInfo().paddingLeft;
    float f2 = getInfo().paddingRight;
    String str = getInfo().imgUrl;
    float f3 = getInfo().height;
    float f4 = getInfo().width;
    if ((f3 != 0.0F) && (f4 != 0.0F) && (!getInfo().bFullScreen)) {
      this.imageView.setLayoutParams(new RelativeLayout.LayoutParams(this.screenWidth - (int)f1 - (int)f2, (this.screenWidth - (int)f1 - (int)f2) * (int)f3 / (int)f4));
    }
    for (;;)
    {
      Bitmap localBitmap = AdLandingPagesDownloadResourceHelper.getCachedImg(str);
      if (localBitmap == null) {
        break;
      }
      setImageView(localBitmap);
      return;
      if ((getInfo().bFullScreen) && (f3 != 0.0F) && (f4 != 0.0F)) {
        this.imageView.setLayoutParams(new RelativeLayout.LayoutParams(this.screenWidth, this.screenHeight));
      } else {
        this.imageView.setLayoutParams(new RelativeLayout.LayoutParams(this.screenWidth, this.screenHeight));
      }
    }
    startLoading();
    AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages(str, new AdLandingPageImagePure.1(this));
  }
  
  public AdLandingPageComponentPureImageInfo getInfo()
  {
    return (AdLandingPageComponentPureImageInfo)this.adLandingPageComponentInfo;
  }
  
  protected int getLayout()
  {
    return 2131563097;
  }
  
  public void setImageView(Bitmap paramBitmap)
  {
    this.progressBar.setVisibility(8);
    this.imageView.setImageBitmap(paramBitmap);
    if (getInfo().bFullScreen) {
      this.imageView.setLayoutParams(new RelativeLayout.LayoutParams(this.screenWidth, this.screenWidth * paramBitmap.getHeight() / paramBitmap.getWidth()));
    }
  }
  
  public void startLoading()
  {
    this.progressBar.setVisibility(0);
  }
  
  public void stopLoading()
  {
    this.progressBar.setVisibility(8);
  }
  
  public void viewWillAppear()
  {
    super.viewWillAppear();
    if (this.appearFlag) {
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Pure_Show_Count", 1L);
    }
    this.appearFlag = false;
  }
  
  public void viewWillDisappear()
  {
    super.viewWillDisappear();
    if (!this.appearFlag)
    {
      long l = getStayTime();
      DataUtil.collect(getInfo().cId, "Event_Native_AD_Component_Pure_Show_Time", l);
    }
    this.appearFlag = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageImagePure
 * JD-Core Version:    0.7.0.1
 */