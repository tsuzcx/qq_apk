import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class zyw
  implements zxa<T>
{
  zyw(zyv paramzyv, String paramString, VSBaseRequest paramVSBaseRequest, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onReceive(boolean paramBoolean, long paramLong, String paramString, T paramT)
  {
    QLog.d(this.jdField_a_of_type_Zyv.getLogTag(), 1, this.jdField_a_of_type_JavaLangString + "onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + this.b);
    this.jdField_a_of_type_Zyv.handleResponse(paramBoolean, this.jdField_a_of_type_Boolean, paramLong, this.jdField_a_of_type_JavaLangString, paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyw
 * JD-Core Version:    0.7.0.1
 */