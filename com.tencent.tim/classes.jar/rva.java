import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class rva
  implements ausj.a
{
  public rva(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.ach) {
      return;
    }
    this.this$0.ach = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.this$0.e.dismiss();
      return;
      if (!this.this$0.isLoading)
      {
        this.this$0.bwC();
        if ((this.this$0.bvw & 0x1) != 0)
        {
          anot.a(this.this$0.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
          continue;
          if (!this.this$0.isLoading)
          {
            this.this$0.bwD();
            if ((this.this$0.bvw & 0x1) != 0)
            {
              anot.a(this.this$0.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
              continue;
              if (!this.this$0.isLoading)
              {
                this.this$0.bwA();
                if ((this.this$0.bvw & 0x1) != 0) {
                  anot.a(this.this$0.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
                }
                if (this.this$0.type == 2) {
                  anot.a(this.this$0.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_save", 0, 0, this.this$0.uin, "", "", String.valueOf(this.this$0.bvr));
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rva
 * JD-Core Version:    0.7.0.1
 */