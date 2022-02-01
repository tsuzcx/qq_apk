import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xzm
  extends QQUIEventReceiver<xzg, wrd>
{
  public xzm(@NonNull xzg paramxzg)
  {
    super(paramxzg);
  }
  
  public void a(@NonNull xzg paramxzg, @NonNull wrd paramwrd)
  {
    if (TextUtils.equals(paramwrd.jdField_a_of_type_JavaLangString, String.valueOf(paramxzg.hashCode())))
    {
      if ((paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        ykq.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramwrd);
        paramxzg.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramxzg.jdField_a_of_type_JavaLangString = paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (xzg.a(paramxzg) != -1) {
          paramxzg.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = xzg.a(paramxzg);
        }
        if (xzg.b(paramxzg) != -1) {
          paramxzg.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = xzg.b(paramxzg);
        }
        ((FriendListHandler)wzk.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramxzg), 5, null, false);
      }
      for (;;)
      {
        xzg.a(paramxzg).a(paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131706001) + paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        ykq.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramwrd });
      }
    }
    ykq.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramwrd);
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzm
 * JD-Core Version:    0.7.0.1
 */