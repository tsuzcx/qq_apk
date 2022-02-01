import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ygg
  extends QQUIEventReceiver<ygd, wwx>
{
  public ygg(@NonNull ygd paramygd)
  {
    super(paramygd);
  }
  
  public void a(@NonNull ygd paramygd, @NonNull wwx paramwwx)
  {
    if ((paramwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramygd.jdField_a_of_type_JavaLangString)))
    {
      yqp.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramwwx);
      paramygd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      ygd.a(paramygd).e();
      ygd.a(paramygd).c();
      ygd.a(paramygd).d();
      ygd.a(paramygd).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygg
 * JD-Core Version:    0.7.0.1
 */