import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class xod
  implements vqp<weg, wgd>
{
  xod(xnz paramxnz, JobContext paramJobContext, xnm paramxnm) {}
  
  public void a(@NonNull weg paramweg, @Nullable wgd paramwgd, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramwgd == null) || (???.isFail())) {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Xnz)
    {
      xnz.a(this.jdField_a_of_type_Xnz, paramwgd);
      xnz.a(this.jdField_a_of_type_Xnz).remove(paramweg);
      xnz.a(this.jdField_a_of_type_Xnz, this.jdField_a_of_type_Xnm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xod
 * JD-Core Version:    0.7.0.1
 */