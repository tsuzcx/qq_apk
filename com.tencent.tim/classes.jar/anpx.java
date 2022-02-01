import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class anpx
{
  private TreeMap<anpy, String> e;
  private Map<String, Integer> nn;
  
  private String Aq()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nBusiness\n");
    Iterator localIterator = this.e.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      if (i < 20) {}
    }
    else
    {
      return localStringBuilder.toString();
    }
    localStringBuilder.append("fd: ").append((String)((Map.Entry)localObject).getValue()).append(" ").append("(").append("count: ").append(((anpy)((Map.Entry)localObject).getKey()).dLG).append(")").append("\n");
    Object localObject = new ArrayList(((anpy)((Map.Entry)localObject).getKey()).nA.values());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    int j = 0;
    for (;;)
    {
      anpy localanpy;
      if (((Iterator)localObject).hasNext())
      {
        localanpy = (anpy)((Iterator)localObject).next();
        if (j >= 5) {
          localStringBuilder.append("\t\t").append("…").append("\n");
        }
      }
      else
      {
        i += 1;
        break;
      }
      j += 1;
      localStringBuilder.append("\t\t").append(localanpy.text).append("(").append("count: ").append(localanpy.dLG).append(")").append("\n");
    }
  }
  
  private String Ar()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSystem\n");
    Iterator localIterator = this.nn.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("fd: ").append((String)localEntry.getKey()).append(" ").append("(").append("count: ").append(localEntry.getValue()).append(")").append("\n");
    }
    return localStringBuilder.toString();
  }
  
  private void a(anpz paramanpz)
  {
    paramanpz.dTa();
    c(paramanpz);
    b(paramanpz);
  }
  
  private void b(anpz paramanpz)
  {
    Object localObject = paramanpz.W();
    paramanpz = new HashMap(20);
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      String str = (String)localEntry.getValue();
      if (anpz.nG(str) == null) {
        paramanpz.put(localEntry.getKey(), str);
      }
    }
    this.e = new TreeMap(paramanpz);
  }
  
  private void c(anpz paramanpz)
  {
    this.nn = new HashMap(10);
    paramanpz = paramanpz.X().entrySet().iterator();
    while (paramanpz.hasNext())
    {
      Object localObject = (Map.Entry)paramanpz.next();
      anpy localanpy = (anpy)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!this.nn.containsKey(localObject))
      {
        this.nn.put(localObject, Integer.valueOf(localanpy.dLG));
      }
      else
      {
        Integer localInteger = (Integer)this.nn.get(localObject);
        Map localMap = this.nn;
        int i = localInteger.intValue();
        localMap.put(localObject, Integer.valueOf(localanpy.dLG + i));
      }
    }
  }
  
  public String a(anpz paramanpz)
  {
    a(paramanpz);
    return Aq() + Ar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpx
 * JD-Core Version:    0.7.0.1
 */