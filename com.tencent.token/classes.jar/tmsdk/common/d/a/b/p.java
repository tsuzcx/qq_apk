package tmsdk.common.d.a.b;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

class p
  implements Runnable
{
  p(o paramo) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    AtomicReference localAtomicReference = new AtomicReference();
    int i = this.a.a(null, localArrayList, localAtomicReference);
    if ((-10 == i) || (i == 0)) {
      return;
    }
    new StringBuilder().append("checkDoRegist() 首次注册失败，ret: ").append(i).toString();
    new StringBuilder().append("checkDoRegist() 首次注册失败，ret: ").append(i).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.p
 * JD-Core Version:    0.7.0.1
 */