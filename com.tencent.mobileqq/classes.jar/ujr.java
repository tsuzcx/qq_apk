import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class ujr
  implements slx<sza, szb>
{
  ujr(ujo paramujo, JobContext paramJobContext, ujb paramujb) {}
  
  public void a(@NonNull sza paramsza, @Nullable szb arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new szb(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Ujo)
      {
        ujo.a(this.jdField_a_of_type_Ujo, paramErrorMessage);
        ujo.a(this.jdField_a_of_type_Ujo).remove(paramsza);
        ujo.a(this.jdField_a_of_type_Ujo, this.jdField_a_of_type_Ujb);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      urk.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    sps localsps = (sps)sqg.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (szc)localIterator.next();
      localsps.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujr
 * JD-Core Version:    0.7.0.1
 */