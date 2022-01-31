import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;

class tzz
  implements zac<FeedCloudRead.StGetSessionInfoRsp>
{
  tzz(tzy paramtzy, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetSessionInfoRsp paramStGetSessionInfoRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStGetSessionInfoRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReportHelper", 1, "requestReportSession error:" + paramString);
    }
    tzy.a(this.jdField_a_of_type_Tzy, paramStGetSessionInfoRsp, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzz
 * JD-Core Version:    0.7.0.1
 */