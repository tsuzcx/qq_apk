import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecommendContact;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class feo
  implements Runnable
{
  public feo(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteRecommendList ");
    }
    PhoneContactManagerImp.a(this.a).a(RecommendContact.class);
    this.a.a.clear();
    this.a.i();
    ((NewFriendManager)PhoneContactManagerImp.a(this.a).getManager(32)).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     feo
 * JD-Core Version:    0.7.0.1
 */