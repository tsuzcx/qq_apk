package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awit;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import kvk;

public class ReadInJoyCommentLikeView
  extends FrameLayout
  implements IView
{
  private a a;
  private BaseCommentData c;
  private TextView cB;
  private RelativeLayout eV;
  private ImageView iF;
  private View.OnClickListener mListener;
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void aHt()
  {
    ImageView localImageView;
    if (this.c != null)
    {
      localImageView = this.iF;
      if (!this.c.isLiked()) {
        break label77;
      }
    }
    label77:
    for (int i = 2130843639;; i = 2130843637)
    {
      localImageView.setImageResource(i);
      if (this.c.likeCnt > 0) {
        this.cB.setText(awit.gM(this.c.likeCnt));
      }
      if (this.c.likeCnt == 0) {
        this.cB.setText("");
      }
      return;
    }
  }
  
  private void cm(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, SCALE_X, new float[] { 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.6F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, SCALE_Y, new float[] { 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.6F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void init()
  {
    inflate(getContext(), 2131560286, this);
    this.eV = ((RelativeLayout)findViewById(2131370686));
    this.iF = ((ImageView)findViewById(2131369795));
    this.cB = ((TextView)findViewById(2131380633));
    this.mListener = new kvk(this);
    this.eV.setOnClickListener(this.mListener);
  }
  
  public void b(BaseCommentData paramBaseCommentData)
  {
    this.c = paramBaseCommentData;
    aHt();
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setOnLikeListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
    extends ViewBase.OnClickListener
  {
    public abstract void m(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentLikeView
 * JD-Core Version:    0.7.0.1
 */