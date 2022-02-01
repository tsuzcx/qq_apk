import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;

class pcs
  implements rxc.a<FeedCloudRead.StGetSessionInfoRsp>
{
  pcs(pcr parampcr, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetSessionInfoRsp paramStGetSessionInfoRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStGetSessionInfoRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReportHelper", 1, "requestReportSession error:" + paramString);
    }
    pcr.a(this.b, paramStGetSessionInfoRsp, this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcs
 * JD-Core Version:    0.7.0.1
 */