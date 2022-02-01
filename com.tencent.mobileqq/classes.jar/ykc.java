import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class ykc
  implements Comparator<yjy>
{
  public int a(yjy paramyjy1, yjy paramyjy2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramyjy1 instanceof yju)) && (((HotRecommendFeedItem)((yju)paramyjy1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramyjy2 instanceof yju)) || (!((HotRecommendFeedItem)((yju)paramyjy2).a()).mIsTopLocation)) {
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
        if (paramyjy1.a.dateTimeMillis != paramyjy2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramyjy1 instanceof yka)) && (yka.a((yka)paramyjy1))) {
          return -1;
        }
        if (!(paramyjy2 instanceof yka)) {
          break label144;
        }
        j = k;
      } while (yka.a((yka)paramyjy2));
      return 0;
      j = k;
    } while (paramyjy1.a.dateTimeMillis <= paramyjy2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykc
 * JD-Core Version:    0.7.0.1
 */