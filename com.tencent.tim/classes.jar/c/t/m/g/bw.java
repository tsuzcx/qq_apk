package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

final class bw
{
  public static final bw a = new bw();
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public final Bundle m = new Bundle();
  
  bw() {}
  
  private bw(bw parambw)
  {
    if (parambw.m.size() > 0)
    {
      this.m.putAll(parambw.m);
      return;
    }
    this.b = parambw.b;
    this.c = parambw.c;
    this.d = parambw.d;
    this.e = parambw.e;
    this.f = parambw.f;
    this.g = parambw.g;
    this.h = parambw.h;
    this.i = parambw.i;
    this.j = parambw.j;
    this.k = parambw.k;
    this.l = parambw.l;
  }
  
  public bw(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      if (paramJSONObject.has("admin_level_1"))
      {
        str1 = paramJSONObject.getString("nation");
        String str2 = paramJSONObject.getString("admin_level_1");
        String str3 = paramJSONObject.getString("admin_level_2");
        String str4 = paramJSONObject.getString("admin_level_3");
        String str5 = paramJSONObject.getString("locality");
        String str6 = paramJSONObject.getString("sublocality");
        paramJSONObject = paramJSONObject.getString("route");
        this.m.putString("nation", str1);
        this.m.putString("admin_level_1", str2);
        this.m.putString("admin_level_2", str3);
        this.m.putString("admin_level_3", str4);
        this.m.putString("locality", str5);
        this.m.putString("sublocality", str6);
        this.m.putString("route", paramJSONObject);
        return;
      }
      this.c = paramJSONObject.getString("name");
      this.d = paramJSONObject.getString("code");
      this.b = paramJSONObject.getString("nation");
      this.e = paramJSONObject.getString("province");
      this.f = paramJSONObject.getString("city");
      this.g = paramJSONObject.getString("district");
      this.h = paramJSONObject.getString("town");
      this.i = paramJSONObject.getString("village");
      this.j = paramJSONObject.getString("street");
      this.k = paramJSONObject.getString("street_no");
      String str1 = paramJSONObject.optString("mergedname");
      paramJSONObject = paramJSONObject.optString("mergedaddr");
      if (!TextUtils.isEmpty(str1)) {
        this.c = str1;
      }
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.l = paramJSONObject;
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
  
  public static bw a(bw parambw)
  {
    if (parambw == null) {
      return null;
    }
    return new bw(parambw);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubnationData{");
    localStringBuilder.append("name=").append(this.c).append(",");
    localStringBuilder.append("address=").append(this.l).append(",");
    localStringBuilder.append("code=").append(this.d).append(",");
    localStringBuilder.append("nation=").append(this.b).append(",");
    localStringBuilder.append("province=").append(this.e).append(",");
    localStringBuilder.append("city=").append(this.f).append(",");
    localStringBuilder.append("district=").append(this.g).append(",");
    localStringBuilder.append("town=").append(this.h).append(",");
    localStringBuilder.append("village=").append(this.i).append(",");
    localStringBuilder.append("street=").append(this.j).append(",");
    localStringBuilder.append("street_no=").append(this.k).append(",");
    localStringBuilder.append("bundle").append(this.m).append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bw
 * JD-Core Version:    0.7.0.1
 */