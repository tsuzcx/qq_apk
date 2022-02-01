import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xlm
  extends QQUIEventReceiver<xlj, wci>
{
  public xlm(@NonNull xlj paramxlj)
  {
    super(paramxlj);
  }
  
  public void a(@NonNull xlj paramxlj, @NonNull wci paramwci)
  {
    if ((paramwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramxlj.jdField_a_of_type_JavaLangString)))
    {
      xvv.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramwci);
      paramxlj.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      xlj.a(paramxlj).e();
      xlj.a(paramxlj).c();
      xlj.a(paramxlj).d();
      xlj.a(paramxlj).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlm
 * JD-Core Version:    0.7.0.1
 */