package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import apzb;
import apzd;
import aqcx;

public class ShakePicView
  extends FrameLayout
  implements apzb
{
  protected ImageView EU;
  protected ImageView EV;
  protected boolean Yp;
  public Handler mHandler = new Handler(Looper.getMainLooper());
  protected ImageView uK;
  
  public ShakePicView(Context paramContext)
  {
    super(paramContext);
    this.uK = new ImageView(paramContext);
    this.EU = new ImageView(paramContext);
    this.EV = new ImageView(paramContext);
    this.uK.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.EU.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.EV.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.uK, -1, -1);
    addView(this.EU, -1, -1);
    addView(this.EV, -1, -1);
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onDestroy()
  {
    this.EU.clearAnimation();
    this.EU.setTag(null);
    this.EV.clearAnimation();
    this.EV.setTag(null);
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
    this.EU.setImageBitmap(paramBitmap);
    this.EV.setImageBitmap(paramBitmap);
  }
  
  protected void startAnimation()
  {
    if (this.Yp) {
      return;
    }
    Object localObject1 = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.142F, -aqcx.dip2px(getContext(), 2.5F)), Keyframe.ofFloat(0.285F, -aqcx.dip2px(getContext(), 7.5F)), Keyframe.ofFloat(0.426F, -aqcx.dip2px(getContext(), 2.5F)), Keyframe.ofFloat(0.568F, -aqcx.dip2px(getContext(), 2.5F)), Keyframe.ofFloat(0.71F, -aqcx.dip2px(getContext(), 7.5F)), Keyframe.ofFloat(0.852F, -aqcx.dip2px(getContext(), 2.5F)), Keyframe.ofFloat(1.0F, 0.0F) });
    Object localObject2 = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.142F, 0.0F), Keyframe.ofFloat(0.285F, -aqcx.dip2px(getContext(), 3.5F)), Keyframe.ofFloat(0.426F, -aqcx.dip2px(getContext(), 13.5F)), Keyframe.ofFloat(0.568F, 0.0F), Keyframe.ofFloat(0.71F, -aqcx.dip2px(getContext(), 3.5F)), Keyframe.ofFloat(0.852F, -aqcx.dip2px(getContext(), 13.5F)), Keyframe.ofFloat(1.0F, 0.0F) });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.EU, new PropertyValuesHolder[] { localObject1 }).setDuration(280L);
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.EU, new PropertyValuesHolder[] { localObject2 }).setDuration(280L);
    Object localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject2);
    ((AnimatorSet)localObject3).start();
    this.EU.setTag(localObject3);
    localObject1 = PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.33F, 0.05F), Keyframe.ofFloat(0.66F, 0.05F), Keyframe.ofFloat(1.0F, 0.0F) });
    localObject3 = new Keyframe[2];
    localObject3[0] = Keyframe.ofFloat(0.0F, 1.0F);
    localObject3[1] = Keyframe.ofFloat(1.0F, 2.33F);
    localObject2 = PropertyValuesHolder.ofKeyframe(View.SCALE_X, (Keyframe[])localObject3);
    localObject3 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, (Keyframe[])localObject3);
    localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.EV, new PropertyValuesHolder[] { localObject2 }).setDuration(320L);
    localObject3 = ObjectAnimator.ofPropertyValuesHolder(this.EV, new PropertyValuesHolder[] { localObject3 }).setDuration(320L);
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.EV, new PropertyValuesHolder[] { localObject1 }).setDuration(320L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject1);
    localAnimatorSet.start();
    this.EV.setTag(localAnimatorSet);
    localAnimatorSet.addListener(new apzd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.ShakePicView
 * JD-Core Version:    0.7.0.1
 */