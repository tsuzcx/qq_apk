import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class ymp
  implements woy<xce, xcf>
{
  ymp(ymo paramymo, JobContext paramJobContext, ymb paramymb) {}
  
  public void a(@NonNull xce paramxce, @Nullable xcf arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    xcf localxcf = ???;
    if (??? == null) {
      localxcf = new xcf(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      yuk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Ymo)
    {
      ymo.a(this.jdField_a_of_type_Ymo, localxcf);
      ymo.a(this.jdField_a_of_type_Ymo).remove(paramxce);
      ymo.a(this.jdField_a_of_type_Ymo, this.jdField_a_of_type_Ymb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymp
 * JD-Core Version:    0.7.0.1
 */