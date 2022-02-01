package com.tencent.qqmail.utilities.uitableview;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class UITableItemImageView
  extends UITableItemBaseView
{
  final LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(-2, -2);
  private ImageView imageView;
  
  public UITableItemImageView(Context paramContext)
  {
    super(paramContext);
    setCustomerPadding(getResources().getDimensionPixelSize(2131299391), getResources().getDimensionPixelSize(2131299393), getResources().getDimensionPixelSize(2131299392), getResources().getDimensionPixelSize(2131299389));
  }
  
  private ImageView initImageView()
  {
    this.imageView = new ImageView(this.context);
    this.imageView.setImageResource(2130850527);
    this.imageView.setDuplicateParentStateEnabled(true);
    this.imageLayoutParams.gravity = 16;
    this.imageLayoutParams.leftMargin = ((int)(8.0F * QMUIKit.DENSITY));
    this.imageView.setLayoutParams(this.imageLayoutParams);
    return this.imageView;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    removeAllViews();
    if (this.imageView == null) {
      initImageView();
    }
    addRightView(this.imageView);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setImage(int paramInt)
  {
    if (this.imageView == null) {
      initImageView();
    }
    this.imageView.setImageResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableItemImageView
 * JD-Core Version:    0.7.0.1
 */