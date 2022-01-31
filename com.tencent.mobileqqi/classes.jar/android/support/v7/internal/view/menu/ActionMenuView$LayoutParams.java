package android.support.v7.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.widget.LinearLayout.LayoutParams;

public class ActionMenuView$LayoutParams
  extends LinearLayout.LayoutParams
{
  @ViewDebug.ExportedProperty
  public int cellsUsed;
  @ViewDebug.ExportedProperty
  public boolean expandable;
  public boolean expanded;
  @ViewDebug.ExportedProperty
  public int extraPixels;
  @ViewDebug.ExportedProperty
  public boolean isOverflowButton;
  @ViewDebug.ExportedProperty
  public boolean preventEdgeOffset;
  
  public ActionMenuView$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.isOverflowButton = false;
  }
  
  public ActionMenuView$LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt1, paramInt2);
    this.isOverflowButton = paramBoolean;
  }
  
  public ActionMenuView$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ActionMenuView$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.isOverflowButton = paramLayoutParams.isOverflowButton;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuView.LayoutParams
 * JD-Core Version:    0.7.0.1
 */