package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import axiy;
import axke;
import axkf;
import axkg;

public class AEEditorApplyAllLoadingView
  extends FrameLayout
{
  private TextView ahj;
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558602, this);
    this.ahj = ((TextView)findViewById(2131379402));
    showAnimation();
  }
  
  private void showAnimation()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator1.setDuration(1000L);
    localValueAnimator1.addUpdateListener(new axke(this));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator2.setDuration(1000L);
    localValueAnimator2.addUpdateListener(new axkf(this));
    localAnimatorSet.play(localValueAnimator1).before(localValueAnimator2);
    localAnimatorSet.addListener(new axkg(this));
    localAnimatorSet.start();
  }
  
  public void cancelLoading()
  {
    if (getParent() == null)
    {
      axiy.d("AEEditorApplyAllLoadingView", "cancelLoading parent is null.");
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView
 * JD-Core Version:    0.7.0.1
 */