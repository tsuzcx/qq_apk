import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment.a;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abjh
  implements DialogInterface.OnClickListener
{
  public abjh(HotChatCenterFragment paramHotChatCenterFragment, HotChatInfo paramHotChatInfo, String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isWifiHotChat)
    {
      paramInt = 1;
      anot.a(HotChatCenterFragment.a(this.this$0), "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if ((!this.this$0.isAdded()) || (aqiw.isNetSupport(this.this$0.getActivity().getApplicationContext()))) {
        break label98;
      }
      QQToast.a(this.this$0.getActivity().getApplicationContext(), acfp.m(2131707204), 0).show(0);
    }
    label98:
    do
    {
      return;
      paramInt = 2;
      break;
      ((acfv)HotChatCenterFragment.a(this.this$0).getBusinessHandler(35)).a(this.a, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      if (HotChatCenterFragment.a(this.this$0).get() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotchatActivity", 2, "remove");
        }
        ((acfs)HotChatCenterFragment.a(this.this$0).get()).kg(this.val$uin);
      }
    } while (HotChatCenterFragment.a(this.this$0) == null);
    ((HotChatCenterFragment.a)HotChatCenterFragment.a(this.this$0)).d(this.e, this.VQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjh
 * JD-Core Version:    0.7.0.1
 */