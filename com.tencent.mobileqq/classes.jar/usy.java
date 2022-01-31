import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class usy
  extends QQUIEventReceiver<usw, tjm>
{
  public usy(@NonNull usw paramusw)
  {
    super(paramusw);
  }
  
  public void a(@NonNull usw paramusw, @NonNull tjm paramtjm)
  {
    if (paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      veg.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramtjm.jdField_a_of_type_Int));
      if ((TextUtils.isEmpty(paramtjm.b)) || (paramtjm.b.equals(paramusw.jdField_a_of_type_JavaLangString))) {
        break label49;
      }
    }
    label49:
    do
    {
      return;
      if (paramtjm.jdField_a_of_type_Int != -1) {
        usw.a(paramusw, paramtjm.jdField_a_of_type_Int);
      }
    } while (paramusw.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null);
    paramusw.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount = usw.a(paramusw);
    ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramusw), 5, null, false);
  }
  
  public Class acceptEventClass()
  {
    return tjm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usy
 * JD-Core Version:    0.7.0.1
 */