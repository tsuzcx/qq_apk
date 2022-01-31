import Wallet.WalletSkinRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

class xgp
  implements PreloadManager.OnGetPathListener
{
  xgp(xgo paramxgo, String paramString) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletSkinHandler", 2, "setWalletSkin OnGetPathListener:" + paramInt + "|" + paramPathResult);
    }
    if ((paramInt != 0) || (TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      QWalletSkinHandler.a(this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, false);
      return;
    }
    QWalletSkinHandler.a(this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_Xgo.jdField_a_of_type_WalletWalletSkinRsp.skinID);
    QWalletSkinHandler.a(this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xgo.jdField_a_of_type_WalletWalletSkinRsp.zipUrl);
    QWalletSkinHandler.b(this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xgo.jdField_a_of_type_WalletWalletSkinRsp.zipMd5);
    QWalletSkinHandler.a(this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler, this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler$SkinListener, true);
    QWalletSkinHandler.a(this.jdField_a_of_type_Xgo.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletSkinHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgp
 * JD-Core Version:    0.7.0.1
 */