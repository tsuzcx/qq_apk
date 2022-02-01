import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class qru
{
  private boolean aEZ = true;
  private boolean aFa = true;
  private HashSet<String> ai = new HashSet();
  private HashSet<String> aj = new HashSet();
  private HashSet<String> ak = new HashSet();
  private HashSet<String> al = new HashSet();
  private HashSet<String> an = new HashSet();
  private String aym;
  private String ayo;
  public CommentLikeFeedItem d;
  private CommentEntry f;
  private CommentEntry g;
  private List<LikeEntry> mLikeEntryList = new ArrayList(0);
  private List<StoryVideoItem> mVideoItemList = new ArrayList(0);
  private List<CommentEntry> of = new ArrayList(0);
  private List<CommentEntry> og = new ArrayList(0);
  private List<LikeEntry> oh = new ArrayList(0);
  private List<rmw.a> oi = new ArrayList();
  
  private int m(int paramInt, boolean paramBoolean)
  {
    int i = -1;
    if (paramBoolean) {
      if (paramInt != -1) {
        i = paramInt + 1;
      }
    }
    while (paramInt <= 0)
    {
      return i;
      return 1;
    }
    return paramInt - 1;
  }
  
  public void E(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.aym = paramString;
      return;
    }
    this.ayo = paramString;
  }
  
  public void I(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.mVideoItemList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
        if (localStoryVideoItem.isUploadSuc())
        {
          this.ai.remove(localStoryVideoItem.mVid);
          ((Iterator)localObject).remove();
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (StoryVideoItem)paramList.next();
      if (!this.ai.contains(((StoryVideoItem)localObject).mVid))
      {
        this.ai.add(((StoryVideoItem)localObject).mVid);
        this.mVideoItemList.add(localObject);
      }
    }
  }
  
  public void J(List<rmw.a> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.oi.clear();
    }
    this.oi.addAll(paramList);
  }
  
  public boolean Kl()
  {
    if ((this.d == null) || (this.d.getOwner() == null)) {}
    while (!(this.d instanceof VideoListFeedItem)) {
      return false;
    }
    return this.d.getOwner().isMe();
  }
  
  public boolean Km()
  {
    if (!Kl()) {}
    label105:
    label106:
    for (;;)
    {
      return false;
      if (((VideoListFeedItem)this.d).mHasPublicVideo) {
        return true;
      }
      int i;
      if (this.mLikeEntryList.size() > 0)
      {
        i = 1;
        if ((i == 0) || (this.mLikeEntryList.size() != 1) || (!QQStoryContext.a().eU(((LikeEntry)this.mLikeEntryList.get(0)).unionId))) {
          break label105;
        }
        i = 0;
      }
      for (;;)
      {
        if ((this.of.size() <= 0) && (i == 0)) {
          break label106;
        }
        return true;
        i = 0;
        break;
      }
    }
  }
  
  public boolean Kn()
  {
    return (this.d instanceof VideoListFeedItem);
  }
  
  public boolean Ko()
  {
    return (this.d instanceof GeneralFeedItem);
  }
  
  public boolean Kp()
  {
    return (this.d instanceof GeneralRecommendFeedItem);
  }
  
  public boolean Kq()
  {
    return (this.d instanceof ShareGroupFeedItem);
  }
  
  public boolean Kr()
  {
    return (this.d instanceof BannerFeedItem);
  }
  
  public boolean Y(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.aEZ;
    }
    return this.aFa;
  }
  
  public CommentEntry a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.f;
    }
    return this.g;
  }
  
  public BannerFeedItem a()
  {
    if (Kr()) {
      return (BannerFeedItem)this.d;
    }
    return null;
  }
  
  public GeneralRecommendFeedItem a()
  {
    if (Kp()) {
      return (GeneralRecommendFeedItem)this.d;
    }
    return null;
  }
  
  public ShareGroupFeedItem a()
  {
    if (Kq()) {
      return (ShareGroupFeedItem)this.d;
    }
    return null;
  }
  
  public void a(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (Kl()) {
      this.d.mFriendLikeCount = m(this.d.mFriendLikeCount, true);
    }
    for (;;)
    {
      this.d.mLikeCount = m(this.d.mLikeCount, true);
      this.mLikeEntryList.add(paramLikeEntry);
      this.ak.add(paramLikeEntry.unionId);
      this.oh.add(paramLikeEntry);
      this.an.add(paramLikeEntry.unionId);
      return;
      this.d.mFanLikeCount = m(this.d.mFanLikeCount, true);
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (paramInt < 0) {
      this.mVideoItemList.add(paramStoryVideoItem);
    }
    for (;;)
    {
      this.ai.add(paramStoryVideoItem.mVid);
      return;
      this.mVideoItemList.add(paramInt, paramStoryVideoItem);
    }
  }
  
  public void ac(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.d.mFanCommentCount = paramInt;
      return;
    }
    this.d.mFriendCommentCount = paramInt;
  }
  
  public void ad(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.d.mFanLikeCount = paramInt;
      return;
    }
    this.d.mFriendLikeCount = paramInt;
  }
  
  public void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.aEZ = paramBoolean2;
      return;
    }
    this.aFa = paramBoolean2;
  }
  
  public GeneralFeedItem b()
  {
    if (Ko()) {
      return (GeneralFeedItem)this.d;
    }
    return null;
  }
  
  public VideoListFeedItem b()
  {
    if (Kn()) {
      return (VideoListFeedItem)this.d;
    }
    return null;
  }
  
  public void b(LikeEntry paramLikeEntry, boolean paramBoolean)
  {
    if (Kl()) {
      this.d.mFriendLikeCount = m(this.d.mFriendLikeCount, false);
    }
    for (;;)
    {
      this.d.mLikeCount = m(this.d.mLikeCount, false);
      Iterator localIterator = this.mLikeEntryList.iterator();
      LikeEntry localLikeEntry;
      while (localIterator.hasNext())
      {
        localLikeEntry = (LikeEntry)localIterator.next();
        if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
        {
          this.ak.remove(localLikeEntry.unionId);
          this.mLikeEntryList.remove(localLikeEntry);
        }
      }
      localIterator = this.oh.iterator();
      while (localIterator.hasNext())
      {
        localLikeEntry = (LikeEntry)localIterator.next();
        if (localLikeEntry.unionId.equals(paramLikeEntry.unionId))
        {
          this.an.remove(localLikeEntry.unionId);
          this.oh.remove(localLikeEntry);
        }
      }
      return;
      this.d.mFanLikeCount = m(this.d.mFanLikeCount, false);
    }
  }
  
  public List<StoryVideoItem> bS()
  {
    return this.mVideoItemList;
  }
  
  public List<rmw.a> bT()
  {
    return Collections.unmodifiableList(this.oi);
  }
  
  public void c(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.of.add(paramCommentEntry);
      this.aj.add(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      if (paramCommentEntry.type != 1)
      {
        if (!paramBoolean) {
          break label144;
        }
        this.d.mFanCommentCount = m(this.d.mFanCommentCount, true);
      }
    }
    for (;;)
    {
      this.d.mCommentCount = m(this.d.mCommentCount, true);
      return;
      this.og.add(paramCommentEntry);
      this.al.add(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      break;
      label144:
      this.d.mFriendCommentCount = m(this.d.mFriendCommentCount, true);
    }
  }
  
  public void d(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.of.iterator();
      while (localIterator.hasNext()) {
        if (((CommentEntry)localIterator.next()).equals(paramCommentEntry)) {
          localIterator.remove();
        }
      }
      this.aj.remove(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      if (paramCommentEntry.type != 1)
      {
        if (!paramBoolean) {
          break label210;
        }
        this.d.mFanCommentCount = m(this.d.mFanCommentCount, false);
      }
    }
    for (;;)
    {
      this.d.mCommentCount = m(this.d.mCommentCount, false);
      return;
      localIterator = this.og.iterator();
      while (localIterator.hasNext()) {
        if (((CommentEntry)localIterator.next()).equals(paramCommentEntry)) {
          localIterator.remove();
        }
      }
      this.al.remove(paramCommentEntry.authorUnionId + paramCommentEntry.fakeId);
      break;
      label210:
      this.d.mFriendCommentCount = m(this.d.mFriendCommentCount, false);
    }
  }
  
  public void d(List<CommentEntry> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.of;
    HashSet localHashSet = this.aj;
    if (!paramBoolean2)
    {
      localList = this.og;
      localHashSet = this.al;
    }
    for (;;)
    {
      CommentEntry localCommentEntry;
      if (paramBoolean1)
      {
        localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          localCommentEntry = (CommentEntry)localIterator.next();
          if (localCommentEntry.status == 0)
          {
            localHashSet.remove(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
            localIterator.remove();
          }
        }
        ram.b("Q.qqstory.detail.DetailFeedItem", "comment list's size is %d after clear.", Integer.valueOf(localList.size()));
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localCommentEntry = (CommentEntry)localIterator.next();
        if (!localHashSet.contains(localCommentEntry.authorUnionId + localCommentEntry.fakeId))
        {
          localHashSet.add(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
          localList.add(localCommentEntry);
        }
      }
      Collections.sort(localList, new qru.a());
      ram.b("Q.qqstory.detail.DetailFeedItem", "comment list's size is %d after add %d comments.", Integer.valueOf(localList.size()), Integer.valueOf(paramList.size()));
      return;
    }
  }
  
  public void e(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f = paramCommentEntry;
      return;
    }
    this.g = paramCommentEntry;
  }
  
  public void e(List<LikeEntry> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = this.mLikeEntryList;
    HashSet localHashSet = this.ak;
    if (!paramBoolean2)
    {
      localList = this.oh;
      localHashSet = this.an;
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        localList.clear();
        localHashSet.clear();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LikeEntry localLikeEntry = (LikeEntry)paramList.next();
        if (!localHashSet.contains(localLikeEntry.unionId))
        {
          localHashSet.add(localLikeEntry.unionId);
          localList.add(localLikeEntry);
        }
      }
      return;
    }
  }
  
  public List<CommentEntry> h(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.of;
    }
    return this.og;
  }
  
  public List<LikeEntry> i(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mLikeEntryList;
    }
    return this.oh;
  }
  
  public String j(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.aym;
    }
    return this.ayo;
  }
  
  public void o(StoryVideoItem paramStoryVideoItem)
  {
    this.mVideoItemList.remove(paramStoryVideoItem);
    this.ai.remove(paramStoryVideoItem.mVid);
  }
  
  public int r(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d.mFanCommentCount;
    }
    return this.d.mFriendCommentCount;
  }
  
  public int s(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.d.mFanLikeCount;
    }
    return this.d.mFriendLikeCount;
  }
  
  public void ti(boolean paramBoolean)
  {
    if (a(paramBoolean) != null)
    {
      d(a(paramBoolean), paramBoolean);
      e(null, paramBoolean);
    }
  }
  
  public String toString()
  {
    return "DetailFeedItem{mFeedBasicItem=" + this.d + ", mVideoItemList=" + this.mVideoItemList.size() + ", mFeedCommentList=" + this.of.size() + ", mCommentCookie=" + this.aym + ", mCommentIsEnd=" + this.aEZ + ", mLikeEntryList=" + this.mLikeEntryList.size() + ", mFriendCommentList=" + this.og.size() + ", mFriendCommentCookie=" + this.ayo + ", mFriendCommentIsEnd=" + this.aFa + ", mFriendLikeList=" + this.oh.size() + '}';
  }
  
  public void wv(int paramInt)
  {
    Iterator localIterator = this.of.iterator();
    CommentEntry localCommentEntry;
    while (localIterator.hasNext())
    {
      localCommentEntry = (CommentEntry)localIterator.next();
      if (localCommentEntry.commentId == paramInt)
      {
        this.aj.remove(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
        this.of.remove(localCommentEntry);
      }
    }
    localIterator = this.og.iterator();
    while (localIterator.hasNext())
    {
      localCommentEntry = (CommentEntry)localIterator.next();
      if (localCommentEntry.commentId == paramInt)
      {
        this.al.remove(localCommentEntry.authorUnionId + localCommentEntry.fakeId);
        this.og.remove(localCommentEntry);
      }
    }
  }
  
  public class a
    implements Comparator<CommentEntry>
  {
    public a() {}
    
    public int a(CommentEntry paramCommentEntry1, CommentEntry paramCommentEntry2)
    {
      if ((paramCommentEntry1.status == 0) && (paramCommentEntry2.status == 0)) {
        if (paramCommentEntry1.replyTime >= paramCommentEntry2.replyTime) {}
      }
      while ((paramCommentEntry1.status == 0) && (paramCommentEntry2.status != 0))
      {
        return -1;
        if (paramCommentEntry1.replyTime > paramCommentEntry2.replyTime) {
          return 1;
        }
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qru
 * JD-Core Version:    0.7.0.1
 */