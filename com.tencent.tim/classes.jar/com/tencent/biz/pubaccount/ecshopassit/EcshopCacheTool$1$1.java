package com.tencent.biz.pubaccount.ecshopassit;

import kea;
import keg;

class EcshopCacheTool$1$1
  implements Runnable
{
  EcshopCacheTool$1$1(EcshopCacheTool.1 param1) {}
  
  public void run()
  {
    if ((this.a.this$0.a != null) && (this.a.this$0.a.b != null)) {
      this.a.this$0.a.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.1.1
 * JD-Core Version:    0.7.0.1
 */