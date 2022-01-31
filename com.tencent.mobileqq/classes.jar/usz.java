import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class usz
  extends QQUIEventReceiver<usw, utz>
{
  public usz(@NonNull usw paramusw)
  {
    super(paramusw);
  }
  
  public void a(@NonNull usw paramusw, @NonNull utz paramutz)
  {
    if (paramutz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      veg.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramutz.jdField_a_of_type_Int));
      usw.b(paramusw, paramutz.jdField_a_of_type_Int);
      if (paramusw.a != null)
      {
        paramusw.a.shareGroupCount = usw.b(paramusw);
        ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramusw), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return utz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usz
 * JD-Core Version:    0.7.0.1
 */