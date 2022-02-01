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

public class xkr
  extends QQUIEventReceiver<xkl, wci>
{
  public xkr(@NonNull xkl paramxkl)
  {
    super(paramxkl);
  }
  
  public void a(@NonNull xkl paramxkl, @NonNull wci paramwci)
  {
    if (TextUtils.equals(paramwci.jdField_a_of_type_JavaLangString, String.valueOf(paramxkl.hashCode())))
    {
      if ((paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        xvv.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramwci);
        paramxkl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramxkl.jdField_a_of_type_JavaLangString = paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (xkl.a(paramxkl) != -1) {
          paramxkl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = xkl.a(paramxkl);
        }
        if (xkl.b(paramxkl) != -1) {
          paramxkl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = xkl.b(paramxkl);
        }
        ((FriendListHandler)wkp.a().getBusinessHandler(1)).getOnlineInfo(paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramxkl), 5, null, false);
      }
      for (;;)
      {
        xkl.a(paramxkl).a(paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, amtj.a(2131705650) + paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        xvv.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramwci });
      }
    }
    xvv.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramwci);
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkr
 * JD-Core Version:    0.7.0.1
 */