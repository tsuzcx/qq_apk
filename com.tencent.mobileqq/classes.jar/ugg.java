import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugg
  extends QQUIEventReceiver<uga, sxr>
{
  public ugg(@NonNull uga paramuga)
  {
    super(paramuga);
  }
  
  public void a(@NonNull uga paramuga, @NonNull sxr paramsxr)
  {
    if (TextUtils.equals(paramsxr.jdField_a_of_type_JavaLangString, String.valueOf(paramuga.hashCode())))
    {
      if ((paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        urk.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramsxr);
        paramuga.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramuga.jdField_a_of_type_JavaLangString = paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (uga.a(paramuga) != -1) {
          paramuga.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = uga.a(paramuga);
        }
        if (uga.b(paramuga) != -1) {
          paramuga.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = uga.b(paramuga);
        }
        ((FriendListHandler)tfy.a().a(1)).c(paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramuga), 5, null, false);
      }
      for (;;)
      {
        uga.a(paramuga).a(paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131640742) + paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        urk.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramsxr });
      }
    }
    urk.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramsxr);
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugg
 * JD-Core Version:    0.7.0.1
 */