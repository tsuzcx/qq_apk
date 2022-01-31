import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class fap
  implements HttpCgiAsyncTask.Callback
{
  public fap(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
      {
        if (this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null)
        {
          this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.a);
          this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131362156));
          this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131362157, new Object[] { this.a.i }), this.a);
          this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a);
        }
        if (this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
        return;
      }
      if ((paramJSONObject.getInt("ret") == 10071) || (paramJSONObject.getInt("ret") == 10000))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a, 230, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131362153), this.a.jdField_a_of_type_AndroidContentResResources.getString(2131362154), 2131363522, 2131362791, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramJSONObject);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
    }
    paramJSONObject = paramJSONObject.getString("msg");
    QQToast.a(CommonDataAdapter.a().a(), paramJSONObject, 0).a(this.a.getTitleBarHeight()).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fap
 * JD-Core Version:    0.7.0.1
 */