import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.List;

public abstract class qwa<T extends FeedItem>
{
  public boolean FR;
  protected T c;
  
  public qwa(@NonNull T paramT)
  {
    rom.checkNotNull(paramT);
    this.c = paramT;
  }
  
  public static qwa a(int paramInt)
  {
    FeedItem localFeedItem = FeedItem.createFeedItemByType(paramInt);
    if (localFeedItem == null) {
      return null;
    }
    return localFeedItem.generateHomeFeed();
  }
  
  public T a()
  {
    return this.c;
  }
  
  public abstract void a(int paramInt, pyk.a parama, pyi.a parama1, pyj.a parama2);
  
  public abstract boolean a(qqstory_struct.StoryFeed paramStoryFeed);
  
  public List<StoryVideoItem> bZ()
  {
    return new ArrayList(0);
  }
  
  public abstract void bra();
  
  public abstract void brb();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (qwa)paramObject;
      if (this.c != null) {
        return this.c.equals(paramObject.c);
      }
    } while (paramObject.c == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.c != null) {
      return this.c.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwa
 * JD-Core Version:    0.7.0.1
 */