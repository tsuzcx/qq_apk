package com.tencent.mobileqq.nearby.now.view.widget;

import ajwh;
import ajzb;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import java.net.URL;
import java.util.ArrayList;

public class ImageDisplayView
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  private ajzb a;
  public FitXImageView a;
  private URLDrawable p;
  private View rootView;
  
  public ImageDisplayView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ImageDisplayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ImageDisplayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void ax(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new ImageDisplayView.1(this, paramString, paramInt1, paramInt2), 8, null, true);
  }
  
  private void init()
  {
    this.rootView = LayoutInflater.from(getContext()).inflate(2131561446, this, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView = ((FitXImageView)this.rootView.findViewById(2131365975));
  }
  
  public void c(VideoData paramVideoData)
  {
    ajxs.feedId = paramVideoData.id;
    ajxs.bSM = String.valueOf(paramVideoData.ads);
    if (paramVideoData.type == 4)
    {
      ax(((ajwh)paramVideoData.yf.get(0)).imageUrl, ((ajwh)paramVideoData.yf.get(0)).imageWidth, ((ajwh)paramVideoData.yf.get(0)).dlm);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseAutoScaleParams = true;
    this.p = URLDrawable.getDrawable(((ajwh)paramVideoData.yf.get(0)).imageUrl, localURLDrawableOptions);
    if (this.p.getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView.setImageDrawable(this.p);
      this.jdField_a_of_type_Ajzb.iR(this.p.getIntrinsicWidth(), this.p.getIntrinsicHeight());
      return;
    }
    this.p.setURLDrawableListener(this);
    this.p.startDownload();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Ajzb != null) {
      this.jdField_a_of_type_Ajzb.a(paramURLDrawable.getURL().toString(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView, 1);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Ajzb != null) {
      this.jdField_a_of_type_Ajzb.a(paramURLDrawable.getURL().toString(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView, 0);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView.setImageDrawable(paramURLDrawable);
    this.jdField_a_of_type_Ajzb.iR(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
  }
  
  public void setRelayoutListener(ajzb paramajzb)
  {
    this.jdField_a_of_type_Ajzb = paramajzb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView
 * JD-Core Version:    0.7.0.1
 */