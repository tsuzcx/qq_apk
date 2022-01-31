import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.ContactUtils;

public class cgl
  extends ContactBindObserver
{
  public cgl(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.a.d();
    if (!paramBoolean)
    {
      this.a.b(2131363383);
      return;
    }
    if ((paramInt == 0) || (paramInt == 106))
    {
      localObject = ((PhoneContactManager)this.a.app.getManager(10)).a();
      if ((this.a.a == 0) || (localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).mobileNo))) {
        this.a.a(new cgm(this));
      }
      for (;;)
      {
        ContactUtils.a(this.a.app, -1L, -1, 1);
        return;
        this.a.setResult(-1);
        this.a.finish();
      }
    }
    if (paramInt == 213)
    {
      this.a.a("验证码错误，请重新输入。");
      return;
    }
    Object localObject = "请稍后重试。";
    if (paramInt == 107) {
      localObject = "此手机号已与其他帐号绑定，请返回重试。";
    }
    this.a.a("请求失败", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgl
 * JD-Core Version:    0.7.0.1
 */