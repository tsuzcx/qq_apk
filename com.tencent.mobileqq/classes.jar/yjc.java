import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjc
  extends QQUIEventReceiver<yja, wzr>
{
  public yjc(@NonNull yja paramyja)
  {
    super(paramyja);
  }
  
  public void a(@NonNull yja paramyja, @NonNull wzr paramwzr)
  {
    if (paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yuk.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramwzr.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramwzr.b)) || (paramwzr.b.equals(paramyja.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramwzr.jdField_a_of_type_Int != -1) {
        yja.a(paramyja, paramwzr.jdField_a_of_type_Int);
      }
    } while (paramyja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramyja.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = yja.a(paramyja);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramyja), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return wzr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjc
 * JD-Core Version:    0.7.0.1
 */