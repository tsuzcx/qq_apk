import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class xck
  implements xdh
{
  public xck(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void a(int paramInt) {}
  
  public void a(List<bals> paramList, xce paramxce)
  {
    if (this.a.jdField_a_of_type_Xcc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftPanel", 2, "getPackGiftStorage--onGetPackGift error--mTroopGifPanelData is null");
      }
      return;
    }
    this.a.jdField_a_of_type_Xcc.b(paramList);
    this.a.jdField_a_of_type_Xcc.a(paramxce);
    if ((this.a.jdField_a_of_type_Xcc != null) && (this.a.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.size() > 0) && (this.a.jdField_a_of_type_Xcc.b.size() > 0) && (this.a.jdField_a_of_type_Xcc.jdField_e_of_type_Int != -1))
    {
      this.a.jdField_a_of_type_Xcb = ((xcb)this.a.jdField_a_of_type_Xcc.jdField_e_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Xcc.jdField_e_of_type_Int));
      TroopGiftPanel.a(this.a, this.a.jdField_a_of_type_Xcb);
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
 * Qualified Name:     xck
 * JD-Core Version:    0.7.0.1
 */