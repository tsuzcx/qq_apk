import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aqmv
{
  public ConcurrentHashMap<String, String> jc = new ConcurrentHashMap();
  public String mLogTag = "TimeTraceUtil";
  private long startTime = SystemClock.elapsedRealtime();
  
  public aqmv() {}
  
  public aqmv(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mLogTag = paramString;
    }
  }
  
  private long m(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jc.containsKey(paramString)))
    {
      paramString = (String)this.jc.get(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(",");
        if ((paramString.length >= 2) && (TextUtils.isDigitsOnly(paramString[1]))) {
          return paramLong - Long.parseLong(paramString[1]);
        }
      }
    }
    else if ("~~startTime".equals(paramString))
    {
      return paramLong - this.startTime;
    }
    return 0L;
  }
  
  public void X(String paramString1, String paramString2, boolean paramBoolean)
  {
    long l;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    if ((this.jc != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      l = SystemClock.elapsedRealtime();
      localConcurrentHashMap = this.jc;
      localStringBuilder = new StringBuilder().append(paramString2).append(",").append(String.valueOf(l)).append(",");
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (String str = "true";; str = "false")
    {
      localConcurrentHashMap.put(paramString1, str);
      paramString1 = String.format("TimerOutput: %s to %s cost=%d", new Object[] { paramString2, paramString1, Long.valueOf(m(paramString2, l)) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.mLogTag, 2, paramString1);
      return;
    }
    Log.i(this.mLogTag, paramString1);
  }
  
  public HashMap<String, String> ab()
  {
    for (;;)
    {
      long l2;
      synchronized (new HashMap())
      {
        if (this.jc != null)
        {
          Iterator localIterator = this.jc.entrySet().iterator();
          l1 = SystemClock.elapsedRealtime() - this.startTime;
          if (localIterator.hasNext())
          {
            Object localObject2 = (Map.Entry)localIterator.next();
            String str1 = (String)((Map.Entry)localObject2).getKey();
            localObject2 = ((String)((Map.Entry)localObject2).getValue()).split(",");
            l2 = l1;
            if (localObject2 == null) {
              break label190;
            }
            l2 = l1;
            if (localObject2.length < 3) {
              break label190;
            }
            String str2 = localObject2[0];
            CharSequence localCharSequence = localObject2[1];
            if (Boolean.parseBoolean(localObject2[2])) {
              continue;
            }
            l2 = l1;
            if (!TextUtils.isDigitsOnly(localCharSequence)) {
              break label190;
            }
            l2 = m(str2, Long.parseLong(localCharSequence));
            break label190;
            ???.put(str1, String.valueOf(l1));
          }
        }
      }
      label190:
      do
      {
        l1 = 0L;
        break;
        return ???;
      } while (l2 < 0L);
      long l1 = l2;
    }
  }
  
  public void dn(String paramString, boolean paramBoolean)
  {
    X(paramString, "~~startTime", paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = ab();
    if (localHashMap != null) {
      try
      {
        Iterator localIterator = localHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          String str2 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            localStringBuilder.append(str2 + ":" + (String)localObject2 + "ms,");
          }
        }
        str1 = localObject1.toString();
      }
      finally {}
    }
    String str1;
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmv
 * JD-Core Version:    0.7.0.1
 */