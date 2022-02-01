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

public class yjg
  extends QQUIEventReceiver<yja, xas>
{
  public yjg(@NonNull yja paramyja)
  {
    super(paramyja);
  }
  
  public void a(@NonNull yja paramyja, @NonNull xas paramxas)
  {
    if (TextUtils.equals(paramxas.jdField_a_of_type_JavaLangString, String.valueOf(paramyja.hashCode())))
    {
      if ((paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null))
      {
        yuk.b("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramxas);
        paramyja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
        paramyja.jdField_a_of_type_JavaLangString = paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.uid;
        if (yja.a(paramyja) != -1) {
          paramyja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = yja.a(paramyja);
        }
        if (yja.b(paramyja) != -1) {
          paramyja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.shareGroupCount = yja.b(paramyja);
        }
        ((FriendListHandler)xiz.a().a(1)).c(paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq, false);
        ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramyja), 5, null, false);
      }
      for (;;)
      {
        yja.a(paramyja).a(paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
        return;
        QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131705420) + paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.getErrorMessage(), 0);
        yuk.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramxas });
      }
    }
    yuk.b("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramxas);
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjg
 * JD-Core Version:    0.7.0.1
 */