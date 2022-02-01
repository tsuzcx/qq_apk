import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class avuc
  implements EIPCResultCallback
{
  avuc(avua paramavua) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "startFontSoDownload download so success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuc
 * JD-Core Version:    0.7.0.1
 */