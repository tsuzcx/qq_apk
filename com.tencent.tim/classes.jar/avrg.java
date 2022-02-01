import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;
import java.util.concurrent.CountDownLatch;

class avrg
  implements rxc.a<FeedCloudWrite.StDoFollowRsp>
{
  avrg(avre paramavre, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.i("QzoneIPCModule", 1, "flow qq circle resp " + paramBoolean + " " + paramLong + " " + paramString);
    this.B[0] = paramBoolean;
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrg
 * JD-Core Version:    0.7.0.1
 */