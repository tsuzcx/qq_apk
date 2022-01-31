import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class wff
  implements wfg
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private wfd jdField_a_of_type_Wfd;
  
  public wff(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, wfd paramwfd)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Wfd = paramwfd;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    wsv.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131703536), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, ume.a(2131700059), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, alpo.a(2131703537), 0).a();
      bool = false;
      paramInt1 = wta.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      wta.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, wta.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localbhpy.c(wfc.d);
        }
        for (;;)
        {
          localbhpy.a(wfc.a, 3);
          localbhpy.d(wfc.f);
          localbhpy.a(new wfe(localbhpy, paramCommentEntry, paramInt1, this.jdField_a_of_type_Wfd));
          localbhpy.show();
          bool = false;
          break;
          localbhpy.c(wfc.e);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        QQToast.a(BaseApplication.getContext(), 1, ume.a(2131700059), 0).a();
        bool = false;
        break;
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbhpy.c(wfc.d);
        localbhpy.a(wfc.a, 3);
      }
    }
    for (;;)
    {
      localbhpy.d(wfc.f);
      localbhpy.a(new wfe(localbhpy, paramCommentEntry, paramInt1, this.jdField_a_of_type_Wfd));
      localbhpy.show();
      return false;
      localbhpy.c(wfc.e);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localbhpy.c(wfc.c);
        localbhpy.a(wfc.a, 3);
        localbhpy.c(wfc.e);
      }
      else
      {
        localbhpy.c(wfc.c);
        localbhpy.c(wfc.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wff
 * JD-Core Version:    0.7.0.1
 */