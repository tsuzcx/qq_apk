import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class wuh
  extends QQUIEventReceiver<wtu, wwx>
{
  public wuh(@NonNull wtu paramwtu)
  {
    super(paramwtu);
  }
  
  public void a(@NonNull wtu paramwtu, @NonNull wwx paramwwx)
  {
    if ((paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwx.jdField_a_of_type_JavaUtilList != null) && (!paramwwx.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramwtu.a.b(paramwwx);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramwwx.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuh
 * JD-Core Version:    0.7.0.1
 */