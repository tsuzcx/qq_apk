import android.content.Context;
import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import java.util.concurrent.CountDownLatch;

public class get
  implements MagicfaceDecoder.MagicPlayListener
{
  public get(Action paramAction) {}
  
  public void a()
  {
    if (Action.a(this.a) == 0)
    {
      Action.a(this.a);
      if ((Action.a(this.a).c != null) && (Action.a(this.a).c.length() > 0) && (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.c))
      {
        if (Action.a(this.a).e > 0)
        {
          MagicfacePlayRes localMagicfacePlayRes = Action.a(this.a);
          localMagicfacePlayRes.e -= 1;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a).c, Action.a(this.a).e);
      }
      if (Action.a(this.a).a)
      {
        Action.a(this.a, (Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (Action.a(this.a).h != -1) {
          break label199;
        }
        Action.a(this.a).vibrate(new long[] { 0L, 1000L }, 0);
      }
    }
    for (;;)
    {
      Action.b(this.a);
      return;
      label199:
      Action.a(this.a).vibrate(Action.a(this.a).h * 1000);
    }
  }
  
  public void b()
  {
    if (Action.a(this.a)) {
      Action.a(this.a).countDown();
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Int == -1)
      {
        if (this.a.jdField_b_of_type_Int == -1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a));
          return;
        }
        if (this.a.jdField_b_of_type_Int < Action.a(this.a))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a));
          return;
        }
        if (this.a.jdField_b_of_type_Int == Action.a(this.a))
        {
          Action.a(this.a).countDown();
          return;
        }
      }
    } while (this.a.jdField_b_of_type_Boolean);
    this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     get
 * JD-Core Version:    0.7.0.1
 */