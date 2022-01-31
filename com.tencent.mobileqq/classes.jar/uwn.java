import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class uwn
  implements syt<tlw, tlx>
{
  uwn(uwk paramuwk, JobContext paramJobContext, uvx paramuvx) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable tlx arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new tlx(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Uwk)
      {
        uwk.a(this.jdField_a_of_type_Uwk, paramErrorMessage);
        uwk.a(this.jdField_a_of_type_Uwk).remove(paramtlw);
        uwk.a(this.jdField_a_of_type_Uwk, this.jdField_a_of_type_Uvx);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      veg.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    tco localtco = (tco)tdc.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (tly)localIterator.next();
      localtco.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwn
 * JD-Core Version:    0.7.0.1
 */