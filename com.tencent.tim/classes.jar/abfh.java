import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class abfh
  implements DialogInterface.OnClickListener
{
  abfh(abfd paramabfd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (aqiw.isNetSupport(abfd.a(this.this$0)))
    {
      anot.a(this.this$0.mApp, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      abfd.b(this.this$0);
      this.this$0.mApp.a().a().cOg();
      ((FriendListHandler)this.this$0.mApp.getBusinessHandler(1)).cIS();
      return;
    }
    QQToast.a(abfd.a(this.this$0), 2131696284, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfh
 * JD-Core Version:    0.7.0.1
 */