import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class wpm
  implements urr<vfj, vhg>
{
  wpm(wpi paramwpi, JobContext paramJobContext, wov paramwov) {}
  
  public void a(@NonNull vfj paramvfj, @Nullable vhg paramvhg, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramvhg == null) || (???.isFail())) {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Wpi)
    {
      wpi.a(this.jdField_a_of_type_Wpi, paramvhg);
      wpi.a(this.jdField_a_of_type_Wpi).remove(paramvfj);
      wpi.a(this.jdField_a_of_type_Wpi, this.jdField_a_of_type_Wov);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpm
 * JD-Core Version:    0.7.0.1
 */