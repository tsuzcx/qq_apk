package taiji;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class g
  implements e, i
{
  private final Path a = new Path();
  private final Path b = new Path();
  private final Path c = new Path();
  private final String d;
  private final List e = new ArrayList();
  private final cd f;
  
  public g(cd paramcd)
  {
    if (Build.VERSION.SDK_INT < 19) {
      throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }
    this.d = paramcd.a();
    this.f = paramcd;
  }
  
  @TargetApi(19)
  private void a(Path.Op paramOp)
  {
    int k = 0;
    this.b.reset();
    this.a.reset();
    int i = this.e.size() - 1;
    List localList;
    Path localPath;
    while (i >= 1)
    {
      locali = (i)this.e.get(i);
      if ((locali instanceof cy))
      {
        localList = ((cy)locali).d();
        int j = localList.size() - 1;
        while (j >= 0)
        {
          localPath = ((i)localList.get(j)).a();
          localPath.transform(((cy)locali).e());
          this.b.addPath(localPath);
          j -= 1;
        }
      }
      this.b.addPath(locali.a());
      i -= 1;
    }
    i locali = (i)this.e.get(0);
    if ((locali instanceof cy))
    {
      localList = ((cy)locali).d();
      i = k;
      while (i < localList.size())
      {
        localPath = ((i)localList.get(i)).a();
        localPath.transform(((cy)locali).e());
        this.a.addPath(localPath);
        i += 1;
      }
    }
    this.a.set(locali.a());
    this.c.op(this.a, this.b, paramOp);
  }
  
  private void c()
  {
    int i = 0;
    while (i < this.e.size())
    {
      this.c.addPath(((i)this.e.get(i)).a());
      i += 1;
    }
  }
  
  public Path a()
  {
    this.c.reset();
    switch (h.a[this.f.b().ordinal()])
    {
    }
    for (;;)
    {
      return this.c;
      c();
      continue;
      a(Path.Op.UNION);
      continue;
      a(Path.Op.REVERSE_DIFFERENCE);
      continue;
      a(Path.Op.INTERSECT);
      continue;
      a(Path.Op.XOR);
    }
  }
  
  public void a(List paramList1, List paramList2)
  {
    int i = 0;
    while (i < this.e.size())
    {
      ((i)this.e.get(i)).a(paramList1, paramList2);
      i += 1;
    }
  }
  
  public void a(ListIterator paramListIterator)
  {
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    while (paramListIterator.hasPrevious())
    {
      cx localcx = (cx)paramListIterator.previous();
      if ((localcx instanceof i))
      {
        this.e.add((i)localcx);
        paramListIterator.remove();
      }
    }
  }
  
  public String b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.g
 * JD-Core Version:    0.7.0.1
 */