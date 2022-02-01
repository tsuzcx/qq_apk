package com.tencent.mobileqq.apollo;

import abhh;
import abiz;
import abvg;
import abvh;
import abvo;
import acfp;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApolloRenderDriver
  implements Handler.Callback
{
  abiz jdField_a_of_type_Abiz;
  auru jdField_a_of_type_Auru;
  public ApolloEngine a;
  private RenderRunnable jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver$RenderRunnable;
  public AtomicInteger aS = new AtomicInteger(1);
  private AtomicBoolean ck = new AtomicBoolean(false);
  public AtomicBoolean cl = new AtomicBoolean(false);
  private WeakReference<a> fh;
  int mFrameNum = 20;
  public int mGameId;
  ReentrantLock mLock;
  
  public ApolloRenderDriver(abiz paramabiz, ApolloEngine paramApolloEngine)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[ApolloRenderDriver] constructor.");
    }
    if (paramApolloEngine == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_Abiz = paramabiz;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine = paramApolloEngine;
    this.jdField_a_of_type_Auru = new auru(ThreadManager.getSubThreadLooper(), this);
    this.mLock = abvh.a().a();
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver$RenderRunnable = new RenderRunnable(this);
    this.ck.set(true);
  }
  
  public void BH(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "[exejsOnEngine jsStr]");
      }
      a(new ApolloRenderDriver.11(this, paramString));
    }
  }
  
  public int a(int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onSetActions], actionId:" + paramInt1);
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length != 2)) {
      return 1;
    }
    a(new ApolloRenderDriver.1(this, paramInt1, paramInt2, paramArrayOfString1, paramArrayOfString2));
    return 0;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, new Object[] { "[onLoadRole] apolloId=", paramString, ", roleType=", Integer.valueOf(paramInt1), ", roleId:" + paramInt2 });
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ApolloUtil.du(paramInt1);
    }
    paramString = abvg.a(str, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    if (TextUtils.isEmpty(paramString)) {
      return 1;
    }
    a(new RenderThreadRunnable(paramString, this.mLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
    return 0;
  }
  
  public int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, new Object[] { "[onExecAction] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt2) });
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtil.du(paramInt1);
    }
    paramString1 = abvg.a(str, paramInt2, paramInt3, paramString2, paramString3);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "errInfo->luaParam is null.");
      }
      return 1;
    }
    a(new ApolloRenderDriver.4(this, paramString1));
    return 0;
  }
  
  public int a(int paramInt, String paramString, int[] paramArrayOfInt, abvo paramabvo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onChangeDress], roleType:" + paramInt);
    }
    if (paramArrayOfInt == null) {}
    do
    {
      return 1;
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = ApolloUtil.du(paramInt);
      }
      paramString = abvg.a(str, paramArrayOfInt);
    } while (paramString == null);
    a(new ApolloRenderDriver.5(this, paramString, paramabvo));
    return 0;
  }
  
  public void a(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((paramIApolloRunnableTask == null) || (this.jdField_a_of_type_Abiz == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Abiz instanceof ApolloSurfaceView))
      {
        ((ApolloSurfaceView)this.jdField_a_of_type_Abiz).runRenderTask(paramIApolloRunnableTask);
        return;
      }
    } while (!(this.jdField_a_of_type_Abiz instanceof ApolloTextureView));
    ((ApolloTextureView)this.jdField_a_of_type_Abiz).queueEvent(paramIApolloRunnableTask);
  }
  
  public void aNu()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[startLoop]. mIsLoopStart:" + this.cl.get());
    }
    if ((this.jdField_a_of_type_Auru != null) && (this.ck.get()))
    {
      this.jdField_a_of_type_Auru.removeMessages(15);
      if (!this.cl.get())
      {
        QLog.d("ApolloRenderDriver", 2, "[startLoop]. ticker Loop: gameId=" + this.mGameId + " view=" + this.jdField_a_of_type_Abiz);
        a(new ApolloRenderDriver.2(this));
        this.cl.set(true);
      }
    }
  }
  
  public int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, new Object[] { "[onAddBubble] bubbleType=", Integer.valueOf(paramInt1), ", apolloId=", paramString1, ", roleType=", Integer.valueOf(paramInt2), ", text=", paramString2, ", roleId=", Integer.valueOf(paramInt3), ", uin=", paramString3 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    paramString2 = paramString2.replace("\\", "").replace("'", "");
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    Object localObject1 = Pattern.compile("\t|\r|\n").matcher(paramString2);
    if (localObject1 != null) {
      paramString2 = ((Matcher)localObject1).replaceAll("");
    }
    for (;;)
    {
      int i = paramString2.length();
      localObject1 = null;
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface)) {
        localObject1 = (QQAppInterface)localObject2;
      }
      if ((1 == paramInt1) && (localObject1 != null))
      {
        localObject2 = (abhh)((QQAppInterface)localObject1).getManager(153);
        if (paramString3.equals(((QQAppInterface)localObject1).getCurrentAccountUin()))
        {
          paramString2 = acfp.m(2131702660);
          if ((localObject2 != null) && (((abhh)localObject2).jl(paramString3))) {
            if ((1 == paramInt2) && ((ApolloUtil.aJ(0, 28)) || (ApolloUtil.aJ(paramInt3, 28)))) {
              paramInt1 = 28;
            }
          }
        }
      }
      for (;;)
      {
        if ((!ApolloUtil.aJ(paramInt3, paramInt1)) && (!ApolloUtil.aJ(0, paramInt1)))
        {
          return 2;
          paramString3 = paramString2;
          if (2 == paramInt2) {
            if (!ApolloUtil.aJ(0, 27))
            {
              paramString3 = paramString2;
              if (!ApolloUtil.aJ(paramInt3, 27)) {}
            }
            else
            {
              paramInt1 = 27;
              continue;
              paramInt1 = 25;
              continue;
              if ((localObject2 != null) && (((abhh)localObject2).jl(paramString3)))
              {
                if ((1 == paramInt2) && ((ApolloUtil.aJ(0, 30)) || (ApolloUtil.aJ(paramInt3, 30))))
                {
                  paramInt1 = 30;
                  continue;
                }
                paramString3 = paramString2;
                if (2 == paramInt2) {
                  if (!ApolloUtil.aJ(0, 29))
                  {
                    paramString3 = paramString2;
                    if (!ApolloUtil.aJ(paramInt3, 29)) {}
                  }
                  else
                  {
                    paramInt1 = 29;
                  }
                }
              }
              else
              {
                paramInt1 = 26;
                continue;
                if ((paramInt1 == 0) || (8 == paramInt1))
                {
                  paramInt1 = ApolloUtil.b(208.0F, paramString2, 1);
                  continue;
                }
                if (2 == paramInt1)
                {
                  paramString3 = paramString2;
                  if (i > 8) {
                    paramString3 = paramString2.substring(0, 7) + "…";
                  }
                  paramInt1 = 16;
                  paramString2 = paramString3;
                  continue;
                }
                if (3 == paramInt1)
                {
                  paramInt1 = 32;
                  continue;
                }
                if (4 == paramInt1)
                {
                  paramInt1 = ApolloUtil.c(157.0F, paramString2);
                  continue;
                }
                if (5 == paramInt1)
                {
                  paramInt1 = 40;
                  continue;
                }
                if (6 == paramInt1)
                {
                  paramInt1 = 33;
                  continue;
                }
                if (7 == paramInt1)
                {
                  paramInt1 = 32;
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloRenderDriver", 2, "Other bubble type, NOT Handle.");
                }
                return 1;
              }
            }
          }
        }
        else
        {
          paramString3 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramString3 = ApolloUtil.du(paramInt2);
          }
          paramString1 = abvg.a(paramString3, paramInt1, paramInt3, paramString2);
          if (TextUtils.isEmpty(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloRenderDriver", 2, "errInfo->luaParam is NULL.");
            }
            return 1;
          }
          a(new RenderThreadRunnable(paramString1, this.mLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
          return 0;
        }
        paramInt1 = 0;
        paramString2 = paramString3;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 15) {
      stopLoop();
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onDestroy]");
    }
    stopLoop();
    if (this.jdField_a_of_type_Auru != null)
    {
      this.jdField_a_of_type_Auru.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Auru = null;
      if (this.ck != null) {
        this.ck.set(false);
      }
    }
  }
  
  public void onEnterGame(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onEnterGame], luaFilePath:" + paramString);
    }
    a(new ApolloRenderDriver.9(this, paramString));
  }
  
  public void onExecDispose()
  {
    a(new RenderThreadRunnable("dispose();", this.mLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public void onExecDispose(String paramString)
  {
    a(new RenderThreadRunnable(String.format("if(%s){%s.removeFromParent();%s.dispose();}", new Object[] { paramString, paramString, paramString }), this.mLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public void setGameStatListener(a parama)
  {
    if (parama == null) {
      return;
    }
    this.fh = new WeakReference(parama);
  }
  
  public void stopLoop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[stopLoop].");
    }
    if ((this.jdField_a_of_type_Auru != null) && (this.cl.get()))
    {
      this.jdField_a_of_type_Auru.removeMessages(15);
      a(new ApolloRenderDriver.3(this));
      this.cl.set(false);
    }
  }
  
  public void stopLoopDelayed(long paramLong)
  {
    if (this.jdField_a_of_type_Auru != null)
    {
      this.jdField_a_of_type_Auru.removeMessages(15);
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(15, paramLong);
    }
  }
  
  public void u(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onRemoveBubble], roleType" + paramInt + ",bubbleName:" + paramString2);
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtil.du(paramInt);
    }
    a(new RenderThreadRunnable(abvg.aH(str, paramString2), this.mLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  static class RenderRunnable
    implements Runnable
  {
    private WeakReference<ApolloRenderDriver> fi;
    
    public RenderRunnable(ApolloRenderDriver paramApolloRenderDriver)
    {
      this.fi = new WeakReference(paramApolloRenderDriver);
    }
    
    public void run()
    {
      ApolloRenderDriver localApolloRenderDriver;
      if ((this.fi != null) && (this.fi.get() != null))
      {
        localApolloRenderDriver = (ApolloRenderDriver)this.fi.get();
        if ((localApolloRenderDriver != null) && (localApolloRenderDriver.jdField_a_of_type_Abiz != null) && (localApolloRenderDriver.jdField_a_of_type_Auru != null))
        {
          localApolloRenderDriver.jdField_a_of_type_Abiz.onRender();
          if (((ApolloRenderDriver)this.fi.get()).mFrameNum <= 0) {
            break label101;
          }
        }
      }
      label101:
      for (int i = 1000 / ((ApolloRenderDriver)this.fi.get()).mFrameNum;; i = 50)
      {
        localApolloRenderDriver.jdField_a_of_type_Auru.postDelayed(this, i);
        return;
      }
    }
  }
  
  class RenderThreadRunnable
    extends IApolloRunnableTask
  {
    private String bgp;
    WeakReference<ApolloEngine> mEngineRef = null;
    private ReentrantLock mLock;
    
    public RenderThreadRunnable(String paramString, ReentrantLock paramReentrantLock, ApolloEngine paramApolloEngine)
    {
      this.bgp = paramString;
      this.mLock = paramReentrantLock;
      this.mEngineRef = new WeakReference(paramApolloEngine);
    }
    
    public String aV()
    {
      return "RenderThreadRunnable";
    }
    
    public void run()
    {
      this.mLock.lock();
      try
      {
        ApolloEngine localApolloEngine = (ApolloEngine)this.mEngineRef.get();
        if (localApolloEngine != null)
        {
          QLog.d("ApolloRenderDriver", 2, "run js =" + this.bgp);
          localApolloEngine.BA(this.bgp);
          if (!ApolloRenderDriver.this.cl.get()) {
            localApolloEngine.x(0.0D);
          }
        }
        return;
      }
      finally
      {
        this.mLock.unlock();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void cCb();
    
    public abstract void gQ(long paramLong);
    
    public abstract void gR(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver
 * JD-Core Version:    0.7.0.1
 */