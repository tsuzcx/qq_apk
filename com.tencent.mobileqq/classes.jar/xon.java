import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xon
  extends vll<xoi, vsd>
{
  public xon(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull vsd paramvsd)
  {
    if (((xoi.a(paramxoi) == 12) && (paramvsd.jdField_a_of_type_Int == 3)) || ((xoi.a(paramxoi) == 10) && (paramvsd.jdField_a_of_type_Int == 0) && (paramvsd.b != 1))) {
      return;
    }
    Object localObject = paramxoi.a(paramvsd.jdField_a_of_type_JavaLangString);
    if (localObject == null)
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "can't find feedId:%s", new Object[] { paramvsd.jdField_a_of_type_JavaLangString });
      return;
    }
    if (!(localObject instanceof xmz))
    {
      xvv.d("Q.qqstory.home.data.HomeFeedPresenter", "that is not commentLike type!! feedId:%s", new Object[] { paramvsd.jdField_a_of_type_JavaLangString });
      return;
    }
    localObject = (xmz)localObject;
    if ((paramvsd.b == 1) || (paramvsd.b == 2))
    {
      if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) {
        ((CommentLikeFeedItem)((xmz)localObject).a).mCommentCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
      }
      ((xmz)localObject).a(((vtu)vux.a(17)).a(paramvsd.jdField_a_of_type_JavaLangString, false), true);
      xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "feedId %s comment update after count:%d", paramvsd.jdField_a_of_type_JavaLangString, Integer.valueOf(((xmz)localObject).b().size()));
    }
    for (;;)
    {
      xoi.a(paramxoi).b(paramvsd.jdField_a_of_type_JavaLangString);
      return;
      if (paramvsd.b == 3)
      {
        if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
        {
          ((CommentLikeFeedItem)((xmz)localObject).a).mHadLike = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike;
          ((CommentLikeFeedItem)((xmz)localObject).a).mLikeCount = paramvsd.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount;
        }
        ((xmz)localObject).b(((vuj)vux.a(15)).a(paramvsd.jdField_a_of_type_JavaLangString, false), true);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return vsd.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull vsd paramvsd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xon
 * JD-Core Version:    0.7.0.1
 */