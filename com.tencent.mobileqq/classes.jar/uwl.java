import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class uwl
  implements syt<tlz, tma>
{
  uwl(uwk paramuwk, JobContext paramJobContext, uvx paramuvx) {}
  
  public void a(@NonNull tlz paramtlz, @Nullable tma arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    tma localtma = ???;
    if (??? == null) {
      localtma = new tma(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Uwk)
    {
      uwk.a(this.jdField_a_of_type_Uwk, localtma);
      uwk.a(this.jdField_a_of_type_Uwk).remove(paramtlz);
      uwk.a(this.jdField_a_of_type_Uwk, this.jdField_a_of_type_Uvx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwl
 * JD-Core Version:    0.7.0.1
 */