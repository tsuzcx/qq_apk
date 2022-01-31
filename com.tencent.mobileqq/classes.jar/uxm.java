import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.List;

public abstract class uxm<T extends FeedItem>
{
  protected T a;
  public boolean b;
  
  public uxm(@NonNull T paramT)
  {
    vxp.a(paramT);
    this.a = paramT;
  }
  
  public static uxm a(int paramInt)
  {
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramInt);
    if (localFeedItem == null) {
      return null;
    }
    return localFeedItem.generateHomeFeed();
  }
  
  public T a()
  {
    return this.a;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, tlx paramtlx, tlr paramtlr, tlu paramtlu);
  
  public abstract boolean a(qqstory_struct.StoryFeed paramStoryFeed);
  
  public abstract void b();
  
  public List<StoryVideoItem> d()
  {
    return new ArrayList(0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (uxm)paramObject;
      if (this.a != null) {
        return this.a.equals(paramObject.a);
      }
    } while (paramObject.a == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.a != null) {
      return this.a.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxm
 * JD-Core Version:    0.7.0.1
 */