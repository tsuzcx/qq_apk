package com.tencent.beacon.event;

import com.tencent.beacon.base.util.c;
import com.tencent.beacon.event.a.a;
import java.util.Iterator;
import java.util.Set;

class e
  implements Runnable
{
  e(f paramf) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = f.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((Long)localIterator.next()).append(",");
    }
    localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(","));
    boolean bool = f.c(this.a).a(f.b(this.a), (String)localObject);
    c.a(f.d(this.a), 4, "delete: %s", new Object[] { Boolean.valueOf(bool) });
    f.e(this.a).a(f.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.e
 * JD-Core Version:    0.7.0.1
 */