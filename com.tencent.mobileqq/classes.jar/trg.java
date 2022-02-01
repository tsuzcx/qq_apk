import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class trg
{
  public int a;
  public String a;
  public tri a;
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
  
  public trg()
  {
    this.jdField_a_of_type_Tri = new tri();
  }
  
  public static trg a(String paramString, trg paramtrg)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramtrg == null) {
      paramtrg = new trg();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramtrg.l = paramString.optString("button_desc", "");
        paramtrg.s = paramString.optString("word_content_no_wifi", "");
        paramtrg.t = paramString.optString("word_content_wifi", "");
        paramtrg.u = paramString.optString("word_highlight", "");
        paramtrg.v = paramString.optString("word_highlight_color", "");
        paramtrg.w = paramString.optString("word_title", "");
        paramtrg.m = paramString.optString("detail_url", "");
        paramtrg.n = paramString.optString("activity_url", "");
        paramtrg.k = paramString.optString("game_icon", "");
        paramtrg.x = paramString.optString("component_type", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramtrg;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramtrg.jdField_a_of_type_Tri = tri.a(str);
        return paramtrg;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramtrg;
      }
    }
  }
  
  public static trg a(String paramString, trg paramtrg, trf paramtrf)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramtrg == null) {
      paramtrg = new trg();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramtrg.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramtrg.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramtrg.b = paramString.optString("package_name", "");
        paramtrg.c = paramString.optString("business_type", "");
        paramtrg.d = paramString.optString("plat_form", "");
        paramtrg.e = paramString.optString("appid", "");
        paramtrg.f = paramString.optString("oper_type", "");
        paramtrg.r = paramString.optString("game_stage", "");
        paramtrg.g = paramString.optString("game_status", "");
        paramtrg.h = paramString.optString("game_kind", "");
        paramtrg.i = paramString.optString("game_sub_kind", "");
        paramtrg.j = paramString.optString("play_nums", "");
        paramtrg.o = paramString.optString("game_tags", "");
        paramtrg.p = paramString.optString("game_download_url", "");
        paramtrg.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramtrg.b)) {
          paramtrf.b = paramtrg.b;
        }
        if (!TextUtils.isEmpty(paramtrg.p)) {
          paramtrf.e = paramtrg.p;
        }
        paramString = paramtrg;
        if (TextUtils.isEmpty(paramtrg.e)) {
          break;
        }
        paramtrf.c = paramtrg.e;
        return paramtrg;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramtrg;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, trg paramtrg, trf paramtrf)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramtrg, paramtrf);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramtrg);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramtrf.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramtrg.b)))
    {
      paramtrg.b = paramtrf.b;
      paramtrg.x = String.valueOf(paramtrf.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trg
 * JD-Core Version:    0.7.0.1
 */