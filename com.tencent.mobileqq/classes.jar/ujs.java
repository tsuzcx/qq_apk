import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class ujs
  implements slx<szp, tbm>
{
  ujs(ujo paramujo, JobContext paramJobContext, ujb paramujb) {}
  
  public void a(@NonNull szp paramszp, @Nullable tbm paramtbm, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramtbm == null) || (???.isFail())) {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Ujo)
    {
      ujo.a(this.jdField_a_of_type_Ujo, paramtbm);
      ujo.a(this.jdField_a_of_type_Ujo).remove(paramszp);
      ujo.a(this.jdField_a_of_type_Ujo, this.jdField_a_of_type_Ujb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujs
 * JD-Core Version:    0.7.0.1
 */