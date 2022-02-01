import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

class xbd
  implements View.OnClickListener
{
  xbd(xbc paramxbc) {}
  
  public void onClick(View paramView)
  {
    localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)wja.a(paramView);
    if (localMessageForDeviceSingleStruct == null) {}
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaFileName)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 2) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey))) {
        localMessageForDeviceSingleStruct.strMediaFileName = (arwv.toMD5(localMessageForDeviceSingleStruct.strMediaKey) + localMessageForDeviceSingleStruct.strMediaKey.substring(localMessageForDeviceSingleStruct.strMediaKey.lastIndexOf(".")));
      }
      localDeviceInfo = ((syw)this.a.app.getBusinessHandler(51)).a(Long.parseLong(localMessageForDeviceSingleStruct.senderuin));
    } while (localDeviceInfo == null);
    if (localDeviceInfo.isAdmin == 1) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("title", localMessageForDeviceSingleStruct.strTitle);
        ((JSONObject)localObject2).put("digest", localMessageForDeviceSingleStruct.strDigest);
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        localObject1 = localMessageForDeviceSingleStruct.strMediaPath;
        ((JSONObject)localObject2).put("file_path_url", localObject1);
        ((JSONObject)localObject2).put("thumb_path_url", localMessageForDeviceSingleStruct.strCoverPath);
        ((JSONObject)localObject2).put("guide_words", localMessageForDeviceSingleStruct.strGuideWords);
        ((JSONObject)localObject2).put("appear_time", localMessageForDeviceSingleStruct.nAppearTime);
        ((JSONObject)localObject2).put("data_type", localMessageForDeviceSingleStruct.nDataType);
        ((JSONObject)localObject2).put("face", localMessageForDeviceSingleStruct.faceRect);
        ((JSONObject)localObject2).put("cover_session_id", localMessageForDeviceSingleStruct.nCoverSessionID);
        ((JSONObject)localObject2).put("media_session_id", localMessageForDeviceSingleStruct.nMediaSessionID);
        if (localMessageForDeviceSingleStruct.nCoverChannelType != 1) {
          continue;
        }
        ((JSONObject)localObject2).put("cover_key", localMessageForDeviceSingleStruct.strCoverKey);
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        long l;
        int j;
        localJSONException.printStackTrace();
        String str = null;
        continue;
        ((JSONObject)localObject2).put("cover_url", localMessageForDeviceSingleStruct.strCoverKey);
        continue;
        if (localMessageForDeviceSingleStruct.nMediaChannelType != 3) {
          continue;
        }
        ((JSONObject)localObject2).put("media_mini", localMessageForDeviceSingleStruct.strMediaKey);
        ((JSONObject)localObject2).put("fkey2", localMessageForDeviceSingleStruct.strCoverKey2);
        continue;
        ((JSONObject)localObject2).put("media_url", localMessageForDeviceSingleStruct.strMediaKey);
        continue;
        Object localObject2 = aqik.c(this.a.app, this.a.mContext, localMessageForDeviceSingleStruct.url);
        if ((localObject2 == null) || (!"openLightApp".equals(((aqhv)localObject2).cti)) || (!"url".equals(((aqhv)localObject2).ctj))) {
          continue;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("param_meta_data", str);
        tas.a(this.a.app, this.a.mContext, localDeviceInfo, ((aqhv)localObject2).getAttribute("url_prefix"), localBundle);
        continue;
        if ((i == 0) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect)) || (!xbc.a(this.a, localMessageForDeviceSingleStruct.faceRect)) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverPath))) {
          continue;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("device_id", localDeviceInfo.din + "");
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        str = localMessageForDeviceSingleStruct.strMediaPath;
        ((Intent)localObject2).putExtra("filepath", str);
        ((Intent)localObject2).putExtra("rect", localMessageForDeviceSingleStruct.faceRect);
        ((Intent)localObject2).putExtra("from", 0);
        awjb.a().a((Activity)this.a.mContext, this.a.app, this.a.app.getAccount(), (Intent)localObject2, "com.tencent.device.face.FaceRegisterActivity", -1, null, SmartDevicePluginProxyActivity.class);
        continue;
        str = localMessageForDeviceSingleStruct.strCoverPath;
        continue;
        if ((aqhq.fileExistsAndNotEmpty(localMessageForDeviceSingleStruct.strMediaPath)) || (!aqiw.isMobileNetWork(aroi.a().getContext()))) {
          continue;
        }
        str = this.a.mContext.getString(2131693826);
        localObject2 = this.a.mContext.getString(2131693828);
        ahal.a(this.a.mContext, str, (CharSequence)localObject2, new xbe(this, localMessageForDeviceSingleStruct));
        continue;
        xbc.a(this.a, localMessageForDeviceSingleStruct);
        continue;
        i = 3;
        continue;
      }
      if (localMessageForDeviceSingleStruct.nMediaChannelType != 1) {
        continue;
      }
      ((JSONObject)localObject2).put("media_key", localMessageForDeviceSingleStruct.strMediaKey);
      ((JSONObject)localObject2).put("jump_url", localMessageForDeviceSingleStruct.url);
      ((JSONObject)localObject2).put("msg_time", localMessageForDeviceSingleStruct.time);
      ((JSONObject)localObject2).put("ext", localMessageForDeviceSingleStruct.ext);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("struct_msg", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
      if (TextUtils.isEmpty(localMessageForDeviceSingleStruct.url)) {
        continue;
      }
      if ((!localMessageForDeviceSingleStruct.url.startsWith("http://")) && (!localMessageForDeviceSingleStruct.url.startsWith("https://"))) {
        continue;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("url", localMessageForDeviceSingleStruct.url);
      ((Intent)localObject2).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject2).putExtra("param_meta_data", (String)localObject1);
      awjb.a().a((Activity)this.a.mContext, this.a.app, this.a.app.getAccount(), (Intent)localObject2, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
      if (localMessageForDeviceSingleStruct.nDataType != 2) {
        continue;
      }
      i = 4;
      l = Long.parseLong(localMessageForDeviceSingleStruct.senderuin);
      j = localDeviceInfo.productId;
      tar.a(this.a.app, l, "Usr_AIO_ReceiveMsg_Click", i, 0, j);
      break;
      i = 0;
      continue;
      localObject1 = localMessageForDeviceSingleStruct.strCoverPath;
      continue;
      if (localMessageForDeviceSingleStruct.nCoverChannelType != 3) {
        continue;
      }
      ((JSONObject)localObject2).put("cover_mini", localMessageForDeviceSingleStruct.strCoverKey);
      ((JSONObject)localObject2).put("ckey2", localMessageForDeviceSingleStruct.strCoverKey2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbd
 * JD-Core Version:    0.7.0.1
 */