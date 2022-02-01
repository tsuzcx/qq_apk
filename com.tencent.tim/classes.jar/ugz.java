import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class ugz
  extends aklm
{
  public ugz(AuthDevActivity paramAuthDevActivity) {}
  
  public void a(oidb_0x5e1.RspBody paramRspBody)
  {
    super.a(paramRspBody);
    AuthDevActivity.a(this.this$0, paramRspBody);
    int i = ((oidb_0x5e1.UdcUinData)AuthDevActivity.a(this.this$0).rpt_msg_uin_data.get(0)).user_login_guard_face.get();
    FormSimpleItem localFormSimpleItem = AuthDevActivity.a(this.this$0);
    if (i == 1)
    {
      paramRspBody = this.this$0.getString(2131693360);
      localFormSimpleItem.setRightText(paramRspBody);
      if (i != 1) {
        break label111;
      }
    }
    label111:
    for (paramRspBody = "1";; paramRspBody = "0")
    {
      anot.a(null, "dc00898", "", "", "0X800AA7C", "0X800AA7C", 0, 0, paramRspBody, "", "", "");
      return;
      paramRspBody = this.this$0.getString(2131693367);
      break;
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    super.onFailedResponse(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */