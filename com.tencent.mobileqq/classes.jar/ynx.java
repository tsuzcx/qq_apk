import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class ynx
  implements Comparator<ynt>
{
  public int a(ynt paramynt1, ynt paramynt2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramynt1 instanceof ynp)) && (((HotRecommendFeedItem)((ynp)paramynt1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramynt2 instanceof ynp)) || (!((HotRecommendFeedItem)((ynp)paramynt2).a()).mIsTopLocation)) {
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
        if (paramynt1.a.dateTimeMillis != paramynt2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramynt1 instanceof ynv)) && (ynv.a((ynv)paramynt1))) {
          return -1;
        }
        if (!(paramynt2 instanceof ynv)) {
          break label144;
        }
        j = k;
      } while (ynv.a((ynv)paramynt2));
      return 0;
      j = k;
    } while (paramynt1.a.dateTimeMillis <= paramynt2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynx
 * JD-Core Version:    0.7.0.1
 */