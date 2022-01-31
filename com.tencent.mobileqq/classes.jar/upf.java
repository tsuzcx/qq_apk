import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class upf
  implements syq<tmg, tmh>
{
  upf(upe paramupe, JobContext paramJobContext, uvo paramuvo) {}
  
  public void a(@NonNull tmg paramtmg, @Nullable tmh paramtmh, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramtmh == null) || (paramErrorMessage.isFail()))
    {
      ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      upe.a(this.jdField_a_of_type_Upe, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Uvo.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((tbw)tcz.a(17)).a(paramtmh.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Uvo.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramtmh.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramtmh.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramtmh.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          ved.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramtmg = new upb(bool1, paramtmh.jdField_a_of_type_JavaUtilList, paramtmh.b, bool2, paramtmh.jdField_a_of_type_JavaLangString);
      upe.a(this.jdField_a_of_type_Upe, paramtmg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upf
 * JD-Core Version:    0.7.0.1
 */