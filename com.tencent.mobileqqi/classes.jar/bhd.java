import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.PoiItemAdapter;
import com.tencent.biz.PoiMapActivity.PoiTab;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class bhd
  implements AbsListView.OnScrollListener
{
  public bhd(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.r() == paramAbsListView.a() - 1) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.a.b)) {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.b(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhd
 * JD-Core Version:    0.7.0.1
 */