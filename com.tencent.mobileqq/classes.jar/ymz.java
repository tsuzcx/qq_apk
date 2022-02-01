import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class ymz
  implements woy<xby, xbz>
{
  ymz(ynv paramynv) {}
  
  public void a(@NonNull xby paramxby, @Nullable xbz paramxbz, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramxbz == null)
    {
      yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new xbz(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramxbz.jdField_a_of_type_JavaUtilList == null) || (paramxbz.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramxby = (wse)wth.a(17);
      paramxbz = (xca)paramxbz.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramxbz.jdField_a_of_type_JavaUtilList == null);
    yuk.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramxbz.jdField_a_of_type_JavaLangString, Integer.valueOf(paramxbz.jdField_a_of_type_Int), Integer.valueOf(paramxbz.jdField_a_of_type_JavaUtilList.size()) });
    paramxby.a(paramxbz.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramxby = new yff(paramErrorMessage, paramxbz.jdField_a_of_type_JavaLangString, 1);
    paramxby.jdField_a_of_type_JavaUtilList = paramxbz.jdField_a_of_type_JavaUtilList;
    paramxby.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramxby.jdField_a_of_type_Boolean = bool;
      paramxby.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramxby.jdField_b_of_type_Int = paramxbz.jdField_a_of_type_Int;
      wjj.a().dispatch(paramxby);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymz
 * JD-Core Version:    0.7.0.1
 */