package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class UITableItemContentView
  extends UITableItemBaseView
{
  private TextView contentView;
  private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
  private LinearLayout.LayoutParams mItemLayout = new LinearLayout.LayoutParams(-1, -2);
  private TextView subjectView;
  
  public UITableItemContentView(Context paramContext)
  {
    super(paramContext);
    setGravity(16);
    setCustomerLayoutParmas(this.layoutParams);
    setOrientation(1);
    setCustomerPadding(getResources().getDimensionPixelSize(2131299391), getResources().getDimensionPixelSize(2131299393), getResources().getDimensionPixelSize(2131299392), getResources().getDimensionPixelSize(2131299389));
  }
  
  private TextView initContentView()
  {
    this.contentView = new TextView(this.context);
    this.contentView.setTextSize(2, 15.0F);
    this.contentView.setGravity(16);
    this.contentView.setDuplicateParentStateEnabled(true);
    this.contentView.setEllipsize(TextUtils.TruncateAt.END);
    this.contentView.setTextColor(getResources().getColor(2131167531));
    this.contentView.setLayoutParams(this.mItemLayout);
    return this.contentView;
  }
  
  private TextView initSubjectView()
  {
    this.subjectView = new TextView(this.context);
    this.subjectView.setTextSize(2, 21.0F);
    this.subjectView.setGravity(16);
    this.subjectView.setDuplicateParentStateEnabled(true);
    this.subjectView.setEllipsize(TextUtils.TruncateAt.END);
    this.subjectView.setTextColor(getResources().getColor(2131167519));
    this.subjectView.setLayoutParams(this.mItemLayout);
    return this.subjectView;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (this.subjectView != null) {
      addView(this.subjectView, this.mItemLayout);
    }
    if (this.contentView != null) {
      addView(this.contentView, this.mItemLayout);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setContent(String paramString)
  {
    if (this.contentView == null) {
      initContentView();
    }
    QMUIKit.setText(this.contentView, paramString);
  }
  
  public void setSubject(String paramString)
  {
    if (this.subjectView == null) {
      initSubjectView();
    }
    QMUIKit.setText(this.subjectView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemContentView
 * JD-Core Version:    0.7.0.1
 */