package com.tencent.qqmail.bottle.fragment.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.model.Bottler;

public class OnDetailClickBridge
  implements View.OnClickListener
{
  private OnDetailClickListener mOnDetailClickListener = null;
  
  public void bindViewOnClickListener(View paramView, Bottler paramBottler)
  {
    paramView.setTag(paramBottler);
    paramView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.mOnDetailClickListener != null)
    {
      Bottler localBottler = (Bottler)paramView.getTag();
      this.mOnDetailClickListener.onDetailClickListener(localBottler, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnDetailClickListener(OnDetailClickListener paramOnDetailClickListener)
  {
    this.mOnDetailClickListener = paramOnDetailClickListener;
  }
  
  public void unbindViewOnClickListener(View paramView)
  {
    paramView.setTag(null);
    paramView.setOnClickListener(null);
  }
  
  public static abstract interface OnDetailClickListener
  {
    public abstract void onDetailClickListener(Bottler paramBottler, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.OnDetailClickBridge
 * JD-Core Version:    0.7.0.1
 */