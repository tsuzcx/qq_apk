import android.view.View;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wdk
  implements ausj.a
{
  public wdk(TroopRequestActivity paramTroopRequestActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 20011;
    switch (paramInt)
    {
    default: 
      this.val$sheet.dismiss();
      return;
    }
    if (aqiw.isNetSupport(BaseApplication.getContext())) {
      paramInt = i;
    }
    for (;;)
    {
      try
      {
        switch (this.this$0.a.msg.group_msg_type.get())
        {
        case 1: 
        case 22: 
          long l = this.this$0.a.msg.group_code.get();
          paramView = this.this$0.app.getCurrentAccountUin();
          stj.a(this.this$0, this.this$0.aRG, String.valueOf(l), paramView, paramInt, null);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        continue;
      }
      anot.a(this.this$0.app, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, this.this$0.aKI, this.this$0.aRH, "", "");
      break;
      paramInt = 20009;
      continue;
      QQToast.a(this.this$0, 2131696272, 0).show(this.this$0.getTitleBarHeight());
      continue;
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdk
 * JD-Core Version:    0.7.0.1
 */