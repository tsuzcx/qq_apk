import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class upj
  implements syq<tmi, tof>
{
  upj(upi paramupi, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull tmi paramtmi, @Nullable tof paramtof, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramtof == null) || (paramErrorMessage.isFail()))
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      upi.a(this.jdField_a_of_type_Upi, paramErrorMessage);
      return;
    }
    if (paramtof.a != null)
    {
      paramtmi = paramtof.a.iterator();
      do
      {
        if (!paramtmi.hasNext()) {
          break;
        }
        paramtof = (tec)paramtmi.next();
      } while (!paramtof.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramtof.c;; i = 0)
    {
      upi.a(this.jdField_a_of_type_Upi, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upj
 * JD-Core Version:    0.7.0.1
 */