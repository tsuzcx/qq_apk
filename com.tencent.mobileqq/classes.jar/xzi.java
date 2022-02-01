import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xzi
  extends QQUIEventReceiver<xzg, wqc>
{
  public xzi(@NonNull xzg paramxzg)
  {
    super(paramxzg);
  }
  
  public void a(@NonNull xzg paramxzg, @NonNull wqc paramwqc)
  {
    if (paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ykq.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramwqc.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramwqc.b)) || (paramwqc.b.equals(paramxzg.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramwqc.jdField_a_of_type_Int != -1) {
        xzg.a(paramxzg, paramwqc.jdField_a_of_type_Int);
      }
    } while (paramxzg.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramxzg.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = xzg.a(paramxzg);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramxzg), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return wqc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzi
 * JD-Core Version:    0.7.0.1
 */