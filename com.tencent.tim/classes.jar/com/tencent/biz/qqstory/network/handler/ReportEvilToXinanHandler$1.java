package com.tencent.biz.qqstory.network.handler;

import android.os.Bundle;
import arwv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import jqc;
import mqq.manager.TicketManager;
import pxx;
import qem;
import ram;

public class ReportEvilToXinanHandler$1
  implements Runnable
{
  public ReportEvilToXinanHandler$1(pxx parampxx, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str4 = pxx.a(this.this$0);
    if (this.aCD) {}
    for (String str1 = "1";; str1 = "0")
    {
      String str2 = this.avM;
      String str3 = this.avN;
      str4 = arwv.toMD5("android" + "_" + "3.4.4" + "_" + "1111" + "_" + str4);
      ram.b("ReportEvilToXinanHandler", "get cryptograph step1. scretKey = %s.", str4);
      str4 = arwv.toMD5(this.avO + "_" + "" + "_" + str2 + "_" + "" + "_" + "" + "_" + str3 + "_" + "" + "_" + "" + "_" + str4);
      ram.b("ReportEvilToXinanHandler", "get cryptograph step2. cryptograph = %s.", str4);
      Object localObject2 = (TicketManager)qem.getQQAppInterface().getManager(2);
      Object localObject1 = qem.getQQAppInterface().getCurrentAccountUin();
      String str5 = ((TicketManager)localObject2).getSkey((String)localObject1);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cookie", "uin=" + (String)localObject1 + ";skey=" + str5);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("system", "android");
      ((Bundle)localObject1).putString("version", "3.4.4");
      ((Bundle)localObject1).putString("uintype", "1");
      ((Bundle)localObject1).putString("eviluin", this.avO);
      ((Bundle)localObject1).putString("appname", "KQQ");
      ((Bundle)localObject1).putString("appid", "2400002");
      ((Bundle)localObject1).putString("subapp", "near_trace");
      ((Bundle)localObject1).putString("scene", "1111");
      ((Bundle)localObject1).putString("evil_type", this.avP);
      ((Bundle)localObject1).putString("buddyflag", str1);
      ((Bundle)localObject1).putString("srv_para", "");
      ((Bundle)localObject1).putString("impeach_desc", "");
      ((Bundle)localObject1).putString("text_evidence", str2);
      ((Bundle)localObject1).putString("img_evidence", "");
      ((Bundle)localObject1).putString("url_evidence", "");
      ((Bundle)localObject1).putString("video_evidence", str3);
      ((Bundle)localObject1).putString("file_evidence", "");
      ((Bundle)localObject1).putString("audio_evidence", "");
      ((Bundle)localObject1).putString("user_input_param", "REPORT_IP=0&EVIL_IP=0");
      ((Bundle)localObject1).putString("cryptograph", str4);
      try
      {
        str1 = jqc.a(BaseApplicationImpl.getContext(), "https://jubao.qq.com/uniform_impeach/impeach_submit", "POST", (Bundle)localObject1, (Bundle)localObject2);
        pxx.a(this.this$0, this.avO, this.val$vid, this.avP, str1);
        return;
      }
      catch (IOException localIOException)
      {
        QLog.d("ReportEvilToXinanHandler", 1, localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.1
 * JD-Core Version:    0.7.0.1
 */