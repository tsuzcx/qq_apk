import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class yed
  implements Comparator<ydz>
{
  public int a(ydz paramydz1, ydz paramydz2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramydz1 instanceof ydv)) && (((HotRecommendFeedItem)((ydv)paramydz1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramydz2 instanceof ydv)) || (!((HotRecommendFeedItem)((ydv)paramydz2).a()).mIsTopLocation)) {
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
        if (paramydz1.a.dateTimeMillis != paramydz2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramydz1 instanceof yeb)) && (yeb.a((yeb)paramydz1))) {
          return -1;
        }
        if (!(paramydz2 instanceof yeb)) {
          break label144;
        }
        j = k;
      } while (yeb.a((yeb)paramydz2));
      return 0;
      j = k;
    } while (paramydz1.a.dateTimeMillis <= paramydz2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yed
 * JD-Core Version:    0.7.0.1
 */