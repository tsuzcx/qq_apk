import android.content.Intent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

class tpl
  implements bhqp
{
  tpl(tpk paramtpk) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (tpu)tpk.a.get(paramInt);
    paramView = new Intent(paramView.getContext(), PublicAccountImageCollectionMainActivity.class);
    paramView.putExtra("recommend_source", paramAdapterView.c);
    paramView.putExtra("recommend_position", paramInt + 1);
    paramView.putExtra("click_source", 2);
    paramView.putExtra("source_for_report", 15);
    tpp.a(tpk.a(this.a), paramView, String.valueOf(paramAdapterView.d));
    if ((tpk.a(this.a) instanceof PublicAccountImageCollectionMainActivity))
    {
      paramView = (PublicAccountImageCollectionMainActivity)tpk.a(this.a);
      paramInt += 1;
      paramView.a(2, paramInt, paramAdapterView.c);
      nrt.a(null, paramView.a, "0X8007B94", "0X8007B94", 0, 0, paramView.b, paramView.c, paramAdapterView.d, "" + paramInt, false);
    }
    sff.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tpl
 * JD-Core Version:    0.7.0.1
 */