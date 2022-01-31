import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class ujp
  implements slx<szd, sze>
{
  ujp(ujo paramujo, JobContext paramJobContext, ujb paramujb) {}
  
  public void a(@NonNull szd paramszd, @Nullable sze arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    sze localsze = ???;
    if (??? == null) {
      localsze = new sze(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Ujo)
    {
      ujo.a(this.jdField_a_of_type_Ujo, localsze);
      ujo.a(this.jdField_a_of_type_Ujo).remove(paramszd);
      ujo.a(this.jdField_a_of_type_Ujo, this.jdField_a_of_type_Ujb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */