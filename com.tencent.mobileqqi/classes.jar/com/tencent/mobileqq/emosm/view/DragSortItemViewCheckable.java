package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;

public class DragSortItemViewCheckable
  extends DragSortItemView
  implements Checkable
{
  public DragSortItemViewCheckable(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean isChecked()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      return ((Checkable)localView).isChecked();
    }
    return false;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).setChecked(paramBoolean);
    }
  }
  
  public void toggle()
  {
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).toggle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortItemViewCheckable
 * JD-Core Version:    0.7.0.1
 */