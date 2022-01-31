import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class wqr
  implements Comparator<wqn>
{
  public int a(wqn paramwqn1, wqn paramwqn2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramwqn1 instanceof wqj)) && (((HotRecommendFeedItem)((wqj)paramwqn1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramwqn2 instanceof wqj)) || (!((HotRecommendFeedItem)((wqj)paramwqn2).a()).mIsTopLocation)) {
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
        if (paramwqn1.a.dateTimeMillis != paramwqn2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramwqn1 instanceof wqp)) && (wqp.a((wqp)paramwqn1))) {
          return -1;
        }
        if (!(paramwqn2 instanceof wqp)) {
          break label144;
        }
        j = k;
      } while (wqp.a((wqp)paramwqn2));
      return 0;
      j = k;
    } while (paramwqn1.a.dateTimeMillis <= paramwqn2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqr
 * JD-Core Version:    0.7.0.1
 */