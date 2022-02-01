import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class yje
  implements wld<wyd, wye>
{
  yje(yka paramyka) {}
  
  public void a(@NonNull wyd paramwyd, @Nullable wye paramwye, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramwye == null)
    {
      yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new wye(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramwye.jdField_a_of_type_JavaUtilList == null) || (paramwye.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramwyd = (woj)wpm.a(17);
      paramwye = (wyf)paramwye.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramwye.jdField_a_of_type_JavaUtilList == null);
    yqp.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramwye.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwye.jdField_a_of_type_Int), Integer.valueOf(paramwye.jdField_a_of_type_JavaUtilList.size()) });
    paramwyd.a(paramwye.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramwyd = new ybk(paramErrorMessage, paramwye.jdField_a_of_type_JavaLangString, 1);
    paramwyd.jdField_a_of_type_JavaUtilList = paramwye.jdField_a_of_type_JavaUtilList;
    paramwyd.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramwyd.jdField_a_of_type_Boolean = bool;
      paramwyd.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramwyd.jdField_b_of_type_Int = paramwye.jdField_a_of_type_Int;
      wfo.a().dispatch(paramwyd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yje
 * JD-Core Version:    0.7.0.1
 */