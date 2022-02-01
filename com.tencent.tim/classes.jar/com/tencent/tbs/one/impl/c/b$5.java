package com.tencent.tbs.one.impl.c;

import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

final class b$5
  implements Runnable
{
  b$5(b paramb, String paramString) {}
  
  public final void run()
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (this.b.g == null)
    {
      localObject1 = this.b.a;
      f.c("[%s] {%s} Unknown error, finished installing component and dependencies but config is null, last error: [%d] %s", new Object[] { this.b.b.b, localObject1, Integer.valueOf(this.b.i), this.b.j });
      localObject2 = this.b.b.o;
      if (localObject2 != null)
      {
        i = ((d)localObject2).a;
        com.tencent.tbs.one.impl.common.h.a(i, (String)localObject1, -1, 101, String.format(Locale.US, "ComponentConfig is null, last error: [%d] %s", new Object[] { Integer.valueOf(this.b.i), this.b.j }), null);
      }
    }
    do
    {
      return;
      i = -1;
      break;
      this.b.a(90);
      localObject1 = this.b.b.a(this.a, this.b.g.c);
      localObject2 = this.b;
      f.a("[%s] {%s} Finished installing component at %s", new Object[] { ((b)localObject2).b.b, ((b)localObject2).a, ((File)localObject1).getAbsolutePath() });
      ((b)localObject2).k = ((File)localObject1);
      TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])((b)localObject2).c.toArray(new TBSOneCallback[0]);
      ((b)localObject2).c.clear();
      int j = arrayOfTBSOneCallback.length;
      i = 0;
      while (i < j)
      {
        TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i];
        localTBSOneCallback.onProgressChanged(((b)localObject2).h, 100);
        localTBSOneCallback.onCompleted(localObject1);
        i += 1;
      }
    } while (this.b.d.size() <= 0);
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.5
 * JD-Core Version:    0.7.0.1
 */