package com.tencent.mobileqq.apollo.script;

import abix;
import abqt;
import abqy;
import abrc;
import abrg;
import abrj;
import abrq;
import acbh;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import aqgz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import wja;
import wki;
import wyk;
import xeh;

public class SpriteUIHandler
  implements abrq
{
  private SpriteVisibleRunnable a;
  private WeakReference<XListView> aw;
  private abrc c;
  private WeakReference<wki> fb;
  
  public SpriteUIHandler(abrc paramabrc)
  {
    this.c = paramabrc;
  }
  
  public static int an(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = wja.dp2px(46.0F, paramContext.getResources());
    }
    return Math.max(i, (int)((float)aqgz.hJ() / 7.0F / 2.84D) + 40);
  }
  
  private void au(long paramLong, int paramInt)
  {
    Object localObject2 = a();
    if (localObject2 == null) {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "adatper is null.");
    }
    label189:
    label204:
    label226:
    for (;;)
    {
      return;
      Object localObject1 = a();
      if (localObject1 != null)
      {
        int i = wja.a(paramLong, (ListAdapter)localObject2);
        if (i >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)((wki)localObject2).getItem(i);
          localObject2 = ((wki)localObject2).a.a(localChatMessage, (BaseAdapter)localObject2);
          ApolloItemBuilder localApolloItemBuilder;
          View localView;
          if (((localObject2 instanceof ApolloItemBuilder)) && ((localChatMessage instanceof MessageForApollo)))
          {
            localApolloItemBuilder = (ApolloItemBuilder)localObject2;
            i = wja.a(paramLong, ((XListView)localObject1).getAdapter());
            localView = wja.a((ListView)localObject1, i);
            if (!(localView instanceof BaseChatItemLayout)) {
              break label204;
            }
            localObject1 = (BaseChatItemLayout)wja.a((ListView)localObject1, i);
            if (paramInt != 1) {
              break label189;
            }
            localApolloItemBuilder.a((View)localObject1, (MessageForApollo)localChatMessage);
          }
          for (;;)
          {
            if ((!(localObject2 instanceof wyk)) || (!(localChatMessage instanceof MessageForApollo))) {
              break label226;
            }
            localObject1 = (wyk)localObject2;
            if (paramInt != 1) {
              break;
            }
            ((wyk)localObject1).b((MessageForApollo)localChatMessage);
            return;
            localApolloItemBuilder.b((View)localObject1, (MessageForApollo)localChatMessage);
            continue;
            if ((localView == null) && (paramInt == 1)) {
              localApolloItemBuilder.a(null, (MessageForApollo)localChatMessage);
            }
          }
        }
      }
    }
  }
  
  public void HU(int paramInt)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.4(this, paramInt));
  }
  
  public XListView a()
  {
    if (this.aw == null) {
      return null;
    }
    return (XListView)this.aw.get();
  }
  
  public wki a()
  {
    if (this.fb == null) {
      return null;
    }
    return (wki)this.fb.get();
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "[onTaskStart], msgId:", Long.valueOf(paramLong) });
    }
    paramSpriteTaskParam = new SpriteUIHandler.2(this, paramLong);
    ThreadManager.getUIHandler().post(paramSpriteTaskParam);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "[onTaskComplete], msgId:", Long.valueOf(paramLong), ",type:", Integer.valueOf(paramInt) });
    }
    paramSpriteTaskParam = new SpriteUIHandler.3(this, paramLong, paramInt);
    ThreadManager.getUIHandler().post(paramSpriteTaskParam);
  }
  
  public void b(XListView paramXListView, wki paramwki)
  {
    this.aw = new WeakReference(paramXListView);
    this.fb = new WeakReference(paramwki);
  }
  
  public void c(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (!abrj.f(paramQQAppInterface, paramInt, paramString))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], condition NOT meet.");
      return;
    }
    if (this.c.cqT == 1)
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label178;
      }
      bool = true;
      label38:
      j(bool, true, null);
      if (QLog.isColorLevel()) {
        if (paramInt != 0) {
          break label184;
        }
      }
    }
    label178:
    label184:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "isShow:", Boolean.valueOf(bool) });
      if (paramInt != 0) {
        break label190;
      }
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131690350), 1).show();
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_double_disappear_clk", this.c.mFriendUin, 0, 0, new String[] { Integer.toString(ApolloUtil.gi(this.c.mAioType)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      paramInt = 0;
      break;
      bool = false;
      break label38;
    }
    label190:
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { Integer.toString(ApolloUtil.gi(this.c.mAioType)), "0" });
  }
  
  public void d(int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUIHandler", 2, new Object[] { "[onActionDownloadNotify], downloadStatus:", Integer.valueOf(paramInt2), ",msgId:", Long.valueOf(paramLong) });
    }
    ThreadManager.getUIHandler().post(new SpriteUIHandler.1(this, paramLong, paramInt2, paramInt1));
  }
  
  public void gK(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.5(this, paramInt1, paramInt2));
  }
  
  public void j(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.a != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.a);
    }
    this.a = new SpriteVisibleRunnable(this.c, paramBoolean1, paramBoolean2, paramString);
    ThreadManager.getSubThreadHandler().post(this.a);
  }
  
  public void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.6(this, paramString));
  }
  
  static class SpriteVisibleRunnable
    implements Runnable
  {
    private boolean bEX;
    private boolean bEY;
    private abrc c;
    private String from;
    
    public SpriteVisibleRunnable(abrc paramabrc, boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      this.bEY = paramBoolean1;
      this.bEX = paramBoolean2;
      this.c = paramabrc;
      this.from = paramString;
    }
    
    public void run()
    {
      if (this.c == null)
      {
        QLog.e("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], mContext is null.");
        return;
      }
      Object localObject1;
      int i;
      if (this.bEX)
      {
        localObject1 = this.c;
        if (this.bEY)
        {
          i = 1;
          label37:
          ((abrc)localObject1).cqT = i;
          this.c.Ea(this.bEY);
        }
      }
      Object localObject2;
      for (;;)
      {
        localObject1 = this.c.a();
        localObject2 = this.c.getApp();
        if (localObject2 == null) {
          break;
        }
        QLog.d("cmshow_scripted_SpriteUIHandler", 1, new Object[] { "[showOrHideSprite], isHide:", Boolean.valueOf(this.bEY), ",from:", this.from, ",surfaceView:", localObject1, ",canInit:", Boolean.valueOf(this.c.bEU), ",isViweReady:", Boolean.valueOf(this.c.Zd()) });
        if (this.bEY) {
          break label367;
        }
        if ((localObject1 != null) || (this.c.bEU)) {
          break label220;
        }
        QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is going to be created in basechatpie, pls wait.");
        return;
        i = 0;
        break label37;
        if (this.from != null) {
          this.c.bw(this.from, this.bEY);
        }
      }
      label220:
      if ((localObject1 != null) && (!this.c.Zd()))
      {
        QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is being created but NOT yet ready, pls wait.");
        return;
      }
      Object localObject3 = this.c.d();
      if ((localObject3 != null) && (((BaseChatPie)localObject3).a != null) && (((BaseChatPie)localObject3).a.bGP))
      {
        QLog.i("cmshow_scripted_SpriteUIHandler", 1, "want to show apollo but AIO finish now");
        return;
      }
      if ((localObject1 != null) && (this.c.Zd())) {
        ((abrg)((QQAppInterface)localObject2).getManager(249)).dj(this.c.mFriendUin, this.c.mAioType);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new SpriteUIHandler.SpriteVisibleRunnable.1(this, (abix)localObject1));
        return;
        if ((localObject3 != null) && (this.c.bEU))
        {
          ((BaseChatPie)localObject3).OK();
          continue;
          label367:
          localObject3 = abrj.a((QQAppInterface)localObject2);
          if (localObject3 != null) {
            ((abqt)localObject3).HO(2);
          }
          localObject2 = ((abrg)((QQAppInterface)localObject2).getManager(249)).a();
          if (localObject2 != null) {
            ((abqy)localObject2).cEz();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler
 * JD-Core Version:    0.7.0.1
 */