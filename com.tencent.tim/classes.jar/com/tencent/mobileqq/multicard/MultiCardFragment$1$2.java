package com.tencent.mobileqq.multicard;

import ajjj;
import anot;
import java.util.List;
import java.util.Map;

class MultiCardFragment$1$2
  implements Runnable
{
  MultiCardFragment$1$2(MultiCardFragment.1 param1, List paramList, Map paramMap1, Map paramMap2) {}
  
  public void run()
  {
    if (MultiCardFragment.a(this.a.this$0) != null) {
      MultiCardFragment.a(this.a.this$0).a(this.Dm, this.lY, this.lZ);
    }
    if (MultiCardFragment.a(this.a.this$0) != null) {
      MultiCardFragment.a(this.a.this$0).updateData();
    }
    if ((this.lY.size() > 0) && (MultiCardFragment.a(this.a.this$0).coZ))
    {
      MultiCardFragment.a(this.a.this$0).coZ = false;
      anot.a(null, "dc00898", "", "", "0X800A213", "0X800A213", 0, 0, "", "", "", "");
    }
    MultiCardFragment.a(this.a.this$0);
    if (MultiCardFragment.a(this.a.this$0)) {
      MultiCardFragment.a(this.a.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1.2
 * JD-Core Version:    0.7.0.1
 */