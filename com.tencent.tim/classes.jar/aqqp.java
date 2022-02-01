import android.os.Bundle;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule.Params;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class aqqp
  implements EIPCResultCallback
{
  public aqqp(aqqm paramaqqm) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code != 0)
    {
      this.a.I(2, "", "");
      return;
    }
    paramEIPCResult = (QuickUpdateIPCModule.Params)paramEIPCResult.data.getSerializable("params");
    this.a.I(paramEIPCResult.intVal, paramEIPCResult.strVal1, paramEIPCResult.strVal2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqp
 * JD-Core Version:    0.7.0.1
 */