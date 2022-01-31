import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class utx
  extends QQUIEventReceiver<utu, tkn>
{
  public utx(@NonNull utu paramutu)
  {
    super(paramutu);
  }
  
  public void a(@NonNull utu paramutu, @NonNull tkn paramtkn)
  {
    if ((paramtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramutu.jdField_a_of_type_JavaLangString)))
    {
      veg.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramtkn);
      paramutu.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      utu.a(paramutu).e();
      utu.a(paramutu).c();
      utu.a(paramutu).d();
      utu.a(paramutu).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */