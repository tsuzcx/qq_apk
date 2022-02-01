package com.tencent.biz.pubaccount.readinjoy.view;

import lwh;

class ReadInJoyListViewGroup$46
  implements Runnable
{
  ReadInJoyListViewGroup$46(ReadInJoyListViewGroup paramReadInJoyListViewGroup, Runnable paramRunnable) {}
  
  public void run()
  {
    if ((lwh.a().CT()) && (!ReadInJoyListViewGroup.b(this.this$0))) {
      this.this$0.O(false, 8);
    }
    while (this.val$runnable == null) {
      return;
    }
    this.val$runnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.46
 * JD-Core Version:    0.7.0.1
 */