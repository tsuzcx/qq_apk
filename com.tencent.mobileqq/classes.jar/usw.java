import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class usw
  extends QQUIEventReceiver<ust, utw>
{
  public usw(@NonNull ust paramust)
  {
    super(paramust);
  }
  
  public void a(@NonNull ust paramust, @NonNull utw paramutw)
  {
    if (paramutw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      ved.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramutw.jdField_a_of_type_Int));
      ust.b(paramust, paramutw.jdField_a_of_type_Int);
      if (paramust.a != null)
      {
        paramust.a.shareGroupCount = ust.b(paramust);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramust), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return utw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usw
 * JD-Core Version:    0.7.0.1
 */