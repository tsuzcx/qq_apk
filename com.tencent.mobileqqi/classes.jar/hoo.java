import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.ResourceUpdater;
import com.tencent.open.appcommon.TaskThread;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;

public class hoo
  implements Runnable
{
  public hoo(TaskThread paramTaskThread, int paramInt) {}
  
  public void run()
  {
    try
    {
      switch (this.jdField_a_of_type_Int)
      {
      case 1: 
        if (!Common.a()) {
          return;
        }
        LogUtility.c(TaskThread.a, "try check md5");
        ResourceUpdater.a();
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(TaskThread.a, "runTask exception", localException);
      return;
    }
    TaskThread.a(CommonDataAdapter.a().a());
    return;
    FileUtils.a("Page/system", Common.f());
    return;
    this.jdField_a_of_type_ComTencentOpenAppcommonTaskThread.a(true, null);
    return;
    LogUtility.b(TaskThread.a, ">>start reset js ,del local and copy from assets");
    this.jdField_a_of_type_ComTencentOpenAppcommonTaskThread.a(false, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hoo
 * JD-Core Version:    0.7.0.1
 */