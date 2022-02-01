package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import wja;

public class PAHighLightImageView
  extends PAImageView
{
  private a a;
  private Context context;
  
  public PAHighLightImageView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.a = new a(this, paramContext);
    setOnTouchListener(this.a);
  }
  
  public PAHighLightImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.a = new a(this, paramContext);
    setOnTouchListener(this.a);
  }
  
  public PAHighLightImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    this.a = new a(this, paramContext);
    setOnTouchListener(this.a);
  }
  
  public void P(Context paramContext, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if ((localViewGroup != null) && (localViewGroup.findViewById(2131373783) == null))
    {
      View localView = new View(paramContext);
      localView.setId(2131373783);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(Color.argb(77, 0, 0, 0));
      if (paramBoolean) {
        localGradientDrawable.setCornerRadius(wja.dp2px(5.0F, paramContext.getResources()));
      }
      localView.setBackgroundDrawable(localGradientDrawable);
      localViewGroup.addView(localView, new ViewGroup.LayoutParams(getLayoutParams()));
    }
  }
  
  public void dIv()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null)
    {
      View localView = localViewGroup.findViewById(2131373783);
      if (localView != null) {
        localViewGroup.removeView(localView);
      }
    }
  }
  
  public void h(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      dIv();
    }
  }
  
  public static class a
    implements View.OnTouchListener
  {
    PAHighLightImageView a;
    Context context;
    
    public a(PAHighLightImageView paramPAHighLightImageView, Context paramContext)
    {
      this.a = paramPAHighLightImageView;
      this.context = paramContext;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAHighLightImageView", 2, "onTouch is called,action is:" + paramMotionEvent.getAction());
      }
      paramView = this.a.getTag(2131373782);
      if (paramView == null) {}
      label100:
      do
      {
        return false;
        if (paramView.equals(Integer.valueOf(1))) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramMotionEvent.getAction() != 0) {
            break label100;
          }
          this.a.P(this.context, bool);
          return false;
          if (!paramView.equals(Integer.valueOf(2))) {
            break;
          }
        }
      } while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1));
      this.a.dIv();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PAHighLightImageView
 * JD-Core Version:    0.7.0.1
 */