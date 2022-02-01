import com.tencent.TMG.utils.QLog;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

final class ove
  implements rxc.a<FeedCloudWrite.StDoLikeRsp>
{
  ove(rxc.a parama) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ove
 * JD-Core Version:    0.7.0.1
 */