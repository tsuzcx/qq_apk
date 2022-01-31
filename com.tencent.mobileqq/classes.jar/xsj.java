import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class xsj
  extends QQUIEventReceiver<StoryNickNameView, uzc>
{
  public xsj(@NonNull StoryNickNameView paramStoryNickNameView)
  {
    super(paramStoryNickNameView);
  }
  
  public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull uzc paramuzc)
  {
    if ((paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {}
    do
    {
      return;
      if ((paramuzc.jdField_a_of_type_JavaUtilList == null) || (paramuzc.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        wsv.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
        return;
      }
      if (TextUtils.equals(paramuzc.b, "Q.qqstoryStoryNickNameView")) {
        StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramuzc.jdField_a_of_type_JavaUtilList.get(0));
      }
    } while (!TextUtils.equals(paramuzc.jdField_a_of_type_JavaLangString, paramStoryNickNameView.a()));
    paramStoryNickNameView.a((QQUserUIItem)paramuzc.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsj
 * JD-Core Version:    0.7.0.1
 */