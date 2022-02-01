import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.observer.AccountObserver;

class ztb
  extends AccountObserver
{
  ztb(zta paramzta) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      zta.b(this.this$0, null);
      zta.a(this.this$0, null);
      this.this$0.notifyDataSetChanged();
      return;
    }
    this.this$0.a(zta.a(this.this$0), this.this$0.b.troopcode, paramString1, this.this$0.mApp.getCurrentAccountUin());
    zta.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztb
 * JD-Core Version:    0.7.0.1
 */