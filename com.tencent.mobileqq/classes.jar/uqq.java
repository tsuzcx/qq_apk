import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;

public class uqq
  implements uqr
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private uqo jdField_a_of_type_Uqo;
  
  public uqq(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, uqo paramuqo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Uqo = paramuqo;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    veg.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131703153), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      bcpw.a(BaseApplication.getContext(), 1, sxp.a(2131699679), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131703154), 0).a();
      bool = false;
      paramInt1 = vel.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vel.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, vel.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localbfol.c(uqn.d);
        }
        for (;;)
        {
          localbfol.a(uqn.a, 3);
          localbfol.d(uqn.f);
          localbfol.a(new uqp(localbfol, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uqo));
          localbfol.show();
          bool = false;
          break;
          localbfol.c(uqn.e);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        bcpw.a(BaseApplication.getContext(), 1, sxp.a(2131699679), 0).a();
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
    bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbfol.c(uqn.d);
        localbfol.a(uqn.a, 3);
      }
    }
    for (;;)
    {
      localbfol.d(uqn.f);
      localbfol.a(new uqp(localbfol, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uqo));
      localbfol.show();
      return false;
      localbfol.c(uqn.e);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localbfol.c(uqn.c);
        localbfol.a(uqn.a, 3);
        localbfol.c(uqn.e);
      }
      else
      {
        localbfol.c(uqn.c);
        localbfol.c(uqn.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqq
 * JD-Core Version:    0.7.0.1
 */