import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class yah
  extends QQUIEventReceiver<yae, wrd>
{
  public yah(@NonNull yae paramyae)
  {
    super(paramyae);
  }
  
  public void a(@NonNull yae paramyae, @NonNull wrd paramwrd)
  {
    if ((paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramyae.jdField_a_of_type_JavaLangString)))
    {
      ykq.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramwrd);
      paramyae.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      yae.a(paramyae).e();
      yae.a(paramyae).c();
      yae.a(paramyae).d();
      yae.a(paramyae).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yah
 * JD-Core Version:    0.7.0.1
 */