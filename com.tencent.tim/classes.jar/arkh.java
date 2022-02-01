import java.util.Iterator;
import java.util.List;

public class arkh
{
  private final List<arkf> events;
  private final long timeInMillis;
  
  arkh(long paramLong, List<arkf> paramList)
  {
    this.timeInMillis = paramLong;
    this.events = paramList;
  }
  
  public String CV()
  {
    if (this.events != null)
    {
      Iterator localIterator = this.events.iterator();
      while (localIterator.hasNext())
      {
        arkf localarkf = (arkf)localIterator.next();
        if (localarkf.getType() == 1) {
          return (String)localarkf.getData();
        }
      }
    }
    return null;
  }
  
  public boolean aGJ()
  {
    if (this.events != null)
    {
      Iterator localIterator = this.events.iterator();
      while (localIterator.hasNext()) {
        if (((arkf)localIterator.next()).getType() == 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean aGK()
  {
    if (this.events != null)
    {
      Iterator localIterator = this.events.iterator();
      while (localIterator.hasNext()) {
        if (((arkf)localIterator.next()).getType() == 2) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean aGL()
  {
    if (this.events != null)
    {
      Iterator localIterator = this.events.iterator();
      while (localIterator.hasNext()) {
        if (((arkf)localIterator.next()).getType() == 3) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void ejA()
  {
    if (this.events != null)
    {
      int i = this.events.size() - 1;
      while (i >= 0)
      {
        if ((((arkf)this.events.get(i)).getType() == 0) || (((arkf)this.events.get(i)).getType() == 1)) {
          this.events.remove(i);
        }
        i -= 1;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (arkh)paramObject;
      if (this.timeInMillis != paramObject.timeInMillis) {
        return false;
      }
      if (this.events == null) {
        break;
      }
    } while (this.events.equals(paramObject.events));
    for (;;)
    {
      return false;
      if (paramObject.events == null) {
        break;
      }
    }
  }
  
  public List<arkf> getEvents()
  {
    return this.events;
  }
  
  public long getTimeInMillis()
  {
    return this.timeInMillis;
  }
  
  public int hashCode()
  {
    if (this.events != null) {}
    for (int i = this.events.hashCode();; i = 0) {
      return i * 31 + (int)(this.timeInMillis ^ this.timeInMillis >>> 32);
    }
  }
  
  public String toString()
  {
    return "Events{events=" + this.events + ", timeInMillis=" + this.timeInMillis + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkh
 * JD-Core Version:    0.7.0.1
 */