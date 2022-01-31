import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class wtb
  implements View.OnClickListener
{
  public wtb(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void onClick(View paramView)
  {
    if (PhoneContactFragment.a(this.a) == null) {
      PhoneContactFragment.a(this.a, (PhoneContactManagerImp)this.a.a.getManager(10));
    }
    int i = PhoneContactFragment.a(this.a).c();
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.PhoneContactFragment", 2, "onClick phone contact state=" + i);
    }
    if ((!PhoneContactFragment.a(this.a).c()) || ((PhoneContactFragment.a(this.a).c()) || (i == 8)))
    {
      if ((PhoneContactFragment.a(this.a).b() == 1) || (PhoneContactFragment.a(this.a)))
      {
        paramView = new Intent(this.a.getActivity(), GuideBindPhoneActivity.class);
        this.a.getActivity().startActivity(paramView);
      }
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.PhoneContactFragment", 2, "onClick banner state=" + PhoneContactFragment.a(this.a).b());
      }
    }
    do
    {
      do
      {
        return;
        if ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5))
        {
          ContactUtils.a(5);
          paramView = new Intent(this.a.getActivity(), BindNumberActivity.class);
          paramView.putExtra("kSrouce", 12);
          this.a.getActivity().startActivityForResult(paramView, 1000000);
          return;
        }
        if (i != 6) {
          break;
        }
      } while ((PhoneContactFragment.a(this.a).a() == null) || (PhoneContactFragment.a(this.a).a().lastUsedFlag != 3L));
      paramView = new Intent(this.a.getActivity(), PhoneMatchActivity.class);
      paramView.putExtra("key_from_Tab", true);
      this.a.getActivity().startActivity(paramView);
      return;
    } while (i != 7);
    if (!PhoneContactFragment.a(this.a).e())
    {
      paramView = new Intent(this.a.getActivity(), PhoneLaunchActivity.class);
      paramView.putExtra("needAlert", true);
      paramView.putExtra("fromStopAndMatch", true);
      paramView.putExtra("leftViewText", "返回");
      this.a.getActivity().startActivity(paramView);
      return;
    }
    this.a.a.a(new wtc(this));
    QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtb
 * JD-Core Version:    0.7.0.1
 */