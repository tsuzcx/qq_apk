import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xzj
  extends QQUIEventReceiver<xzg, yaj>
{
  public xzj(@NonNull xzg paramxzg)
  {
    super(paramxzg);
  }
  
  public void a(@NonNull xzg paramxzg, @NonNull yaj paramyaj)
  {
    if (paramyaj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ykq.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramyaj.jdField_a_of_type_Int));
      xzg.b(paramxzg, paramyaj.jdField_a_of_type_Int);
      if (paramxzg.a != null)
      {
        paramxzg.a.shareGroupCount = xzg.b(paramxzg);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramxzg), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return yaj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzj
 * JD-Core Version:    0.7.0.1
 */