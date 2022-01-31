import android.os.Process;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.mobileqq.app.FaceDownloader.FaceDownloadThreadInfo;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class zkb
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  
  public zkb(FaceDownloader paramFaceDownloader, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    Thread.currentThread().setName("FaceDownloadThread" + this.jdField_a_of_type_Int);
    if (FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader).b != -2147483648) {
      Process.setThreadPriority(FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader).b);
    }
    int j = 0;
    for (;;)
    {
      int i;
      if (((j < FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader)) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.size();
          if (i == 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          }
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.wait(30000L);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        i = j + 1;
        FaceInfo localFaceInfo = null;
        j = i;
        if (localFaceInfo == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.b(localFaceInfo);
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilHashSet.remove(localFaceInfo.c());
          Thread.yield();
          j = i;
          continue;
          if (i > FaceDownloader.b(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader))
          {
            localFaceInfo = (FaceInfo)this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
            break label405;
          }
          localFaceInfo = (FaceInfo)this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.remove(0);
          break label405;
          localObject1 = finally;
          throw localObject1;
        }
        synchronized (FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader))
        {
          if ((FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader) != null) && (this.jdField_a_of_type_Int < FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader).length))
          {
            FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader)[this.jdField_a_of_type_Int] = null;
            FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader)[this.jdField_a_of_type_Int] = null;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.b.decrementAndGet();
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDownloader", 2, "FaceDownloadThread thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
          }
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          continue;
          label405:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkb
 * JD-Core Version:    0.7.0.1
 */