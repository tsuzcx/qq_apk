import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bna
  implements View.OnClickListener
{
  public bna(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    default: 
      return;
    case 10: 
      this.a.j();
      return;
    }
    paramView = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f)) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k)) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m)) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long == -1L) || (TextUtils.isEmpty(paramView)))
    {
      this.a.e();
      return;
    }
    if (((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r == 2) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r == 3)) && (this.a.jdField_a_of_type_Long != -1L) && (this.a.jdField_a_of_type_Long <= this.a.b))
    {
      paramView = DialogUtil.a(this.a, 230);
      paramView.setTitle(null);
      paramView.setMessage(this.a.getString(2131362654));
      paramView.setPositiveButton(this.a.getString(2131362655), new bnb(this, paramView));
      paramView.setPositiveButtonContentDescription(this.a.getString(2131362655));
      paramView.show();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bna
 * JD-Core Version:    0.7.0.1
 */