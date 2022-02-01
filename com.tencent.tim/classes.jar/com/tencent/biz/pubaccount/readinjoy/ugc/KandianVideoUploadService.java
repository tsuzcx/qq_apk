package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aurf;
import awit;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kxm;
import mey;
import mit;
import miu;
import miu.a;
import mqq.os.MqqHandler;
import mqt;
import mqy;
import mra;

public class KandianVideoUploadService
  extends Service
  implements Handler.Callback, miu.a
{
  private static final String[] bu = { "com.tencent.biz.pubaccount.readinjoy" };
  private static final String[] bv = { "kandian", "readinjoy", "post.mp.qq.com " };
  private static WeakReference<a> ci;
  private static Map<String, WeakReference<miu>> ev = new HashMap();
  private mey a = new mey();
  private boolean amX;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private boolean DG()
  {
    Object localObject = BaseActivity.sTopActivity;
    boolean bool;
    if (ReadinjoyTabFrame.asp) {
      bool = true;
    }
    for (;;)
    {
      QLog.d("KandianVideoUploadService", 1, "isInkandian:" + bool);
      return bool;
      if (localObject == null)
      {
        bool = b(bv, jZ());
      }
      else
      {
        localObject = localObject.toString();
        bool = b(bu, (String)localObject);
      }
    }
  }
  
  private a a()
  {
    a locala = null;
    if (ci != null) {
      locala = (a)ci.get();
    }
    return locala;
  }
  
  public static void a(Bundle paramBundle, a parama)
  {
    Object localObject = paramBundle.getString("mTaskID");
    localObject = (WeakReference)ev.get(localObject);
    if (localObject != null) {}
    for (localObject = (miu)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        parama.a(paramBundle, 200, ((miu)localObject).mProgress);
        return;
      }
      if (ev.size() < 2)
      {
        parama.a(paramBundle, 202, 0.0F);
        return;
      }
      parama.a(paramBundle, 201, 0.0F);
      return;
    }
  }
  
  public static void a(a parama)
  {
    if (parama != null) {
      ci = new WeakReference(parama);
    }
  }
  
  private void a(String paramString, int paramInt, float paramFloat)
  {
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("mTaskID", paramString);
    localMessage.what = paramInt;
    localMessage.obj = Float.valueOf(paramFloat);
    localMessage.setData(localBundle);
    this.uiHandler.sendMessage(localMessage);
  }
  
  private void aK(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0.0F);
  }
  
  private boolean b(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramArrayOfString.length)
      {
        if (paramString.contains(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private String jZ()
  {
    return awit.a(kxm.getAppRuntime(), false, true).getString("mLoadingUrl", "");
  }
  
  private void nD(String paramString)
  {
    QLog.d("KandianVideoUploadService", 1, "removeTask!");
    miu localmiu = (miu)((WeakReference)ev.get(paramString)).get();
    if (localmiu != null) {
      localmiu.aPg();
    }
    ev.remove(paramString);
    if (ev.size() == 0) {
      stopSelf();
    }
  }
  
  public static int pj()
  {
    return mit.be().size();
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    if (DG()) {
      QQToast.a(getBaseContext(), paramInt, paramCharSequence, 0).show(getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  public void a(String paramString, int paramInt, mqt parammqt)
  {
    int i = 1004;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      QLog.d("KandianVideoUploadService", 1, "deliver over!" + paramInt);
      if (paramInt != 0)
      {
        paramString = (miu)((WeakReference)ev.get(paramString)).get();
        if (paramString != null) {
          paramString.rM(i);
        }
      }
      return;
      aK(paramString, 106);
      i = 1001;
      continue;
      aK(paramString, 107);
      i = 1001;
      continue;
      aK(paramString, 100);
      i = 1001;
      continue;
      aK(paramString, 102);
      i = 1001;
      continue;
      aK(paramString, 105);
      continue;
      aK(paramString, 105);
      continue;
      aK(paramString, 104);
      continue;
      aK(paramString, 100);
      i = 1002;
      continue;
      aK(paramString, 105);
      i = 1003;
      continue;
      aK(paramString, 105);
      i = 1003;
      continue;
      aK(paramString, 104);
      i = 1003;
      continue;
      aK(paramString, 105);
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void b(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    paramString2 = (miu)((WeakReference)ev.get(paramString1)).get();
    if ((paramString2 instanceof mra)) {}
    for (paramString2 = ((mra)paramString2).mBundle;; paramString2 = null)
    {
      paramString3 = a();
      switch (paramInt1)
      {
      default: 
        if ((paramString3 != null) && (paramString2 != null)) {
          paramString3.a(paramString2, paramString4);
        }
        a(1, paramString4);
      }
      for (;;)
      {
        nD(paramString1);
        return;
        if (paramString3 != null) {
          paramString3.W(paramString1);
        }
      }
    }
  }
  
  protected void e(Intent paramIntent, String paramString)
  {
    boolean bool1 = false;
    if (ev.size() >= 2)
    {
      paramIntent = ev.values().iterator();
      while (paramIntent.hasNext())
      {
        paramString = (miu)((WeakReference)paramIntent.next()).get();
        QLog.d("KandianVideoUploadService", 1, "startTask");
      }
    }
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D));
    }
    paramString = paramIntent.getStringExtra("arg_video_path");
    boolean bool2 = paramIntent.getBooleanExtra("arg_is_from_wang_zhe", false);
    String str2 = paramIntent.getStringExtra("arg_video_cover");
    if ((TextUtils.isEmpty(str2)) || (!new File(str2).exists())) {
      QLog.d("KandianVideoUploadService", 1, "coverParh not exist!");
    }
    do
    {
      do
      {
        return;
        if ((bool2) || ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))) {
          break;
        }
        QLog.d("KandianVideoUploadService", 1, "onDeliver video not exist!");
        paramString = a();
      } while (paramString == null);
      paramIntent = paramIntent.getExtras();
    } while (paramIntent == null);
    paramString.a(paramIntent, getString(2131720257));
    return;
    paramIntent.putExtra("mTaskID", str1);
    paramString = ev.keySet().iterator();
    while (paramString.hasNext()) {
      bool1 = ((String)paramString.next()).equalsIgnoreCase(str1);
    }
    if (bool1)
    {
      QLog.d("KandianVideoUploadService", 1, "has same task!");
      return;
    }
    if (bool2) {}
    for (paramIntent = new mqy(this, this, paramIntent);; paramIntent = new mra(this, this, paramIntent))
    {
      paramString = new WeakReference(paramIntent);
      ev.put(str1, paramString);
      paramIntent.aPf();
      return;
    }
  }
  
  public void e(String paramString, float paramFloat)
  {
    a(paramString, 108, paramFloat);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 101;
    Object localObject = String.valueOf(paramMessage.getData().get("mTaskID"));
    float f = 0.0F;
    String str = "";
    int j;
    if (paramMessage.what == 100)
    {
      i = 100;
      j = 0;
    }
    for (;;)
    {
      paramMessage = (miu)((WeakReference)ev.get(localObject)).get();
      if (paramMessage != null)
      {
        if (!(paramMessage instanceof mra)) {
          break label289;
        }
        paramMessage = ((mra)paramMessage).mBundle;
      }
      for (;;)
      {
        label77:
        if (j == 0) {
          nD((String)localObject);
        }
        localObject = a();
        switch (j)
        {
        }
        label289:
        do
        {
          return true;
          if (paramMessage.what == 101)
          {
            str = getString(2131720257);
            j = 0;
            break;
          }
          if (paramMessage.what == 102)
          {
            i = 102;
            j = 0;
            break;
          }
          if (paramMessage.what == 103)
          {
            i = 103;
            j = 0;
            break;
          }
          if (paramMessage.what == 104)
          {
            i = 104;
            j = 0;
            break;
          }
          if (paramMessage.what == 105)
          {
            i = 105;
            j = 0;
            break;
          }
          if (paramMessage.what == 106)
          {
            i = 106;
            j = 0;
            break;
          }
          if (paramMessage.what == 107)
          {
            if (!this.amX) {
              break label376;
            }
            i = 107;
            j = 0;
            break;
          }
          if (paramMessage.what != 108) {
            break label368;
          }
          f = ((Float)paramMessage.obj).floatValue();
          i = -1;
          j = 1;
          break;
          if (!(paramMessage instanceof mqy)) {
            break label363;
          }
          paramMessage = ((mqy)paramMessage).mBundle;
          break label77;
          a(1, str);
          if ((localObject != null) && (paramMessage != null)) {
            ((a)localObject).a(paramMessage, str);
          }
          this.uiHandler.removeMessages(i);
          return true;
        } while ((localObject == null) || (paramMessage == null));
        ((a)localObject).a(paramMessage, f);
        return true;
        label363:
        paramMessage = null;
      }
      label368:
      i = -1;
      j = 0;
      continue;
      label376:
      i = 107;
      j = 0;
    }
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("mTaskID");
      QLog.d("KandianVideoUploadService", 1, "receive task  taskID :" + (String)localObject2 + " now taskMap:" + ev.size());
      localObject1 = (WeakReference)ev.get(localObject2);
      if (localObject1 == null) {
        break label145;
      }
    }
    label145:
    for (Object localObject1 = (miu)((WeakReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = a();
        if (localObject2 != null)
        {
          Bundle localBundle = paramIntent.getExtras();
          if (localBundle != null) {
            ((a)localObject2).a(localBundle, ((miu)localObject1).mProgress);
          }
        }
      }
      for (;;)
      {
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
        e(paramIntent, (String)localObject2);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void W(String paramString);
    
    public abstract void a(Bundle paramBundle, float paramFloat);
    
    public abstract void a(Bundle paramBundle, int paramInt, float paramFloat);
    
    public abstract void a(Bundle paramBundle, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService
 * JD-Core Version:    0.7.0.1
 */