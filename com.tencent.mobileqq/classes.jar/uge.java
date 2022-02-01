import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class uge
{
  public int a;
  public String a;
  public CopyOnWriteArrayList<ugf> a;
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
  
  public uge()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static uge a(String paramString)
  {
    uge localuge = new uge();
    try
    {
      paramString = new JSONObject(paramString);
      localuge.jdField_a_of_type_JavaLangString = paramString.optString("more_btn_url");
      localuge.jdField_b_of_type_JavaLangString = paramString.optString("trace_id");
      localuge.d = paramString.optString("md_style");
      localuge.f = paramString.optString("game_tips");
      localuge.g = paramString.optString("game_tips_icon");
      localuge.j = paramString.optString("game_id");
      localuge.o = paramString.optString("game_name");
      localuge.l = paramString.optString("game_icon");
      localuge.m = paramString.optString("game_desc");
      localuge.n = paramString.optString("game_btn_text");
      localuge.k = paramString.optString("game_jump_url");
      localuge.jdField_a_of_type_OrgJsonJSONArray = paramString.optJSONArray("app_picthree");
      localuge.p = paramString.optString("article_title");
      localuge.jdField_b_of_type_Int = paramString.optInt("card_size");
      localuge.jdField_a_of_type_Int = paramString.optInt("style_type");
      localuge.h = paramString.optString("left_big_img_url");
      localuge.i = paramString.optString("background_img_url");
      int i1 = paramString.optInt("obj_type");
      if (i1 != 0) {
        localuge.c = String.valueOf(i1);
      }
      if (localuge.jdField_b_of_type_Int > 0)
      {
        a(paramString, localuge.jdField_b_of_type_Int, localuge);
        return localuge;
      }
      a(paramString, 5, localuge);
      return localuge;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallMiniGameInfo", 2, "json error:" + paramString.getMessage());
      }
    }
    return localuge;
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, uge paramuge)
  {
    paramuge.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      ugf localugf = new ugf();
      localugf.jdField_a_of_type_JavaLangString = paramJSONObject.optString("game_id" + i1);
      localugf.c = paramJSONObject.optString("game_slot_type" + i1);
      localugf.d = paramJSONObject.optString("game_title" + i1);
      localugf.jdField_b_of_type_JavaLangString = paramJSONObject.optString("game_url" + i1);
      paramuge.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localugf);
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
        localStringBuilder.append(((ugf)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
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
        str1 = ((ugf)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
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
        str1 = ((ugf)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uge
 * JD-Core Version:    0.7.0.1
 */