import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class who
  extends QQUIEventReceiver<whl, wio>
{
  public who(@NonNull whl paramwhl)
  {
    super(paramwhl);
  }
  
  public void a(@NonNull whl paramwhl, @NonNull wio paramwio)
  {
    if (paramwio.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wsv.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramwio.jdField_a_of_type_Int));
      whl.b(paramwhl, paramwio.jdField_a_of_type_Int);
      if (paramwhl.a != null)
      {
        paramwhl.a.shareGroupCount = whl.b(paramwhl);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramwhl), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wio.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     who
 * JD-Core Version:    0.7.0.1
 */