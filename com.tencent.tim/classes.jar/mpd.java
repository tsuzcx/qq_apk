import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment;
import com.tencent.widget.ListView;

public class mpd
  extends amlu<ampx, amxy>
{
  public mpd(HybridSearchFragment paramHybridSearchFragment, ListView paramListView, aqdf paramaqdf)
  {
    super(paramListView, paramaqdf);
  }
  
  protected amsq<ampx, amxy> a(int paramInt)
  {
    if (((ampx)a(paramInt) instanceof amok)) {
      return new amtx(this.a, this.b, HybridSearchFragment.a(this.b), null);
    }
    return new moz(this.a, this.b, HybridSearchFragment.a(this.b));
  }
  
  protected amxz a(int paramInt, ViewGroup paramViewGroup)
  {
    return new amxs(paramViewGroup, 2131563032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpd
 * JD-Core Version:    0.7.0.1
 */