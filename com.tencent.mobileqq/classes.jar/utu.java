import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

class utu
  extends QQUIEventReceiver<utr, tkk>
{
  public utu(@NonNull utr paramutr)
  {
    super(paramutr);
  }
  
  public void a(@NonNull utr paramutr, @NonNull tkk paramtkk)
  {
    if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem != null) && (TextUtils.equals(paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), paramutr.jdField_a_of_type_JavaLangString)))
    {
      ved.b("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramtkk);
      paramutr.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
      utr.a(paramutr).e();
      utr.a(paramutr).c();
      utr.a(paramutr).d();
      utr.a(paramutr).a();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utu
 * JD-Core Version:    0.7.0.1
 */