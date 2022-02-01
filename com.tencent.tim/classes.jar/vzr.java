import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity.29.1;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class vzr
  implements Observer
{
  public vzr(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.this$0.isFinishing()) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof TroopUploadingThread.a));
      paramObservable = (TroopUploadingThread.a)paramObject;
    } while (paramObservable.dWB != 1);
    if (paramObservable.type == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, String.format("update isAvatar=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        this.this$0.a.hasSetNewTroopHead = true;
        if (this.this$0.a.hasSetNewTroopName) {
          this.this$0.a.isNewTroop = false;
        }
        if (this.this$0.a.isUseClassAvatar) {
          this.this$0.a.isUseClassAvatar = false;
        }
        if (this.this$0.b != null)
        {
          this.this$0.b.hasSetNewTroopHead = true;
          this.this$0.b.isNewTroop = this.this$0.a.isNewTroop;
          if (this.this$0.b.isUseClassAvatar()) {
            this.this$0.b.setUseClassAvatar(false);
          }
          this.this$0.bWy();
        }
      }
      if (!this.this$0.isResume()) {
        break;
      }
      this.this$0.runOnUiThread(new TroopInfoActivity.29.1(this, paramObservable));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzr
 * JD-Core Version:    0.7.0.1
 */