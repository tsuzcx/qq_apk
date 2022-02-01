package com.tencent.mobileqq.app;

import acly;
import acly.c;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Message;
import arwv;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class StartAppCheckHandler$3
  implements Runnable
{
  public StartAppCheckHandler$3(acly paramacly) {}
  
  public void run()
  {
    try
    {
      Object localObject = acly.a(this.this$0, this.this$0.appInterface.getApplication(), this.this$0.jdField_a_of_type_Acly$c.mPkgName);
      if (localObject != null)
      {
        long l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
        String str = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        this.this$0.jdField_a_of_type_Acly$a.QQ = l;
        this.this$0.jdField_a_of_type_Acly$c.bpB = str;
        this.this$0.jdField_a_of_type_Acly$c.bpz = ((PackageInfo)localObject).versionName;
        this.this$0.jdField_a_of_type_Acly$c.bpA = arwv.encodeFileHexStr(((PackageInfo)localObject).applicationInfo.sourceDir);
      }
      this.this$0.jdField_a_of_type_Acly$a.bpt = this.this$0.jdField_a_of_type_Acly$c.bpB;
      this.this$0.jdField_a_of_type_Acly$a.md5 = this.this$0.jdField_a_of_type_Acly$c.bpA;
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, " " + this.this$0.jdField_a_of_type_Acly$c.mUin + " " + this.this$0.jdField_a_of_type_Acly$c.mClientType + " " + this.this$0.jdField_a_of_type_Acly$c.mPkgName + " " + this.this$0.jdField_a_of_type_Acly$c.bpz + " " + this.this$0.jdField_a_of_type_Acly$c.bpA + " " + this.this$0.jdField_a_of_type_Acly$c.bpB);
      }
      if ((this.this$0.jdField_a_of_type_Acly$c.mPkgName != null) && (this.this$0.jdField_a_of_type_Acly$c.bpz != null) && (this.this$0.jdField_a_of_type_Acly$c.bpA != null) && (this.this$0.jdField_a_of_type_Acly$c.bpB != null))
      {
        this.this$0.jdField_a_of_type_Acly$c.a.u64_uin.set(this.this$0.jdField_a_of_type_Acly$c.mUin);
        this.this$0.jdField_a_of_type_Acly$c.a.u32_client_type.set(this.this$0.jdField_a_of_type_Acly$c.mClientType);
        this.this$0.jdField_a_of_type_Acly$c.a.str_packname.set(this.this$0.jdField_a_of_type_Acly$c.mPkgName);
        this.this$0.jdField_a_of_type_Acly$c.a.str_version.set(this.this$0.jdField_a_of_type_Acly$c.bpz);
        this.this$0.jdField_a_of_type_Acly$c.a.str_md5.set(this.this$0.jdField_a_of_type_Acly$c.bpA);
        this.this$0.jdField_a_of_type_Acly$c.a.str_signature.set(this.this$0.jdField_a_of_type_Acly$c.bpB);
        this.this$0.jdField_a_of_type_Acly$c.a.u32_protocol_version.set(2);
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.this$0.jdField_a_of_type_Acly$c;
        acly.a(this.this$0).sendMessage((Message)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "SendStartedAppInfo end..");
        }
      }
      this.this$0.mIsRunning = false;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.3
 * JD-Core Version:    0.7.0.1
 */