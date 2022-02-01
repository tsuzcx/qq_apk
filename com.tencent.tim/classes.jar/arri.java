import android.os.Bundle;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class arri
  implements asbh.a
{
  public arri(OpenAuthorityFragment paramOpenAuthorityFragment, int paramInt) {}
  
  public void J(String paramString, Bundle paramBundle)
  {
    QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket onFail triggerReason=", Integer.valueOf(this.ekP) });
    if (OpenAuthorityFragment.i(this.this$0))
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket onFail Activity Finishing");
      return;
    }
    OpenAuthorityFragment.a(this.this$0, acfp.m(2131709374), false);
    this.this$0.WO(paramString);
  }
  
  public void a(asav paramasav)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "refreshTicket success info.uin=" + artw.qx(paramasav.uin), ", triggerReason=", Integer.valueOf(this.ekP) });
    if (OpenAuthorityFragment.i(this.this$0)) {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "refreshTicket success Activity Finishing");
    }
    do
    {
      return;
      OpenAuthorityFragment.a(this.this$0).a().b(OpenAuthorityFragment.a(this.this$0), paramasav);
      if (this.ekP == 1)
      {
        long l = OpenAuthorityFragment.a(this.this$0).ia();
        paramasav = OpenAuthorityFragment.a(this.this$0);
        OpenAuthorityFragment.e(this.this$0, System.currentTimeMillis());
        OpenAuthorityFragment.a(this.this$0).a(OpenAuthorityFragment.f(this.this$0), OpenAuthorityFragment.f(this.this$0), OpenAuthorityFragment.c(this.this$0), paramasav, l, this.this$0.b, artw.i(this.this$0.getActivity()), this.this$0.getActivity());
        return;
      }
      if (this.ekP == 2)
      {
        this.this$0.eln();
        return;
      }
    } while (this.ekP != 3);
    OpenAuthorityFragment.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arri
 * JD-Core Version:    0.7.0.1
 */