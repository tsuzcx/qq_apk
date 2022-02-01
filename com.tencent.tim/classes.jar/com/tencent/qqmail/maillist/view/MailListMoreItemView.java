package com.tencent.qqmail.maillist.view;

import android.content.Context;
import android.content.res.Resources;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMLoading;

public class MailListMoreItemView
  extends RelativeLayout
{
  private TextView loadMoreTextView;
  private QMLoading loadingView;
  
  public MailListMoreItemView(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new AbsListView.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(2131297677)));
    setBackgroundResource(2130845612);
    initViews(paramContext);
  }
  
  private void initViews(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.loadMoreTextView = new TextView(paramContext);
    this.loadMoreTextView.setTextColor(paramContext.getResources().getColorStateList(2131165482));
    this.loadMoreTextView.setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131297623));
    this.loadMoreTextView.setText(2131695375);
    this.loadMoreTextView.setDuplicateParentStateEnabled(true);
    this.loadMoreTextView.setVisibility(8);
    addView(this.loadMoreTextView, localLayoutParams);
    this.loadingView = new QMLoading(paramContext, QMLoading.SIZE_SMALL);
    addView(this.loadingView, localLayoutParams);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.view.MailListMoreItemView
 * JD-Core Version:    0.7.0.1
 */