import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Vector;

class wla
  implements uni<vao, vap>
{
  wla(wkz paramwkz, JobContext paramJobContext, wkm paramwkm) {}
  
  public void a(@NonNull vao paramvao, @Nullable vap arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed basic info pull segment cancel on net respond");
      return;
    }
    vap localvap = ???;
    if (??? == null) {
      localvap = new vap(paramErrorMessage);
    }
    if (paramErrorMessage.isFail()) {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for feed info request");
    }
    synchronized (this.jdField_a_of_type_Wkz)
    {
      wkz.a(this.jdField_a_of_type_Wkz, localvap);
      wkz.a(this.jdField_a_of_type_Wkz).remove(paramvao);
      wkz.a(this.jdField_a_of_type_Wkz, this.jdField_a_of_type_Wkm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wla
 * JD-Core Version:    0.7.0.1
 */