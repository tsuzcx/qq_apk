import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wpv
  extends umf<wpr, whz>
{
  public wpv(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull whz paramwhz)
  {
    int i = 1;
    if (paramwhz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      localObject = paramwpr.a(paramwhz.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramwhz.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      return;
    }
    if (!(localObject instanceof woi))
    {
      wxe.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramwhz.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject = (woi)localObject;
    ((woi)localObject).a(paramwhz.jdField_a_of_type_JavaUtilList, paramwhz.c);
    CommentLikeFeedItem localCommentLikeFeedItem = (CommentLikeFeedItem)((woi)localObject).a;
    if (paramwhz.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localCommentLikeFeedItem.mCommentIsEnd = i;
      ((CommentLikeFeedItem)((woi)localObject).a).mCommentLastCookie = paramwhz.jdField_b_of_type_JavaLangString;
      ((CommentLikeFeedItem)((woi)localObject).a).mCommentCount = paramwhz.jdField_b_of_type_Int;
      ((woy)uwa.a(11)).a(((woi)localObject).a);
      wpr.a(paramwpr).b(paramwhz.jdField_a_of_type_JavaLangString);
      wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d. isEnd:%b, cookie:%s", paramwhz.jdField_a_of_type_JavaLangString, Integer.valueOf(((woi)localObject).b().size()), Boolean.valueOf(paramwhz.jdField_a_of_type_Boolean), paramwhz.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
    }
  }
  
  public Class acceptEventClass()
  {
    return whz.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull whz paramwhz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpv
 * JD-Core Version:    0.7.0.1
 */