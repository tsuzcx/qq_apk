import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class vkv
  extends accn
{
  public vkv(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.this$0.app.getCurrentAccountUin())))
    {
      if (paramBoolean1) {
        PermisionPrivacyActivity.a(this.this$0, this.this$0.ao.a(), paramBoolean2);
      }
      return;
    }
    QLog.e("Q.security", 2, "onGetAllowSeeLoginDays isSuccess " + paramBoolean1 + "isAllow:" + paramBoolean2 + "uin empty!");
  }
  
  protected void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.this$0.isFinishing()) || (this.this$0.app == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      this.this$0.cf(2131719890, 1);
      Card localCard = ((acff)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
      PermisionPrivacyActivity.a(this.this$0, this.this$0.ap.a(), localCard.strangerInviteMeGroupOpen);
      return;
    }
    PermisionPrivacyActivity.a(this.this$0, this.this$0.ap.a(), paramBoolean2);
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.this$0.isFinishing()))
    {
      if (paramBoolean2) {
        break label106;
      }
      this.this$0.P.setRightText(acfp.m(2131701654));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Card localCard = ((acff)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
        QLog.d("interactive", 2, "PermisionPrivacyActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + localCard.allowCalInteractive);
      }
      return;
      label106:
      this.this$0.P.setRightText(acfp.m(2131701656));
    }
  }
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.this$0.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.this$0, this.this$0.al.a(), paramBoolean2);
    PermisionPrivacyActivity.a(this.this$0, PermisionPrivacyActivity.a(this.this$0), paramBoolean3);
  }
  
  protected void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PermisionPrivacyActivity.a(this.this$0, paramBoolean);
        this.this$0.au.setChecked(paramBoolean);
        QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag " + paramBoolean);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag ex:" + paramObject);
        return;
      }
      paramBoolean = false;
    }
  }
  
  protected void onGetTroopHonorSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.this$0.isFinishing()))
    {
      if (paramBoolean2) {
        this.this$0.Q.setRightText(acfp.m(2131701654));
      }
    }
    else {
      return;
    }
    this.this$0.Q.setRightText(acfp.m(2131701656));
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean)
  {
    Card localCard = ((acff)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
    PermisionPrivacyActivity.a(this.this$0, this.this$0.ao.a(), localCard.allowPeopleSee);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (!this.this$0.isFinishing()))
    {
      Card localCard = ((acff)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
      if (localCard.allowCalInteractive) {
        break label108;
      }
      this.this$0.P.setRightText(acfp.m(2131701654));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("PermisionPrivacyActivity onSetCalReactiveDays isAllow= ");
        if (localCard.allowCalInteractive) {
          break label126;
        }
      }
    }
    label108:
    label126:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("interactive", 2, paramBoolean);
      return;
      this.this$0.P.setRightText(acfp.m(2131701656));
      break;
    }
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.this$0.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.this$0.cf(2131719890, 1);
    }
    if (paramBoolean2)
    {
      PermisionPrivacyActivity.a(this.this$0, this.this$0.al.a(), paramBoolean3);
      return;
    }
    PermisionPrivacyActivity.a(this.this$0, PermisionPrivacyActivity.a(this.this$0), paramBoolean3);
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    if (!paramBoolean)
    {
      QQToast.a(this.this$0.app.getApp(), 1, this.this$0.getString(2131719890), 3000).show(this.this$0.getTitleBarHeight());
      localObject1 = this.this$0;
      localObject2 = this.this$0.at.a();
      paramBoolean = bool;
      if (!this.this$0.at.a().isChecked()) {
        paramBoolean = true;
      }
      PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "PermisionPrivacyActivity onSetMedal failed");
      }
      return;
    }
    Object localObject1 = ((acff)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
    if (!this.this$0.isFinishing())
    {
      localObject2 = this.this$0;
      Switch localSwitch = this.this$0.at.a();
      if (((Card)localObject1).medalSwitchDisable) {
        break label260;
      }
      paramBoolean = true;
      PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject2, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "PermisionPrivacyActivity onSetMedal medalSwitchDisable= " + ((Card)localObject1).medalSwitchDisable);
      }
    }
    Object localObject2 = this.this$0.app;
    if (((Card)localObject1).medalSwitchDisable) {}
    for (;;)
    {
      anot.a((QQAppInterface)localObject2, "dc00898", "", "", "0X80073A0", "0X80073A0", i, 0, "", "", "", "");
      return;
      label260:
      paramBoolean = false;
      break;
      i = 0;
    }
  }
  
  protected void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PermisionPrivacyActivity.a(this.this$0, paramBoolean);
        QLog.e("vip_pretty.Q.security", 1, "onSetPrettyOwnerFlag " + paramBoolean);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("vip_pretty.Q.security", 1, "onSetPrettyOwnerFlag ex:" + paramObject);
        return;
      }
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkv
 * JD-Core Version:    0.7.0.1
 */