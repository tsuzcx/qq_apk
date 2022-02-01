import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class ycv
  implements wfk<wsp, wsq>
{
  ycv(ycu paramycu, JobContext paramJobContext, ych paramych) {}
  
  public void a(@NonNull wsp paramwsp, @Nullable wsq arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    wsq localwsq = ???;
    if (??? == null) {
      localwsq = new wsq(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Ycu)
    {
      ycu.a(this.jdField_a_of_type_Ycu, localwsq);
      ycu.a(this.jdField_a_of_type_Ycu).remove(paramwsp);
      ycu.a(this.jdField_a_of_type_Ycu, this.jdField_a_of_type_Ych);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycv
 * JD-Core Version:    0.7.0.1
 */