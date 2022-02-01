package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import zno;
import znq;
import zns;

public class MiniMsgUser
  implements Handler.Callback, View.OnClickListener
{
  public static final int MSG_HIDE_ENTRY = 4;
  public static final int MSG_HIDE_UNREAD = 3;
  public static final int MSG_SHOW_ENTRY = 0;
  public static final int MSG_UPDATE_UNREAD_GET = 2;
  public static final int MSG_UPDATE_UNREAD_SYNC = 1;
  public static final String TAG = "mini_msg_User";
  private Activity mActivity;
  private boolean mIsAttach;
  private AtomicBoolean mIsDetroy = new AtomicBoolean();
  private MiniMsgUserParam mMiniMsgUserParam;
  private MqqHandler mUIHandler;
  
  public MiniMsgUser(Activity paramActivity, MiniMsgUserParam paramMiniMsgUserParam)
  {
    this.mActivity = paramActivity;
    this.mMiniMsgUserParam = paramMiniMsgUserParam;
    if (this.mMiniMsgUserParam.accessType == 0)
    {
      int n = paramMiniMsgUserParam.filterMsgType;
      int k = paramMiniMsgUserParam.positionX;
      int m = paramMiniMsgUserParam.positionY;
      int i1 = paramMiniMsgUserParam.colorType;
      int i2 = paramMiniMsgUserParam.entryType;
      int i3 = paramMiniMsgUserParam.businessName;
      int j = k;
      int i = m;
      if (this.mMiniMsgUserParam.entryType == 0)
      {
        paramMiniMsgUserParam = MiniMsgIPCClient.getInstance().getBusinessInfo(i3);
        j = k;
        i = m;
        if (paramMiniMsgUserParam != null)
        {
          j = k;
          i = m;
          if (paramMiniMsgUserParam.brJ)
          {
            j = k;
            i = m;
            if (paramMiniMsgUserParam.positionX > 0)
            {
              j = paramMiniMsgUserParam.positionX;
              i = paramMiniMsgUserParam.positionY;
            }
          }
        }
      }
      this.mMiniMsgUserParam.unreadCallback = new znq(paramActivity, n, i2, i1, j, i, this);
    }
    for (;;)
    {
      this.mUIHandler = new MqqHandler(Looper.getMainLooper(), this);
      return;
      if (this.mMiniMsgUserParam.accessType == 1)
      {
        if (this.mMiniMsgUserParam.entryView != null) {
          this.mMiniMsgUserParam.entryView.setOnClickListener(this);
        }
        if (this.mMiniMsgUserParam.unreadCallback == null) {
          this.mMiniMsgUserParam.unreadCallback = new zno(this.mMiniMsgUserParam.entryView, this.mMiniMsgUserParam.unreadView);
        }
      }
    }
  }
  
  public static void clear() {}
  
  public void destroy()
  {
    this.mIsDetroy.set(true);
    this.mMiniMsgUserParam.unreadCallback.destroy();
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mActivity = null;
  }
  
  public IMiniMsgActionCallback getActionCallback()
  {
    if (this.mMiniMsgUserParam != null) {
      return this.mMiniMsgUserParam.actionCallback;
    }
    return null;
  }
  
  public MiniMsgUserParam getParam()
  {
    return this.mMiniMsgUserParam;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    int j = 0;
    if (this.mIsDetroy.get()) {}
    int k;
    zns localzns;
    IMiniMsgUnreadCallback localIMiniMsgUnreadCallback;
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("mini_msg_User", 2, "msg_what = " + paramMessage.what);
        }
        k = paramMessage.arg1;
        localzns = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
      } while (localzns == null);
      localIMiniMsgUnreadCallback = this.mMiniMsgUserParam.unreadCallback;
    } while (localIMiniMsgUnreadCallback == null);
    if ((this.mMiniMsgUserParam.accessType == 0) && ((this.mMiniMsgUserParam.entryType == 0) || (this.mMiniMsgUserParam.entryType == 1))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool1;
      switch (paramMessage.what)
      {
      default: 
      case 0: 
        for (;;)
        {
          return true;
          i = j;
          if (localzns.brJ)
          {
            i = j;
            if (localzns.brI) {
              i = localzns.unreadCount;
            }
          }
          this.mIsAttach = localIMiniMsgUnreadCallback.show(i);
          localzns.brJ = this.mIsAttach;
        }
      case 1: 
        if ((i != 0) && (!localzns.brJ))
        {
          this.mIsAttach = localIMiniMsgUnreadCallback.show(k);
          localzns.brJ = this.mIsAttach;
        }
        for (;;)
        {
          localzns.brI = true;
          localzns.unreadCount = k;
          break;
          localIMiniMsgUnreadCallback.updateUnreadCount(k, false);
        }
      case 2: 
        if (!localzns.brI)
        {
          bool1 = true;
          label290:
          if (i != 0) {
            break label388;
          }
          if (k > 0) {
            break label330;
          }
          bool1 = bool2;
        }
        break;
      }
      label388:
      for (;;)
      {
        localIMiniMsgUnreadCallback.updateUnreadCount(k, bool1);
        localzns.unreadCount = k;
        break;
        bool1 = false;
        break label290;
        label330:
        localzns.unreadCount = k;
        return true;
        localIMiniMsgUnreadCallback.hideUnread();
        localzns.brI = false;
        break;
        localzns.brJ = false;
        localzns.brI = false;
        this.mIsAttach = false;
        localzns.unreadCount = 0;
        localIMiniMsgUnreadCallback.hide();
        break;
      }
    }
  }
  
  public void hideEntry()
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    this.mUIHandler.obtainMessage(4).sendToTarget();
  }
  
  public void hideUnread()
  {
    this.mUIHandler.obtainMessage(3).sendToTarget();
  }
  
  public void notifyFromMiniAIOToAIO()
  {
    if ((this.mMiniMsgUserParam != null) && (this.mMiniMsgUserParam.actionCallback != null)) {
      this.mMiniMsgUserParam.actionCallback.onFromMiniAIOToAIO();
    }
  }
  
  public void notifyGoToConversation()
  {
    if ((this.mMiniMsgUserParam != null) && (this.mMiniMsgUserParam.actionCallback != null)) {
      this.mMiniMsgUserParam.actionCallback.onGoToConversation();
    }
  }
  
  public void onBackground()
  {
    if (this.mMiniMsgUserParam != null)
    {
      if ((this.mMiniMsgUserParam.accessType == 0) && (this.mMiniMsgUserParam.entryType == 0))
      {
        zns localzns = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
        if (localzns != null)
        {
          int[] arrayOfInt = ((znq)this.mMiniMsgUserParam.unreadCallback).L();
          if (arrayOfInt != null)
          {
            localzns.positionX = arrayOfInt[0];
            localzns.positionY = arrayOfInt[1];
          }
        }
      }
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessBackground(this.mMiniMsgUserParam.businessName);
      MiniMsgIPCClient.getInstance().removetMiniUser(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mMiniMsgUserParam == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mMiniMsgUserParam.actionCallback != null) {
        this.mMiniMsgUserParam.actionCallback.onOpenMiniAIOCallback();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_mini_need_update_unread", true);
      localIntent.putExtra("key_mini_msgtab_businame", this.mMiniMsgUserParam.businessName);
      localIntent.putExtra("key_mini_msgtab_type", this.mMiniMsgUserParam.filterMsgType);
      localIntent.putExtra("key_mini_msgtab_need_full_screen", this.mMiniMsgUserParam.isNeedFullScreen);
      localIntent.putExtra("key_mini_msgtab_isneed_back_conversation", this.mMiniMsgUserParam.isNeedBackConversation);
      if (this.mMiniMsgUserParam.isNeedBackConversation) {
        localIntent.putExtra("key_mini_msgtab_back_pending_intent", this.mMiniMsgUserParam.backConversationIntent);
      }
      MiniChatActivity.e(this.mActivity, localIntent, this.mMiniMsgUserParam.requestCode);
      hideUnread();
    }
  }
  
  public void onForeground()
  {
    if (this.mMiniMsgUserParam != null)
    {
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.register(this.mMiniMsgUserParam.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
      MiniMsgIPCClient.getInstance().setMiniUser(this);
      MiniMsgIPCClient.getInstance().syncGetUnread();
      MiniMsgIPCClient.getInstance();
      MiniMsgIPCClient.onProcessForeGround(this.mMiniMsgUserParam.businessName);
    }
  }
  
  public void showEntry()
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    this.mUIHandler.obtainMessage(0).sendToTarget();
  }
  
  public void showOnFirst()
  {
    if ((this.mMiniMsgUserParam != null) && (this.mMiniMsgUserParam.accessType == 0))
    {
      zns localzns = MiniMsgIPCClient.getInstance().getBusinessInfo(this.mMiniMsgUserParam.businessName);
      if ((localzns != null) && (localzns.brJ) && (!this.mIsAttach))
      {
        this.mUIHandler.obtainMessage(0).sendToTarget();
        MiniMsgIPCClient.getInstance().syncGetUnread();
      }
    }
  }
  
  public void updateUnreadCountGet(int paramInt)
  {
    if (this.mIsDetroy.get()) {
      return;
    }
    int j = 2;
    int i = j;
    if (paramInt == 0)
    {
      i = j;
      if (this.mMiniMsgUserParam.accessType == 0)
      {
        if (this.mMiniMsgUserParam.entryType != 0) {
          break label65;
        }
        i = 4;
      }
    }
    for (;;)
    {
      Message localMessage = this.mUIHandler.obtainMessage(i);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
      return;
      label65:
      i = j;
      if (this.mMiniMsgUserParam.entryType == 1) {
        i = 3;
      }
    }
  }
  
  public void updateUnreadCountSync(int paramInt)
  {
    int j = 1;
    if (this.mIsDetroy.get()) {
      return;
    }
    int i = j;
    if (paramInt == 0)
    {
      i = j;
      if (this.mMiniMsgUserParam.accessType == 0)
      {
        if (this.mMiniMsgUserParam.entryType != 0) {
          break label65;
        }
        i = 4;
      }
    }
    for (;;)
    {
      Message localMessage = this.mUIHandler.obtainMessage(i);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
      return;
      label65:
      i = j;
      if (this.mMiniMsgUserParam.entryType == 1) {
        i = 3;
      }
    }
  }
  
  public void updateWhenBackFromMiniChat(int paramInt)
  {
    if ((paramInt == 0) && (this.mMiniMsgUserParam.accessType == 0) && (this.mMiniMsgUserParam.entryType == 0)) {
      this.mUIHandler.obtainMessage(4).sendToTarget();
    }
  }
  
  public static abstract interface IMiniMsgActionCallback
  {
    public abstract void onFromMiniAIOToAIO();
    
    public abstract void onGoToConversation();
    
    public abstract void onOpenMiniAIOCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgUser
 * JD-Core Version:    0.7.0.1
 */