import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class ycx
  implements wfk<wsm, wsn>
{
  ycx(ycu paramycu, JobContext paramJobContext, ych paramych) {}
  
  public void a(@NonNull wsm paramwsm, @Nullable wsn arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new wsn(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Ycu)
      {
        ycu.a(this.jdField_a_of_type_Ycu, paramErrorMessage);
        ycu.a(this.jdField_a_of_type_Ycu).remove(paramwsm);
        ycu.a(this.jdField_a_of_type_Ycu, this.jdField_a_of_type_Ych);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      ykq.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    wje localwje = (wje)wjs.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (wso)localIterator.next();
      localwje.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycx
 * JD-Core Version:    0.7.0.1
 */