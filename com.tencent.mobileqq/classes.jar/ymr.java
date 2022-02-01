import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class ymr
  implements woy<xcb, xcc>
{
  ymr(ymo paramymo, JobContext paramJobContext, ymb paramymb) {}
  
  public void a(@NonNull xcb paramxcb, @Nullable xcc arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new xcc(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Ymo)
      {
        ymo.a(this.jdField_a_of_type_Ymo, paramErrorMessage);
        ymo.a(this.jdField_a_of_type_Ymo).remove(paramxcb);
        ymo.a(this.jdField_a_of_type_Ymo, this.jdField_a_of_type_Ymb);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    wst localwst = (wst)wth.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (xcd)localIterator.next();
      localwst.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymr
 * JD-Core Version:    0.7.0.1
 */