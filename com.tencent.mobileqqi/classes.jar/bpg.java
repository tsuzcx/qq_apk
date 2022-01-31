import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;

class bpg
  implements Runnable
{
  bpg(bpf parambpf, String paramString) {}
  
  public void run()
  {
    String str2;
    String str3;
    if ((this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isResume()) && (!this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      str2 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_Bpf.b });
      str3 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.jdField_a_of_type_Bpf.b });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label241;
      }
    }
    label241:
    for (String str1 = this.jdField_a_of_type_Bpf.jdField_a_of_type_JavaLangString;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      String str4 = String.format(this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131560575), new Object[] { this.jdField_a_of_type_Bpf.c });
      ShareMsgHelper.a(this.jdField_a_of_type_Bpf.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 1001, 1, "struct_msg_from_h5", this.jdField_a_of_type_Bpf.b, str1, this.jdField_a_of_type_Bpf.c, this.jdField_a_of_type_Bpf.d, str4, this.jdField_a_of_type_Bpf.e, "web", null, null, null, "plugin", null, str2, str3, "http://url.cn/JS8oE7", this.jdField_a_of_type_Bpf.f, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpg
 * JD-Core Version:    0.7.0.1
 */