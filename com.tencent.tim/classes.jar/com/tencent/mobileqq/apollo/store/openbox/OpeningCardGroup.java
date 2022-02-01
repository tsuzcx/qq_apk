package com.tencent.mobileqq.apollo.store.openbox;

import abud;
import abud.a;
import abuh;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import auru;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class OpeningCardGroup
  extends MultilScreenlLayout
  implements Handler.Callback
{
  private abuh b;
  private auru e;
  private int mCenterX;
  private int mCenterY;
  private float sO;
  private AnimationSet w;
  
  public OpeningCardGroup(Context paramContext, abuh paramabuh)
  {
    super(paramContext);
    this.b = paramabuh;
    this.e = new auru(Looper.getMainLooper(), this);
  }
  
  public void Ej(boolean paramBoolean)
  {
    this.e.removeCallbacksAndMessages(null);
    if (paramBoolean)
    {
      this.b = null;
      this.a = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, abud paramabud)
  {
    if ((paramabud == null) || (paramabud.mItems == null)) {
      return;
    }
    int j = Math.min(super.getChildCount(), paramabud.mItems.size());
    int i = 0;
    while (i < j)
    {
      View localView = super.getChildAt(i);
      localView.clearAnimation();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      if ((localView instanceof ApolloCardLayout)) {
        ((ApolloCardLayout)localView).a(1, (abud.a)paramabud.mItems.get(i), paramInt1, paramInt2);
      }
      i += 1;
    }
    super.clearAnimation();
    super.setLayoutStyle(1);
  }
  
  public void a(List<abud.a> paramList, List<ApolloCardLayout> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.removeAllViews();
    super.clearAnimation();
    super.setLayoutStyle(0);
    super.setCurrentFrame(0);
    paramInt4 = (int)(paramInt3 * 0.706F);
    int i = paramInt4 * 760 / 530;
    int j = Math.min(paramList1.size(), paramList.size());
    this.sO = 1.0F;
    this.mCenterX = paramInt1;
    this.mCenterY = paramInt2;
    if (j == 1)
    {
      this.sO = 1.818182F;
      paramInt4 = (int)(paramInt4 * 0.55F);
      i = (int)(i * 0.55F);
      paramList1 = (ApolloCardLayout)paramList1.get(0);
      paramList1.a(2, (abud.a)paramList.get(0), paramInt4, i);
      paramList = new FrameLayout.LayoutParams(paramInt4, i);
      paramList.leftMargin = (paramInt3 - paramInt1 - paramInt4 / 2);
      paramList.topMargin = (paramInt2 - i / 2);
      paramList1.clearAnimation();
      super.addView(paramList1, paramList);
      return;
    }
    if (j == 2)
    {
      this.sO = 1.818182F;
      paramInt4 = (int)(paramInt4 * 0.55F);
      i = (int)(i * 0.55F);
      j = (int)(paramInt3 * 0.016F);
      localApolloCardLayout = (ApolloCardLayout)paramList1.get(0);
      localApolloCardLayout.a(2, (abud.a)paramList.get(0), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt3 - paramInt1 - j / 2 - paramInt4;
      paramInt2 -= i / 2;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      paramList1 = (ApolloCardLayout)paramList1.get(1);
      paramList1.a(2, (abud.a)paramList.get(1), paramInt4, i);
      paramList = new FrameLayout.LayoutParams(paramInt4, i);
      paramList.leftMargin = (paramInt4 + (paramInt1 + j));
      paramList.topMargin = paramInt2;
      paramList1.clearAnimation();
      super.addView(paramList1, paramList);
      return;
    }
    if (j == 3)
    {
      this.sO = 2.631579F;
      paramInt4 = (int)(paramInt4 * 0.38F);
      i = (int)(i * 0.38F);
      localApolloCardLayout = (ApolloCardLayout)paramList1.get(0);
      localApolloCardLayout.a(3, (abud.a)paramList.get(0), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt3 - paramInt1 - 0 - paramInt4 * 3 / 2;
      paramInt2 -= i / 2;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      localApolloCardLayout = (ApolloCardLayout)paramList1.get(1);
      localApolloCardLayout.a(3, (abud.a)paramList.get(1), paramInt4, i);
      localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
      paramInt1 = paramInt1 + 0 + paramInt4;
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.topMargin = paramInt2;
      localApolloCardLayout.clearAnimation();
      super.addView(localApolloCardLayout, localLayoutParams);
      paramList1 = (ApolloCardLayout)paramList1.get(2);
      paramList1.a(3, (abud.a)paramList.get(2), paramInt4, i);
      paramList = new FrameLayout.LayoutParams(paramInt4, i);
      paramList.leftMargin = (paramInt4 + (paramInt1 + 0));
      paramList.topMargin = paramInt2;
      paramList1.clearAnimation();
      super.addView(paramList1, paramList);
      return;
    }
    this.sO = 3.571429F;
    paramInt4 = (int)(paramInt4 * 0.28F);
    i = (int)(i * 0.28F);
    j = (int)(paramInt3 * 0.008F);
    ApolloCardLayout localApolloCardLayout = (ApolloCardLayout)paramList1.get(0);
    localApolloCardLayout.a(4, (abud.a)paramList.get(0), paramInt4, i);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt3 = paramInt3 - paramInt1 - j * 3 / 2 - paramInt4 * 2;
    paramInt1 = paramInt2 - i / 2;
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    localApolloCardLayout = (ApolloCardLayout)paramList1.get(1);
    localApolloCardLayout.a(4, (abud.a)paramList.get(1), paramInt4, i);
    localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt2 = paramInt3 + j + paramInt4;
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    localApolloCardLayout = (ApolloCardLayout)paramList1.get(2);
    localApolloCardLayout.a(4, (abud.a)paramList.get(2), paramInt4, i);
    localLayoutParams = new FrameLayout.LayoutParams(paramInt4, i);
    paramInt2 = paramInt2 + j + paramInt4;
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt1;
    localApolloCardLayout.clearAnimation();
    super.addView(localApolloCardLayout, localLayoutParams);
    paramList1 = (ApolloCardLayout)paramList1.get(3);
    paramList1.a(4, (abud.a)paramList.get(3), paramInt4, i);
    paramList = new FrameLayout.LayoutParams(paramInt4, i);
    paramList.leftMargin = (paramInt4 + (paramInt2 + j));
    paramList.topMargin = paramInt1;
    paramList1.clearAnimation();
    super.addView(paramList1, paramList);
  }
  
  public void aD(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = super.getChildAt(i);
      float f = this.sO;
      int k = localView.getLeft();
      int m = localView.getWidth() / 2;
      AnimationSet localAnimationSet = new AnimationSet(false);
      Object localObject = new ScaleAnimation(1.0F, f, 1.0F, f, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setFillAfter(true);
      localObject = new TranslateAnimation(0.0F, paramInt2 * i + paramInt1 - (k + m), 0.0F, paramInt3 - this.mCenterY);
      ((TranslateAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localView.clearAnimation();
      localView.startAnimation(localAnimationSet);
      i += 1;
    }
    this.e.removeMessages(15);
    this.e.sendEmptyMessageDelayed(15, 400L);
  }
  
  public void cFy()
  {
    if (this.w == null)
    {
      this.w = new AnimationSet(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.25F, 0.0F, 0.25F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      this.w.addAnimation(localScaleAnimation);
      localScaleAnimation = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(150L);
      localScaleAnimation.setStartOffset(450L);
      this.w.addAnimation(localScaleAnimation);
    }
    this.w.reset();
    super.startAnimation(this.w);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return false;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 15: 
        if (QLog.isColorLevel()) {
          QLog.d("ApolloCardWindow", 2, "MSG_CODE_ANIMATION_END");
        }
        break;
      }
    } while (this.b == null);
    this.b.aC(10, 0, 0);
    return false;
    super.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.OpeningCardGroup
 * JD-Core Version:    0.7.0.1
 */