import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class uxq
  implements Comparator<uxm>
{
  public int a(uxm paramuxm1, uxm paramuxm2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramuxm1 instanceof uxi)) && (((HotRecommendFeedItem)((uxi)paramuxm1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramuxm2 instanceof uxi)) || (!((HotRecommendFeedItem)((uxi)paramuxm2).a()).mIsTopLocation)) {
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
        if (paramuxm1.a.dateTimeMillis != paramuxm2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramuxm1 instanceof uxo)) && (uxo.a((uxo)paramuxm1))) {
          return -1;
        }
        if (!(paramuxm2 instanceof uxo)) {
          break label144;
        }
        j = k;
      } while (uxo.a((uxo)paramuxm2));
      return 0;
      j = k;
    } while (paramuxm1.a.dateTimeMillis <= paramuxm2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */