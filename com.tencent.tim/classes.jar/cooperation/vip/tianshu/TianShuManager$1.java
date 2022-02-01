package cooperation.vip.tianshu;

import awmt;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TianShuManager$1
  implements Runnable
{
  public TianShuManager$1(awmt paramawmt) {}
  
  public void run()
  {
    synchronized (awmt.a(this.this$0))
    {
      ArrayList localArrayList2 = new ArrayList(awmt.a(this.this$0));
      awmt.a(this.this$0).clear();
      awmt.a(this.this$0).set(false);
      awmt.a(this.this$0, localArrayList2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager.1
 * JD-Core Version:    0.7.0.1
 */