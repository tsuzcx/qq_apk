import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qvq
  extends qve.a
{
  public boolean aFO;
  public List<qwa> or = new ArrayList();
  
  public qvq(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String mQ()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.or.iterator();
    while (localIterator.hasNext())
    {
      qwa localqwa = (qwa)localIterator.next();
      localStringBuilder.append("feedId:").append(localqwa.a().feedId);
      localStringBuilder.append("unionId:").append(localqwa.a().getOwner().getUnionId());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return "FeedData{" + super.toString() + "mFeedItems=" + this.or + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvq
 * JD-Core Version:    0.7.0.1
 */