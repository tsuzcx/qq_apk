import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aqrh
{
  public static void gt(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("authResult", String.valueOf(paramInt));
    anpc.a(BaseApplication.getContext()).collectPerformance("", paramString, false, 0L, -1L, localHashMap, "", true);
  }
  
  public static void is(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", paramString2);
    anpc.a(BaseApplication.getContext()).collectPerformance("", paramString1, false, 0L, -1L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrh
 * JD-Core Version:    0.7.0.1
 */