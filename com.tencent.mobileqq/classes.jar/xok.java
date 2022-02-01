import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class xok
  implements vqp<wdo, wdp>
{
  xok(xpg paramxpg) {}
  
  public void a(@NonNull wdo paramwdo, @Nullable wdp paramwdp, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramwdp == null)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new wdp(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramwdp.jdField_a_of_type_JavaUtilList == null) || (paramwdp.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramwdo = (vtu)vux.a(17);
      paramwdp = (wdq)paramwdp.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramwdp.jdField_a_of_type_JavaUtilList == null);
    xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramwdp.jdField_a_of_type_JavaLangString, Integer.valueOf(paramwdp.jdField_a_of_type_Int), Integer.valueOf(paramwdp.jdField_a_of_type_JavaUtilList.size()) });
    paramwdo.a(paramwdp.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramwdo = new xgq(paramErrorMessage, paramwdp.jdField_a_of_type_JavaLangString, 1);
    paramwdo.jdField_a_of_type_JavaUtilList = paramwdp.jdField_a_of_type_JavaUtilList;
    paramwdo.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramwdo.jdField_a_of_type_Boolean = bool;
      paramwdo.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramwdo.jdField_b_of_type_Int = paramwdp.jdField_a_of_type_Int;
      vli.a().dispatch(paramwdo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xok
 * JD-Core Version:    0.7.0.1
 */