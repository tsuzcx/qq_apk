package com.tencent.mobileqq.doutu.combo;

import afed;
import afee;
import afee.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ComboNavigateBar
  extends LinearLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  protected Animation X;
  afed a;
  private String bDi = "";
  private boolean bXH = true;
  private QQAppInterface mApp;
  private ImageView yA;
  private ImageView yB;
  private ImageView yC;
  private ImageView yD;
  private ImageView yE;
  
  public ComboNavigateBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Drawable a(View paramView, afee.a parama)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = parama.width;
    paramView.height = parama.height;
    return parama.drawable;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    afee.a locala = afee.a(paramInt);
    if (locala == null)
    {
      this.bXH = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, locala));
    return true;
  }
  
  private boolean aiR()
  {
    afee.a locala = afee.a();
    if (locala == null)
    {
      this.bXH = false;
      return false;
    }
    this.yE.setImageDrawable(a(this.yE, locala));
    return true;
  }
  
  private boolean aiS()
  {
    afee.a locala = afee.b();
    if (locala == null)
    {
      this.bXH = false;
      return false;
    }
    this.yD.setImageDrawable(a(this.yD, locala));
    return true;
  }
  
  public void hide()
  {
    if ((this.X != null) && (getVisibility() == 0))
    {
      clearAnimation();
      startAnimation(this.X);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.X)) {
      setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    hide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCountNum()
  {
    int k = this.a.cQE;
    int j = k / 10;
    int i;
    if (j != 0)
    {
      i = j % 10;
      j /= 10;
    }
    for (;;)
    {
      if (j != 0) {
        j %= 100;
      }
      for (;;)
      {
        aiS();
        aiR();
        this.yC.setVisibility(0);
        a(this.yC, k % 10);
        if (j == 0)
        {
          if (i == 0)
          {
            this.yB.setVisibility(8);
            this.yA.setVisibility(8);
            return;
          }
          this.yB.setVisibility(0);
          this.yA.setVisibility(8);
          a(this.yB, i);
          return;
        }
        this.yB.setVisibility(0);
        this.yA.setVisibility(0);
        a(this.yB, i);
        a(this.yA, j);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  public void setInfo(afed paramafed)
  {
    this.a = paramafed;
    this.bXH = true;
    String str = paramafed.uin;
    int i = paramafed.cQE;
    setCountNum();
    if (this.bXH == true)
    {
      setVisibility(0);
      setOnClickListener(this);
      return;
    }
    setVisibility(8);
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.yE = ((ImageView)findViewById(2131362391));
    this.yD = ((ImageView)findViewById(2131362385));
    this.yA = ((ImageView)findViewById(2131362386));
    this.yB = ((ImageView)findViewById(2131362387));
    this.yC = ((ImageView)findViewById(2131362388));
    setVisibility(8);
    this.X = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.X.setDuration(500L);
    this.X.setAnimationListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboNavigateBar
 * JD-Core Version:    0.7.0.1
 */