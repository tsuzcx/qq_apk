import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

class kxc
  implements Comparator<Pair<Long, Pair<View, BaseArticleInfo>>>
{
  kxc(kxb paramkxb) {}
  
  public int a(Pair<Long, Pair<View, BaseArticleInfo>> paramPair1, Pair<Long, Pair<View, BaseArticleInfo>> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kxc
 * JD-Core Version:    0.7.0.1
 */