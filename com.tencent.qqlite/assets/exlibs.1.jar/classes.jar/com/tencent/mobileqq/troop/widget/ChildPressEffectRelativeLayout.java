package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChildPressEffectRelativeLayout
  extends RelativeLayout
{
  List a = new ArrayList();
  
  public ChildPressEffectRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChildPressEffectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ChildPressEffectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt)
  {
    View localView = findViewById(paramInt);
    if (localView != null) {
      this.a.add(localView);
    }
  }
  
  protected void drawableStateChanged()
  {
    if (isPressed())
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setPressed(true);
      }
    }
    super.drawableStateChanged();
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setPressed(false);
      }
    }
    super.setPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ChildPressEffectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */