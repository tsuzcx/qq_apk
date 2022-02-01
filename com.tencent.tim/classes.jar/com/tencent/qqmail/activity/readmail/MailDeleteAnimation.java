package com.tencent.qqmail.activity.readmail;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MailDeleteAnimation
{
  private Context context;
  private ImageView disappearView;
  private Runnable mAnimationComplete;
  private View showingView;
  
  public MailDeleteAnimation(ImageView paramImageView, View paramView, Context paramContext)
  {
    this.disappearView = paramImageView;
    this.showingView = paramView;
    this.context = paramContext;
  }
  
  public MailDeleteAnimation(ImageView paramImageView, View paramView, Context paramContext, Runnable paramRunnable)
  {
    this(paramImageView, paramView, paramContext);
    this.mAnimationComplete = paramRunnable;
  }
  
  public void animationStart()
  {
    this.showingView.destroyDrawingCache();
    this.showingView.setDrawingCacheEnabled(true);
    this.showingView.buildDrawingCache();
    Object localObject = Bitmap.createBitmap(this.showingView.getDrawingCache());
    this.disappearView.setImageBitmap((Bitmap)localObject);
    this.disappearView.setVisibility(0);
    localObject = AnimationUtils.loadAnimation(this.context, 2130772133);
    ((Animation)localObject).setAnimationListener(new MailDeleteAnimation.1(this));
    this.disappearView.startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.MailDeleteAnimation
 * JD-Core Version:    0.7.0.1
 */