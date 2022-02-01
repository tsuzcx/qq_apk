import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class wsn
  implements wld<wss, wst>
{
  wsn(wsm paramwsm, wff paramwff, wfg paramwfg) {}
  
  public void a(@NonNull wss paramwss, @Nullable wst paramwst, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwst == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramwst.b == 1)
    {
      this.jdField_a_of_type_Wsm.a(true);
      this.jdField_a_of_type_Wff.b(2);
      this.jdField_a_of_type_Wsm.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramwst.b);
    }
    this.jdField_a_of_type_Wfg.a(paramwst.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsn
 * JD-Core Version:    0.7.0.1
 */