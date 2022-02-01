package com.tencent.mobileqq.activity.photo;

import akxq;
import akxy;
import android.content.Intent;
import awjb;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import syw;

class SendPhotoTask$1
  implements Runnable
{
  SendPhotoTask$1(SendPhotoTask paramSendPhotoTask, syw paramsyw, akxq paramakxq, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    try
    {
      this.jdField_b_of_type_Syw.a(Long.parseLong(this.jdField_b_of_type_Akxq.b.peerUin), "", "", "", 0, null);
      DeviceInfo localDeviceInfo = this.jdField_b_of_type_Syw.a(Long.parseLong(this.jdField_b_of_type_Akxq.b.peerUin));
      Object localObject = new FileInfo(this.jdField_b_of_type_Akxq.b.localPath);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", localArrayList);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject).putExtra("url", "https://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", "pic");
      awjb.a().a(this.val$activity, this.val$activity.app, this.val$activity.app.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask.1
 * JD-Core Version:    0.7.0.1
 */