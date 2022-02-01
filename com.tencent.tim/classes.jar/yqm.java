import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class yqm
{
  public static yqm a()
  {
    return yqm.b.b();
  }
  
  private ArrayList<yqm.a> w(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("group_search_local_history_" + paramString, 0).getAll();
    paramString = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramString.add(new yqm.a((String)localEntry.getKey(), (Long)localEntry.getValue()));
    }
    Collections.sort(paramString);
    return paramString;
  }
  
  public void dL(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString2.trim()))) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("group_search_local_history_" + paramString1, 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (localSharedPreferences.getLong(paramString2, -1L) == -1L)
    {
      paramString1 = w(paramString1);
      if ((paramString1 != null) && (paramString1.size() >= 3))
      {
        int i = 2;
        while (i < paramString1.size())
        {
          localEditor.remove(((yqm.a)paramString1.get(i)).getKeyword());
          i += 1;
        }
      }
    }
    localEditor.putLong(paramString2, System.currentTimeMillis());
    localEditor.apply();
  }
  
  void dM(String paramString1, String paramString2)
  {
    paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("group_search_local_history_" + paramString1, 0).edit();
    paramString1.remove(paramString2);
    paramString1.apply();
  }
  
  ArrayList<String> x(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = w(paramString).iterator();
    while (paramString.hasNext()) {
      localArrayList.add(((yqm.a)paramString.next()).getKeyword());
    }
    return localArrayList;
  }
  
  class a
    implements Comparable<a>
  {
    private String keyword;
    private Long timestamp;
    
    a(String paramString, Long paramLong)
    {
      this.keyword = paramString;
      this.timestamp = paramLong;
    }
    
    public int a(a parama)
    {
      if (this.timestamp.longValue() > parama.timestamp.longValue()) {
        return -1;
      }
      return 1;
    }
    
    public String getKeyword()
    {
      return this.keyword;
    }
  }
  
  static class b
  {
    private static final yqm b = new yqm(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqm
 * JD-Core Version:    0.7.0.1
 */