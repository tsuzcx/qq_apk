package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QCircleCertifiedDialogView
  extends RelativeLayout
  implements View.OnClickListener
{
  private URLImageView Q;
  private URLImageView R;
  private a a;
  private ImageView mc;
  private ImageView md;
  
  public QCircleCertifiedDialogView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCertifiedDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCertifiedDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131560878, this);
    setBackgroundDrawable(getResources().getDrawable(2130844765));
    this.Q = ((URLImageView)findViewById(2131381908));
    this.R = ((URLImageView)findViewById(2131381909));
    this.mc = ((ImageView)findViewById(2131369693));
    this.md = ((ImageView)findViewById(2131369694));
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.mc.setOnClickListener(this);
    this.md.setOnClickListener(this);
    this.Q.setBackgroundURL("https://qzonestyle.gtimg.cn/aoi/sola/20200303153157_RUD3Zf0Pyz.png");
    this.R.setBackgroundURL("https://qzonestyle.gtimg.cn/aoi/sola/20200303153157_OASs9ECpAn.png");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a != null)
      {
        this.a.bhY();
        continue;
        if (this.a != null) {
          this.a.bhZ();
        }
      }
    }
  }
  
  public void setCertifiedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bhY();
    
    public abstract void bhZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView
 * JD-Core Version:    0.7.0.1
 */