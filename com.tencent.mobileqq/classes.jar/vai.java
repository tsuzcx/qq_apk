import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.HiBoomItemBuilder;
import com.tencent.mobileqq.hiboom.HiBoomTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;

public class vai
  implements HiBoomTextView.OnDoubleClick
{
  public vai(HiBoomItemBuilder paramHiBoomItemBuilder) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.ItemBuilder", 2, "onDoubleClick");
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    if (HiBoomItemBuilder.a(this.a)) {
      return;
    }
    ChatActivityUtils.a(this.a.a, paramView, (FragmentActivity)this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vai
 * JD-Core Version:    0.7.0.1
 */