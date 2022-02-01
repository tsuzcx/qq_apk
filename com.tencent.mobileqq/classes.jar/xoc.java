import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class xoc
  implements vqp<wdr, wds>
{
  xoc(xnz paramxnz, JobContext paramJobContext, xnm paramxnm) {}
  
  public void a(@NonNull wdr paramwdr, @Nullable wds arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new wds(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Xnz)
      {
        xnz.a(this.jdField_a_of_type_Xnz, paramErrorMessage);
        xnz.a(this.jdField_a_of_type_Xnz).remove(paramwdr);
        xnz.a(this.jdField_a_of_type_Xnz, this.jdField_a_of_type_Xnm);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      xvv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    vuj localvuj = (vuj)vux.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (wdt)localIterator.next();
      localvuj.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoc
 * JD-Core Version:    0.7.0.1
 */