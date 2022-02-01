import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class tmd
{
  public int a;
  public String a;
  public CopyOnWriteArrayList<tme> a;
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
  
  public tmd()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static tmd a(String paramString)
  {
    tmd localtmd = new tmd();
    try
    {
      paramString = new JSONObject(paramString);
      localtmd.jdField_a_of_type_JavaLangString = paramString.optString("more_btn_url");
      localtmd.jdField_b_of_type_JavaLangString = paramString.optString("trace_id");
      localtmd.d = paramString.optString("md_style");
      localtmd.f = paramString.optString("game_tips");
      localtmd.g = paramString.optString("game_tips_icon");
      localtmd.j = paramString.optString("game_id");
      localtmd.o = paramString.optString("game_name");
      localtmd.l = paramString.optString("game_icon");
      localtmd.m = paramString.optString("game_desc");
      localtmd.n = paramString.optString("game_btn_text");
      localtmd.k = paramString.optString("game_jump_url");
      localtmd.jdField_a_of_type_OrgJsonJSONArray = paramString.optJSONArray("app_picthree");
      localtmd.p = paramString.optString("article_title");
      localtmd.jdField_b_of_type_Int = paramString.optInt("card_size");
      localtmd.jdField_a_of_type_Int = paramString.optInt("style_type");
      localtmd.h = paramString.optString("left_big_img_url");
      localtmd.i = paramString.optString("background_img_url");
      int i1 = paramString.optInt("obj_type");
      if (i1 != 0) {
        localtmd.c = String.valueOf(i1);
      }
      if (localtmd.jdField_b_of_type_Int > 0)
      {
        a(paramString, localtmd.jdField_b_of_type_Int, localtmd);
        return localtmd;
      }
      a(paramString, 5, localtmd);
      return localtmd;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallMiniGameInfo", 2, "json error:" + paramString.getMessage());
      }
    }
    return localtmd;
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, tmd paramtmd)
  {
    paramtmd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      tme localtme = new tme();
      localtme.jdField_a_of_type_JavaLangString = paramJSONObject.optString("game_id" + i1);
      localtme.c = paramJSONObject.optString("game_slot_type" + i1);
      localtme.d = paramJSONObject.optString("game_title" + i1);
      localtme.jdField_b_of_type_JavaLangString = paramJSONObject.optString("game_url" + i1);
      paramtmd.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localtme);
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
        localStringBuilder.append(((tme)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
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
        str1 = ((tme)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
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
        str1 = ((tme)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmd
 * JD-Core Version:    0.7.0.1
 */