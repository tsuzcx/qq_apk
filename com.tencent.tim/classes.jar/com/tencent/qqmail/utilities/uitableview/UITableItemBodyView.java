package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class UITableItemBodyView
  extends UITableItemBaseView
{
  private final LinearLayout.LayoutParams arrowLayoutParams = new LinearLayout.LayoutParams(-2, -2);
  protected ImageView arrowView;
  private TextView bodyView;
  private final LinearLayout.LayoutParams detailLayoutParams = new LinearLayout.LayoutParams(-1, -2);
  private LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
  private Resources resources = getResources();
  private LinearLayout titleLayout;
  private final LinearLayout.LayoutParams titleLayoutParmas = new LinearLayout.LayoutParams(-1, -2);
  private TextView titleView;
  private final LinearLayout.LayoutParams titleViewLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
  
  public UITableItemBodyView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    setCustomerLayoutParmas(this.layoutParams);
    setCustomerPadding(this.resources.getDimensionPixelSize(2131299391), this.resources.getDimensionPixelSize(2131299393), this.resources.getDimensionPixelSize(2131299392), this.resources.getDimensionPixelSize(2131299389));
  }
  
  private final ImageView initArrowView()
  {
    if (this.titleLayout == null) {
      initTitleLayout();
    }
    this.arrowView = new ImageView(this.context);
    this.arrowView.setImageResource(2130840745);
    this.arrowView.setDuplicateParentStateEnabled(true);
    this.arrowLayoutParams.gravity = 16;
    this.arrowLayoutParams.leftMargin = ((int)(8.0F * QMUIKit.DENSITY));
    this.arrowView.setLayoutParams(this.arrowLayoutParams);
    this.titleLayout.addView(this.arrowView);
    return this.arrowView;
  }
  
  private TextView initBodyView()
  {
    this.bodyView = new TextView(this.context);
    this.bodyView.setTextSize(2, 16.0F);
    this.bodyView.setGravity(3);
    this.bodyView.setDuplicateParentStateEnabled(true);
    this.bodyView.setEllipsize(TextUtils.TruncateAt.END);
    this.bodyView.setMaxLines(4);
    QMUIKit.setText(this.bodyView, "");
    this.bodyView.setTextColor(this.resources.getColor(2131167531));
    this.bodyView.setLayoutParams(this.detailLayoutParams);
    return this.bodyView;
  }
  
  private LinearLayout initTitleLayout()
  {
    this.titleLayout = new LinearLayout(this.context);
    this.titleLayout.setOrientation(0);
    this.titleLayout.setLayoutParams(this.titleLayoutParmas);
    return this.titleLayout;
  }
  
  private final TextView initTitleView()
  {
    if (this.titleLayout == null) {
      initTitleLayout();
    }
    this.titleView = new TextView(this.context);
    this.titleView.setTextSize(2, 18.0F);
    this.titleView.setDuplicateParentStateEnabled(true);
    this.titleView.setSingleLine();
    this.titleView.setEllipsize(TextUtils.TruncateAt.END);
    QMUIKit.setText(this.titleView, "");
    this.titleView.setTextColor(this.resources.getColor(2131167519));
    this.titleView.setLayoutParams(this.titleViewLayoutParams);
    this.titleLayout.addView(this.titleView);
    return this.titleView;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (this.titleLayout == null) {
      initTitleLayout();
    }
    if (this.bodyView == null) {
      initBodyView();
    }
    addRightView(this.titleLayout);
    addRightView(this.bodyView);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public TextView setBody(String paramString)
  {
    if (this.bodyView == null) {
      initBodyView();
    }
    this.bodyView.setText(paramString);
    return this.bodyView;
  }
  
  public void setTitle(int paramInt)
  {
    if (this.titleView == null) {
      initTitleView();
    }
    this.titleView.setText(this.resources.getString(paramInt));
  }
  
  public void showArrow(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.arrowView == null) {
        initArrowView();
      }
      this.arrowView.setVisibility(0);
      return;
    }
    if (this.arrowView != null) {
      this.arrowView.setVisibility(8);
    }
    this.arrowView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemBodyView
 * JD-Core Version:    0.7.0.1
 */