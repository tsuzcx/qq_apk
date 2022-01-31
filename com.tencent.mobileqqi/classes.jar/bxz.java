import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class bxz
  extends AccountObserver
{
  public bxz(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onDeleteAccount isSuccess " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxz
 * JD-Core Version:    0.7.0.1
 */