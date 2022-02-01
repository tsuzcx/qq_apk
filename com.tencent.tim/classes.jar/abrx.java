import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class abrx
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("CmShow_CmShowRenderView", 1, "openCmShowStore CmShow code:" + paramEIPCResult.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrx
 * JD-Core Version:    0.7.0.1
 */