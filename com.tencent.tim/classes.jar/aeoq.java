import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aeoq
{
  public String bAa = "";
  public int cOk;
  public ArrayList<aeoq.a> vM = new ArrayList();
  
  public static aeoq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aeoq localaeoq = new aeoq();
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONArray("match");
        if (paramString == null) {
          break;
        }
        localaeoq.cOk = localJSONObject.optInt("switch");
        localaeoq.bAa = localJSONObject.optString("blackList");
        if (localaeoq.vM == null)
        {
          localaeoq.vM = new ArrayList();
          a(localaeoq);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            aeoq.a locala = new aeoq.a();
            locala.key = localJSONObject.optString("key");
            locala.resUrl = localJSONObject.optString("resUrl");
            locala.md5 = localJSONObject.optString("md5");
            localaeoq.vM.add(locala);
            break label235;
          }
        }
        else
        {
          localaeoq.vM.clear();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label233;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VipARConfBean", 1, "parse content exception = " + paramString.getMessage());
        paramString.printStackTrace();
        return null;
      }
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localaeoq.toString());
      label233:
      return localaeoq;
      label235:
      i += 1;
    }
  }
  
  private static void a(aeoq paramaeoq)
  {
    if ((paramaeoq == null) || (TextUtils.isEmpty(paramaeoq.bAa))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (awlg.aF(paramaeoq.bAa)) {
      paramaeoq.cOk = 0;
    }
  }
  
  @NonNull
  public String toString()
  {
    if (this.vM != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(" switch = " + this.cOk);
      Iterator localIterator = this.vM.iterator();
      while (localIterator.hasNext())
      {
        aeoq.a locala = (aeoq.a)localIterator.next();
        if (locala != null) {
          localStringBuilder.append("\n " + locala.toString());
        }
      }
      if ((this.vM == null) || (this.vM.size() == 0)) {
        localStringBuilder.append(" config list = null");
      }
      return localStringBuilder.toString();
    }
    return " switch = " + this.cOk + " list = null";
  }
  
  public static class a
  {
    public String key;
    public String md5;
    public String resUrl;
    
    @NonNull
    public String toString()
    {
      return " key = " + this.key + " resUrl = " + this.resUrl + " md5 = " + this.md5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoq
 * JD-Core Version:    0.7.0.1
 */