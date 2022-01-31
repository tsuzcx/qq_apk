import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class wpl
  implements urr<veu, vev>
{
  wpl(wpi paramwpi, JobContext paramJobContext, wov paramwov) {}
  
  public void a(@NonNull veu paramveu, @Nullable vev arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new vev(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Wpi)
      {
        wpi.a(this.jdField_a_of_type_Wpi, paramErrorMessage);
        wpi.a(this.jdField_a_of_type_Wpi).remove(paramveu);
        wpi.a(this.jdField_a_of_type_Wpi, this.jdField_a_of_type_Wov);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    uvm localuvm = (uvm)uwa.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (vew)localIterator.next();
      localuvm.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpl
 * JD-Core Version:    0.7.0.1
 */