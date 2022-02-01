import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class apzj
  extends acnd
{
  apzj(apzg paramapzg) {}
  
  public void a(boolean paramBoolean, apzf paramapzf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (paramapzf == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramapzf.troopUin))) {
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    label423:
    label604:
    for (;;)
    {
      return;
      if ((this.this$0.g != null) && (this.this$0.g.isShowing()) && (this.this$0.atU != -1) && (this.this$0.atV != -1))
      {
        if ((!paramBoolean) || (paramapzf.errCode != 0)) {
          break label423;
        }
        if (paramapzf.isVerify)
        {
          this.this$0.bKO = paramapzf.shareUrl;
          if (this.this$0.atV != 0)
          {
            if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
              continue;
            }
            ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          }
        }
        else
        {
          this.this$0.bKP = paramapzf.shareUrl;
          if (this.this$0.atV != 1)
          {
            if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
              continue;
            }
            ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
            return;
          }
        }
        switch (this.this$0.atU)
        {
        }
      }
      for (;;)
      {
        if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          break label604;
        }
        ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        return;
        this.this$0.ath();
        apzg.c(this.this$0);
        continue;
        this.this$0.ath();
        apzg.d(this.this$0);
        continue;
        this.this$0.crP = apqw.p("", this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.this$0.ath();
        apzg.e(this.this$0);
        continue;
        this.this$0.ath();
        apzg.f(this.this$0);
        continue;
        this.this$0.ath();
        apzg.g(this.this$0);
        continue;
        if ((paramapzf.isVerify) && (this.this$0.atV != 0))
        {
          if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if ((!paramapzf.isVerify) && (this.this$0.atV != 1))
        {
          if (!(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzj
 * JD-Core Version:    0.7.0.1
 */