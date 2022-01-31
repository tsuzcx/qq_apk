import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class uus
  implements uni<uux, uuy>
{
  uus(uur paramuur, uhk paramuhk, uhl paramuhl) {}
  
  public void a(@NonNull uux paramuux, @Nullable uuy paramuuy, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramuuy == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramuuy.b == 1)
    {
      this.jdField_a_of_type_Uur.a(true);
      this.jdField_a_of_type_Uhk.b(2);
      this.jdField_a_of_type_Uur.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramuuy.b);
    }
    this.jdField_a_of_type_Uhl.a(paramuuy.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uus
 * JD-Core Version:    0.7.0.1
 */