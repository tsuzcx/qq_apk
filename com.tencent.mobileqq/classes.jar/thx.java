import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class thx
  extends QQUIEventReceiver<thk, tkn>
{
  public thx(@NonNull thk paramthk)
  {
    super(paramthk);
  }
  
  public void a(@NonNull thk paramthk, @NonNull tkn paramtkn)
  {
    if ((paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkn.jdField_a_of_type_JavaUtilList != null) && (!paramtkn.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramthk.a.b(paramtkn);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramtkn.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thx
 * JD-Core Version:    0.7.0.1
 */