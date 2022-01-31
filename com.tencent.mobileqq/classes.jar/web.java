import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class web
  implements uni<vba, vcx>
{
  web(wea paramwea, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull vba paramvba, @Nullable vcx paramvcx, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramvcx == null) || (paramErrorMessage.isFail()))
    {
      wsv.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      wea.a(this.jdField_a_of_type_Wea, paramErrorMessage);
      return;
    }
    if (paramvcx.a != null)
    {
      paramvba = paramvcx.a.iterator();
      do
      {
        if (!paramvba.hasNext()) {
          break;
        }
        paramvcx = (usu)paramvba.next();
      } while (!paramvcx.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramvcx.c;; i = 0)
    {
      wea.a(this.jdField_a_of_type_Wea, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     web
 * JD-Core Version:    0.7.0.1
 */