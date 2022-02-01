import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class ycw
  implements wfk<wsj, wsk>
{
  ycw(ycu paramycu, JobContext paramJobContext, ych paramych) {}
  
  public void a(@NonNull wsj paramwsj, @Nullable wsk arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new wsk(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Ycu)
      {
        ycu.a(this.jdField_a_of_type_Ycu, paramErrorMessage);
        ycu.a(this.jdField_a_of_type_Ycu).remove(paramwsj);
        ycu.a(this.jdField_a_of_type_Ycu, this.jdField_a_of_type_Ych);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    wip localwip = (wip)wjs.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (wsl)localIterator.next();
      localwip.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localwip.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycw
 * JD-Core Version:    0.7.0.1
 */