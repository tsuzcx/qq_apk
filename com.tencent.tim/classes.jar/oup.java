import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

final class oup
  implements rxc.a<FeedCloudRead.StGetBusiInfoRsp>
{
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QLog.i("QCircleGlobalInfo", 1, "updateCircleInfo onReceive: isSuccess=" + paramBoolean + " retCode=" + paramLong);
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
      oum.r(paramStGetBusiInfoRsp.schoolInfos.get(), paramStGetBusiInfoRsp.companyInfos.get());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleGlobalInfo", 1, "updateCircleInfo error", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oup
 * JD-Core Version:    0.7.0.1
 */