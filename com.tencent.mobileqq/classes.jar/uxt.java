import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class uxt
  implements Comparator<uxp>
{
  public int a(uxp paramuxp1, uxp paramuxp2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramuxp1 instanceof uxl)) && (((HotRecommendFeedItem)((uxl)paramuxp1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramuxp2 instanceof uxl)) || (!((HotRecommendFeedItem)((uxl)paramuxp2).a()).mIsTopLocation)) {
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
        if (paramuxp1.a.dateTimeMillis != paramuxp2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramuxp1 instanceof uxr)) && (uxr.a((uxr)paramuxp1))) {
          return -1;
        }
        if (!(paramuxp2 instanceof uxr)) {
          break label144;
        }
        j = k;
      } while (uxr.a((uxr)paramuxp2));
      return 0;
      j = k;
    } while (paramuxp1.a.dateTimeMillis <= paramuxp2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxt
 * JD-Core Version:    0.7.0.1
 */