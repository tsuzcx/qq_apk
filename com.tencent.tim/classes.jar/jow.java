import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class jow
  extends aquy
{
  jow(jov paramjov) {}
  
  public void onDone(aquz paramaquz)
  {
    if (paramaquz.errCode == 0) {
      paramaquz = paramaquz.getParams().getString("file_path");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        File localFile = new File(paramaquz);
        String str = aqhq.readFileToString(localFile);
        if (QLog.isColorLevel()) {
          QLog.d("CommonConfigBase", 2, "onDone() content =  " + str + ", filePath = " + paramaquz);
        }
        localFile.delete();
        this.a.kY(str);
        this.a.kX(str);
        return;
      }
      catch (IOException paramaquz)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CommonConfigBase", 2, QLog.getStackTraceString(paramaquz));
        return;
      }
    }
    QLog.d("CommonConfigBase", 2, "onError(), errorCode = " + paramaquz.errCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jow
 * JD-Core Version:    0.7.0.1
 */