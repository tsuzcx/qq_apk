import android.content.Intent;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.ArrayList;

public class bqg
  extends TroopObserver
{
  public bqg(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((!Utils.a(String.valueOf(paramLong), this.a.b)) || (!Utils.a(paramString1, this.a.app.a()))) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      paramString1 = (TroopManager)this.a.app.getManager(44);
      paramString3 = paramString1.a(paramLong + "");
      if (paramString3 != null)
      {
        paramString3.dwAdditionalFlag = 0L;
        paramString1.b(paramString3);
      }
      paramString1 = new Intent();
      paramString1.putExtra("isNeedFinish", true);
      paramString1.putExtra("fin_tip_msg", this.a.getString(2131363634));
      paramString1.putExtra("uin", paramString2);
      this.a.setResult(-1, paramString1);
      this.a.finish();
      return;
    }
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      paramString1 = this.a.getString(2131363635);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, paramString1, 1500);
      return;
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 7) || (paramInt == 16) || (paramInt == 19))
      {
        paramString1 = this.a.getString(2131363637);
      }
      else if ((paramInt == 5) || (paramInt == 17) || (paramInt == 18))
      {
        paramString1 = this.a.getString(2131363636);
      }
      else
      {
        if (paramInt == 12)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
          }
          paramString1 = DialogUtil.a(this.a, 230);
          paramString1.setTitle(this.a.getString(2131362593));
          paramString1.setMessage(this.a.getString(2131362596));
          paramString1.setNegativeButton(this.a.getString(2131362592), new bqh(this, paramString1));
          paramString1.setPositiveButton(this.a.getString(2131363660), new bqi(this, paramString1));
          paramString1.show();
          return;
        }
        paramString1 = this.a.getString(2131363636);
      }
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void c(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void d(boolean paramBoolean, ArrayList paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqg
 * JD-Core Version:    0.7.0.1
 */