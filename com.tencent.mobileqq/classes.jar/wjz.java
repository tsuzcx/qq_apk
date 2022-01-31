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

public abstract class wjz<T extends CommentLikeFeedItem>
  extends wme<T>
{
  protected HashSet<Integer> a;
  protected List<CommentEntry> a;
  protected HashSet<String> b;
  protected List<LikeEntry> b;
  
  public wjz(@NonNull T paramT)
  {
    super(paramT);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private vak a(int paramInt, wjz paramwjz, vaj paramvaj)
  {
    List localList = paramvaj.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramvaj = (vak)localList.get(paramInt);; paramvaj = null)
    {
      if ((paramvaj != null) && (paramvaj.jdField_a_of_type_JavaLangString.equals(paramwjz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramvaj;
      }
      paramvaj = new vak();
      paramvaj.jdField_a_of_type_JavaLangString = paramwjz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramvaj);
      if (paramInt >= 0) {
        return (vak)localList.get(paramInt);
      }
      wsv.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed comment for id:%s", new Object[] { paramwjz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  @Nullable
  private van a(int paramInt, wjz paramwjz, vam paramvam)
  {
    List localList = paramvam.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {}
    for (paramvam = (van)localList.get(paramInt);; paramvam = null)
    {
      if ((paramvam != null) && (paramvam.jdField_a_of_type_JavaLangString.equals(paramwjz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId))) {
        return paramvam;
      }
      paramvam = new van();
      paramvam.jdField_a_of_type_JavaLangString = paramwjz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId;
      paramInt = localList.indexOf(paramvam);
      if (paramInt >= 0) {
        return (van)localList.get(paramInt);
      }
      wsv.d("Q.qqstory.home.data.CommentLikeHomeFeed", "can't not find feed like for id:%s", new Object[] { paramwjz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
      return null;
    }
  }
  
  public T a()
  {
    return (CommentLikeFeedItem)super.a();
  }
  
  public abstract List<StoryVideoItem> a();
  
  public void a(int paramInt, vap paramvap, vaj paramvaj, vam paramvam)
  {
    if ((paramvaj != null) && (paramvaj.jdField_a_of_type_Int == 0))
    {
      paramvap = a(paramInt, this, paramvaj);
      if (paramvap != null)
      {
        a(paramvap.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentCount = paramvap.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentIsEnd = paramvap.jdField_b_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mCommentLastCookie = paramvap.jdField_b_of_type_JavaLangString;
      }
    }
    if ((paramvam != null) && (paramvam.jdField_a_of_type_Int == 0))
    {
      paramvap = a(paramInt, this, paramvam);
      if (paramvap != null)
      {
        b(paramvap.jdField_a_of_type_JavaUtilList, true);
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mLikeCount = paramvap.jdField_a_of_type_Int;
        ((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mHadLike = paramvap.jdField_b_of_type_Int;
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
    uqo localuqo = (uqo)urr.a(17);
    urd localurd = (urd)urr.a(15);
    a(localuqo.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
    b(localurd.a(((CommentLikeFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, false), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjz
 * JD-Core Version:    0.7.0.1
 */