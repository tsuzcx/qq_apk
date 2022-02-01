import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenAuthorityFragment.12.1;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class arrh
  extends artd
{
  public arrh(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, arte paramarte)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    ahlw.a("KEY_AUTHORIZE_REQUEST", OpenAuthorityFragment.a(this.this$0), paramBoolean);
    Object localObject;
    if ((paramBoolean) && (paramarte != null))
    {
      localObject = this.this$0.b.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramarte;
      this.this$0.b.sendMessage((Message)localObject);
      return;
    }
    if (paramInt == 110509)
    {
      if (OpenAuthorityFragment.e(this.this$0) >= 2)
      {
        OpenAuthorityFragment.a(this.this$0, acfp.m(2131709374), false);
        paramarte = OpenAuthorityFragment.a(this.this$0).a().a(OpenAuthorityFragment.a(this.this$0));
        localObject = this.this$0;
        if (paramarte == null) {}
        for (paramarte = null;; paramarte = paramarte.uin)
        {
          ((OpenAuthorityFragment)localObject).WO(paramarte);
          return;
        }
      }
      OpenAuthorityFragment.f(this.this$0);
      OpenAuthorityFragment.a(this.this$0, 1);
      return;
    }
    if (paramInt == 110537)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onDoAuthorize 110537");
      artw.f(this.this$0.getActivity(), acfp.m(2131709376), false);
      this.this$0.WO(OpenAuthorityFragment.b(this.this$0));
      return;
    }
    if ((paramarte != null) && (!TextUtils.isEmpty(paramarte.msg.get())))
    {
      OpenAuthorityFragment.a(this.this$0, paramarte.msg.get() + acfp.m(2131709369) + paramInt, false);
      return;
    }
    OpenAuthorityFragment.a(this.this$0, acfp.m(2131709371) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(paramBoolean) });
    if (OpenAuthorityFragment.a(this.this$0))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    ahlw.a("KEY_GET_VIRTUAL_LIST_D24", OpenAuthorityFragment.a(this.this$0), paramBoolean);
    this.this$0.getActivity().runOnUiThread(new OpenAuthorityFragment.12.1(this, paramBoolean, paramGetVirtualListResult));
  }
  
  public void bO(boolean paramBoolean, int paramInt)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (paramBoolean) {
      return;
    }
    this.this$0.elm();
    if (paramInt == 151)
    {
      OpenAuthorityFragment.a(this.this$0, acfp.m(2131709373), false);
      this.this$0.WO(OpenAuthorityFragment.b(this.this$0));
      return;
    }
    OpenAuthorityFragment.a(this.this$0, acfp.m(2131709375) + paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrh
 * JD-Core Version:    0.7.0.1
 */