import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ygu
  implements ygv
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private ygs jdField_a_of_type_Ygs;
  
  public ygu(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, ygs paramygs)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Ygs = paramygs;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean a()
  {
    yuk.c("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131702052), 0).a();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, wnu.a(2131698604), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131702053), 0).a();
      bool = false;
      paramInt1 = yup.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      yup.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, yup.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          localblir.c(ygr.d);
        }
        for (;;)
        {
          localblir.a(ygr.a, 3);
          localblir.d(ygr.f);
          localblir.a(new ygt(localblir, paramCommentEntry, paramInt1, this.jdField_a_of_type_Ygs));
          localblir.show();
          bool = false;
          break;
          localblir.c(ygr.e);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        QQToast.a(BaseApplication.getContext(), 1, wnu.a(2131698604), 0).a();
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
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localblir.c(ygr.d);
        localblir.a(ygr.a, 3);
      }
    }
    for (;;)
    {
      localblir.d(ygr.f);
      localblir.a(new ygt(localblir, paramCommentEntry, paramInt1, this.jdField_a_of_type_Ygs));
      localblir.show();
      return false;
      localblir.c(ygr.e);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localblir.c(ygr.c);
        localblir.a(ygr.a, 3);
        localblir.c(ygr.e);
      }
      else
      {
        localblir.c(ygr.c);
        localblir.c(ygr.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygu
 * JD-Core Version:    0.7.0.1
 */