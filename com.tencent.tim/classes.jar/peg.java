import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;

class peg
  implements rxc.a<FeedCloudRead.StGetLightInteractListRsp>
{
  peg(pef parampef, QCircleGetLightInteractRequest paramQCircleGetLightInteractRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    boolean bool = VSNetworkHelper.fQ(paramString);
    QLog.d(pef.TAG, 1, "requestPolyList onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isCache:" + bool);
    this.b.a(paramBoolean, paramLong, this.azD, paramString, paramStGetLightInteractListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     peg
 * JD-Core Version:    0.7.0.1
 */