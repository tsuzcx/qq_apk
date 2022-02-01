import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class yfq
  implements woy<xcq, xen>
{
  yfq(yfp paramyfp, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull xcq paramxcq, @Nullable xen paramxen, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramxen == null) || (paramErrorMessage.isFail()))
    {
      yuk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      yfp.a(this.jdField_a_of_type_Yfp, paramErrorMessage);
      return;
    }
    if (paramxen.a != null)
    {
      paramxcq = paramxen.a.iterator();
      do
      {
        if (!paramxcq.hasNext()) {
          break;
        }
        paramxen = (wuk)paramxcq.next();
      } while (!paramxen.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramxen.c;; i = 0)
    {
      yfp.a(this.jdField_a_of_type_Yfp, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfq
 * JD-Core Version:    0.7.0.1
 */