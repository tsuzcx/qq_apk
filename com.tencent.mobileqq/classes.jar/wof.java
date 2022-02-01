import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wof
  extends QQUIEventReceiver<woa, wqn>
{
  public wof(@NonNull woa paramwoa)
  {
    super(paramwoa);
  }
  
  public void a(@NonNull woa paramwoa, @NonNull wqn paramwqn)
  {
    if (paramwqn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: " + paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      }
      if (paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) {
        paramwoa.a(paramwoa.a.a(8, paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: " + paramwqn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", sharegroupInfo = " + paramwqn.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return wqn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wof
 * JD-Core Version:    0.7.0.1
 */