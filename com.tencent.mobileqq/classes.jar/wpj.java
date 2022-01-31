import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class wpj
  implements urr<vex, vey>
{
  wpj(wpi paramwpi, JobContext paramJobContext, wov paramwov) {}
  
  public void a(@NonNull vex paramvex, @Nullable vey arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    vey localvey = ???;
    if (??? == null) {
      localvey = new vey(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Wpi)
    {
      wpi.a(this.jdField_a_of_type_Wpi, localvey);
      wpi.a(this.jdField_a_of_type_Wpi).remove(paramvex);
      wpi.a(this.jdField_a_of_type_Wpi, this.jdField_a_of_type_Wov);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpj
 * JD-Core Version:    0.7.0.1
 */