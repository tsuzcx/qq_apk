import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wim
  extends QQUIEventReceiver<wij, uzc>
{
  public wim(@NonNull wij paramwij)
  {
    super(paramwij);
  }
  
  public void a(@NonNull wij paramwij, @NonNull uzc paramuzc)
  {
    if ((paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramwij.jdField_a_of_type_JavaLangString)))
    {
      wsv.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramuzc);
      paramwij.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      wij.a(paramwij).e();
      wij.a(paramwij).c();
      wij.a(paramwij).d();
      wij.a(paramwij).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wim
 * JD-Core Version:    0.7.0.1
 */