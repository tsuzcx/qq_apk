package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class PopularizeFolderSubItems
  extends LinearLayout
{
  private ImageView leftImageView;
  private ImageView rightImageView;
  private TextView textView;
  
  public PopularizeFolderSubItems(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PopularizeFolderSubItems(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setOrientation(0);
    int i = getResources().getDimensionPixelSize(2131297350);
    setPadding(i, 0, i, 0);
    this.leftImageView = new ImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.rightMargin = i;
    addView(this.leftImageView, localLayoutParams);
    this.textView = new TextView(paramContext);
    this.textView.setTextColor(getResources().getColor(2131167531));
    this.textView.setTextSize(0, getResources().getDimensionPixelSize(2131297620));
    this.textView.setSingleLine(true);
    this.textView.setEllipsize(TextUtils.TruncateAt.END);
    this.textView.setMaxHeight(getResources().getDimensionPixelSize(2131297351));
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    addView(this.textView, localLayoutParams);
    this.rightImageView = new ImageView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    paramContext.leftMargin = i;
    addView(this.rightImageView, paramContext);
  }
  
  public void reset()
  {
    this.leftImageView.setImageDrawable(null);
    this.rightImageView.setImageDrawable(null);
    this.textView.setText(null);
  }
  
  public void setImage(Drawable paramDrawable, int paramInt)
  {
    if (paramInt == 3) {
      this.rightImageView.setImageDrawable(paramDrawable);
    }
    while (paramInt != 2) {
      return;
    }
    this.leftImageView.setImageDrawable(paramDrawable);
  }
  
  public void setText(String paramString, int paramInt)
  {
    this.textView.setText(paramString);
    if (paramInt == 3) {
      this.textView.setGravity(5);
    }
    while (paramInt != 2) {
      return;
    }
    this.textView.setGravity(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeFolderSubItems
 * JD-Core Version:    0.7.0.1
 */