package com.tencent.mobileqq.activity.aio.item;

import ahei;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import wyw;
import wzw;

public class ArkFlashChatContainerWrapper
  extends wyw
{
  private static final List<WeakReference<ArkFlashChatContainerWrapper>> sa = Collections.synchronizedList(new ArrayList());
  private static final List<WeakReference<ArkFlashChatContainerWrapper>> sb = Collections.synchronizedList(new ArrayList());
  private ahei a = new wzw(this);
  public int bSD;
  public WeakReference<QQAppInterface> bT;
  public boolean bgF;
  private WeakReference<MessageForArkFlashChat> dX;
  
  public ArkFlashChatContainerWrapper()
  {
    this(true);
  }
  
  public ArkFlashChatContainerWrapper(boolean paramBoolean)
  {
    super(false);
    if (paramBoolean) {
      sa.add(new WeakReference(this));
    }
    for (;;)
    {
      this.bgF = paramBoolean;
      return;
      sb.add(new WeakReference(this));
    }
  }
  
  public static void Da(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format(Locale.CHINA, "doArkAppEventAIO type:%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    I(paramInt, sa);
  }
  
  public static void I(int paramInt, List<WeakReference<ArkFlashChatContainerWrapper>> paramList)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if ((localObject2 == null) || (((WeakReference)localObject2).get() == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAioContainerWrapper", 4, "doArkAppEvent.(item == null || item.get() == null)");
          }
          localIterator.remove();
          continue;
        }
        localObject2 = (ArkFlashChatContainerWrapper)((WeakReference)localObject2).get();
      }
      finally {}
      ((ArkFlashChatContainerWrapper)localObject2).doOnEvent(paramInt);
      if (paramInt == 2)
      {
        localObject2 = ((ArkFlashChatContainerWrapper)localObject2).dX;
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null)) {
          ((MessageForArkFlashChat)((WeakReference)localObject2).get()).arkContainer = null;
        }
      }
    }
    if (paramInt == 2) {
      paramList.clear();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, float paramFloat1, SessionInfo paramSessionInfo, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    this.bSD = paramInt;
    this.bT = new WeakReference(paramQQAppInterface);
    if (paramMessageForArkFlashChat != null) {
      this.dX = new WeakReference(paramMessageForArkFlashChat);
    }
    if (!super.a(paramString1, paramString2, paramString3, paramString4, paramFloat1, paramSessionInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAioContainerWrapper", 4, String.format("super.init return false!!! wrapper: %h.", new Object[] { this }));
      }
      return false;
    }
    setFixSize((int)paramFloat2, (int)paramFloat3);
    setMaxSize((int)paramFloat4, (int)paramFloat5);
    return true;
  }
  
  public void cdD()
  {
    this.mInit = false;
    this.mLoadFailed = false;
  }
  
  public String getConfigString()
  {
    if (this.dX == null) {
      return "";
    }
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)this.dX.get();
    if (localMessageForArkFlashChat == null) {
      return "";
    }
    return localMessageForArkFlashChat.ark_app_message.config;
  }
  
  public String getViewId()
  {
    if (this.dX == null) {
      return null;
    }
    MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)this.dX.get();
    if (localMessageForArkFlashChat == null) {
      return null;
    }
    String str = localMessageForArkFlashChat.getExtInfoFromExtStr("pa_msgId");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return String.valueOf(localMessageForArkFlashChat.uniseq);
  }
  
  public String hs(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    MessageForArkFlashChat localMessageForArkFlashChat;
    do
    {
      do
      {
        do
        {
          do
          {
            return str;
            str = paramString;
          } while (this.dX == null);
          localMessageForArkFlashChat = (MessageForArkFlashChat)this.dX.get();
          str = paramString;
        } while (localMessageForArkFlashChat == null);
        str = paramString;
      } while (localMessageForArkFlashChat.ark_app_message == null);
      str = paramString;
      if (localMessageForArkFlashChat.ark_app_message.appDesc != null) {
        str = paramString.replace("%APP_DESC%", localMessageForArkFlashChat.ark_app_message.appDesc).replace("$APP_DESC$", localMessageForArkFlashChat.ark_app_message.appDesc);
      }
      paramString = str;
      if (localMessageForArkFlashChat.ark_app_message.appName != null) {
        paramString = str.replace("%APP_NAME%", localMessageForArkFlashChat.ark_app_message.appName).replace("$APP_NAME$", localMessageForArkFlashChat.ark_app_message.appName);
      }
      str = paramString;
    } while (localMessageForArkFlashChat.ark_app_message.promptText == null);
    return paramString.replace("%PROMPT%", localMessageForArkFlashChat.ark_app_message.promptText).replace("$PROMPT$", localMessageForArkFlashChat.ark_app_message.promptText);
  }
  
  public boolean isLoadFailed()
  {
    return this.mLoadFailed;
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    paramAppInfo = getAppInterface();
    if (paramAppInfo == null)
    {
      this.mInit = false;
      this.mLoadFailed = true;
      if (this.mViewImpl != null) {
        this.mViewImpl.onLoadFailed(null, this.mErrorInfo.retCode, true);
      }
      return true;
    }
    this.mExtraTimerRecord.beginOfGetApp = System.currentTimeMillis();
    FlashChatManager localFlashChatManager = (FlashChatManager)paramAppInfo.getManager(217);
    String str = localFlashChatManager.i(this.bSD, this.mAppInfo.name, this.mAppInfo.appMinVersion);
    if (str != null)
    {
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkFlashChatContainerWrapper.1(this, str));
      return true;
    }
    if (this.mViewImpl != null) {
      this.mViewImpl.onLoading();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp", 2, String.format("request from url", new Object[] { this }));
    }
    paramAppInfo.registObserver(this.a);
    localFlashChatManager.OY(this.bSD);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.bgF) {}
    while ((this.mContainer == null) || (this.mContainer == null)) {
      return false;
    }
    float f = this.mAppInfo.scale;
    ArkDispatchTask.getInstance().post(this.mAppInfo.name, new TouchRunnable(paramMotionEvent, this.mContainer, f));
    return true;
  }
  
  class TouchRunnable
    implements Runnable
  {
    private int mAction;
    private ark.Container mContainer;
    private int[] mId;
    private float[] mX;
    private float[] mY;
    
    public TouchRunnable(MotionEvent paramMotionEvent, ark.Container paramContainer, float paramFloat)
    {
      this.mAction = paramMotionEvent.getActionMasked();
      this.mContainer = paramContainer;
      int i;
      if ((this.mAction != 5) && (this.mAction != 6))
      {
        int k = paramMotionEvent.getPointerCount();
        i = k;
        if (k > ark.arkGetMaxTouchPoints()) {
          i = ark.arkGetMaxTouchPoints();
        }
        this.mId = new int[i];
        this.mX = new float[i];
        this.mY = new float[i];
      }
      while (j < i)
      {
        this.mId[j] = paramMotionEvent.getPointerId(j);
        this.mX[j] = (paramMotionEvent.getX(j) / paramFloat);
        this.mY[j] = (paramMotionEvent.getY(j) / paramFloat);
        j += 1;
        continue;
        this.mId = new int[1];
        this.mX = new float[1];
        this.mY = new float[1];
        i = paramMotionEvent.getActionIndex();
        this.mId[0] = paramMotionEvent.getPointerId(i);
        this.mX[0] = (paramMotionEvent.getX(i) / paramFloat);
        this.mY[0] = (paramMotionEvent.getY(i) / paramFloat);
      }
    }
    
    public void run()
    {
      switch (this.mAction)
      {
      case 4: 
      default: 
        return;
      case 0: 
      case 5: 
        this.mContainer.TouchStart(this.mX, this.mY, this.mId, this.mId.length);
        return;
      case 1: 
      case 6: 
        Object localObject = (QQAppInterface)ArkFlashChatContainerWrapper.this.bT.get();
        MessageForArkFlashChat localMessageForArkFlashChat;
        if (localObject != null)
        {
          localObject = (FlashChatManager)((QQAppInterface)localObject).getManager(217);
          if (ArkFlashChatContainerWrapper.a(ArkFlashChatContainerWrapper.this) != null)
          {
            localMessageForArkFlashChat = (MessageForArkFlashChat)ArkFlashChatContainerWrapper.a(ArkFlashChatContainerWrapper.this).get();
            if ((localMessageForArkFlashChat != null) && (!((FlashChatManager)localObject).c(localMessageForArkFlashChat))) {
              break label164;
            }
          }
        }
        for (;;)
        {
          this.mContainer.TouchEnd(this.mX, this.mY, this.mId, this.mId.length);
          return;
          ((FlashChatManager)localObject).m(null);
          ((FlashChatManager)localObject).b(localMessageForArkFlashChat);
        }
      case 2: 
        label164:
        this.mContainer.TouchMove(this.mX, this.mY, this.mId, this.mId.length);
        return;
      }
      this.mContainer.TouchCancel(this.mX, this.mY, this.mId, this.mId.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper
 * JD-Core Version:    0.7.0.1
 */