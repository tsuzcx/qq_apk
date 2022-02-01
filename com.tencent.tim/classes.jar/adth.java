import android.os.Bundle;
import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class adth
  implements EIPCResultCallback
{
  adth(adtg paramadtg, String paramString1, String paramString2, IArkDelegateNetCallback paramIArkDelegateNetCallback, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("ArkApp.ArkMultiProcUtil", 1, new Object[] { "ArkMultiProc.sendAppMsg cmd=", this.val$cmd, ", msg=", this.val$msg, ", ipc call back code=", Integer.valueOf(paramEIPCResult.code) });
    switch (paramEIPCResult.code)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback == null);
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onUpdate(this.cJP, false, null);
      return;
      paramEIPCResult = paramEIPCResult.data;
    } while ((paramEIPCResult == null) || (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback == null));
    int i = paramEIPCResult.getInt("type");
    boolean bool = paramEIPCResult.getBoolean("sucess");
    paramEIPCResult = paramEIPCResult.getString("data");
    this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onUpdate(i, bool, paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adth
 * JD-Core Version:    0.7.0.1
 */