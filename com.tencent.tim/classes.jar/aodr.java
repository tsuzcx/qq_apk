import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aodr
  implements DialogInterface.OnClickListener
{
  public aodr(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, PadInfo paramPadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
    }
    while (this.this$0.a == null) {
      return;
    }
    paramDialogInterface = aobw.a(this.a.domainId, this.a.padId);
    this.this$0.a.a(this.this$0.aoW, paramDialogInterface, this.a.pad_url, true);
    this.this$0.VI(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodr
 * JD-Core Version:    0.7.0.1
 */