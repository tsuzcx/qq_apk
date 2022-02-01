import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class xob
  implements vqp<wdo, wdp>
{
  xob(xnz paramxnz, JobContext paramJobContext, xnm paramxnm) {}
  
  public void a(@NonNull wdo paramwdo, @Nullable wdp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new wdp(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Xnz)
      {
        xnz.a(this.jdField_a_of_type_Xnz, paramErrorMessage);
        xnz.a(this.jdField_a_of_type_Xnz).remove(paramwdo);
        xnz.a(this.jdField_a_of_type_Xnz, this.jdField_a_of_type_Xnm);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for comment request");
    }
    vtu localvtu = (vtu)vux.a(17);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (wdq)localIterator.next();
      localvtu.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
      if (paramErrorMessage.b == 1) {
        paramErrorMessage.jdField_a_of_type_JavaUtilList.addAll(localvtu.b(paramErrorMessage.jdField_a_of_type_JavaLangString, false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xob
 * JD-Core Version:    0.7.0.1
 */