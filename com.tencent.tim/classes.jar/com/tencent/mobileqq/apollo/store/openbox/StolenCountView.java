package com.tencent.mobileqq.apollo.store.openbox;

import abtn;
import abxi;
import android.content.Context;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqgz;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.io.File;

public class StolenCountView
  extends RelativeLayout
{
  private URLImageView aN;
  private URLImageView aO;
  
  public StolenCountView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  private void cFA()
  {
    if (!new File(abxi.biw + "boxcard/apollo_stolen_count_1.png").exists()) {
      abtn.a("apollo_stolen_count_1.png", null, abtn.iG("apollo_stolen_count_1.png")).startDownload();
    }
    if (!new File(abxi.biw + "boxcard/apollo_stolen_count_2.png").exists()) {
      abtn.a("apollo_stolen_count_2.png", null, abtn.iG("apollo_stolen_count_2.png")).startDownload();
    }
    if (!new File(abxi.biw + "boxcard/apollo_stolen_count_3.png").exists()) {
      abtn.a("apollo_stolen_count_3.png", null, abtn.iG("apollo_stolen_count_3.png")).startDownload();
    }
    if (!new File(abxi.biw + "boxcard/apollo_stolen_count_4.png").exists()) {
      abtn.a("apollo_stolen_count_4.png", null, abtn.iG("apollo_stolen_count_4.png")).startDownload();
    }
  }
  
  private void init(Context paramContext)
  {
    cFA();
    this.aO = new URLImageView(paramContext);
    int j = (int)((float)aqgz.hK() * 0.97F);
    int i = (int)((float)aqgz.hK() * 0.192F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, i);
    localLayoutParams.addRule(13);
    URLDrawable localURLDrawable = abtn.a("apollo_stolen_count_bg.png", null, abtn.iG("apollo_stolen_count_bg.png"));
    localURLDrawable.startDownload();
    this.aO.setImageDrawable(localURLDrawable);
    this.aO.setAlpha(0);
    super.addView(this.aO, localLayoutParams);
    j = (int)((float)aqgz.hK() * 0.738F);
    this.aN = new URLImageView(paramContext);
    paramContext = new RelativeLayout.LayoutParams(j, i);
    this.aN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    paramContext.addRule(13);
    super.addView(this.aN, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.StolenCountView
 * JD-Core Version:    0.7.0.1
 */