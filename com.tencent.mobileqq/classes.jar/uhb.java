import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class uhb
  extends QQUIEventReceiver<ugy, sxr>
{
  public uhb(@NonNull ugy paramugy)
  {
    super(paramugy);
  }
  
  public void a(@NonNull ugy paramugy, @NonNull sxr paramsxr)
  {
    if ((paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramugy.jdField_a_of_type_JavaLangString)))
    {
      urk.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramsxr);
      paramugy.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramsxr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      ugy.a(paramugy).e();
      ugy.a(paramugy).c();
      ugy.a(paramugy).d();
      ugy.a(paramugy).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhb
 * JD-Core Version:    0.7.0.1
 */