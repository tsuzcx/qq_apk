import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public class ambl
{
  public static void an(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt));
    localHashMap.put("totalCost", String.valueOf(paramLong));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgCompleteInfo", true, paramLong, paramInt, localHashMap, "");
  }
  
  public static void bR(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt));
    anpc localanpc = anpc.a(BaseApplication.getContext());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localanpc.collectPerformance(null, "OrderMediaMsgSendTimeout", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public static void jt(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("idType", String.valueOf(paramInt2));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgAddTimeout", false, 0L, 0L, localHashMap, "");
  }
  
  public static void ju(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt1));
    localHashMap.put("mediaSize", String.valueOf(paramInt2));
    anpc localanpc = anpc.a(BaseApplication.getContext());
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(null, "OrderMediaMsgMultiSeperate", bool, 0L, paramInt1, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambl
 * JD-Core Version:    0.7.0.1
 */