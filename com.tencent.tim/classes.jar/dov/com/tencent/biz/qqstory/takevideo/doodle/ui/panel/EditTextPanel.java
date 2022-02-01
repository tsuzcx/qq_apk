package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import ahal;
import ahep;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqcl;
import axov;
import axtq;
import axug;
import aynp;
import aynq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.b;

public class EditTextPanel
  extends RelativeLayout
  implements ahep
{
  public static String TAG = "EditTextPanel";
  a a;
  int aXA = -1;
  public EditTextEffectView b;
  EditText bN;
  private DynamicTextConfigManager.b c = new aynp(this);
  int eKM = 0;
  private int eKx;
  int mCurrentTab = -1;
  int mSelectedPosition;
  
  public EditTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new EditTextEffectView(paramContext, this);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.b, paramContext);
  }
  
  private void b(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramDynamicTextConfigBean, paramInt);
    }
  }
  
  public void C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "selectItem position = " + paramInt2);
    }
    DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = a(paramInt1, paramInt2);
    if (localDynamicTextConfigBean != null)
    {
      if (this.bN != null) {
        this.bN.getText().toString();
      }
      b(localDynamicTextConfigBean, paramInt2);
    }
    for (;;)
    {
      this.mSelectedPosition = paramInt2;
      this.aXA = paramInt1;
      this.b.select(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "cancelChoose");
      }
    }
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt1, int paramInt2)
  {
    try
    {
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = this.b.a(paramInt2);
      return localDynamicTextConfigBean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getSelectedItem" + paramInt1 + " " + this.mSelectedPosition + "itemPosition=" + paramInt2);
      }
    }
    return null;
  }
  
  public void h(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onItemClick position = " + paramInt1);
    }
    this.eKM = paramInt1;
    DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = a(paramInt2, paramInt1);
    if (localDynamicTextConfigBean != null) {
      if (!AppSetting.enableTalkBack) {}
    }
    while (!QLog.isColorLevel()) {
      try
      {
        aqcl.speak(paramView, axug.aa(localDynamicTextConfigBean.text_id, 0));
        DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)axov.a(7);
        axtq localaxtq = (axtq)axov.a(14);
        if (localDynamicTextConfigBean != null) {
          localaxtq.hk(String.valueOf(localDynamicTextConfigBean.text_id), 5);
        }
        if (localDynamicTextConfigManager.a(localDynamicTextConfigBean))
        {
          ii(paramInt2, paramInt1);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        if (NetConnInfoCenter.isMobileConn())
        {
          ahal.a(paramView.getContext(), 2131700392, 2131700391, new aynq(this, localException, localDynamicTextConfigBean));
          return;
        }
        localException.a(localDynamicTextConfigBean, this.c);
        return;
      }
    }
    QLog.d(TAG, 2, "onItemClick item null");
  }
  
  public void ii(int paramInt1, int paramInt2)
  {
    C(paramInt1, paramInt2, false);
  }
  
  public void j(EditText paramEditText)
  {
    this.bN = paramEditText;
  }
  
  public int mc(int paramInt)
  {
    paramInt = this.b.mb(paramInt);
    if (paramInt >= 0)
    {
      this.b.select(paramInt);
      postDelayed(new EditTextPanel.1(this, paramInt), 200L);
      this.mSelectedPosition = paramInt;
      this.aXA = paramInt;
    }
    return paramInt;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    if (this.b != null)
    {
      this.b.setEditPhoto(paramBoolean);
      this.b.ie();
    }
  }
  
  public void setOpIn(int paramInt)
  {
    this.eKx = paramInt;
    if (this.b != null) {
      this.b.setOpIn(paramInt);
    }
  }
  
  public void setPanelListener(a parama)
  {
    this.a = parama;
  }
  
  public void x(View paramView, int paramInt1, int paramInt2) {}
  
  public static abstract interface a
  {
    public abstract void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel
 * JD-Core Version:    0.7.0.1
 */