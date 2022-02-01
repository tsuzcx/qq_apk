import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wrb
{
  private wro a = new wro();
  private long fm;
  private ArrayList<wrx> qq = new ArrayList();
  
  public wro a()
  {
    return this.a;
  }
  
  public void a(wrx paramwrx, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramwrx == null) {}
    do
    {
      return;
      if (paramBoolean1) {
        this.a.a(paramwrx);
      }
      this.qq.add(paramwrx);
    } while (!paramBoolean2);
    this.fm += paramwrx.getTotalTime();
  }
  
  public ArrayList<wrx> bI()
  {
    return this.qq;
  }
  
  public void fW(long paramLong)
  {
    this.fm = paramLong;
  }
  
  public long getTotalTime()
  {
    return this.fm;
  }
  
  public void i(List<wrx> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l;
    if (paramList != null)
    {
      l = 0L;
      if ((paramBoolean1) || (paramBoolean2))
      {
        Iterator localIterator = paramList.iterator();
        l = 0L;
        if (localIterator.hasNext())
        {
          wrx localwrx = (wrx)localIterator.next();
          if (paramBoolean1) {
            this.a.a(localwrx);
          }
          if (!paramBoolean2) {
            break label103;
          }
          l = localwrx.getTotalTime() + l;
        }
      }
    }
    label103:
    for (;;)
    {
      break;
      this.qq.addAll(paramList);
      if (paramBoolean2) {
        this.fm = (l + this.fm);
      }
      return;
    }
  }
  
  public String pl()
  {
    if (!this.qq.isEmpty())
    {
      wrx localwrx = (wrx)this.qq.get(0);
      if (localwrx != null)
      {
        if (localwrx.mID > 0) {
          return String.valueOf(localwrx.getTextureID());
        }
        return String.valueOf(localwrx.getColor());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrb
 * JD-Core Version:    0.7.0.1
 */