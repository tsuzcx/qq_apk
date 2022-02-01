import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class qvo
  implements ppv.b<pyj, pyj.a>
{
  qvo(qvl paramqvl, JobContext paramJobContext, qve.c paramc) {}
  
  public void a(@NonNull pyj parampyj, @Nullable pyj.a arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new pyj.a(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Qvl)
      {
        qvl.a(this.jdField_a_of_type_Qvl, paramErrorMessage);
        qvl.a(this.jdField_a_of_type_Qvl).remove(parampyj);
        qvl.a(this.jdField_a_of_type_Qvl, this.jdField_a_of_type_Qve$c);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    psm localpsm = (psm)psx.a(15);
    Iterator localIterator = ???.ni.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (pyj.b)localIterator.next();
      localpsm.b(paramErrorMessage.nj, paramErrorMessage.feedId, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvo
 * JD-Core Version:    0.7.0.1
 */