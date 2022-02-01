import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class cly
  extends Thread
{
  public cly(ForwardOperations paramForwardOperations, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.c) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null)))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.c) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_v_of_type_JavaLangString))) {
          break label89;
        }
        ForwardOperations.b(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new clz(this));
      }
      label89:
      Object localObject1;
      Object localObject2;
      String str2;
      Object localObject3;
      HashMap localHashMap;
      try
      {
        Thread.sleep(1000L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      localObject2 = Share.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
      if (((GetAppInfoProto.AndroidInfo)localObject1).sourceUrl != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", ((GetAppInfoProto.AndroidInfo)localObject1).sourceUrl.get());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)localObject2);
      }
      if (((GetAppInfoProto.AndroidInfo)localObject1).messagetail != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", ((GetAppInfoProto.AndroidInfo)localObject1).messagetail.get());
      }
      if (((GetAppInfoProto.AndroidInfo)localObject1).packName != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", ((GetAppInfoProto.AndroidInfo)localObject1).packName.get());
      }
    }
    str2 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
    localHashMap = new HashMap();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("sourceUrl", localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localHashMap.put("sourceIcon", localObject3);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.z != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.z);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_v_of_type_Int == 5)
    {
      localObject2 = new ImageInfo();
      ((ImageInfo)localObject2).h = str2;
      ((ImageInfo)localObject2).c = this.jdField_a_of_type_JavaLangString;
      localObject2 = StructMsgForImageShare.scaleLocalImage(this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity, (ImageInfo)localObject2, (String)localObject1, this.jdField_a_of_type_Int);
      if (localObject2 == null) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("image_url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.remove("image_url_remote");
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.remove("title");
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.remove("desc");
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.remove("detail_url");
        localObject1 = HttpUtil.a(BaseApplication.getContext(), str2, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_v_of_type_JavaLangString, 1, localHashMap);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new cma(this, (HashMap)localObject1));
        return;
        localObject1 = localObject2;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_v_of_type_Int == 2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
      if (HttpUtil.a((String)localObject2)) {
        localHashMap.put("audioUrl", localObject2);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new HashMap();
      ((Map)localObject2).put("Connection", "keep-alive");
      ((Map)localObject2).put("Referer", "http://www.qq.com");
      localObject3 = new HashMap();
      ((Map)localObject3).put("share_image", localObject1);
      localObject1 = HttpUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", str2, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_v_of_type_JavaLangString, null, (Map)localObject3, (Map)localObject2);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if ((((JSONObject)localObject1).getInt("retcode") == 0) && (((JSONObject)localObject1).has("result")))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("result").getString("url");
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.remove("image_url");
        }
        localObject1 = HttpUtil.a(BaseApplication.getContext(), str2, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_v_of_type_JavaLangString, 1, localHashMap);
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new cmb(this, (HashMap)localObject1));
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("sdk_share", 4, localJSONException.getMessage());
        continue;
      }
      String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
      if (HttpUtil.a(str1)) {
        localHashMap.put("imageUrl", str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cly
 * JD-Core Version:    0.7.0.1
 */