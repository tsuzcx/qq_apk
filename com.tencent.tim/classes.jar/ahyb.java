import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.a;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class ahyb
  implements PanelIconLinearLayout.a, EmotionPanelListView.a
{
  public static int bQT;
  protected RichTextPanel a;
  protected int bQS;
  protected int cSk;
  private int cSl;
  protected QQAppInterface mApp;
  protected BaseChatPie mBaseChatPie;
  private float wb;
  
  public ahyb(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, RichTextPanel paramRichTextPanel)
  {
    this.mApp = paramQQAppInterface;
    this.mBaseChatPie = paramBaseChatPie;
    this.a = paramRichTextPanel;
    bQT = (int)(this.mApp.getApp().getResources().getDisplayMetrics().heightPixels * 0.6D);
    daA();
  }
  
  protected void Py(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { XPanelContainer.aLe, paramInt });
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new ahyd(this, paramInt));
    localValueAnimator.start();
  }
  
  public boolean R(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (!ajz()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      int i = (int)(paramMotionEvent.getY() - this.wb + 0.5F);
      j = XPanelContainer.aLe;
      XPanelContainer.aLe -= i;
      if (XPanelContainer.aLe > bQT) {
        XPanelContainer.aLe = bQT;
      }
      while (XPanelContainer.aLe != j)
      {
        AbstractGifImage.pauseAll();
        if (!(this.a.getParent() instanceof XPanelContainer)) {
          break;
        }
        this.a.getParent().requestLayout();
        break;
        if (XPanelContainer.aLe < this.bQS) {
          XPanelContainer.aLe = this.bQS;
        }
      }
      int k = XPanelContainer.aLe;
      if ((k != bQT) && (k != this.bQS))
      {
        if (k > this.cSl)
        {
          i = bQT;
          label176:
          if (Math.abs(k - this.cSl) > 100) {
            j = 1;
          }
          if (j == 0) {
            break label239;
          }
          label197:
          if ((j == 0) || (i != this.bQS)) {
            break label247;
          }
          if (QLog.isColorLevel()) {
            QLog.i("RichTextPanelExtendHelper", 2, "report panel close");
          }
        }
        for (;;)
        {
          Py(i);
          break;
          i = this.bQS;
          break label176;
          label239:
          i = this.cSl;
          break label197;
          label247:
          if ((j != 0) && (i == bQT) && (QLog.isColorLevel())) {
            QLog.i("RichTextPanelExtendHelper", 2, "report panel open");
          }
        }
      }
      AbstractGifImage.resumeAll();
    }
  }
  
  public boolean S(MotionEvent paramMotionEvent)
  {
    if (!ajz()) {}
    float f;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (this.a.getParent() == null);
      this.a.getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.wb = paramMotionEvent.getY();
      this.cSl = XPanelContainer.aLe;
      return false;
      f = paramMotionEvent.getY();
      i = (int)(f - this.wb + 0.5F);
    } while ((!ajx()) || (this.mBaseChatPie == null) || (this.mBaseChatPie.b == null) || (Math.abs(i) <= this.mBaseChatPie.b.getHeight() * 0.6F));
    this.wb = f;
    return true;
  }
  
  protected void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new ahyc(this));
    localValueAnimator.start();
  }
  
  boolean ajx()
  {
    return (this.mBaseChatPie != null) && (this.mBaseChatPie.a != null);
  }
  
  public boolean ajy()
  {
    return XPanelContainer.aLe == bQT;
  }
  
  protected boolean ajz()
  {
    return (bQT > this.bQS) && (ajx());
  }
  
  public boolean aox()
  {
    return XPanelContainer.aLe == this.bQS;
  }
  
  public void cZu()
  {
    if (!ajz()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.aLe != this.bQS);
      aM(200, XPanelContainer.aLe, bQT);
    } while (!QLog.isColorLevel());
    QLog.d("RichTextPanelExtendHelper", 2, "onPullUp");
  }
  
  public void cZv()
  {
    if (!ajz()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.aLe != bQT);
      aM(250, XPanelContainer.aLe, this.bQS);
    } while (!QLog.isColorLevel());
    QLog.d("RichTextPanelExtendHelper", 2, "onPullDown");
  }
  
  public void daA()
  {
    this.bQS = XPanelContainer.aLe;
    if (bQT > this.bQS) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onShow " + AppSetting.getRevision() + " init panelH " + this.bQS + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (ajx())
    {
      this.cSk = XPanelContainer.aLe;
      XPanelContainer.aLe = this.bQS;
    }
  }
  
  public void onShow()
  {
    if (ajx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onShow.");
      }
      this.cSk = 0;
      daA();
      if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null)) {
        this.mBaseChatPie.b.setInterceptListener(this);
      }
    }
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (ajx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanelExtendHelper", 2, "onHide. openSoftInput: " + paramBoolean + " mOriginPanelHeight: " + this.bQS + " mOldPanelHeight: " + this.cSk);
      }
      if (paramBoolean) {
        break label107;
      }
      XPanelContainer.aLe = this.bQS;
    }
    for (;;)
    {
      this.cSk = 0;
      if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null)) {
        this.mBaseChatPie.b.setInterceptListener(null);
      }
      return;
      label107:
      if (this.cSk != 0) {
        XPanelContainer.aLe = this.cSk;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyb
 * JD-Core Version:    0.7.0.1
 */