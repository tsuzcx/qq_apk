import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class wlk
  implements uni<vai, vaj>
{
  wlk(wmg paramwmg) {}
  
  public void a(@NonNull vai paramvai, @Nullable vaj paramvaj, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramvaj == null)
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new vaj(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramvaj.jdField_a_of_type_JavaUtilList == null) || (paramvaj.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramvai = (uqo)urr.a(17);
      paramvaj = (vak)paramvaj.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramvaj.jdField_a_of_type_JavaUtilList == null);
    wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramvaj.jdField_a_of_type_JavaLangString, Integer.valueOf(paramvaj.jdField_a_of_type_Int), Integer.valueOf(paramvaj.jdField_a_of_type_JavaUtilList.size()) });
    paramvai.a(paramvaj.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramvai = new wdq(paramErrorMessage, paramvaj.jdField_a_of_type_JavaLangString, 1);
    paramvai.jdField_a_of_type_JavaUtilList = paramvaj.jdField_a_of_type_JavaUtilList;
    paramvai.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramvai.jdField_a_of_type_Boolean = bool;
      paramvai.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramvai.jdField_b_of_type_Int = paramvaj.jdField_a_of_type_Int;
      uht.a().dispatch(paramvai);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlk
 * JD-Core Version:    0.7.0.1
 */