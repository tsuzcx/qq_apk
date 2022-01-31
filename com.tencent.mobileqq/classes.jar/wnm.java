import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class wnm
  extends azjp
{
  public wnm(TroopGiftPanel paramTroopGiftPanel, wnb paramwnb) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
    {
      ajnb.a("gift_store", "fail_all", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
      return;
    }
    awqx.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_fail", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Wnb.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mje.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult productId = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
    {
      ajnb.a("gift_store", "suc_all", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
      return;
    }
    awqx.b(null, "dc00899", "Grp_flower", "", "aio_mall", "send_forall_suc", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "" + this.jdField_a_of_type_Wnb.e, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + mje.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wnm
 * JD-Core Version:    0.7.0.1
 */