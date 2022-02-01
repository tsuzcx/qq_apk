import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity.1.1;
import com.tencent.mobileqq.activity.AssistantSettingActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import java.util.Locale;
import java.util.Map;

public class uft
  extends accn
{
  public uft(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.this$0.isFinishing())) {
      AssistantSettingActivity.a(this.this$0, this.this$0.j.a(), paramBoolean2);
    }
  }
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if ((paramBoolean) && (AssistantSettingActivity.a(this.this$0) != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a.a(paramArrayOfShort)))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, "onGetCommonSwitchFromDetailInfo");
      }
      AssistantSettingActivity.a(this.this$0).bFV();
    }
  }
  
  protected void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, "onGetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingActivity localAssistantSettingActivity;
    if (paramBoolean)
    {
      localAssistantSettingActivity = this.this$0;
      if (this.this$0.jdField_a_of_type_Zbq.Vf()) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AssistantSettingActivity.b(localAssistantSettingActivity, paramBoolean);
      return;
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.this$0.isFinishing()) {
      AssistantSettingActivity.a(this.this$0, this.this$0.j.a(), paramBoolean2);
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    boolean bool2 = true;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a == null) {}
    for (zbm localzbm = null; localzbm == null; localzbm = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$a.a(paramShort1)) {
      return;
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
    boolean bool1;
    if (paramShort2 == 1)
    {
      bool1 = true;
      label91:
      if ((paramBoolean) || (bool1 != localzbm.bqy)) {
        break label148;
      }
      if (localzbm.bqy) {
        break label150;
      }
    }
    label148:
    label150:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localzbm.bqy = paramBoolean;
      this.this$0.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.post(new AssistantSettingActivity.1.1(this, bool1));
      return;
      bool1 = false;
      break label91;
      break;
    }
  }
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, "onSetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingActivity localAssistantSettingActivity;
    if (!paramBoolean)
    {
      AssistantSettingActivity.a(this.this$0, 2131719890, 1);
      localAssistantSettingActivity = this.this$0;
      if (this.this$0.jdField_a_of_type_Zbq.Vf()) {
        break label95;
      }
    }
    label95:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      AssistantSettingActivity.b(localAssistantSettingActivity, paramBoolean);
      return;
    }
  }
  
  protected void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.this$0.isFinishing()) || (this.this$0.app == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      AssistantSettingActivity.a(this.this$0, 2131719890, 1);
      AssistantSettingActivity.a(this.this$0, yhf.a(this.this$0.app).TC(), AssistantSettingActivity.a(this.this$0));
      return;
    }
    AssistantSettingActivity.a(this.this$0, paramBoolean2, AssistantSettingActivity.a(this.this$0));
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (paramBoolean2) {}
    for (String str = "1";; str = "2")
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X800A223", "0X800A223", 0, 0, str, "", "", "");
      return;
    }
  }
  
  protected void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131702909), 0).show(this.this$0.getTitleBarHeight());
      paramBoolean = ((Boolean)paramObject).booleanValue();
      AssistantSettingActivity.a(this.this$0, true);
      this.this$0.e.setChecked(paramBoolean);
      AssistantSettingActivity.a(this.this$0, paramBoolean);
      AssistantSettingActivity.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uft
 * JD-Core Version:    0.7.0.1
 */