import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class yiu
  implements wld<wyj, wyk>
{
  yiu(yit paramyit, JobContext paramJobContext, yig paramyig) {}
  
  public void a(@NonNull wyj paramwyj, @Nullable wyk arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    wyk localwyk = ???;
    if (??? == null) {
      localwyk = new wyk(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Yit)
    {
      yit.a(this.jdField_a_of_type_Yit, localwyk);
      yit.a(this.jdField_a_of_type_Yit).remove(paramwyj);
      yit.a(this.jdField_a_of_type_Yit, this.jdField_a_of_type_Yig);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiu
 * JD-Core Version:    0.7.0.1
 */