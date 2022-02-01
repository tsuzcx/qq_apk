import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajoi
{
  public long HR;
  public long HS;
  public long HU;
  public long HV;
  public String aSN = "";
  public String aSQ = "";
  public long ada;
  public long adb;
  public long adc;
  public boolean bdS;
  public boolean cpw;
  public String icon_static_url = "";
  public long type;
  public float xw;
  
  private static ajoi a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    ajoi localajoi = new ajoi();
    localajoi.type = paramJSONObject.optLong("type");
    localajoi.ada = paramJSONObject.optLong("level");
    localajoi.xw = ((float)paramJSONObject.optDouble("count", 0.0D));
    localajoi.adb = paramJSONObject.optLong("continue_days");
    localajoi.HR = paramJSONObject.optLong("last_action_time");
    localajoi.HS = paramJSONObject.optLong("last_change_time");
    localajoi.HU = paramJSONObject.optLong("icon_status");
    localajoi.HV = paramJSONObject.optLong("icon_status_end_time");
    localajoi.cpw = paramJSONObject.optBoolean("hasRemindInContact");
    localajoi.icon_static_url = paramJSONObject.optString("icon_static_url");
    localajoi.aSN = paramJSONObject.optString("icon_dynamic_url");
    localajoi.aSQ = paramJSONObject.optString("icon_name");
    localajoi.bdS = paramJSONObject.optBoolean("user_close_flag");
    return localajoi;
  }
  
  private JSONObject ab()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("level", this.ada);
      localJSONObject.put("count", this.xw);
      localJSONObject.put("continue_days", this.adb);
      localJSONObject.put("last_action_time", this.HR);
      localJSONObject.put("last_change_time", this.HS);
      localJSONObject.put("icon_status", this.HU);
      localJSONObject.put("icon_status_end_time", this.HV);
      localJSONObject.put("hasRemindInContact", this.cpw);
      localJSONObject.put("icon_static_url", this.icon_static_url);
      localJSONObject.put("icon_dynamic_url", this.aSN);
      localJSONObject.put("icon_name", this.aSQ);
      localJSONObject.put("user_close_flag", this.bdS);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("MutualMarkInfo", 1, "toJsonForStore error:" + localJSONException.getMessage());
    }
    return localJSONObject;
  }
  
  public static String b(ConcurrentHashMap<Long, ajoi> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((ajoi)localEntry.getValue()).ab());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, ajoi> b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkInfo", 1, "parseFrom json_str:" + paramString);
    }
    localConcurrentHashMap = new ConcurrentHashMap();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        ajoi localajoi = a(paramString.getJSONObject(i));
        if (localajoi != null) {
          localConcurrentHashMap.put(Long.valueOf(localajoi.type), localajoi);
        }
        i += 1;
      }
      return localConcurrentHashMap;
    }
    catch (JSONException paramString)
    {
      QLog.e("MutualMarkInfo", 1, "toJsonString error:" + paramString.getMessage());
    }
  }
  
  public boolean a(ajoj paramajoj)
  {
    this.type = paramajoj.type;
    this.ada = paramajoj.ada;
    this.xw = paramajoj.xw;
    this.adb = paramajoj.adb;
    this.HR = paramajoj.HR;
    this.HU = paramajoj.HU;
    this.HV = paramajoj.HV;
    this.icon_static_url = paramajoj.icon_static_url;
    this.aSN = paramajoj.aSN;
    this.aSQ = paramajoj.aSQ;
    this.bdS = paramajoj.bdS;
    if ((this.type == 17L) && (this.ada > 0L) && (TextUtils.isEmpty(this.icon_static_url))) {
      QLog.i("MutualMarkInfo", 1, "mergeFrom pull info resource invalid: " + this);
    }
    return true;
  }
  
  public boolean a(wkz.c paramc, long paramLong)
  {
    boolean bool2 = true;
    if (paramc.a != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.HR > 0L) && (paramc.a.HR < this.HR))
      {
        QLog.i("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramc.a.HR + " last_action_time:" + this.HR);
        return false;
      }
      this.type = paramc.relation_type;
      this.ada = paramc.a.HQ;
      if (paramc.a.HR > 0L) {
        this.HR = paramc.a.HR;
      }
      if (paramc.a.HS > 0L) {
        this.HS = paramc.a.HS;
      }
      this.adb = paramc.a.bOZ;
      this.HU = paramc.a.HU;
      if (paramLong == 11002L) {
        this.HV = paramc.a.HV;
      }
      if (this.HU != 2L) {
        this.HV = 0L;
      }
      this.icon_static_url = paramc.a.icon_static_url;
      this.aSN = paramc.a.aSN;
      this.aSQ = paramc.a.aSQ;
      this.bdS = paramc.a.bdS;
      bool1 = bool2;
      if (this.type == 17L)
      {
        bool1 = bool2;
        if (this.ada > 0L)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(this.icon_static_url)) {
            QLog.i("MutualMarkInfo", 1, "mergeFrom push info resource invalid: " + this);
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkInfo{");
    localStringBuilder.append("type=").append(this.type);
    localStringBuilder.append(", level=").append(this.ada);
    localStringBuilder.append(", count=").append(this.xw);
    localStringBuilder.append(", continue_days=").append(this.adb);
    localStringBuilder.append(", last_action_time=").append(this.HR);
    localStringBuilder.append(", last_change_time=").append(this.HS);
    localStringBuilder.append(", icon_status=").append(this.HU);
    localStringBuilder.append(", icon_status_end_time=").append(this.HV);
    localStringBuilder.append(", hasRemindInContact=").append(this.cpw);
    localStringBuilder.append(", remindAnimStartTime=").append(this.adc);
    localStringBuilder.append(", icon_static_url='").append(this.icon_static_url).append("'");
    localStringBuilder.append(", icon_dynamic_url='").append(this.aSN).append("'");
    localStringBuilder.append(", icon_name='").append(this.aSQ).append("'");
    localStringBuilder.append(", user_close_flag=").append(this.bdS);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajoi
 * JD-Core Version:    0.7.0.1
 */