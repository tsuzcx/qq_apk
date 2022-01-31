import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class wpt
  implements urr<ver, ves>
{
  wpt(wqp paramwqp) {}
  
  public void a(@NonNull ver paramver, @Nullable ves paramves, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramves == null)
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new ves(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramves.jdField_a_of_type_JavaUtilList == null) || (paramves.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramver = (uux)uwa.a(17);
      paramves = (vet)paramves.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramves.jdField_a_of_type_JavaUtilList == null);
    wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramves.jdField_a_of_type_JavaLangString, Integer.valueOf(paramves.jdField_a_of_type_Int), Integer.valueOf(paramves.jdField_a_of_type_JavaUtilList.size()) });
    paramver.a(paramves.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramver = new whz(paramErrorMessage, paramves.jdField_a_of_type_JavaLangString, 1);
    paramver.jdField_a_of_type_JavaUtilList = paramves.jdField_a_of_type_JavaUtilList;
    paramver.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramver.jdField_a_of_type_Boolean = bool;
      paramver.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramver.jdField_b_of_type_Int = paramves.jdField_a_of_type_Int;
      umc.a().dispatch(paramver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpt
 * JD-Core Version:    0.7.0.1
 */