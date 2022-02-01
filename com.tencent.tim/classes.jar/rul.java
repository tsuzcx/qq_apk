import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rul
  implements AdapterView.OnItemClickListener
{
  public rul(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QRDisplayActivity.a(this.this$0).dismiss();
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
    }
    this.this$0.atU = ((int)paramLong);
    QRDisplayActivity.a(this.this$0);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rul
 * JD-Core Version:    0.7.0.1
 */