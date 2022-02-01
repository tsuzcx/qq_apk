import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.f;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class jnj
  implements AdapterView.c
{
  public jnj(PoiMapActivity.f paramf, PoiMapActivity paramPoiMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.R(paramInt, true);
    int i = this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.this$0.a.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.aCj != paramInt) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$f.this$0.a[paramInt].R(-1, false);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnj
 * JD-Core Version:    0.7.0.1
 */