import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class cex
  implements DialogInterface.OnDismissListener
{
  public cex(MainAssistObserver paramMainAssistObserver, QQAppInterface paramQQAppInterface) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a.finish();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cex
 * JD-Core Version:    0.7.0.1
 */