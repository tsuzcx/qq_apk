import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class ybv
  implements wld<wyv, xas>
{
  ybv(ybu paramybu, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull wyv paramwyv, @Nullable xas paramxas, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramxas == null) || (paramErrorMessage.isFail()))
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      ybu.a(this.jdField_a_of_type_Ybu, paramErrorMessage);
      return;
    }
    if (paramxas.a != null)
    {
      paramwyv = paramxas.a.iterator();
      do
      {
        if (!paramwyv.hasNext()) {
          break;
        }
        paramxas = (wqp)paramwyv.next();
      } while (!paramxas.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramxas.c;; i = 0)
    {
      ybu.a(this.jdField_a_of_type_Ybu, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybv
 * JD-Core Version:    0.7.0.1
 */