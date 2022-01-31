import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.SubAccountObserver;

public class dli
  implements View.OnClickListener
{
  public dli(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.findViewById(2131231002);
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    do
    {
      return;
      if (SubAccountAssistantManager.a().a(this.a.b))
      {
        this.a.a(this.a.getString(2131563287));
        return;
      }
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = (SimpleAccount)SubAccountBindActivity.a(this.a).get(i);
      if (!paramView.isLogined())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onSelectAccountClick.onClick:add account");
        }
        localObject = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject).putExtra("subuin", paramView.getUin());
        this.a.startActivity((Intent)localObject);
        return;
      }
    } while (!this.a.f());
    localObject = SubAccountAssistantManager.a();
    String str = ((SubAccountAssistantManager)localObject).a();
    this.a.d();
    if (TextUtils.isEmpty(str))
    {
      localObject = new dlj(this, paramView, (SubAccountAssistantManager)localObject);
      this.a.getAppRuntime().getSubAccountKey(this.a.b.getAccount(), paramView.getUin(), (SubAccountObserver)localObject);
      return;
    }
    ((SubAccountAssistantManager)localObject).a(this.a.b, paramView.getUin(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dli
 * JD-Core Version:    0.7.0.1
 */