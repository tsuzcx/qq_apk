import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ztl
  implements zui
{
  public ztl(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<bfct> paramList, ztd paramztd)
  {
    if (this.a.jdField_a_of_type_Zsz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.jdField_a_of_type_Zsz.b(paramList);
    this.a.jdField_a_of_type_Zsz.a(paramztd);
    if ((this.a.jdField_a_of_type_Zsz != null) && (this.a.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.size() > 0) && (this.a.jdField_a_of_type_Zsz.b.size() > 0) && (this.a.jdField_a_of_type_Zsz.jdField_e_of_type_Int != -1))
    {
      this.a.jdField_a_of_type_Zsy = ((zsy)this.a.jdField_a_of_type_Zsz.jdField_e_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Zsz.jdField_e_of_type_Int));
      TroopGiftPanel.a(this.a, this.a.jdField_a_of_type_Zsy);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztl
 * JD-Core Version:    0.7.0.1
 */