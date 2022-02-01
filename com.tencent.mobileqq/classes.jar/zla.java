import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class zla
  extends ClickableSpan
{
  public zla(QRDisplayActivity paramQRDisplayActivity, TroopInfo paramTroopInfo) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 5, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLat, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLon, 0, "");
    paramView.putString("leftViewText", this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.getString(2131719629));
    paramView.putInt("PARAM_EXIT_ANIMATION", 1);
    paramView.putBoolean(TroopInfoActivity.c, true);
    TroopInfoActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity, paramView);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity.overridePendingTransition(2130771979, 2130771980);
    bhbu.a("Grp_QR", "search_upgrade", "search_upgrade_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin });
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-11692801);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zla
 * JD-Core Version:    0.7.0.1
 */