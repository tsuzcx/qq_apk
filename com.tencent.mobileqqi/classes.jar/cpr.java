import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class cpr
  implements View.OnClickListener
{
  public cpr(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = VipUtils.a(this.a.b, null);
    int i;
    if ((k & 0x2) != 0)
    {
      i = 1;
      if ((k & 0x4) == 0) {
        break label91;
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0)) {
        break label96;
      }
      if (30 != this.a.a.size()) {
        break label143;
      }
      paramView = new QQToast(this.a);
      paramView.c(2000);
      paramView.b(2131563261);
      paramView.a();
      return;
      i = 0;
      break;
      label91:
      j = 0;
    }
    label96:
    if (16 == this.a.a.size())
    {
      paramView = new QQToast(this.a);
      paramView.c(2000);
      paramView.b(2131563260);
      paramView.a();
      return;
    }
    label143:
    GroupManagerActivity.a(this.a, DialogUtil.a(this.a, 2131561596, 2131562625, null, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
    GroupManagerActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cpr
 * JD-Core Version:    0.7.0.1
 */