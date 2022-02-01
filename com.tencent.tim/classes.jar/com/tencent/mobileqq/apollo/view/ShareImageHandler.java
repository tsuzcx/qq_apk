package com.tencent.mobileqq.apollo.view;

import acbi;
import acbj;
import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import auru;
import ausj;
import ausj.a;
import avqq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import jqg;

public class ShareImageHandler
  implements acbj, DialogInterface.OnDismissListener, Handler.Callback, AdapterView.OnItemClickListener, ausj.a
{
  private long BH;
  private acbi a;
  private ausj ad;
  private boolean bGQ;
  private WeakReference<Activity> mActivityRef;
  private WeakReference<AppInterface> mAppRef;
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.ad != null) {
      this.ad.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            AppInterface localAppInterface;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return false;
                    } while (this.bGQ);
                    paramMessage = (String)paramMessage.obj;
                  } while ((TextUtils.isEmpty(paramMessage)) || (this.mActivityRef == null) || (this.mActivityRef.get() == null));
                  QQToast.a((Context)this.mActivityRef.get(), acfp.m(2131714403) + paramMessage, 1).show();
                  return false;
                  if (this.ad != null) {
                    this.ad.dismiss();
                  }
                } while ((this.bGQ) || (this.mAppRef == null) || (this.mActivityRef == null) || (this.mActivityRef.get() == null));
                localAppInterface = (AppInterface)this.mAppRef.get();
              } while (localAppInterface == null);
              paramMessage = (String)paramMessage.obj;
              if (!TextUtils.isEmpty(paramMessage)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ShareImageHandler", 1, "onItemClick share QZone apolloImage no file");
            return false;
            Bundle localBundle = new Bundle();
            ArrayList localArrayList = new ArrayList();
            try
            {
              localArrayList.add(URLDecoder.decode(paramMessage));
              localBundle.putStringArrayList("images", localArrayList);
              localBundle.putString("summary", acfp.m(2131714402));
              localBundle.putInt("req_type", 7);
              localBundle.putBoolean("key_need_save_draft", false);
              avqq.a(localAppInterface, (Context)this.mActivityRef.get(), localBundle, this, 15);
              return false;
            }
            catch (Exception paramMessage)
            {
              QLog.d("ShareImageHandler", 2, "publishToQzone:" + paramMessage.getMessage());
              return false;
            }
            if (this.ad != null) {
              this.ad.dismiss();
            }
          } while (this.bGQ);
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ShareImageHandler", 1, "onItemClick share QQ apolloImage no file");
        return false;
        if (new File(paramMessage).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ShareImageHandler", 1, "onItemClick share QQ apolloImage no file");
      return false;
    } while ((this.mActivityRef == null) || (this.mActivityRef.get() == null));
    ApolloUtil.d((Activity)this.mActivityRef.get(), paramMessage, null, 1);
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.BH < 1000L) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.BH = l;
      if (paramLong == 1L)
      {
        if (this.a != null) {
          this.a.a(this, 16);
        }
      }
      else if (this.a != null) {
        this.a.a(this, 17);
      }
    }
  }
  
  static class SaveImageTask
    implements Runnable
  {
    private final WeakReference<Bitmap> dR;
    private WeakReference<auru> gd;
    private WeakReference<acbi> ge;
    private int[] ke;
    private final int mCallBackCode;
    private final int mHeight;
    private final int mWidth;
    
    public void run()
    {
      if ((this.gd == null) || (this.ge == null)) {}
      auru localauru;
      Object localObject3;
      do
      {
        do
        {
          return;
          localauru = (auru)this.gd.get();
        } while (localauru == null);
        localObject3 = (acbi)this.ge.get();
      } while (localObject3 == null);
      for (;;)
      {
        int i;
        int j;
        try
        {
          Object localObject2 = (Bitmap)this.dR.get();
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new int[this.mWidth * this.mHeight];
            i = 0;
            j = 0;
            if (j < this.mHeight)
            {
              int k = 0;
              if (k < this.mWidth)
              {
                int m = this.ke[(this.mWidth * j + k)];
                localObject1[((this.mHeight - i - 1) * this.mWidth + k)] = (m & 0xFF00FF00 | m << 16 & 0xFFFF0000 | m >> 16 & 0xFF);
                k += 1;
                continue;
              }
            }
            else
            {
              localObject1 = Bitmap.createBitmap((int[])localObject1, this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
            }
          }
          else if (localObject1 != null)
          {
            localObject3 = ((acbi)localObject3).a(this.ke, (Bitmap)localObject1, this.mWidth, this.mHeight);
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = localObject1;
            }
            localObject1 = jqg.c((Bitmap)localObject2);
            localObject2 = localauru.obtainMessage(this.mCallBackCode);
            ((Message)localObject2).obj = localObject1;
            ((Message)localObject2).sendToTarget();
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("ShareImageHandler", 2, localException.getMessage());
          return;
          QLog.e("ShareImageHandler", 2, "error! bitmap null");
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("ShareImageHandler", 2, localOutOfMemoryError.getMessage());
          return;
        }
        j += 1;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ShareImageHandler
 * JD-Core Version:    0.7.0.1
 */