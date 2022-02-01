package com.tencent.viola.vinstance;

import android.view.View;
import android.view.ViewGroup;

class VInstanceAction$2
  implements Runnable
{
  VInstanceAction$2(VInstanceAction paramVInstanceAction, VInstance paramVInstance, View paramView, ViewGroup paramViewGroup) {}
  
  public void run()
  {
    this.val$instance.willAppear((int)this.val$itemView.getY(), 0, this.val$parent.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.VInstanceAction.2
 * JD-Core Version:    0.7.0.1
 */