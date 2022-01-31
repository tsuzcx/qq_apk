import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class xpc
  implements Runnable
{
  public final int a;
  public final long a;
  public final File[] a;
  public long b;
  
  private xpc(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    paramString = new File(paramString);
    if (paramString.isDirectory()) {}
    for (this.jdField_a_of_type_ArrayOfJavaIoFile = paramString.listFiles();; this.jdField_a_of_type_ArrayOfJavaIoFile = null)
    {
      this.b = a();
      this.jdField_a_of_type_Int = paramInt;
      paramNewFlowCameraActivity.e("请稍候");
      return;
    }
  }
  
  private long a()
  {
    long l1 = 0L;
    long l2 = l1;
    if (this.jdField_a_of_type_ArrayOfJavaIoFile != null)
    {
      File[] arrayOfFile = this.jdField_a_of_type_ArrayOfJavaIoFile;
      int j = arrayOfFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = FileUtils.a(arrayOfFile[i].getAbsolutePath());
        i += 1;
        l1 = l2 + l1;
      }
    }
    return l2;
  }
  
  public void run()
  {
    long l = a();
    SLog.a("PTV.NewFlowCameraActivity", "recordTime = %d, currentLength = %d, old length = %d", Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(l), Long.valueOf(this.b));
    if (l == this.b)
    {
      StoryReportor.b("video_shoot", "wait_start_edit", 0, 0, new String[] { Build.MODEL.toLowerCase(), String.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.P();
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, this.jdField_a_of_type_Int);
      return;
    }
    this.b = l;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpc
 * JD-Core Version:    0.7.0.1
 */