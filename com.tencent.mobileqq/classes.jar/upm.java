import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class upm
  implements syt<tml, toi>
{
  upm(upl paramupl, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull tml paramtml, @Nullable toi paramtoi, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramtoi == null) || (paramErrorMessage.isFail()))
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      upl.a(this.jdField_a_of_type_Upl, paramErrorMessage);
      return;
    }
    if (paramtoi.a != null)
    {
      paramtml = paramtoi.a.iterator();
      do
      {
        if (!paramtml.hasNext()) {
          break;
        }
        paramtoi = (tef)paramtml.next();
      } while (!paramtoi.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramtoi.c;; i = 0)
    {
      upl.a(this.jdField_a_of_type_Upl, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upm
 * JD-Core Version:    0.7.0.1
 */