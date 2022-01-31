import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

public class ylq
  implements Runnable
{
  public ylq(ApolloRenderRunner paramApolloRenderRunner, IRenderRunner paramIRenderRunner, long paramLong, ApolloCmdChannel paramApolloCmdChannel, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner != null) && (this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner.getRuntimeState()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackEngineWrapper(this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner.isJsRuntime(), this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "apolloSurfaceView.queueEvent mNativeSSOReqMgr.callbackEngine cmd:" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylq
 * JD-Core Version:    0.7.0.1
 */