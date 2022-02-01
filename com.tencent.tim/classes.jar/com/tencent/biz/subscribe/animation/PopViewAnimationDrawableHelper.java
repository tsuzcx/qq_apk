package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import mqq.util.WeakReference;
import sai;

public class PopViewAnimationDrawableHelper
{
  private b jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$b;
  private c jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$c;
  private int btH;
  private int bvV;
  private int bvW;
  private AnimationDrawable mAnimationDrawable;
  private Handler mHandler;
  private Runnable mRunnable;
  
  public PopViewAnimationDrawableHelper(AnimationDrawable paramAnimationDrawable)
  {
    this.mAnimationDrawable = paramAnimationDrawable;
    this.bvW = paramAnimationDrawable.getNumberOfFrames();
    this.mHandler = new a();
    this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$c = new sai(this);
    this.mRunnable = new LoopingRunnable(this);
  }
  
  private void initHandler()
  {
    if ((this.mRunnable != null) && (this.mHandler != null))
    {
      if (this.bvV > 0) {
        this.mHandler.postDelayed(this.mRunnable, this.bvV);
      }
    }
    else {
      return;
    }
    Handler localHandler = this.mHandler;
    Runnable localRunnable = this.mRunnable;
    if (this.bvV == 0) {}
    for (long l = ui();; l = this.btH)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
  
  private int ui()
  {
    int i = 0;
    while (i < this.bvW)
    {
      if (this.btH < this.mAnimationDrawable.getDuration(i)) {
        this.btH = this.mAnimationDrawable.getDuration(i);
      }
      i += 1;
    }
    if (this.btH > 1000) {
      return 1000;
    }
    return this.btH;
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$b = paramb;
  }
  
  public void releaseHandler()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
  }
  
  public void start()
  {
    if (this.mAnimationDrawable == null) {}
    do
    {
      return;
      this.mAnimationDrawable.start();
      initHandler();
    } while (this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$b == null);
    this.jdField_a_of_type_ComTencentBizSubscribeAnimationPopViewAnimationDrawableHelper$b.onStart();
  }
  
  static class LoopingRunnable
    implements Runnable
  {
    private WeakReference<PopViewAnimationDrawableHelper> M;
    
    public LoopingRunnable(PopViewAnimationDrawableHelper paramPopViewAnimationDrawableHelper)
    {
      this.M = new WeakReference(paramPopViewAnimationDrawableHelper);
    }
    
    public void run()
    {
      Object localObject = (PopViewAnimationDrawableHelper)this.M.get();
      PopViewAnimationDrawableHelper.c localc;
      if (localObject != null)
      {
        localc = PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject);
        if (localc != null)
        {
          if (PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject) <= 0) {
            break label38;
          }
          localc.bxH();
        }
      }
      return;
      label38:
      localObject = PopViewAnimationDrawableHelper.a((PopViewAnimationDrawableHelper)localObject);
      if ((localObject != null) && (((AnimationDrawable)localObject).getFrame(((AnimationDrawable)localObject).getNumberOfFrames() - 1) != ((AnimationDrawable)localObject).getCurrent()))
      {
        localc.bxI();
        return;
      }
      localc.bxH();
    }
  }
  
  static class a
    extends Handler
  {}
  
  public static abstract interface b
  {
    public abstract void onEnd();
    
    public abstract void onStart();
  }
  
  public static abstract interface c
  {
    public abstract void bxH();
    
    public abstract void bxI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper
 * JD-Core Version:    0.7.0.1
 */