import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class qvp
  implements ppv.b<pyu, qag>
{
  qvp(qvl paramqvl, JobContext paramJobContext, qve.c paramc) {}
  
  public void a(@NonNull pyu parampyu, @Nullable qag paramqag, @NonNull ErrorMessage arg3)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramqag == null) || (???.isFail())) {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feature request, %s", new Object[] { ???.toString() });
    }
    synchronized (this.jdField_a_of_type_Qvl)
    {
      qvl.a(this.jdField_a_of_type_Qvl, paramqag);
      qvl.a(this.jdField_a_of_type_Qvl).remove(parampyu);
      qvl.a(this.jdField_a_of_type_Qvl, this.jdField_a_of_type_Qve$c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvp
 * JD-Core Version:    0.7.0.1
 */