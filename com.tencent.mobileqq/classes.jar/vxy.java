import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class vxy
  implements vqp<vyd, vye>
{
  vxy(vxx paramvxx, vkz paramvkz, vla paramvla) {}
  
  public void a(@NonNull vyd paramvyd, @Nullable vye paramvye, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramvye == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramvye.b == 1)
    {
      this.jdField_a_of_type_Vxx.a(true);
      this.jdField_a_of_type_Vkz.b(2);
      this.jdField_a_of_type_Vxx.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramvye.b);
    }
    this.jdField_a_of_type_Vla.a(paramvye.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxy
 * JD-Core Version:    0.7.0.1
 */