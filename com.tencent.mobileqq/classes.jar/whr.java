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

public class whr
  extends QQUIEventReceiver<whl, uzc>
{
  public whr(@NonNull whl paramwhl)
  {
    super(paramwhl);
  }
  
  public void a(@NonNull whl paramwhl, @NonNull uzc paramuzc)
  {
    if (TextUtils.equals(paramuzc.jdField_a_of_type_JavaLangString, String.valueOf(paramwhl.hashCode())))
    {
      if ((paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        wsv.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramuzc);
        paramwhl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramwhl.jdField_a_of_type_JavaLangString = paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (whl.a(paramwhl) != -1) {
          paramwhl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = whl.a(paramwhl);
        }
        if (whl.b(paramwhl) != -1) {
          paramwhl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = whl.b(paramwhl);
        }
        ((FriendListHandler)vhj.a().a(1)).c(paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramwhl), 5, null, false);
      }
      for (;;)
      {
        whl.a(paramwhl).a(paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131706910) + paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        wsv.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramuzc });
      }
    }
    wsv.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramuzc);
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whr
 * JD-Core Version:    0.7.0.1
 */