import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class xpi
  implements Comparator<xpe>
{
  public int a(xpe paramxpe1, xpe paramxpe2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramxpe1 instanceof xpa)) && (((HotRecommendFeedItem)((xpa)paramxpe1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramxpe2 instanceof xpa)) || (!((HotRecommendFeedItem)((xpa)paramxpe2).a()).mIsTopLocation)) {
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
        if (paramxpe1.a.dateTimeMillis != paramxpe2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramxpe1 instanceof xpg)) && (xpg.a((xpg)paramxpe1))) {
          return -1;
        }
        if (!(paramxpe2 instanceof xpg)) {
          break label144;
        }
        j = k;
      } while (xpg.a((xpg)paramxpe2));
      return 0;
      j = k;
    } while (paramxpe1.a.dateTimeMillis <= paramxpe2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpi
 * JD-Core Version:    0.7.0.1
 */