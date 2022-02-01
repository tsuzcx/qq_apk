import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class vzs
  extends QQUIEventReceiver<vzf, wci>
{
  public vzs(@NonNull vzf paramvzf)
  {
    super(paramvzf);
  }
  
  public void a(@NonNull vzf paramvzf, @NonNull wci paramwci)
  {
    if ((paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwci.jdField_a_of_type_JavaUtilList != null) && (!paramwci.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramvzf.a.b(paramwci);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramwci.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzs
 * JD-Core Version:    0.7.0.1
 */