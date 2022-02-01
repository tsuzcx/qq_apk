import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class yme
{
  private HashMap<String, Integer> hb = new HashMap();
  private long timeMillis;
  private int totalCount;
  
  public static yme a(SharedPreferences paramSharedPreferences, int paramInt)
  {
    String str2 = "bless_uin_list";
    String str1 = "bless_uin_list_time_millis";
    if (paramInt == 2)
    {
      str2 = "web_uin_list";
      str1 = "web_uin_list_time_millis";
    }
    yme localyme = new yme();
    localyme.timeMillis = paramSharedPreferences.getLong(str1, 0L);
    if (DateUtils.isToday(localyme.timeMillis)) {
      try
      {
        paramSharedPreferences = paramSharedPreferences.getString(str2, "[]");
        if (QLog.isColorLevel()) {
          QLog.d("BlessManager", 2, "read uin list from mode=" + paramInt + " ,SP=" + paramSharedPreferences);
        }
        paramSharedPreferences = new JSONArray(paramSharedPreferences);
        paramInt = 0;
        while (paramInt + 1 < paramSharedPreferences.length())
        {
          localyme.put(paramSharedPreferences.getString(paramInt), paramSharedPreferences.getInt(paramInt + 1));
          paramInt += 2;
          continue;
          localyme.timeMillis = System.currentTimeMillis();
        }
      }
      catch (Exception paramSharedPreferences)
      {
        paramSharedPreferences.printStackTrace();
        return null;
      }
    }
    return localyme;
  }
  
  public static void a(SharedPreferences paramSharedPreferences, yme paramyme, int paramInt)
  {
    paramyme.bnu();
    Object localObject = new JSONArray();
    Iterator localIterator = paramyme.hb.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      ((JSONArray)localObject).put(localEntry.getValue());
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    localObject = ((JSONArray)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "save uin list to SP=" + (String)localObject);
    }
    if (paramInt == 2)
    {
      paramSharedPreferences.putString("web_uin_list", (String)localObject);
      paramSharedPreferences.putLong("web_uin_list_time_millis", paramyme.timeMillis);
    }
    for (;;)
    {
      paramSharedPreferences.commit();
      return;
      paramSharedPreferences.putString("bless_uin_list", (String)localObject);
      paramSharedPreferences.putLong("bless_uin_list_time_millis", paramyme.timeMillis);
    }
  }
  
  private void put(String paramString, int paramInt)
  {
    this.totalCount += paramInt;
    this.hb.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void add(String paramString)
  {
    this.totalCount += 1;
    if (this.hb.containsKey(paramString))
    {
      this.hb.put(paramString, Integer.valueOf(((Integer)this.hb.get(paramString)).intValue() + 1));
      return;
    }
    this.hb.put(paramString, Integer.valueOf(1));
  }
  
  public void bnu()
  {
    if (!DateUtils.isToday(this.timeMillis)) {
      clear();
    }
  }
  
  public void clear()
  {
    this.hb.clear();
    this.totalCount = 0;
    this.timeMillis = System.currentTimeMillis();
  }
  
  public boolean contains(String paramString)
  {
    return this.hb.containsKey(paramString);
  }
  
  public int getTotalCount()
  {
    return this.totalCount;
  }
  
  public int size()
  {
    return this.hb.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yme
 * JD-Core Version:    0.7.0.1
 */