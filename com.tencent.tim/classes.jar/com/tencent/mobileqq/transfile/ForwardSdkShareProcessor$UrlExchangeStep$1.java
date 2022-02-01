package com.tencent.mobileqq.transfile;

import ahlw;
import android.os.Bundle;
import android.text.TextUtils;
import aokr;
import aokr.h;
import aool;
import arts;
import arww;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import jqc;

public class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$UrlExchangeStep$1(aokr.h paramh) {}
  
  public void run()
  {
    this.a.RX("UrlExchangeStep|run,retry=" + aokr.h.a(this.a));
    if (this.a.dY.get())
    {
      this.a.doCancel();
      return;
    }
    Object localObject = new Bundle();
    String str = this.a.this$0.app.getCurrentUin();
    int i;
    long l;
    boolean bool;
    if ((!aokr.a(this.a.this$0).get()) && (TextUtils.isEmpty(aokr.a(this.a.this$0))))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", aokr.e(this.a.this$0));
      ((Bundle)localObject).putString("intext_4", "" + i);
      arts.a().a((Bundle)localObject, "", str, false, this.a.this$0.azV());
      l = System.currentTimeMillis();
      ahlw.Kj("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = jqc.a(this.a.this$0.mAppContext, str, aokr.f(this.a.this$0), 1, aokr.a(this.a.this$0), (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      aokr.h.b(this.a).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      ahlw.a("batch_url_exchange", str, (HashMap)localObject, bool);
      this.a.RX("UrlExchangeStep|run,suc=" + bool + ",ret=" + aokr.h.b(this.a) + ",cost=" + l);
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "12");
      localBundle.putString("intext_3", "0");
      if (!bool) {
        break label1119;
      }
      localObject = "0";
      label425:
      localBundle.putString("intext_1", (String)localObject);
      localBundle.putString("intext_2", "" + aokr.h.b(this.a));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", aokr.e(this.a.this$0));
      }
      arts.a().a(localBundle, "", str, false, this.a.this$0.azV());
      if (!bool) {
        break label1127;
      }
      aokr.a(this.a.this$0).putAll(localHashMap);
      aokr.c(this.a.this$0).set(true);
      this.a.RX("UrlExchangeStep|run,url=" + aokr.a(this.a.this$0).toString());
      localObject = (String)aokr.a(this.a.this$0).get("imageUrl");
      if (localObject != null)
      {
        ahlw.Kj("reuse_image_for_aio");
        arww.k(false, aokr.a(this.a.this$0), aokr.a(this.a.this$0), (String)localObject);
        ahlw.N("reuse_image_for_aio", str, true);
      }
    }
    label1119:
    label1127:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + aokr.h.b(this.a) + ",cost=" + l + ",url=" + aokr.a(this.a.this$0).toString());
      }
      localObject = this.a.this$0.app.b().b(this.a.this$0.h.mPeerUin, this.a.this$0.h.mUinType, this.a.this$0.h.mUniseq);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)aokr.a(this.a.this$0).get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)aokr.a(this.a.this$0).get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)aokr.a(this.a.this$0).get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)aokr.a(this.a.this$0).get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)aokr.a(this.a.this$0).get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (aokr.c(this.a.this$0).get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.a.this$0.app.b().c(this.a.this$0.h.mPeerUin, this.a.this$0.h.mUinType, this.a.this$0.h.mUniseq, ((AbsShareMsg)localObject).getBytes());
      }
      this.a.dVB();
      return;
      i = aokr.a(this.a.this$0).length();
      break;
      localObject = "1";
      break label425;
      if ((aokr.h.b(this.a).get() == 100000) && (aokr.c(this.a.this$0) < 2))
      {
        aokr.d(this.a.this$0);
        aokr.d(this.a.this$0, null);
        aokr.a(this.a.this$0, true);
        aokr.a(this.a.this$0);
        return;
      }
    } while ((aokr.h.b(this.a).get() != -1) || (aokr.h.a(this.a).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */