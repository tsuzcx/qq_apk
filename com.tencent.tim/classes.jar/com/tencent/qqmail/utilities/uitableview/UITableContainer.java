package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class UITableContainer
  extends LinearLayout
{
  private final LinearLayout.LayoutParams itemLayoutParams = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297616));
  private TextView mCaptionView;
  private TextView mDescriptionView;
  private boolean mIsBackgroundClickable;
  private List<UITableItemBaseView> mItemList;
  
  public UITableContainer(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    this.mIsBackgroundClickable = true;
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setMargins(0, getResources().getDimensionPixelSize(2131299376), 0, getResources().getDimensionPixelSize(2131299375));
    setLayoutParams(paramContext);
    this.mItemList = new ArrayList();
  }
  
  private void commitTableItem(UITableItemBaseView paramUITableItemBaseView)
  {
    paramUITableItemBaseView.setPadding(paramUITableItemBaseView.getCustomerPaddingLeft(), paramUITableItemBaseView.getCustomerPaddingTop(), paramUITableItemBaseView.getCustomerPaddingRight(), paramUITableItemBaseView.getCustomerPaddingBottom());
    LinearLayout.LayoutParams localLayoutParams = paramUITableItemBaseView.getCustomerLayoutParams();
    if (localLayoutParams != null)
    {
      addView(paramUITableItemBaseView, localLayoutParams);
      return;
    }
    addView(paramUITableItemBaseView, this.itemLayoutParams);
  }
  
  public void addItem(UITableItemBaseView paramUITableItemBaseView)
  {
    this.mItemList.add(paramUITableItemBaseView);
    requestLayout();
  }
  
  public void clear()
  {
    this.mItemList.clear();
    removeAllViews();
    this.mDescriptionView = null;
  }
  
  public UITableItemBaseView getItem(int paramInt)
  {
    if (getChildCount() > paramInt) {
      return (UITableItemBaseView)getChildAt(paramInt);
    }
    return null;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (this.mCaptionView != null) {
      addView(this.mCaptionView);
    }
    UITableItemBaseView localUITableItemBaseView;
    if (this.mItemList.size() > 1)
    {
      int i = 0;
      if (i < this.mItemList.size())
      {
        localUITableItemBaseView = (UITableItemBaseView)this.mItemList.get(i);
        if (i == 0) {
          if (this.mIsBackgroundClickable) {
            localUITableItemBaseView.setBackgroundResource(2130845610);
          }
        }
        for (;;)
        {
          commitTableItem(localUITableItemBaseView);
          i += 1;
          break;
          localUITableItemBaseView.setBackgroundResource(2130845599);
          continue;
          if (i < this.mItemList.size() - 1)
          {
            if (this.mIsBackgroundClickable) {
              localUITableItemBaseView.setBackgroundResource(2130845603);
            } else {
              localUITableItemBaseView.setBackgroundResource(2130845589);
            }
          }
          else if (this.mIsBackgroundClickable) {
            localUITableItemBaseView.setBackgroundResource(2130845603);
          } else {
            localUITableItemBaseView.setBackgroundResource(2130845589);
          }
        }
      }
    }
    else if (this.mItemList.size() == 1)
    {
      localUITableItemBaseView = (UITableItemBaseView)this.mItemList.get(0);
      if (!this.mIsBackgroundClickable) {
        break label242;
      }
      localUITableItemBaseView.setBackgroundResource(2130845610);
    }
    for (;;)
    {
      commitTableItem(localUITableItemBaseView);
      if (this.mDescriptionView != null) {
        addView(this.mDescriptionView);
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
      label242:
      localUITableItemBaseView.setBackgroundResource(2130845599);
    }
  }
  
  public void setBackgroundClickable(boolean paramBoolean)
  {
    this.mIsBackgroundClickable = paramBoolean;
  }
  
  public void setCaption(int paramInt)
  {
    this.mCaptionView = new TextView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(2131299394));
    this.mCaptionView.setLayoutParams(localLayoutParams);
    this.mCaptionView.setPadding(getResources().getDimensionPixelSize(2131299395), 0, 0, 0);
    this.mCaptionView.setTextColor(getResources().getColor(2131165419));
    this.mCaptionView.setTextSize(2, 17.0F);
    this.mCaptionView.setText(getResources().getString(paramInt));
  }
  
  public void setDescription(int paramInt)
  {
    if (this.mDescriptionView == null)
    {
      this.mDescriptionView = new TextView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.mDescriptionView.setLayoutParams(localLayoutParams);
      int i = getResources().getDimensionPixelSize(2131299394);
      int j = getResources().getDimensionPixelSize(2131299395);
      this.mDescriptionView.setPadding(j, i, j, 0);
      this.mDescriptionView.setTextColor(getResources().getColor(2131165860));
      this.mDescriptionView.setTextSize(2, 16.0F);
      this.mDescriptionView.setGravity(17);
      this.mDescriptionView.setLineSpacing(0.0F, 1.1F);
    }
    this.mDescriptionView.setText(getResources().getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableContainer
 * JD-Core Version:    0.7.0.1
 */