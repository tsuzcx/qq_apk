import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wmv
  extends QQUIEventReceiver<wms, vdl>
{
  public wmv(@NonNull wms paramwms)
  {
    super(paramwms);
  }
  
  public void a(@NonNull wms paramwms, @NonNull vdl paramvdl)
  {
    if ((paramvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramwms.jdField_a_of_type_JavaLangString)))
    {
      wxe.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramvdl);
      paramwms.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      wms.a(paramwms).e();
      wms.a(paramwms).c();
      wms.a(paramwms).d();
      wms.a(paramwms).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmv
 * JD-Core Version:    0.7.0.1
 */