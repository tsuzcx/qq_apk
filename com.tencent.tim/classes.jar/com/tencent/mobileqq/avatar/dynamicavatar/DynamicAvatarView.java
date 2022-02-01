package com.tencent.mobileqq.avatar.dynamicavatar;

import advr;
import adwb;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import aqcy;
import aqdj;
import aqdj.a;
import aqdk;
import aqeh;
import auvj;
import auvj.a;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.widget.URLTextImageView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DynamicAvatarView
  extends URLTextImageView
  implements auvj.a
{
  public String YP;
  public auvj a;
  private VideoDrawable.OnPlayRepeatListener a = new adwb(this);
  public boolean aLJ;
  public aqcy b;
  public boolean bRs;
  private Runnable gg = new DynamicAvatarView.1(this);
  public String mId;
  public int mSource;
  
  public DynamicAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean3, null, paramBoolean1, paramBoolean4, paramBoolean5, paramBoolean2, paramInt4);
  }
  
  public void L(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void Q(Drawable paramDrawable)
  {
    if (this.b != null)
    {
      this.b.fR = paramDrawable;
      if (this.b.getCurrDrawable() != this.b.N) {
        setImageDrawable(this.b.getCurrDrawable());
      }
      return;
    }
    setImageDrawable(paramDrawable);
  }
  
  public void cUN()
  {
    if ((this.b == null) || (!this.aLJ))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("updateImageDrawable null == mDynamicFaceDrawable: ");
        if (this.b != null) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        QLog.w("Q.dynamicAvatar", 2, bool + " isAttachToWindow: " + this.aLJ);
        return;
      }
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setImageDrawable(this.b.getCurrDrawable());
      return;
    }
    ThreadManager.getUIHandler().post(this.gg);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.aLJ = true;
    if (this.b != null) {
      setImageDrawable(this.b.getCurrDrawable());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Drawable localDrawable = getDrawable();
    if (((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof VideoDrawable)))
    {
      if (this.b != null) {
        this.b.b.a(this.b, true);
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.01");
      }
    }
    super.onDetachedFromWindow();
    removeCallbacks(this.gg);
    this.aLJ = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    QLog.e("Q.dynamicAvatar", 1, "onLoadFailed", paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((!this.bRs) && (this.aLJ) && (VideoDrawable.class.isInstance(paramURLDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnPlayRepeatListener(this.a);
    }
    QLog.i("Q.dynamicAvatar", 1, "onLoadSuccessed, curDrawable " + paramURLDrawable);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    this.mSource = paramInt5;
    this.mId = paramString;
    this.bRs = paramBoolean3;
    String str = null;
    if (this.b != null) {
      str = advr.a(this.b, false);
    }
    if (advr.b(paramInt1, paramInt2, paramString, paramInt4).equals(str))
    {
      boolean bool = this.b.aBS();
      this.b.a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, true);
      if ((paramAppInterface instanceof QQAppInterface)) {}
      for (this.b.fR = new aqdk(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean4);; this.b.fR = new aqeh(paramAppInterface, paramInt1, paramInt2, paramString, (byte)1, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean4))
      {
        this.b.a(paramBoolean4, null);
        if (!bool) {
          setImageDrawable(this.b.getCurrDrawable());
        }
        return;
      }
    }
    this.YP = "";
    if (this.b != null)
    {
      this.b.a(paramAppInterface, null, paramInt1, paramInt2, paramString, paramInt4, paramInt3, paramBoolean3, paramInt5, paramBoolean2, paramBoolean5, paramBoolean1, null, false);
      if ((paramAppInterface instanceof QQAppInterface))
      {
        this.b.fR = new aqdk(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramInt4, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean4);
        this.b.a(paramBoolean4, null);
      }
    }
    for (;;)
    {
      this.b.bb = new WeakReference(this);
      setImageDrawable(this.b.getCurrDrawable());
      return;
      this.b.fR = new aqeh(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean4);
      break;
      this.b = new aqcy(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt5);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    Drawable localDrawable = aqdj.g(paramInt1, 1);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 1, false, localDrawable, localDrawable, null, paramInt2, false, paramBoolean1, paramBoolean2, false, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = aqdj.g(paramInt1, 1);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 1, false, localDrawable, localDrawable, null, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    this.mSource = paramInt4;
    this.mId = paramString;
    this.bRs = paramBoolean1;
    String str = null;
    if (this.b != null) {
      str = advr.a(this.b, false);
    }
    if (advr.b(paramInt1, paramInt2, paramString, paramInt3).equals(str))
    {
      boolean bool = this.b.aBS();
      this.b.a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 1, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, true);
      this.b.a(paramBoolean3, paramDynamicAvatar);
      if (!bool) {
        setImageDrawable(this.b.getCurrDrawable());
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.dynamicAvatar", 2, "setFaceDrwable bitmapDrawable is: " + paramDrawable + " id: " + paramString);
      }
      return;
    }
    this.YP = "";
    if (this.b == null) {
      this.b = new aqcy(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt4);
    }
    for (;;)
    {
      this.b.bb = new WeakReference(this);
      setImageDrawable(this.b.getCurrDrawable());
      break;
      this.b.a(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, 1, paramBoolean1, paramInt4, paramBoolean5, paramBoolean4, paramBoolean2, paramDynamicAvatar, false);
      this.b.a(paramBoolean3, paramDynamicAvatar);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    aqdj.g(paramInt1, 1);
    a(paramAppInterface, paramDrawable, paramInt1, 200, paramString, false, paramInt2, false, paramBoolean1, paramBoolean2, false, paramInt3);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = getDrawable();
    if (paramDrawable == localDrawable) {
      return;
    }
    int m = 0;
    VideoDrawable localVideoDrawable = null;
    int i;
    Object localObject1;
    if ((localDrawable instanceof URLDrawable))
    {
      i = 1;
      localObject1 = ((URLDrawable)localDrawable).getCurrDrawable();
      k = i;
      if ((localObject1 instanceof VideoDrawable))
      {
        localVideoDrawable = (VideoDrawable)localObject1;
        m = 1;
      }
    }
    for (int k = i;; k = 0)
    {
      int j;
      if ((paramDrawable instanceof URLDrawable))
      {
        localObject1 = ((URLDrawable)paramDrawable).getCurrDrawable();
        if (VideoDrawable.class.isInstance(localObject1))
        {
          localObject1 = (VideoDrawable)localObject1;
          j = 1;
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject2;
        boolean bool;
        if (QLog.isDevelopLevel())
        {
          Object localObject3 = toString();
          int n = ((String)localObject3).indexOf("{");
          localObject2 = localObject3;
          if (n >= 0) {
            localObject2 = ((String)localObject3).substring(n);
          }
          if (this.b == null) {
            break label418;
          }
          localObject2 = (String)localObject2 + this.b.mKey;
          localObject3 = new StringBuilder().append("setImageDrawable isStatic: ");
          if (paramDrawable == this.b.fR)
          {
            bool = true;
            label203:
            localObject3 = ((StringBuilder)localObject3).append(bool).append(" isDynamic: ");
            if (paramDrawable != this.b.N) {
              break label412;
            }
            bool = true;
            label232:
            QLog.d("Q.dynamicAvatar", 2, bool + " " + (String)localObject2);
          }
        }
        else
        {
          label259:
          if (m == 0) {
            break label488;
          }
          if (j == 0) {
            break label461;
          }
        }
        for (;;)
        {
          if (((k != 0) && (i == 0)) || ((localDrawable == null) && (this.b != null))) {
            this.b.b.a(this.b, false);
          }
          if ((this.b != null) && (paramDrawable != this.b.N) && (paramDrawable != this.b.fR))
          {
            this.mId = "";
            this.YP = "";
            this.bRs = false;
            this.b = null;
          }
          super.setImageDrawable(paramDrawable);
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.w("Q.dynamicAvatar", 2, "setImageDrawable drawable is: " + paramDrawable + " id: " + this.mId);
          return;
          bool = false;
          break label203;
          label412:
          bool = false;
          break label232;
          label418:
          QLog.d("Q.dynamicAvatar", 2, "setImageDrawable isNotDynamicDrawable. " + (String)localObject2 + " " + this.mId);
          break label259;
          label461:
          localVideoDrawable.removeOnPlayRepeatListener(this.a);
          if (QLog.isColorLevel())
          {
            QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.02");
            continue;
            label488:
            if ((j != 0) && (!this.bRs)) {
              ((VideoDrawable)localObject1).setOnPlayRepeatListener(this.a);
            }
          }
        }
        localObject1 = null;
        i = 1;
        j = 0;
        continue;
        j = 0;
        localObject1 = null;
        i = 0;
      }
    }
  }
  
  public void setStrangerFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = aqdj.g(32, 1);
    setFaceDrawable(paramAppInterface, 32, paramInt1, paramString, (byte)1, 1, paramBoolean1, localDrawable, localDrawable, null, paramInt2, false, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */