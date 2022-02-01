package tmsdk.common.d.a.b;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

class p
  implements Runnable
{
  p(o paramo) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    AtomicReference localAtomicReference = new AtomicReference();
    int i = this.a.a(null, (ArrayList)localObject, localAtomicReference);
    if (-10 != i)
    {
      if (i == 0) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkDoRegist() 首次注册失败，ret: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkDoRegist() 首次注册失败，ret: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).toString();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.p
 * JD-Core Version:    0.7.0.1
 */