package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kxm;
import lie;
import lwl;
import lwm.a;
import mas;
import wja;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, lwl
{
  mas a;
  public View kR;
  
  public ComponentNotIntrest(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      aNf();
    }
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq()
  {
    this.kR.setOnClickListener(this);
  }
  
  public void aNf()
  {
    if (this.a.CV())
    {
      this.kR.setPadding(wja.dp2px(5.0F, getResources()), wja.dp2px(5.0F, getResources()), wja.dp2px(5.0F, getResources()), wja.dp2px(5.0F, getResources()));
      return;
    }
    if (kxm.u(this.a.a.a()))
    {
      this.kR.setPadding(wja.dp2px(5.0F, getResources()), wja.dp2px(5.0F, getResources()), wja.dp2px(9.0F, getResources()), wja.dp2px(5.0F, getResources()));
      return;
    }
    this.kR.setPadding(wja.dp2px(12.0F, getResources()), wja.dp2px(9.0F, getResources()), wja.dp2px(12.0F, getResources()), wja.dp2px(9.0F, getResources()));
  }
  
  public void init(Context paramContext)
  {
    this.kR = LayoutInflater.from(paramContext).inflate(2131560326, this, true).findViewById(2131381256);
  }
  
  public void onClick(View paramView)
  {
    if (this.a.b != null) {
      this.a.b.a(paramView, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */