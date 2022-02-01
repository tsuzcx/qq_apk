package com.tencent.mobileqq.emoticonview;

import acdz;
import afkr;
import afmf;
import afmk;
import afnu;
import afoo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class EmoticonMainPanel
  extends RelativeLayout
  implements EmotionPanelListView.a
{
  public static long XA;
  public View BO;
  private b a;
  public HorizontalListViewEx a;
  private EmoticonPanelController b = new EmoticonPanelController(paramContext, this);
  @Deprecated
  public boolean bYX = true;
  @Deprecated
  public boolean bYY;
  @Deprecated
  public boolean bYZ;
  @Deprecated
  public boolean bZa;
  @Deprecated
  public boolean bZb;
  @Deprecated
  public boolean bZc;
  public boolean bZd;
  public boolean bZe;
  public int cRX = -1;
  public int cdX = -1;
  public boolean isHiden;
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void x(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      if (paramInt == 1)
      {
        ThreadManagerV2.excute(new EmoticonMainPanel.1(paramQQAppInterface), 128, null, true);
        return;
      }
      localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      l = localSharedPreferences.getLong("last_get_recommendemotion_time_" + paramQQAppInterface.getCurrentUin(), 0L);
      paramInt = localSharedPreferences.getInt("recommendSeqinterval", 7200);
    } while (System.currentTimeMillis() - l < paramInt * 1000);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "sendRecommendSSORequest send req to recommend");
    }
    ((acdz)paramQQAppInterface.getBusinessHandler(12)).cIq();
    localSharedPreferences.edit().putLong("last_get_recommendemotion_time_" + paramQQAppInterface.getCurrentUin(), System.currentTimeMillis()).apply();
  }
  
  public void HW(boolean paramBoolean) {}
  
  public void Ia(String paramString)
  {
    this.b.Ia(paramString);
  }
  
  public void MC(int paramInt)
  {
    this.b.MC(paramInt);
  }
  
  public void MD(int paramInt)
  {
    this.b.MD(paramInt);
  }
  
  public void ME(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload begins.");
    }
    afkr.a().My(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  public EmoticonPanelController a()
  {
    return this.b;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramInt3, paramBaseChatPie, false, new a(null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie, boolean paramBoolean, afmk paramafmk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    new c(this, paramQQAppInterface, paramBaseChatPie, paramInt1).a(paramafmk).b(paramBoolean).a(paramString).b(paramInt3).a(paramInt2).a(this.bZc).c(this.bYX).d(this.bYY).e(this.bYZ).f(this.bZa).g(this.bZb).h(ajw()).show();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, false, new a(null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, new a(null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean, afmk paramafmk)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, paramafmk);
  }
  
  public boolean ajw()
  {
    return this.b.ajw();
  }
  
  public boolean ajx()
  {
    return this.b.ajx();
  }
  
  public boolean ajy()
  {
    return this.b.ajy();
  }
  
  public int cN(String paramString)
  {
    return this.b.cN(paramString);
  }
  
  public void cZu()
  {
    this.b.cZu();
  }
  
  public void cZv()
  {
    this.b.cZv();
  }
  
  public void dak()
  {
    this.b.dak();
  }
  
  public void dal()
  {
    this.b.dal();
  }
  
  public void dam()
  {
    this.b.dam();
  }
  
  public void dan()
  {
    this.b.dan();
  }
  
  public void dao()
  {
    this.b.dao();
  }
  
  public void dap()
  {
    this.b.dap();
  }
  
  public void daq()
  {
    this.b.daq();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      this.b.dispatchDraw(paramCanvas);
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("EmoticonMainPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.a != null) && (this.a.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void hO(int paramInt1, int paramInt2)
  {
    this.b.hO(paramInt1, paramInt2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.onAttachedToWindow();
  }
  
  public void onDestory()
  {
    this.b.onDestory();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = getParent();
    int i;
    if (localViewParent != null)
    {
      i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0) {
        break label35;
      }
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label35:
      if ((i == 1) || (i == 3)) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.b.daw();
  }
  
  public void onPause()
  {
    this.b.onPause();
  }
  
  public void onResume()
  {
    this.b.onResume();
  }
  
  public void onShow()
  {
    this.b.onShow();
  }
  
  public void preloadWebProcess()
  {
    this.b.preloadWebProcess();
  }
  
  public void setCallBack(afmf paramafmf)
  {
    this.b.setCallBack(paramafmf);
  }
  
  public void setDispatchKeyEventListener(b paramb)
  {
    this.a = paramb;
  }
  
  @Deprecated
  public void setEmoSettingVisibility(int paramInt)
  {
    this.b.setEmoSettingVisibility(paramInt);
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.b.setFilterSysFaceBeyond255Enable(paramBoolean);
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.b.setHideAllSettingTabs(paramBoolean);
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.b.setOnlySysEmotionEnable(paramBoolean);
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.b.setSysEmotionOrder(paramArrayOfInt);
  }
  
  public void setVisibility(int paramInt)
  {
    this.b.setVisibility(paramInt);
    super.setVisibility(paramInt);
  }
  
  public void yQ(boolean paramBoolean)
  {
    this.b.yQ(paramBoolean);
  }
  
  class a
    implements afmk
  {
    private a() {}
    
    public List<afoo> c(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean2) || (EmoticonMainPanel.a(EmoticonMainPanel.this).b.bZq)) {
        return afnu.h(EmoticonMainPanel.a(EmoticonMainPanel.this).app);
      }
      if (!paramBoolean1) {
        return afnu.g(EmoticonMainPanel.a(EmoticonMainPanel.this).app);
      }
      return afnu.a(EmoticonMainPanel.a(EmoticonMainPanel.this).app, EmoticonMainPanel.a(EmoticonMainPanel.this).businessType, EmoticonMainPanel.a(EmoticonMainPanel.this).bZn);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  }
  
  public static class c
  {
    private final EmoticonPanelController.a a;
    
    c(EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, int paramInt)
    {
      this.a = new EmoticonPanelController.a(paramEmoticonMainPanel);
      this.a.app = paramQQAppInterface;
      this.a.mBaseChatPie = paramBaseChatPie;
      this.a.sessionType = paramInt;
    }
    
    public c a(int paramInt)
    {
      this.a.cSg = paramInt;
      return this;
    }
    
    public c a(afmk paramafmk)
    {
      this.a.b = paramafmk;
      return this;
    }
    
    public c a(String paramString)
    {
      this.a.aLB = paramString;
      return this;
    }
    
    public c a(boolean paramBoolean)
    {
      this.a.bZc = paramBoolean;
      return this;
    }
    
    public c b(int paramInt)
    {
      this.a.bED = paramInt;
      return this;
    }
    
    public c b(boolean paramBoolean)
    {
      this.a.bZn = paramBoolean;
      return this;
    }
    
    public c c(boolean paramBoolean)
    {
      this.a.bYX = paramBoolean;
      return this;
    }
    
    public c d(boolean paramBoolean)
    {
      this.a.bYY = paramBoolean;
      return this;
    }
    
    public c e(boolean paramBoolean)
    {
      this.a.bYZ = paramBoolean;
      return this;
    }
    
    public c f(boolean paramBoolean)
    {
      this.a.bZa = paramBoolean;
      return this;
    }
    
    public c g(boolean paramBoolean)
    {
      this.a.bZb = paramBoolean;
      return this;
    }
    
    public c h(boolean paramBoolean)
    {
      this.a.bZr = paramBoolean;
      return this;
    }
    
    void show()
    {
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */