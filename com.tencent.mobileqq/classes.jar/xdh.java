import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.HbSkinInfo;
import cooperation.qwallet.plugin.TenUtils;

class xdh
  implements DialogInterface.OnClickListener
{
  xdh(xdf paramxdf, HbSkinInfo paramHbSkinInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentHbSkinInfo.a.pop_dialog.right_url;
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      TenUtils.startQQBrowser(this.jdField_a_of_type_Xdf.a.getActivity(), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdh
 * JD-Core Version:    0.7.0.1
 */