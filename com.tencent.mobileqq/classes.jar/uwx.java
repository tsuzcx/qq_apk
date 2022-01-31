import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class uwx
  extends sth<uwt, upb>
{
  public uwx(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull upb paramupb)
  {
    int i = 1;
    if (paramupb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramuwt.a(paramupb.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        veg.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramupb.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof uvk))
    {
      veg.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramupb.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (uvk)localObject;
    ((uvk)localObject).a(paramupb.jdField_a_of_type_JavaUtilList, paramupb.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((uvk)localObject).a;
    if (paramupb.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((uvk)localObject).a).mCommentLastCookie = paramupb.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((uvk)localObject).a).mCommentCount = paramupb.jdField_b_of_type_Int;
      ((uwa)tdc.a(11)).a(((uvk)localObject).a);
      uwt.a(paramuwt).b(paramupb.jdField_a_of_type_JavaLangString);
      veg.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramupb.jdField_a_of_type_JavaLangString, Integer.valueOf(((uvk)localObject).b().size()), Boolean.valueOf(paramupb.jdField_a_of_type_Boolean), paramupb.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return upb.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull upb paramupb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwx
 * JD-Core Version:    0.7.0.1
 */