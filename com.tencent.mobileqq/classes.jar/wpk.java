import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class wpk
  implements urr<ver, ves>
{
  wpk(wpi paramwpi, JobContext paramJobContext, wov paramwov) {}
  
  public void a(@NonNull ver paramver, @Nullable ves arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new ves(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Wpi)
      {
        wpi.a(this.jdField_a_of_type_Wpi, paramErrorMessage);
        wpi.a(this.jdField_a_of_type_Wpi).remove(paramver);
        wpi.a(this.jdField_a_of_type_Wpi, this.jdField_a_of_type_Wov);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      wxe.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    uux localuux = (uux)uwa.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (vet)localIterator.next();
      localuux.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localuux.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpk
 * JD-Core Version:    0.7.0.1
 */