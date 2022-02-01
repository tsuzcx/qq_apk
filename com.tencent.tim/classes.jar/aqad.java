import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.1;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class aqad
{
  public String crZ;
  public String csa = "";
  public final int dYe = 32;
  public float elapsedTime;
  public QQAppInterface mApp;
  public Handler mHandler;
  public List<aqad.a> traces;
  public int ttl = 1;
  
  public aqad(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = paramHandler;
    this.traces = new ArrayList();
  }
  
  public void b(long paramLong, String paramString, Map<String, Object> paramMap)
  {
    this.mHandler.post(new UnifiedTraceRouter.1(this, paramString, paramLong, paramMap));
  }
  
  public String dC(String paramString)
    throws IOException, RuntimeException
  {
    Object localObject = String.format("/system/bin/ping -i 0.2 -c 1 -s 0 -t %d -W 4 %s", new Object[] { Integer.valueOf(this.ttl), paramString });
    long l = System.currentTimeMillis();
    Process localProcess = Runtime.getRuntime().exec((String)localObject);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
    localObject = "";
    for (;;)
    {
      String str2 = localBufferedReader.readLine();
      if (str2 == null) {
        break;
      }
      String str1 = (String)localObject + str2 + "\n";
      if (!str2.contains("From"))
      {
        localObject = str1;
        if (!str2.contains("from")) {}
      }
      else
      {
        this.elapsedTime = ((float)(System.currentTimeMillis() - l));
        localObject = str1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedTraceRouter", 2, "ping url = " + paramString + " result = " + (String)localObject);
    }
    try
    {
      localProcess.destroy();
      label190:
      if (((String)localObject).equals("")) {
        throw new IllegalArgumentException("ping result is empty");
      }
      if (this.ttl == 1)
      {
        this.crZ = pa((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedTraceRouter", 2, "final ip: " + this.crZ);
        }
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      break label190;
    }
  }
  
  public String oZ(String paramString)
  {
    Object localObject2 = null;
    int i;
    int j;
    Object localObject1;
    if (paramString.contains("From"))
    {
      paramString = paramString.substring(paramString.indexOf("From") + 5);
      if (paramString.contains("("))
      {
        i = paramString.indexOf("(");
        j = paramString.indexOf(")");
        localObject1 = paramString;
        if (i >= 0)
        {
          localObject1 = paramString;
          if (j >= 0) {
            localObject1 = paramString.substring(i + 1, j);
          }
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        paramString = paramString.substring(0, paramString.indexOf("\n"));
        if (paramString.contains(":")) {}
        for (i = paramString.indexOf(":");; i = paramString.indexOf(" "))
        {
          localObject1 = paramString;
          if (i <= 0) {
            break;
          }
          return paramString.substring(0, i);
        }
        i = paramString.indexOf("(");
        j = paramString.indexOf(")");
        localObject1 = localObject2;
      } while (i < 0);
      localObject1 = localObject2;
    } while (j < 0);
    return paramString.substring(i + 1, j);
  }
  
  public String pa(String paramString)
  {
    String str = "";
    if (paramString.contains("PING")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  public String pb(String paramString)
  {
    String str = "";
    if (paramString.contains("time="))
    {
      paramString = paramString.substring(paramString.indexOf("time=") + 5);
      str = paramString.substring(0, paramString.indexOf(" "));
    }
    return str;
  }
  
  public class a
  {
    public String host;
    public String ip;
    public float time;
    public int ttl;
    
    public a(String paramString, float paramFloat)
    {
      this.ip = paramString;
      this.time = paramFloat;
    }
    
    public JSONArray k()
    {
      JSONArray localJSONArray = new JSONArray();
      try
      {
        localJSONArray.put(this.ip);
        localJSONArray.put(this.time);
        return localJSONArray;
      }
      catch (JSONException localJSONException) {}
      return localJSONArray;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqad
 * JD-Core Version:    0.7.0.1
 */