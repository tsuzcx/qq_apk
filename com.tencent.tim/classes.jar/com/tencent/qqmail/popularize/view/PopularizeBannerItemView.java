package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class PopularizeBannerItemView
  extends FrameLayout
{
  private ImageView backgroundView;
  private final int bannerHeight = QMUIKit.dpToPx(70);
  private ImageView iconView;
  private Context mContext;
  private Popularize popularize;
  
  public PopularizeBannerItemView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setLayoutParams(new LinearLayout.LayoutParams(-1, this.bannerHeight));
    initView();
  }
  
  private void initView()
  {
    this.backgroundView = new ImageView(this.mContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.backgroundView, localLayoutParams);
    this.iconView = new ImageView(this.mContext);
    this.iconView.setImageResource(2130841021);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 21);
    localLayoutParams.rightMargin = QMUIKit.dpToPx(8);
    addView(this.iconView, localLayoutParams);
  }
  
  public void setOnCancelClickListener(View.OnClickListener paramOnClickListener)
  {
    this.iconView.setOnClickListener(new PopularizeBannerItemView.2(this, paramOnClickListener));
  }
  
  public void setOnImageClickListener(View.OnClickListener paramOnClickListener)
  {
    this.backgroundView.setOnClickListener(new PopularizeBannerItemView.1(this, paramOnClickListener));
  }
  
  public void setPopularize(Popularize paramPopularize)
  {
    this.popularize = paramPopularize;
    Bitmap localBitmap = PopularizeThumbManager.sharedInstance().getPopularizeThumb(paramPopularize.getImageUrl());
    if (localBitmap != null)
    {
      this.backgroundView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.backgroundView.setImageBitmap(localBitmap);
    }
    if (paramPopularize.getShowType() == 5) {
      this.iconView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBannerItemView
 * JD-Core Version:    0.7.0.1
 */