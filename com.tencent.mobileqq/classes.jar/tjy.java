import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tjy
  extends CardObserver
{
  public tjy(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131436084, 1);
    }
    if (paramBoolean2)
    {
      PermisionPrivacyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
      return;
    }
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void a(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    switch (paramShort1)
    {
    }
    do
    {
      return;
    } while (paramBoolean);
    this.a.runOnUiThread(new tka(this));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      if (paramBoolean2) {
        break label103;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已启用");
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
        QLog.d("interactive", 2, "PermisionPrivacyActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + localCard.allowCalInteractive);
      }
      return;
      label103:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("未启用");
    }
  }
  
  protected void a(boolean paramBoolean, short[] paramArrayOfShort, Map paramMap)
  {
    if ((paramBoolean) && (paramMap != null) && (paramMap.size() > 0) && (paramMap.containsKey(Short.valueOf((short)-23447))))
    {
      short s = ((Short)paramMap.get(Short.valueOf((short)-23447))).shortValue();
      this.a.runOnUiThread(new tjz(this, s));
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
      if (localCard.allowCalInteractive) {
        break label105;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已启用");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("PermisionPrivacyActivity onSetCalReactiveDays isAllow= ");
        if (localCard.allowCalInteractive) {
          break label120;
        }
      }
    }
    label105:
    label120:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("interactive", 2, paramBoolean);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("未启用");
      break;
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
    PermisionPrivacyActivity.a(this.a, this.a.c.a(), localCard.allowPeopleSee);
  }
  
  protected void j(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean2);
    }
  }
  
  protected void k(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing())) {
      PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean2);
    }
  }
  
  protected void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing()) {
      PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjy
 * JD-Core Version:    0.7.0.1
 */