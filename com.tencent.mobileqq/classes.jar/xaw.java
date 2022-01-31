import Wallet.WalletSkinRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler.SkinListener;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class xaw
  implements BusinessObserver
{
  public xaw(QWalletSkinHandler paramQWalletSkinHandler, QWalletSkinHandler.SkinListener paramSkinListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (WalletSkinRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "OpenWalletSkin openObserver:" + paramBoolean + "|" + paramBundle);
    }
    if ((paramBoolean) && (paramBundle != null) && (paramBundle.status == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "OpenWalletSkin rsp fail:" + paramBundle);
    }
    QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xaw
 * JD-Core Version:    0.7.0.1
 */