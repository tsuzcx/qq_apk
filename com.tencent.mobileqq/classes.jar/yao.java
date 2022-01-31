import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class yao
  extends DiscussionObserver
{
  public yao(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      SelectMemberActivity.jdField_f_of_type_Boolean = false;
    }
    ArrayList localArrayList;
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (!paramBoolean) {
        break label486;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "create discussion success: roomId: " + paramLong + ", mSubType: " + this.a.d + ", mEntrance: " + this.a.jdField_f_of_type_Int);
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.a.i.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.jdField_a_of_type_Int == 5)
        {
          if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
            localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
          }
          localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        }
        else if ((localResultRecord.jdField_a_of_type_Int == 4) && (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+")))
        {
          localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", String.valueOf(paramLong));
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("discussName", paramString);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("qqPhoneUserList", localArrayList);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("audioType", 2);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("callType", 2);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("reportType", SelectMemberActivity.a(this.a));
      if (this.a.jdField_f_of_type_Int != 18) {
        break label456;
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("from", 3);
    }
    for (;;)
    {
      if (this.a.jdField_f_of_type_Int == 12) {
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("select_memeber_discussion_memeber_count", this.a.i.size() + 1);
      }
      if (13 == this.a.jdField_f_of_type_Int) {}
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
      if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false))) {
        this.a.b(paramBoolean, paramLong, localArrayList);
      }
      this.a.finish();
      return;
      label456:
      if (this.a.jdField_f_of_type_Int == 10) {
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("from", 6);
      }
    }
    label486:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "create discussion fail, errCode=" + paramInt);
    }
    if (paramInt == 1000)
    {
      QQToast.a(this.a, this.a.getString(2131430296), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      ReportController.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a, this.a.getString(2131433981), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (!paramBoolean) {
        break label328;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add discussion member success: roomId: " + paramLong);
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.a.i.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.jdField_a_of_type_Int == 5)
        {
          if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
            localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
          }
          localArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", String.valueOf(paramLong));
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("qqPhoneUserList", localArrayList);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("audioType", 2);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("callType", 2);
      if (this.a.jdField_f_of_type_Int != 18) {
        break label298;
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("from", 3);
    }
    for (;;)
    {
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
      if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false))) {
        this.a.a(paramBoolean, paramLong, paramArrayList);
      }
      this.a.finish();
      return;
      label298:
      if (this.a.jdField_f_of_type_Int == 10) {
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("from", 6);
      }
    }
    label328:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member fail");
    }
    if (paramInt == 1000) {
      ReportController.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
    }
    QQToast.a(this.a, this.a.getString(2131433988), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
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
    } while (!this.a.jdField_c_of_type_JavaLangString.equals(str));
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member failed, error code: " + i);
    }
    QQToast.a(this.a, this.a.getString(2131433988), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yao
 * JD-Core Version:    0.7.0.1
 */