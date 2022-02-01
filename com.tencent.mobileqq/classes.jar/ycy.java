import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class ycy
  implements wfk<wtb, wuy>
{
  ycy(ycu paramycu, JobContext paramJobContext, ych paramych) {}
  
  public void a(@NonNull wtb paramwtb, @Nullable wuy paramwuy, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramwuy == null) || (???.isFail())) {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Ycu)
    {
      ycu.a(this.jdField_a_of_type_Ycu, paramwuy);
      ycu.a(this.jdField_a_of_type_Ycu).remove(paramwtb);
      ycu.a(this.jdField_a_of_type_Ycu, this.jdField_a_of_type_Ych);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycy
 * JD-Core Version:    0.7.0.1
 */