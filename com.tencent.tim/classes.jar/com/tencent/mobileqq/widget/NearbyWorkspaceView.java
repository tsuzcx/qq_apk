package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class NearbyWorkspaceView
  extends WorkSpaceView
{
  private int egL = 0;
  
  public NearbyWorkspaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int m = getChildCount();
    float f = getScrollX() / getWidth();
    int i;
    int j;
    if ((f < 0.0F) && (this.cZp))
    {
      i = 0;
      j = m - 1;
    }
    for (;;)
    {
      View localView;
      if (m > 1)
      {
        paramCanvas = (View)getChildAt(j).getTag();
        localView = (View)getChildAt(i).getTag();
        if ((paramCanvas != null) && (localView != null)) {
          break label120;
        }
      }
      label120:
      Rect localRect2;
      label327:
      do
      {
        for (;;)
        {
          return;
          i = (int)f % m;
          j = i + 1;
          if (!this.cZp) {
            break label361;
          }
          k = j % m;
          j = i;
          i = k;
          break;
          Rect localRect1 = new Rect();
          localRect2 = new Rect();
          paramCanvas.getGlobalVisibleRect(localRect1);
          localView.getGlobalVisibleRect(localRect2);
          k = getWidth() - (getScrollX() + getWidth()) % getWidth();
          if (this.egL == j) {
            if ((localRect1.left < 0) || (k < localRect1.right))
            {
              this.egL = -1;
              paramCanvas.setVisibility(4);
            }
          }
          while (this.egL == -1)
          {
            if ((localRect1.left < 0) || (k < localRect1.right)) {
              break label327;
            }
            this.egL = j;
            paramCanvas.setVisibility(0);
            return;
            if (this.egL == i)
            {
              if ((k > localRect2.left) || (getWidth() < localRect2.right))
              {
                this.egL = -1;
                localView.setVisibility(4);
              }
            }
            else if (this.egL != -1)
            {
              ((View)getChildAt(this.egL).getTag()).setVisibility(4);
              this.egL = -1;
            }
          }
        }
      } while ((k > localRect2.left) || (getWidth() < localRect2.right));
      this.egL = i;
      localView.setVisibility(0);
      return;
      label361:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public void removeAllViews()
  {
    View localView = getChildAt(this.egL);
    if ((localView != null) && (localView.getTag() != null)) {
      ((View)localView.getTag()).setVisibility(4);
    }
    super.removeAllViews();
  }
  
  public void setVisibility(int paramInt)
  {
    View localView = getChildAt(this.egL);
    if ((localView != null) && (localView.getTag() != null))
    {
      localView = (View)localView.getTag();
      if ((paramInt != 8) && (paramInt != 4)) {
        break label50;
      }
      localView.setVisibility(4);
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      label50:
      localView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NearbyWorkspaceView
 * JD-Core Version:    0.7.0.1
 */