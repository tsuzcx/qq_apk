import com.tencent.mobileqq.videoplatform.api.IReport;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class alln
  implements IReport
{
  public void report(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    anpc.a(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alln
 * JD-Core Version:    0.7.0.1
 */