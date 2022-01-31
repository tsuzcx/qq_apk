import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class wdr
  extends QQUIEventReceiver<StoryNickNameView, tkk>
{
  public wdr(@NonNull StoryNickNameView paramStoryNickNameView)
  {
    super(paramStoryNickNameView);
  }
  
  public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull tkk paramtkk)
  {
    if ((paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (paramtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {}
    do
    {
      return;
      if ((paramtkk.jdField_a_of_type_JavaUtilList == null) || (paramtkk.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        ved.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
        return;
      }
      if (TextUtils.equals(paramtkk.b, "Q.qqstoryStoryNickNameView")) {
        StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramtkk.jdField_a_of_type_JavaUtilList.get(0));
      }
    } while (!TextUtils.equals(paramtkk.jdField_a_of_type_JavaLangString, paramStoryNickNameView.a()));
    paramStoryNickNameView.a((QQUserUIItem)paramtkk.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wdr
 * JD-Core Version:    0.7.0.1
 */