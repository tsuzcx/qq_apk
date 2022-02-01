import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xnw
  implements woy<xdm, xdn>
{
  xnw(xnv paramxnv, xmy paramxmy) {}
  
  public void a(@NonNull xdm paramxdm, @Nullable xdn paramxdn, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramxdn == null))
    {
      yuk.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xmy.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Xnv.a.a(paramxdn.jdField_a_of_type_JavaUtilList, paramxdn.jdField_a_of_type_JavaLangString, paramxdn.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xmy.a(paramErrorMessage, xmg.b(paramxdn.jdField_a_of_type_JavaUtilList), paramxdn.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnw
 * JD-Core Version:    0.7.0.1
 */