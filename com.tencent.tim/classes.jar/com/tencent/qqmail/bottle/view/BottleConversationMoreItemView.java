package com.tencent.qqmail.bottle.view;

import android.content.Context;
import android.content.res.Resources;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMLoading;

public class BottleConversationMoreItemView
  extends LinearLayout
{
  private TextView loadMoreTextView;
  private QMLoading loadingView;
  
  public BottleConversationMoreItemView(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new AbsListView.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(2131296694)));
    setBackgroundResource(2130845612);
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    setOrientation(0);
    setGravity(17);
    this.loadingView = new QMLoading(paramContext, QMLoading.SIZE_SMALL);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    addView(this.loadingView, localLayoutParams);
    this.loadMoreTextView = new TextView(paramContext);
    this.loadMoreTextView.setText("正在加载...");
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.leftMargin = 5;
    addView(this.loadMoreTextView, paramContext);
    new LinearLayout.LayoutParams(-2, -2).gravity = 17;
  }
  
  public void showError(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.loadMoreTextView.setText(2131695376);
      this.loadMoreTextView.setVisibility(0);
      this.loadingView.setVisibility(8);
      return;
    }
    this.loadMoreTextView.setText(2131695375);
    this.loadMoreTextView.setVisibility(8);
    this.loadingView.setVisibility(0);
  }
  
  public void showLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.loadMoreTextView.setVisibility(8);
      this.loadingView.setVisibility(0);
      return;
    }
    this.loadMoreTextView.setVisibility(0);
    this.loadingView.setVisibility(8);
  }
  
  public void showTips(int paramInt)
  {
    this.loadMoreTextView.setText(paramInt);
    this.loadMoreTextView.setVisibility(0);
    this.loadingView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleConversationMoreItemView
 * JD-Core Version:    0.7.0.1
 */