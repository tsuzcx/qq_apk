import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wxu
  extends QQUIEventReceiver<wxp, xac>
{
  public wxu(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull xac paramxac)
  {
    if (paramxac.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: " + paramxac.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      }
      if (paramxac.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) {
        paramwxp.a(paramwxp.a.a(8, paramxac.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: " + paramxac.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", sharegroupInfo = " + paramxac.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return xac.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxu
 * JD-Core Version:    0.7.0.1
 */