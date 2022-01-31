import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class thm
  extends QQUIEventReceiver<thh, tju>
{
  public thm(@NonNull thh paramthh)
  {
    super(paramthh);
  }
  
  public void a(@NonNull thh paramthh, @NonNull tju paramtju)
  {
    if (paramtju.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: " + paramtju.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
      }
      if (paramtju.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) {
        paramthh.a(paramthh.a.a(8, paramtju.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: " + paramtju.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", sharegroupInfo = " + paramtju.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
  }
  
  public Class acceptEventClass()
  {
    return tju.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thm
 * JD-Core Version:    0.7.0.1
 */