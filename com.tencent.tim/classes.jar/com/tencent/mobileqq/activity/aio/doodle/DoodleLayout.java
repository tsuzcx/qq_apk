package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqcu;
import argt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import wja;
import wrb;
import wrc;
import wrq;

public class DoodleLayout
  extends RelativeLayout
  implements ScribbleResMgr.b
{
  private a jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout$a;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private DoodleView b;
  private int bRb;
  private ImageView sx;
  private ImageView sy;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean av(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.sy != null) {
        this.sy.setVisibility(8);
      }
      return false;
    }
    int i = wja.dp2px(50.0F, getResources());
    int j = wja.dp2px(37.0F, getResources());
    if (this.sy == null)
    {
      this.sy = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13, -1);
      this.sy.setLayoutParams(localLayoutParams);
      this.sy.setImageDrawable(b(i, j));
      addView(this.sy);
    }
    if (this.sy != null) {
      this.sy.setVisibility(0);
    }
    return true;
  }
  
  private Drawable b(int paramInt1, int paramInt2)
  {
    argt localargt = new argt(aj(), 0, false);
    localargt.setBounds(new Rect(0, 0, paramInt1, paramInt2));
    return localargt;
  }
  
  private void init()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.sx == null)
    {
      this.sx = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.sx.setLayoutParams(localLayoutParams);
      addView(this.sx);
    }
    if (this.b == null)
    {
      this.b = new DoodleView(getContext(), null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.b.setLayoutParams(localLayoutParams);
      this.b.setBackgroundColor(getResources().getColor(2131167595));
      addView(this.b);
      this.b.a(new wrc(this));
    }
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundColor(-1);
    ba(true, false);
  }
  
  public Bitmap U()
  {
    QLog.d("DoodleLayout", 2, "getDoodleBitmap begin");
    Bitmap localBitmap = e(20);
    QLog.d("DoodleLayout", 2, "getDoodleBitmap end");
    return localBitmap;
  }
  
  public wrb a()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.a(false);
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if ((paramInt1 != 2) || (paramResInfo == null) || (paramResInfo.sourceId != this.bRb)) {}
    do
    {
      do
      {
        return;
        if (1 == paramInt2)
        {
          this.bRb = -1;
          setTemplateID(paramResInfo.sourceId);
          return;
        }
        if ((2 != paramInt2) && (3 != paramInt2)) {
          break;
        }
        av(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), getResources().getString(2131690114), 0);
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.isShowing());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.show();
      return;
    } while (4 != paramInt2);
  }
  
  protected Bitmap aj()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("aio_doodle_progress_list");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = aqcu.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130839658);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("aio_doodle_progress_list", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public void ba(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b != null) {
      this.b.yS(paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.bRb = 0;
      setTemplateVisible(Boolean.valueOf(false));
    }
  }
  
  public int e(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    if (this.b != null)
    {
      j = this.b.t(paramBoolean2);
      if (this.bRb > 0)
      {
        if (!paramBoolean1) {
          break label48;
        }
        i = j + i;
      }
    }
    label48:
    do
    {
      return i;
      i = 0;
      break;
      return j;
      i = k;
    } while (!paramBoolean1);
    if (this.bRb > 0) {}
    for (i = j;; i = 0) {
      return i;
    }
  }
  
  public Bitmap e(int paramInt)
  {
    if ((paramInt <= 0) || (this.b == null)) {
      return null;
    }
    return this.b.j(paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    if (this.b != null) {
      this.b.setLineColor(paramInt);
    }
  }
  
  public void setDoodleLayoutListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout$a = parama;
  }
  
  public void setTemplateID(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "setTemplateID:" + paramInt);
    }
    if (this.bRb == paramInt) {}
    do
    {
      Object localObject;
      do
      {
        return;
        this.bRb = paramInt;
        if (this.bRb <= 0) {
          break;
        }
        localObject = wrq.a().getBitmap(3, this.bRb);
        if ((localObject != null) && (this.sx != null))
        {
          this.sx.setImageBitmap((Bitmap)localObject);
          setTemplateVisible(Boolean.valueOf(true));
          av(false);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "load bitmap failed:" + this.bRb);
        }
        if (!wrq.a().ax(3, this.bRb))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "file not exist, start download:" + this.bRb);
          }
          av(true);
          setTemplateVisible(Boolean.valueOf(false));
          wrq.a().b(1, paramInt, this, this);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DoodleLayout", 2, "try use drawable:" + this.bRb);
        }
        localObject = wrq.a().a(3, this.bRb, false);
      } while ((localObject == null) || (this.sx == null));
      this.sx.setImageDrawable((Drawable)localObject);
      setTemplateVisible(Boolean.valueOf(true));
      av(false);
    } while (!QLog.isColorLevel());
    QLog.d("DoodleLayout", 2, "use drawable succ:" + this.bRb);
    return;
    setTemplateVisible(Boolean.valueOf(false));
    av(false);
  }
  
  public void setTemplateVisible(Boolean paramBoolean)
  {
    if (this.sx != null)
    {
      if (paramBoolean.booleanValue()) {
        this.sx.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.sx.setVisibility(8);
  }
  
  public void setTexture(int paramInt)
  {
    if (this.b != null) {
      this.b.setLineTexture(paramInt);
    }
  }
  
  public void unInit()
  {
    if (this.b != null) {
      this.b.unInit();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleLayout$a = null;
    this.sx = null;
    this.bRb = 0;
  }
  
  public void undo()
  {
    if ((this.b != null) && (this.b.t(false) > 0)) {
      this.b.undo();
    }
  }
  
  public int vY()
  {
    return this.bRb;
  }
  
  public static abstract interface a
  {
    public abstract void CF(int paramInt);
    
    public abstract void ft(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */