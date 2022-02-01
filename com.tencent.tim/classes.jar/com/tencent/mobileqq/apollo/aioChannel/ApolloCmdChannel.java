package com.tencent.mobileqq.apollo.aioChannel;

import abji;
import abjj;
import abjk;
import abjl;
import abjm;
import abjo;
import abjp;
import abjq;
import ably;
import abmt;
import abmy;
import abnm;
import aboc;
import aboi;
import abos;
import abpc;
import abpf;
import abqe;
import acff;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import aqgv;
import aqgz;
import auru;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ApolloCmdChannel
{
  private static final String TAG = "cmgame_process.ApolloDataChannel";
  private static ApolloCmdChannel sDataChannel;
  private AppRuntime _mApp;
  private WeakReference<Activity> mActivityRef;
  private WeakReference<QQAppInterface> mAppRef;
  private HashMap<Long, Boolean> mCallJsRuntimeMap;
  private abnm mPlayer;
  private abjm mRenderRunners;
  private auru mRequestHandlerThread;
  private List<a> mRequestHandlers;
  private volatile boolean mSetNativeObj;
  
  private ApolloCmdChannel(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.mRequestHandlers = new ArrayList();
    this.mRenderRunners = new abjm();
    this.mPlayer = new abmy(paramQQAppInterface, -10000);
    this.mCallJsRuntimeMap = new HashMap();
    init();
  }
  
  public ApolloCmdChannel(AppRuntime paramAppRuntime)
  {
    this._mApp = paramAppRuntime;
    this.mCallJsRuntimeMap = new HashMap();
    this.mRenderRunners = new abjm();
    this.mRequestHandlers = new ArrayList();
    init();
  }
  
  private native void callbackEngineOld(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public static void checkNeedDestroy()
  {
    if (sDataChannel != null)
    {
      sDataChannel.onDestroy();
      sDataChannel = null;
    }
  }
  
  private void createRightPlayer(int paramInt)
  {
    if (abmt.YH())
    {
      abos localabos = abmt.a(getGameId());
      if (localabos != null) {
        localabos.HE(paramInt);
      }
    }
  }
  
  public static ApolloCmdChannel getChannel(QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      try
      {
        if (sDataChannel == null)
        {
          sDataChannel = new ApolloCmdChannel(paramQQAppInterface);
          paramQQAppInterface = sDataChannel;
          return paramQQAppInterface;
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)sDataChannel.mAppRef.get();
        if (localQQAppInterface == null)
        {
          sDataChannel.onDestroy();
          sDataChannel = new ApolloCmdChannel(paramQQAppInterface);
          QLog.d("cmgame_process.ApolloDataChannel", 1, "oldApp == null create new cmdChannel App:" + paramQQAppInterface);
          continue;
        }
        if (localQQAppInterface == paramQQAppInterface) {
          continue;
        }
      }
      finally {}
      sDataChannel.onDestroy();
      sDataChannel = new ApolloCmdChannel(paramQQAppInterface);
      QLog.d("cmgame_process.ApolloDataChannel", 1, "oldApp != app create new cmdChannel App:" + paramQQAppInterface);
    }
  }
  
  public static ApolloCmdChannel getChannelFromOtherProcess(AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        if ((paramAppRuntime instanceof QQAppInterface))
        {
          paramAppRuntime = getChannel((QQAppInterface)paramAppRuntime);
          return paramAppRuntime;
        }
        if (sDataChannel == null)
        {
          sDataChannel = new ApolloCmdChannel(paramAppRuntime);
          paramAppRuntime = sDataChannel;
          continue;
        }
        AppRuntime localAppRuntime = sDataChannel._mApp;
        if (localAppRuntime == null)
        {
          sDataChannel.onDestroy();
          sDataChannel = new ApolloCmdChannel(paramAppRuntime);
          QLog.d("cmgame_process.ApolloDataChannel", 1, "oldApp == null create new cmdChannel App:" + paramAppRuntime);
          continue;
        }
        if (localAppRuntime == paramAppRuntime) {
          continue;
        }
      }
      finally {}
      sDataChannel.onDestroy();
      sDataChannel = new ApolloCmdChannel(paramAppRuntime);
      QLog.d("cmgame_process.ApolloDataChannel", 1, "oldApp != app create new cmdChannel App:" + paramAppRuntime);
    }
  }
  
  private int getGameId()
  {
    if (abmt.YH())
    {
      abos localabos = abmt.a(Thread.currentThread().getId());
      if (localabos == null) {
        return -1;
      }
      return localabos.getGameId();
    }
    return -10000;
  }
  
  private abnm getRightPlayer()
  {
    if (abmt.YH())
    {
      abos localabos = abmt.a(getGameId());
      if (localabos != null) {
        return localabos.a();
      }
    }
    else
    {
      return this.mPlayer;
    }
    return null;
  }
  
  private void init()
  {
    makesureHasInitObj();
    this.mRequestHandlerThread = new auru(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.mRequestHandlers)
    {
      Collections.sort(this.mRequestHandlers, new abjj(this));
      return;
    }
  }
  
  private boolean isGameHandlerClosed()
  {
    for (;;)
    {
      synchronized (this.mRequestHandlers)
      {
        Iterator localIterator = this.mRequestHandlers.iterator();
        if (localIterator.hasNext())
        {
          if (!((a)localIterator.next() instanceof aboc)) {
            continue;
          }
          bool = false;
          return bool;
        }
      }
      boolean bool = true;
    }
  }
  
  private native void nativeGetHeadCallback(Bitmap paramBitmap, String paramString, int paramInt, long paramLong);
  
  private native void nativeGetNickCallback(String paramString1, String paramString2, int paramInt, long paramLong);
  
  private native void nativeSetAudioHash(long paramLong, int paramInt);
  
  private native void nativeSetDataChannelObj(ApolloCmdChannel paramApolloCmdChannel);
  
  public static void onAccountChanged()
  {
    if (sDataChannel != null)
    {
      sDataChannel.onDestroy();
      sDataChannel = null;
    }
  }
  
  public void addCmdHandler(a parama)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(parama);
      this.mRequestHandlers.add(parama);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "addCmdHandler class:" + parama.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void addRenderRunner(abjq paramabjq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "addRenderRunner,renderRunner:" + paramabjq);
    }
    this.mRenderRunners.a(paramabjq);
  }
  
  public void callbackDirect(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[callbackEngine], luaState:" + paramLong + ",errCode:" + paramInt + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    if (-1L == paramLong)
    {
      QLog.i("cmgame_process.ApolloDataChannel", 1, "callbackEngine, errInfo->lState is destroyed.");
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = "{}";
    }
    for (;;)
    {
      callbackEngineWrapper(paramBoolean, paramLong, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public native void callbackEngine(long paramLong, int paramInt, String paramString1, String paramString2);
  
  void callbackEngineWrapper(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramLong == -1L) {}
    label166:
    label339:
    do
    {
      Boolean localBoolean;
      do
      {
        return;
        if (!ApolloEngine.BJ()) {
          break label339;
        }
        localBoolean = (Boolean)this.mCallJsRuntimeMap.get(Long.valueOf(paramLong));
        try
        {
          localabos = abmt.b(paramLong);
          if ((localabos == null) || (!localabos.YN())) {
            break label258;
          }
          if (localBoolean == null) {
            break label166;
          }
          if (localBoolean.booleanValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper isCallFromJs callbackEngine,lState:" + paramLong);
            }
            callbackEngine(paramLong, paramInt, paramString1, paramString2);
            return;
          }
        }
        catch (OutOfMemoryError paramString1)
        {
          QLog.e("cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper isCallFromJs callbackEngineOld,lState:" + paramLong);
        }
        callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
        return;
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper callbackEngine, jsRuntime lState:" + paramLong);
          }
          callbackEngine(paramLong, paramInt, paramString1, paramString2);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWrapper callbackEngineOld, jsRuntime lState:" + paramLong);
        }
        callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
        return;
        abos localabos = abmt.a((int)paramLong);
        if (localabos == null) {
          break;
        }
        if (!localabos.YN())
        {
          localabos.z(paramInt, paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloDataChannel", 2, "not h5 game");
      return;
      if ((paramBoolean) || (localBoolean.booleanValue())) {
        callbackEngine(paramLong, paramInt, paramString1, paramString2);
      }
      QLog.e("cmgame_process.ApolloDataChannel", 1, "can not find h5 launcher");
      return;
    } while (!QLog.isColorLevel());
    label258:
    QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackEngineWarpper ApolloEngine.isEngineReady() false");
  }
  
  public void callbackFromRequest(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[callbackFromRequest], luaState:" + paramLong + ",errCode:" + paramInt + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    this.mRenderRunners.a(this, paramLong, paramInt, paramString1, paramString2);
  }
  
  public void callbackGetHead(Bitmap paramBitmap, String paramString, int paramInt, long paramLong)
  {
    abjq localabjq = this.mRenderRunners.a(paramLong);
    if (localabjq != null)
    {
      if (ApolloEngine.BJ()) {
        break label38;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackGetHead ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label38:
    localabjq.runRenderTask(new ApolloCmdChannel.4(this, paramBitmap, paramString, paramInt, paramLong));
  }
  
  public void callbackGetNick(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    abjq localabjq = this.mRenderRunners.a(paramLong);
    if (localabjq != null)
    {
      if (ApolloEngine.BJ()) {
        break label38;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "callbackGetNick ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label38:
    localabjq.runRenderTask(new ApolloCmdChannel.3(this, paramString1, paramString2, paramInt, paramLong));
  }
  
  public void checkSetNative()
  {
    if (!this.mSetNativeObj)
    {
      nativeSetDataChannelObj(this);
      this.mSetNativeObj = true;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "checkSetNative nativeSetDataChannelObj");
      }
    }
  }
  
  public void destroyMusic()
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.onDestroy();
    }
  }
  
  public void exeJsOnEngine(abjq paramabjq, String paramString)
  {
    this.mRenderRunners.exeJsOnEngine(paramabjq, paramString);
  }
  
  public void getAccountInfo(long paramLong, String paramString, int paramInt)
  {
    if (abmt.YH()) {
      abpc.j(paramLong, paramInt, paramString);
    }
  }
  
  public int getDeviceHeight()
  {
    return (int)aqgz.getHeight();
  }
  
  public int getDeviceWidth()
  {
    return (int)aqgz.getWidth();
  }
  
  public int getDispalyDpi()
  {
    return aqgz.getDispalyDpi();
  }
  
  public int getMusicCurPos(int paramInt)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      return this.mPlayer.gc(paramInt);
    }
    return -1;
  }
  
  public int getMusicDuration(int paramInt)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      return this.mPlayer.getDuration(paramInt);
    }
    return -1;
  }
  
  public int getMusicSwitch()
  {
    this.mPlayer = getRightPlayer();
    AppInterface localAppInterface = abmt.getAppInterface();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      return this.mPlayer.c(localAppInterface);
    }
    return 1;
  }
  
  public String getNickname(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (this.mAppRef != null)
    {
      localObject = paramString2;
      if (this.mAppRef.get() != null)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label36;
        }
        localObject = paramString2;
      }
    }
    return localObject;
    label36:
    if (paramInt == 4) {
      paramString1 = aqgv.o((QQAppInterface)this.mAppRef.get(), paramString1, paramString2);
    }
    for (;;)
    {
      localObject = paramString1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[getNickname], nickName:" + paramString1);
      return paramString1;
      if (paramInt == 5)
      {
        paramString1 = aqgv.c((QQAppInterface)this.mAppRef.get(), paramString2, false);
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt == 1)
        {
          localObject = (QQAppInterface)this.mAppRef.get();
          paramString1 = paramString2;
          if (localObject != null)
          {
            localObject = ((acff)((QQAppInterface)localObject).getManager(51)).b(paramString2);
            paramString1 = paramString2;
            if (localObject != null) {
              paramString1 = ((Friends)localObject).getFriendNick();
            }
          }
        }
      }
    }
  }
  
  public void getOpenApiHead(long paramLong, String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mRequestHandlers.size())
      {
        if ((this.mRequestHandlers.get(i) instanceof aboc)) {
          ((aboc)this.mRequestHandlers.get(i)).a(paramLong, paramString, new abjk(this, paramLong, paramString));
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void getOpenApiNick(long paramLong, String paramString)
  {
    int i = 0;
    while (i < this.mRequestHandlers.size())
    {
      if ((this.mRequestHandlers.get(i) instanceof aboc)) {
        ((aboc)this.mRequestHandlers.get(i)).a(paramLong, paramString, new abjl(this, paramLong, paramString));
      }
      i += 1;
    }
  }
  
  @Deprecated
  public void handleWebEvent(String paramString)
  {
    handleWebEvent(paramString, 0);
  }
  
  public void handleWebEvent(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, new Object[] { "[handleWebEvent] data=", paramString });
    }
    if (!ApolloEngine.BJ())
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "handleWebEvent ApolloEngine.isEngineReady() false");
      }
      return;
    }
    if (paramInt != 0) {}
    for (abjq localabjq = this.mRenderRunners.a(paramInt);; localabjq = this.mRenderRunners.a())
    {
      if (localabjq != null) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[handleWebEvent], not find renderRunner");
      return;
    }
    label92:
    localabjq.runRenderTask(new ApolloCmdChannel.5(this, localabjq, paramString));
  }
  
  /* Error */
  public void makesureHasInitObj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 317	com/tencent/mobileqq/apollo/ApolloEngine:BJ	()Z
    //   5: ifeq +38 -> 43
    //   8: aload_0
    //   9: getfield 396	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:mSetNativeObj	Z
    //   12: ifne +28 -> 40
    //   15: aload_0
    //   16: aload_0
    //   17: invokespecial 398	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:nativeSetDataChannelObj	(Lcom/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel;)V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 396	com/tencent/mobileqq/apollo/aioChannel/ApolloCmdChannel:mSetNativeObj	Z
    //   25: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +12 -> 40
    //   31: ldc 23
    //   33: iconst_2
    //   34: ldc_w 524
    //   37: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: invokestatic 253	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq -6 -> 40
    //   49: ldc 23
    //   51: iconst_2
    //   52: ldc_w 526
    //   55: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: goto -18 -> 40
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	ApolloCmdChannel
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	61	finally
    //   43	58	61	finally
  }
  
  public native void nativeOpenApiGetHeadCallBack(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public native void nativeOpenApiGetNickCallBack(long paramLong, String paramString1, int paramInt, String paramString2);
  
  public void onDestroy()
  {
    this.mRenderRunners.onDestroy();
    synchronized (this.mRequestHandlers)
    {
      Iterator localIterator = this.mRequestHandlers.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).destroyHandler();
      }
    }
    this.mRequestHandlers.clear();
    this.mRequestHandlerThread.removeCallbacksAndMessages(null);
    if (this.mPlayer != null) {
      this.mPlayer.onDestroy();
    }
  }
  
  public void openWebview(String paramString)
  {
    if (this.mActivityRef != null) {}
    for (Object localObject1 = (Activity)this.mActivityRef.get();; localObject1 = BaseActivity.sTopActivity)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (SplashActivity.dO != null) {
          localObject2 = (Activity)SplashActivity.dO.get();
        }
      }
      if (localObject2 != null)
      {
        localObject1 = new Intent((Context)localObject2, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("game_busid", "Android.H5");
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity((Context)localObject2, paramString, -1L, (Intent)localObject1, true, 100);
        QLog.i("cmgame_process.ApolloDataChannel", 1, "openWebview activity=" + localObject2 + ", url: " + paramString);
      }
      return;
    }
  }
  
  public void operateNativeUI(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = abmt.b(paramLong);
    if (localObject != null)
    {
      localObject = ((abos)localObject).a();
      if (localObject == null) {}
    }
    try
    {
      paramString3 = new JSONObject(paramString3);
      paramString3.put("action", paramString4);
      ((abqe)localObject).A(paramString1, paramString2, paramString4, paramString3.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
    }
  }
  
  public void pauseMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.pauseMusic(paramInt, paramString);
    }
  }
  
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], type:" + paramInt1 + ",count:" + paramInt2 + ",musicPath:" + paramString);
    }
    playMusic(paramLong, paramInt1, paramInt2, paramString, -1.0F, 0, 0);
  }
  
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString, float paramFloat, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",count:", Integer.valueOf(paramInt2), ",musicPath:", "volumn:", Float.valueOf(paramFloat), ",seekTo:", Integer.valueOf(paramInt3), ",audioType:", Integer.valueOf(paramInt4) });
    }
    abjq localabjq = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localabjq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], not find renderRunner");
      }
    }
    label232:
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[playMusic], musicPath is null");
      return;
      if (paramString.startsWith("actionMusic:")) {
        paramString = paramString.substring(paramString.indexOf(":") + 1);
      }
      for (;;)
      {
        if (!(localabjq instanceof View)) {
          break label232;
        }
        View localView = (View)localabjq;
        if ((localView == null) || (localView.isShown())) {
          break label232;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmgame_process.ApolloDataChannel", 2, "DO NOT play music, cause the view is not visible.");
        return;
      }
      createRightPlayer(paramInt4);
      this.mPlayer = getRightPlayer();
    } while (this.mPlayer == null);
    ThreadManager.post(new PlayMusicTask(getGameId(), this, localabjq, this.mPlayer, paramLong, paramInt1, paramInt2, paramString, paramFloat, paramInt3), 5, null, true);
  }
  
  public void playMusicInner(abjq paramabjq, int paramInt, long paramLong)
  {
    if ((paramabjq != null) && (paramInt != 0) && (paramLong != 0L))
    {
      if (ApolloEngine.BJ()) {
        break label36;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "playMusicInner ApolloEngine.isEngineReady() false");
      }
    }
    return;
    label36:
    paramabjq.runRenderTask(new ApolloCmdChannel.6(this, paramLong, paramInt));
  }
  
  public void removeCmdHandler(a parama)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(parama);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloDataChannel", 2, "removeCmdHandler class:" + parama.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void removeRenderRunner(abjq paramabjq)
  {
    this.mRenderRunners.b(paramabjq);
  }
  
  public String requestData(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[requestData], luaState:" + paramLong + ",cmd:" + paramString1 + ",async:" + paramBoolean1 + ",isCallFromJsRuntime:" + paramBoolean2);
    }
    if (isGameHandlerClosed()) {
      abmt.eu(paramString1, paramString2);
    }
    if (aboi.a(paramLong, paramBoolean1, paramString1, paramString2))
    {
      QLog.i("cmgame_process.ApolloDataChannel", 1, "fetch uin by openId first.");
      return "{}";
    }
    paramString2 = abpc.b(paramLong, paramString1, paramString2);
    if (1 == aboi.a(paramLong, paramString1, paramString2, paramBoolean1)) {
      return "{}";
    }
    this.mCallJsRuntimeMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean2));
    ??? = paramString1.trim();
    Object localObject2 = new RequestRunable(this, paramLong, (String)???, paramString2);
    if (("cs.close_room.local".equals(???)) || ("cs.make_room_min.local".equals(???)) || ("cs.share_game_result.local".equals(???)) || ("cs.invite_friends.local".equals(paramString1)) || ("cs.send_b2c_redpacket.local".equals(paramString1)) || ("cs.qta_notify_test_result.local".equals(paramString1)) || ("cs.share_pic.local".equals(paramString1))) {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    for (;;)
    {
      return "{}";
      if (paramBoolean1) {
        this.mRequestHandlerThread.post((Runnable)localObject2);
      } else {
        synchronized (this.mRequestHandlers)
        {
          localObject2 = this.mRequestHandlers.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            abjp localabjp = ((a)((Iterator)localObject2).next()).a(paramLong, paramString1, paramString2);
            if (localabjp != null)
            {
              if (localabjp.bDr) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localabjp.bgF;
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  public void resumeMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.resumeMusic(paramInt, paramString);
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.seekTo(paramInt1, paramInt2);
    }
  }
  
  public void setActivityContext(Activity paramActivity)
  {
    if ((this.mSetNativeObj) && ((this.mActivityRef == null) || (this.mActivityRef.get() != paramActivity)))
    {
      this.mActivityRef = new WeakReference(paramActivity);
      synchronized (this.mRequestHandlers)
      {
        Iterator localIterator = this.mRequestHandlers.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.q(paramActivity))
          {
            locala.destroyHandler();
            localIterator.remove();
            QLog.d("cmgame_process.ApolloDataChannel", 1, "setActivityContext handler.checkReCreateOnActivityChanged:" + locala.getClass());
          }
        }
      }
      this.mRequestHandlers.add(new abjo(paramActivity, (QQAppInterface)this.mAppRef.get()));
      Collections.sort(this.mRequestHandlers, new abji(this));
      QLog.d("cmgame_process.ApolloDataChannel", 1, "setActivityContext activity: " + paramActivity);
    }
  }
  
  public void setMusicSwitch(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "[setMusicSwitch], switch:" + paramInt);
    }
    this.mPlayer = getRightPlayer();
    AppInterface localAppInterface = abmt.getAppInterface();
    if ((this.mPlayer != null) && (localAppInterface != null)) {
      this.mPlayer.a(paramInt, localAppInterface);
    }
  }
  
  public void setScreenMode(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("cmgame_process.ApolloDataChannel", 1, "[setScreenMode] " + paramInt1 + ",oldWidth:" + paramInt2 + ",oldHeight:" + paramInt3);
    Object localObject1 = ApolloRender.getRenderByThreadId();
    Object localObject2 = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject3 = abmt.b(((abjq)localObject2).getRuntimeState());
      } while ((localObject3 == null) || (localObject1 == null));
      localObject2 = ((abos)localObject3).a();
      localObject3 = ((abos)localObject3).c();
    } while ((localObject3 == null) || (localObject2 == null));
    int i = ((CmGameInitParams)localObject3).mViewMode + 1;
    QLog.i("cmgame_process.ApolloDataChannel", 1, "oldMode:" + i);
    if (((i == 1) && ((paramInt1 == 2) || (paramInt1 == 3))) || (((i == 2) || (i == 3)) && (paramInt1 == 1)))
    {
      localObject1 = ((ApolloRender)localObject1).getSavaWrapper();
      if (localObject1 != null) {
        ((ApolloEngine)localObject1).M(paramInt3 / aqgz.density, paramInt2 / aqgz.density);
      }
    }
    ((abpf)localObject2).HK(abpf.ga(paramInt1));
  }
  
  public void stopMusic(int paramInt, String paramString)
  {
    this.mPlayer = getRightPlayer();
    if (this.mPlayer != null) {
      this.mPlayer.stopMusic(paramInt, paramString);
    }
  }
  
  public void updateUserInfo(ably paramably)
  {
    int i = 0;
    while (i < this.mRequestHandlers.size())
    {
      if ((this.mRequestHandlers.get(i) instanceof aboc)) {
        ((aboc)this.mRequestHandlers.get(i)).updateUserInfo(paramably);
      }
      i += 1;
    }
  }
  
  static class PlayMusicTask
    implements Runnable
  {
    private final long NF;
    private final String bgC;
    private final int cpq;
    private WeakReference<abjq> ft;
    private WeakReference<abnm> fu;
    private WeakReference<ApolloCmdChannel> fv;
    private final int mCount;
    private int mGameId;
    private final int mType;
    private final float sm;
    
    PlayMusicTask(int paramInt1, ApolloCmdChannel paramApolloCmdChannel, abjq paramabjq, abnm paramabnm, long paramLong, int paramInt2, int paramInt3, String paramString, float paramFloat, int paramInt4)
    {
      this.fv = new WeakReference(paramApolloCmdChannel);
      this.ft = new WeakReference(paramabjq);
      this.fu = new WeakReference(paramabnm);
      this.mType = paramInt2;
      this.mCount = paramInt3;
      this.bgC = paramString;
      this.NF = paramLong;
      this.mGameId = paramInt1;
      this.cpq = paramInt4;
      this.sm = paramFloat;
    }
    
    public void run()
    {
      ApolloCmdChannel localApolloCmdChannel = (ApolloCmdChannel)this.fv.get();
      abjq localabjq = (abjq)this.ft.get();
      abnm localabnm = (abnm)this.fu.get();
      if ((localApolloCmdChannel == null) || (localabnm == null) || (localabjq == null) || (TextUtils.isEmpty(this.bgC))) {
        return;
      }
      localabnm.a(localabjq, this.mType, this.mCount, this.bgC, this.NF, this.cpq, this.sm);
    }
  }
  
  static class RequestRunable
    implements Runnable
  {
    private long NG;
    private String bgD;
    private WeakReference<ApolloCmdChannel> fw;
    private String mCmd;
    
    RequestRunable(ApolloCmdChannel paramApolloCmdChannel, long paramLong, String paramString1, String paramString2)
    {
      this.fw = new WeakReference(paramApolloCmdChannel);
      this.NG = paramLong;
      this.mCmd = paramString1;
      this.bgD = paramString2;
    }
    
    public void run()
    {
      if (this.fw == null) {}
      ApolloCmdChannel localApolloCmdChannel;
      do
      {
        return;
        localApolloCmdChannel = (ApolloCmdChannel)this.fw.get();
      } while ((localApolloCmdChannel == null) || (this.NG == -1L) || (TextUtils.isEmpty(this.mCmd)) || (TextUtils.isEmpty(this.bgD)));
      synchronized (localApolloCmdChannel.mRequestHandlers)
      {
        Iterator localIterator = localApolloCmdChannel.mRequestHandlers.iterator();
        while (localIterator.hasNext())
        {
          abjp localabjp = ((ApolloCmdChannel.a)localIterator.next()).a(this.NG, this.mCmd, this.bgD);
          if (localabjp != null)
          {
            if (localabjp.bDr) {
              localIterator.remove();
            }
            if (localabjp.bDs) {
              localApolloCmdChannel.callbackFromRequest(this.NG, 0, this.mCmd, localabjp.bgF);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract abjp a(long paramLong, String paramString1, String paramString2);
    
    public abstract void destroyHandler();
    
    public abstract boolean q(Activity paramActivity);
    
    public abstract int zz();
  }
  
  public static abstract interface b
  {
    public abstract void f(Bitmap paramBitmap, int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void BJ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel
 * JD-Core Version:    0.7.0.1
 */