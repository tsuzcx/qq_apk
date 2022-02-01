package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import the;
import tkw;

final class GdtBannerViewWithOnePicture
  extends FrameLayout
  implements the
{
  private GdtBannerImageView b;
  private int imageHeight = -2147483648;
  private int imageWidth = -2147483648;
  
  public GdtBannerViewWithOnePicture(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      tkw.e("GdtBannerViewForCreativeSize193", "constructor");
      return;
    }
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    this.b = new GdtBannerImageView(paramContext, paramString);
    this.b.setId(2131367907);
    addView(this.b);
  }
  
  public void destroy(Context paramContext) {}
  
  public View getView()
  {
    return this;
  }
  
  public void pause(Context paramContext) {}
  
  public void resume(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.imageWidth <= 0) || (this.imageHeight <= 0) || (this.b == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      tkw.e("GdtBannerViewForCreativeSize193", "setSize error");
      return;
    }
    Object localObject = new GdtBannerViewWithLetterStyle.a(getContext(), paramInt1, paramInt2);
    paramInt2 = Double.valueOf(1.0D * (paramInt1 - ((GdtBannerViewWithLetterStyle.a)localObject).imageMargin * 2) / this.imageWidth * this.imageHeight + ((GdtBannerViewWithLetterStyle.a)localObject).imageMargin * 2).intValue();
    this.b.setPadding(((GdtBannerViewWithLetterStyle.a)localObject).imageMargin, ((GdtBannerViewWithLetterStyle.a)localObject).imageMargin, ((GdtBannerViewWithLetterStyle.a)localObject).imageMargin, ((GdtBannerViewWithLetterStyle.a)localObject).imageMargin);
    localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewWithOnePicture
 * JD-Core Version:    0.7.0.1
 */