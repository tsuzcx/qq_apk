import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.model.PhoneContactManager;

public class ffi
  implements Runnable
{
  public ffi(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (PhoneContactManager)this.a.getManager(10);
    if (localObject != null) {
      ((PhoneContactManager)localObject).a(false);
    }
    localObject = (RecommendTroopManagerImp)this.a.getManager(19);
    if (localObject != null) {
      ((RecommendTroopManagerImp)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffi
 * JD-Core Version:    0.7.0.1
 */