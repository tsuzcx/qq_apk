import android.support.annotation.NonNull;
import com.tencent.mobileqq.statistics.fdcount.FdTrie.1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class anpz
{
  static final List<String> GI = new FdTrie.1(10);
  private anpy a = new anpy();
  private HashMap<anpy, String> nB = new HashMap(100);
  private HashMap<anpy, String> nC = new HashMap(GI.size());
  
  private void a(anpy paramanpy, String paramString)
  {
    if (paramanpy == null) {
      return;
    }
    Object localObject = nG(paramString);
    if (localObject != null) {
      this.nC.put(paramanpy, localObject);
    }
    localObject = paramanpy.nA.values().iterator();
    anpy localanpy;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localanpy = (anpy)((Iterator)localObject).next();
    } while ((localanpy == null) || (localanpy.isLeaf()));
    for (int i = 0;; i = 1)
    {
      if ((i != 0) && (!paramanpy.nA.isEmpty()))
      {
        this.nB.put(paramanpy, paramString);
        return;
      }
      localObject = paramanpy.nA.values().iterator();
      label117:
      while (((Iterator)localObject).hasNext())
      {
        localanpy = (anpy)((Iterator)localObject).next();
        if (localanpy != null) {
          if (paramString == null) {
            break label186;
          }
        }
      }
      label186:
      for (paramanpy = paramString + "/" + localanpy.text;; paramanpy = localanpy.text)
      {
        a(localanpy, paramanpy);
        break label117;
        break;
      }
    }
  }
  
  private static List<String> aP(String paramString)
  {
    paramString = paramString.split("/");
    ArrayList localArrayList = new ArrayList(paramString.length);
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  private void b(anpy paramanpy, String paramString)
  {
    Iterator localIterator = aP(paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramanpy.a(str);
      if (paramString != null)
      {
        paramString.dLG += 1;
        paramanpy = paramString;
      }
      else
      {
        paramString = new anpy(str);
        paramString.dLG = 1;
        paramanpy.nA.put(paramString.text, paramString);
        paramanpy = paramString;
      }
    }
  }
  
  static String nG(String paramString)
  {
    Iterator localIterator = GI.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((paramString != null) && (paramString.contains(str))) {
        return str;
      }
    }
    return null;
  }
  
  public void Rj(@NonNull String paramString)
  {
    b(this.a, paramString);
  }
  
  public HashMap<anpy, String> W()
  {
    return this.nB;
  }
  
  public HashMap<anpy, String> X()
  {
    return this.nC;
  }
  
  public void dTa()
  {
    a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpz
 * JD-Core Version:    0.7.0.1
 */