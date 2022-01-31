import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class vqy
  extends QQUIEventReceiver<StoryNickNameView, sxr>
{
  public vqy(@NonNull StoryNickNameView paramStoryNickNameView)
  {
    super(paramStoryNickNameView);
  }
  
  public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull sxr paramsxr)
  {
    if ((paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {}
    do
    {
      return;
      if ((paramsxr.jdField_a_of_type_JavaUtilList == null) || (paramsxr.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        urk.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
        return;
      }
      if (TextUtils.equals(paramsxr.b, "Q.qqstoryStoryNickNameView")) {
        StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramsxr.jdField_a_of_type_JavaUtilList.get(0));
      }
    } while (!TextUtils.equals(paramsxr.jdField_a_of_type_JavaLangString, paramStoryNickNameView.a()));
    paramStoryNickNameView.a((QQUserUIItem)paramsxr.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqy
 * JD-Core Version:    0.7.0.1
 */