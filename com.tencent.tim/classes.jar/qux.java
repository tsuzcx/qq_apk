import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class qux<T extends CommentLikeFeedItem>
  extends qwa<T>
{
  protected HashSet<Integer> aj = new HashSet();
  protected HashSet<String> ak = new HashSet();
  protected List<LikeEntry> mLikeEntryList = new ArrayList(0);
  protected List<CommentEntry> of = new ArrayList(0);
  
  public qux(@NonNull T paramT)
  {
    super(paramT);
  }
  
  private pyi.b a(int paramInt, qux paramqux, pyi.a parama)
  {
    List localList = parama.nf;
    if (paramInt < localList.size()) {}
    for (parama = (pyi.b)localList.get(paramInt);; parama = null)
    {
      if ((parama != null) && (parama.feedId.equals(paramqux.c.feedId))) {
        return parama;
      }
      parama = new pyi.b();
      parama.feedId = paramqux.c.feedId;
      paramInt = localList.indexOf(parama);
      if (paramInt >= 0) {
        return (pyi.b)localList.get(paramInt);
      }
      ram.w("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramqux.c.feedId });
      return null;
    }
  }
  
  @Nullable
  private pyj.b a(int paramInt, qux paramqux, pyj.a parama)
  {
    List localList = parama.ni;
    if (paramInt < localList.size()) {}
    for (parama = (pyj.b)localList.get(paramInt);; parama = null)
    {
      if ((parama != null) && (parama.feedId.equals(paramqux.c.feedId))) {
        return parama;
      }
      parama = new pyj.b();
      parama.feedId = paramqux.c.feedId;
      paramInt = localList.indexOf(parama);
      if (paramInt >= 0) {
        return (pyj.b)localList.get(paramInt);
      }
      ram.w("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramqux.c.feedId });
      return null;
    }
  }
  
  public void O(List<CommentEntry> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.of.clear();
      this.aj.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)paramList.next();
      if (this.aj.contains(Integer.valueOf(localCommentEntry.commentId))) {
        this.of.remove(localCommentEntry);
      }
      for (;;)
      {
        this.of.add(localCommentEntry);
        break;
        this.aj.add(Integer.valueOf(localCommentEntry.commentId));
      }
    }
  }
  
  public void P(List<LikeEntry> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLikeEntryList.clear();
      this.ak.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.next();
      if (this.ak.contains(localLikeEntry.unionId)) {
        this.mLikeEntryList.remove(localLikeEntry);
      }
      for (;;)
      {
        this.mLikeEntryList.add(localLikeEntry);
        break;
        this.ak.add(localLikeEntry.unionId);
      }
    }
  }
  
  public T a()
  {
    return (CommentLikeFeedItem)super.a();
  }
  
  public void a(int paramInt, pyk.a parama, pyi.a parama1, pyj.a parama2)
  {
    if ((parama1 != null) && (parama1.errorCode == 0))
    {
      parama = a(paramInt, this, parama1);
      if (parama != null)
      {
        O(parama.nh, true);
        ((CommentLikeFeedItem)this.c).mCommentCount = parama.commentCount;
        ((CommentLikeFeedItem)this.c).mCommentIsEnd = parama.isEnd;
        ((CommentLikeFeedItem)this.c).mCommentLastCookie = parama.cookie;
      }
    }
    if ((parama2 != null) && (parama2.errorCode == 0))
    {
      parama = a(paramInt, this, parama2);
      if (parama != null)
      {
        P(parama.nj, true);
        ((CommentLikeFeedItem)this.c).mLikeCount = parama.likeCount;
        ((CommentLikeFeedItem)this.c).mHadLike = parama.blo;
      }
    }
  }
  
  public abstract List<StoryVideoItem> bS();
  
  public List<LikeEntry> bU()
  {
    return this.mLikeEntryList;
  }
  
  public void brb()
  {
    psa localpsa = (psa)psx.a(17);
    psm localpsm = (psm)psx.a(15);
    O(localpsa.a(((CommentLikeFeedItem)this.c).feedId, false), true);
    P(localpsm.c(((CommentLikeFeedItem)this.c).feedId, false), true);
  }
  
  public List<CommentEntry> getCommentList()
  {
    return this.of;
  }
  
  public void k(CommentEntry paramCommentEntry)
  {
    if (!this.aj.contains(Integer.valueOf(paramCommentEntry.commentId))) {
      this.aj.add(Integer.valueOf(paramCommentEntry.commentId));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qux
 * JD-Core Version:    0.7.0.1
 */