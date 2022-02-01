import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xkb
  implements wld<wzr, wzs>
{
  xkb(xka paramxka, xjd paramxjd) {}
  
  public void a(@NonNull wzr paramwzr, @Nullable wzs paramwzs, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwzs == null))
    {
      yqp.a("Q.qqstory.player.data.TroopAssistantHomeFeedPlayPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      this.jdField_a_of_type_Xjd.a(paramErrorMessage, null, false);
      return;
    }
    this.jdField_a_of_type_Xka.a.a(paramwzs.jdField_a_of_type_JavaUtilList, paramwzs.jdField_a_of_type_JavaLangString, paramwzs.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Xjd.a(paramErrorMessage, xil.b(paramwzs.jdField_a_of_type_JavaUtilList), paramwzs.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkb
 * JD-Core Version:    0.7.0.1
 */