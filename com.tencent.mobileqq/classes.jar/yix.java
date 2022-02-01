import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class yix
  implements wld<wyv, xas>
{
  yix(yit paramyit, JobContext paramJobContext, yig paramyig) {}
  
  public void a(@NonNull wyv paramwyv, @Nullable xas paramxas, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramxas == null) || (???.isFail())) {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Yit)
    {
      yit.a(this.jdField_a_of_type_Yit, paramxas);
      yit.a(this.jdField_a_of_type_Yit).remove(paramwyv);
      yit.a(this.jdField_a_of_type_Yit, this.jdField_a_of_type_Yig);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yix
 * JD-Core Version:    0.7.0.1
 */