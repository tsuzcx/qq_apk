import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class uwm
  extends uvs
{
  public List<uxm> b = new ArrayList();
  public boolean e;
  
  public uwm(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      uxm localuxm = (uxm)localIterator.next();
      localStringBuilder.append("feedId:").append(localuxm.a().feedId);
      localStringBuilder.append("unionId:").append(localuxm.a().getOwner().getUnionId());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return "FeedData{" + super.toString() + "mFeedItems=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwm
 * JD-Core Version:    0.7.0.1
 */