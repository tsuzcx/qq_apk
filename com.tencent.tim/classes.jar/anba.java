import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class anba
{
  public static final String[] gw = { "msg_cached_max_seq", "msg_cached_min_seq", "msg_readed_seq", "msg_expired_seq" };
  private ArrayList<ConcurrentHashMap<String, Long>> Am;
  private anaz.a a;
  private QQAppInterface app;
  private ConcurrentHashMap<String, Integer> im = new ConcurrentHashMap(2);
  private ConcurrentHashMap<String, ArrayList<Object[]>> in = new ConcurrentHashMap(2);
  private String mTag;
  private int mUinType;
  private SharedPreferences pref;
  
  public anba(QQAppInterface paramQQAppInterface, int paramInt, String paramString, SharedPreferences paramSharedPreferences, anaz.a parama)
  {
    this.app = paramQQAppInterface;
    this.mUinType = paramInt;
    this.mTag = paramString;
    this.pref = paramSharedPreferences;
    this.a = parama;
    this.Am = new ArrayList(gw.length);
    paramInt = 0;
    while (paramInt <= 3)
    {
      this.Am.add(new ConcurrentHashMap(2));
      paramInt += 1;
    }
  }
  
  public String L(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 3) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(this.mTag).append("_").append(gw[paramInt]).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public long b(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 3) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.app.getCurrentAccountUin() == null) {
      return 0L;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.Am.get(paramInt);
    if (!localConcurrentHashMap.containsKey(paramString)) {
      localConcurrentHashMap.put(paramString, Long.valueOf(this.pref.getLong(L(paramInt, paramString), 0L)));
    }
    return ((Long)localConcurrentHashMap.get(paramString)).longValue();
  }
  
  public void clearCache()
  {
    int i = 0;
    while (i <= 3)
    {
      ((ConcurrentHashMap)this.Am.get(i)).clear();
      i += 1;
    }
  }
  
  public void e(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    long l1;
    if (paramInt2 == 1) {
      l1 = Math.max(paramLong, b(paramInt1, paramString));
    }
    for (;;)
    {
      ((ConcurrentHashMap)this.Am.get(paramInt1)).put(paramString, Long.valueOf(l1));
      if (this.app.getCurrentAccountUin() == null) {
        break;
      }
      this.a.putLong(L(paramInt1, paramString), l1);
      return;
      l1 = paramLong;
      if (paramInt2 == 2)
      {
        long l2 = b(paramInt1, paramString);
        l1 = paramLong;
        if (l2 != 0L) {
          l1 = Math.min(paramLong, l2);
        }
      }
    }
  }
  
  public int ed(String paramString)
  {
    if (!this.im.containsKey(paramString)) {
      this.im.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.im.get(paramString)).intValue();
  }
  
  public void u(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.in.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.in.put(paramString, localArrayList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anba
 * JD-Core Version:    0.7.0.1
 */