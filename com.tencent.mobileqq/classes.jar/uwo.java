import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class uwo
  implements syt<tml, toi>
{
  uwo(uwk paramuwk, JobContext paramJobContext, uvx paramuvx) {}
  
  public void a(@NonNull tml paramtml, @Nullable toi paramtoi, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramtoi == null) || (???.isFail())) {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Uwk)
    {
      uwk.a(this.jdField_a_of_type_Uwk, paramtoi);
      uwk.a(this.jdField_a_of_type_Uwk).remove(paramtml);
      uwk.a(this.jdField_a_of_type_Uwk, this.jdField_a_of_type_Uvx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwo
 * JD-Core Version:    0.7.0.1
 */