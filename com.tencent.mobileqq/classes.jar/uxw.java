import android.content.Intent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

class uxw
  implements bljm
{
  uxw(uxv paramuxv) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (uyf)uxv.a.get(paramInt);
    paramView = new Intent(paramView.getContext(), PublicAccountImageCollectionMainActivity.class);
    paramView.putExtra("recommend_source", paramAdapterView.c);
    paramView.putExtra("recommend_position", paramInt + 1);
    paramView.putExtra("click_source", 2);
    paramView.putExtra("source_for_report", 15);
    uya.a(uxv.a(this.a), paramView, String.valueOf(paramAdapterView.d));
    if ((uxv.a(this.a) instanceof PublicAccountImageCollectionMainActivity))
    {
      paramView = (PublicAccountImageCollectionMainActivity)uxv.a(this.a);
      paramInt += 1;
      paramView.a(2, paramInt, paramAdapterView.c);
      ocd.a(null, paramView.a, "0X8007B94", "0X8007B94", 0, 0, paramView.b, paramView.c, paramAdapterView.d, "" + paramInt, false);
    }
    sun.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxw
 * JD-Core Version:    0.7.0.1
 */