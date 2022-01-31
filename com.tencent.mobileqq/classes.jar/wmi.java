import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import java.util.Comparator;

public class wmi
  implements Comparator<wme>
{
  public int a(wme paramwme1, wme paramwme2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramwme1 instanceof wma)) && (((HotRecommendFeedItem)((wma)paramwme1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramwme2 instanceof wma)) || (!((HotRecommendFeedItem)((wma)paramwme2).a()).mIsTopLocation)) {
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
        if (paramwme1.a.dateTimeMillis != paramwme2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramwme1 instanceof wmg)) && (wmg.a((wmg)paramwme1))) {
          return -1;
        }
        if (!(paramwme2 instanceof wmg)) {
          break label144;
        }
        j = k;
      } while (wmg.a((wmg)paramwme2));
      return 0;
      j = k;
    } while (paramwme1.a.dateTimeMillis <= paramwme2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */