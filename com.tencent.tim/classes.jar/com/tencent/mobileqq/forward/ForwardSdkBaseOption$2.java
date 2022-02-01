package com.tencent.mobileqq.forward;

import ahki;
import ahlw;
import android.os.Bundle;
import android.text.TextUtils;
import arts;
import arww;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;

public class ForwardSdkBaseOption$2
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    ahki.a(this.this$0, "KEY_STAGE_1_CHANGE_IMG_URL");
    Object localObject1 = arww.a(this.bKM, this.this$0.app.getCurrentUin());
    int i = ((Integer)localObject1[0]).intValue();
    boolean bool2 = ((Boolean)localObject1[1]).booleanValue();
    String str = (String)localObject1[2];
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_ret_code", Integer.toString(i));
    Object localObject2 = this.this$0.app.getCurrentUin();
    boolean bool1;
    if ((i == 0) && (!TextUtils.isEmpty(str))) {
      bool1 = true;
    }
    for (;;)
    {
      ahlw.a("KEY_STAGE_1_CHANGE_IMG_URL", (String)localObject2, (HashMap)localObject1, bool1);
      l = System.currentTimeMillis() - l;
      QLog.d("ForwardSdkBaseOption", 1, new Object[] { "changeRemoteUrl|ret=", Integer.valueOf(i), ",needRich=", Boolean.valueOf(bool2), ",url=", str, ",cost=", Long.valueOf(l) });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "19");
      ((Bundle)localObject2).putString("intext_1", "" + i);
      if (bool2)
      {
        localObject1 = "1";
        ((Bundle)localObject2).putString("intext_2", (String)localObject1);
        ((Bundle)localObject2).putString("intext_3", "0");
        ((Bundle)localObject2).putString("intext_5", "" + l);
        ((Bundle)localObject2).putString("stringext_2", this.bKM);
        arts.a().a((Bundle)localObject2, "" + this.this$0.appid, this.this$0.app.getCurrentUin(), false);
        if ((i != 0) || (TextUtils.isEmpty(str))) {}
      }
      try
      {
        this.this$0.bf.putByte("struct_share_key_image_url_status", (byte)3);
        arww.k(false, this.bKM, this.bKM, str);
        this.this$0.bf.putString("image_url_remote", str);
        if (this.this$0.d != null)
        {
          this.this$0.d.updateCover(str);
          ahki.a(this.this$0).sendEmptyMessage(2);
        }
        return;
        bool1 = false;
        continue;
        localObject1 = "0";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 2, localException, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.2
 * JD-Core Version:    0.7.0.1
 */