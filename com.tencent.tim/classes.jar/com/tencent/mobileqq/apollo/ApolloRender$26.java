package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ApolloRender$26
  implements Runnable
{
  ApolloRender$26(long paramLong, int paramInt, View paramView, ApolloRender paramApolloRender) {}
  
  public void run()
  {
    try
    {
      ApolloRender.access$902(this.Nu);
      Intent localIntent;
      if (this.val$type == 0)
      {
        localIntent = new Intent("android.intent.action.PICK");
        localIntent.setType("image/*");
        ((Activity)this.val$view.getContext()).startActivityForResult(localIntent, 14006);
        return;
      }
      if (this.val$type == 1)
      {
        localIntent = new Intent();
        localIntent.addCategory("android.intent.category.DEFAULT");
        Object localObject = this.b;
        ApolloRender.access$1002(new File(ApolloRender.CMSHOW_FILE_PATH));
        localObject = this.b;
        ApolloRender.access$1000().createNewFile();
        localObject = this.val$view.getContext();
        ApolloRender localApolloRender = this.b;
        FileProvider7Helper.setSystemCapture((Context)localObject, ApolloRender.access$1000(), localIntent);
        ((Activity)this.val$view.getContext()).startActivityForResult(localIntent, 14005);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("sava_ApolloRender", 2, "imageselector  fail e=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.26
 * JD-Core Version:    0.7.0.1
 */