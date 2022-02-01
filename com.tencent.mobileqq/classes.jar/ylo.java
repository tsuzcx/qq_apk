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

public abstract class ylo<T extends CommentLikeFeedItem>
  extends ynt<T>
{
  protected HashSet<Integer> a;
  protected List<CommentEntry> a;
  protected HashSet<String> b;
  protected List<LikeEntry> b;
  
  public ylo(@NonNull T paramT)
  {
    super(paramT);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private xca a(int paramInt, ylo paramylo, xbz paramxbz)
  {
    List localList = paramxbz.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramxbz = (xca)localList.get(paramInt);; paramxbz = null)
    {
      if ((paramxbz != null) && (paramxbz.jdField_a_of_type_JavaLangString.equals(paramylo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramxbz;
      }
      paramxbz = new xca();
      paramxbz.jdField_a_of_type_JavaLangString = paramylo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramxbz);
      if (paramInt >= 0) {
        return (xca)localList.get(paramInt);
      }
      yuk.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramylo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  @Nullable
  private xcd a(int paramInt, ylo paramylo, xcc paramxcc)
  {
    List localList = paramxcc.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramxcc = (xcd)localList.get(paramInt);; paramxcc = null)
    {
      if ((paramxcc != null) && (paramxcc.jdField_a_of_type_JavaLangString.equals(paramylo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramxcc;
      }
      paramxcc = new xcd();
      paramxcc.jdField_a_of_type_JavaLangString = paramylo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramxcc);
      if (paramInt >= 0) {
        return (xcd)localList.get(paramInt);
      }
      yuk.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramylo.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  public T a()
  {
    return (CommentLikeFeedItem)super.a();
  }
  
  public abstract List<StoryVideoItem> a();
  
  public void a(int paramInt, xcf paramxcf, xbz paramxbz, xcc paramxcc)
  {
    if ((paramxbz != null) && (paramxbz.jdField_a_of_type_Int == 0))
    {
      paramxcf = a(paramInt, this, paramxbz);
      if (paramxcf != null)
      {
        a(paramxcf.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentCount = paramxcf.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentIsEnd = paramxcf.jdField_b_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie = paramxcf.jdField_b_of_type_JavaLangString;
      }
    }
    if ((paramxcc != null) && (paramxcc.jdField_a_of_type_Int == 0))
    {
      paramxcf = a(paramInt, this, paramxcc);
      if (paramxcf != null)
      {
        b(paramxcf.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mLikeCount = paramxcf.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mHadLike = paramxcf.jdField_b_of_type_Int;
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
    wse localwse = (wse)wth.a(17);
    wst localwst = (wst)wth.a(15);
    a(localwse.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
    b(localwst.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylo
 * JD-Core Version:    0.7.0.1
 */