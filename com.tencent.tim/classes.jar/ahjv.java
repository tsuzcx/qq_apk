import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ahjv
  extends ahgq
{
  AbsStructMsg b;
  AbsShareMsg d;
  
  public ahjv(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean a(aqju paramaqju)
  {
    if (this.b != null) {
      paramaqju.addView(this.b.getPreDialogView(this.mActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.d != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(wja.dp2px(-15.0F, this.mActivity.getResources()), 0, wja.dp2px(-15.0F, this.mActivity.getResources()), wja.dp2px(5.0F, this.mActivity.getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardRecommendFriendOption", 2, "updateImageView addStructView");
        }
        paramaqju.addView(this.d.getPreDialogView(this.mActivity, null), localLayoutParams);
      }
    }
  }
  
  public boolean anj()
  {
    super.anj();
    AbsStructMsg localAbsStructMsg = anre.a(this.bf.getByteArray("stuctmsg_bytes"));
    this.b = anre.a(this.bf.getByteArray("struct_msg_show_in_dialog"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.d = ((AbsShareMsg)localAbsStructMsg);
    }
    return true;
  }
  
  protected void dnO()
  {
    int i = this.mIntent.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      anot.a(this.app, "CliOper", "", "", "0X8005B35", "0X8005B35", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.dnO();
      return;
      if (i == 84) {
        if (this.mIntent.getIntExtra("pa_type", -1) == 53) {
          anot.a(this.app, "CliOper", "", "", "0X8007017", "0X8007017", 0, 0, "", "", "", "");
        } else {
          anot.a(this.app, "CliOper", "", "", "0X800716A", "0X800716A", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  protected void dnv()
  {
    int i = this.mIntent.getIntExtra("structmsg_service_id", -1);
    if (i == 63) {
      anot.a(this.app, "CliOper", "", "", "0X8005B34", "0X8005B34", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.dnv();
      return;
      if (i == 84) {
        if (this.mIntent.getIntExtra("pa_type", -1) == 53) {
          anot.a(this.app, "CliOper", "", "", "0X8007018", "0X8007018", 0, 0, "", "", "", "");
        } else {
          anot.a(this.app, "CliOper", "", "", "0X8007169", "0X8007169", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjv
 * JD-Core Version:    0.7.0.1
 */