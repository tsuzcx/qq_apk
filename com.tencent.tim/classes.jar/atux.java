import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.PreviewAdderss;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;

class atux
  implements IWyFileSystem.IWyCallback<IWyFileSystem.PreviewAdderss>
{
  atux(atuw paramatuw) {}
  
  public void a(IWyFileSystem.PreviewAdderss paramPreviewAdderss)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onSucceed");
    }
    String str2 = aqhs.bytes2HexStr(paramPreviewAdderss.downloadKey);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.b.app.a().b(true, 278, new Object[] { Integer.valueOf(0), "", str1, paramPreviewAdderss.cookie, paramPreviewAdderss.downloadIp, paramPreviewAdderss.downloadHost, Integer.valueOf(paramPreviewAdderss.downloadPort) });
  }
  
  public void onFailed(IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onFailed,errCode[" + paramWyErrorStatus.errorCode + "],errMsg[" + paramWyErrorStatus.errorMsg + "]");
    }
    this.b.app.a().b(false, 278, new Object[] { Integer.valueOf(paramWyErrorStatus.errorCode), paramWyErrorStatus.errorMsg, "", "", "", "", Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atux
 * JD-Core Version:    0.7.0.1
 */