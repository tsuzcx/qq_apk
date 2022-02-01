package com.tencent.mobileqq.richmedia.ordersend;

import ambp;
import android.view.View;
import aoko;
import wla.a;

public class OrderMediaMsgStatusCallback$1
  implements Runnable
{
  public OrderMediaMsgStatusCallback$1(ambp paramambp, wla.a parama, View paramView, aoko paramaoko) {}
  
  public void run()
  {
    this.b.a(this.val$contentView, this.a, this.a.status, this.a.errorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */