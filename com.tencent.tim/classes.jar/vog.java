import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.a;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class vog
  implements AdapterView.c
{
  public vog(QQLSActivity paramQQLSActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (RecentBaseData)QQLSActivity.a(this.this$0).getItem(paramInt);
    paramLong = paramAdapterView.getAdapter().getItemId(paramInt);
    if ((paramLong == QQLSActivity.a(this.this$0)) && (Math.abs(QQLSActivity.b(this.this$0) - System.currentTimeMillis()) < 300L))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "mRecentList is double click");
      }
      QQLSActivity.a(this.this$0, -1L);
      QQLSActivity.b(this.this$0, 0L);
      QQLSActivity.a(this.this$0, paramView);
      QQLSActivity.a(this.this$0, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQLSActivity", 2, "mRecentList  click once");
    }
    QQLSActivity.a(this.this$0, paramLong);
    QQLSActivity.b(this.this$0, System.currentTimeMillis());
    if (QQLSActivity.a(this.this$0)) {
      QQLSActivity.a(this.this$0).setText(2131701311);
    }
    for (;;)
    {
      paramAdapterView = QQLSActivity.a(this.this$0).obtainMessage(6);
      QQLSActivity.a(this.this$0).sendMessageDelayed(paramAdapterView, 500L);
      return;
      QQLSActivity.a(this.this$0).setText(2131701310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */