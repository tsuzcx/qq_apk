import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugd
  extends QQUIEventReceiver<uga, uhd>
{
  public ugd(@NonNull uga paramuga)
  {
    super(paramuga);
  }
  
  public void a(@NonNull uga paramuga, @NonNull uhd paramuhd)
  {
    if (paramuhd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      urk.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramuhd.jdField_a_of_type_Int));
      uga.b(paramuga, paramuhd.jdField_a_of_type_Int);
      if (paramuga.a != null)
      {
        paramuga.a.shareGroupCount = uga.b(paramuga);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramuga), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return uhd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugd
 * JD-Core Version:    0.7.0.1
 */