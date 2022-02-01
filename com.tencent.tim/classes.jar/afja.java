import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;

public class afja
  extends acfd
{
  public afja(MessengerService paramMessengerService) {}
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    if (this.a.aD != null)
    {
      this.a.aD.putString("cmd", "ipc_signature_setlike");
      paramObject = new Bundle();
      if (!paramBoolean) {
        break label81;
      }
    }
    label81:
    for (int i = 0;; i = 101)
    {
      paramObject.putInt("result", i);
      this.a.aD.putBundle("response", paramObject);
      this.a.cp(this.a.aD);
      this.a.aD = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */