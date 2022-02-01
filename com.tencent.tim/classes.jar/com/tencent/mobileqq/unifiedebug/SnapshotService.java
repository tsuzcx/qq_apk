package com.tencent.mobileqq.unifiedebug;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import apzs;
import aqyg;
import arcp;
import arcp.b;
import ardn;
import arwv;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SnapshotService
  extends IphoneTitleBarActivity
{
  private static String TAG = "SnapshotService";
  private static boolean cTf;
  public static String crS = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
  private c a;
  private long ass;
  private c b;
  private AppInterface mApp;
  public Handler mHandler = new Handler();
  private Queue<a> mQueue;
  private BroadcastReceiver mReceiver = new apzs(this);
  private RelativeLayout mRoot;
  
  private void a(Bitmap paramBitmap, a parama, c paramc)
  {
    int j = 1;
    if ((paramc == null) || (paramc.a == null) || (paramc.a.mWebview.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = paramc.a.mWebview.getX5WebViewExtension().getClass().getInterfaces();
    int k = localObject1.length;
    int i = 0;
    label69:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!"com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(localObject2.getName())) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = localObject2.getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "call snapshotVisibleWithBitmap");
        }
        ((Method)localObject1).invoke(paramc.a.mWebview.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new SnapshotService.2(this, paramBitmap, parama, paramc) });
        i = j;
      }
      catch (Exception paramBitmap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, "call snapshotVisibleWithBitmap failed: " + paramBitmap.getMessage());
        i = 0;
        continue;
      }
      if (i != 0) {
        break;
      }
      if (paramc.s != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", parama.seq);
        paramc.s.send(3, paramBitmap);
      }
      finish();
      return;
      i += 1;
      break label69;
      i = 0;
    }
  }
  
  private void a(a parama, c paramc)
  {
    this.mHandler.postDelayed(new SnapshotService.1(this, paramc, parama), paramc.delay);
  }
  
  private void a(c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "mQueue size = " + this.mQueue.size());
    }
    a locala = (a)this.mQueue.peek();
    if (locala != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "current cmd=" + locala.seq);
      }
      a(locala, paramc);
    }
  }
  
  private boolean a(Intent paramIntent, c paramc)
  {
    c.a(paramc, paramIntent.getLongExtra("id", -1L));
    paramc.s = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramc.delay = paramIntent.getLongExtra("delay", 10000L);
    paramc.ast = 3000L;
    paramc.crU = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramc.crU))
    {
      paramc.suffix = (c.a(paramc) + arwv.toMD5(paramc.crU));
      return true;
    }
    return false;
  }
  
  public static boolean aBK()
  {
    return cTf;
  }
  
  private boolean ac(Intent arg1)
  {
    a locala = new a();
    locala.seq = ???.getLongExtra("seq", -1L);
    locala.crT = ???.getStringExtra("seqKey");
    locala.dYb = ???.getIntExtra("maxSnapshotCount", 5);
    locala.index = 0;
    locala.CE = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "new Command seq=" + locala.seq);
    }
    if (locala.seq == -1L) {
      return false;
    }
    synchronized (this.mQueue)
    {
      if (this.mQueue.isEmpty())
      {
        this.mQueue.offer(locala);
        a(this.a);
        return true;
      }
      this.mQueue.offer(locala);
    }
  }
  
  private void b(Bitmap paramBitmap, a parama, c paramc)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramc = new StringBuilder().append("/Snapshot_").append(paramc.suffix).append("_");
      int i = parama.index;
      parama.index = (i + 1);
      paramc = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(paramc);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      parama.CE.add(paramc.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "saveSnapshotBitmap file path = " + paramc.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, paramBitmap.getMessage());
    }
  }
  
  private void b(a arg1, c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "finish once debug, webview id =" + c.a(paramc) + ", seq=" + ???.seq);
    }
    Bundle localBundle;
    int i;
    if (paramc.s != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.CE);
      localBundle.putLong("seq", ???.seq);
      localBundle.putString("seqKey", ???.crT);
      ??? = paramc.s;
      if (c.a(paramc) <= 0L) {
        break label169;
      }
      i = 1;
    }
    for (;;)
    {
      ???.send(i, localBundle);
      synchronized (this.mQueue)
      {
        if (!this.mQueue.isEmpty()) {
          this.mQueue.remove();
        }
        if (this.ass > 0L)
        {
          a(paramc);
          return;
          label169:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void c(a parama, c paramc)
  {
    if ((paramc.a.mWebview.getWidth() <= 0) || (paramc.a.mWebview.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "webview width =" + paramc.a.mWebview.getWidth() + ", height=" + paramc.a.mWebview.getHeight());
      }
      if ((this.ass > 0L) && (paramc.s != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", paramc.crU);
        ((Bundle)localObject).putInt("maxCount", parama.dYb);
        ((Bundle)localObject).putLong("delay", paramc.delay);
        ((Bundle)localObject).putLong("seq", parama.seq);
        ((Bundle)localObject).putString("seqKey", parama.crT);
        paramc.s.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(paramc.a.mWebview.getWidth(), paramc.a.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
    if (paramc.a.mWebview.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, parama, paramc);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramc.a.mWebview.draw(localCanvas);
    if (parama.index == 0) {
      parama.index += 1;
    }
    for (;;)
    {
      d(parama, paramc);
      return;
      b((Bitmap)localObject, parama, paramc);
    }
  }
  
  private void d(a parama, c paramc)
  {
    int j;
    int i;
    boolean bool;
    if (paramc.a.mWebview.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label217;
      }
      i = paramc.a.mWebview.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "webview width =" + paramc.a.mWebview.getWidth() + ", height=" + paramc.a.mWebview.getHeight());
        QLog.i(TAG, 2, "webview scroll height =" + i);
      }
      paramc.a.mWebview.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label233;
      }
      i = parama.dYb;
      label169:
      if (parama.index >= i) {
        break label243;
      }
      i = 1;
      label179:
      if (j == 0) {
        break label248;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label275;
      }
      this.mHandler.postDelayed(new SnapshotService.3(this, parama, paramc), paramc.ast);
      return;
      j = 0;
      break;
      label217:
      bool = paramc.a.mWebview.pageDown(false);
      break label159;
      label233:
      i = parama.dYb + 1;
      break label169;
      label243:
      i = 0;
      break label179;
      label248:
      if ((parama.index <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label275:
    b(parama, paramc);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "in onDestroy method()");
    }
    if (this.ass > 0L)
    {
      unregisterReceiver(this.mReceiver);
      cTf = false;
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mQueue.clear();
    super.doOnDestroy();
    if (this.a != null) {
      this.a.a.onDestroy();
    }
    if (this.b != null) {
      this.b.a.onDestroy();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.a != null) {
      this.a.a.onPause();
    }
    if (this.b != null) {
      this.b.a.onPause();
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRoot = new RelativeLayout(this);
    paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((paramBundle instanceof AppInterface)) {
      this.mApp = ((AppInterface)paramBundle);
    }
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "app == null");
      }
      super.finish();
    }
    arcp.ehv();
    this.mQueue = new LinkedList();
    this.ass = getIntent().getLongExtra("id", -1L);
    if (this.ass > 0L)
    {
      this.a = new c();
      if (!a(getIntent(), this.a)) {
        finish();
      }
      this.a.a = new b(getBaseContext(), this, this.mApp);
      this.a.a.at(super.getIntent());
      this.mRoot.addView(this.a.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
      super.setContentView(this.mRoot);
      super.moveTaskToBack(true);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "new Command in onCreate");
      }
      if (this.ass <= 0L) {
        break label416;
      }
      paramBundle = new IntentFilter("android.intent.action.ultimatesnapshot");
      registerReceiver(this.mReceiver, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "registered receiver: android.intent.action.ultimatesnapshot");
      }
      cTf = true;
      this.a.a.loadUrl(this.a.crU);
      if (!ac(getIntent())) {
        finish();
      }
    }
    label416:
    do
    {
      return;
      this.b = new c();
      if (!a(getIntent(), this.b)) {
        finish();
      }
      this.b.a = new b(getBaseContext(), this, this.mApp);
      this.b.a.at(super.getIntent());
      this.mRoot.addView(this.b.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.b.a.loadUrl(this.b.crU);
      paramBundle = new a();
      paramBundle.seq = getIntent().getLongExtra("seq", -1L);
      paramBundle.crT = getIntent().getStringExtra("seqKey");
      paramBundle.dYb = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.index = 0;
      paramBundle.CE = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "new Command seq=" + paramBundle.seq);
      }
    } while (paramBundle.seq == -1L);
    a(paramBundle, this.b);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    if (l < 0L)
    {
      if (this.b == null)
      {
        this.b = new c();
        this.b.a = new b(getBaseContext(), this, this.mApp);
        this.b.a.at(super.getIntent());
        this.mRoot.addView(this.b.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.b);
      a locala = new a();
      locala.seq = paramIntent.getLongExtra("seq", -1L);
      locala.crT = paramIntent.getStringExtra("seqKey");
      locala.dYb = paramIntent.getIntExtra("maxSnapshotCount", 5);
      locala.index = 0;
      locala.CE = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "new Command in onNewIntent()");
        QLog.i(TAG, 2, "new Command seq=" + locala.seq);
      }
      if (locala.seq != -1L)
      {
        this.b.a.loadUrl(this.b.crU);
        a(locala, this.b);
      }
    }
    do
    {
      do
      {
        return;
        if (this.a == null)
        {
          this.a = new c();
          this.a.a = new b(getBaseContext(), this, this.mApp);
          this.a.a.at(super.getIntent());
          this.mRoot.addView(this.a.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
        }
        switch (paramIntent.getIntExtra("action", 2))
        {
        case 1: 
        default: 
          return;
        }
      } while (l != this.ass);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onNewIntent(), just snapshot for loaded url");
      }
      this.a.delay = 1000L;
      this.a.ast = 1000L;
      ac(paramIntent);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onNewIntent(), load url");
      }
      if (!cTf)
      {
        paramIntent = new IntentFilter("android.intent.action.ultimatesnapshot");
        registerReceiver(this.mReceiver, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "registered receiver: android.intent.action.ultimatesnapshot");
        }
      }
      cTf = true;
    } while ((!a(getIntent(), this.a)) || (!ac(getIntent())));
    this.a.a.loadUrl(this.a.crU);
    this.ass = l;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.a.onResume();
    }
    if (this.b != null) {
      this.b.a.onResume();
    }
  }
  
  static class a
  {
    public ArrayList<String> CE;
    public String crT;
    public int dYb;
    public int index;
    public long seq;
  }
  
  static class b
    extends aqyg
  {
    public b(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
    {
      super(paramActivity, paramAppInterface);
      super.preInitPluginEngine();
      this.mWebview = new TouchWebView(this.mContext);
      buildBaseWebView(paramAppInterface);
    }
    
    public void at(Intent paramIntent)
    {
      super.doOnCreate(paramIntent);
    }
    
    public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
    {
      if (paramArrayList != null) {
        paramArrayList.add(new ardn());
      }
    }
    
    public void loadUrl(String paramString)
    {
      if (arcp.b.cYT)
      {
        arcp.b(this.mWebview, arcp.b.proxy);
        arcp.b.cYT = false;
      }
      this.mUrl = paramString;
      this.mWebview.loadUrl(this.mUrl);
    }
    
    public void onDestroy()
    {
      super.doOnDestroy();
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      paramWebView.loadUrl("javascript:" + SnapshotService.crS);
    }
    
    public void onPause()
    {
      super.doOnPause();
    }
    
    public void onResume()
    {
      super.doOnResume();
    }
  }
  
  class c
  {
    SnapshotService.b a;
    long ast;
    String crU;
    long delay;
    private long mId;
    ResultReceiver s;
    String suffix;
    
    c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */