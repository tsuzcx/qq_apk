import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class vtp
  implements begw
{
  public vtp(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.f) {
      return;
    }
    this.a.f = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      if (!this.a.jdField_a_of_type_Boolean)
      {
        this.a.e();
        if ((this.a.g & 0x1) != 0)
        {
          awqx.b(this.a.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
          continue;
          if (!this.a.jdField_a_of_type_Boolean)
          {
            this.a.f();
            if ((this.a.g & 0x1) != 0)
            {
              awqx.b(this.a.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
              continue;
              if (!this.a.jdField_a_of_type_Boolean)
              {
                this.a.d();
                if ((this.a.g & 0x1) != 0) {
                  awqx.b(this.a.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
                }
                if (this.a.jdField_c_of_type_Int == 2) {
                  awqx.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_save", 0, 0, this.a.jdField_c_of_type_JavaLangString, "", "", String.valueOf(this.a.jdField_a_of_type_Int));
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     vtp
 * JD-Core Version:    0.7.0.1
 */