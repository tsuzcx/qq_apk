import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class whn
  extends QQUIEventReceiver<whl, uyb>
{
  public whn(@NonNull whl paramwhl)
  {
    super(paramwhl);
  }
  
  public void a(@NonNull whl paramwhl, @NonNull uyb paramuyb)
  {
    if (paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wsv.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramuyb.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramuyb.b)) || (paramuyb.b.equals(paramwhl.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramuyb.jdField_a_of_type_Int != -1) {
        whl.a(paramwhl, paramuyb.jdField_a_of_type_Int);
      }
    } while (paramwhl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramwhl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = whl.a(paramwhl);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramwhl), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return uyb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whn
 * JD-Core Version:    0.7.0.1
 */