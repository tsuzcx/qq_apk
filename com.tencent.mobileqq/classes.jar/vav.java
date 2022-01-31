import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class vav
  extends QQUIEventReceiver<vai, vdl>
{
  public vav(@NonNull vai paramvai)
  {
    super(paramvai);
  }
  
  public void a(@NonNull vai paramvai, @NonNull vdl paramvdl)
  {
    if ((paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvdl.jdField_a_of_type_JavaUtilList != null) && (!paramvdl.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramvai.a.b(paramvdl);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramvdl.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vav
 * JD-Core Version:    0.7.0.1
 */