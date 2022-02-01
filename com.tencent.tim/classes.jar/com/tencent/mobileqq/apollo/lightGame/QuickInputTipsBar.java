package com.tencent.mobileqq.apollo.lightGame;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import wja;

public class QuickInputTipsBar
  extends LinearLayout
  implements View.OnClickListener
{
  private a a;
  
  public QuickInputTipsBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    super.setOrientation(0);
    super.setGravity(16);
  }
  
  public void cDn()
  {
    super.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setFillAfter(true);
    super.startAnimation(localAlphaAnimation);
  }
  
  public void hY(List<b> paramList)
  {
    super.clearAnimation();
    super.removeAllViews();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject1 = (b)paramList.get(i);
        if (localObject1 == null)
        {
          i += 1;
        }
        else
        {
          Object localObject2 = new LinearLayout(getContext());
          ((LinearLayout)localObject2).setBackgroundResource(2130838539);
          ((LinearLayout)localObject2).setGravity(17);
          localObject2 = new TextView(getContext());
          ((TextView)localObject2).setGravity(17);
          ((TextView)localObject2).setTextColor(-6908266);
          ((TextView)localObject2).setTextSize(14.0F);
          ((TextView)localObject2).setText(((b)localObject1).mText);
          ((TextView)localObject2).setTag(localObject1);
          ((TextView)localObject2).setOnClickListener(this);
          ((TextView)localObject2).setBackgroundResource(2130838539);
          int j = wja.dp2px(10.0F, getContext().getResources());
          ((TextView)localObject2).setPadding(j, 0, j, 0);
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          if (i == 0) {}
          for (((LinearLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(8.0F, getContext().getResources());; ((LinearLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(5.0F, getContext().getResources()))
          {
            ((LinearLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(5.0F, getContext().getResources());
            ((LinearLayout.LayoutParams)localObject1).bottomMargin = wja.dp2px(2.0F, getContext().getResources());
            super.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            break;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (((localObject instanceof b)) && (this.a != null)) {
      this.a.a((b)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setTipsClickListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(QuickInputTipsBar.b paramb);
  }
  
  public static class b
  {
    public int mId;
    public CharSequence mText;
    public int mTipsType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.QuickInputTipsBar
 * JD-Core Version:    0.7.0.1
 */