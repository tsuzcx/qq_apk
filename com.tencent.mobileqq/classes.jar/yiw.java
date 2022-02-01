import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class yiw
  implements wld<wyg, wyh>
{
  yiw(yit paramyit, JobContext paramJobContext, yig paramyig) {}
  
  public void a(@NonNull wyg paramwyg, @Nullable wyh arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new wyh(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Yit)
      {
        yit.a(this.jdField_a_of_type_Yit, paramErrorMessage);
        yit.a(this.jdField_a_of_type_Yit).remove(paramwyg);
        yit.a(this.jdField_a_of_type_Yit, this.jdField_a_of_type_Yig);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      yqp.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    woy localwoy = (woy)wpm.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (wyi)localIterator.next();
      localwoy.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yiw
 * JD-Core Version:    0.7.0.1
 */