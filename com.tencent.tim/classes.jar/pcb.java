import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class pcb
  implements rxc.a<FeedCloudRead.StGetBusiInfoRsp>
{
  pcb(pca parampca, QCircleGetTabListRequest paramQCircleGetTabListRequest, ryt paramryt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if (this.jdField_a_of_type_Ryt != null) {
      this.jdField_a_of_type_Ryt.u(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetBusiInfoRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcb
 * JD-Core Version:    0.7.0.1
 */