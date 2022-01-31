import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class wld
  implements uni<vba, vcx>
{
  wld(wkz paramwkz, JobContext paramJobContext, wkm paramwkm) {}
  
  public void a(@NonNull vba paramvba, @Nullable vcx paramvcx, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramvcx == null) || (???.isFail())) {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Wkz)
    {
      wkz.a(this.jdField_a_of_type_Wkz, paramvcx);
      wkz.a(this.jdField_a_of_type_Wkz).remove(paramvba);
      wkz.a(this.jdField_a_of_type_Wkz, this.jdField_a_of_type_Wkm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wld
 * JD-Core Version:    0.7.0.1
 */