package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAd;
import tgg;
import the;
import tkw;

public final class GdtBannerViewWithLetterStyle
  extends FrameLayout
  implements the
{
  the c;
  
  public GdtBannerViewWithLetterStyle(Context paramContext, GdtAd paramGdtAd)
  {
    super(paramContext);
    if ((paramContext == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      tkw.e("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    setBackgroundResource(2130840580);
    int k = -2147483648;
    int m = -2147483648;
    int i;
    int j;
    if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184) || (paramGdtAd.getCreativeSize() == 193) || (paramGdtAd.getCreativeSize() == 194) || (paramGdtAd.getCreativeSize() == 210))
    {
      i = k;
      j = m;
      if (paramGdtAd.getImageData() != null)
      {
        i = paramGdtAd.getImageData().width;
        j = paramGdtAd.getImageData().height;
      }
      if ((i > 0) && (j > 0)) {
        break label248;
      }
      tkw.e("GdtBannerViewWithLetterStyle", "createBannerViewWithLetterStyle error, image width or image height is zero");
    }
    for (;;)
    {
      paramContext = new ImageView(getContext());
      paramContext.setImageResource(2130840581);
      addView(paramContext, -1, -1);
      return;
      i = k;
      j = m;
      if (paramGdtAd.getCreativeSize() != 285) {
        break;
      }
      i = k;
      j = m;
      if (paramGdtAd.getImageData(0) == null) {
        break;
      }
      i = k;
      j = m;
      if (paramGdtAd.getImageData(1) == null) {
        break;
      }
      i = k;
      j = m;
      if (paramGdtAd.getImageData(2) == null) {
        break;
      }
      i = paramGdtAd.getImageData(0).width;
      j = paramGdtAd.getImageData(0).height;
      break;
      label248:
      if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184) || (paramGdtAd.getCreativeSize() == 210)) {
        this.c = new GdtBannerViewWithOnePicturePlusOneText(paramContext, paramGdtAd.getImageData().url, i, j, paramGdtAd.getText());
      }
      for (;;)
      {
        addView(this.c.getView());
        break;
        if (paramGdtAd.getCreativeSize() == 193)
        {
          this.c = new GdtBannerViewWithOnePicture(paramContext, paramGdtAd.getImageData().url, i, j);
        }
        else if (paramGdtAd.getCreativeSize() == 194)
        {
          this.c = new GdtBannerViewWithOnePicturePlusTwoTexts(paramContext, paramGdtAd.getImageData().url, i, j, paramGdtAd.getText(), paramGdtAd.getDescription());
        }
        else
        {
          if (paramGdtAd.getCreativeSize() != 285) {
            break label453;
          }
          this.c = new GdtBannerViewWithThreePicturesPlusOneText(paramContext, paramGdtAd.getImageData(0).url, paramGdtAd.getImageData(1).url, paramGdtAd.getImageData(2).url, i, j, paramGdtAd.getText());
        }
      }
      label453:
      tkw.e("GdtBannerViewWithLetterStyle", String.format("createBannerView error, creative size is %d", new Object[] { Integer.valueOf(paramGdtAd.getCreativeSize()) }));
    }
  }
  
  public void destroy(Context paramContext)
  {
    if (this.c == null) {
      return;
    }
    this.c.destroy(paramContext);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void pause(Context paramContext)
  {
    if (this.c == null) {
      return;
    }
    this.c.pause(paramContext);
  }
  
  public void resume(Context paramContext)
  {
    if (this.c == null) {
      return;
    }
    this.c.resume(paramContext);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.c == null) || (this.c.getView() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      tkw.e("GdtBannerViewWithLetterStyle", "setSize error");
      return;
    }
    int i = Double.valueOf(0.7076023391812866D * paramInt1).intValue();
    int j = Double.valueOf(0.9036144578313253D * paramInt2).intValue();
    paramInt1 = Double.valueOf((paramInt1 - i) * 1.0D / 2.0D).intValue();
    paramInt2 = Double.valueOf((paramInt2 - j) * 1.0D / 2.0D).intValue();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.bottomMargin = paramInt2;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt1;
    this.c.getView().setLayoutParams(localLayoutParams);
    this.c.setSize(i, j);
  }
  
  static final class a
  {
    public int bBn = -2147483648;
    public int bBo = -2147483648;
    public int imageMargin = -2147483648;
    public int textSize = -2147483648;
    
    public a(Context paramContext, int paramInt1, int paramInt2)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        tkw.e("GdtBannerViewWithLetterStyle", "constructor");
        return;
      }
      this.bBn = Double.valueOf(0.02892561983471075D * paramInt1).intValue();
      this.imageMargin = Double.valueOf(0.02666666666666667D * paramInt2).intValue();
      this.bBo = Double.valueOf(0.06666666666666667D * paramInt2).intValue();
      this.textSize = Double.valueOf(0.16D * paramInt2).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewWithLetterStyle
 * JD-Core Version:    0.7.0.1
 */