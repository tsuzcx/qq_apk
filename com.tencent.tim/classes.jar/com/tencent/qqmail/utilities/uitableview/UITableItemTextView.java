package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class UITableItemTextView
  extends UITableItemBaseView
{
  private static final int STYLE_BLUE = 2131167535;
  private static final int STYLE_GRAY = 2131167531;
  private final LinearLayout.LayoutParams detailLayoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0F);
  private TextView detailView;
  
  public UITableItemTextView(Context paramContext)
  {
    super(paramContext);
    setCustomerPadding(getResources().getDimensionPixelSize(2131299391), getResources().getDimensionPixelSize(2131299393), getResources().getDimensionPixelSize(2131299392), getResources().getDimensionPixelSize(2131299389));
  }
  
  private TextView initDetailView()
  {
    this.detailView = new TextView(this.context);
    this.detailView.setTextSize(2, 16.0F);
    this.detailView.setGravity(21);
    this.detailView.setDuplicateParentStateEnabled(true);
    this.detailView.setSingleLine();
    this.detailView.setEllipsize(TextUtils.TruncateAt.END);
    QMUIKit.setText(this.detailView, "");
    this.detailView.setLayoutParams(this.detailLayoutParams);
    return this.detailView;
  }
  
  public TextView getDetailView()
  {
    return this.detailView;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (this.detailView == null) {
      initDetailView();
    }
    addRightView(this.detailView);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setTextWithBlueStyle(String paramString)
  {
    if (this.detailView == null) {
      initDetailView();
    }
    int i = getResources().getColor(STYLE_BLUE);
    this.detailView.setTextColor(i);
    this.detailView.setText(paramString);
  }
  
  public void setTextWithGrayStyle(String paramString)
  {
    if (this.detailView == null) {
      initDetailView();
    }
    int i = getResources().getColor(STYLE_GRAY);
    this.detailView.setTextColor(i);
    this.detailView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemTextView
 * JD-Core Version:    0.7.0.1
 */