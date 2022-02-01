import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqrv
{
  private static aqrv a;
  private List<String> Jb = new CopyOnWriteArrayList();
  private final String TAG = "VipLongMsgShareDomainHelper";
  private List<String> whiteList = new CopyOnWriteArrayList();
  
  public aqrv()
  {
    this.Jb.add("vip.qq.com");
  }
  
  public static aqrv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqrv();
      }
      return a;
    }
    finally {}
  }
  
  public boolean rD(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = this.whiteList;
    Object localObject1 = localObject2;
    if (((List)localObject2).isEmpty()) {
      localObject1 = this.Jb;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (paramString.endsWith((String)localObject2))) {
        return true;
      }
    }
    return false;
  }
  
  public void x(JSONArray paramJSONArray)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipLongMsgShareDomainHelper", 2, "setConfigData data = " + paramJSONArray);
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONArray.length()) {
          return;
        }
        try
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optString("domain", "");
            this.whiteList.add(localObject);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("VipLongMsgShareDomainHelper", 1, "setConfigData exception ", localException);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrv
 * JD-Core Version:    0.7.0.1
 */