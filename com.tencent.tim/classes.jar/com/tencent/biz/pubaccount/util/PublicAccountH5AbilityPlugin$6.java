package com.tencent.biz.pubaccount.util;

import alwy;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import aqgo;
import aqha;
import aqju;
import arhz;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import muw;
import obw;
import ocj;
import ock;
import ocl;
import org.json.JSONObject;

public class PublicAccountH5AbilityPlugin$6
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$6(obw paramobw, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (!alwy.auJ()) {
      aqha.a(this.this$0.activity, 230, null, "'", null, this.this$0.activity.getString(2131721079), new ocj(this), null).show();
    }
    Object localObject2;
    String str2;
    int i;
    int j;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    label196:
    boolean bool;
    do
    {
      return;
      Object localObject1;
      try
      {
        localObject2 = new JSONObject(this.val$args[0]);
        if (QLog.isColorLevel()) {
          QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage param json:" + ((JSONObject)localObject2).toString());
        }
        str2 = ((JSONObject)localObject2).optString("topicId");
        i = ((JSONObject)localObject2).optInt("adtag");
        j = ((JSONObject)localObject2).optInt("mode");
        str3 = ((JSONObject)localObject2).optString("vid");
        str4 = ((JSONObject)localObject2).optString("videourl");
        str5 = ((JSONObject)localObject2).optString("coverurl");
        str6 = ((JSONObject)localObject2).optString("md5");
        localObject1 = ((JSONObject)localObject2).optString("topicName");
        str7 = ((JSONObject)localObject2).optString("cookie");
      }
      catch (Exception localException1) {}
      try
      {
        str1 = new String(aqgo.decode((String)localObject1, 0));
        localObject1 = str1;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        break label196;
        if (!QLog.isColorLevel()) {
          break label339;
        }
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage isSoReady=" + bool);
        if (bool) {
          break label457;
        }
        localObject2 = new arhz(this.this$0.mRuntime.getActivity(), this.this$0.mRuntime.getActivity().getResources().getDimensionPixelSize(2131299627));
        ock localock = new ock(this, (arhz)localObject2, str2, localException1, i, j, localException2, str3, str4, str5, str6, str7);
        this.this$0.c.a(localock);
        this.this$0.c.b("CMD_CAMERA_CAPTURE_SO_DOWNLOAD", null);
        ((arhz)localObject2).a(new ocl(this, localock));
        ((arhz)localObject2).show();
        return;
        obw.a(this.this$0, str2, localock, i, j, localException2, str3, str4, str5, str6, str7);
      }
      String str1 = ((JSONObject)localObject2).optString("callback");
      localObject2 = this.this$0.c.b("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null);
      bool = ((Bundle)localObject2).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (!((Bundle)localObject2).getBoolean("VALUE_CAMERA_IS_VIDEO_CHATTING")) {
        break;
      }
      QQToast.a(this.this$0.mRuntime.getActivity(), 0, 2131720263, 0).show();
      return;
    } while (!QLog.isColorLevel());
    QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() Exception=" + localException1.getMessage());
    return;
    label339:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.6
 * JD-Core Version:    0.7.0.1
 */