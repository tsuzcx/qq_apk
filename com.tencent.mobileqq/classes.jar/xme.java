import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

public class xme
  implements ConditionSearchManager.IConfigListener
{
  public xme(QWalletIPCModule paramQWalletIPCModule, Bundle paramBundle, int paramInt, ResultReceiver paramResultReceiver, ConditionSearchManager paramConditionSearchManager) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("updateResult", this.jdField_a_of_type_Int);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("isUpdateSuccess", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this);
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("isUpdateSuccess", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xme
 * JD-Core Version:    0.7.0.1
 */