import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class ucq
  implements slx<szp, tbm>
{
  ucq(ucp paramucp, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull szp paramszp, @Nullable tbm paramtbm, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramtbm == null) || (paramErrorMessage.isFail()))
    {
      urk.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      ucp.a(this.jdField_a_of_type_Ucp, paramErrorMessage);
      return;
    }
    if (paramtbm.a != null)
    {
      paramszp = paramtbm.a.iterator();
      do
      {
        if (!paramszp.hasNext()) {
          break;
        }
        paramtbm = (srj)paramszp.next();
      } while (!paramtbm.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramtbm.c;; i = 0)
    {
      ucp.a(this.jdField_a_of_type_Ucp, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ucq
 * JD-Core Version:    0.7.0.1
 */