import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class ydf
  implements wfk<wsj, wsk>
{
  ydf(yeb paramyeb) {}
  
  public void a(@NonNull wsj paramwsj, @Nullable wsk paramwsk, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramwsk == null)
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new wsk(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramwsk.jdField_a_of_type_JavaUtilList == null) || (paramwsk.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramwsj = (wip)wjs.a(17);
      paramwsk = (wsl)paramwsk.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramwsk.jdField_a_of_type_JavaUtilList == null);
    ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramwsk.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwsk.jdField_a_of_type_Int), Integer.valueOf(paramwsk.jdField_a_of_type_JavaUtilList.size()) });
    paramwsj.a(paramwsk.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramwsj = new xvl(paramErrorMessage, paramwsk.jdField_a_of_type_JavaLangString, 1);
    paramwsj.jdField_a_of_type_JavaUtilList = paramwsk.jdField_a_of_type_JavaUtilList;
    paramwsj.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramwsj.jdField_a_of_type_Boolean = bool;
      paramwsj.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramwsj.jdField_b_of_type_Int = paramwsk.jdField_a_of_type_Int;
      wad.a().dispatch(paramwsj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydf
 * JD-Core Version:    0.7.0.1
 */