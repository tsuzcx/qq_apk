package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import the;
import tkw;

final class GdtBannerViewWithOnePicturePlusOneText
  extends LinearLayout
  implements the
{
  private GdtBannerImageView b;
  private int imageHeight = -2147483648;
  private int imageWidth = -2147483648;
  private TextView textView;
  
  public GdtBannerViewWithOnePicturePlusOneText(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      tkw.e("GdtBannerViewWithPictureText", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    this.b = new GdtBannerImageView(paramContext, paramString1);
    this.b.setId(2131367907);
    addView(this.b);
    this.textView = new TextView(paramContext);
    this.textView.setId(2131367910);
    this.textView.setMaxLines(4);
    this.textView.setEllipsize(TextUtils.TruncateAt.END);
    this.textView.setTextColor(Color.parseColor("#333333"));
    this.textView.setText(paramString2);
    addView(this.textView);
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
    if ((this.imageWidth <= 0) || (this.imageHeight <= 0) || (this.b == null) || (this.textView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      tkw.e("GdtBannerViewWithPictureText", "setSize error");
      return;
    }
    GdtBannerViewWithLetterStyle.a locala = new GdtBannerViewWithLetterStyle.a(getContext(), paramInt1, paramInt2);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(Double.valueOf(1.0D * (paramInt2 - locala.imageMargin * 2) / this.imageHeight * this.imageWidth + locala.imageMargin * 2).intValue(), paramInt2);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setPadding(locala.imageMargin, locala.imageMargin, locala.imageMargin, locala.imageMargin);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = locala.bBn;
    this.textView.setLayoutParams(localLayoutParams);
    this.textView.setTextSize(0, locala.textSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewWithOnePicturePlusOneText
 * JD-Core Version:    0.7.0.1
 */