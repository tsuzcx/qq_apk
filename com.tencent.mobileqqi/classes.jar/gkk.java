import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class gkk
  implements CrashHandleListener
{
  public gkk(StatisticCollector paramStatisticCollector) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean) {}
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gkk
 * JD-Core Version:    0.7.0.1
 */