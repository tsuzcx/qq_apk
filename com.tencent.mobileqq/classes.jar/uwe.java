import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uwe
  extends QQUIEventReceiver<uvz, uym>
{
  public uwe(@NonNull uvz paramuvz)
  {
    super(paramuvz);
  }
  
  public void a(@NonNull uvz paramuvz, @NonNull uym paramuym)
  {
    if (paramuym.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: " + paramuym.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      }
      if (paramuym.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) {
        paramuvz.a(paramuvz.a.a(8, paramuym.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: " + paramuym.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", sharegroupInfo = " + paramuym.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return uym.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwe
 * JD-Core Version:    0.7.0.1
 */