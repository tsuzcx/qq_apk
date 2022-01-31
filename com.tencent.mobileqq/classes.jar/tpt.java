import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;

class tpt
  implements Runnable
{
  tpt(tps paramtps) {}
  
  public void run()
  {
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      int j;
      try
      {
        localObject = new SpannableStringBuilder();
        localResources = this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
        if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
          break label503;
        }
        bool1 = true;
        if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
          break label508;
        }
        bool2 = true;
        j = this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
        if (!QLog.isColorLevel()) {
          break label488;
        }
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + j + ",QQLevel=" + this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Resources localResources;
        localThrowable.printStackTrace();
        return;
      }
      int i = Math.max(j, 1);
      ((SpannableStringBuilder)localObject).append(QQSettingUtil.a(this.a.a.b, localResources, bool1, bool2, i));
      if (VipGrayConfigHelper.a().a(bool1, this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
        ((SpannableStringBuilder)localObject).append(QQSettingUtil.a(this.a.a.b, localResources, this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
      }
      ((SpannableStringBuilder)localObject).append(QQSettingUtil.a(localResources, this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel));
      this.a.a.b.setText((CharSequence)localObject);
      this.a.a.b.setContentDescription("等级：" + this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
      this.a.a.a(bool1, bool2, i);
      if (AppSetting.b)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(QQSettingMe.a(this.a.a));
        if (bool1)
        {
          ((StringBuilder)localObject).append("你是尊贵的超级会员");
          if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
            ((StringBuilder)localObject).append(" 等级").append(this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
          }
          this.a.a.jdField_a_of_type_AndroidViewView.setContentDescription(((StringBuilder)localObject).toString());
          return;
        }
        if (bool2)
        {
          ((StringBuilder)localObject).append("你是尊贵的会员");
          continue;
          label488:
          if (!bool1)
          {
            i = j;
            if (!bool2) {}
          }
        }
      }
      else
      {
        return;
        label503:
        bool1 = false;
        continue;
        label508:
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpt
 * JD-Core Version:    0.7.0.1
 */