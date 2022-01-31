import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class usv
  extends QQUIEventReceiver<ust, tjj>
{
  public usv(@NonNull ust paramust)
  {
    super(paramust);
  }
  
  public void a(@NonNull ust paramust, @NonNull tjj paramtjj)
  {
    if (paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ved.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramtjj.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramtjj.b)) || (paramtjj.b.equals(paramust.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramtjj.jdField_a_of_type_Int != -1) {
        ust.a(paramust, paramtjj.jdField_a_of_type_Int);
      }
    } while (paramust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramust.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = ust.a(paramust);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramust), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return tjj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usv
 * JD-Core Version:    0.7.0.1
 */