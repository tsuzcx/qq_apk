import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tyi
  extends sth<tyf, tah>
{
  public tyi(tyf paramtyf)
  {
    super(paramtyf);
  }
  
  public void a(@NonNull tyf paramtyf, @NonNull tah paramtah)
  {
    if ((paramtah.jdField_a_of_type_Int == 2) || (!paramtah.jdField_a_of_type_JavaLangString.equals(tyf.a(paramtyf))) || (tyf.a(paramtyf) == null) || (tyf.a(paramtyf).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null)) {
      veg.b(this.TAG, "ignore this feed info change event. %s.", paramtah.toString());
    }
    tyo localtyo;
    do
    {
      return;
      veg.a(this.TAG, "receive feed info change event. %s.", paramtah.toString());
      localtyo = paramtyf.a();
      switch (paramtah.b)
      {
      default: 
        return;
      }
      if (paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null)
      {
        tyf.a(paramtyf).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount;
        tyf.a(paramtyf).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFriendCommentCount;
        tyf.a(paramtyf).jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount = paramtah.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mFanCommentCount;
      }
      tyf.a(paramtyf).a(paramtah.c);
    } while (localtyo == null);
    localtyo.a(tyf.a(paramtyf), paramtah.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return tah.class;
  }
  
  public void b(@NonNull tyf paramtyf, @NonNull tah paramtah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyi
 * JD-Core Version:    0.7.0.1
 */