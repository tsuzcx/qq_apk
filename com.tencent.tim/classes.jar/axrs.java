import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class axrs
  implements rqi
{
  axrs(String paramString, axsf paramaxsf) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onFailure: invoked. info: Failed to convert sample rate. message = " + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    File localFile = new File(this.cVS);
    if ((this.a != null) && (localFile.exists()))
    {
      this.a.E(localFile);
      this.a.eOB();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("HumUtils", 2, "onFinish: audioFile not exist. audioFile = " + localFile);
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onStart: invoked. info: ");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onSuccess: invoked. info: message = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrs
 * JD-Core Version:    0.7.0.1
 */