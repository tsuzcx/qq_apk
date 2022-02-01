package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;

public class UITableItemCheckBoxView
  extends UITableItemBaseView
{
  final LinearLayout.LayoutParams checkBoxLayoutParams = new LinearLayout.LayoutParams(-2, -2);
  private CheckBox checkBoxView;
  
  public UITableItemCheckBoxView(Context paramContext)
  {
    super(paramContext);
    setCustomerPadding(getResources().getDimensionPixelSize(2131299391), 0, getResources().getDimensionPixelSize(2131299392), 0);
  }
  
  private CheckBox initCheckBox()
  {
    this.checkBoxView = new CheckBox(this.context);
    Drawable localDrawable = getResources().getDrawable(2130850528);
    this.checkBoxView.setButtonDrawable(localDrawable);
    this.checkBoxView.setMinWidth(localDrawable.getIntrinsicWidth());
    this.checkBoxView.setDuplicateParentStateEnabled(true);
    this.checkBoxLayoutParams.gravity = 16;
    this.checkBoxView.setLayoutParams(this.checkBoxLayoutParams);
    return this.checkBoxView;
  }
  
  public boolean getChecked()
  {
    return this.checkBoxView.isChecked();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (this.checkBoxView == null) {
      initCheckBox();
    }
    addRightView(this.checkBoxView);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.checkBoxView == null) {
      initCheckBox();
    }
    this.checkBoxView.setChecked(paramBoolean);
  }
  
  public void setOnCheckChangeListener(OnCheckChangeListener paramOnCheckChangeListener)
  {
    if (paramOnCheckChangeListener != null) {
      this.checkBoxView.setOnClickListener(new UITableItemCheckBoxView.1(this, paramOnCheckChangeListener));
    }
  }
  
  public static abstract interface OnCheckChangeListener
  {
    public abstract void onChange(UITableItemCheckBoxView paramUITableItemCheckBoxView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemCheckBoxView
 * JD-Core Version:    0.7.0.1
 */