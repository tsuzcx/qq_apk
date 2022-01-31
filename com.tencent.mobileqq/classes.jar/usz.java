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

public class usz
  extends QQUIEventReceiver<ust, tkk>
{
  public usz(@NonNull ust paramust)
  {
    super(paramust);
  }
  
  public void a(@NonNull ust paramust, @NonNull tkk paramtkk)
  {
    if (TextUtils.equals(paramtkk.jdField_a_of_type_JavaLangString, String.valueOf(paramust.hashCode())))
    {
      if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        ved.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramtkk);
        paramust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramust.jdField_a_of_type_JavaLangString = paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (ust.a(paramust) != -1) {
          paramust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = ust.a(paramust);
        }
        if (ust.b(paramust) != -1) {
          paramust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = ust.b(paramust);
        }
        ((FriendListHandler)tsr.a().a(1)).c(paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramust), 5, null, false);
      }
      for (;;)
      {
        ust.a(paramust).a(paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131706538) + paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        ved.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramtkk });
      }
    }
    ved.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramtkk);
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usz
 * JD-Core Version:    0.7.0.1
 */