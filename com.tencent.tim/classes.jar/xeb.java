import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.hiboom.HiBoomTextView.d;
import com.tencent.qphone.base.util.QLog;

class xeb
  implements HiBoomTextView.d
{
  xeb(xea paramxea) {}
  
  public void R(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.ItemBuilder", 2, "onDoubleClick");
    }
    wja.bcO = true;
    if (this.a.Rk()) {
      return;
    }
    ChatActivityUtils.a(this.a.app, paramView, (FragmentActivity)this.a.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xeb
 * JD-Core Version:    0.7.0.1
 */