package com.tencent.mobileqq.transfile;

import akyj;
import android.content.Intent;
import anot;
import aooi;
import aooj;
import aool;
import aqmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import ime;

public class TransFileController$1
  implements Runnable
{
  public TransFileController$1(aooi paramaooi, String paramString, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new CompressInfo(this.val$filePath, 0);
    ((CompressInfo)localObject).picType = 0;
    akyj.b((CompressInfo)localObject);
    String str = "";
    boolean bool;
    int i;
    if (this.val$intent != null)
    {
      bool = this.val$intent.getBooleanExtra("PhotoConst.SYNCQZONE", false);
      str = this.val$intent.getStringExtra("PhotoConst.SOURCE_FROM");
      if ("FROM_SELECT_PHOTO".equals(str)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, ".uploadPhoto(), img_path = " + ((CompressInfo)localObject).destPath + ",isSyncQZone=" + bool);
      }
      aool localaool;
      if (!aqmr.isEmpty(((CompressInfo)localObject).destPath))
      {
        localaool = new aool();
        localaool.cNy = true;
        localaool.dQ = ((CompressInfo)localObject).destPath;
        localaool.mFileType = 22;
        localObject = new ime();
        if (!bool) {
          break label310;
        }
      }
      label310:
      for (byte b = 1;; b = 0)
      {
        ((ime)localObject).WriteUInt8(b);
        localaool.gb = ((ime)localObject).Data();
        localaool.b = new aooj(this, bool, str);
        this.this$0.a(localaool);
        if (bool)
        {
          int j = this.val$intent.getIntExtra("PhotoConst.SYNCQZONE_CHECKSTATE", 1);
          anot.a(this.val$app, "dc00898", "", "", "0X8007C16", "0X8007C16", j, 0, "", "", "", "");
        }
        anot.a(this.val$app, "dc00898", "", "", "0X8007C17", "0X8007C17", i, 0, "", "", "", "");
        return;
        if ("FROM_TAKE_PHOTO".equals(str))
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 3;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileController.1
 * JD-Core Version:    0.7.0.1
 */