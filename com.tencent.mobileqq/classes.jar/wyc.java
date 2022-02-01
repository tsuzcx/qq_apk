import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class wyc
  extends QQUIEventReceiver<wxp, xas>
{
  public wyc(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull xas paramxas)
  {
    if ((paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxas.jdField_a_of_type_JavaUtilList != null) && (!paramxas.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramwxp.a.b(paramxas);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramxas.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyc
 * JD-Core Version:    0.7.0.1
 */