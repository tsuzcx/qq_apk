import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class zty
  extends QQUIEventReceiver<StoryNickNameView, xas>
{
  public zty(@NonNull StoryNickNameView paramStoryNickNameView)
  {
    super(paramStoryNickNameView);
  }
  
  public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull xas paramxas)
  {
    if ((paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (paramxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {}
    do
    {
      return;
      if ((paramxas.jdField_a_of_type_JavaUtilList == null) || (paramxas.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        yuk.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
        return;
      }
      if (TextUtils.equals(paramxas.b, "Q.qqstoryStoryNickNameView")) {
        StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramxas.jdField_a_of_type_JavaUtilList.get(0));
      }
    } while (!TextUtils.equals(paramxas.jdField_a_of_type_JavaLangString, paramStoryNickNameView.a()));
    paramStoryNickNameView.a((QQUserUIItem)paramxas.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zty
 * JD-Core Version:    0.7.0.1
 */