import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.widget.QQToast;

class uts
  implements DialogInterface.OnClickListener
{
  uts(utq paramutq, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      anot.a(this.val$app, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (aqiw.isNetSupport(this.g)) {
        break;
      }
      QQToast.a(this.g.getApplicationContext(), acfp.m(2131704506), 0).show(this.g.getTitleBarHeight());
      return;
    }
    this.g.addObserver(utq.a(this.b));
    ((acfv)this.val$app.getBusinessHandler(35)).a(this.a, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
    this.b.C = new arhz(this.g, this.g.getTitleBarHeight());
    this.b.C.setContentView(2131562991);
    this.b.C.setMessage(this.g.getString(2131693294));
    this.b.C.setCancelable(true);
    this.b.C.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uts
 * JD-Core Version:    0.7.0.1
 */