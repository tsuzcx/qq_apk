import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class wem
  implements DialogInterface.OnClickListener
{
  public wem(TroopTransferActivity paramTroopTransferActivity, String paramString, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (this.this$0.a == null) {
        this.this$0.a = new arib(this.this$0);
      }
      this.this$0.a.aq(2, 2131693404, 1000);
      return;
    }
    paramDialogInterface = (acms)this.this$0.app.getBusinessHandler(20);
    if (paramDialogInterface != null) {}
    try
    {
      long l1 = Long.parseLong(this.this$0.mTroopUin);
      long l2 = Long.parseLong(this.this$0.app.getCurrentAccountUin());
      long l3 = Long.parseLong(this.aRL);
      this.this$0.bbR = true;
      paramDialogInterface.q(l1, l2, l3);
      if (this.this$0.a == null) {
        this.this$0.a = new arib(this.this$0);
      }
      this.this$0.a.aq(0, 2131721271, 1000);
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, paramDialogInterface.toString());
        }
      }
    }
    this.M.cancel();
    anot.a(this.this$0.app, "CliOper", "", "", "Grp", "Transgrp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wem
 * JD-Core Version:    0.7.0.1
 */