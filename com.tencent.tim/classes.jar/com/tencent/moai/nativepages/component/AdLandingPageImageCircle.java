package com.tencent.moai.nativepages.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper;
import com.tencent.moai.nativepages.model.AdLandingPageComponentPureImageInfo;
import com.tencent.moai.nativepages.view.CircularImageView;

public class AdLandingPageImageCircle
  extends AdLandingPageBaseComp
{
  private CircularImageView img;
  
  public AdLandingPageImageCircle(Context paramContext, AdLandingPageComponentPureImageInfo paramAdLandingPageComponentPureImageInfo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramAdLandingPageComponentPureImageInfo, paramViewGroup);
  }
  
  public View createView()
  {
    this.img = ((CircularImageView)this.contentView);
    return this.contentView;
  }
  
  protected View customLayout()
  {
    return new CircularImageView(this.context);
  }
  
  protected void fillItem()
  {
    AdLandingPageComponentPureImageInfo localAdLandingPageComponentPureImageInfo = getInfo();
    Bitmap localBitmap = AdLandingPagesDownloadResourceHelper.getCachedImg(localAdLandingPageComponentPureImageInfo.imgUrl);
    if (localBitmap != null)
    {
      setImageView(localBitmap);
      return;
    }
    AdLandingPagesDownloadResourceHelper.downloadImgForAdLandingPages(localAdLandingPageComponentPureImageInfo.imgUrl, new AdLandingPageImageCircle.1(this));
  }
  
  public AdLandingPageComponentPureImageInfo getInfo()
  {
    return (AdLandingPageComponentPureImageInfo)this.adLandingPageComponentInfo;
  }
  
  public void setImageView(Bitmap paramBitmap)
  {
    this.img.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageImageCircle
 * JD-Core Version:    0.7.0.1
 */