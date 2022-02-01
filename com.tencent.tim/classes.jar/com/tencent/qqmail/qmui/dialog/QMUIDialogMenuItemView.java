package com.tencent.qqmail.qmui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class QMUIDialogMenuItemView
  extends TextView
{
  private int index;
  private OnMenuItemViewClickListener onClickListener;
  
  public QMUIDialogMenuItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.index = paramInt;
  }
  
  public QMUIDialogMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QMUIDialogMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getMenuIndex()
  {
    return this.index;
  }
  
  public boolean performClick()
  {
    if (this.onClickListener != null) {
      this.onClickListener.onClick(this.index);
    }
    return super.performClick();
  }
  
  public void setMenuIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemViewClickListener paramOnMenuItemViewClickListener)
  {
    if (!isClickable()) {
      setClickable(true);
    }
    this.onClickListener = paramOnMenuItemViewClickListener;
  }
  
  public static abstract interface OnMenuItemViewClickListener
  {
    public abstract void onClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialogMenuItemView
 * JD-Core Version:    0.7.0.1
 */