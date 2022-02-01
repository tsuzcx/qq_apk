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

final class GdtBannerViewWithOnePicturePlusTwoTexts
  extends LinearLayout
  implements the
{
  private TextView Bj;
  private GdtBannerImageView b;
  private LinearLayout container;
  private int imageHeight = -2147483648;
  private int imageWidth = -2147483648;
  private TextView titleView;
  
  public GdtBannerViewWithOnePicturePlusTwoTexts(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      tkw.e("GdtBannerViewForCreativeSize194", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    this.b = new GdtBannerImageView(paramContext, paramString1);
    this.b.setId(2131367907);
    addView(this.b);
    this.container = new LinearLayout(paramContext);
    this.container.setOrientation(1);
    addView(this.container);
    this.titleView = new TextView(paramContext);
    this.titleView.setId(2131367910);
    this.titleView.setLines(1);
    this.titleView.setEllipsize(TextUtils.TruncateAt.END);
    this.titleView.setTextColor(Color.parseColor("#333333"));
    this.titleView.setText(paramString2);
    this.container.addView(this.titleView);
    this.Bj = new TextView(paramContext);
    this.Bj.setId(2131367906);
    this.Bj.setMaxLines(2);
    this.Bj.setEllipsize(TextUtils.TruncateAt.END);
    this.Bj.setTextColor(Color.parseColor("#666666"));
    this.Bj.setText(paramString3);
    this.container.addView(this.Bj);
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
    if ((this.imageWidth <= 0) || (this.imageHeight <= 0) || (this.b == null) || (this.container == null) || (this.titleView == null) || (this.Bj == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      tkw.e("GdtBannerViewForCreativeSize194", "setSize error");
      return;
    }
    GdtBannerViewWithLetterStyle.a locala = new GdtBannerViewWithLetterStyle.a(getContext(), paramInt1, paramInt2);
    paramInt1 = Double.valueOf(1.0D * (paramInt2 - locala.imageMargin * 2) / this.imageHeight * this.imageWidth + locala.imageMargin * 2).intValue();
    this.b.setPadding(locala.imageMargin, locala.imageMargin, locala.imageMargin, locala.imageMargin);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = locala.bBn;
    this.container.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.titleView.setLayoutParams(localLayoutParams);
    this.titleView.setTextSize(0, locala.textSize);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = locala.bBo;
    this.Bj.setLayoutParams(localLayoutParams);
    this.Bj.setTextSize(0, locala.textSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerViewWithOnePicturePlusTwoTexts
 * JD-Core Version:    0.7.0.1
 */