import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.c;

class yki
  implements TimeSelectView.c
{
  yki(ykh paramykh) {}
  
  public void dn()
  {
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "onConfirm: ");
    long l = System.currentTimeMillis();
    boolean bool = false;
    if (ykh.a(this.b) > l) {
      bool = true;
    }
    if (ykh.a(this.b) != null) {
      ykh.a(this.b).ag(ykh.a(this.b), bool);
    }
    if (bool) {
      ykh.a(this.b).dismiss();
    }
    int i = (int)(ykh.a(this.b) - System.currentTimeMillis()) / 60000;
    anot.a(null, "dc00898", "", "", "0X800AE7F", "0X800AE7F", ykh.a(this.b), i, "", "", "", "");
  }
  
  public void fF(View paramView)
  {
    ykh.a(this.b).dismiss();
    anot.a(null, "dc00898", "", "", "0X800AE80", "0X800AE80", 0, 0, "", "", "", "");
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    ykh.a(this.b, paramInt1, paramInt2);
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "column: " + paramInt1 + ", row: " + paramInt2);
    if (paramInt1 == 0) {
      ykh.a(this.b).LV(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yki
 * JD-Core Version:    0.7.0.1
 */