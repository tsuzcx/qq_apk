import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;
import java.util.List;

public class aume
  implements DialogInterface.OnClickListener
{
  public aume(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 4;
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      return;
    }
    paramDialogInterface = (aulh)this.this$0.app.getBusinessHandler(122);
    if (this.this$0.bQb == 0) {}
    for (;;)
    {
      paramDialogInterface.af(this.lj, paramInt);
      this.this$0.VI(1);
      if (this.lj.size() != 0) {
        break;
      }
      this.this$0.VI(2);
      GroupTeamWorkListActivity.a(this.this$0, false);
      return;
      if (this.this$0.bQb == 2) {
        paramInt = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aume
 * JD-Core Version:    0.7.0.1
 */