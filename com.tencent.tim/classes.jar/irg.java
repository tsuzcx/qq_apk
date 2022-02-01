import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.2.1;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class irg
  implements jkb.a
{
  public irg(RandomController paramRandomController) {}
  
  public void a(String paramString, jkb.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "onGetNearbyPeopleProfile uin :" + paramString + ", nickname:" + paramb.nickname + ", gender:" + paramb.gender);
    }
    if (paramString.equals(RandomController.a(this.this$0).getAccount()))
    {
      if (paramb.gender != -1) {
        RandomController.a(this.this$0).lv(paramb.gender);
      }
      if (RandomController.a(this.this$0).vk())
      {
        if (!RandomController.a(this.this$0)) {
          break label209;
        }
        RandomController.b(this.this$0, false);
        RandomController.a(this.this$0).set(0);
        RandomController.a(this.this$0).a(RandomController.b(this.this$0), RandomController.c(this.this$0), 1, new String[0]);
        RandomController.a(this.this$0).getHandler().removeCallbacks(RandomController.b(this.this$0));
      }
    }
    for (;;)
    {
      RandomController.a(this.this$0).getHandler().post(new RandomController.2.1(this));
      return;
      label209:
      if (RandomController.b(this.this$0))
      {
        RandomController.c(this.this$0, false);
        RandomController.a(this.this$0).s(this.this$0.Ur, RandomController.b(this.this$0));
        RandomController.a(this.this$0).getHandler().removeCallbacks(RandomController.b(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irg
 * JD-Core Version:    0.7.0.1
 */