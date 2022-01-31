import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class ujz
  implements slx<syx, syy>
{
  ujz(ukv paramukv) {}
  
  public void a(@NonNull syx paramsyx, @Nullable syy paramsyy, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramsyy == null)
    {
      urk.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new syy(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          urk.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramsyy.jdField_a_of_type_JavaUtilList == null) || (paramsyy.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramsyx = (spd)sqg.a(17);
      paramsyy = (syz)paramsyy.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramsyy.jdField_a_of_type_JavaUtilList == null);
    urk.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramsyy.jdField_a_of_type_JavaLangString, Integer.valueOf(paramsyy.jdField_a_of_type_Int), Integer.valueOf(paramsyy.jdField_a_of_type_JavaUtilList.size()) });
    paramsyx.a(paramsyy.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramsyx = new ucf(paramErrorMessage, paramsyy.jdField_a_of_type_JavaLangString, 1);
    paramsyx.jdField_a_of_type_JavaUtilList = paramsyy.jdField_a_of_type_JavaUtilList;
    paramsyx.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramsyx.jdField_a_of_type_Boolean = bool;
      paramsyx.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramsyx.jdField_b_of_type_Int = paramsyy.jdField_a_of_type_Int;
      sgi.a().dispatch(paramsyx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujz
 * JD-Core Version:    0.7.0.1
 */