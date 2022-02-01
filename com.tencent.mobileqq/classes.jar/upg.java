import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public class upg
{
  public static final HashMap<String, String> a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("1_1_1", "2020020023");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_2", "2020020023");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_3", "2020020024");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_4", "2020020024");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_5", "2020020057");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_6", "2020020028");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_7", "2020020116");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_8", "2020020115");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_13", "2020020427");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_14", "2020020428");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_101", "2020020026");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_102", "2020020027");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_103", "2020020160");
    jdField_a_of_type_JavaUtilHashMap.put("1_1_401", "2020020167");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_1", "2020020082");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_2", "2020020082");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_3", "2020020083");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_4", "2020020084");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_5", "2020020085");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_6", "2020020086");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_7", "2020020118");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_8", "2020020117");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_100", "2020020032");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_104", "2020020163");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_13", "2020020427");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_14", "2020020428");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_101", "2020020026");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_102", "2020020027");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_103", "2020020160");
    jdField_a_of_type_JavaUtilHashMap.put("1_2_401", "2020020167");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_1", "2020020072");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_2", "2020020072");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_3", "2020020073");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_4", "2020020074");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_5", "2020020075");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_6", "2020020076");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_7", "2020020120");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_8", "2020020119");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_13", "2020020427");
    jdField_a_of_type_JavaUtilHashMap.put("1_3_14", "2020020428");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_1", "2020020077");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_2", "2020020077");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_3", "2020020078");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_4", "2020020079");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_5", "2020020080");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_6", "2020020081");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_7", "2020020122");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_8", "2020020121");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_13", "2020020427");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_14", "2020020428");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_300", "2020020071");
    jdField_a_of_type_JavaUtilHashMap.put("1_4_401", "2020020167");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_1", "2020020031");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_2", "2020020031");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_3", "2020020032");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_4", "2020020033");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_5", "2020020034");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_6", "2020020035");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_7", "2020020053");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_8", "2020020052");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_301", "2020020030");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_101", "2020020026");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_102", "2020020027");
    jdField_a_of_type_JavaUtilHashMap.put("1_5_103", "2020020160");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_1", "2020020037");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_2", "2020020037");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_3", "2020020038");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_4", "2020020039");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_5", "2020020040");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_6", "2020020041");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_7", "2020020055");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_8", "2020020054");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_302", "2020020036");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_101", "2020020026");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_102", "2020020027");
    jdField_a_of_type_JavaUtilHashMap.put("1_6_103", "2020020160");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_1", "2020020059");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_2", "2020020059");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_3", "2020020060");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_4", "2020020061");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_5", "2020020062");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_6", "2020020064");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_7", "2020020114");
    jdField_a_of_type_JavaUtilHashMap.put("2_0_8", "2020020113");
    jdField_a_of_type_JavaUtilHashMap.put("3_0_200", "2020020029");
    jdField_a_of_type_JavaUtilHashMap.put("3_0_201", "20200200230");
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label72;
      }
      label8:
      if (paramInt3 <= 0) {
        break label77;
      }
    }
    for (;;)
    {
      String str = paramInt1 + "_" + paramInt2 + "_" + paramInt3;
      str = (String)jdField_a_of_type_JavaUtilHashMap.get(str);
      if (TextUtils.isEmpty(str)) {
        break label82;
      }
      return str;
      paramInt1 = 0;
      break;
      label72:
      paramInt2 = 0;
      break label8;
      label77:
      paramInt3 = 0;
    }
    label82:
    return "2020020063";
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id;
    }
    return "weishi://main";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = ups.b(paramString2);
    upe.d("WeishiScehmeUtil", "openWeishi: scheme = " + paramString2);
    jdField_a_of_type_Boolean = true;
    zmi.a(paramContext, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      upe.d("WeishiScehmeUtil", "openWeishi context = " + paramContext + "scheme = " + paramString2);
      return;
    }
    String str = paramString2;
    if (!paramString2.contains("?")) {
      str = paramString2 + "?";
    }
    paramString2 = str;
    if (!str.contains("&logsour="))
    {
      paramString2 = a(paramInt1, paramInt2, paramInt3);
      paramString2 = str + "&logsour=" + paramString2;
    }
    upe.c("WeishiScehmeUtil", "openWeishi final scheme = " + paramString2);
    a(paramContext, paramString1, paramString2);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("weishi://"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upg
 * JD-Core Version:    0.7.0.1
 */