import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class axel
  implements EIPCResultCallback
{
  axel(axec paramaxec) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD onCallback");
    if (paramEIPCResult.code == 0)
    {
      QLog.d("AEGIFChunkPreviewFragment", 4, "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code == 0");
      return;
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "QIPC_ACTION_EMO_CREATE_GIF_AND_UPLOAD eipcResult.code != 0, eipcResult.code == ", Integer.valueOf(paramEIPCResult.code), ", msg = ", paramEIPCResult.e.getMessage() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axel
 * JD-Core Version:    0.7.0.1
 */