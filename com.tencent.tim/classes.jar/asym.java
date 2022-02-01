import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.FilterManager.1;
import com.tencent.qqprotect.qsec.ICloudAVEngine.a;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asym
  implements asys
{
  private static volatile asym a;
  private static String cGa = "qp_fm_config";
  private static String cGb = "_last_time";
  private Map<String, asyl> pn = new HashMap();
  
  private boolean J(String paramString, long paramLong)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(cGa, 0);
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putLong(paramString + cGb, paramLong).commit();
      bool = true;
    }
    return bool;
  }
  
  private void YC(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new ICloudAVEngine.a(paramString);
    asye.a().cloudDetect(paramString, true, false, null);
  }
  
  public static asym a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new asym();
      }
      return a;
    }
    finally {}
  }
  
  private long n(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(cGa, 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString + cGb, paramLong);
    }
    return l;
  }
  
  public void E(String paramString, Object paramObject)
  {
    J(paramString, new Date().getTime());
    QLog.d("QSFM", 1, String.format("scan started: %s", new Object[] { paramString }));
  }
  
  public void F(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      asyl localasyl = a(paramString);
      if ((localasyl != null) && (localasyl.f(paramObject)))
      {
        YC(asyk.g(paramObject, "packageName").toString());
        if (localasyl.NZ() > 100000)
        {
          asxz localasxz = new asxz();
          Iterator localIterator = localasyl.hb().iterator();
          if (localIterator.hasNext())
          {
            paramString = asyk.h(paramObject, (String)localIterator.next());
            if (paramString != null) {}
            for (paramString = paramString.toString();; paramString = "")
            {
              localasxz.a(paramString);
              break;
            }
          }
          asxw.cN(localasxz.toString(), localasyl.NZ());
        }
      }
    }
  }
  
  public void G(String paramString, Object paramObject)
  {
    QLog.d("QSFM", 1, String.format("scan completed: %s", new Object[] { paramString }));
    asye.a().flushRequest();
  }
  
  public asyl a(String paramString)
  {
    return (asyl)this.pn.get(paramString);
  }
  
  public asyr a(String paramString)
  {
    asyt localasyt = null;
    if (paramString.equalsIgnoreCase("App")) {
      localasyt = new asyt(this);
    }
    return localasyt;
  }
  
  public void est()
  {
    Iterator localIterator = this.pn.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      long l1 = n((String)localObject, -1L);
      if (l1 != -1L)
      {
        long l2 = new Date().getTime();
        asyl localasyl = a((String)localObject);
        if ((localasyl != null) && (l2 - l1 < localasyl.getInterval() * 1000L))
        {
          QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l2 - l1), Long.valueOf(localasyl.getInterval() * 1000L) }));
          continue;
        }
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (asyr)localObject), 5, null, true);
      }
    }
  }
  
  public boolean v(byte[] paramArrayOfByte)
  {
    try
    {
      this.pn.clear();
      paramArrayOfByte = new JSONArray(new String(paramArrayOfByte));
      if (paramArrayOfByte != null)
      {
        int i = 0;
        while (i < paramArrayOfByte.length())
        {
          JSONObject localJSONObject = paramArrayOfByte.getJSONObject(i);
          if ((localJSONObject != null) && (localJSONObject.has("type"))) {
            this.pn.put(localJSONObject.getString("type"), new asyl(localJSONObject));
          }
          i += 1;
        }
      }
      return true;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asym
 * JD-Core Version:    0.7.0.1
 */