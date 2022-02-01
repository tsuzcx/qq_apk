package com.tencent.biz.qqcircle.fragments.content;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.qqcircle.widgets.multiTouchImage.QCircleMultiTouchImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import ous;
import par;
import pas;

public class QCircleContentImage
  extends BaseWidgetView<FeedCloudMeta.StFeed>
  implements URLDrawableDownListener
{
  private QCircleMultiTouchImageView a;
  private boolean azh;
  private int bgQ;
  
  public QCircleContentImage(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private URLDrawable.URLDrawableOptions a(URLImageView paramURLImageView, FeedCloudMeta.StImage paramStImage)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = ous.b(this.a);
    localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130851770);
    if ((paramStImage == null) || (paramURLImageView == null)) {}
    int k;
    do
    {
      return localURLDrawableOptions;
      j = paramStImage.height.get();
      k = paramStImage.width.get();
    } while ((j <= 0) || (k <= 0));
    int i = ImmersiveUtils.getScreenWidth();
    float f = i / k;
    int j = (int)(j * f);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = j;
    return localURLDrawableOptions;
  }
  
  private void f(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.a != null)
    {
      this.a.setOnDoubleTabListener(new par(this, paramStFeed));
      this.a.setOnScaleChangeListener(new pas(this, paramStFeed));
    }
  }
  
  protected void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.a != null)
    {
      Object localObject2 = (FeedCloudMeta.StImage)((FeedCloudMeta.StImage)paramStFeed.images.get(this.bvX)).get();
      Object localObject1 = ((FeedCloudMeta.StImage)localObject2).picUrl.get();
      if (localObject1 != null)
      {
        localObject2 = a(this.a, (FeedCloudMeta.StImage)localObject2);
        localObject1 = new QCircleFeedPicLoader.b().a(this.a).a(((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight).b(((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth).a((String)localObject1).a(getResources().getDrawable(2130851770)).a(true);
        QCircleFeedPicLoader.a().a((QCircleFeedPicLoader.b)localObject1, null);
      }
      f(paramStFeed);
      this.azh = false;
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.a = new QCircleMultiTouchImageView(getContext());
    addView(this.a, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      this.a.blh();
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (this.a != null) {
      this.a.blg();
    }
  }
  
  public void release()
  {
    if (this.a != null) {
      this.a.setImageDrawable(null);
    }
  }
  
  public void setVerticalPos(int paramInt)
  {
    this.bgQ = paramInt;
  }
  
  public boolean v(float paramFloat1, float paramFloat2)
  {
    if (this.a != null) {
      return this.a.v(paramFloat1, paramFloat2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage
 * JD-Core Version:    0.7.0.1
 */