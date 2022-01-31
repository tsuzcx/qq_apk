import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vqe
  implements urr<vfr, vfs>
{
  vqe(vqd paramvqd, vps paramvps) {}
  
  public void a(@NonNull vfr paramvfr, @Nullable vfs paramvfs, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvfs == null))
    {
      wxe.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Vps.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Vqd.a.a(paramvfs.jdField_a_of_type_JavaUtilList, paramvfs.jdField_a_of_type_JavaLangString, paramvfs.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Vps.a(paramErrorMessage, vpa.b(paramvfs.jdField_a_of_type_JavaUtilList), paramvfs.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqe
 * JD-Core Version:    0.7.0.1
 */