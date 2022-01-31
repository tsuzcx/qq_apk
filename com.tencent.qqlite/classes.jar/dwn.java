import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.mobileqq.filemanager.util.UniformDownloader.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class dwn
  implements UniformDownloader.IUniformDownloaderListener
{
  public dwn(UniformDownloader paramUniformDownloader) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Iterator localIterator = UniformDownloader.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
        if (localIUniformDownloaderListener != null) {
          localIUniformDownloaderListener.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.a(paramInt, paramString, paramBundle);
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", UniformDownloader.a(this.a));
    paramBundle.putString("_CB_URL", UniformDownloader.a(this.a));
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      UniformDownloader.IUniformDownloaderListener localIUniformDownloaderListener = (UniformDownloader.IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwn
 * JD-Core Version:    0.7.0.1
 */