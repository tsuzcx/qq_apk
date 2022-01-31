import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class yre
  extends bcjt
{
  public yre(TroopGiftPanel paramTroopGiftPanel, int paramInt, yqu paramyqu) {}
  
  public void a(int paramInt)
  {
    azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_suc", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Yqu.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mwu.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext, alpo.a(2131715809), 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131298914));
    azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Yqu.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mwu.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    Context localContext = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = alpo.a(2131715794);
    }
    QQToast.a(localContext, str, 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131298914));
    azmj.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Yqu.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mwu.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yre
 * JD-Core Version:    0.7.0.1
 */