import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

final class uwv
  implements syt<tlt, tlu>
{
  uwv(uxr paramuxr) {}
  
  public void a(@NonNull tlt paramtlt, @Nullable tlu paramtlu, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, refresh comment.");
    if (paramtlu == null)
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, response is null.");
      new tlu(paramErrorMessage);
    }
    do
    {
      do
      {
        return;
        if (paramErrorMessage.isFail()) {
          veg.d("Q.qqstory.home.data.HomeFeedPresenter", "request fail for comment request");
        }
      } while ((paramtlu.jdField_a_of_type_JavaUtilList == null) || (paramtlu.jdField_a_of_type_JavaUtilList.isEmpty()));
      paramtlt = (tbz)tdc.a(17);
      paramtlu = (tlv)paramtlu.jdField_a_of_type_JavaUtilList.get(0);
    } while (paramtlu.jdField_a_of_type_JavaUtilList == null);
    veg.d("Q.qqstory.home.data.HomeFeedPresenter", "onCmdRespond, commentFeedId:%s, commentSize:%s, entryListSize:%s", new Object[] { paramtlu.jdField_a_of_type_JavaLangString, Integer.valueOf(paramtlu.jdField_a_of_type_Int), Integer.valueOf(paramtlu.jdField_a_of_type_JavaUtilList.size()) });
    paramtlt.a(paramtlu.jdField_a_of_type_JavaUtilList, this.a.a.feedId, true, true);
    paramtlt = new upb(paramErrorMessage, paramtlu.jdField_a_of_type_JavaLangString, 1);
    paramtlt.jdField_a_of_type_JavaUtilList = paramtlu.jdField_a_of_type_JavaUtilList;
    paramtlt.c = true;
    if (((CommentLikeFeedItem)this.a.a).mCommentIsEnd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramtlt.jdField_a_of_type_Boolean = bool;
      paramtlt.jdField_b_of_type_JavaLangString = ((CommentLikeFeedItem)this.a.a).mCommentLastCookie;
      paramtlt.jdField_b_of_type_Int = paramtlu.jdField_a_of_type_Int;
      ste.a().dispatch(paramtlt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwv
 * JD-Core Version:    0.7.0.1
 */