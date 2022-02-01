import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class qvn
  implements ppv.b<pyi, pyi.a>
{
  qvn(qvl paramqvl, JobContext paramJobContext, qve.c paramc) {}
  
  public void a(@NonNull pyi parampyi, @Nullable pyi.a arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new pyi.a(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Qvl)
      {
        qvl.a(this.jdField_a_of_type_Qvl, paramErrorMessage);
        qvl.a(this.jdField_a_of_type_Qvl).remove(parampyi);
        qvl.a(this.jdField_a_of_type_Qvl, this.jdField_a_of_type_Qve$c);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      ram.w("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    psa localpsa = (psa)psx.a(17);
    Iterator localIterator = ???.nf.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (pyi.b)localIterator.next();
      localpsa.a(paramErrorMessage.nh, paramErrorMessage.feedId, false, true);
      if (paramErrorMessage.isEnd == 1) {
        paramErrorMessage.nh.addAll(localpsa.b(paramErrorMessage.feedId, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvn
 * JD-Core Version:    0.7.0.1
 */