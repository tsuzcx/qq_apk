import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class zic
  extends QQUIEventReceiver<StoryNickNameView, wrd>
{
  public zic(@NonNull StoryNickNameView paramStoryNickNameView)
  {
    super(paramStoryNickNameView);
  }
  
  public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull wrd paramwrd)
  {
    if ((paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) && (paramwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {}
    do
    {
      return;
      if ((paramwrd.jdField_a_of_type_JavaUtilList == null) || (paramwrd.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        ykq.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
        return;
      }
      if (TextUtils.equals(paramwrd.b, "Q.qqstoryStoryNickNameView")) {
        StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramwrd.jdField_a_of_type_JavaUtilList.get(0));
      }
    } while (!TextUtils.equals(paramwrd.jdField_a_of_type_JavaLangString, paramStoryNickNameView.a()));
    paramStoryNickNameView.a((QQUserUIItem)paramwrd.jdField_a_of_type_JavaUtilList.get(0));
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zic
 * JD-Core Version:    0.7.0.1
 */