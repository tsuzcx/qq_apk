package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

public class QMListItemView
  extends RelativeLayout
  implements QMListItemViewer
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  protected Drawable backgroundDrawable = null;
  protected CheckBox checkBox;
  protected ImageView chevron;
  protected Drawable editModeBackgroundDrawable;
  protected boolean isChecked = false;
  protected boolean isInEditMode = false;
  protected int itemType = 0;
  protected int mDividerBottomInsetLeft = 0;
  protected int mDividerTopInsetLeft = 0;
  private boolean mNeedDrawDividerBottom = true;
  private boolean mNeedDrawDividerTop = false;
  private Paint mPaint;
  
  public QMListItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.editModeBackgroundDrawable = paramContext.getResources().getDrawable(2130845612);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842964 });
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMListItemView);
    this.backgroundDrawable = localTypedArray.getDrawable(0);
    int j = paramAttributeSet.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramAttributeSet.getIndex(i);
      if (k == R.styleable.QMListItemView_itemType) {
        this.itemType = paramAttributeSet.getInt(R.styleable.QMListItemView_itemType, 0);
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == R.styleable.QMListItemView_editModeBackground)
        {
          Drawable localDrawable = paramAttributeSet.getDrawable(R.styleable.QMListItemView_editModeBackground);
          if (localDrawable != null) {
            this.editModeBackgroundDrawable = localDrawable;
          }
        }
      }
    }
    localTypedArray.recycle();
    paramAttributeSet.recycle();
    this.mPaint = new Paint();
    this.mPaint.setColor(getContext().getResources().getColor(2131165952));
    this.mPaint.setStrokeWidth(getContext().getResources().getDimension(2131297594));
    i = paramContext.getResources().getDimensionPixelSize(2131297032);
    this.mDividerTopInsetLeft = i;
    this.mDividerBottomInsetLeft = i;
  }
  
  public static void setItemPressedSafty(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof QMListItemView))
    {
      ((QMListItemView)paramView).setPressedCustom(paramBoolean);
      return;
    }
    Log.w("QMListItemView#setItemPressedSafty", "item view not implemented for class QMListItemView");
  }
  
  public static void setItemToEditModeSafty(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof QMListItemView))
    {
      ((QMListItemView)paramView).setItemToEditMode();
      return;
    }
    Log.w("QMListItemView#setItemStyleToEditingSafty", "item view not implemented for class QMListItemView");
  }
  
  public static void setItemToNormalModeSafty(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof QMListItemView))
    {
      ((QMListItemView)paramView).setItemToNormalMode();
      return;
    }
    Log.w("QMListItemView#setItemStyleToNormalSafty", "item view not implemented for class QMListItemView");
  }
  
  public void bindItemCheckBox(CheckBox paramCheckBox)
  {
    if (paramCheckBox != null) {
      this.checkBox = paramCheckBox;
    }
  }
  
  public void bindItemChevron(ImageView paramImageView)
  {
    if (paramImageView != null) {
      this.chevron = paramImageView;
    }
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isInEditMode()
  {
    return this.isInEditMode;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(CHECKED_STATE_SET.length + paramInt);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    QMUIHelper.drawDivider(this.mNeedDrawDividerTop, this.mNeedDrawDividerBottom, paramCanvas, this.mPaint, this.mDividerTopInsetLeft, this.mDividerBottomInsetLeft);
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.isChecked != paramBoolean)
    {
      this.isChecked = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setDrawDivider(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mNeedDrawDividerTop = paramBoolean1;
    this.mNeedDrawDividerBottom = paramBoolean2;
  }
  
  public void setEditModeBackgroundDrawable(Drawable paramDrawable)
  {
    this.editModeBackgroundDrawable = paramDrawable;
    if (this.isInEditMode) {
      QMUIHelper.setBackground(this, paramDrawable);
    }
  }
  
  public void setItemToEditMode()
  {
    QMUIHelper.setBackground(this, this.editModeBackgroundDrawable);
    if (this.chevron != null)
    {
      this.chevron.setAlpha(76);
      this.chevron.setImageResource(2130840745);
    }
    this.isInEditMode = true;
  }
  
  public void setItemToNormalMode()
  {
    this.isInEditMode = false;
    QMUIHelper.setBackground(this, this.backgroundDrawable);
    if (this.isChecked) {
      setChecked(false);
    }
    if (this.chevron != null)
    {
      this.chevron.setAlpha(255);
      this.chevron.setImageResource(2130840745);
    }
  }
  
  public void setPressedCustom(boolean paramBoolean)
  {
    setSelected(paramBoolean);
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
  
  public void updateDividerInsetLeft(int paramInt1, int paramInt2)
  {
    this.mDividerTopInsetLeft = paramInt1;
    this.mDividerBottomInsetLeft = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMListItemView
 * JD-Core Version:    0.7.0.1
 */