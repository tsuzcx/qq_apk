import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class xxa
  implements xxb
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private xwy jdField_a_of_type_Xwy;
  
  public xxa(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, xwy paramxwy)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Xwy = paramxwy;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    ykq.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131702638), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, weg.a(2131699190), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131702639), 0).a();
      bool = false;
      paramInt1 = ykv.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      ykv.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, ykv.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localbkzi.c(xwx.d);
        }
        for (;;)
        {
          localbkzi.a(xwx.a, 3);
          localbkzi.d(xwx.f);
          localbkzi.a(new xwz(localbkzi, paramCommentEntry, paramInt1, this.jdField_a_of_type_Xwy));
          localbkzi.show();
          bool = false;
          break;
          localbkzi.c(xwx.e);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        QQToast.a(BaseApplication.getContext(), 1, weg.a(2131699190), 0).a();
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
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbkzi.c(xwx.d);
        localbkzi.a(xwx.a, 3);
      }
    }
    for (;;)
    {
      localbkzi.d(xwx.f);
      localbkzi.a(new xwz(localbkzi, paramCommentEntry, paramInt1, this.jdField_a_of_type_Xwy));
      localbkzi.show();
      return false;
      localbkzi.c(xwx.e);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localbkzi.c(xwx.c);
        localbkzi.a(xwx.a, 3);
        localbkzi.c(xwx.e);
      }
      else
      {
        localbkzi.c(xwx.c);
        localbkzi.c(xwx.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxa
 * JD-Core Version:    0.7.0.1
 */