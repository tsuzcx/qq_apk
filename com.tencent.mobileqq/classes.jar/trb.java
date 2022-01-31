import com.tencent.TMG.utils.QLog;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

final class trb
  implements zac<FeedCloudWrite.StDoLikeRsp>
{
  trb(zac paramzac) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    if ((paramBoolean) && (paramLong == 0L)) {
      QLog.d("doubleclicklike", 3, " success");
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(paramBoolean, paramLong, paramString, paramStDoLikeRsp);
      }
      return;
      QLog.d("doubleclicklike", 3, " failed：" + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trb
 * JD-Core Version:    0.7.0.1
 */