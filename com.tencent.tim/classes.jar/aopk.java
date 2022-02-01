import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aopk
{
  private Map<String, String> nx = new HashMap();
  
  public String getMimeType(String paramString)
  {
    paramString = aopi.getExtension(paramString);
    return (String)this.nx.get(paramString);
  }
  
  public List<String> gw()
  {
    if ((this.nx != null) && (this.nx.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.nx.entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Map.Entry)localIterator.next()).getValue());
      }
      return localArrayList;
    }
    return null;
  }
  
  public void put(String paramString1, String paramString2)
  {
    this.nx.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopk
 * JD-Core Version:    0.7.0.1
 */