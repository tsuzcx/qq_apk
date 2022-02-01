import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.c;
import com.tencent.biz.PoiMapActivity.f;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

public class jnk
  implements AbsListView.e
{
  public jnk(PoiMapActivity.f paramf, PoiMapActivity paramPoiMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.a.hasMore))
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.lr(false);
      if (!PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.this$0)) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.this$0.report("share_locate", "turn_page", this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.this$0.To, this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.this$0.Tn, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnk
 * JD-Core Version:    0.7.0.1
 */