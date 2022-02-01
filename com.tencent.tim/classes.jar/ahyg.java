import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ahyg
{
  public static ConcurrentHashMap<String, ArrayList<ahyj>> fB = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, ahyi> fC = new ConcurrentHashMap();
  
  public static void KO(String paramString)
  {
    synchronized (fB)
    {
      ahyj localahyj;
      do
      {
        Iterator localIterator = fB.keySet().iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (String)localIterator.next();
          } while (!((String)localObject).endsWith("plugin"));
          localObject = ((ArrayList)fB.get(localObject)).iterator();
        }
        localahyj = (ahyj)((Iterator)localObject).next();
      } while (!((ahyh)localahyj).mPluginId.equals(paramString));
      localahyj.dqV();
      localahyj.end();
    }
  }
  
  public static void KP(String paramString)
  {
    synchronized (fB)
    {
      ahyi localahyi = (ahyi)fC.get(paramString);
      if (localahyi != null)
      {
        localahyi.end();
        fC.remove(paramString);
      }
      return;
    }
  }
  
  public static void KQ(String paramString)
  {
    synchronized (fB)
    {
      paramString = (ahyi)fC.get(paramString);
      if (paramString != null) {
        paramString.dqV();
      }
      return;
    }
  }
  
  public static void KR(String paramString)
  {
    synchronized (fB)
    {
      if ((ahyi)fC.get(paramString) == null)
      {
        ahyi localahyi = new ahyi(paramString);
        fC.put(paramString, localahyi);
        localahyi.begin();
      }
      return;
    }
  }
  
  public static void a(ahyj paramahyj)
  {
    synchronized (fB)
    {
      String str = paramahyj.getKey();
      ArrayList localArrayList = (ArrayList)fB.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramahyj);
        fB.put(str, localArrayList);
      }
      while (localArrayList.contains(paramahyj)) {
        return;
      }
      localArrayList.add(paramahyj);
    }
  }
  
  public static void dqU()
  {
    synchronized (fB)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator2 = fB.values().iterator();
      while (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((ArrayList)localIterator2.next()).iterator();
        if (localIterator3.hasNext())
        {
          ahyj localahyj = (ahyj)localIterator3.next();
          localahyj.end();
          localHashSet.add(localahyj.processName);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      KP((String)localIterator1.next());
    }
  }
  
  public static void exitProcess(String paramString)
  {
    synchronized (fB)
    {
      Iterator localIterator = fB.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (((String)localObject).startsWith(paramString))
        {
          localObject = ((ArrayList)fB.get(localObject)).iterator();
          if (((Iterator)localObject).hasNext()) {
            ((ahyj)((Iterator)localObject).next()).end();
          }
        }
      }
    }
    KP(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahyg
 * JD-Core Version:    0.7.0.1
 */