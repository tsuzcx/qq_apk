import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class aibr
  implements Callable<File>
{
  aibr(aibq paramaibq) {}
  
  public File G()
    throws Exception
  {
    try
    {
      boolean bool = aibq.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.F();
      if (aibq.a(this.a) != null) {
        aibq.a(this.a).drV();
      }
      return localFile;
    }
    finally
    {
      aibq.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */