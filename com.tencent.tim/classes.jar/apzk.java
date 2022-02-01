import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apzk
  extends ashx
{
  apzk(apzg paramapzg) {}
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null)) {
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    while ((this.this$0.g == null) || (!this.this$0.g.isShowing()) || (this.this$0.atU == -1) || (this.this$0.atV == -1)) {
      return;
    }
    if ((paramBoolean) && (paramHashMap != null))
    {
      String str = (String)paramHashMap.get("uin");
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(str))
      {
        this.this$0.ath();
        return;
      }
      paramHashMap = (String)paramHashMap.get("url");
      this.this$0.bKO = paramHashMap;
      switch (this.this$0.atU)
      {
      default: 
        return;
      case 0: 
        this.this$0.crP = apqw.p("", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.this$0.ath();
        apzg.e(this.this$0);
        return;
      case 3: 
        this.this$0.ath();
        apzg.c(this.this$0);
        return;
      case 2: 
        this.this$0.ath();
        apzg.d(this.this$0);
        return;
      case 1: 
        this.this$0.ath();
        apzg.f(this.this$0);
        return;
      }
      this.this$0.ath();
      apzg.g(this.this$0);
      return;
    }
    if (this.this$0.jdField_a_of_type_Apzg$a != null) {
      this.this$0.jdField_a_of_type_Apzg$a.cc(this.this$0.atU, false);
    }
    this.this$0.ath();
    QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694334), 0).show(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.this$0.atU = -1;
    this.this$0.atV = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzk
 * JD-Core Version:    0.7.0.1
 */