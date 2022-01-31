import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.ShareToQZone;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;

public class amw
  implements Runnable
{
  public amw(ForwardOperations paramForwardOperations) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!NetworkUtil.e(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      this.a.a(1003, 1, null, 0, null);
      return;
    }
    String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    if ((this.a.w != 5) && (!TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
    {
      this.a.a(1002, 1, null, 0, null);
      return;
    }
    Bundle localBundle = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
    localBundle.putString("vkey", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
    localBundle.putString("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (this.a.jdField_a_of_type_AndroidOsBundle.containsKey("title")) {
      localBundle.putString("title", this.a.jdField_a_of_type_AndroidOsBundle.getString("title"));
    }
    if (this.a.jdField_a_of_type_AndroidOsBundle.containsKey("desc")) {
      localBundle.putString("summary", this.a.jdField_a_of_type_AndroidOsBundle.getString("desc"));
    }
    if (this.a.jdField_a_of_type_AndroidOsBundle.containsKey("detail_url")) {
      localBundle.putString("url", this.a.jdField_a_of_type_AndroidOsBundle.getString("detail_url"));
    }
    if ((this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      GetAppInfoProto.AndroidInfo localAndroidInfo = this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      if (localAndroidInfo.officalwebsite != null) {
        localBundle.putString("fromUrl", localAndroidInfo.officalwebsite.get());
      }
      if (localAndroidInfo.messagetail != null) {
        localBundle.putString("site", localAndroidInfo.messagetail.get());
      }
    }
    if (this.a.w == 5)
    {
      localBundle.putBoolean("picOnly", true);
      localBundle.putString("imageUrl", str1);
      localBundle.putString("title", this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364195, new Object[] { this.a.jdField_a_of_type_AndroidOsBundle.getString("app_name") }));
    }
    for (;;)
    {
      str1 = ForwardOperations.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getEditText());
      if (str1 != null) {
        localBundle.putString("comment", str1);
      }
      if (this.a.jdField_a_of_type_Long > 0L) {
        localBundle.putLong("res_share_id", this.a.jdField_a_of_type_Long);
      }
      localBundle.putString("sdk_type", "" + this.a.w);
      ShareToQZone.a(this.a.jdField_a_of_type_AndroidAppActivity, localBundle, this.a);
      return;
      localBundle.putString("imageUrl", str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     amw
 * JD-Core Version:    0.7.0.1
 */