package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import wja;

public class WatchPanelView
  extends RelativeLayout
  implements View.OnClickListener
{
  ImageView DY;
  TextView ZW;
  TextView ZX;
  int deT;
  PatchedButton h;
  URLDrawable k;
  public View.OnClickListener mOnClickListener;
  
  public WatchPanelView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131561209, this, true);
    setBackgroundResource(2130838051);
    this.DY = ((ImageView)findViewById(2131379974));
    this.ZW = ((TextView)findViewById(2131379977));
    this.h = ((PatchedButton)findViewById(2131379975));
    this.ZX = ((TextView)findViewById(2131379976));
    this.h.setOnClickListener(this);
    this.deT = wja.dp2px(39.0F, getResources());
  }
  
  public void destroy()
  {
    if (this.k != null)
    {
      this.k.setDecodeHandler(null);
      this.k = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mOnClickListener != null) {
      this.mOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.together.ui.WatchPanelView
 * JD-Core Version:    0.7.0.1
 */