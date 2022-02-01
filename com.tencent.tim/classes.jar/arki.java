import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class arki
{
  private Calendar D;
  private Comparator<arkf> al = new arkg();
  private Map<String, List<arkh>> oE = new HashMap();
  
  public arki(Calendar paramCalendar)
  {
    this.D = paramCalendar;
  }
  
  private arkh a(long paramLong)
  {
    this.D.setTimeInMillis(paramLong);
    Object localObject = d(this.D);
    localObject = (List)this.oE.get(localObject);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        arkh localarkh = (arkh)((Iterator)localObject).next();
        if (b(paramLong, localarkh.getTimeInMillis())) {
          return localarkh;
        }
      }
    }
    return null;
  }
  
  private boolean b(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (c(paramLong1) == c(paramLong2));
  }
  
  private long c(long paramLong)
  {
    return (TimeZone.getDefault().getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  private String d(Calendar paramCalendar)
  {
    return paramCalendar.get(1) + "_" + paramCalendar.get(2);
  }
  
  void a(arkf paramarkf)
  {
    this.D.setTimeInMillis(paramarkf.getTimeInMillis());
    String str = d(this.D);
    Object localObject2 = (List)this.oE.get(str);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = a(paramarkf.getTimeInMillis());
    if (localObject2 == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramarkf);
      ((List)localObject1).add(new arkh(paramarkf.getTimeInMillis(), (List)localObject2));
    }
    for (;;)
    {
      this.oE.put(str, localObject1);
      return;
      ((arkh)localObject2).getEvents().add(paramarkf);
    }
  }
  
  void b(arkf paramarkf)
  {
    this.D.setTimeInMillis(paramarkf.getTimeInMillis());
    Object localObject = d(this.D);
    localObject = (List)this.oE.get(localObject);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        arkh localarkh = (arkh)((Iterator)localObject).next();
        int i = localarkh.getEvents().indexOf(paramarkf);
        if (i >= 0) {
          localarkh.getEvents().remove(i);
        }
      }
    }
  }
  
  public void ejo()
  {
    this.oE.clear();
  }
  
  public List<arkh> i(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.oE.get(paramInt2 + "_" + paramInt1) != null) {
      localArrayList.addAll((Collection)this.oE.get(paramInt2 + "_" + paramInt1));
    }
    return localArrayList;
  }
  
  public void mk(long paramLong)
  {
    this.D.setTimeInMillis(paramLong);
    Object localObject = d(this.D);
    localObject = (List)this.oE.get(localObject);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((arkh)((Iterator)localObject).next()).ejA();
      }
    }
  }
  
  public void u(List<arkf> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      b((arkf)paramList.get(i));
      i += 1;
    }
  }
  
  public void v(List<arkf> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a((arkf)paramList.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arki
 * JD-Core Version:    0.7.0.1
 */