import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vqq
  implements urr<vgf, vgg>
{
  vqq(vqp paramvqp, vps paramvps) {}
  
  public void a(@NonNull vgf paramvgf, @Nullable vgg paramvgg, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvgg == null))
    {
      wxe.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Vps.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Vqp.a.a(paramvgg.jdField_a_of_type_JavaUtilList, paramvgg.jdField_a_of_type_JavaLangString, paramvgg.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Vps.a(paramErrorMessage, vpa.b(paramvgg.jdField_a_of_type_JavaUtilList), paramvgg.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqq
 * JD-Core Version:    0.7.0.1
 */