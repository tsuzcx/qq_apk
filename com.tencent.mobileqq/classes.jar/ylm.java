import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.qphone.base.util.QLog;

public class ylm
  implements Runnable
{
  public ylm(ApolloCmdChannel paramApolloCmdChannel, IRenderRunner paramIRenderRunner, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackEngineWrapper(this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner.isJsRuntime(), this.jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner.getRuntimeState(), 0, "sc.apolloGameWebMessage.local", this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "handleWebEvent data:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylm
 * JD-Core Version:    0.7.0.1
 */