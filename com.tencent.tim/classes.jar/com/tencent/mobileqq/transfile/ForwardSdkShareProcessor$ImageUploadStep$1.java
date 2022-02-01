package com.tencent.mobileqq.transfile;

import ahlw;
import android.text.TextUtils;
import aokr;
import aokr.d;
import aool;
import arww;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForwardSdkShareProcessor$ImageUploadStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$ImageUploadStep$1(aokr.d paramd) {}
  
  public void run()
  {
    int j = 0;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|run|retry=" + aokr.d.a(this.a));
    if (this.a.dY.get())
    {
      this.a.doCancel();
      return;
    }
    String str = this.a.this$0.app.getCurrentUin();
    long l = System.currentTimeMillis();
    int i;
    byte b;
    if ((!TextUtils.isEmpty(aokr.b(this.a.this$0))) && (TextUtils.isEmpty(aokr.a(this.a.this$0))))
    {
      i = 1;
      if (i == 0) {
        break label156;
      }
      b = 2;
    }
    Object localObject1;
    label156:
    Object localObject2;
    boolean bool;
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = aokr.b(this.a.this$0);
        if (this.a.dY.get())
        {
          this.a.doCancel();
          return;
          i = 0;
          break;
          b = 4;
          continue;
        }
        localObject2 = aokr.d.a(this.a, (String)localObject1, l);
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject2).second))
        {
          aokr.c(this.a.this$0, (String)((Pair)localObject2).second);
          aokr.a(this.a.this$0).set(true);
          bool = true;
          i = j;
          if (!bool) {}
        }
        else
        {
          try
          {
            localObject2 = new File((String)localObject1).toURL().toString();
            localObject1 = localObject2;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              QLog.d("Q.share.ForwardSdkShareProcessor", 1, "srcPath to URL err:" + localMalformedURLException.getMessage());
            }
          }
          ahlw.Kj("reuse_image_for_aio");
          arww.k(true, (String)localObject1, aokr.b(this.a.this$0), aokr.a(this.a.this$0));
          ahlw.N("reuse_image_for_aio", str, true);
          b = 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = this.a.this$0.app.b().b(this.a.this$0.h.mPeerUin, this.a.this$0.h.mUinType, this.a.this$0.h.mUniseq);
      if (((localObject1 instanceof MessageForStructing)) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)))
      {
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        ((AbsShareMsg)localObject1).updateCover(aokr.a(this.a.this$0));
        ((AbsShareMsg)localObject1).shareData.imageUrlStatus = b;
        this.a.this$0.app.b().c(this.a.this$0.h.mPeerUin, this.a.this$0.h.mUinType, this.a.this$0.h.mUniseq, ((AbsShareMsg)localObject1).getBytes());
      }
      aokr.b(this.a.this$0).set(true);
      this.a.dVB();
      return;
      if (this.a.dY.get())
      {
        this.a.doCancel();
        return;
      }
      localObject2 = aokr.d.a(this.a, l);
      i = ((Integer)((Pair)localObject2).first).intValue();
      bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      break;
      if ((i == 100000) && (aokr.c(this.a.this$0) < 2))
      {
        aokr.d(this.a.this$0);
        aokr.d(this.a.this$0, null);
        aokr.a(this.a.this$0, true);
        aokr.a(this.a.this$0);
        return;
      }
      if (aokr.d.b(this.a) < 2)
      {
        ThreadManager.post(this, 8, null, true);
        return;
      }
      this.a.this$0.dN(9402, "upload share thumbnail fail");
      this.a.dVC();
      return;
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "skip ImageUploadStep change remote url : " + aokr.a(this.a.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */