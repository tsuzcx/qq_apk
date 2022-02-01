import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.AccountObserver;

class ztg
  extends AccountObserver
{
  ztg(ztd paramztd) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.this$0.rN.size();
    if (paramString1 == null)
    {
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        paramString1 = ztd.a(this.this$0, ((TroopClipPic)this.this$0.rN.get(j)).ts);
        if (paramString1 == null)
        {
          i = j;
        }
        else
        {
          this.this$0.uK.remove(paramString1);
          this.this$0.b(paramString1);
          i = j;
        }
      }
      this.this$0.rN.clear();
      return;
    }
    this.this$0.a(this.this$0.rN, this.this$0.b.troopcode, paramString1, this.this$0.mApp.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztg
 * JD-Core Version:    0.7.0.1
 */