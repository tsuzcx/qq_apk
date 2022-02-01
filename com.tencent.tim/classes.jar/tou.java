import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.SubAccountObserver;

class tou
  extends SubAccountObserver
{
  tou(tos paramtos, anxr paramanxr) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.this$0.app == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.this$0.app.getAccount())) {
      return;
    }
    this.a.R(paramString2, paramString3, true);
    anxk.a(this.this$0.app, (byte)1, paramString2);
    anxk.d(this.this$0.app, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tou
 * JD-Core Version:    0.7.0.1
 */