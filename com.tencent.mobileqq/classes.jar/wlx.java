import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wlx
  extends QQUIEventReceiver<wlu, wmx>
{
  public wlx(@NonNull wlu paramwlu)
  {
    super(paramwlu);
  }
  
  public void a(@NonNull wlu paramwlu, @NonNull wmx paramwmx)
  {
    if (paramwmx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      wxe.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramwmx.jdField_a_of_type_Int));
      wlu.b(paramwlu, paramwmx.jdField_a_of_type_Int);
      if (paramwlu.a != null)
      {
        paramwlu.a.shareGroupCount = wlu.b(paramwlu);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramwlu), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wmx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlx
 * JD-Core Version:    0.7.0.1
 */