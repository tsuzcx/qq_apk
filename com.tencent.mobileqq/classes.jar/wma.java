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

public class wma
  extends QQUIEventReceiver<wlu, vdl>
{
  public wma(@NonNull wlu paramwlu)
  {
    super(paramwlu);
  }
  
  public void a(@NonNull wlu paramwlu, @NonNull vdl paramvdl)
  {
    if (TextUtils.equals(paramvdl.jdField_a_of_type_JavaLangString, String.valueOf(paramwlu.hashCode())))
    {
      if ((paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        wxe.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramvdl);
        paramwlu.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramwlu.jdField_a_of_type_JavaLangString = paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (wlu.a(paramwlu) != -1) {
          paramwlu.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = wlu.a(paramwlu);
        }
        if (wlu.b(paramwlu) != -1) {
          paramwlu.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = wlu.b(paramwlu);
        }
        ((FriendListHandler)vls.a().a(1)).c(paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramwlu), 5, null, false);
      }
      for (;;)
      {
        wlu.a(paramwlu).a(paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131706922) + paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        wxe.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramvdl });
      }
    }
    wxe.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramvdl);
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wma
 * JD-Core Version:    0.7.0.1
 */