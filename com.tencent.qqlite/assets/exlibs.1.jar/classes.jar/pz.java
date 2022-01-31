import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class pz
  implements ActionSheet.OnButtonClickListener
{
  public pz(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    if (this.a.d) {
      return;
    }
    this.a.d = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      if (!this.a.a)
      {
        this.a.c();
        if ((this.a.k & 0x1) != 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          continue;
          if (!this.a.a)
          {
            this.a.b();
            if ((this.a.k & 0x1) != 0) {
              ReportController.b(this.a.app, "P_CliOper", "", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pz
 * JD-Core Version:    0.7.0.1
 */