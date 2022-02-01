import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ywi
  extends aprz.a
{
  public ywi(NotificationView paramNotificationView) {}
  
  protected void y(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    while (this.this$0.J == null) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
        localStructMsg.mergeFrom(paramBundle);
        NotificationView.a(this.this$0, 1, localStructMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        do
        {
          if (QLog.isColorLevel()) {
            QLog.e("NotificationView", 2, "structMsg merge error");
          }
        } while (this.this$0.J == null);
        this.this$0.J.dismiss();
        QQToast.a(this.this$0.P, this.this$0.P.getString(2131699592), 0).show(this.this$0.getTitleBarHeight());
        return;
      }
    }
    this.this$0.J.dismiss();
    QQToast.a(this.this$0.P, this.this$0.P.getString(2131699592), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywi
 * JD-Core Version:    0.7.0.1
 */