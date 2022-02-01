import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class qvm
  implements ppv.b<pyk, pyk.a>
{
  qvm(qvl paramqvl, JobContext paramJobContext, qve.c paramc) {}
  
  public void a(@NonNull pyk parampyk, @Nullable pyk.a arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    pyk.a locala = ???;
    if (??? == null) {
      locala = new pyk.a(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Qvl)
    {
      qvl.a(this.jdField_a_of_type_Qvl, locala);
      qvl.a(this.jdField_a_of_type_Qvl).remove(parampyk);
      qvl.a(this.jdField_a_of_type_Qvl, this.jdField_a_of_type_Qve$c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvm
 * JD-Core Version:    0.7.0.1
 */