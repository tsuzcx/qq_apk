import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yfi
  extends QQUIEventReceiver<yff, ygi>
{
  public yfi(@NonNull yff paramyff)
  {
    super(paramyff);
  }
  
  public void a(@NonNull yff paramyff, @NonNull ygi paramygi)
  {
    if (paramygi.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yqp.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramygi.jdField_a_of_type_Int));
      yff.b(paramyff, paramygi.jdField_a_of_type_Int);
      if (paramyff.a != null)
      {
        paramyff.a.shareGroupCount = yff.b(paramyff);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramyff), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ygi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfi
 * JD-Core Version:    0.7.0.1
 */