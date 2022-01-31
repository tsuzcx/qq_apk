import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.ShopListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class bms
  implements AbsListView.OnScrollListener
{
  public bms(PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.r() == paramAbsListView.a() - 1) && (this.a.a.a)) {
      this.a.a.a();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bms
 * JD-Core Version:    0.7.0.1
 */