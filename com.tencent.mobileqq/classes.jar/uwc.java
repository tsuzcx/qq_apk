import com.tencent.component.network.module.common.NetworkState;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class uwc
{
  private static uwb a;
  
  @NotNull
  public static Map<String, String> a(urt paramurt, boolean paramBoolean)
  {
    Object localObject = paramurt.jdField_a_of_type_Urw;
    HashMap localHashMap;
    if (localObject == null)
    {
      localObject = "0";
      paramurt = paramurt.jdField_a_of_type_Urx;
      localHashMap = new HashMap();
      localHashMap.put("video_total_time", String.valueOf(paramurt.c));
      localHashMap.put("video_play_time", localObject);
      localHashMap.put("videoid", paramurt.a);
      localHashMap.put("feedid", paramurt.a);
      localHashMap.put("author_uin", paramurt.jdField_e_of_type_JavaLangString);
      if (NetworkState.g().getNetworkType() != 1) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 2)
    {
      localHashMap.put("network", String.valueOf(i));
      localHashMap.put("video_type", String.valueOf(paramurt.jdField_e_of_type_Int));
      return localHashMap;
      localObject = String.valueOf(((urw)localObject).a(paramBoolean));
      break;
    }
  }
  
  public static void a()
  {
    if (a == null) {
      return;
    }
    a.d();
  }
  
  public static void a(int paramInt)
  {
    if (a == null) {
      return;
    }
    a.a(paramInt);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (a == null) {
      return;
    }
    a.a(paramInt1, paramInt2);
  }
  
  public static void a(String paramString)
  {
    if (a == null) {
      return;
    }
    a.c(paramString);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (a == null) {
      return;
    }
    a.a(paramString, paramInt1, paramInt2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a != null)
    {
      a.b(paramString2);
      a.a(paramString1);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    a = new uwb(uvz.a(paramString1));
    a(paramString2, paramString3);
  }
  
  public static void a(urt paramurt, boolean paramBoolean)
  {
    if (a == null) {}
    while ((paramurt == null) || (paramurt.jdField_a_of_type_Urx == null)) {
      return;
    }
    paramurt = a(paramurt, paramBoolean);
    a.a(paramurt);
  }
  
  public static void b()
  {
    if (a == null) {
      return;
    }
    a.a();
  }
  
  public static void b(int paramInt)
  {
    if (a == null) {
      return;
    }
    a.b(paramInt);
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    if (a == null) {
      return;
    }
    a.b(paramString, paramInt1, paramInt2);
  }
  
  public static void c()
  {
    if (a == null) {
      return;
    }
    a.b();
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    if (a == null) {
      return;
    }
    a.c(paramString, paramInt1, paramInt2);
  }
  
  public static void d()
  {
    if (a == null) {
      return;
    }
    a.c();
  }
  
  public static void e()
  {
    if (a == null) {
      return;
    }
    a.e();
  }
  
  public static void f()
  {
    if (a == null) {
      return;
    }
    a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwc
 * JD-Core Version:    0.7.0.1
 */