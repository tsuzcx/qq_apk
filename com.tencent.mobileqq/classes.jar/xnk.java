import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xnk
  implements woy<xcy, xcz>
{
  xnk(xnj paramxnj, xmy paramxmy) {}
  
  public void a(@NonNull xcy paramxcy, @Nullable xcz paramxcz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxcz == null))
    {
      yuk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xmy.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Xnj.a.a(paramxcz.jdField_a_of_type_JavaUtilList, paramxcz.jdField_a_of_type_JavaLangString, paramxcz.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xmy.a(paramErrorMessage, xmg.b(paramxcz.jdField_a_of_type_JavaUtilList), paramxcz.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnk
 * JD-Core Version:    0.7.0.1
 */