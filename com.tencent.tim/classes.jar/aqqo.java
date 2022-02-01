import android.os.Bundle;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule.Params;
import eipc.EIPCResult;

public class aqqo
  implements aqqm
{
  public aqqo(QuickUpdateIPCModule paramQuickUpdateIPCModule, int paramInt) {}
  
  public void I(int paramInt, String paramString1, String paramString2)
  {
    QuickUpdateIPCModule.Params localParams = new QuickUpdateIPCModule.Params(null);
    localParams.intVal = paramInt;
    localParams.strVal1 = paramString1;
    localParams.strVal2 = paramString2;
    paramString1 = new Bundle();
    paramString1.putSerializable("params", localParams);
    paramString1 = EIPCResult.createResult(0, paramString1);
    this.b.callbackResult(this.val$callbackId, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqo
 * JD-Core Version:    0.7.0.1
 */