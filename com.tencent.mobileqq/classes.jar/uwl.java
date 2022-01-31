import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class uwl
  implements syq<tmi, tof>
{
  uwl(uwh paramuwh, JobContext paramJobContext, uvu paramuvu) {}
  
  public void a(@NonNull tmi paramtmi, @Nullable tof paramtof, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramtof == null) || (???.isFail())) {
      ved.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Uwh)
    {
      uwh.a(this.jdField_a_of_type_Uwh, paramtof);
      uwh.a(this.jdField_a_of_type_Uwh).remove(paramtmi);
      uwh.a(this.jdField_a_of_type_Uwh, this.jdField_a_of_type_Uvu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwl
 * JD-Core Version:    0.7.0.1
 */