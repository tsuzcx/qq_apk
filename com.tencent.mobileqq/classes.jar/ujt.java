import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ujt
  extends uiz
{
  public List<ukt> b = new ArrayList();
  public boolean e;
  
  public ujt(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ukt localukt = (ukt)localIterator.next();
      localStringBuilder.append("feedId:").append(localukt.a().feedId);
      localStringBuilder.append("unionId:").append(localukt.a().getOwner().getUnionId());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return "FeedData{" + super.toString() + "mFeedItems=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujt
 * JD-Core Version:    0.7.0.1
 */