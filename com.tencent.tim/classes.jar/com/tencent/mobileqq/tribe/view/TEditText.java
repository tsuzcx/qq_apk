package com.tencent.mobileqq.tribe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class TEditText
  extends EditText
{
  private a a;
  
  public TEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (this.a != null) {
      this.a.onSelectionChanged(paramInt1, paramInt2);
    }
  }
  
  public void setOnSelectionChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onSelectionChanged(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.view.TEditText
 * JD-Core Version:    0.7.0.1
 */