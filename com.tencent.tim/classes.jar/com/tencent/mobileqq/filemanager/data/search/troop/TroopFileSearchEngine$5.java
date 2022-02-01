package com.tencent.mobileqq.filemanager.data.search.troop;

import agoo;
import apeo;
import java.util.List;

public class TroopFileSearchEngine$5
  implements Runnable
{
  public TroopFileSearchEngine$5(agoo paramagoo, int paramInt, List paramList) {}
  
  public void run()
  {
    if (this.val$state == 1)
    {
      this.this$0.jf = apeo.E(this.zl);
      agoo.a(this.this$0, agoo.a(this.this$0), agoo.b(this.this$0), this.this$0.jf, agoo.a(this.this$0), agoo.b(this.this$0));
      this.zl.clear();
      return;
    }
    agoo.a(this.this$0, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.5
 * JD-Core Version:    0.7.0.1
 */