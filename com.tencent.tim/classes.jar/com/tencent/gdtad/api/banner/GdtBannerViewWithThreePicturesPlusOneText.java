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

final class GdtBannerViewWithThreePicturesPlusOneText
  extends LinearLayout
  implements the
{
  private GdtBannerImageView c;
  private GdtBannerImageView d;
  private GdtBannerImageView e;
  private int imageHeight = -2147483648;
  private int imageWidth = -2147483648;
  private TextView textView;
  
  public GdtBannerViewWithThreePicturesPlusOneText(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      tkw.e("GdtBannerViewForCreativeSize285", "constructor");
      return;
    }
    setOrientation(1);
    setGravity(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    addView(localLinearLayout, localLayoutParams);
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    this.c = new GdtBannerImageView(paramContext, paramString1);
    this.c.setId(2131367907);
    localLinearLayout.addView(this.c);
    this.d = new GdtBannerImageView(paramContext, paramString2);
    this.d.setId(2131367908);
    localLinearLayout.addView(this.d);
    this.e = new GdtBannerImageView(paramContext, paramString3);
    this.e.setId(2131367909);
    localLinearLayout.addView(this.e);
    this.textView = new TextView(paramContext);
    this.textView.setId(2131367910);
    this.textView.setLines(1);
    this.textView.setEllipsize(TextUtils.TruncateAt.END);
    this.textView.setTextColor(Color.parseColor("#333333"));
    this.textView.setText(paramString4);
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
    if ((this.imageWidth <= 0) || (this.imageHeight <= 0) || (this.c == null) || (this.d == null) || (this.e == null) || (this.textView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      tkw.e("GdtBannerViewForCreativeSize285", "setSize error");
      return;
    }
    GdtBannerViewWithLetterStyle.a locala = new GdtBannerViewWithLetterStyle.a(getContext(), paramInt1, paramInt2);
    paramInt2 = Double.valueOf((paramInt1 - locala.bBn * 2) * 1.0D / 3.0D).intValue();
    int i = Double.valueOf((paramInt2 - locala.imageMargin * 2) * 1.0D / this.imageWidth * this.imageHeight + locala.imageMargin * 2).intValue();
    paramInt1 = Double.valueOf(0.839285714285714D * paramInt1).intValue();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
    localLayoutParams.leftMargin = 0;
    this.c.setPadding(locala.imageMargin, locala.imageMargin, locala.imageMargin, locala.imageMargin);
    this.c.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
    localLayoutParams.leftMargin = locala.bBn;
    this.d.setPadding(locala.imageMargin, locala.imageMargin, locala.imageMargin, locala.imageMargin);
    this.d.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
    localLayoutParams.leftMargin = locala.bBn;
    this.e.setPadding(locala.imageMargin, locala.imageMargin, locala.imageMargin, locala.imageMargin);
    this.e.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(paramInt1, -2);
    localLayoutParams.topMargin = locala.imageMargin;
    this.textView.setLayoutParams(localLayoutParams);
    this.textView.setTextSize(0, locala.textSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewWithThreePicturesPlusOneText
 * JD-Core Version:    0.7.0.1
 */