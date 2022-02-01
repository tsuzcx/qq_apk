import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class tlq
{
  public int a;
  public String a;
  public tls a;
  public String b = "";
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
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  
  public tlq()
  {
    this.jdField_a_of_type_Tls = new tls();
  }
  
  public static tlq a(String paramString, tlq paramtlq)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramtlq == null) {
      paramtlq = new tlq();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramtlq.l = paramString.optString("button_desc", "");
        paramtlq.s = paramString.optString("word_content_no_wifi", "");
        paramtlq.t = paramString.optString("word_content_wifi", "");
        paramtlq.u = paramString.optString("word_highlight", "");
        paramtlq.v = paramString.optString("word_highlight_color", "");
        paramtlq.w = paramString.optString("word_title", "");
        paramtlq.m = paramString.optString("detail_url", "");
        paramtlq.n = paramString.optString("activity_url", "");
        paramtlq.k = paramString.optString("game_icon", "");
        paramtlq.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramtlq;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramtlq.jdField_a_of_type_Tls = tls.a(str);
        return paramtlq;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramtlq;
      }
    }
  }
  
  public static tlq a(String paramString, tlq paramtlq, tlp paramtlp)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramtlq == null) {
      paramtlq = new tlq();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramtlq.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramtlq.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramtlq.b = paramString.optString("package_name", "");
        paramtlq.c = paramString.optString("business_type", "");
        paramtlq.d = paramString.optString("plat_form", "");
        paramtlq.e = paramString.optString("appid", "");
        paramtlq.f = paramString.optString("oper_type", "");
        paramtlq.r = paramString.optString("game_stage", "");
        paramtlq.g = paramString.optString("game_status", "");
        paramtlq.h = paramString.optString("game_kind", "");
        paramtlq.i = paramString.optString("game_sub_kind", "");
        paramtlq.j = paramString.optString("play_nums", "");
        paramtlq.o = paramString.optString("game_tags", "");
        paramtlq.p = paramString.optString("game_download_url", "");
        paramtlq.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramtlq.b)) {
          paramtlp.b = paramtlq.b;
        }
        if (!TextUtils.isEmpty(paramtlq.p)) {
          paramtlp.e = paramtlq.p;
        }
        paramString = paramtlq;
        if (TextUtils.isEmpty(paramtlq.e)) {
          break;
        }
        paramtlp.c = paramtlq.e;
        return paramtlq;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramtlq;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, tlq paramtlq, tlp paramtlp)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramtlq, paramtlp);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramtlq);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramtlp.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramtlq.b)))
    {
      paramtlq.b = paramtlp.b;
      paramtlq.x = String.valueOf(paramtlp.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlq
 * JD-Core Version:    0.7.0.1
 */