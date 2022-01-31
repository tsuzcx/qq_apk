import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;

public class udu
  implements udv
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private uds jdField_a_of_type_Uds;
  
  public udu(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, uds paramuds)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Uds = paramuds;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    urk.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131637368), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      bbmy.a(BaseApplication.getContext(), 1, skt.a(2131633891), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131637369), 0).a();
      bool = false;
      paramInt1 = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      urp.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, urp.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        begr localbegr = begr.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localbegr.c(udr.d);
        }
        for (;;)
        {
          localbegr.a(udr.a, 3);
          localbegr.d(udr.f);
          localbegr.a(new udt(localbegr, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uds));
          localbegr.show();
          bool = false;
          break;
          localbegr.c(udr.e);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        bbmy.a(BaseApplication.getContext(), 1, skt.a(2131633891), 0).a();
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
    begr localbegr = begr.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbegr.c(udr.d);
        localbegr.a(udr.a, 3);
      }
    }
    for (;;)
    {
      localbegr.d(udr.f);
      localbegr.a(new udt(localbegr, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uds));
      localbegr.show();
      return false;
      localbegr.c(udr.e);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localbegr.c(udr.c);
        localbegr.a(udr.a, 3);
        localbegr.c(udr.e);
      }
      else
      {
        localbegr.c(udr.c);
        localbegr.c(udr.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udu
 * JD-Core Version:    0.7.0.1
 */