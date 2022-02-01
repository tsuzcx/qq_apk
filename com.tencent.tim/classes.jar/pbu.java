import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class pbu
{
  public static final String TAG = pbu.class.getSimpleName();
  private static volatile pbu a;
  private ConcurrentHashMap<String, Boolean> bK = new ConcurrentHashMap();
  private List<SoftReference<Object>> mListenerList = new LinkedList();
  
  public static pbu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pbu();
      }
      return a;
    }
    finally {}
  }
  
  public void clearAll()
  {
    if (this.bK != null)
    {
      QLog.i(TAG, 1, "clear all");
      this.bK.clear();
    }
  }
  
  public boolean getUinFollowed(String paramString)
  {
    if (hasUin(paramString))
    {
      paramString = (Boolean)this.bK.get(paramString);
      if (paramString == null)
      {
        QLog.e(TAG, 1, "mUinFollowMap getValue uin null");
        return false;
      }
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean hasUin(String paramString)
  {
    return (paramString != null) && (this.bK.containsKey(paramString));
  }
  
  public void setUinFollowed(String paramString, boolean paramBoolean)
  {
    if (this.bK != null) {
      this.bK.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbu
 * JD-Core Version:    0.7.0.1
 */