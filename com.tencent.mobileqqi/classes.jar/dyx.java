import android.content.Intent;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import java.util.ArrayList;

public class dyx
  extends TroopObserver
{
  public dyx(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((!Utils.a(String.valueOf(paramLong), this.a.jdField_b_of_type_JavaLangString)) || (!Utils.a(paramString1, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      }
      paramString1 = new Intent();
      paramString1.putExtra("isNeedFinish", true);
      paramString1.putExtra("fin_tip_msg", this.a.getString(2131563100));
      paramString1.putExtra("uin", paramString2);
      this.a.setResult(-1, paramString1);
      this.a.finish();
      return;
    }
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      paramString1 = this.a.getString(2131563242);
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
        paramString1 = this.a.getString(2131563069);
      }
      else if ((paramInt == 5) || (paramInt == 17) || (paramInt == 18))
      {
        paramString1 = this.a.getString(2131563009);
      }
      else
      {
        if (paramInt == 12)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
          }
          paramString1 = DialogUtil.a(this.a, 230);
          paramString1.setTitle(this.a.getString(2131560763));
          paramString1.setMessage(this.a.getString(2131560766));
          paramString1.setNegativeButton(this.a.getString(2131562549), new dyy(this, paramString1));
          paramString1.show();
          return;
        }
        paramString1 = this.a.getString(2131563009);
      }
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dyx
 * JD-Core Version:    0.7.0.1
 */