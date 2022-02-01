import com.tencent.pts.nativemodule.PTSNativeModuleRegistry.IPTSMarkArticleRead;
import com.tencent.qphone.base.util.QLog;

public class lvs
  implements PTSNativeModuleRegistry.IPTSMarkArticleRead
{
  public final String TAG = "PTSMarkArticleReadModule";
  
  public void markArticleRead(long paramLong1, long paramLong2)
  {
    QLog.i("PTSMarkArticleReadModule", 1, "[markArticleRead], articleID = " + paramLong1 + ", channelID = " + paramLong2);
    try
    {
      lbz.a().H(paramLong1, System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSMarkArticleReadModule", 1, "[markArticleRead], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvs
 * JD-Core Version:    0.7.0.1
 */