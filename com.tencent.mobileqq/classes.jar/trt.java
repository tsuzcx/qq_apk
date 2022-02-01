import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class trt
{
  public int a;
  public String a;
  public CopyOnWriteArrayList<tru> a;
  public JSONArray a;
  public int b;
  public String b;
  public String c = "2";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  
  public trt()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static trt a(String paramString)
  {
    trt localtrt = new trt();
    try
    {
      paramString = new JSONObject(paramString);
      localtrt.jdField_a_of_type_JavaLangString = paramString.optString("more_btn_url");
      localtrt.jdField_b_of_type_JavaLangString = paramString.optString("trace_id");
      localtrt.d = paramString.optString("md_style");
      localtrt.f = paramString.optString("game_tips");
      localtrt.g = paramString.optString("game_tips_icon");
      localtrt.j = paramString.optString("game_id");
      localtrt.o = paramString.optString("game_name");
      localtrt.l = paramString.optString("game_icon");
      localtrt.m = paramString.optString("game_desc");
      localtrt.n = paramString.optString("game_btn_text");
      localtrt.k = paramString.optString("game_jump_url");
      localtrt.jdField_a_of_type_OrgJsonJSONArray = paramString.optJSONArray("app_picthree");
      localtrt.p = paramString.optString("article_title");
      localtrt.jdField_b_of_type_Int = paramString.optInt("card_size");
      localtrt.jdField_a_of_type_Int = paramString.optInt("style_type");
      localtrt.h = paramString.optString("left_big_img_url");
      localtrt.i = paramString.optString("background_img_url");
      int i1 = paramString.optInt("obj_type");
      if (i1 != 0) {
        localtrt.c = String.valueOf(i1);
      }
      if (localtrt.jdField_b_of_type_Int > 0)
      {
        a(paramString, localtrt.jdField_b_of_type_Int, localtrt);
        return localtrt;
      }
      a(paramString, 5, localtrt);
      return localtrt;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallMiniGameInfo", 2, "json error:" + paramString.getMessage());
      }
    }
    return localtrt;
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, trt paramtrt)
  {
    paramtrt.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      tru localtru = new tru();
      localtru.jdField_a_of_type_JavaLangString = paramJSONObject.optString("game_id" + i1);
      localtru.c = paramJSONObject.optString("game_slot_type" + i1);
      localtru.d = paramJSONObject.optString("game_title" + i1);
      localtru.jdField_b_of_type_JavaLangString = paramJSONObject.optString("game_url" + i1);
      paramtrt.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localtru);
      i1 += 1;
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((tru)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > paramInt) {
        str1 = ((tru)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public String b(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > paramInt) {
        str1 = ((tru)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trt
 * JD-Core Version:    0.7.0.1
 */