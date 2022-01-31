import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class thu
  extends QQUIEventReceiver<thh, tkk>
{
  public thu(@NonNull thh paramthh)
  {
    super(paramthh);
  }
  
  public void a(@NonNull thh paramthh, @NonNull tkk paramtkk)
  {
    if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkk.jdField_a_of_type_JavaUtilList != null) && (!paramtkk.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramthh.a.b(paramtkk);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramtkk.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thu
 * JD-Core Version:    0.7.0.1
 */