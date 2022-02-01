package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

public class CalendarTableItemView
  extends UITableItemView
{
  private CalColorView mCalColorView;
  private int mColor;
  private Context mContext;
  private boolean mIsLinkItem;
  private ImageView mLeftCheckBox;
  private RelativeLayout mLeftContainer;
  private int mLeftWidth;
  private View mPlaceView;
  
  public CalendarTableItemView(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    super(paramContext, paramString);
    this.mIsLinkItem = paramBoolean;
    this.mContext = paramContext;
    this.mLeftWidth = paramContext.getResources().getDimensionPixelSize(2131296761);
    if (this.mIsLinkItem) {
      initLinkItemLeft();
    }
    for (;;)
    {
      hideArrow();
      return;
      this.mColor = paramInt;
      initCheckLeft();
    }
  }
  
  private void initCheckLeft()
  {
    this.mLeftContainer = new RelativeLayout(this.mContext);
    this.mLeftContainer.setLayoutParams(new ViewGroup.LayoutParams(this.mLeftWidth, -1));
    this.mLeftCheckBox = new ImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(9, -1);
    this.mLeftCheckBox.setImageResource(2130840883);
    this.mLeftCheckBox.setLayoutParams(localLayoutParams);
    this.mLeftCheckBox.setVisibility(4);
    this.mLeftContainer.addView(this.mLeftCheckBox);
    this.mCalColorView = new CalColorView(this.mContext, this.mColor);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131296762);
    this.mCalColorView.setLayoutParams(localLayoutParams);
    this.mLeftContainer.addView(this.mCalColorView);
  }
  
  private void initLinkItemLeft()
  {
    getTitleView().setTextColor(getResources().getColor(2131166580));
    if (this.mPlaceView == null)
    {
      this.mPlaceView = new View(this.mContext);
      this.mPlaceView.setLayoutParams(new ViewGroup.LayoutParams(this.mLeftWidth, -1));
    }
  }
  
  public void drawViews()
  {
    super.drawViews();
    if ((this.mIsLinkItem) && (this.mPlaceView != null)) {
      addView(this.mPlaceView, 0);
    }
    while (this.mLeftContainer == null) {
      return;
    }
    addView(this.mLeftContainer, 0);
  }
  
  public CharSequence getContentDescription()
  {
    Object localObject = super.getContentDescription();
    if ((localObject == null) || (this.mLeftCheckBox == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(localObject);
    if (this.mLeftCheckBox.getVisibility() == 0) {}
    for (localObject = getContext().getString(2131720855);; localObject = "") {
      return (String)localObject;
    }
  }
  
  public boolean getIsLeftChecked()
  {
    return (this.mLeftCheckBox != null) && (this.mLeftCheckBox.getVisibility() == 0);
  }
  
  public void setIsLeftChecked(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.mLeftCheckBox != null)
    {
      localImageView = this.mLeftCheckBox;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalendarTableItemView
 * JD-Core Version:    0.7.0.1
 */