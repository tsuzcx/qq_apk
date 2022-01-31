import android.os.Process;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.mobileqq.app.FaceDownloader.FaceDownloadThreadInfo;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;

public class yzv
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  
  public yzv(FaceDownloader paramFaceDownloader, int paramInt)
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
      Object localObject1;
      if (((j < FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader)) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.size() > 0)) && (this.jdField_a_of_type_Boolean)) {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.size();
          if (i == 0)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader;
            ((FaceDownloader)localObject1).b += 1;
          }
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.wait(30000L);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader;
        ((FaceDownloader)localObject1).b -= 1;
        i = j + 1;
        localObject1 = null;
        j = i;
        if (localObject1 == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.b((FaceInfo)localObject1);
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilHashSet)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilHashSet.remove(((FaceInfo)localObject1).c());
          Thread.yield();
          j = i;
          continue;
          if (i > FaceDownloader.b(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader))
          {
            localObject1 = (FaceInfo)this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.remove(i - 1);
            break label398;
          }
          localObject1 = (FaceInfo)this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader.jdField_a_of_type_JavaUtilArrayList.remove(0);
          break label398;
          localObject2 = finally;
          throw localObject2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.FaceDownloader", 2, "FaceDownloadThread thread exit. isRunning=" + this.jdField_a_of_type_Boolean + ", id=" + this.jdField_a_of_type_Int);
        }
        if ((FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader) != null) && (this.jdField_a_of_type_Int < FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader).length))
        {
          FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader)[this.jdField_a_of_type_Int] = null;
          FaceDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader)[this.jdField_a_of_type_Int] = null;
        }
        FaceDownloader localFaceDownloader = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader;
        localFaceDownloader.c -= 1;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          continue;
          label398:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yzv
 * JD-Core Version:    0.7.0.1
 */