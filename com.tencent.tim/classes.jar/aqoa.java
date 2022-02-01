import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqoa
{
  String cur;
  public List<aqob> vq = new ArrayList();
  
  public String Cl()
  {
    return this.cur;
  }
  
  public void UY(String paramString)
  {
    this.cur = paramString;
  }
  
  public void Z(int paramInt1, String paramString, int paramInt2)
  {
    aqob localaqob = new aqob();
    localaqob.id = paramInt1;
    localaqob.title = paramString;
    localaqob.drawable = paramInt2;
    this.vq.add(localaqob);
  }
  
  public aqoa a()
  {
    aqoa localaqoa = new aqoa();
    localaqoa.cur = this.cur;
    localaqoa.vq.addAll(this.vq);
    return localaqoa;
  }
  
  public aqob a(int paramInt)
  {
    return (aqob)this.vq.get(paramInt);
  }
  
  public void a(aqob paramaqob)
  {
    this.vq.add(paramaqob);
  }
  
  public aqob[] a()
  {
    if ((this.vq != null) && (this.vq.size() > 0))
    {
      aqob[] arrayOfaqob = new aqob[this.vq.size()];
      this.vq.toArray(arrayOfaqob);
      return arrayOfaqob;
    }
    return null;
  }
  
  @Deprecated
  public void dV(int paramInt, String paramString)
  {
    aqob localaqob = new aqob();
    localaqob.id = paramInt;
    localaqob.title = paramString;
    this.vq.add(localaqob);
  }
  
  public int size()
  {
    return this.vq.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.vq != null)
    {
      Iterator localIterator = this.vq.iterator();
      while (localIterator.hasNext())
      {
        aqob localaqob = (aqob)localIterator.next();
        localStringBuilder.append(" " + localaqob.title + "\n");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqoa
 * JD-Core Version:    0.7.0.1
 */