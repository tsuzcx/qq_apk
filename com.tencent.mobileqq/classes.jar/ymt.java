import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ymt
  extends ylz
{
  public List<ynt> b = new ArrayList();
  public boolean e;
  
  public ymt(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ynt localynt = (ynt)localIterator.next();
      localStringBuilder.append("feedId:").append(localynt.a().feedId);
      localStringBuilder.append("unionId:").append(localynt.a().getOwner().getUnionId());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return "FeedData{" + super.toString() + "mFeedItems=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymt
 * JD-Core Version:    0.7.0.1
 */