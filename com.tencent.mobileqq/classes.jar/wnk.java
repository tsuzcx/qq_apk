import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class wnk
  implements woh
{
  public wnk(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<azkb> paramList, wne paramwne)
  {
    if (this.a.jdField_a_of_type_Wnc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.jdField_a_of_type_Wnc.b(paramList);
    this.a.jdField_a_of_type_Wnc.a(paramwne);
    if ((this.a.jdField_a_of_type_Wnc != null) && (this.a.jdField_a_of_type_Wnc.jdField_e_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_Wnc.jdField_e_of_type_JavaUtilArrayList.size() > 0) && (this.a.jdField_a_of_type_Wnc.b.size() > 0) && (this.a.jdField_a_of_type_Wnc.jdField_e_of_type_Int != -1))
    {
      this.a.jdField_a_of_type_Wnb = ((wnb)this.a.jdField_a_of_type_Wnc.jdField_e_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Wnc.jdField_e_of_type_Int));
      TroopGiftPanel.a(this.a, this.a.jdField_a_of_type_Wnb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wnk
 * JD-Core Version:    0.7.0.1
 */