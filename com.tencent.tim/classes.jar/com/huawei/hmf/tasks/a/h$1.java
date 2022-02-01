package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;

final class h$1
  implements Runnable
{
  h$1(h paramh, Task paramTask) {}
  
  public final void run()
  {
    synchronized (h.a(this.b))
    {
      if (h.b(this.b) != null) {
        h.b(this.b).onSuccess(this.a.getResult());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.a.h.1
 * JD-Core Version:    0.7.0.1
 */