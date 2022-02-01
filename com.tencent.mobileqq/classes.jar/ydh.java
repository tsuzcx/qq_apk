import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class ydh
  extends wag<ydd, xvl>
{
  public ydh(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull xvl paramxvl)
  {
    int i = 1;
    if (paramxvl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramydd.a(paramxvl.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramxvl.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof ybu))
    {
      ykq.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramxvl.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (ybu)localObject;
    ((ybu)localObject).a(paramxvl.jdField_a_of_type_JavaUtilList, paramxvl.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((ybu)localObject).a;
    if (paramxvl.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((ybu)localObject).a).mCommentLastCookie = paramxvl.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((ybu)localObject).a).mCommentCount = paramxvl.jdField_b_of_type_Int;
      ((yck)wjs.a(11)).a(((ybu)localObject).a);
      ydd.a(paramydd).b(paramxvl.jdField_a_of_type_JavaLangString);
      ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramxvl.jdField_a_of_type_JavaLangString, Integer.valueOf(((ybu)localObject).b().size()), Boolean.valueOf(paramxvl.jdField_a_of_type_Boolean), paramxvl.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return xvl.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull xvl paramxvl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydh
 * JD-Core Version:    0.7.0.1
 */