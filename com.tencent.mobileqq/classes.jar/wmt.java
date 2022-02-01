import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class wmt
  implements wfk<wmy, wmz>
{
  wmt(wms paramwms, vzu paramvzu, vzv paramvzv) {}
  
  public void a(@NonNull wmy paramwmy, @Nullable wmz paramwmz, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwmz == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramwmz.b == 1)
    {
      this.jdField_a_of_type_Wms.a(true);
      this.jdField_a_of_type_Vzu.b(2);
      this.jdField_a_of_type_Wms.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramwmz.b);
    }
    this.jdField_a_of_type_Vzv.a(paramwmz.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmt
 * JD-Core Version:    0.7.0.1
 */