package com.tencent.mobileqq.apollo.view;

import abxi;
import acaa;
import acac;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import aquz;
import aqva;
import aqvc;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import jqp;
import mqq.os.MqqHandler;

public class ApolloLottieAnim
  implements Handler.Callback
{
  private boolean Yp;
  private DecoderRunnable a = new DecoderRunnable();
  private boolean bii;
  private String bkk;
  private WeakReference<DiniFlyAnimationView> fZ;
  private auru l = new auru(paramContext.getMainLooper(), this);
  private boolean mAutoPlay;
  private WeakReference<Context> mContextRef;
  public int mState = 0;
  private String mZipUrl;
  
  public ApolloLottieAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mContextRef = new WeakReference(paramContext);
  }
  
  private void A(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.mAutoPlay = paramBoolean;
      if (!paramString2.equals(this.bkk))
      {
        this.bkk = paramString2;
        this.mState = 0;
      }
      paramString2 = jc(this.bkk);
      new File(paramString2).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "setZipData mState:", Integer.valueOf(this.mState), ",zipUrl:", paramString1, ",localZipPath:", this.bkk });
      }
      paramBoolean = jP(paramString2);
      if (!paramBoolean)
      {
        QLog.w("ApolloLottieAnim", 1, "setZipData Lottie Anim data.json not exit");
        this.mState = 0;
      }
      if ((this.mState == 2) || (this.mState == 0))
      {
        this.bii = false;
        File localFile = new File(this.bkk);
        if (paramBoolean)
        {
          a(false, localFile, paramString2);
          return;
        }
        if (localFile.exists())
        {
          a(true, localFile, paramString2);
          return;
        }
        P(paramString1, this.bkk, paramString2);
        return;
      }
    } while (this.mState != 3);
    a(false, null, paramString2);
  }
  
  private void Di(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("folder", paramString);
    localMessage.setData(localBundle);
    this.l.sendMessage(localMessage);
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      b(paramFile, paramString);
      if (!jP(paramString))
      {
        QLog.e("ApolloLottieAnim", 1, "Lottie Anim data.json not exit");
        return;
      }
      this.mState = 3;
      stop();
      Di(paramString);
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("ApolloLottieAnim", 2, paramFile.getMessage());
      this.mState = 2;
    }
  }
  
  private void b(File paramFile, String paramString)
    throws IOException
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      jqp.b(paramFile, paramString);
    }
  }
  
  public static String jb(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = abxi.biw;
    return str + paramString + ".zip";
  }
  
  private String jc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      return str + File.separator;
    }
    return "";
  }
  
  protected void P(String paramString1, String paramString2, String paramString3)
  {
    this.mState = 1;
    aquz localaquz = new aquz(paramString1, new File(paramString2));
    localaquz.cWy = true;
    localaquz.cWw = true;
    localaquz.cxX = "apollo_lottie";
    localaquz.retryCount = 1;
    localaquz.cWz = true;
    localaquz.cWA = true;
    localaquz.c(new acac(this, paramString1, paramString2, paramString3));
    paramString1 = BaseApplicationImpl.getApplication();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getRuntime();
      if (!(paramString1 instanceof QQAppInterface)) {}
    }
    for (paramString1 = (QQAppInterface)paramString1;; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramString1 = (aqva)paramString1.getManager(47);
        if (paramString1 != null)
        {
          paramString1 = paramString1.a(3);
          if (paramString1 != null) {
            paramString1.a(localaquz, localaquz.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new ApolloLottieAnim.3(this, localaquz));
        }
        return;
      }
    }
  }
  
  public MQLruCache<String, Object> a()
  {
    return BaseApplicationImpl.sImageCache;
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, new Object[] { "fromFileWithCacheBitmap animPathFolder:", paramString });
      }
    } while (paramDiniFlyAnimationView.isAnimating());
    if ((this.bii) && (paramBoolean))
    {
      paramDiniFlyAnimationView.playAnimation();
      return;
    }
    for (;;)
    {
      try
      {
        acaa localacaa = new acaa(this, paramDiniFlyAnimationView, paramBoolean);
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder().append("apollo://lottie_");
        if (TextUtils.isEmpty(this.mZipUrl))
        {
          str = paramString;
          localBundle.putString("key", Utils.Crc64String(str));
          localBundle.putString("path", paramString + "images/");
          LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, paramInputStream, paramDiniFlyAnimationView.getLottieDrawable(), localacaa, localBundle, a());
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("ApolloLottieAnim", 1, "playApolloGameBoxLottieAnim:" + paramContext);
        return;
      }
      String str = this.mZipUrl;
    }
  }
  
  public void a(Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.fZ == null) {
        this.fZ = new WeakReference(paramDiniFlyAnimationView);
      }
      a(paramContext, paramDiniFlyAnimationView, paramString, new FileInputStream(paramString + "data.json"), paramBoolean);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ApolloLottieAnim", 1, "fromFileWithCacheBitmap:" + paramContext);
    }
  }
  
  public void a(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.fZ = new WeakReference(paramDiniFlyAnimationView);
    this.mZipUrl = paramString1;
    this.a.b(this, paramString1, paramString2, paramBoolean);
    ThreadManager.removeJobFromThreadPool(this.a, 16);
    ThreadManager.excute(this.a, 16, null, true);
  }
  
  public void destroy()
  {
    stop();
    this.bii = false;
    this.Yp = true;
  }
  
  public void f(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLottieAnim", 2, "onDownloadFinish，result:" + paramBoolean + " url:" + paramString1 + " zipFile:" + paramString2 + " folder:" + paramString3);
    }
    if ((this.bkk != null) && (!this.bkk.equals(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "onDownloadFinish，zipFile unEqual mLocalZipPath:" + this.bkk);
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.mState = 2;
      return;
    }
    this.mState = 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.mContextRef != null) && (this.mContextRef.get() != null) && (this.fZ != null) && (this.fZ.get() != null))
      {
        paramMessage = paramMessage.getData().getString("folder");
        a((Context)this.mContextRef.get(), (DiniFlyAnimationView)this.fZ.get(), paramMessage, this.mAutoPlay);
      }
    }
  }
  
  public boolean jP(String paramString)
  {
    return new File(paramString + "data.json").exists();
  }
  
  public void stop()
  {
    ThreadManager.getUIHandler().post(new ApolloLottieAnim.4(this));
    if (this.l != null) {
      this.l.removeCallbacksAndMessages(null);
    }
  }
  
  static class DecoderRunnable
    implements Runnable
  {
    private String bkm;
    private WeakReference<ApolloLottieAnim> ga;
    private boolean mAutoPlay;
    private String mZipUrl;
    
    public void b(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.mZipUrl = paramString1;
      this.bkm = paramString2;
      this.mAutoPlay = paramBoolean;
      this.ga = new WeakReference(paramApolloLottieAnim);
    }
    
    public void run()
    {
      if ((this.ga != null) && (this.ga.get() != null)) {
        ApolloLottieAnim.a((ApolloLottieAnim)this.ga.get(), this.mZipUrl, this.bkm, this.mAutoPlay);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim
 * JD-Core Version:    0.7.0.1
 */