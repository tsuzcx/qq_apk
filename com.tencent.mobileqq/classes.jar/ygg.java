import android.content.Context;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.lang.ref.WeakReference;

public class ygg
  implements ygf
{
  private int jdField_a_of_type_Int;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public ygg(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
  }
  
  public void a(String paramString, int paramInt)
  {
    yuk.a("Q.qqstory.detail.SpannableStringUtils", "on nick click. unionId = %s.", paramString);
    if ((paramInt == 1002) || (paramInt == 1003)) {}
    Object localObject;
    do
    {
      return;
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        wnu.a((Context)localObject, 12, paramString);
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = "clk_reply_nick";
      paramString = "2";
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem instanceof VideoListFeedItem)) {
        break label157;
      }
      paramString = (VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      paramInt = yup.a(paramString);
      if (!paramString.getOwner().isMe()) {
        break label151;
      }
      paramString = "1";
    }
    for (;;)
    {
      yup.a("home_page", (String)localObject, paramInt, 0, new String[] { paramString, yup.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      localObject = "clk_like_name";
      break;
      label151:
      paramString = "2";
      continue;
      label157:
      paramInt = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygg
 * JD-Core Version:    0.7.0.1
 */