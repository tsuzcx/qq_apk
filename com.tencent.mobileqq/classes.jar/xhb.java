import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class xhb
  implements vqp<weg, wgd>
{
  xhb(xha paramxha, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull weg paramweg, @Nullable wgd paramwgd, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramwgd == null) || (paramErrorMessage.isFail()))
    {
      xvv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      xha.a(this.jdField_a_of_type_Xha, paramErrorMessage);
      return;
    }
    if (paramwgd.a != null)
    {
      paramweg = paramwgd.a.iterator();
      do
      {
        if (!paramweg.hasNext()) {
          break;
        }
        paramwgd = (vwa)paramweg.next();
      } while (!paramwgd.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramwgd.c;; i = 0)
    {
      xha.a(this.jdField_a_of_type_Xha, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhb
 * JD-Core Version:    0.7.0.1
 */