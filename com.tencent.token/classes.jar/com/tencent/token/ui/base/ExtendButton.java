package com.tencent.token.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ExtendButton
  extends Button
{
  private boolean a = true;
  
  public ExtendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchSetSelected(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a))
    {
      Object localObject = getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup)))
      {
        localObject = (ViewGroup)localObject;
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          if ((localView != null) && (localView != this)) {
            localView.setSelected(false);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ExtendButton
 * JD-Core Version:    0.7.0.1
 */