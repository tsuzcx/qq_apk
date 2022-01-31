import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class wik
  implements urr<vfj, vhg>
{
  wik(wij paramwij, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull vfj paramvfj, @Nullable vhg paramvhg, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramvhg == null) || (paramErrorMessage.isFail()))
    {
      wxe.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      wij.a(this.jdField_a_of_type_Wij, paramErrorMessage);
      return;
    }
    if (paramvhg.a != null)
    {
      paramvfj = paramvhg.a.iterator();
      do
      {
        if (!paramvfj.hasNext()) {
          break;
        }
        paramvhg = (uxd)paramvfj.next();
      } while (!paramvhg.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramvhg.c;; i = 0)
    {
      wij.a(this.jdField_a_of_type_Wij, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wik
 * JD-Core Version:    0.7.0.1
 */