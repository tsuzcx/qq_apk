import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class wwi
  implements woy<wwn, wwo>
{
  wwi(wwh paramwwh, wja paramwja, wjb paramwjb) {}
  
  public void a(@NonNull wwn paramwwn, @Nullable wwo paramwwo, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramwwo == null))
    {
      QLog.w("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 1, "get active fail" + paramErrorMessage.getErrorMessage());
      return;
    }
    if (paramwwo.b == 1)
    {
      this.jdField_a_of_type_Wwh.a(true);
      this.jdField_a_of_type_Wja.b(2);
      this.jdField_a_of_type_Wwh.a = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "active value is " + paramwwo.b);
    }
    this.jdField_a_of_type_Wjb.a(paramwwo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwi
 * JD-Core Version:    0.7.0.1
 */