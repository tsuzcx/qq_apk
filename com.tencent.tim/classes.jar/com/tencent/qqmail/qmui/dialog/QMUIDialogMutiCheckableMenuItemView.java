package com.tencent.qqmail.qmui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMUIDialogMutiCheckableMenuItemView
  extends QMUIDialogMenuItemView
  implements Checkable
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] NORMAL_STATE_SET = new int[0];
  private boolean isChecked;
  private int mBasePaddingRight = -1;
  private Drawable mCheckMarkDrawable;
  private int mCheckMarkDrawablePadding;
  private int mCheckMarkWidth;
  private int mPaddingRight;
  
  public QMUIDialogMutiCheckableMenuItemView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    init();
  }
  
  public QMUIDialogMutiCheckableMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QMUIDialogMutiCheckableMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.isChecked = false;
    this.mCheckMarkDrawable = getResources().getDrawable(2130845602);
    this.mCheckMarkDrawablePadding = QMUIKit.dpToPx(6);
    updatePadding();
  }
  
  private void updateCheckMarkDrawableState(boolean paramBoolean)
  {
    Drawable localDrawable = this.mCheckMarkDrawable;
    if (paramBoolean) {}
    for (int[] arrayOfInt = CHECKED_STATE_SET;; arrayOfInt = NORMAL_STATE_SET)
    {
      localDrawable.setState(arrayOfInt);
      invalidate();
      return;
    }
  }
  
  private void updatePadding()
  {
    if (this.mBasePaddingRight == -1) {
      this.mBasePaddingRight = getPaddingLeft();
    }
    int i;
    if (this.mCheckMarkDrawable == null)
    {
      i = this.mBasePaddingRight;
      if (this.mBasePaddingRight == i) {
        break label98;
      }
    }
    label98:
    for (int j = 1;; j = 0)
    {
      this.mPaddingRight = i;
      if (j != 0)
      {
        setPadding(getPaddingLeft(), getPaddingTop(), i, getPaddingBottom());
        requestLayout();
      }
      return;
      this.mCheckMarkWidth = this.mCheckMarkDrawable.getIntrinsicWidth();
      i = this.mCheckMarkWidth + this.mBasePaddingRight + this.mCheckMarkDrawablePadding;
      break;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mCheckMarkDrawable != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.mCheckMarkDrawable.setState(arrayOfInt);
      invalidate();
    }
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.mCheckMarkDrawable;
    int k;
    int j;
    int i;
    if (localDrawable != null)
    {
      k = getGravity();
      j = localDrawable.getIntrinsicHeight();
      i = 0;
      switch (k & 0x70)
      {
      }
    }
    for (;;)
    {
      k = getWidth() - this.mBasePaddingRight;
      localDrawable.setBounds(k - this.mCheckMarkWidth, i, k, i + j);
      localDrawable.draw(paramCanvas);
      return;
      i = getHeight() - j;
      continue;
      i = (getHeight() - j) / 2;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.isChecked != paramBoolean)
    {
      this.isChecked = paramBoolean;
      updateCheckMarkDrawableState(this.isChecked);
    }
  }
  
  public void toggle()
  {
    if (!this.isChecked) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialogMutiCheckableMenuItemView
 * JD-Core Version:    0.7.0.1
 */