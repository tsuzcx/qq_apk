import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pbz
{
  public static final String TAG = pbz.class.getSimpleName();
  private static volatile pbz a;
  private ConcurrentHashMap<String, Boolean> bM = new ConcurrentHashMap();
  private List<SoftReference<Object>> mListenerList = new LinkedList();
  
  public static pbz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pbz();
      }
      return a;
    }
    finally {}
  }
  
  public void as(String paramString, boolean paramBoolean)
  {
    if (this.bM != null) {
      this.bM.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
  
  public void clearAll()
  {
    if (this.bM != null)
    {
      QLog.i(TAG, 1, "clear all");
      this.bM.clear();
    }
  }
  
  public boolean eP(String paramString)
  {
    return (paramString != null) && (this.bM.containsKey(paramString));
  }
  
  public boolean eQ(String paramString)
  {
    if (eP(paramString))
    {
      paramString = (Boolean)this.bM.get(paramString);
      if (paramString == null)
      {
        QLog.e(TAG, 1, "mTagFollowMap getValue tagId null");
        return false;
      }
      return paramString.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbz
 * JD-Core Version:    0.7.0.1
 */