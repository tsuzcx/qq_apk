import android.os.Handler;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.ArrayList;

class ucb
  implements Runnable
{
  ucb(uca paramuca, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((TroopGagMgr)this.jdField_a_of_type_Uca.a.app.getManager(47)).a(this.jdField_a_of_type_Uca.a.a, false);
    this.jdField_a_of_type_AndroidOsHandler.post(new ucc(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucb
 * JD-Core Version:    0.7.0.1
 */