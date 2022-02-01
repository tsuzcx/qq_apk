import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class xpj
  extends aquy
{
  xpj(xpg paramxpg, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onCancel| task:" + paramaquz);
    }
  }
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onDone| task:" + paramaquz);
    }
    if (paramaquz.isCancel()) {}
    do
    {
      return;
      paramaquz.getParams().getInt("type");
    } while (paramaquz.getStatus() == -1);
    paramaquz = new Message();
    paramaquz.what = xpg.bVS;
    this.a.mHandler.sendMessage(paramaquz);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "coverDownloadListener.onStart| task:" + paramaquz);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpj
 * JD-Core Version:    0.7.0.1
 */