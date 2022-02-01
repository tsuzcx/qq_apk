import android.text.TextUtils;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afcj
{
  public long Xh;
  public int age;
  public String bCU = "";
  public int cQg;
  public int cQh;
  public String constellation = "";
  public int gender = 0;
  public String nickname;
  public int profession;
  public int state;
  
  public static afcj a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    afcj localafcj;
    do
    {
      return localObject;
      localafcj = new afcj();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localafcj.Xh = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localafcj.age = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localafcj.gender = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localafcj.nickname = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localafcj.state = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localafcj.cQh = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localafcj.constellation = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localafcj.profession = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localafcj.cQg = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localafcj;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localafcj.bCU = paramStrangerInfo.str_vipinfo.get();
    return localafcj;
  }
  
  public static afcj a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localafcj = new afcj();
    for (;;)
    {
      try
      {
        localafcj.Xh = paramJSONObject.getLong("open_id");
        localafcj.nickname = paramJSONObject.getString("nickname");
        localafcj.age = paramJSONObject.getInt("age");
        localafcj.gender = paramJSONObject.getInt("gender");
        localafcj.state = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localafcj.constellation = paramJSONObject.getString("constellation");
        localafcj.profession = paramJSONObject.getInt("profession");
        localafcj.cQg = paramJSONObject.getInt("emotion");
        localafcj.cQh = paramJSONObject.getInt("listIdx");
        localafcj.bCU = paramJSONObject.getString("vip");
        paramJSONObject = localafcj;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localafcj;
      }
    }
    return paramJSONObject;
  }
  
  public static JSONObject a(afcj paramafcj)
  {
    if (paramafcj == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramafcj.Xh);
      localJSONObject.put("nickname", paramafcj.nickname);
      localJSONObject.put("age", paramafcj.age);
      localJSONObject.put("gender", paramafcj.gender);
      localJSONObject.put("state", paramafcj.state);
      localJSONObject.put("constellation", paramafcj.constellation);
      localJSONObject.put("profession", paramafcj.profession);
      localJSONObject.put("emotion", paramafcj.cQg);
      localJSONObject.put("listIdx", paramafcj.cQh);
      localJSONObject.put("vip", paramafcj.bCU);
      return localJSONObject;
    }
    catch (JSONException paramafcj)
    {
      paramafcj.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static String pack(List<afcj> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((afcj)paramList.next());
      if (localJSONObject == null) {
        break label83;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label83:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static void x(List<afcj> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          afcj localafcj = a(paramString.getJSONObject(i));
          if (localafcj != null) {
            paramList.add(localafcj);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    if (((afcj)paramObject).Xh == this.Xh) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.Xh).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.Xh).append(",").append(this.nickname).append(",").append(this.age).append(",").append(this.gender).append(",").append(this.state).append(",").append(this.constellation).append(",").append(this.profession).append(",").append(this.cQg).append(",").append(this.cQh).append(",").append(this.bCU).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcj
 * JD-Core Version:    0.7.0.1
 */