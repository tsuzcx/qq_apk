package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;

public class QMRadioGroup
  extends UITableView
{
  private UITableView.ClickListener clickListener = new QMRadioGroup.1(this);
  private boolean mHasChanged = false;
  private OnCheckedChangeListener mOnCheckedChangeListener;
  private int mSelectedID = 0;
  
  public QMRadioGroup(Context paramContext)
  {
    super(paramContext);
    setClickListener(this.clickListener);
  }
  
  private void select(boolean paramBoolean)
  {
    Object localObject = (UITableItemView)findViewWithTag(Integer.valueOf(this.mSelectedID));
    if (localObject != null)
    {
      localObject = ((UITableItemView)localObject).getTailImage();
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 0;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      return;
    }
  }
  
  public UITableItemView addItem(int paramInt1, int paramInt2)
  {
    return addItem(paramInt1, getResources().getString(paramInt2));
  }
  
  public UITableItemView addItem(int paramInt, String paramString)
  {
    paramString = super.addItem(paramString);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setTailImage(2130840882).setVisibility(4);
    return paramString;
  }
  
  public int getSelectedItem()
  {
    return this.mSelectedID;
  }
  
  public boolean hasChange()
  {
    return this.mHasChanged;
  }
  
  public void resetSelectdItem()
  {
    select(false);
    this.mSelectedID = 0;
    select(true);
  }
  
  public void setClickListenerWithoutSelector()
  {
    setClickListener(new QMRadioGroup.2(this));
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.mOnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setSelectedItem(int paramInt)
  {
    select(false);
    this.mSelectedID = paramInt;
    select(true);
  }
  
  public static abstract interface OnCheckedChangeListener
  {
    public abstract void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.QMRadioGroup
 * JD-Core Version:    0.7.0.1
 */