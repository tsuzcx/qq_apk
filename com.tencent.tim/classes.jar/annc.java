import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.StatisticCollector.Proxy;
import java.util.HashMap;

public final class annc
  implements IMCoreProxyRoute.StatisticCollector.Proxy
{
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public void collectPerformance(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3, boolean paramBoolean2)
  {
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramHashMap, paramString3, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annc
 * JD-Core Version:    0.7.0.1
 */