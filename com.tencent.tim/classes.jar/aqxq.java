import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class aqxq
  extends aquy
{
  aqxq(aqxp paramaqxp) {}
  
  public void onDone(aquz paramaquz)
  {
    if (paramaquz == null)
    {
      if (this.a.gk.size() > 0)
      {
        localObject = (String)this.a.gk.remove(0);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size()=" + this.a.gk.size() + ", url=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("VoiceChangeManager", 1, "picDownloadListener url = null");
          onDone(null);
        }
      }
      else
      {
        while (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size() = 0");
        return;
      }
      File localFile = new File(aqxp.CD() + ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1));
      if ((localFile.isFile()) && (localFile.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
        }
        onDone(null);
        return;
      }
      paramaquz = new Bundle();
      Object localObject = new aquz((String)localObject, localFile);
      ((aquz)localObject).cWw = true;
      ((aqva)this.a.mApp.getManager(47)).a(1).a((aquz)localObject, this.a.x, paramaquz);
      return;
    }
    super.onDone(paramaquz);
    paramaquz.getParams();
    if ((paramaquz.getStatus() == 3) && (paramaquz.errCode == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener downloadOk task.key = " + paramaquz.key);
      }
    }
    for (;;)
    {
      onDone(null);
      return;
      QLog.e("VoiceChangeManager", 1, "picDownloadListener download Error task.key = " + paramaquz.key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxq
 * JD-Core Version:    0.7.0.1
 */