import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class vdg
  implements View.OnClickListener
{
  public vdg(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int k = VipUtils.a(this.a.app, null);
    int i;
    label31:
    QQToast localQQToast;
    if ((k & 0x2) != 0)
    {
      i = 1;
      if ((k & 0x4) == 0) {
        break label103;
      }
      if ((i == 0) && (j == 0)) {
        break label108;
      }
      if (30 != this.a.oW.size()) {
        break label162;
      }
      localQQToast = new QQToast(this.a);
      localQQToast.setDuration(2000);
      localQQToast.setToastMsg(2131721193);
      localQQToast.show();
    }
    label162:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label31;
      label108:
      if (16 == this.a.oW.size())
      {
        localQQToast = new QQToast(this.a);
        localQQToast.setDuration(2000);
        localQQToast.setToastMsg(2131721192);
        localQQToast.show();
      }
      else
      {
        GroupManagerActivity.a(this.a, aqha.a(this.a, 2131694538, 2131694544, null, GroupManagerActivity.a(this.a), GroupManagerActivity.b(this.a)));
        GroupManagerActivity.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */