import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xko
  extends QQUIEventReceiver<xkl, xlo>
{
  public xko(@NonNull xkl paramxkl)
  {
    super(paramxkl);
  }
  
  public void a(@NonNull xkl paramxkl, @NonNull xlo paramxlo)
  {
    if (paramxlo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      xvv.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramxlo.jdField_a_of_type_Int));
      xkl.b(paramxkl, paramxlo.jdField_a_of_type_Int);
      if (paramxkl.a != null)
      {
        paramxkl.a.shareGroupCount = xkl.b(paramxkl);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramxkl), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xlo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xko
 * JD-Core Version:    0.7.0.1
 */