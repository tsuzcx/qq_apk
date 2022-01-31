import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

final class tqi
  implements yvn<FeedCloudRead.StGetBusiInfoRsp>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QLog.i(tqg.c(), 1, "updateCircleInfo onReceive: isSuccess=" + paramBoolean + " retCode=" + paramLong);
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = paramStGetBusiInfoRsp.busiRspData.get();
      if (paramString != null) {
        paramStGetBusiInfoRsp = new QQCircleFeedBase.StBusiInfoData();
      }
    }
    try
    {
      paramStGetBusiInfoRsp.mergeFrom(paramString.toByteArray());
      tqg.a(paramStGetBusiInfoRsp.schoolInfos.get(), paramStGetBusiInfoRsp.companyInfos.get());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(tqg.c(), 1, "updateCircleInfo error", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqi
 * JD-Core Version:    0.7.0.1
 */