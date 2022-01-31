import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class yrd
  implements ysa
{
  public yrd(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<bckf> paramList, yqx paramyqx)
  {
    if (this.a.jdField_a_of_type_Yqv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.jdField_a_of_type_Yqv.b(paramList);
    this.a.jdField_a_of_type_Yqv.a(paramyqx);
    if ((this.a.jdField_a_of_type_Yqv != null) && (this.a.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.size() > 0) && (this.a.jdField_a_of_type_Yqv.b.size() > 0) && (this.a.jdField_a_of_type_Yqv.jdField_e_of_type_Int != -1))
    {
      this.a.jdField_a_of_type_Yqu = ((yqu)this.a.jdField_a_of_type_Yqv.jdField_e_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Yqv.jdField_e_of_type_Int));
      TroopGiftPanel.a(this.a, this.a.jdField_a_of_type_Yqu);
    }
    if (this.a.d())
    {
      paramList = this.a;
      if ((!TextUtils.isEmpty(this.a.f)) && (TroopGiftPanel.a(this.a))) {}
      for (boolean bool = true;; bool = false)
      {
        paramList.setSendGiftBtnEnabled(bool);
        return;
      }
    }
    this.a.setSendGiftBtnEnabled(TroopGiftPanel.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yrd
 * JD-Core Version:    0.7.0.1
 */