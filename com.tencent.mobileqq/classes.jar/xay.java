import Wallet.WalletSkinRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler.SkinListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.qphone.base.util.QLog;

public class xay
  implements Runnable
{
  public xay(QWalletSkinHandler paramQWalletSkinHandler, WalletSkinRsp paramWalletSkinRsp, QWalletSkinHandler.SkinListener paramSkinListener) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_WalletWalletSkinRsp == null) || (TextUtils.isEmpty(this.jdField_a_of_type_WalletWalletSkinRsp.zipUrl)))
    {
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, false);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletSkinHandler", 2, "setWalletSkin fail:" + this.jdField_a_of_type_WalletWalletSkinRsp);
      }
      return;
    }
    if (this.jdField_a_of_type_WalletWalletSkinRsp.skinID == 0)
    {
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, 0);
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, true);
      return;
    }
    String str1 = QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_WalletWalletSkinRsp.skinID + "", 0);
    String str2 = QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, str1);
    String str3 = QWalletSkinHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, str1);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_WalletWalletSkinRsp.zipUrl)) && (QWalletTools.c(str3, this.jdField_a_of_type_WalletWalletSkinRsp.zipUrl)) && (QWalletTools.c(str2, this.jdField_a_of_type_WalletWalletSkinRsp.zipMd5)) && (QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler).c(this.jdField_a_of_type_WalletWalletSkinRsp.zipUrl) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletSkinHandler", 2, "setWalletSkin res exist" + this.jdField_a_of_type_WalletWalletSkinRsp);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler.a() != this.jdField_a_of_type_WalletWalletSkinRsp.skinID) {
        QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, null);
      }
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_WalletWalletSkinRsp.skinID);
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, true);
      QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "setWalletSkin res not exist" + this.jdField_a_of_type_WalletWalletSkinRsp);
    }
    QWalletTools.a(QWalletSkinHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, str1));
    if (!TextUtils.isEmpty(str3)) {
      QWalletTools.a(QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler).d(str3));
    }
    QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, null);
    QWalletSkinHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler).a(this.jdField_a_of_type_WalletWalletSkinRsp.zipUrl, this.jdField_a_of_type_WalletWalletSkinRsp.zipMd5, new xaz(this, str1), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xay
 * JD-Core Version:    0.7.0.1
 */