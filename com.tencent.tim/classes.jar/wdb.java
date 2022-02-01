import android.os.Bundle;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class wdb
  extends aprz.a
{
  public wdb(TroopRequestActivity paramTroopRequestActivity) {}
  
  protected void y(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        new structmsg.StructMsg().mergeFrom(paramBundle);
        TroopRequestActivity.a(this.this$0, 1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.TroopRequestActivity", 2, "structMsg merge error");
        }
        this.this$0.ath();
        QQToast.a(this.this$0, this.this$0.getString(2131699592), 0).show(this.this$0.getTitleBarHeight());
        return;
      }
    }
    this.this$0.ath();
    QQToast.a(this.this$0, this.this$0.getString(2131699592), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdb
 * JD-Core Version:    0.7.0.1
 */