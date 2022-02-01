import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

public class ruo
  implements WXShareHelper.a
{
  public ruo(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.this$0.Qt == null) || (!this.this$0.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    String str1;
    label53:
    String str3;
    int i;
    if (this.this$0.type == 2)
    {
      if (this.this$0.atU != 2) {
        break label159;
      }
      str1 = "qr_wechat";
      str3 = this.this$0.uin;
      i = this.this$0.bvr;
      if (paramBaseResp.errCode != 0) {
        break label165;
      }
    }
    label159:
    label165:
    for (String str2 = "0";; str2 = "1")
    {
      aqfr.b("Grp_share", "grpData_admin", str1, 0, 0, new String[] { str3, String.valueOf(i), str2 });
      switch (paramBaseResp.errCode)
      {
      case -1: 
      default: 
        rwt.ez(1, 2131720152);
        this.this$0.um(false);
        return;
        str1 = "qr_circle";
        break label53;
      }
    }
    rwt.ez(2, 2131720175);
    this.this$0.um(true);
    return;
    this.this$0.um(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ruo
 * JD-Core Version:    0.7.0.1
 */