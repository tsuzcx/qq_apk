import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjd
  extends QQUIEventReceiver<yja, ykd>
{
  public yjd(@NonNull yja paramyja)
  {
    super(paramyja);
  }
  
  public void a(@NonNull yja paramyja, @NonNull ykd paramykd)
  {
    if (paramykd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yuk.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramykd.jdField_a_of_type_Int));
      yja.b(paramyja, paramykd.jdField_a_of_type_Int);
      if (paramyja.a != null)
      {
        paramyja.a.shareGroupCount = yja.b(paramyja);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramyja), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ykd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjd
 * JD-Core Version:    0.7.0.1
 */