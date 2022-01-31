import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureSoManager.Callback;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import eipc.EIPCResult;

public class ymu
  implements ReadInJoyCameraCaptureSoManager.Callback
{
  public ymu(CmGameServerQIPCModule paramCmGameServerQIPCModule, int paramInt) {}
  
  public void a(int paramInt)
  {
    CmGameServerQIPCModule.b = false;
    if (paramInt == 1)
    {
      EIPCResult localEIPCResult = EIPCResult.createResult(0, new Bundle());
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymu
 * JD-Core Version:    0.7.0.1
 */