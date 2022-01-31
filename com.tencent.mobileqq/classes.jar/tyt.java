import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;

class tyt
  implements zac<T>
{
  tyt(tys paramtys, String paramString, QCircleBaseRequest paramQCircleBaseRequest, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, T paramT)
  {
    QLog.d("QCircleBaseListAdapter", 1, this.jdField_a_of_type_JavaLangString + "onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleBaseRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + this.b);
    this.jdField_a_of_type_Tys.handleResponse(paramBoolean, this.jdField_a_of_type_Boolean, paramLong, this.jdField_a_of_type_JavaLangString, paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyt
 * JD-Core Version:    0.7.0.1
 */