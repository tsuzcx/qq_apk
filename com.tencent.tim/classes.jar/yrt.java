import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;

public class yrt
  implements ausj.a
{
  public yrt(AddRequestSuspiciousMsgFragment paramAddRequestSuspiciousMsgFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$sheet.dismiss();
      return;
      if (aqiw.isNetSupport(this.a.getActivity())) {
        stj.a(this.a.getActivity(), AddRequestSuspiciousMsgFragment.a(this.a).uin + "", null, AddRequestSuspiciousMsgFragment.a(this.a).getCurrentAccountUin(), 20010, null);
      } else {
        QQToast.a(this.a.getActivity(), 2131696272, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrt
 * JD-Core Version:    0.7.0.1
 */