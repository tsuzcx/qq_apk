import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wlm
  extends uhw<wli, wdq>
{
  public wlm(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull wdq paramwdq)
  {
    int i = 1;
    if (paramwdq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramwli.a(paramwdq.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwdq.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof wjz))
    {
      wsv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramwdq.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (wjz)localObject;
    ((wjz)localObject).a(paramwdq.jdField_a_of_type_JavaUtilList, paramwdq.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((wjz)localObject).a;
    if (paramwdq.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((wjz)localObject).a).mCommentLastCookie = paramwdq.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((wjz)localObject).a).mCommentCount = paramwdq.jdField_b_of_type_Int;
      ((wkp)urr.a(11)).a(((wjz)localObject).a);
      wli.a(paramwli).b(paramwdq.jdField_a_of_type_JavaLangString);
      wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramwdq.jdField_a_of_type_JavaLangString, Integer.valueOf(((wjz)localObject).b().size()), Boolean.valueOf(paramwdq.jdField_a_of_type_Boolean), paramwdq.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return wdq.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull wdq paramwdq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlm
 * JD-Core Version:    0.7.0.1
 */