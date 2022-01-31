import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class ukx
  implements Comparator<ukt>
{
  public int a(ukt paramukt1, ukt paramukt2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramukt1 instanceof ukp)) && (((HotRecommendFeedItem)((ukp)paramukt1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramukt2 instanceof ukp)) || (!((HotRecommendFeedItem)((ukp)paramukt2).a()).mIsTopLocation)) {
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
        if (paramukt1.a.dateTimeMillis != paramukt2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramukt1 instanceof ukv)) && (ukv.a((ukv)paramukt1))) {
          return -1;
        }
        if (!(paramukt2 instanceof ukv)) {
          break label144;
        }
        j = k;
      } while (ukv.a((ukv)paramukt2));
      return 0;
      j = k;
    } while (paramukt1.a.dateTimeMillis <= paramukt2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukx
 * JD-Core Version:    0.7.0.1
 */