import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.BaseApplication;

public class cga
  implements DialogInterface.OnClickListener
{
  public cga(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = DetailProfileActivity.a(this.a).getInputValue();
    if ((paramDialogInterface != null) && (!paramDialogInterface.equals("")) && (!paramDialogInterface.equals(this.a.c)))
    {
      if (this.a.a == null) {
        this.a.a = ((CardHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
      }
      if (this.a.a == null) {
        this.a.a(2131561424, 1);
      }
    }
    else
    {
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.jdField_b_of_type_JavaLangString = paramDialogInterface;
      this.a.a.a(this.a.jdField_b_of_type_JavaLangString, null);
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      return;
    }
    this.a.a(2131562445, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cga
 * JD-Core Version:    0.7.0.1
 */