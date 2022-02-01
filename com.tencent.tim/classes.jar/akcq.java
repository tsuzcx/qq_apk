import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class akcq
  extends Handler
{
  public akcq(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 101: 
    case 100: 
      do
      {
        do
        {
          return;
          this.this$0.aqz();
          aurh localaurh = aurh.c;
          if ((localaurh != null) && (localaurh.aJB())) {
            localaurh.aaZ(5);
          }
        } while (paramMessage.obj == null);
        paramMessage = (NearbyPeopleCard)paramMessage.obj;
        this.this$0.cru = true;
        this.this$0.a(paramMessage, true, false);
        return;
      } while (NearbyPeopleProfileActivity.a(this.this$0) == null);
      NearbyPeopleProfileActivity.a(this.this$0).dBb();
      return;
    case 102: 
      NearbyPeopleProfileActivity.a(this.this$0).iV(paramMessage.arg1, paramMessage.arg2);
      return;
    case 202: 
      NearbyPeopleProfileActivity.a(this.this$0).ML(true);
      this.this$0.mHandler.sendEmptyMessageDelayed(203, 1500L);
      return;
    case 203: 
      NearbyPeopleProfileActivity.a(this.this$0).ML(false);
      return;
    case 204: 
      this.this$0.dN(this.this$0.getString(2131696226));
      return;
    case 207: 
      this.this$0.dN(acfp.m(2131708791));
      return;
    }
    this.this$0.aqz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcq
 * JD-Core Version:    0.7.0.1
 */