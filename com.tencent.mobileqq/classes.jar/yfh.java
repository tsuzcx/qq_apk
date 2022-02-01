import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yfh
  extends QQUIEventReceiver<yff, wvw>
{
  public yfh(@NonNull yff paramyff)
  {
    super(paramyff);
  }
  
  public void a(@NonNull yff paramyff, @NonNull wvw paramwvw)
  {
    if (paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      yqp.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramwvw.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramwvw.b)) || (paramwvw.b.equals(paramyff.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramwvw.jdField_a_of_type_Int != -1) {
        yff.a(paramyff, paramwvw.jdField_a_of_type_Int);
      }
    } while (paramyff.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramyff.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = yff.a(paramyff);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramyff), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return wvw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfh
 * JD-Core Version:    0.7.0.1
 */