import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yfl
  extends QQUIEventReceiver<yff, wwx>
{
  public yfl(@NonNull yff paramyff)
  {
    super(paramyff);
  }
  
  public void a(@NonNull yff paramyff, @NonNull wwx paramwwx)
  {
    if (TextUtils.equals(paramwwx.jdField_a_of_type_JavaLangString, String.valueOf(paramyff.hashCode())))
    {
      if ((paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        yqp.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramwwx);
        paramyff.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramyff.jdField_a_of_type_JavaLangString = paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (yff.a(paramyff) != -1) {
          paramyff.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = yff.a(paramyff);
        }
        if (yff.b(paramyff) != -1) {
          paramyff.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = yff.b(paramyff);
        }
        ((FriendListHandler)xfe.a().a(1)).c(paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramyff), 5, null, false);
      }
      for (;;)
      {
        yff.a(paramyff).a(paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, anni.a(2131705313) + paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        yqp.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramwwx });
      }
    }
    yqp.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramwwx);
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfl
 * JD-Core Version:    0.7.0.1
 */