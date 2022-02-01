import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class ryj
  implements rxc.a<T>
{
  ryj(ryi paramryi, String paramString, VSBaseRequest paramVSBaseRequest, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, T paramT)
  {
    QLog.d("BaseListBlock", 1, this.aDu + "onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.us + " | isCache:" + this.aKx);
    this.jdField_a_of_type_Ryi.handleResponse(paramBoolean, this.us, paramLong, this.aDu, paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryj
 * JD-Core Version:    0.7.0.1
 */