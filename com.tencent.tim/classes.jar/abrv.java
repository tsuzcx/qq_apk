import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class abrv
  implements EIPCResultCallback
{
  public abrv(abyv.a parama) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.access$002(true);
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      this.c.hO(1);
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk resp == null");
      return;
    }
    abxi.bjH = paramEIPCResult.getString("sApolloBaseScriptId");
    abhh.bCR = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    abhh.bCS = paramEIPCResult.getBoolean("sApolloEngineLockEnable");
    abxi.bjI = abxi.bim + "/script/" + abxi.bjH + "/";
    if (abyv.Zr()) {
      this.c.hO(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      abyv.b(this.c);
      abyv.a(this.c);
      abyv.loadSo("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrv
 * JD-Core Version:    0.7.0.1
 */