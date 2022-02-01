package com.tencent.mobileqq.apollo.process.data;

import abmt;
import aboo;
import aboq;
import abxi;
import acfp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import apzg;
import aqcu;
import aquz;
import aqva;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class CmGameCommonShare$4
  implements Runnable
{
  public CmGameCommonShare$4(aboo paramaboo, int paramInt) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(aboo.b(this.this$0))) {
      aboo.a(this.this$0, "shareQRCode_default_v2.png");
    }
    Object localObject2;
    Object localObject1;
    if ((aboo.b(this.this$0).startsWith("http")) || (aboo.b(this.this$0).startsWith("https")))
    {
      localObject2 = new File(abxi.biF + aboo.a(this.this$0) + File.separator + Utils.Crc64String(aboo.b(this.this$0)) + "_shareQRCode.png");
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        aquz localaquz = new aquz(aboo.b(this.this$0), (File)localObject2);
        localaquz.cWy = false;
        localaquz.cWs = false;
        localaquz.cWw = true;
        localaquz.cWB = false;
        localaquz.cWz = true;
        localaquz.cWA = true;
        localaquz.cWl = true;
        localaquz.cxX = "apollo_res";
        localObject1 = localObject2;
        if (aqva.a(localaquz, abmt.getAppInterface().getCurrentAccountUin(), BaseApplicationImpl.getContext()) != 0) {
          ApolloItemBuilder.a(acfp.m(2131704077), 1, BaseApplicationImpl.getContext());
        }
      }
    }
    else
    {
      localObject1 = new File(aboo.c(this.this$0));
    }
    for (;;)
    {
      try
      {
        if ((!((File)localObject1).isFile()) || (!((File)localObject1).exists()))
        {
          QLog.e("apollo_cmGame_CmGameCommonShare", 1, new Object[] { "shareResult2WXFriendOrCircle sharefile is not exsit:", ((File)localObject1).getAbsolutePath() });
          localObject1 = new File(aboo.a(this.this$0, aboo.a(this.this$0)));
          if (!((File)localObject1).exists())
          {
            localObject1 = new File(aboo.b(this.this$0, aboo.a(this.this$0)));
            if (((File)localObject1).exists())
            {
              localObject2 = BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
              if (localObject2 == null) {
                break;
              }
              localObject2 = apzg.R((Bitmap)localObject2);
              WXShareHelper.a().a(new aboq(this));
              WXShareHelper.a().b(((File)localObject1).getAbsolutePath(), (Bitmap)localObject2, this.val$type);
              return;
            }
            localObject2 = aqcu.f(BaseApplicationImpl.getApplication().getResources(), 2130838700);
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_cmGame_CmGameCommonShare", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.4
 * JD-Core Version:    0.7.0.1
 */