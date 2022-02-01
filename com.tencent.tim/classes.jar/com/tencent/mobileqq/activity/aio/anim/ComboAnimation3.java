package com.tencent.mobileqq.activity.aio.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import wnk;
import wnl;
import wnm;
import wnn;

public class ComboAnimation3
  extends AIOAnimationConatiner.a
{
  static final int bPC = (int)(60.0F * BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density + 0.5F);
  Drawable[] drawables;
  public float pG = 0.04166667F;
  long targetId;
  private View view;
  private View view1;
  
  public ComboAnimation3(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean bv(long paramLong)
  {
    int m = this.view.getLeft();
    int n = this.view.getWidth() / 2;
    int i = this.view.getTop();
    int j = this.view.getHeight() / 2;
    int i1 = this.c.getWidth() / 2;
    int k = this.c.getHeight() / 2;
    m = i1 - (m + n);
    i = k - (i + j);
    if ((m != 0) || (i != 0))
    {
      this.view.offsetLeftAndRight(m);
      this.view.offsetTopAndBottom(i);
      this.view1.offsetLeftAndRight(m);
      this.view1.offsetTopAndBottom(i);
      this.c.invalidate();
    }
    return true;
  }
  
  protected void Cp(int paramInt)
  {
    this.c.offsetChildrenTopAndBottom(paramInt);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return bv(this.targetId);
  }
  
  @TargetApi(11)
  protected boolean c(Object... paramVarArgs)
  {
    boolean bool2 = false;
    int i = ((Integer)paramVarArgs[0]).intValue();
    this.targetId = ((Long)paramVarArgs[1]).longValue();
    boolean bool1 = bool2;
    int i1;
    int j;
    int k;
    if (i > 0)
    {
      i1 = Integer.toString(i).length();
      if (i <= 99) {
        break label783;
      }
      this.drawables = new Drawable[4];
      this.drawables[3] = this.l.getResources().getDrawable(2130838071);
      i = this.drawables[3].getIntrinsicWidth();
      this.drawables[2] = this.l.getResources().getDrawable(2130838281);
      j = this.drawables[2].getIntrinsicWidth();
      this.drawables[1] = this.l.getResources().getDrawable(2130838281);
      k = this.drawables[1].getIntrinsicWidth() + (i + 0 + j);
      this.drawables[0] = this.l.getResources().getDrawable(2130838282);
      i = this.drawables[0].getIntrinsicWidth() + k;
      this.view = new ComboView(this.l.getContext());
      this.view1 = new ComboView(this.l.getContext());
      this.c.addViewInLayout(this.view, -1, AIOAnimationConatiner.i, false);
      this.c.addViewInLayout(this.view1, -1, AIOAnimationConatiner.i, false);
      this.view.layout(0, 0, i, bPC);
      this.view1.layout(0, 0, i, bPC);
      bool1 = bool2;
      if (bv(this.targetId))
      {
        if (!VersionUtils.isHoneycomb()) {
          break label870;
        }
        this.view.setLayerType(2, null);
        this.view.setPivotX(i / 2);
        this.view.setPivotY(bPC / 2);
        this.view1.setLayerType(2, null);
        this.view1.setPivotX(i / 2);
        this.view1.setPivotY(bPC / 2);
        Object localObject1 = Keyframe.ofFloat(0.0F, 0.0F);
        Object localObject2 = Keyframe.ofFloat(11.0F * this.pG, 1.0F);
        Object localObject3 = Keyframe.ofFloat(20.0F * this.pG, 1.0F);
        Keyframe localKeyframe = Keyframe.ofFloat(1.0F, 0.0F);
        paramVarArgs = new Keyframe[4];
        paramVarArgs[0] = Keyframe.ofFloat(0.0F, 1.0F);
        paramVarArgs[1] = Keyframe.ofFloat(6.0F * this.pG, 1.5F);
        paramVarArgs[2] = Keyframe.ofFloat(11.0F * this.pG, 1.0F);
        paramVarArgs[3] = Keyframe.ofFloat(1.0F, 1.0F);
        localObject3 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject1, localObject2, localObject3, localKeyframe });
        localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", paramVarArgs);
        localObject2 = PropertyValuesHolder.ofKeyframe("scaleY", paramVarArgs);
        paramVarArgs = ObjectAnimator.ofPropertyValuesHolder(this.view, new PropertyValuesHolder[] { localObject3 }).setDuration(1000L);
        localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.view, new PropertyValuesHolder[] { localObject1 }).setDuration(1000L);
        localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.view, new PropertyValuesHolder[] { localObject2 }).setDuration(1000L);
        localObject3 = new AnimatorSet();
        ((AnimatorSet)localObject3).addListener(new wnk(this));
        ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
        ((AnimatorSet)localObject3).start();
        this.view.setTag(localObject3);
        this.view1.setAlpha(0.0F);
        paramVarArgs = ObjectAnimator.ofFloat(this.view1, "alpha", new float[] { 0.5F, 0.0F }).setDuration(333L);
        localObject1 = ObjectAnimator.ofFloat(this.view1, "scaleX", new float[] { 1.5F, 2.0F }).setDuration(333L);
        localObject2 = ObjectAnimator.ofFloat(this.view1, "scaleY", new float[] { 1.5F, 2.0F }).setDuration(333L);
        localObject3 = new AnimatorSet();
        ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
        ((AnimatorSet)localObject3).setStartDelay((this.pG * 5.0F * 1000.0F));
        ((AnimatorSet)localObject3).start();
        this.view1.setTag(localObject3);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label783:
      this.drawables = new Drawable[i1 + 1];
      int m = 0;
      j = 0;
      int n;
      do
      {
        this.drawables[(i1 - m)] = this.l.getResources().getDrawable(i % 10 + 2130838272);
        k = j + this.drawables[(i1 - m)].getIntrinsicWidth();
        m += 1;
        n = i / 10;
        j = k;
        i = n;
      } while (n > 0);
      break;
      label870:
      paramVarArgs = new wnl(this);
      paramVarArgs.setDuration(1000L);
      paramVarArgs.setFillAfter(true);
      this.view.setAnimation(paramVarArgs);
      paramVarArgs.setAnimationListener(new wnm(this));
      paramVarArgs = new wnn(this);
      paramVarArgs.setDuration(1000L);
      paramVarArgs.setFillAfter(true);
      this.view1.setAnimation(paramVarArgs);
    }
  }
  
  @TargetApi(11)
  protected void stop()
  {
    this.c.removeViewInLayout(this.view);
    this.c.removeViewInLayout(this.view1);
    if (VersionUtils.isHoneycomb())
    {
      Animator localAnimator1 = (Animator)this.view.getTag();
      Animator localAnimator2 = (Animator)this.view1.getTag();
      if (localAnimator1 != null) {
        localAnimator1.cancel();
      }
      if (localAnimator2 != null) {
        localAnimator2.cancel();
      }
    }
    this.view = null;
    this.view = null;
  }
  
  class ComboView
    extends View
  {
    public ComboView(Context paramContext)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas)
    {
      Drawable[] arrayOfDrawable = ComboAnimation3.this.drawables;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        arrayOfDrawable[i].draw(paramCanvas);
        i += 1;
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt1 = 0;
      paramInt3 = paramInt4 - paramInt2;
      Drawable[] arrayOfDrawable = ComboAnimation3.this.drawables;
      paramInt4 = arrayOfDrawable.length;
      paramInt2 = 0;
      while (paramInt1 < paramInt4)
      {
        Drawable localDrawable = arrayOfDrawable[paramInt1];
        localDrawable.setBounds(paramInt2, paramInt3 - localDrawable.getIntrinsicHeight(), localDrawable.getIntrinsicWidth() + paramInt2, paramInt3);
        paramInt2 += localDrawable.getIntrinsicWidth();
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.ComboAnimation3
 * JD-Core Version:    0.7.0.1
 */