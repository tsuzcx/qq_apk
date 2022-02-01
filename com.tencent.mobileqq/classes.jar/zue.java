import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

class zue
  implements TextView.OnEditorActionListener
{
  zue(zuc paramzuc, TroopGiftPanel paramTroopGiftPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Zuc.c();
      paramTextView = this.jdField_a_of_type_Zuc.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(paramTextView))
      {
        this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(paramTextView);
        this.jdField_a_of_type_Zuc.b();
        if (!nmy.a().a(this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {
          break label194;
        }
      }
      label194:
      for (paramInt = 2;; paramInt = 1)
      {
        bcef.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", paramInt, 0, this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + muk.a((AppInterface)this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).getCurrentAccountUin(), this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
        return true;
        this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a("1");
        break;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zue
 * JD-Core Version:    0.7.0.1
 */