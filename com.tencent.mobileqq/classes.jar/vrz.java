import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoData;
import qqcircle.QQCircleFeedBase.StRewardData;

class vrz
  implements aaav<FeedCloudRead.StGetBusiInfoRsp>
{
  vrz(vry paramvry, QCircleGetTabListRequest paramQCircleGetTabListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QLog.d(vry.a(), 1, vry.a() + "->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new QQCircleFeedBase.StBusiInfoData();
      paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
    }
    try
    {
      paramString.mergeFrom(paramStGetBusiInfoRsp);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Vry.a(paramString.allPolyInfo.get());
      }
      if (paramString.rewardData.myMoney.get() >= 0L) {
        this.jdField_a_of_type_Vry.a((float)paramString.rewardData.myMoney.get());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrz
 * JD-Core Version:    0.7.0.1
 */