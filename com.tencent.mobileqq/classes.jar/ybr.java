import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class ybr
  implements wld<wyt, wyu>
{
  ybr(ybq paramybq, JobContext paramJobContext, yia paramyia) {}
  
  public void a(@NonNull wyt paramwyt, @Nullable wyu paramwyu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramwyu == null) || (paramErrorMessage.isFail()))
    {
      yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      ybq.a(this.jdField_a_of_type_Ybq, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Yia.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((woj)wpm.a(17)).a(paramwyu.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Yia.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramwyu.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramwyu.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramwyu.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          yqp.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramwyt = new ybn(bool1, paramwyu.jdField_a_of_type_JavaUtilList, paramwyu.b, bool2, paramwyu.jdField_a_of_type_JavaLangString);
      ybq.a(this.jdField_a_of_type_Ybq, paramwyt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybr
 * JD-Core Version:    0.7.0.1
 */