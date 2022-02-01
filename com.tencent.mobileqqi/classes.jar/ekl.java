import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.ContactUtils;

public class ekl
  extends ContactBindObserver
{
  public ekl(BindVerifyActivity paramBindVerifyActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.a.d();
    if (!paramBoolean)
    {
      this.a.b(2131562782);
      return;
    }
    if ((paramInt == 0) || (paramInt == 106))
    {
      localObject = ((PhoneContactManager)this.a.b.getManager(10)).a();
      if (1 == this.a.a) {
        MyBusinessActivity.c(true);
      }
      if ((this.a.a == 0) || (localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).mobileNo)))
      {
        this.a.b.a(new ekm(this));
        this.a.setResult(-1);
        this.a.finish();
      }
      for (;;)
      {
        ContactUtils.a(this.a.b, -1L, -1, 1);
        return;
        this.a.setResult(-1);
        this.a.finish();
      }
    }
    if (paramInt == 213)
    {
      this.a.b(this.a.getString(2131558962));
      return;
    }
    Object localObject = this.a.getString(2131558963);
    if (paramInt == 107) {
      localObject = this.a.getString(2131558964);
    }
    this.a.a(this.a.getString(2131558965), (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ekl
 * JD-Core Version:    0.7.0.1
 */