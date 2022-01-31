import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class uwm
  implements syt<tlt, tlu>
{
  uwm(uwk paramuwk, JobContext paramJobContext, uvx paramuvx) {}
  
  public void a(@NonNull tlt paramtlt, @Nullable tlu arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new tlu(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Uwk)
      {
        uwk.a(this.jdField_a_of_type_Uwk, paramErrorMessage);
        uwk.a(this.jdField_a_of_type_Uwk).remove(paramtlt);
        uwk.a(this.jdField_a_of_type_Uwk, this.jdField_a_of_type_Uvx);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    tbz localtbz = (tbz)tdc.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (tlv)localIterator.next();
      localtbz.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localtbz.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwm
 * JD-Core Version:    0.7.0.1
 */