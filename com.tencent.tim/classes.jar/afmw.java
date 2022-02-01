import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController.a;
import com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.4;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView.a;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class afmw
  extends aflk
  implements PanelIconLinearLayout.a, EmotionPanelListView.a
{
  private static int bQT;
  private QQAppInterface app;
  private int bQS;
  private int cSk;
  private int cSl;
  private EmoticonMainPanel f;
  private TextWatcher textWatcher = new afmz(this);
  private float wb;
  
  public afmw(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void Ib(String paramString)
  {
    afoo localafoo;
    if ((this.a.zZ != null) && (EmoticonPanelController.cSe >= 0) && (EmoticonPanelController.cSe < this.a.zZ.size()))
    {
      localafoo = (afoo)this.a.zZ.get(EmoticonPanelController.cSe);
      if (localafoo.type != 7) {
        break label88;
      }
      anot.a(this.app, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    label88:
    do
    {
      return;
      if (localafoo.type == 4)
      {
        anot.a(this.app, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
        return;
      }
      if (localafoo.type == 11)
      {
        anot.a(this.app, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
        return;
      }
      if (localafoo.type == 8)
      {
        anot.a(this.app, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
        return;
      }
      if (localafoo.type == 10)
      {
        anot.a(this.app, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
        return;
      }
    } while ((localafoo.type != 9) && (localafoo.type != 6));
    anot.a(this.app, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
  }
  
  private void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new afmy(this, paramInt3));
    localValueAnimator.start();
  }
  
  private boolean ajz()
  {
    return (bQT > this.bQS) && (ajx());
  }
  
  public int[] C()
  {
    return new int[] { 10, 9, 4, 5, 1, 3 };
  }
  
  public int Di()
  {
    return bQT - this.bQS;
  }
  
  public void HY(boolean paramBoolean)
  {
    afll localafll = a();
    if (localafll != null) {
      ((afnm)localafll.a().getOnScrollListener()).Ia(paramBoolean);
    }
  }
  
  protected void Ic(String paramString)
  {
    Object localObject = this.a.a;
    List localList = this.a.zZ;
    if ((localObject != null) && (localList != null) && (EmoticonPanelController.cSe >= 0) && (EmoticonPanelController.cSe < localList.size()))
    {
      localObject = ((EmotionPanelViewPagerAdapter)localObject).a(EmoticonPanelController.cSe);
      if (localObject != null)
      {
        HY(true);
        if (!TextUtils.isEmpty(paramString)) {
          break label91;
        }
      }
    }
    label91:
    for (int i = 8;; i = 0)
    {
      ((ImageButton)localObject).setVisibility(i);
      ((ImageButton)localObject).post(new EmoticonPanelExtendHelper.4(this));
      return;
    }
  }
  
  public boolean R(MotionEvent paramMotionEvent)
  {
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
      int j = XPanelContainer.aLe;
      XPanelContainer.aLe -= i;
      if (XPanelContainer.aLe > bQT) {
        XPanelContainer.aLe = bQT;
      }
      while (XPanelContainer.aLe != j)
      {
        AbstractGifImage.pauseAll();
        if (!(this.f.getParent() instanceof XPanelContainer)) {
          break;
        }
        this.f.getParent().requestLayout();
        break;
        if (XPanelContainer.aLe < this.bQS) {
          XPanelContainer.aLe = this.bQS;
        }
      }
      j = XPanelContainer.aLe;
      if ((j != bQT) && (j != this.bQS))
      {
        if (j > this.cSl)
        {
          i = bQT;
          label172:
          if (Math.abs(j - this.cSl) <= 100) {
            break label277;
          }
          j = 1;
          label188:
          if (j == 0) {
            break label282;
          }
          label192:
          if ((j == 0) || (i != this.bQS)) {
            break label290;
          }
          Ib("0X800A847");
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonPanelExtendHelper", 2, "report panel close");
          }
        }
        for (;;)
        {
          paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.aLe, i });
          paramMotionEvent.setDuration(150L);
          paramMotionEvent.addUpdateListener(new afmx(this, i));
          paramMotionEvent.start();
          break;
          i = this.bQS;
          break label172;
          label277:
          j = 0;
          break label188;
          label282:
          i = this.cSl;
          break label192;
          label290:
          if ((j != 0) && (i == bQT))
          {
            Ib("0X800A846");
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonPanelExtendHelper", 2, "report panel open");
            }
          }
        }
      }
      AbstractGifImage.resumeAll();
    }
  }
  
  public boolean S(MotionEvent paramMotionEvent)
  {
    if (!ajz()) {}
    float f1;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (this.a.b().getParent() == null);
      this.a.b().getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.wb = paramMotionEvent.getY();
      this.cSl = XPanelContainer.aLe;
      return false;
      f1 = paramMotionEvent.getY();
      i = (int)(f1 - this.wb + 0.5F);
    } while ((!ajx()) || (this.a.mBaseChatPie == null) || (this.a.mBaseChatPie.b == null) || (Math.abs(i) <= this.a.mBaseChatPie.b.getHeight() * 0.6F));
    this.wb = f1;
    return true;
  }
  
  protected afll a()
  {
    if ((this.a.a != null) && (this.a.zZ != null) && (EmoticonPanelController.cSe >= 0) && (EmoticonPanelController.cSe < this.a.zZ.size()))
    {
      Object localObject = (afoo)this.a.zZ.get(EmoticonPanelController.cSe);
      localObject = this.a.a.a((afoo)localObject);
      if ((localObject != null) && (((afll)localObject).a() != null) && ((((afll)localObject).a().getOnScrollListener() instanceof afnm))) {
        return localObject;
      }
    }
    return null;
  }
  
  protected void abordFling()
  {
    if ((this.a.a != null) && (this.a.zZ != null) && (EmoticonPanelController.cSe >= 0) && (EmoticonPanelController.cSe < this.a.zZ.size()))
    {
      Object localObject = (afoo)this.a.zZ.get(EmoticonPanelController.cSe);
      localObject = this.a.a.a((afoo)localObject);
      if ((localObject != null) && (((afll)localObject).a() != null)) {
        ((afll)localObject).a().abordFling();
      }
    }
  }
  
  public boolean ajx()
  {
    return (this.a.mBaseChatPie != null) && (!this.a.b.bZn) && (this.a.mBaseChatPie.a != null);
  }
  
  public boolean ajy()
  {
    return XPanelContainer.aLe == bQT;
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
      Ib("0X800A846");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelExtendHelper", 2, "onPullUp");
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
      Ib("0X800A847");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelExtendHelper", 2, "onPullDown");
  }
  
  public void daA()
  {
    this.bQS = XPanelContainer.aLe;
    if (bQT > this.bQS) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onShow " + AppSetting.getRevision() + " init panelH " + this.bQS + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  public void dae()
  {
    this.app = this.a.app;
    this.f = this.a.b();
    bQT = (int)(this.app.getApp().getResources().getDisplayMetrics().heightPixels * 0.6D);
  }
  
  public void daz()
  {
    afll localafll = a();
    if (localafll != null) {
      ((afnm)localafll.a().getOnScrollListener()).m(localafll.a());
    }
  }
  
  public void onAttachedToWindow()
  {
    if (ajx()) {
      this.a.mBaseChatPie.a.addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (ajx())
    {
      this.a.mBaseChatPie.a.removeTextChangedListener(this.textWatcher);
      this.cSk = XPanelContainer.aLe;
      XPanelContainer.aLe = this.bQS;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((this.a.mBaseChatPie != null) && (this.a.mBaseChatPie.a != null)) {
      Ic(this.a.mBaseChatPie.a.getText().toString());
    }
  }
  
  public void onShow()
  {
    if (ajx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onShow.");
      }
      this.cSk = 0;
      daA();
      if ((this.a.mBaseChatPie != null) && (this.a.mBaseChatPie.b != null)) {
        this.a.mBaseChatPie.b.setInterceptListener(this);
      }
      daz();
    }
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (ajx())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelExtendHelper", 2, "onHide.");
      }
      if (paramBoolean) {
        break label76;
      }
      XPanelContainer.aLe = this.bQS;
    }
    for (;;)
    {
      this.cSk = 0;
      if ((this.a.mBaseChatPie != null) && (this.a.mBaseChatPie.b != null)) {
        this.a.mBaseChatPie.b.setInterceptListener(null);
      }
      return;
      label76:
      if (this.cSk != 0) {
        XPanelContainer.aLe = this.cSk;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmw
 * JD-Core Version:    0.7.0.1
 */