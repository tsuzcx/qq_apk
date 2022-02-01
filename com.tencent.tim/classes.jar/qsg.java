import android.content.Context;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class qsg
  implements qsh
{
  private qsf.a a;
  private CommentLikeFeedItem d;
  private Context mContext;
  private int mSource;
  
  public qsg(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, qsf.a parama)
  {
    this.mContext = paramContext;
    this.mSource = paramInt;
    this.d = paramCommentLikeFeedItem;
    this.a = parama;
    if (!(paramCommentLikeFeedItem.getOwner() instanceof ShareGroupItem)) {
      throw new IllegalStateException("initial comment event proxy while owner is not share group item.");
    }
  }
  
  public boolean Ku()
  {
    ram.i("Q.qqstory.detail.DetailShareGroupCommentEventProxy", "on comment button click.");
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704951), 0).show();
      return false;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.d.getOwner();
    if ((!localShareGroupItem.isPublic()) && (!localShareGroupItem.isSubscribe()))
    {
      QQToast.a(BaseApplication.getContext(), 1, ppf.getString(2131701931), 0).show();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (!aqiw.isNetSupport(this.mContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131704952), 0).show();
      bool = false;
      paramInt1 = rar.a(this.d);
      if (!this.d.getOwner().isMe()) {
        break label252;
      }
    }
    label252:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      rar.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, rar.bX(this.mSource), "", this.d.feedId });
      return bool;
      if (QQStoryContext.a().eU(paramCommentEntry.authorUnionId))
      {
        ausj localausj = ausj.b(this.mContext);
        if (paramCommentEntry.status == 2) {
          localausj.addButton(qsf.ays);
        }
        for (;;)
        {
          localausj.addButton(qsf.ayp, 3);
          localausj.addCancelButton(qsf.ayu);
          localausj.a(new qsf.b(localausj, paramCommentEntry, paramInt1, this.a));
          localausj.show();
          bool = false;
          break;
          localausj.addButton(qsf.ayt);
        }
      }
      paramCommentEntry = (ShareGroupItem)this.d.getOwner();
      if ((!paramCommentEntry.isPublic()) && (!paramCommentEntry.isSubscribe()))
      {
        QQToast.a(BaseApplication.getContext(), 1, ppf.getString(2131701931), 0).show();
        bool = false;
        break;
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.d.getOwner();
    ausj localausj = ausj.b(this.mContext);
    if (QQStoryContext.a().eU(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localausj.addButton(qsf.ays);
        localausj.addButton(qsf.ayp, 3);
      }
    }
    for (;;)
    {
      localausj.addCancelButton(qsf.ayu);
      localausj.a(new qsf.b(localausj, paramCommentEntry, paramInt1, this.a));
      localausj.show();
      return false;
      localausj.addButton(qsf.ayt);
      break;
      if ((localShareGroupItem.isPublic()) && (localShareGroupItem.isOwner()))
      {
        localausj.addButton(qsf.ayr);
        localausj.addButton(qsf.ayp, 3);
        localausj.addButton(qsf.ayt);
      }
      else
      {
        localausj.addButton(qsf.ayr);
        localausj.addButton(qsf.ayt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsg
 * JD-Core Version:    0.7.0.1
 */