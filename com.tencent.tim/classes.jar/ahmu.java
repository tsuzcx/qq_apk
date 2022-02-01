import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.TicketManager;

public class ahmu
  implements View.OnClickListener
{
  public ahmu(DeleteFaceFragment paramDeleteFaceFragment, FragmentActivity paramFragmentActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    if ((DeleteFaceFragment.a(this.a) != null) && (DeleteFaceFragment.a(this.a).isShowing())) {
      DeleteFaceFragment.a(this.a).dismiss();
    }
    if (!aqiw.isNetSupport(this.a.getActivity())) {
      QQToast.a(this.a.getActivity(), this.a.getString(2131693404), 0).show(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DeleteFaceFragment", 2, "user confirm delete");
      }
      if ((this.b == null) || (this.b.app == null))
      {
        QLog.d("DeleteFaceFragment", 1, "delete face, but activity is null or app is null");
      }
      else
      {
        this.a.showLoadingView();
        TicketManager localTicketManager = (TicketManager)this.b.app.getManager(2);
        String str1 = this.b.app.getAccount();
        String str2 = localTicketManager.getSkey(str1);
        if (TextUtils.isEmpty(str2))
        {
          QLog.d("DeleteFaceFragment", 1, "skey is null");
          localTicketManager.GetSkey(str1, 16L, new ahmv(this, str1));
        }
        else
        {
          DeleteFaceFragment.a(this.a, str1, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmu
 * JD-Core Version:    0.7.0.1
 */