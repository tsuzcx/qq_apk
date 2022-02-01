package com.tencent.mobileqq.multicard;

import ajjj;
import java.util.List;
import java.util.Map;

class MultiCardFragment$1$1
  implements Runnable
{
  MultiCardFragment$1$1(MultiCardFragment.1 param1, List paramList, Map paramMap1, Map paramMap2) {}
  
  public void run()
  {
    if (MultiCardFragment.a(this.a.this$0) != null) {
      MultiCardFragment.a(this.a.this$0).a(this.Dm, this.lY, this.lZ);
    }
    if (MultiCardFragment.a(this.a.this$0) != null) {
      MultiCardFragment.a(this.a.this$0).notifyDataSetChanged();
    }
    if (MultiCardFragment.a(this.a.this$0) != null) {
      MultiCardFragment.a(this.a.this$0).notifyDataSetChanged();
    }
    if (MultiCardFragment.a(this.a.this$0) != null)
    {
      MultiCardFragment.a(this.a.this$0).init(this.Dm.size());
      MultiCardFragment.a(this.a.this$0).Rc(0);
      MultiCardFragment.a(this.a.this$0).doReport();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1.1
 * JD-Core Version:    0.7.0.1
 */