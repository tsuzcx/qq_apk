import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class wlb
  implements uni<vai, vaj>
{
  wlb(wkz paramwkz, JobContext paramJobContext, wkm paramwkm) {}
  
  public void a(@NonNull vai paramvai, @Nullable vaj arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new vaj(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Wkz)
      {
        wkz.a(this.jdField_a_of_type_Wkz, paramErrorMessage);
        wkz.a(this.jdField_a_of_type_Wkz).remove(paramvai);
        wkz.a(this.jdField_a_of_type_Wkz, this.jdField_a_of_type_Wkm);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    uqo localuqo = (uqo)urr.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (vak)localIterator.next();
      localuqo.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localuqo.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlb
 * JD-Core Version:    0.7.0.1
 */