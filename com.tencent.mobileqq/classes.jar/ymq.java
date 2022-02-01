import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class ymq
  implements woy<xby, xbz>
{
  ymq(ymo paramymo, JobContext paramJobContext, ymb paramymb) {}
  
  public void a(@NonNull xby paramxby, @Nullable xbz arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new xbz(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Ymo)
      {
        ymo.a(this.jdField_a_of_type_Ymo, paramErrorMessage);
        ymo.a(this.jdField_a_of_type_Ymo).remove(paramxby);
        ymo.a(this.jdField_a_of_type_Ymo, this.jdField_a_of_type_Ymb);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    wse localwse = (wse)wth.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (xca)localIterator.next();
      localwse.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localwse.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymq
 * JD-Core Version:    0.7.0.1
 */