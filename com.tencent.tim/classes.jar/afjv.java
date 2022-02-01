import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.a;

public class afjv
  implements aqrg.a<aher>
{
  public afjv(MessengerService.a parama, int paramInt, acle paramacle, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(aher paramaher, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.val$id);
    if ((paramaher != null) || (this.val$id == 0))
    {
      paramObject.putInt("result", 0);
      this.b.dH(this.val$qqApp.getCurrentAccountUin(), this.val$id);
    }
    for (;;)
    {
      this.val$reqbundle.putBundle("response", paramObject);
      this.val$service.cp(this.val$reqbundle);
      return;
      aqri.a(this.val$qqApp, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(this.val$id), null, null, 0.0F, 0.0F);
      aqrh.is("individual_v2_colorscreen_set_fail", "id:" + this.val$id);
      paramObject.putInt("result", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afjv
 * JD-Core Version:    0.7.0.1
 */