package com.tencent.mobileqq.colornote.list;

import aeci.d;
import aecs;
import aect;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class DefaultItemBuilder$1
  implements Runnable
{
  public DefaultItemBuilder$1(aecs paramaecs, String paramString1, Context paramContext, String paramString2, aeci.d paramd, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      InputStream localInputStream = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getAssets().open(this.bwB);
      aecs.a(this.this$0, LottieComposition.Factory.fromInputStream(this.val$context, localInputStream, new aect(this)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DefaultItemBuilder", 2, "load lottie failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */