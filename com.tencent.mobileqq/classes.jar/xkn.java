import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xkn
  extends QQUIEventReceiver<xkl, wbh>
{
  public xkn(@NonNull xkl paramxkl)
  {
    super(paramxkl);
  }
  
  public void a(@NonNull xkl paramxkl, @NonNull wbh paramwbh)
  {
    if (paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      xvv.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramwbh.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramwbh.b)) || (paramwbh.b.equals(paramxkl.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramwbh.jdField_a_of_type_Int != -1) {
        xkl.a(paramxkl, paramwbh.jdField_a_of_type_Int);
      }
    } while (paramxkl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramxkl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = xkl.a(paramxkl);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramxkl), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return wbh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkn
 * JD-Core Version:    0.7.0.1
 */