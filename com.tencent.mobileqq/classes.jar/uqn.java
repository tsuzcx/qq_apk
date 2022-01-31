import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.BaseApplication;

public class uqn
  implements uqo
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private uql jdField_a_of_type_Uql;
  
  public uqn(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, uql paramuql)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Uql = paramuql;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    ved.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131703164), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      bcql.a(BaseApplication.getContext(), 1, sxm.a(2131699690), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(BaseApplication.getContext(), 1, ajya.a(2131703165), 0).a();
      bool = false;
      paramInt1 = vei.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      vei.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, vei.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localbfpc.c(uqk.d);
        }
        for (;;)
        {
          localbfpc.a(uqk.a, 3);
          localbfpc.d(uqk.f);
          localbfpc.a(new uqm(localbfpc, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uql));
          localbfpc.show();
          bool = false;
          break;
          localbfpc.c(uqk.e);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        bcql.a(BaseApplication.getContext(), 1, sxm.a(2131699690), 0).a();
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
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localbfpc.c(uqk.d);
        localbfpc.a(uqk.a, 3);
      }
    }
    for (;;)
    {
      localbfpc.d(uqk.f);
      localbfpc.a(new uqm(localbfpc, paramCommentEntry, paramInt1, this.jdField_a_of_type_Uql));
      localbfpc.show();
      return false;
      localbfpc.c(uqk.e);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localbfpc.c(uqk.c);
        localbfpc.a(uqk.a, 3);
        localbfpc.c(uqk.e);
      }
      else
      {
        localbfpc.c(uqk.c);
        localbfpc.c(uqk.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqn
 * JD-Core Version:    0.7.0.1
 */