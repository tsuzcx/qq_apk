import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class yqn
  extends DownloadListener
{
  public yqn(File paramFile) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((3 == paramDownloadTask.a()) && (this.a.exists())) {}
    try
    {
      ZipUtils.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception paramDownloadTask)
    {
      paramDownloadTask = paramDownloadTask;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + paramDownloadTask.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception paramDownloadTask)
      {
        return;
      }
    }
    catch (OutOfMemoryError paramDownloadTask)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + paramDownloadTask.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception paramDownloadTask)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw paramDownloadTask;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqn
 * JD-Core Version:    0.7.0.1
 */