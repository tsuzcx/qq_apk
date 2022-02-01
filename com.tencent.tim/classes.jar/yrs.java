import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class yrs
  extends acfd
{
  public yrs(AddRequestSuspiciousMsgFragment paramAddRequestSuspiciousMsgFragment) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt + " " + paramLong);
    }
    if ((AddRequestSuspiciousMsgFragment.a(this.a) != null) && (AddRequestSuspiciousMsgFragment.a(this.a).uin == paramLong))
    {
      AddRequestSuspiciousMsgFragment.a(this.a);
      if (paramBoolean)
      {
        QQToast.a(this.a.getActivity(), acfp.m(2131702088), 0).show();
        AddRequestSuspiciousMsgFragment.b(this.a);
        this.a.getActivity().finish();
      }
    }
    else
    {
      return;
    }
    QQToast.a(this.a.getActivity(), acfp.m(2131702089), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrs
 * JD-Core Version:    0.7.0.1
 */