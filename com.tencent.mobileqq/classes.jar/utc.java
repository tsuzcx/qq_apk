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

public class utc
  extends QQUIEventReceiver<usw, tkn>
{
  public utc(@NonNull usw paramusw)
  {
    super(paramusw);
  }
  
  public void a(@NonNull usw paramusw, @NonNull tkn paramtkn)
  {
    if (TextUtils.equals(paramtkn.jdField_a_of_type_JavaLangString, String.valueOf(paramusw.hashCode())))
    {
      if ((paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        veg.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramtkn);
        paramusw.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramusw.jdField_a_of_type_JavaLangString = paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (usw.a(paramusw) != -1) {
          paramusw.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = usw.a(paramusw);
        }
        if (usw.b(paramusw) != -1) {
          paramusw.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = usw.b(paramusw);
        }
        ((FriendListHandler)tsu.a().a(1)).c(paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramusw), 5, null, false);
      }
      for (;;)
      {
        usw.a(paramusw).a(paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        bcpw.a(BaseApplicationImpl.getContext(), 1, ajyc.a(2131706527) + paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        veg.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramtkn });
      }
    }
    veg.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramtkn);
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utc
 * JD-Core Version:    0.7.0.1
 */