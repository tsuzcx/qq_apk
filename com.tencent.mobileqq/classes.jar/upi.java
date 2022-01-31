import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.util.List;

class upi
  implements syt<tmj, tmk>
{
  upi(uph paramuph, JobContext paramJobContext, uvr paramuvr) {}
  
  public void a(@NonNull tmj paramtmj, @Nullable tmk paramtmk, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed comment info pull segment cancel on net respond");
      return;
    }
    if ((paramtmk == null) || (paramErrorMessage.isFail()))
    {
      veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for comment request");
      uph.a(this.jdField_a_of_type_Uph, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Uvr.b == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((tbz)tdc.a(17)).a(paramtmk.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Uvr.jdField_a_of_type_JavaLangString, bool1, true);
      boolean bool3 = paramtmk.jdField_a_of_type_Boolean;
      boolean bool2 = bool3;
      if (!paramtmk.jdField_a_of_type_Boolean)
      {
        bool2 = bool3;
        if (paramtmk.jdField_a_of_type_JavaUtilList.size() == 0)
        {
          veg.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "comment pull should be end!!!!!!!!!!!!");
          bool2 = true;
        }
      }
      paramtmj = new upe(bool1, paramtmk.jdField_a_of_type_JavaUtilList, paramtmk.b, bool2, paramtmk.jdField_a_of_type_JavaLangString);
      uph.a(this.jdField_a_of_type_Uph, paramtmj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upi
 * JD-Core Version:    0.7.0.1
 */