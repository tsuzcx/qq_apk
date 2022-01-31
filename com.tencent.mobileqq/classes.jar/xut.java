import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class xut
  implements bevy
{
  public xut(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.g == null) || (!this.a.g.equals(paramBaseResp.transaction))) {
      return;
    }
    String str1;
    label53:
    String str3;
    int i;
    if (this.a.jdField_c_of_type_Int == 2)
    {
      if (this.a.h != 2) {
        break label159;
      }
      str1 = "qr_wechat";
      str3 = this.a.jdField_c_of_type_JavaLangString;
      i = this.a.a;
      if (paramBaseResp.errCode != 0) {
        break label165;
      }
    }
    label159:
    label165:
    for (String str2 = "0";; str2 = "1")
    {
      bdaj.a("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, String.valueOf(i), str2 });
      switch (paramBaseResp.errCode)
      {
      case -1: 
      default: 
        xxb.a(1, 2131720019);
        this.a.a(false);
        return;
        str1 = "qr_circle";
        break label53;
      }
    }
    xxb.a(2, 2131720038);
    this.a.a(true);
    return;
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xut
 * JD-Core Version:    0.7.0.1
 */