import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class anwz
  implements Callable<File>
{
  anwz(anwy paramanwy) {}
  
  public File G()
    throws Exception
  {
    try
    {
      boolean bool = anwy.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.F();
      return localFile;
    }
    finally
    {
      anwy.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwz
 * JD-Core Version:    0.7.0.1
 */