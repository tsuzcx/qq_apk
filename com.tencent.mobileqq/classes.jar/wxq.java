import Wallet.WalletSkinRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler.SkinListener;
import mqq.observer.BusinessObserver;

public class wxq
  implements BusinessObserver
{
  public wxq(QWalletSkinHandler paramQWalletSkinHandler, QWalletSkinHandler.SkinListener paramSkinListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (WalletSkinRsp)paramBundle.getSerializable("rsp");
    if ((paramBoolean) && (paramBundle != null) && (paramBundle.status == 0))
    {
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, 0);
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, true);
      return;
    }
    QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxq
 * JD-Core Version:    0.7.0.1
 */