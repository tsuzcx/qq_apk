import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

final class ouo
  implements rxc.a<FeedCloudRead.StGetBusiInfoRsp>
{
  ouo(QCircleGetTabListRequest paramQCircleGetTabListRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QLog.d("QCircleGlobalInfo", 1, "QCircleGlobalInfo->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.a.getCmdName() + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new QQCircleFeedBase.StBusiInfoData();
      paramStGetBusiInfoRsp = paramStGetBusiInfoRsp.busiRspData.get().toByteArray();
    }
    try
    {
      paramString.mergeFrom(paramStGetBusiInfoRsp);
      oum.dD(paramString.allPolyInfo.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ouo
 * JD-Core Version:    0.7.0.1
 */