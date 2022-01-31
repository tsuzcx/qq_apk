import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wlw
  extends QQUIEventReceiver<wlu, vck>
{
  public wlw(@NonNull wlu paramwlu)
  {
    super(paramwlu);
  }
  
  public void a(@NonNull wlu paramwlu, @NonNull vck paramvck)
  {
    if (paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wxe.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramvck.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramvck.b)) || (paramvck.b.equals(paramwlu.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramvck.jdField_a_of_type_Int != -1) {
        wlu.a(paramwlu, paramvck.jdField_a_of_type_Int);
      }
    } while (paramwlu.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramwlu.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = wlu.a(paramwlu);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramwlu), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return vck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlw
 * JD-Core Version:    0.7.0.1
 */