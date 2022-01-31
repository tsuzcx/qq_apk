import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class fo
  extends DownloadListener
{
  public fo(FontManager paramFontManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onProgress|fontId" + paramDownloadTask.k + ", status=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + ", isCancel=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean + ", progress=" + paramDownloadTask.jdField_a_of_type_Float);
    }
  }
  
  public boolean a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onStart| task:" + paramDownloadTask.k + ", status=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + ", iCancel=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if (!paramDownloadTask.a().containsKey("callbackId")) {
      FontManager.a(this.a, "AIO_Font_download", paramDownloadTask.k);
    }
    for (;;)
    {
      return super.a(paramDownloadTask);
      FontManager.a(this.a, "Font_download", paramDownloadTask.k);
    }
  }
  
  public void b(DownloadTask paramDownloadTask)
  {
    FontManager.a(this.a, "Font_download_cancel", paramDownloadTask.k);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onCancel|font id=" + paramDownloadTask.k + ", status=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + ", isCancel=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
  }
  
  public void c(DownloadTask paramDownloadTask)
  {
    int i = 0;
    boolean bool;
    if (paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)
    {
      bool = FontManager.a(this.a, paramDownloadTask.k, paramDownloadTask.jdField_a_of_type_JavaIoFile);
      FontManager.a(this.a, "Font_download_succ", paramDownloadTask.k);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "onDone| task:" + paramDownloadTask.k + "status=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + ", iCancel=" + paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean + "succ=" + bool);
      }
      IPCDownloadListener localIPCDownloadListener;
      long l;
      if ((this.a.a != null) && (paramDownloadTask.a().containsKey("callbackId")))
      {
        localIPCDownloadListener = this.a.a;
        l = paramDownloadTask.k;
        if (!bool) {
          break label164;
        }
      }
      for (;;)
      {
        localIPCDownloadListener.onDone(l, i, paramDownloadTask.a());
        return;
        label164:
        i = -1;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fo
 * JD-Core Version:    0.7.0.1
 */