package com.tencent.tim.todo.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import auoi;
import aupe;
import aupz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.todo.data.TodoInfo;
import java.util.ArrayList;
import java.util.List;

public class TodoCardView
  extends RelativeLayout
{
  private View Lb;
  private View Lc;
  private View Ld;
  private TextView RL;
  private TextView acc;
  private TextView afF;
  private boolean djw;
  private boolean djx;
  private ViewGroup eV;
  private ViewGroup eW;
  private Button hM;
  private boolean isEmpty;
  private ViewGroup mContentLayout;
  private ImageView mEmptyBackground;
  private TextView[] u = new TextView[4];
  private boolean[] z = new boolean[4];
  
  public TodoCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TodoCardView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TodoCardView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bj(float paramFloat)
  {
    ((ViewGroup.MarginLayoutParams)this.eW.getLayoutParams()).topMargin = ((int)h(10.0F, 100.0F, paramFloat));
    this.eW.setScaleX(0.5F * paramFloat + 1.0F);
    this.eW.setScaleY(0.5F * paramFloat + 1.0F);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mEmptyBackground.getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)h(-20.0F, 0.0F, paramFloat));
    localMarginLayoutParams.height = ((int)h(166.0F, 200.0F, paramFloat));
    ((ViewGroup.MarginLayoutParams)this.afF.getLayoutParams()).topMargin = ((int)h(40.0F, 125.0F, paramFloat));
    this.afF.setTextSize(0, (int)h(16.0F, 24.0F, paramFloat));
    localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.hM.getLayoutParams();
    localMarginLayoutParams.topMargin = ((int)h(20.0F, 84.0F, paramFloat));
    localMarginLayoutParams.width = ((int)h(120.0F, 188.0F, paramFloat));
    localMarginLayoutParams.height = ((int)h(28.0F, 36.0F, paramFloat));
    this.hM.setTextSize(0, (int)h(14.0F, 16.0F, paramFloat));
  }
  
  private float h(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return getContext().getResources().getDisplayMetrics().density * ((paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1) + 0.5F;
  }
  
  public void ewc()
  {
    float f = getContext().getResources().getDisplayMetrics().density;
    this.eW.setTranslationY(0.0F);
    this.Lb.setScaleX(1.0F);
    this.Lb.setScaleY(1.0F);
    this.Lc.setScaleX(1.0F);
    this.Lc.setScaleY(1.0F);
    this.Ld.setScaleX(1.0F);
    this.Ld.setScaleY(1.0F);
    this.mEmptyBackground.setAlpha(1.0F);
    this.afF.setTranslationY(0.0F);
    this.afF.setAlpha(1.0F);
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 11.0F * f, 0.0F);
    ((TranslateAnimation)localObject1).setDuration(1030L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.eW.startAnimation((Animation)localObject1);
    localObject1 = new ScaleAnimation(0.87F, 1.0F, 0.87F, 1.0F, this.Lb.getWidth() / 2, this.Lb.getHeight() / 2);
    ((ScaleAnimation)localObject1).setDuration(400L);
    ((ScaleAnimation)localObject1).setFillAfter(true);
    this.Lb.startAnimation((Animation)localObject1);
    localObject1 = new ScaleAnimation(0.52F, 1.0F, 0.52F, 1.0F, this.Lc.getWidth() / 2, this.Lc.getHeight() / 2);
    ((ScaleAnimation)localObject1).setDuration(733L);
    ((ScaleAnimation)localObject1).setFillAfter(true);
    this.Lc.startAnimation((Animation)localObject1);
    localObject1 = new ScaleAnimation(0.31F, 1.0F, 0.31F, 1.0F, this.Ld.getWidth() / 2, this.Ld.getHeight() / 2);
    ((ScaleAnimation)localObject1).setDuration(1070L);
    ((ScaleAnimation)localObject1).setFillAfter(true);
    this.Ld.startAnimation((Animation)localObject1);
    localObject1 = new AlphaAnimation(0.65F, 1.0F);
    ((AlphaAnimation)localObject1).setDuration(370L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.mEmptyBackground.startAnimation((Animation)localObject1);
    localObject1 = new AnimationSet(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, 9.0F * f, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(270L);
    ((TranslateAnimation)localObject2).setFillAfter(true);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AlphaAnimation(0.3F, 1.0F);
    ((AlphaAnimation)localObject2).setDuration(230L);
    ((AlphaAnimation)localObject2).setFillAfter(true);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    this.afF.startAnimation((Animation)localObject1);
  }
  
  public void ewd()
  {
    if (!this.isEmpty)
    {
      int i = 0;
      while (i < 4)
      {
        this.u[i].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.u[i].setMaxLines(2);
        i += 1;
      }
    }
  }
  
  public void ewe()
  {
    if (!this.isEmpty)
    {
      setVisibility(8);
      setAlpha(1.0F);
      this.mContentLayout.getBackground().setAlpha(255);
      return;
    }
    if (this.djw)
    {
      setVisibility(8);
      setAlpha(1.0F);
      return;
    }
    this.acc.setVisibility(0);
  }
  
  public boolean isEmpty()
  {
    return this.isEmpty;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mContentLayout = ((ViewGroup)findViewById(2131365382));
    this.RL = ((TextView)findViewById(2131381119));
    this.u[0] = ((TextView)findViewById(2131381121));
    this.u[1] = ((TextView)findViewById(2131381122));
    this.u[2] = ((TextView)findViewById(2131381123));
    this.u[3] = ((TextView)findViewById(2131381124));
    this.eV = ((ViewGroup)findViewById(2131366417));
    this.eW = ((ViewGroup)findViewById(2131366424));
    this.Lb = findViewById(2131379014);
    this.Lc = findViewById(2131379015);
    this.Ld = findViewById(2131379016);
    this.mEmptyBackground = ((ImageView)findViewById(2131366402));
    this.afF = ((TextView)findViewById(2131366416));
    this.hM = ((Button)findViewById(2131366419));
    this.acc = ((TextView)findViewById(2131366435));
    this.hM.setOnClickListener(new aupz(this));
  }
  
  public void setAnimationProgress(float paramFloat)
  {
    if (!this.isEmpty)
    {
      this.RL.setAlpha(h(0.6F, 1.0F, paramFloat));
      this.RL.setTextSize(0, (int)h(18.0F, 36.0F, paramFloat));
      this.RL.setPadding((int)h(24.0F, 8.0F, paramFloat), (int)h(24.0F, 0.0F, paramFloat), getPaddingRight(), (int)h(6.0F, 72.0F, paramFloat) + 1);
      int i = 0;
      if (i < 4)
      {
        TextView localTextView = this.u[i];
        int j;
        label155:
        int k;
        int m;
        if (localTextView.getVisibility() == 0)
        {
          localTextView.setTextSize(0, (int)h(16.0F, 18.0F, paramFloat));
          j = (int)h(34.0F, 35.0F, paramFloat);
          if (this.z[i] == 0) {
            break label221;
          }
          f = 36.0F;
          k = (int)h(18.0F, f, paramFloat);
          m = (int)h(24.0F, 8.0F, paramFloat);
          if (this.z[i] == 0) {
            break label228;
          }
        }
        label221:
        label228:
        for (float f = 32.0F;; f = 50.0F)
        {
          localTextView.setPadding(j, k, m, (int)h(2.0F, f, paramFloat) + 1);
          i += 1;
          break;
          f = 18.0F;
          break label155;
        }
      }
      this.mContentLayout.getBackground().setAlpha((int)h(255.0F, 0.0F, paramFloat));
      return;
    }
    if (this.djw)
    {
      setAlpha(1.0F - paramFloat);
      return;
    }
    bj(paramFloat);
  }
  
  public void setOnlyCard(boolean paramBoolean)
  {
    this.djx = paramBoolean;
  }
  
  public void setTodoData()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject = (auoi)localQQAppInterface.getManager(376);
    ArrayList localArrayList = ((auoi)localObject).et();
    boolean bool;
    int i;
    if (((auoi)localObject).OL() > 0)
    {
      bool = true;
      this.djw = bool;
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break label286;
      }
      this.mContentLayout.setVisibility(0);
      this.eV.setVisibility(8);
      this.isEmpty = false;
      this.RL.setText(getResources().getString(2131721213, new Object[] { Integer.valueOf(localArrayList.size()) }));
      i = 0;
      label119:
      if (i >= 4) {
        return;
      }
      if (localArrayList.size() <= i) {
        break label266;
      }
      if (!TextUtils.isEmpty(((TodoInfo)localArrayList.get(i)).content)) {
        this.u[i].setText(((TodoInfo)localArrayList.get(i)).content.trim());
      }
      this.u[i].setVisibility(0);
      localObject = this.z;
      if ((!TextUtils.isEmpty(aupe.a((TodoInfo)localArrayList.get(i), localQQAppInterface, getContext()))) || (((TodoInfo)localArrayList.get(i)).remindTime != 0L)) {
        break label261;
      }
      bool = true;
      label244:
      localObject[i] = bool;
    }
    for (;;)
    {
      i += 1;
      break label119;
      bool = false;
      break;
      label261:
      bool = false;
      break label244;
      label266:
      this.u[i].setVisibility(4);
      this.z[i] = false;
    }
    label286:
    this.mContentLayout.setVisibility(4);
    this.eV.setVisibility(0);
    this.isEmpty = true;
    if (this.djx)
    {
      float f = getContext().getResources().getDisplayMetrics().density;
      this.eW.setTranslationY(11.0F * f);
      this.Lb.setScaleX(0.87F);
      this.Lb.setScaleY(0.87F);
      this.Lc.setScaleX(0.52F);
      this.Lc.setScaleY(0.52F);
      this.Ld.setScaleX(0.31F);
      this.Ld.setScaleY(0.31F);
      this.mEmptyBackground.setAlpha(0.65F);
      this.afF.setTranslationY(f * 9.0F);
      this.afF.setAlpha(0.3F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.widget.TodoCardView
 * JD-Core Version:    0.7.0.1
 */