import android.content.Intent;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare.2;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

public class aobf
  implements WXShareHelper.a
{
  public aobf(TeamWorkForceShare.2.1 param1) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((TeamWorkForceShare.b(this.a.a.this$0) == null) || (!TeamWorkForceShare.b(this.a.a.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d(TeamWorkForceShare.access$100(), 1, "wx rsp = " + paramBaseResp.errCode);
    if (this.a.a.cLb) {}
    for (byte b = 86;; b = 120)
    {
      TeamWorkForceShare.a(this.a.a.this$0).onActivityResult(new Intent(), b, paramBaseResp.errCode);
      WXShareHelper.a().b(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobf
 * JD-Core Version:    0.7.0.1
 */