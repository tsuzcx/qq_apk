package com.tencent.mobileqq.multicard;

import ajjf;
import ajjj;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;
import java.util.Map;

class MultiCardFragment$1$3
  implements Runnable
{
  MultiCardFragment$1$3(MultiCardFragment.1 param1, Map paramMap) {}
  
  public void run()
  {
    if (MultiCardFragment.a(this.a.this$0) != null)
    {
      MultiCardFragment.a(this.a.this$0).a(null, null, this.lZ);
      if ((this.lZ != null) && (MultiCardFragment.a(this.a.this$0) != null) && (MultiCardFragment.a(this.a.this$0)))
      {
        Object localObject = MultiCardFragment.a(this.a.this$0).a(MultiCardFragment.a(this.a.this$0).getCurrentItem());
        if ((localObject != null) && (this.lZ.containsKey(((ajjf)localObject).getUin())))
        {
          localObject = MultiCardFragment.a(this.a.this$0).getNickName(((ajjf)localObject).getUin());
          MultiCardFragment.a(this.a.this$0, (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1.3
 * JD-Core Version:    0.7.0.1
 */