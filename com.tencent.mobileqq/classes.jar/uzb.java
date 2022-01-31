import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class uzb
  implements urr<uzg, uzh>
{
  uzb(uza paramuza, ult paramult, ulu paramulu) {}
  
  public void a(@NonNull uzg paramuzg, @Nullable uzh paramuzh, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramuzh == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramuzh.b == 1)
    {
      this.jdField_a_of_type_Uza.a(true);
      this.jdField_a_of_type_Ult.b(2);
      this.jdField_a_of_type_Uza.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramuzh.b);
    }
    this.jdField_a_of_type_Ulu.a(paramuzh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzb
 * JD-Core Version:    0.7.0.1
 */