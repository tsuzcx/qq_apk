import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.5.1;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class apqb
  implements Observer
{
  apqb(appx paramappx) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((appx.a(this.this$0) == null) || (appx.a(this.this$0) == null)) {}
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
      paramObservable = appx.a(this.this$0);
      appx.a(this.this$0).Tx(appx.a(this.this$0).troopUin);
      if (bool)
      {
        appx.a(this.this$0).hasSetNewTroopHead = true;
        if (appx.a(this.this$0).hasSetNewTroopName) {
          appx.a(this.this$0).isNewTroop = false;
        }
        if (appx.a(this.this$0).isUseClassAvatar) {
          appx.a(this.this$0).isUseClassAvatar = false;
        }
        if ((paramObservable != null) && (paramObservable.b != null))
        {
          paramObservable.b.hasSetNewTroopHead = true;
          paramObservable.b.isNewTroop = appx.a(this.this$0).isNewTroop;
          if (paramObservable.b.isUseClassAvatar()) {
            paramObservable.b.setUseClassAvatar(false);
          }
          this.this$0.bWy();
        }
      }
      if (!appx.a(this.this$0).isResume()) {
        break;
      }
      appx.a(this.this$0).runOnUiThread(new VisitorTroopCardPresenter.5.1(this, bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqb
 * JD-Core Version:    0.7.0.1
 */