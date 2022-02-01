import android.content.Intent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;

class oua
  implements AdapterView.c
{
  oua(otz paramotz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (oub.d)otz.ml.get(paramInt);
    paramView = new Intent(paramView.getContext(), PublicAccountImageCollectionMainActivity.class);
    paramView.putExtra("recommend_source", paramAdapterView.source);
    paramView.putExtra("recommend_position", paramInt + 1);
    paramView.putExtra("click_source", 2);
    paramView.putExtra("source_for_report", 15);
    oub.a(otz.a(this.b), paramView, String.valueOf(paramAdapterView.arn));
    if ((otz.a(this.b) instanceof PublicAccountImageCollectionMainActivity))
    {
      paramView = (PublicAccountImageCollectionMainActivity)otz.a(this.b);
      paramInt += 1;
      paramView.n(2, paramInt, paramAdapterView.source);
      kbp.a(null, paramView.puin, "0X8007B94", "0X8007B94", 0, 0, paramView.Wz, paramView.webUrl, paramAdapterView.arn, "" + paramInt, false);
    }
    noy.a().clean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oua
 * JD-Core Version:    0.7.0.1
 */