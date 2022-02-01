import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ufr
{
  public int a;
  public String a;
  public uft a;
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
  
  public ufr()
  {
    this.jdField_a_of_type_Uft = new uft();
  }
  
  public static ufr a(String paramString, ufr paramufr)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramufr == null) {
      paramufr = new ufr();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramufr.l = paramString.optString("button_desc", "");
        paramufr.s = paramString.optString("word_content_no_wifi", "");
        paramufr.t = paramString.optString("word_content_wifi", "");
        paramufr.u = paramString.optString("word_highlight", "");
        paramufr.v = paramString.optString("word_highlight_color", "");
        paramufr.w = paramString.optString("word_title", "");
        paramufr.m = paramString.optString("detail_url", "");
        paramufr.n = paramString.optString("activity_url", "");
        paramufr.k = paramString.optString("game_icon", "");
        paramufr.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramufr;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramufr.jdField_a_of_type_Uft = uft.a(str);
        return paramufr;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramufr;
      }
    }
  }
  
  public static ufr a(String paramString, ufr paramufr, ufq paramufq)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramufr == null) {
      paramufr = new ufr();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramufr.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramufr.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramufr.b = paramString.optString("package_name", "");
        paramufr.c = paramString.optString("business_type", "");
        paramufr.d = paramString.optString("plat_form", "");
        paramufr.e = paramString.optString("appid", "");
        paramufr.f = paramString.optString("oper_type", "");
        paramufr.r = paramString.optString("game_stage", "");
        paramufr.g = paramString.optString("game_status", "");
        paramufr.h = paramString.optString("game_kind", "");
        paramufr.i = paramString.optString("game_sub_kind", "");
        paramufr.j = paramString.optString("play_nums", "");
        paramufr.o = paramString.optString("game_tags", "");
        paramufr.p = paramString.optString("game_download_url", "");
        paramufr.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramufr.b)) {
          paramufq.b = paramufr.b;
        }
        if (!TextUtils.isEmpty(paramufr.p)) {
          paramufq.e = paramufr.p;
        }
        paramString = paramufr;
        if (TextUtils.isEmpty(paramufr.e)) {
          break;
        }
        paramufq.c = paramufr.e;
        return paramufr;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramufr;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, ufr paramufr, ufq paramufq)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramufr, paramufq);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramufr);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramufq.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramufr.b)))
    {
      paramufr.b = paramufq.b;
      paramufr.x = String.valueOf(paramufq.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufr
 * JD-Core Version:    0.7.0.1
 */