import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class wqp<T extends VideoListFeedItem>
  extends woi<T>
{
  public static wqr a;
  private boolean a;
  protected HashSet<String> c;
  protected List<StoryVideoItem> c;
  public boolean c;
  public List<xof> d = new ArrayList();
  
  static
  {
    jdField_a_of_type_Wqr = new wqr(null);
  }
  
  public wqp(@NonNull T paramT)
  {
    super(paramT);
    this.jdField_c_of_type_JavaUtilList = new ArrayList(0);
    this.jdField_c_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_Boolean = true;
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = xsm.a(paramString);
    return (localCalendar.get(1) + 0 <= paramString[0]) && (localCalendar.get(2) + 1 <= paramString[1]) && (localCalendar.get(5) + 0 <= paramString[2]);
  }
  
  public T a()
  {
    return (VideoListFeedItem)super.a();
  }
  
  public List<StoryVideoItem> a()
  {
    return Collections.unmodifiableList(this.jdField_c_of_type_JavaUtilList);
  }
  
  public void a()
  {
    c(((uvx)uwa.a(5)).a(((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, 0, a(), true), true);
    ((wpe)uwa.a(12)).a(0, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoSeq, a(), ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoNextCookie, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mIsVideoEnd, ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).mVideoPullType, true);
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_c_of_type_JavaUtilList.remove(paramInt);
    this.jdField_c_of_type_JavaUtilList.add(paramInt, paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
    paramStoryVideoItem = this.jdField_c_of_type_JavaUtilList.iterator();
    paramInt = 0;
    if (paramStoryVideoItem.hasNext())
    {
      if (!StoryVideoItem.isFakeVid(((StoryVideoItem)paramStoryVideoItem.next()).mVid)) {
        break label131;
      }
      paramInt += 1;
    }
    label131:
    for (;;)
    {
      break;
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        wxe.d("Q.qqstory.home.data.VideoListHomeFeed", "feed id %s, fake video count:%d", new Object[] { ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId, Integer.valueOf(paramInt) });
        xqq.a();
        return;
      }
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_c_of_type_JavaUtilList.remove(paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.remove(paramStoryVideoItem.mVid);
    xqq.a();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (this.jdField_c_of_type_JavaUtilHashSet.contains(paramStoryVideoItem.mVid)) {
      this.jdField_c_of_type_JavaUtilList.remove(paramStoryVideoItem);
    }
    this.jdField_c_of_type_JavaUtilList.add(0, paramStoryVideoItem);
    this.jdField_c_of_type_JavaUtilHashSet.add(paramStoryVideoItem.mVid);
    this.jdField_a_of_type_Boolean = true;
    boolean bool2;
    if (paramBoolean)
    {
      bool2 = a(a().date);
      wxe.b("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b before %s", Boolean.valueOf(bool2), this.jdField_c_of_type_JavaUtilList);
      paramStoryVideoItem = this.jdField_c_of_type_JavaUtilList;
      if (bool2) {
        break label129;
      }
    }
    label129:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      Collections.sort(paramStoryVideoItem, new wqs(paramBoolean));
      wxe.b("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b after %s", Boolean.valueOf(bool2), this.jdField_c_of_type_JavaUtilList);
      return;
    }
  }
  
  public boolean a()
  {
    try
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((StoryVideoItem)localIterator.next()).isUploadSuc();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      wxe.d("Q.qqstory.home.data.VideoListHomeFeed", "video item size:%d", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    c(((uvx)uwa.a(5)).a(((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem).feedId), true);
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (StoryVideoItem.isFakeVid(((StoryVideoItem)localIterator.next()).mVid)) {
        return true;
      }
    }
    return false;
  }
  
  public void c(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilHashSet.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      if (this.jdField_c_of_type_JavaUtilHashSet.contains(localStoryVideoItem.mVid)) {
        this.jdField_c_of_type_JavaUtilList.remove(localStoryVideoItem);
      }
      for (;;)
      {
        this.jdField_c_of_type_JavaUtilList.add(localStoryVideoItem);
        if (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        break;
        this.jdField_c_of_type_JavaUtilHashSet.add(localStoryVideoItem.mVid);
      }
    }
    paramBoolean = a(a().date);
    if ((!(a() instanceof TagFeedItem)) && (a().assignType() != 7))
    {
      paramList = this.jdField_c_of_type_JavaUtilList;
      if (paramBoolean) {
        break label173;
      }
    }
    label173:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Collections.sort(paramList, new wqs(paramBoolean));
      return;
    }
  }
  
  public List<StoryVideoItem> d()
  {
    return Collections.unmodifiableList(this.jdField_c_of_type_JavaUtilList);
  }
  
  public String toString()
  {
    return "hasFakeVideo=" + this.jdField_a_of_type_Boolean + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem + String.format("video=%d,like=%d,comment=%d", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()), Integer.valueOf(this.b.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */