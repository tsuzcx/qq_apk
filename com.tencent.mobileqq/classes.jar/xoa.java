import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class xoa
  implements vqp<wdu, wdv>
{
  xoa(xnz paramxnz, JobContext paramJobContext, xnm paramxnm) {}
  
  public void a(@NonNull wdu paramwdu, @Nullable wdv arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    wdv localwdv = ???;
    if (??? == null) {
      localwdv = new wdv(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Xnz)
    {
      xnz.a(this.jdField_a_of_type_Xnz, localwdv);
      xnz.a(this.jdField_a_of_type_Xnz).remove(paramwdu);
      xnz.a(this.jdField_a_of_type_Xnz, this.jdField_a_of_type_Xnm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoa
 * JD-Core Version:    0.7.0.1
 */