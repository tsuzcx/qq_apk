import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class xvw
  implements wfk<wtb, wuy>
{
  xvw(xvv paramxvv, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull wtb paramwtb, @Nullable wuy paramwuy, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramwuy == null) || (paramErrorMessage.isFail()))
    {
      ykq.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      xvv.a(this.jdField_a_of_type_Xvv, paramErrorMessage);
      return;
    }
    if (paramwuy.a != null)
    {
      paramwtb = paramwuy.a.iterator();
      do
      {
        if (!paramwtb.hasNext()) {
          break;
        }
        paramwuy = (wkv)paramwtb.next();
      } while (!paramwuy.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramwuy.c;; i = 0)
    {
      xvv.a(this.jdField_a_of_type_Xvv, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvw
 * JD-Core Version:    0.7.0.1
 */