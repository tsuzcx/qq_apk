import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class won
  extends QQUIEventReceiver<woa, wrd>
{
  public won(@NonNull woa paramwoa)
  {
    super(paramwoa);
  }
  
  public void a(@NonNull woa paramwoa, @NonNull wrd paramwrd)
  {
    if ((paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwrd.jdField_a_of_type_JavaUtilList != null) && (!paramwrd.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramwoa.a.b(paramwrd);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramwrd.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     won
 * JD-Core Version:    0.7.0.1
 */