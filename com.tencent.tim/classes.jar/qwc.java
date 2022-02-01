import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class qwc<T extends VideoListFeedItem>
  extends qux<T>
{
  public static qwc.a a = new qwc.a(null);
  public boolean aFP = true;
  private boolean aFQ;
  protected HashSet<String> ai = new HashSet();
  protected List<StoryVideoItem> mVideoItemList = new ArrayList(0);
  public List<rmw.a> oi = new ArrayList();
  
  public qwc(@NonNull T paramT)
  {
    super(paramT);
  }
  
  private boolean fs(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = rpq.g(paramString);
    return (localCalendar.get(1) + 0 <= paramString[0]) && (localCalendar.get(2) + 1 <= paramString[1]) && (localCalendar.get(5) + 0 <= paramString[2]);
  }
  
  public void I(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mVideoItemList.clear();
      this.ai.clear();
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      if (this.ai.contains(localStoryVideoItem.mVid)) {
        this.mVideoItemList.remove(localStoryVideoItem);
      }
      for (;;)
      {
        this.mVideoItemList.add(localStoryVideoItem);
        if (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {
          break;
        }
        this.aFQ = true;
        break;
        this.ai.add(localStoryVideoItem.mVid);
      }
    }
    paramBoolean = fs(c().date);
    if ((!(c() instanceof TagFeedItem)) && (c().assignType() != 7))
    {
      paramList = this.mVideoItemList;
      if (paramBoolean) {
        break label173;
      }
    }
    label173:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Collections.sort(paramList, new qwc.b(paramBoolean));
      return;
    }
  }
  
  public boolean KD()
  {
    try
    {
      Iterator localIterator = this.mVideoItemList.iterator();
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
      ram.w("Q.qqstory.home.data.VideoListHomeFeed", "video item size:%d", new Object[] { Integer.valueOf(this.mVideoItemList.size()) });
    }
    return false;
  }
  
  public boolean KE()
  {
    Iterator localIterator = this.mVideoItemList.iterator();
    while (localIterator.hasNext()) {
      if (StoryVideoItem.isFakeVid(((StoryVideoItem)localIterator.next()).mVid)) {
        return true;
      }
    }
    return false;
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    this.mVideoItemList.remove(paramInt);
    this.mVideoItemList.add(paramInt, paramStoryVideoItem);
    this.ai.add(paramStoryVideoItem.mVid);
    paramStoryVideoItem = this.mVideoItemList.iterator();
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
        this.aFQ = bool;
        ram.w("Q.qqstory.home.data.VideoListHomeFeed", "feed id %s, fake video count:%d", new Object[] { ((VideoListFeedItem)this.c).feedId, Integer.valueOf(paramInt) });
        rom.bvK();
        return;
      }
    }
  }
  
  public List<StoryVideoItem> bS()
  {
    return Collections.unmodifiableList(this.mVideoItemList);
  }
  
  public List<StoryVideoItem> bZ()
  {
    return Collections.unmodifiableList(this.mVideoItemList);
  }
  
  public void bra()
  {
    I(((psu)psx.a(5)).a(((VideoListFeedItem)this.c).feedId, 0, bS(), true), true);
    ((qvi)psx.a(12)).a(0, ((VideoListFeedItem)this.c).feedId, ((VideoListFeedItem)this.c).mVideoSeq, bS(), ((VideoListFeedItem)this.c).mVideoNextCookie, ((VideoListFeedItem)this.c).mIsVideoEnd, ((VideoListFeedItem)this.c).mVideoPullType, true);
  }
  
  public void brb()
  {
    super.brb();
    I(((psu)psx.a(5)).P(((VideoListFeedItem)this.c).feedId), true);
  }
  
  public T c()
  {
    return (VideoListFeedItem)super.a();
  }
  
  public void c(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    boolean bool1 = true;
    if (this.ai.contains(paramStoryVideoItem.mVid)) {
      this.mVideoItemList.remove(paramStoryVideoItem);
    }
    this.mVideoItemList.add(0, paramStoryVideoItem);
    this.ai.add(paramStoryVideoItem.mVid);
    this.aFQ = true;
    boolean bool2;
    if (paramBoolean)
    {
      bool2 = fs(c().date);
      ram.d("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b before %s", Boolean.valueOf(bool2), this.mVideoItemList);
      paramStoryVideoItem = this.mVideoItemList;
      if (bool2) {
        break label130;
      }
    }
    label130:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      Collections.sort(paramStoryVideoItem, new qwc.b(paramBoolean));
      ram.d("Q.qqstory.home.data.VideoListHomeFeed", "sort today=%b after %s", Boolean.valueOf(bool2), this.mVideoItemList);
      return;
    }
  }
  
  public void o(StoryVideoItem paramStoryVideoItem)
  {
    this.mVideoItemList.remove(paramStoryVideoItem);
    this.ai.remove(paramStoryVideoItem.mVid);
    rom.bvK();
  }
  
  public String toString()
  {
    return "hasFakeVideo=" + this.aFQ + this.c + String.format("video=%d,like=%d,comment=%d", new Object[] { Integer.valueOf(this.mVideoItemList.size()), Integer.valueOf(this.mLikeEntryList.size()), Integer.valueOf(this.of.size()) });
  }
  
  public static class a
    implements Comparator<qwa>
  {
    public int a(qwa paramqwa1, qwa paramqwa2)
    {
      int k = 1;
      int i;
      int j;
      if (((paramqwa1 instanceof qvx)) && (((HotRecommendFeedItem)((qvx)paramqwa1).c()).mIsTopLocation))
      {
        i = 1;
        if ((!(paramqwa2 instanceof qvx)) || (!((HotRecommendFeedItem)((qvx)paramqwa2).c()).mIsTopLocation)) {
          break label80;
        }
        j = 1;
        label54:
        if ((j ^ i) == 0) {
          break label86;
        }
        j = k;
        if (i != 0) {
          j = -1;
        }
      }
      label80:
      label86:
      do
      {
        do
        {
          return j;
          i = 0;
          break;
          j = 0;
          break label54;
          if (paramqwa1.c.dateTimeMillis != paramqwa2.c.dateTimeMillis) {
            break label146;
          }
          if (((paramqwa1 instanceof qwc)) && (qwc.b((qwc)paramqwa1))) {
            return -1;
          }
          if (!(paramqwa2 instanceof qwc)) {
            break label144;
          }
          j = k;
        } while (qwc.b((qwc)paramqwa2));
        return 0;
        j = k;
      } while (paramqwa1.c.dateTimeMillis <= paramqwa2.c.dateTimeMillis);
      label144:
      label146:
      return -1;
    }
  }
  
  public static class b
    implements Comparator<StoryVideoItem>
  {
    private boolean aFR;
    
    public b(boolean paramBoolean)
    {
      this.aFR = paramBoolean;
    }
    
    public int a(StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
    {
      int j = 1;
      int i = -1;
      if (paramStoryVideoItem1.isUploadFail() == paramStoryVideoItem2.isUploadFail()) {
        if (paramStoryVideoItem1.mCreateTime == paramStoryVideoItem2.mCreateTime) {
          i = 0;
        }
      }
      do
      {
        do
        {
          return i;
          if (paramStoryVideoItem1.mCreateTime <= paramStoryVideoItem2.mCreateTime) {
            break;
          }
          i = j;
        } while (this.aFR);
        return -1;
        if (this.aFR) {}
        for (;;)
        {
          return i;
          i = 1;
        }
        if (!paramStoryVideoItem1.isUploadFail()) {
          break;
        }
        i = j;
      } while (this.aFR);
      return -1;
      if (paramStoryVideoItem2.isUploadFail())
      {
        if (this.aFR) {}
        for (;;)
        {
          return i;
          i = 1;
        }
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwc
 * JD-Core Version:    0.7.0.1
 */