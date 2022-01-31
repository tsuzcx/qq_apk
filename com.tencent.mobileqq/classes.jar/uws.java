import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class uws
  implements syq<tlq, tlr>
{
  uws(uxo paramuxo) {}
  
  public void a(@NonNull tlq paramtlq, @Nullable tlr paramtlr, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramtlr == null)
    {
      ved.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new tlr(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          ved.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramtlr.jdField_a_of_type_JavaUtilList == null) || (paramtlr.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramtlq = (tbw)tcz.a(17);
      paramtlr = (tls)paramtlr.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramtlr.jdField_a_of_type_JavaUtilList == null);
    ved.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramtlr.jdField_a_of_type_JavaLangString, Integer.valueOf(paramtlr.jdField_a_of_type_Int), Integer.valueOf(paramtlr.jdField_a_of_type_JavaUtilList.size()) });
    paramtlq.a(paramtlr.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramtlq = new uoy(paramErrorMessage, paramtlr.jdField_a_of_type_JavaLangString, 1);
    paramtlq.jdField_a_of_type_JavaUtilList = paramtlr.jdField_a_of_type_JavaUtilList;
    paramtlq.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramtlq.jdField_a_of_type_Boolean = bool;
      paramtlq.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramtlq.jdField_b_of_type_Int = paramtlr.jdField_a_of_type_Int;
      stb.a().dispatch(paramtlq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */