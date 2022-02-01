import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public class opb
{
  public static boolean axV;
  public static final HashMap<String, String> eO = new HashMap();
  
  static
  {
    eO.put("1_1_1", "2020020023");
    eO.put("1_1_2", "2020020023");
    eO.put("1_1_3", "2020020024");
    eO.put("1_1_4", "2020020024");
    eO.put("1_1_5", "2020020057");
    eO.put("1_1_6", "2020020028");
    eO.put("1_1_7", "2020020116");
    eO.put("1_1_8", "2020020115");
    eO.put("1_1_13", "2020020427");
    eO.put("1_1_14", "2020020428");
    eO.put("1_1_101", "2020020026");
    eO.put("1_1_102", "2020020027");
    eO.put("1_1_103", "2020020160");
    eO.put("1_1_401", "2020020167");
    eO.put("1_2_1", "2020020082");
    eO.put("1_2_2", "2020020082");
    eO.put("1_2_3", "2020020083");
    eO.put("1_2_4", "2020020084");
    eO.put("1_2_5", "2020020085");
    eO.put("1_2_6", "2020020086");
    eO.put("1_2_7", "2020020118");
    eO.put("1_2_8", "2020020117");
    eO.put("1_2_100", "2020020032");
    eO.put("1_2_104", "2020020163");
    eO.put("1_2_13", "2020020427");
    eO.put("1_2_14", "2020020428");
    eO.put("1_2_101", "2020020026");
    eO.put("1_2_102", "2020020027");
    eO.put("1_2_103", "2020020160");
    eO.put("1_2_401", "2020020167");
    eO.put("1_3_1", "2020020072");
    eO.put("1_3_2", "2020020072");
    eO.put("1_3_3", "2020020073");
    eO.put("1_3_4", "2020020074");
    eO.put("1_3_5", "2020020075");
    eO.put("1_3_6", "2020020076");
    eO.put("1_3_7", "2020020120");
    eO.put("1_3_8", "2020020119");
    eO.put("1_3_13", "2020020427");
    eO.put("1_3_14", "2020020428");
    eO.put("1_4_1", "2020020077");
    eO.put("1_4_2", "2020020077");
    eO.put("1_4_3", "2020020078");
    eO.put("1_4_4", "2020020079");
    eO.put("1_4_5", "2020020080");
    eO.put("1_4_6", "2020020081");
    eO.put("1_4_7", "2020020122");
    eO.put("1_4_8", "2020020121");
    eO.put("1_4_13", "2020020427");
    eO.put("1_4_14", "2020020428");
    eO.put("1_4_300", "2020020071");
    eO.put("1_4_401", "2020020167");
    eO.put("1_5_1", "2020020031");
    eO.put("1_5_2", "2020020031");
    eO.put("1_5_3", "2020020032");
    eO.put("1_5_4", "2020020033");
    eO.put("1_5_5", "2020020034");
    eO.put("1_5_6", "2020020035");
    eO.put("1_5_7", "2020020053");
    eO.put("1_5_8", "2020020052");
    eO.put("1_5_301", "2020020030");
    eO.put("1_5_101", "2020020026");
    eO.put("1_5_102", "2020020027");
    eO.put("1_5_103", "2020020160");
    eO.put("1_6_1", "2020020037");
    eO.put("1_6_2", "2020020037");
    eO.put("1_6_3", "2020020038");
    eO.put("1_6_4", "2020020039");
    eO.put("1_6_5", "2020020040");
    eO.put("1_6_6", "2020020041");
    eO.put("1_6_7", "2020020055");
    eO.put("1_6_8", "2020020054");
    eO.put("1_6_302", "2020020036");
    eO.put("1_6_101", "2020020026");
    eO.put("1_6_102", "2020020027");
    eO.put("1_6_103", "2020020160");
    eO.put("2_0_1", "2020020059");
    eO.put("2_0_2", "2020020059");
    eO.put("2_0_3", "2020020060");
    eO.put("2_0_4", "2020020061");
    eO.put("2_0_5", "2020020062");
    eO.put("2_0_6", "2020020064");
    eO.put("2_0_7", "2020020114");
    eO.put("2_0_8", "2020020113");
    eO.put("3_0_200", "2020020029");
    eO.put("3_0_201", "20200200230");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2)))
    {
      ooz.e("WeishiScehmeUtil", "openWeishi context = " + paramContext + "scheme = " + paramString2);
      return;
    }
    String str = paramString2;
    if (!paramString2.contains("?")) {
      str = paramString2 + "?";
    }
    paramString2 = str;
    if (!str.contains("&logsour="))
    {
      paramString2 = f(paramInt1, paramInt2, paramInt3);
      paramString2 = str + "&logsour=" + paramString2;
    }
    ooz.w("WeishiScehmeUtil", "openWeishi final scheme = " + paramString2);
    p(paramContext, paramString1, paramString2);
  }
  
  public static String d(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (!TextUtils.isEmpty(paramstSimpleMetaFeed.id))) {
      return "weishi://feed?feed_id=" + paramstSimpleMetaFeed.id;
    }
    return "weishi://main";
  }
  
  public static boolean eH(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("weishi://"));
  }
  
  private static String f(int paramInt1, int paramInt2, int paramInt3)
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
      str = (String)eO.get(str);
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
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = opn.fA(paramString2);
    ooz.e("WeishiScehmeUtil", "openWeishi: scheme = " + paramString2);
    axV = true;
    rpw.p(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opb
 * JD-Core Version:    0.7.0.1
 */