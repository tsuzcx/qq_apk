import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ykb
  extends QQUIEventReceiver<yjy, xas>
{
  public ykb(@NonNull yjy paramyjy)
  {
    super(paramyjy);
  }
  
  public void a(@NonNull yjy paramyjy, @NonNull xas paramxas)
  {
    if ((paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramyjy.jdField_a_of_type_JavaLangString)))
    {
      yuk.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramxas);
      paramyjy.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      yjy.a(paramyjy).e();
      yjy.a(paramyjy).c();
      yjy.a(paramyjy).d();
      yjy.a(paramyjy).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykb
 * JD-Core Version:    0.7.0.1
 */