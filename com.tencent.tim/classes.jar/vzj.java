import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class vzj
  extends Handler
{
  public vzj(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.this$0.init();
    }
    do
    {
      return;
      if (paramMessage.what == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_OWNER_NAME");
        }
        this.this$0.i(2, this.this$0.a.getTroopOwnerName(), this.this$0.a.isFetchedTroopOwnerUin());
        return;
      }
      if (paramMessage.what == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_INFO");
        }
        if ((this.this$0.a.dwGroupFlagExt & 0x800) != 0L) {
          this.this$0.i(7, this.this$0.a.troopAuthenticateInfo, false);
        }
        this.this$0.i(2, this.this$0.a.troopOwnerNick, this.this$0.a.isFetchedTroopOwnerUin());
        if ((this.this$0.a.troopOwnerNick == null) && (!TextUtils.isEmpty(this.this$0.a.troopowneruin))) {
          TroopInfoActivity.c(this.this$0);
        }
        this.this$0.bLn();
        if (!TextUtils.isEmpty(this.this$0.a.mRichFingerMemo)) {}
        for (paramMessage = this.this$0.a.mRichFingerMemo;; paramMessage = this.this$0.getResources().getString(2131698395))
        {
          this.this$0.i(6, paramMessage, this.this$0.a.isOwnerOrAdim());
          if (this.this$0.a.troopClass != null) {
            break;
          }
          TroopInfoActivity.d(this.this$0);
          return;
        }
      }
      if (paramMessage.what == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_CLASS");
        }
        this.this$0.i(4, this.this$0.a.troopClass, this.this$0.a.isOwnerOrAdim());
        return;
      }
      if (paramMessage.what == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_TAGS");
        }
        paramMessage = TroopInfoActivity.a(this.this$0, this.this$0.a);
        this.this$0.a(8, paramMessage, true, 2, true);
        return;
      }
      if (paramMessage.what == 7)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "MSG_UPDATE_TROOP_INTEREST");
        }
        paramMessage = new ArrayList();
        if (!TextUtils.isEmpty(this.this$0.a.tribeName)) {
          paramMessage.add(this.this$0.a.tribeName);
        }
        this.this$0.a(9, paramMessage, true, 1, true);
        TroopInfoActivity.e(this.this$0);
        return;
      }
    } while (paramMessage.what != 8);
    TroopInfoActivity.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzj
 * JD-Core Version:    0.7.0.1
 */