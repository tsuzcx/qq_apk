import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wxk
{
  public static int a;
  public static long a;
  public static String a;
  public static int b;
  public static long b;
  public static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  private static int a()
  {
    if (jdField_a_of_type_JavaLangString.equals("grp_tribe")) {
      return 4;
    }
    if (jdField_a_of_type_JavaLangString.equals("grp_qq")) {
      return 1;
    }
    if (jdField_a_of_type_JavaLangString.equals("grp_readinjoy")) {
      return 5;
    }
    return 2;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "grp_qq_pic_base";
    case 2: 
      return "grp_qq_pic_base";
    case 3: 
      return "grp_qq_pic_qzone";
    }
    return "grp_qq_pic_kandian";
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if ((paramInt == 101) || (paramInt == 102))
    {
      if (b()) {
        b(paramString);
      }
    }
    else {
      return;
    }
    a(paramString);
  }
  
  public static void a(long paramLong, String paramString)
  {
    if ((paramLong > 0L) && (jdField_a_of_type_Long > 0L) && (jdField_b_of_type_Long > 0L) && (!TextUtils.isEmpty(paramString)) && (a()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("create_duration", String.valueOf((jdField_b_of_type_Long - jdField_a_of_type_Long) / 1000.0D));
      localHashMap.put("frame_duration", String.valueOf((paramLong - jdField_a_of_type_Long) / 1000.0D));
      paramLong -= jdField_a_of_type_Long;
      azri.a(BaseApplicationImpl.getContext()).a(paramString, "actShortVideoEdit", true, paramLong, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("VideoEditReport", 2, "create_duration:" + (String)localHashMap.get("create_duration") + ", frame_duration:" + (String)localHashMap.get("frame_duration") + ", frameDuration:" + paramLong);
      }
      jdField_a_of_type_Long = 0L;
      jdField_b_of_type_Long = 0L;
    }
  }
  
  public static void a(String paramString)
  {
    if (!a()) {
      return;
    }
    azqs.b(null, "dc00898", "", "", paramString, paramString, a(), 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (!a()) {
      return;
    }
    azqs.b(null, "dc00898", "", "", paramString, paramString, a(), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    int i;
    if (b())
    {
      i = 1;
      if (!jdField_a_of_type_JavaLangString.equalsIgnoreCase("grp_qq_pic_qzone")) {
        break label43;
      }
      i = 2;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", paramString1, paramString1, i, 0, "", "", paramString2, "");
      return;
      label43:
      if (jdField_a_of_type_JavaLangString.equalsIgnoreCase("grp_qq_pic_kandian")) {
        i = 3;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!a()) {
      return;
    }
    azqs.b(null, "dc00898", "", "", paramString1, paramString1, a(), 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static boolean a()
  {
    return ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (jdField_a_of_type_JavaLangString.equals("grp_qq"))) || (jdField_a_of_type_JavaLangString.equals("grp_qzone")) || (jdField_a_of_type_JavaLangString.equals("grp_tribe")) || (jdField_a_of_type_JavaLangString.equals("grp_readinjoy"));
  }
  
  public static void b(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
  }
  
  public static void b(String paramString)
  {
    a(paramString, "");
  }
  
  public static void b(String paramString, int paramInt)
  {
    int i;
    if (b())
    {
      i = 1;
      if (!jdField_a_of_type_JavaLangString.equalsIgnoreCase("grp_qq_pic_qzone")) {
        break label46;
      }
      i = 2;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", paramString, paramString, i, 0, String.valueOf(paramInt), "", "", "");
      return;
      label46:
      if (jdField_a_of_type_JavaLangString.equalsIgnoreCase("grp_qq_pic_kandian")) {
        i = 3;
      }
    }
  }
  
  private static boolean b()
  {
    return (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && ((jdField_a_of_type_JavaLangString.equals("grp_qq_pic_base")) || (jdField_a_of_type_JavaLangString.equals("grp_qq_pic_qzone")) || (jdField_a_of_type_JavaLangString.equals("grp_qq_pic_kandian")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxk
 * JD-Core Version:    0.7.0.1
 */