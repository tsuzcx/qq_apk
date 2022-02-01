import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class pch
  implements rxc.a<FeedCloudRead.StGetFeedListRsp>
{
  pch(pcg parampcg, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, ryt paramryt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    QLog.d("QCircleTagPreLoaderTask", 1, "QCircleTagPreLoaderTask->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.b.getCmdName() + " | TraceId:" + this.b.getTraceId() + " | SeqId:" + this.b.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if (this.jdField_a_of_type_Ryt != null) {
      this.jdField_a_of_type_Ryt.u(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetFeedListRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pch
 * JD-Core Version:    0.7.0.1
 */