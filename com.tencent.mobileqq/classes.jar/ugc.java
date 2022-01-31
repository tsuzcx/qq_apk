import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugc
  extends QQUIEventReceiver<uga, swq>
{
  public ugc(@NonNull uga paramuga)
  {
    super(paramuga);
  }
  
  public void a(@NonNull uga paramuga, @NonNull swq paramswq)
  {
    if (paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      urk.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramswq.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramswq.b)) || (paramswq.b.equals(paramuga.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramswq.jdField_a_of_type_Int != -1) {
        uga.a(paramuga, paramswq.jdField_a_of_type_Int);
      }
    } while (paramuga.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramuga.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = uga.a(paramuga);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramuga), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return swq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugc
 * JD-Core Version:    0.7.0.1
 */