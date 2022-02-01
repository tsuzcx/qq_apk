package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class QMCheckBox
  extends UITableView
{
  private UITableView.ClickListener clickListener = new QMCheckBox.1(this);
  private boolean mHasChanged = false;
  private List<Integer> mNotSelectedID = new ArrayList();
  private OnCheckedChangeListener mOnCheckedChangeListener;
  private List<Integer> mSelectedID = new ArrayList();
  
  public QMCheckBox(Context paramContext)
  {
    super(paramContext);
    setClickListener(this.clickListener);
  }
  
  private void select(boolean paramBoolean, int paramInt)
  {
    Object localObject = (UITableItemView)findViewWithTag(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((UITableItemView)localObject).getTailImage();
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (paramInt = 0;; paramInt = 4)
    {
      ((ImageView)localObject).setVisibility(paramInt);
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
  
  public void addSelectedItem(int paramInt)
  {
    if (this.mNotSelectedID.contains(Integer.valueOf(paramInt))) {
      this.mNotSelectedID.remove(this.mNotSelectedID.indexOf(Integer.valueOf(paramInt)));
    }
    this.mSelectedID.add(Integer.valueOf(paramInt));
    select(true, paramInt);
  }
  
  public void deleteSelectedItem(int paramInt)
  {
    if (this.mSelectedID.contains(Integer.valueOf(paramInt))) {
      this.mSelectedID.remove(this.mSelectedID.indexOf(Integer.valueOf(paramInt)));
    }
    this.mNotSelectedID.add(Integer.valueOf(paramInt));
    select(false, paramInt);
  }
  
  public List<Integer> getNotSelectItem()
  {
    return this.mNotSelectedID;
  }
  
  public List<Integer> getSelectedItem()
  {
    return this.mSelectedID;
  }
  
  public boolean hasChange()
  {
    return this.mHasChanged;
  }
  
  public void setHasChange(boolean paramBoolean)
  {
    this.mHasChanged = paramBoolean;
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.mOnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public static abstract interface OnCheckedChangeListener
  {
    public abstract void onCheckedChanged(QMCheckBox paramQMCheckBox, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.QMCheckBox
 * JD-Core Version:    0.7.0.1
 */