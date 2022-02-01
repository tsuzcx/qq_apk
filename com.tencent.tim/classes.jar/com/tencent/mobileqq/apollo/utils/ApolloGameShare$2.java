package com.tencent.mobileqq.apollo.utils;

import abxi;
import abyb;
import abyd;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import apzg;
import aqcu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloGameShare$2
  implements Runnable
{
  public ApolloGameShare$2(abyb paramabyb, int paramInt) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(abxi.biF).append(abyb.a(this.this$0)).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      } else {
        localObject = aqcu.f(BaseApplicationImpl.getApplication().getResources(), 2130838700);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameShare", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameShare", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
      return;
    }
    Bitmap localBitmap;
    while (localBitmap != null)
    {
      localBitmap = apzg.R(localThrowable);
      abyb.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(new abyd(this));
      WXShareHelper.a().c(abyb.a(this.this$0), abyb.b(this.this$0), localBitmap, abyb.c(this.this$0), abyb.d(this.this$0), this.val$type);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2
 * JD-Core Version:    0.7.0.1
 */