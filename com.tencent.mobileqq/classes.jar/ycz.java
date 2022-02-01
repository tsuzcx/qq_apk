import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ycz
  extends ycf
{
  public List<ydz> b = new ArrayList();
  public boolean e;
  
  public ycz(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ydz localydz = (ydz)localIterator.next();
      localStringBuilder.append("feedId:").append(localydz.a().feedId);
      localStringBuilder.append("unionId:").append(localydz.a().getOwner().getUnionId());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return "FeedData{" + super.toString() + "mFeedItems=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycz
 * JD-Core Version:    0.7.0.1
 */