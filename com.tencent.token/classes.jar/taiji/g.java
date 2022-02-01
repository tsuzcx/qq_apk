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
  implements e, h
{
  private final Path a = new Path();
  private final Path b = new Path();
  private final Path c = new Path();
  private final String d;
  private final List<h> e = new ArrayList();
  private final cd f;
  
  public g(cd paramcd)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.d = paramcd.a();
      this.f = paramcd;
      return;
    }
    throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
  }
  
  @TargetApi(19)
  private void a(Path.Op paramOp)
  {
    this.b.reset();
    this.a.reset();
    int i = this.e.size() - 1;
    List localList;
    Path localPath;
    while (i >= 1)
    {
      localObject = (h)this.e.get(i);
      if ((localObject instanceof bs))
      {
        localObject = (bs)localObject;
        localList = ((bs)localObject).d();
        int j = localList.size() - 1;
        while (j >= 0)
        {
          localPath = ((h)localList.get(j)).a();
          localPath.transform(((bs)localObject).e());
          this.b.addPath(localPath);
          j -= 1;
        }
      }
      this.b.addPath(((h)localObject).a());
      i -= 1;
    }
    Object localObject = this.e;
    i = 0;
    localObject = (h)((List)localObject).get(0);
    if ((localObject instanceof bs))
    {
      localObject = (bs)localObject;
      localList = ((bs)localObject).d();
      while (i < localList.size())
      {
        localPath = ((h)localList.get(i)).a();
        localPath.transform(((bs)localObject).e());
        this.a.addPath(localPath);
        i += 1;
      }
    }
    this.a.set(((h)localObject).a());
    this.c.op(this.a, this.b, paramOp);
  }
  
  private void c()
  {
    int i = 0;
    while (i < this.e.size())
    {
      this.c.addPath(((h)this.e.get(i)).a());
      i += 1;
    }
  }
  
  public Path a()
  {
    this.c.reset();
    Path.Op localOp;
    switch (1.a[this.f.b().ordinal()])
    {
    default: 
      break;
    case 5: 
      localOp = Path.Op.XOR;
      break;
    case 4: 
      localOp = Path.Op.INTERSECT;
      break;
    case 3: 
      localOp = Path.Op.REVERSE_DIFFERENCE;
      break;
    case 2: 
      localOp = Path.Op.UNION;
      a(localOp);
      break;
    }
    c();
    return this.c;
  }
  
  public void a(List<br> paramList1, List<br> paramList2)
  {
    int i = 0;
    while (i < this.e.size())
    {
      ((h)this.e.get(i)).a(paramList1, paramList2);
      i += 1;
    }
  }
  
  public void a(ListIterator<br> paramListIterator)
  {
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    while (paramListIterator.hasPrevious())
    {
      br localbr = (br)paramListIterator.previous();
      if ((localbr instanceof h))
      {
        this.e.add((h)localbr);
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