import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class vgq
  extends aklm
{
  public vgq(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void a(oidb_0x5e1.RspBody paramRspBody)
  {
    LoginInfoActivity.a(this.this$0, paramRspBody);
    int i = ((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get();
    TextView localTextView = LoginInfoActivity.c(this.this$0);
    if (i == 1)
    {
      paramRspBody = this.this$0.getString(2131693360);
      localTextView.setText(paramRspBody);
      LoginInfoActivity.a(this.this$0).setVisibility(4);
      LoginInfoActivity.c(this.this$0).setVisibility(0);
      if (i != 1) {
        break label122;
      }
    }
    label122:
    for (paramRspBody = "1";; paramRspBody = "0")
    {
      anot.a(null, "dc00898", "", "", "0X800AA7A", "0X800AA7A", 0, 0, paramRspBody, "", "", "");
      return;
      paramRspBody = this.this$0.getString(2131693367);
      break;
    }
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.this$0, paramString2, 0).show();
    QLog.e("LoginInfoActivity.AccDevSec", 1, "cmd : " + paramString1 + " request failed  code : " + paramInt + " message : " + paramString2);
    LoginInfoActivity.a(this.this$0).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgq
 * JD-Core Version:    0.7.0.1
 */