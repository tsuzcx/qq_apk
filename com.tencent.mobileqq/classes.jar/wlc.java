import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class wlc
  implements uni<val, vam>
{
  wlc(wkz paramwkz, JobContext paramJobContext, wkm paramwkm) {}
  
  public void a(@NonNull val paramval, @Nullable vam arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new vam(paramErrorMessage);
      synchronized (this.jdField_a_of_type_Wkz)
      {
        wkz.a(this.jdField_a_of_type_Wkz, paramErrorMessage);
        wkz.a(this.jdField_a_of_type_Wkz).remove(paramval);
        wkz.a(this.jdField_a_of_type_Wkz, this.jdField_a_of_type_Wkm);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      wsv.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    urd localurd = (urd)urr.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (van)localIterator.next();
      localurd.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlc
 * JD-Core Version:    0.7.0.1
 */