import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aumh
  implements DialogInterface.OnClickListener
{
  public aumh(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, PadInfo paramPadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
    }
    while (this.this$0.a == null) {
      return;
    }
    paramDialogInterface = ault.a(this.c.domainId, this.c.padId);
    if (GroupTeamWorkListActivity.a(this.this$0).getCheckBoxState()) {
      this.this$0.a.a(this.this$0.aoW, paramDialogInterface, this.c.pad_url, true);
    }
    for (;;)
    {
      this.this$0.VI(1);
      return;
      this.this$0.a.a(this.this$0.aoW, paramDialogInterface, this.c.pad_url, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumh
 * JD-Core Version:    0.7.0.1
 */