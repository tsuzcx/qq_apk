package com.tencent.mobileqq.app;

import accv;
import accv.b;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ConditionSearchManager$2$1
  implements Runnable
{
  ConditionSearchManager$2$1(ConditionSearchManager.2 param2) {}
  
  public void run()
  {
    accv.a(this.a.this$0, false);
    if (this.a.this$0.bHb) {
      for (;;)
      {
        try
        {
          if (this.a.this$0.J == null) {
            continue;
          }
          Object localObject = new LinkedList();
          ((LinkedList)localObject).addAll(this.a.this$0.J);
          localObject = ((LinkedList)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          localb = (accv.b)((Iterator)localObject).next();
          if (accv.a(this.a.this$0) == null) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          accv.b localb;
          QLog.e("ConditionSearch.Manager", 1, "updateLocal callback fail.", localException);
          if ((!this.a.this$0.bHc) || (accv.a(this.a.this$0) == null)) {
            continue;
          }
          this.a.this$0.j(this.a.this$0.e);
          return;
          boolean bool = false;
          continue;
          this.a.this$0.bHc = false;
          this.a.this$0.e = null;
          this.a.this$0.aW(this.a.this$0.cn);
          return;
        }
        localb.D(2, bool);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | SearchActivity is not running");
    }
    accv.a(this.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.2.1
 * JD-Core Version:    0.7.0.1
 */