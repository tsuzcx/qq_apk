import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class uwm
  extends QQUIEventReceiver<uvz, uzc>
{
  public uwm(@NonNull uvz paramuvz)
  {
    super(paramuvz);
  }
  
  public void a(@NonNull uvz paramuvz, @NonNull uzc paramuzc)
  {
    if ((paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuzc.jdField_a_of_type_JavaUtilList != null) && (!paramuzc.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramuvz.a.b(paramuzc);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramuzc.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwm
 * JD-Core Version:    0.7.0.1
 */