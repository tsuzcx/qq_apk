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

public abstract class uvh<T extends CommentLikeFeedItem>
  extends uxm<T>
{
  protected HashSet<Integer> a;
  protected List<CommentEntry> a;
  protected HashSet<String> b;
  protected List<LikeEntry> b;
  
  public uvh(@NonNull T paramT)
  {
    super(paramT);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private tls a(int paramInt, uvh paramuvh, tlr paramtlr)
  {
    List localList = paramtlr.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramtlr = (tls)localList.get(paramInt);; paramtlr = null)
    {
      if ((paramtlr != null) && (paramtlr.jdField_a_of_type_JavaLangString.equals(paramuvh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramtlr;
      }
      paramtlr = new tls();
      paramtlr.jdField_a_of_type_JavaLangString = paramuvh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramtlr);
      if (paramInt >= 0) {
        return (tls)localList.get(paramInt);
      }
      ved.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramuvh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  @Nullable
  private tlv a(int paramInt, uvh paramuvh, tlu paramtlu)
  {
    List localList = paramtlu.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramtlu = (tlv)localList.get(paramInt);; paramtlu = null)
    {
      if ((paramtlu != null) && (paramtlu.jdField_a_of_type_JavaLangString.equals(paramuvh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramtlu;
      }
      paramtlu = new tlv();
      paramtlu.jdField_a_of_type_JavaLangString = paramuvh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramtlu);
      if (paramInt >= 0) {
        return (tlv)localList.get(paramInt);
      }
      ved.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramuvh.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  public T a()
  {
    return (CommentLikeFeedItem)super.a();
  }
  
  public abstract List<StoryVideoItem> a();
  
  public void a(int paramInt, tlx paramtlx, tlr paramtlr, tlu paramtlu)
  {
    if ((paramtlr != null) && (paramtlr.jdField_a_of_type_Int == 0))
    {
      paramtlx = a(paramInt, this, paramtlr);
      if (paramtlx != null)
      {
        a(paramtlx.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentCount = paramtlx.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentIsEnd = paramtlx.jdField_b_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie = paramtlx.jdField_b_of_type_JavaLangString;
      }
    }
    if ((paramtlu != null) && (paramtlu.jdField_a_of_type_Int == 0))
    {
      paramtlx = a(paramInt, this, paramtlu);
      if (paramtlx != null)
      {
        b(paramtlx.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mLikeCount = paramtlx.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mHadLike = paramtlx.jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramCommentEntry.commentId))) {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramCommentEntry.commentId));
    }
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)paramList.next();
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(localCommentEntry.commentId))) {
        this.jdField_a_of_type_JavaUtilList.remove(localCommentEntry);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
        break;
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(localCommentEntry.commentId));
      }
    }
  }
  
  public List<CommentEntry> b()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void b()
  {
    tbw localtbw = (tbw)tcz.a(17);
    tcl localtcl = (tcl)tcz.a(15);
    a(localtbw.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
    b(localtcl.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
  }
  
  public void b(List<LikeEntry> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.next();
      if (this.jdField_b_of_type_JavaUtilHashSet.contains(localLikeEntry.unionId)) {
        this.jdField_b_of_type_JavaUtilList.remove(localLikeEntry);
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilList.add(localLikeEntry);
        break;
        this.jdField_b_of_type_JavaUtilHashSet.add(localLikeEntry.unionId);
      }
    }
  }
  
  public List<LikeEntry> c()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvh
 * JD-Core Version:    0.7.0.1
 */