import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class dtj
  extends SubAccountBindObserver
{
  public dtj(SubaccountUgActivity paramSubaccountUgActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    int i = 0;
    if (this.a.f)
    {
      this.a.f = false;
      this.a.e();
    }
    if (paramBoolean)
    {
      paramSubAccountBackProtocData = this.a.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.a.b);
      if ((!TextUtils.isEmpty(paramSubAccountBackProtocData)) || (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))) {
        break label70;
      }
    }
    label70:
    do
    {
      return;
      if (((this.a.c) && (this.a.jdField_a_of_type_JavaLangString != null) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramSubAccountBackProtocData))) || (!this.a.c)) {
        i = 1;
      }
    } while (i == 0);
    this.a.a(this.a.getString(2131562520), this.a.getString(2131563026), this.a.getString(2131562540), new dtm(this));
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    this.a.e();
    if (this.a.e)
    {
      this.a.e = false;
      if (paramBoolean)
      {
        this.a.b.a().c(AppConstants.O, 7000);
        this.a.h();
        this.a.b(this.a.getString(2131563119));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          switch (paramSubAccountBackProtocData.p)
          {
          default: 
            this.a.a(this.a.getString(2131561771));
            return;
          case 1008: 
            this.a.a(this.a.getString(2131563297));
          }
        } while (!this.a.c);
        this.a.h();
        return;
        paramSubAccountBackProtocData = this.a.getString(2131562520);
        String str = this.a.getString(2131563286);
        this.a.a(paramSubAccountBackProtocData, str, new dtk(this));
        return;
      } while (!paramBoolean);
      this.a.b.a().c(AppConstants.O, 7000);
    } while (!this.a.c);
    this.a.a(this.a.getString(2131562520), this.a.getString(2131563026), this.a.getString(2131562540), new dtl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dtj
 * JD-Core Version:    0.7.0.1
 */