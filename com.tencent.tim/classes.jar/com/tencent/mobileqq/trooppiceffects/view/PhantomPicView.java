package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import apzb;

public class PhantomPicView
  extends FrameLayout
  implements apzb
{
  protected ImageView EU;
  protected ImageView EV;
  protected boolean Yp;
  protected FrameLayout ca;
  protected FrameLayout cb;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  protected ImageView uK;
  
  public PhantomPicView(Context paramContext)
  {
    super(paramContext);
    this.uK = new ImageView(paramContext);
    this.EU = new ImageView(paramContext);
    this.EV = new ImageView(paramContext);
    this.ca = new FrameLayout(paramContext);
    this.cb = new FrameLayout(paramContext);
    this.uK.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.EU.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.EV.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.uK, -1, -1);
    addView(this.ca, -1, -1);
    addView(this.cb, -1, -1);
    this.ca.addView(this.EU, -1, -1);
    this.cb.addView(this.EV, -1, -1);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onDestroy()
  {
    this.ca.clearAnimation();
    this.ca.setTag(null);
    this.cb.clearAnimation();
    this.cb.setTag(null);
    this.Yp = true;
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void play()
  {
    startAnimation();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.uK.setImageBitmap(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), paramBitmap);
    localBitmapDrawable.setColorFilter(Color.parseColor("#D000FF"), PorterDuff.Mode.ADD);
    paramBitmap = new BitmapDrawable(getResources(), paramBitmap);
    paramBitmap.setColorFilter(Color.parseColor("#0005FF"), PorterDuff.Mode.ADD);
    this.EU.setImageDrawable(localBitmapDrawable);
    this.EV.setImageDrawable(paramBitmap);
    this.ca.setVisibility(4);
    this.cb.setVisibility(4);
  }
  
  public void startAnimation()
  {
    if (this.Yp) {
      return;
    }
    this.ca.setVisibility(0);
    Object localObject4 = new Keyframe[3];
    localObject4[0] = Keyframe.ofFloat(0.0F, 1.0F);
    localObject4[1] = Keyframe.ofFloat(0.33F, 1.1F);
    localObject4[2] = Keyframe.ofFloat(1.0F, 1.0F);
    Object localObject2 = Keyframe.ofFloat(0.0F, 0.0F);
    Object localObject3 = Keyframe.ofFloat(0.33F, 0.8F);
    Keyframe localKeyframe1 = Keyframe.ofFloat(0.66F, 0.8F);
    Keyframe localKeyframe2 = Keyframe.ofFloat(1.0F, 0.0F);
    Object localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", (Keyframe[])localObject4);
    localObject4 = PropertyValuesHolder.ofKeyframe("scaleY", (Keyframe[])localObject4);
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.ca, new PropertyValuesHolder[] { localObject1 }).setDuration(320L);
    localObject4 = ObjectAnimator.ofPropertyValuesHolder(this.ca, new PropertyValuesHolder[] { localObject4 }).setDuration(320L);
    localObject2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject2, localObject3, localKeyframe1, localKeyframe2 });
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.ca, new PropertyValuesHolder[] { localObject2 }).setDuration(320L);
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject4).with((Animator)localObject2);
    ((AnimatorSet)localObject3).start();
    this.ca.setTag(localObject3);
    this.mHandler.postDelayed(new PhantomPicView.1(this), 80L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.PhantomPicView
 * JD-Core Version:    0.7.0.1
 */