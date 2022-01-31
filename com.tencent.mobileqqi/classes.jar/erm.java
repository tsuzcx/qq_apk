import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class erm
  extends DiscussionObserver
{
  public erm(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (!paramBoolean) {
      SelectMemberActivity.jdField_a_of_type_Boolean = false;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion success: roomId: " + paramLong + ", mSubType: " + SelectMemberActivity.a(this.a) + ", mEntrance: " + this.a.q);
        }
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", String.valueOf(paramLong));
        this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false))) {
          this.a.a(paramBoolean, paramLong);
        }
        this.a.finish();
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "create discussion fail");
    }
    QQToast.a(this.a, this.a.getString(2131562044), 2000).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
  }
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "add discussion member success: roomId: " + paramLong);
        }
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", String.valueOf(paramLong));
        this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false))) {
          this.a.a(paramBoolean, paramLong, paramArrayList);
        }
        this.a.finish();
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member fail");
    }
    QQToast.a(this.a, this.a.getString(2131562045), 2000).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (paramArrayOfObject == null) {}
    String str;
    do
    {
      return;
      str = (String)paramArrayOfObject[0];
    } while (!this.a.E.equals(str));
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member failed, error code: " + i);
    }
    QQToast.a(this.a, this.a.getString(2131562045), 0).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     erm
 * JD-Core Version:    0.7.0.1
 */