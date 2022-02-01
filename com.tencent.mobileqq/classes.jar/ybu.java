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

public abstract class ybu<T extends CommentLikeFeedItem>
  extends ydz<T>
{
  protected HashSet<Integer> a;
  protected List<CommentEntry> a;
  protected HashSet<String> b;
  protected List<LikeEntry> b;
  
  public ybu(@NonNull T paramT)
  {
    super(paramT);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private wsl a(int paramInt, ybu paramybu, wsk paramwsk)
  {
    List localList = paramwsk.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramwsk = (wsl)localList.get(paramInt);; paramwsk = null)
    {
      if ((paramwsk != null) && (paramwsk.jdField_a_of_type_JavaLangString.equals(paramybu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramwsk;
      }
      paramwsk = new wsl();
      paramwsk.jdField_a_of_type_JavaLangString = paramybu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramwsk);
      if (paramInt >= 0) {
        return (wsl)localList.get(paramInt);
      }
      ykq.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramybu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  @Nullable
  private wso a(int paramInt, ybu paramybu, wsn paramwsn)
  {
    List localList = paramwsn.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramwsn = (wso)localList.get(paramInt);; paramwsn = null)
    {
      if ((paramwsn != null) && (paramwsn.jdField_a_of_type_JavaLangString.equals(paramybu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramwsn;
      }
      paramwsn = new wso();
      paramwsn.jdField_a_of_type_JavaLangString = paramybu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramwsn);
      if (paramInt >= 0) {
        return (wso)localList.get(paramInt);
      }
      ykq.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramybu.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  public T a()
  {
    return (CommentLikeFeedItem)super.a();
  }
  
  public abstract List<StoryVideoItem> a();
  
  public void a(int paramInt, wsq paramwsq, wsk paramwsk, wsn paramwsn)
  {
    if ((paramwsk != null) && (paramwsk.jdField_a_of_type_Int == 0))
    {
      paramwsq = a(paramInt, this, paramwsk);
      if (paramwsq != null)
      {
        a(paramwsq.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentCount = paramwsq.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentIsEnd = paramwsq.jdField_b_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie = paramwsq.jdField_b_of_type_JavaLangString;
      }
    }
    if ((paramwsn != null) && (paramwsn.jdField_a_of_type_Int == 0))
    {
      paramwsq = a(paramInt, this, paramwsn);
      if (paramwsq != null)
      {
        b(paramwsq.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mLikeCount = paramwsq.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mHadLike = paramwsq.jdField_b_of_type_Int;
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
    wip localwip = (wip)wjs.a(17);
    wje localwje = (wje)wjs.a(15);
    a(localwip.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
    b(localwje.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
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
 * Qualified Name:     ybu
 * JD-Core Version:    0.7.0.1
 */