import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class znt
{
  public boolean brK = true;
  public Map<Integer, Boolean> iq = new HashMap();
  
  public static znt a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaeic[0].content);
    }
    localznt = new znt();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      int i;
      label93:
      int k;
      if (paramArrayOfaeic.optInt("allSwitch") == 1)
      {
        bool = true;
        localznt.brK = bool;
        paramArrayOfaeic = paramArrayOfaeic.optJSONArray("business");
        int j = paramArrayOfaeic.length();
        i = 0;
        if (i >= j) {
          break label174;
        }
        JSONObject localJSONObject = (JSONObject)paramArrayOfaeic.get(i);
        k = localJSONObject.optInt("id");
        if (localJSONObject.optInt("switch") != 1) {
          break label163;
        }
      }
      label163:
      for (boolean bool = true;; bool = false)
      {
        localznt.iq.put(Integer.valueOf(k), Boolean.valueOf(bool));
        i += 1;
        break label93;
        bool = false;
        break;
      }
      return localznt;
    }
    catch (Exception paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("allSwitch = ");
    localStringBuilder.append(this.brK);
    localStringBuilder.append(",businessSwitch: ");
    if (this.iq.size() > 0)
    {
      Iterator localIterator = this.iq.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        boolean bool = ((Boolean)this.iq.get(localInteger)).booleanValue();
        localStringBuilder.append(localInteger);
        localStringBuilder.append("=");
        localStringBuilder.append(bool);
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znt
 * JD-Core Version:    0.7.0.1
 */