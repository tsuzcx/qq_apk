package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;

public abstract class UITableItemBaseView
  extends LinearLayout
{
  private final LinearLayout.LayoutParams arrowLayoutParams = new LinearLayout.LayoutParams(-2, -1);
  protected ImageView arrowView;
  protected Context context;
  private LayoutInflater inflater;
  private View layout;
  protected int paddingBottom;
  protected int paddingLeft;
  protected int paddingRight;
  protected int paddingTop;
  protected LinearLayout.LayoutParams params;
  protected ArrayList<View> rightViews;
  private final LinearLayout.LayoutParams titleLayoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0F);
  protected TextView titleView;
  
  public UITableItemBaseView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.inflater = LayoutInflater.from(paramContext);
    this.rightViews = new ArrayList();
  }
  
  private final ImageView initArrowView()
  {
    this.arrowView = new ImageView(this.context);
    this.arrowView.setImageResource(2130840745);
    this.arrowView.setDuplicateParentStateEnabled(true);
    this.arrowLayoutParams.gravity = 16;
    this.arrowLayoutParams.leftMargin = ((int)(8.0F * QMUIKit.DENSITY));
    this.arrowView.setLayoutParams(this.arrowLayoutParams);
    return this.arrowView;
  }
  
  private final TextView initTitleView()
  {
    this.titleView = new TextView(this.context);
    this.titleView.setTextSize(2, 18.0F);
    this.titleView.setGravity(16);
    this.titleView.setDuplicateParentStateEnabled(true);
    this.titleView.setSingleLine();
    this.titleView.setEllipsize(TextUtils.TruncateAt.END);
    QMUIKit.setText(this.titleView, "");
    this.titleView.setTextColor(getResources().getColor(2131167519));
    this.titleView.setLayoutParams(this.titleLayoutParams);
    return this.titleView;
  }
  
  public void addRightView(int paramInt)
  {
    View localView = this.inflater.inflate(paramInt, null);
    if (localView != null) {
      this.rightViews.add(localView);
    }
  }
  
  public void addRightView(View paramView)
  {
    if ((paramView != null) && (!this.rightViews.contains(paramView))) {
      this.rightViews.add(paramView);
    }
  }
  
  public LinearLayout.LayoutParams getCustomerLayoutParams()
  {
    return this.params;
  }
  
  public int getCustomerPaddingBottom()
  {
    return this.paddingBottom;
  }
  
  public int getCustomerPaddingLeft()
  {
    return this.paddingLeft;
  }
  
  public int getCustomerPaddingRight()
  {
    return this.paddingRight;
  }
  
  public int getCustomerPaddingTop()
  {
    return this.paddingTop;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.layout != null) {
      addView(this.layout);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      if (this.titleView != null) {
        addView(this.titleView);
      }
      if ((this.rightViews != null) && (this.rightViews.size() > 0))
      {
        int i = 0;
        while (i < this.rightViews.size())
        {
          addView((View)this.rightViews.get(i));
          i += 1;
        }
      }
      if (this.arrowView != null) {
        addView(this.arrowView);
      }
    }
  }
  
  public void setCustomerLayoutParmas(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.params = paramLayoutParams;
  }
  
  public void setCustomerPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.paddingLeft = paramInt1;
    this.paddingTop = paramInt2;
    this.paddingRight = paramInt3;
    this.paddingBottom = paramInt4;
  }
  
  public void setCustomerPaddingBottom(int paramInt)
  {
    this.paddingBottom = paramInt;
  }
  
  public void setCustomerPaddingLeft(int paramInt)
  {
    this.paddingLeft = paramInt;
  }
  
  public void setCustomerPaddingRight(int paramInt)
  {
    this.paddingRight = paramInt;
  }
  
  public void setCustomerPaddingTop(int paramInt)
  {
    this.paddingTop = paramInt;
  }
  
  public View setLayoutFromXml(int paramInt)
  {
    this.layout = this.inflater.inflate(paramInt, null);
    this.layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    return this.layout;
  }
  
  public void setTitle(int paramInt)
  {
    if (this.titleView == null) {
      initTitleView();
    }
    QMUIKit.setText(this.titleView, getResources().getString(paramInt));
  }
  
  public void setTitle(String paramString)
  {
    if (this.titleView == null) {
      initTitleView();
    }
    QMUIKit.setText(this.titleView, paramString);
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
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemBaseView
 * JD-Core Version:    0.7.0.1
 */