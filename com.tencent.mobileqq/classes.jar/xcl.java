import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class xcl
  extends balg
{
  public xcl(TroopGiftPanel paramTroopGiftPanel, int paramInt, xcb paramxcb) {}
  
  public void a(int paramInt)
  {
    axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_suc", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Xcb.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mua.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    bcql.a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext, ajya.a(2131715437), 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131298865));
    axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Xcb.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mua.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    Context localContext = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_AndroidContentContext;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ajya.a(2131715422);
    }
    bcql.a(localContext, str, 0).b(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getResources().getDimensionPixelSize(2131298865));
    axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forone_fail", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Xcb.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mua.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xcl
 * JD-Core Version:    0.7.0.1
 */