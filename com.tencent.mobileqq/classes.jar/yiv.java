import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class yiv
  implements wld<wyd, wye>
{
  yiv(yit paramyit, JobContext paramJobContext, yig paramyig) {}
  
  public void a(@NonNull wyd paramwyd, @Nullable wye arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new wye(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Yit)
      {
        yit.a(this.jdField_a_of_type_Yit, paramErrorMessage);
        yit.a(this.jdField_a_of_type_Yit).remove(paramwyd);
        yit.a(this.jdField_a_of_type_Yit, this.jdField_a_of_type_Yig);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    woj localwoj = (woj)wpm.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (wyf)localIterator.next();
      localwoj.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localwoj.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiv
 * JD-Core Version:    0.7.0.1
 */