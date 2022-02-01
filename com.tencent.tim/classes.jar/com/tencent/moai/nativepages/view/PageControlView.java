package com.tencent.moai.nativepages.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Map;

public class PageControlView
  extends LinearLayout
{
  protected Context context;
  protected int count;
  protected ImageView imageView;
  protected Map<Integer, ImageView> map = new HashMap();
  protected int resIndicatorLayout = 2131559735;
  
  public PageControlView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PageControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void bindPage(int paramInt1, int paramInt2)
  {
    this.count = paramInt1;
    generatePageControl(paramInt2);
  }
  
  protected void generatePageControl(int paramInt)
  {
    removeAllViews();
    if (paramInt >= this.count) {
      return;
    }
    int j = this.count;
    int i = 0;
    label20:
    if (i < j)
    {
      this.imageView = null;
      if (paramInt != i) {
        break label155;
      }
      if (this.map.size() > i) {
        this.imageView = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.imageView == null)
      {
        this.imageView = ((ImageView)View.inflate(this.context, this.resIndicatorLayout, null).findViewById(2131372817));
        this.map.put(Integer.valueOf(i), this.imageView);
      }
      this.imageView.setSelected(true);
    }
    for (;;)
    {
      if (i == 0) {
        this.imageView.setPadding(0, 0, 0, 0);
      }
      addView(this.imageView);
      i += 1;
      break label20;
      break;
      label155:
      if (this.map.size() > i) {
        this.imageView = ((ImageView)this.map.get(Integer.valueOf(i)));
      }
      if (this.imageView == null)
      {
        this.imageView = ((ImageView)View.inflate(this.context, this.resIndicatorLayout, null).findViewById(2131372817));
        this.map.put(Integer.valueOf(i), this.imageView);
      }
      this.imageView.setSelected(false);
    }
  }
  
  public void setIndicatorLayoutRes(int paramInt)
  {
    this.resIndicatorLayout = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    generatePageControl(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.PageControlView
 * JD-Core Version:    0.7.0.1
 */