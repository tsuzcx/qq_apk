import android.app.Dialog;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.POI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class bne
  implements AdapterView.OnItemClickListener
{
  public bne(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PoiMapActivity", 2, "setOnItemClickListener" + paramInt);
    }
    paramAdapterView = (PoiMapActivity.POI)this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.get(paramInt);
    if (paramAdapterView != null)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(paramAdapterView);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "click_sch_result", "", "", "");
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bne
 * JD-Core Version:    0.7.0.1
 */