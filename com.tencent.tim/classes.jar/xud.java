import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class xud
{
  private int bXc;
  private ArrayMap<String, List<Object>> g = new ArrayMap();
  private ArrayMap<String, Boolean> h = new ArrayMap();
  
  private int a(String paramString, int paramInt, List<Object> paramList)
  {
    checkThread();
    if ((paramString == null) || (paramInt <= 0) || (paramList == null)) {
      return -1;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      if (((localObject instanceof String)) && (((String)localObject).equals(paramString))) {
        return i + paramInt;
      }
      i += 1;
    }
    return -1;
  }
  
  private void b(int paramInt, String paramString, List<Object> paramList)
  {
    checkThread();
    if ((paramString == null) || (paramInt < 0) || (paramList == null)) {}
    do
    {
      return;
      paramString = (List)this.g.get(paramString);
    } while (paramString == null);
    int i = paramString.size();
    while ((i > 0) && (paramInt < paramList.size()))
    {
      paramList.remove(paramInt);
      i -= 1;
    }
    paramInt = this.bXc;
    this.bXc = (paramString.size() + paramInt);
  }
  
  private void c(int paramInt, String paramString, List<Object> paramList)
  {
    checkThread();
    if ((paramString == null) || (paramInt < 0) || (paramList == null)) {}
    do
    {
      return;
      paramString = (List)this.g.get(paramString);
    } while (paramString == null);
    paramList.addAll(paramInt, paramString);
    this.bXc -= paramString.size();
  }
  
  public void J(List<Object> paramList, int paramInt)
  {
    checkThread();
    if ((paramList == null) || (paramInt <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        if (((localObject instanceof String)) && (this.h.get((String)localObject) != null) && (!((Boolean)this.h.get((String)localObject)).booleanValue()) && (this.g.get(localObject) != null)) {
          paramList.addAll(i + paramInt, (Collection)this.g.get(localObject));
        }
        i += 1;
      }
    }
  }
  
  public List<Object> ab(String paramString)
  {
    checkThread();
    return (List)this.g.get(paramString);
  }
  
  public boolean c(String paramString, int paramInt, List<Object> paramList)
  {
    boolean bool2 = true;
    checkThread();
    if (this.g.get(paramString) == null) {
      return false;
    }
    if (this.h.get(paramString) != null) {}
    for (boolean bool1 = ((Boolean)this.h.get(paramString)).booleanValue();; bool1 = true)
    {
      ArrayMap localArrayMap = this.h;
      if (!bool1)
      {
        localArrayMap.put(paramString, Boolean.valueOf(bool2));
        paramInt = a(paramString, paramInt, paramList);
        if (bool1) {
          break label99;
        }
        c(paramInt, paramString, paramList);
      }
      for (;;)
      {
        return bool1;
        bool2 = false;
        break;
        label99:
        b(paramInt, paramString, paramList);
      }
    }
  }
  
  public void checkThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  public void e(boolean paramBoolean, int paramInt, List<Object> paramList)
  {
    checkThread();
    if ((paramList == null) || (paramInt <= 0)) {}
    for (;;)
    {
      return;
      this.g.clear();
      Object localObject2 = null;
      int i = 0;
      Object localObject3;
      if (i < paramList.size())
      {
        localObject3 = paramList.get(i);
        if ((localObject3 instanceof String))
        {
          localObject2 = (List)this.g.get(localObject3);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            this.g.put((String)localObject3, localObject1);
          }
        }
        for (;;)
        {
          i += 1;
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if (localObject2 != null) {
            if ((!(localObject3 instanceof xuf)) && (localObject3 != xto.bS) && (!(localObject3 instanceof afrq)))
            {
              localObject1 = localObject2;
              if (localObject3 != ChatHistoryEmotionAdapter.bS) {}
            }
            else
            {
              ((List)localObject2).add(localObject3);
              localObject1 = localObject2;
            }
          }
        }
      }
      this.bXc = 0;
      if (!paramBoolean) {
        break;
      }
      Object localObject1 = this.h.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (Boolean)((Map.Entry)localObject3).getValue();
        if ((localObject3 != null) && (!((Boolean)localObject3).booleanValue())) {
          b(a((String)localObject2, paramInt, paramList), (String)localObject2, paramList);
        }
      }
    }
    this.h.clear();
  }
  
  public boolean f(List<Object> paramList, int paramInt)
  {
    checkThread();
    boolean bool2;
    if ((this.h.isEmpty()) || (paramList == null))
    {
      bool2 = false;
      return bool2;
    }
    int i = 0;
    boolean bool1 = false;
    label29:
    if (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      if ((!(localObject instanceof String)) || (this.h.get((String)localObject) == null) || (((Boolean)this.h.get((String)localObject)).booleanValue()) || (this.g.get(localObject) == null)) {
        break label155;
      }
      paramList.addAll(i + paramInt, (Collection)this.g.get(localObject));
      bool1 = true;
    }
    label155:
    for (;;)
    {
      i += 1;
      break label29;
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.h.clear();
      return bool1;
    }
  }
  
  public boolean hS(String paramString)
  {
    checkThread();
    paramString = (Boolean)this.h.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return true;
  }
  
  public int wx()
  {
    checkThread();
    return this.bXc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xud
 * JD-Core Version:    0.7.0.1
 */