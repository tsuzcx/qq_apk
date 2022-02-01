package com.tencent.mobileqq.onlinestatus.music;

import aiwn;
import aiwp;
import aiwr;
import akum;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import arge;
import arge.a;
import axol;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import wja;

public class OnlineStatusLyricView
  extends TextView
  implements Handler.Callback, arge.a
{
  protected aiwn a;
  private aiwr jdField_a_of_type_Aiwr;
  private Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  private arge jdField_a_of_type_Arge;
  private a jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView$a;
  private long aep;
  public String bPo;
  public String bUj;
  private boolean ckU;
  private int dek;
  private int del;
  public Friends h;
  private volatile boolean isDestroyed;
  private int mLastWidth;
  private volatile boolean mPaused;
  private int mScrollX;
  protected Handler mUIHandler;
  
  public OnlineStatusLyricView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public OnlineStatusLyricView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OnlineStatusLyricView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int FM()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i) * 0.5F - localFontMetrics.ascent);
  }
  
  private int a(aiwr paramaiwr)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return paramaiwr.dfy * 2;
    }
    return paramaiwr.dfy;
  }
  
  private aiwp a(int paramInt)
  {
    if (paramInt > 0) {}
    for (paramInt = (int)(this.aep - paramInt);; paramInt = (int)(this.aep - (this.h.songEndTime - NetConnInfoCenter.getServerTimeMillis())))
    {
      int i = this.jdField_a_of_type_Aiwn.jdMethod_if(paramInt);
      Object localObject = this.jdField_a_of_type_Aiwn.xs;
      int j = ((ArrayList)localObject).size();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      i = paramInt;
      if (paramInt >= j) {
        i = j - 1;
      }
      aiwp localaiwp = (aiwp)((ArrayList)localObject).get(i);
      localObject = localaiwp;
      if (localaiwp.dj().isEmpty())
      {
        if (this.mLastWidth != 0) {
          dDz();
        }
        QLog.d("OnlineStatusLyricView", 1, "getUILyricLineList empty");
        localObject = null;
      }
      return localObject;
    }
  }
  
  private void a(Canvas paramCanvas, aiwr paramaiwr)
  {
    if (TextUtils.isEmpty(getText().toString())) {
      return;
    }
    this.jdField_a_of_type_Aiwr = paramaiwr;
    paramCanvas.save();
    TextPaint localTextPaint = getPaint();
    paramCanvas.clipRect(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    int i = getPaddingLeft();
    int j = a(paramaiwr);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[0] != null)
    {
      m = getMeasuredHeight();
      n = getPaddingTop();
      int i1 = getPaddingBottom();
      int i2 = arrayOfDrawable[0].getBounds().height();
      k = getPaddingTop();
      m = (m - n - i1 - i2) / 2;
      Rect localRect = new Rect(0, 0, arrayOfDrawable[0].getBounds().width(), arrayOfDrawable[0].getBounds().height());
      localRect.offset(i + j, m + k);
      arrayOfDrawable[0].setBounds(localRect);
      arrayOfDrawable[0].draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(getCompoundPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    i = a(paramaiwr);
    j = getCompoundPaddingLeft();
    int k = this.mScrollX;
    if (this.dek == 0) {
      this.dek = FM();
    }
    int m = this.dek;
    int n = getPaddingTop();
    localTextPaint.setStyle(Paint.Style.FILL);
    localTextPaint.setColor(getCurrentTextColor());
    paramCanvas.drawText(paramaiwr.mText, i + j - k, m + n, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(aiwp paramaiwp)
  {
    boolean bool = false;
    long l1 = (int)(this.aep - (this.h.songEndTime - NetConnInfoCenter.getServerTimeMillis()));
    long l2 = paramaiwp.mStartTime;
    long l3 = paramaiwp.mDuration;
    if (l1 > l2 + l3) {
      return false;
    }
    int j = ((aiwr)paramaiwp.dj().get(0)).dfA;
    int k = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    int m;
    int i;
    if (j > k)
    {
      m = (int)((float)(l1 - l2) / (float)l3 * j) - (int)(this.mScrollX + 0.5F * k);
      i = this.mScrollX + m;
      if (m < 0)
      {
        if (i >= 0) {
          break label182;
        }
        i = 0;
        bool = true;
      }
    }
    for (;;)
    {
      this.mScrollX = i;
      return bool;
      if (m > 0)
      {
        j -= k;
        if (i <= j) {
          break label179;
        }
        i = j;
      }
      label179:
      for (;;)
      {
        bool = true;
        break;
        i = this.mScrollX;
        bool = true;
        break;
      }
      label182:
      bool = true;
      continue;
      i = 0;
    }
  }
  
  @SuppressLint({"WrongCall"})
  private void aZ(Canvas paramCanvas)
  {
    this.ckU = false;
    Object localObject;
    if (apl())
    {
      if ((this.jdField_a_of_type_Aiwr == null) || (!getText().toString().equals(this.jdField_a_of_type_Aiwr.mText))) {
        this.jdField_a_of_type_Aiwr = a(getText().toString());
      }
      localObject = this.jdField_a_of_type_Aiwr;
      this.mScrollX = 0;
    }
    for (;;)
    {
      if (localObject != null) {
        a(paramCanvas, (aiwr)localObject);
      }
      label142:
      aiwp localaiwp;
      do
      {
        do
        {
          return;
          if (!this.mPaused) {
            break label142;
          }
          if (this.jdField_a_of_type_Aiwr != null) {
            break;
          }
          localObject = a(this.h.songPauseRemainTime);
        } while ((localObject == null) || (((aiwp)localObject).dj().isEmpty()));
        localObject = (aiwr)((aiwp)localObject).dj().get(0);
        break;
        localObject = this.jdField_a_of_type_Aiwr;
        break;
        localaiwp = a(-1);
      } while ((localaiwp == null) || (localaiwp.dj().isEmpty()));
      localObject = (aiwr)localaiwp.dj().get(0);
      this.ckU = a(localaiwp);
    }
  }
  
  private void doRefresh()
  {
    this.isDestroyed = false;
    this.mUIHandler.removeMessages(0);
    this.mUIHandler.sendEmptyMessage(0);
  }
  
  private void stopRefresh()
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.removeMessages(0);
    }
  }
  
  public aiwr a(String paramString)
  {
    int j = (int)(getPaint().measureText(paramString) + 0.5D);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[0] != null) {}
    for (int i = arrayOfDrawable[0].getBounds().width() + getCompoundDrawablePadding();; i = 0) {
      return new aiwr(paramString, Math.max(getMeasuredWidth() / 2 - j / 2 - i, 0), 0, j + i, 0, null);
    }
  }
  
  public void aX(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void aY(Canvas paramCanvas)
  {
    aZ(paramCanvas);
  }
  
  public boolean apl()
  {
    boolean bool2 = false;
    String str = ((QQAppInterface)axol.getAppInterface()).b().oA();
    if ((str != null) && (this.h != null) && (!str.equals(this.h.uin)))
    {
      this.h = null;
      QLog.d("OnlineStatusLyricView", 1, "currentChatUin is not matched");
      return true;
    }
    if ((this.h == null) || (TextUtils.isEmpty(this.h.songName)))
    {
      this.jdField_a_of_type_Aiwn = null;
      stopRefresh();
      QLog.d("OnlineStatusLyricView", 1, "mFriend is null");
      return true;
    }
    if (!this.h.songId.equals(this.bPo))
    {
      this.jdField_a_of_type_Aiwn = null;
      this.bPo = this.h.songId;
      QLog.d("OnlineStatusLyricView", 1, "mFriend songId has changed");
      label138:
      if (this.h.songPauseRemainTime <= 0) {
        break label429;
      }
    }
    label429:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mPaused = bool1;
      if ((this.jdField_a_of_type_Aiwn == null) || (this.jdField_a_of_type_Aiwn.xs == null) || (this.jdField_a_of_type_Aiwn.xs.isEmpty()))
      {
        this.jdField_a_of_type_Aiwn = ((aiwn)akum.b().gu.get(this.h.songId));
        if ((this.jdField_a_of_type_Aiwn != null) && (this.jdField_a_of_type_Aiwn.xs != null))
        {
          this.jdField_a_of_type_Aiwn.reset();
          this.mUIHandler.sendEmptyMessage(1);
          this.aep = this.h.songDuration;
          if ((this.aep <= 0L) && (this.jdField_a_of_type_Aiwn != null) && (this.jdField_a_of_type_Aiwn.xs != null) && (!this.jdField_a_of_type_Aiwn.xs.isEmpty())) {
            this.aep = (((aiwp)this.jdField_a_of_type_Aiwn.xs.get(this.jdField_a_of_type_Aiwn.xs.size() - 1)).mStartTime + 30000L);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView$a != null) {
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView$a.dDA();
          }
          QLog.d("OnlineStatusLyricView", 1, "mLyric reset");
        }
      }
      if ((this.jdField_a_of_type_Aiwn != null) && (this.jdField_a_of_type_Aiwn.xs != null))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Aiwn.xs.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (System.currentTimeMillis() <= this.h.songEndTime) {
        break label138;
      }
      this.jdField_a_of_type_Aiwn = null;
      stopRefresh();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnlineStatusLyricView", 2, "mFriend song is deprecated");
      return true;
    }
  }
  
  public boolean asP()
  {
    return this.jdField_a_of_type_Aiwn != null;
  }
  
  public void dDz()
  {
    if (this.jdField_a_of_type_Aiwn.xs != null)
    {
      Iterator localIterator = this.jdField_a_of_type_Aiwn.xs.iterator();
      while (localIterator.hasNext())
      {
        aiwp localaiwp = (aiwp)localIterator.next();
        localaiwp.xu.clear();
        localaiwp.xu.add(a(localaiwp.mText));
      }
    }
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.mUIHandler.removeMessages(0);
      if ((!this.mPaused) && (!this.isDestroyed)) {
        if (!this.ckU) {
          break label80;
        }
      }
      label80:
      for (int i = 200;; i = 500)
      {
        this.mUIHandler.sendEmptyMessageDelayed(0, i);
        invalidate();
        return false;
      }
    }
    this.mUIHandler.removeMessages(1);
    requestLayout();
    return false;
  }
  
  public void init()
  {
    this.del = wja.dp2px(200.0F, getResources());
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Arge != null)
    {
      this.jdField_a_of_type_Arge.onDraw(paramCanvas);
      return;
    }
    aZ(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getMeasuredWidth() != this.mLastWidth)
    {
      this.mLastWidth = getMeasuredWidth();
      if (this.jdField_a_of_type_Aiwn != null) {
        dDz();
      }
      reset();
    }
    doRefresh();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLyricView", 2, new Object[] { "onLayout, mLastWidth:", Integer.valueOf(this.mLastWidth) });
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    int i;
    int j;
    if (asP())
    {
      paramInt1 = this.del;
      Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
      i = localFontMetricsInt.descent;
      j = localFontMetricsInt.ascent;
      if (arrayOfDrawable[0] == null) {
        break label184;
      }
    }
    label184:
    for (paramInt2 = arrayOfDrawable[0].getBounds().height();; paramInt2 = 0)
    {
      setMeasuredDimension(paramInt1, Math.max(paramInt2, i - j) + (getPaddingTop() + getPaddingBottom()));
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusLyricView", 2, new Object[] { "onMeasure, measureWidth:", Integer.valueOf(paramInt1) });
      }
      return;
      paramInt1 = (int)(getPaint().measureText(getText().toString()) + 0.5D);
      if ((arrayOfDrawable[0] != null) && (arrayOfDrawable[2] == null)) {
        paramInt1 += getCompoundPaddingLeft() * 2;
      }
      for (;;)
      {
        paramInt1 = Math.min(paramInt1, this.del);
        break;
        paramInt1 = paramInt1 + getCompoundPaddingLeft() + getCompoundPaddingRight();
      }
    }
  }
  
  public void reset()
  {
    this.dek = 0;
    this.jdField_a_of_type_Aiwr = null;
    this.mScrollX = 0;
  }
  
  public void setFriendSession(Friends paramFriends, String paramString)
  {
    boolean bool = false;
    this.h = paramFriends;
    this.bUj = paramString;
    if (paramFriends == null) {
      bool = true;
    }
    QLog.d("OnlineStatusLyricView", 1, new Object[] { "setFriendSession, friendIsNull:", Boolean.valueOf(bool) });
  }
  
  public void setLyricStateListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicOnlineStatusLyricView$a = parama;
  }
  
  public void setMosaicEffect(arge paramarge)
  {
    arge localarge = this.jdField_a_of_type_Arge;
    if (localarge != null) {
      localarge.setView(null);
    }
    this.jdField_a_of_type_Arge = paramarge;
    if (paramarge != null) {
      paramarge.setView(this);
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = getText().toString();
    super.setText(paramCharSequence, paramBufferType);
    if ((paramCharSequence == null) || (!str.equals(paramCharSequence.toString())))
    {
      if ((this.bUj != null) && (!paramCharSequence.equals(this.bUj)))
      {
        QLog.d("OnlineStatusLyricView", 1, new Object[] { "setText, mSongStatusName:", this.bUj });
        this.bUj = null;
        this.h = null;
        this.jdField_a_of_type_Aiwn = null;
      }
      if (this.mUIHandler != null) {
        this.mUIHandler.sendEmptyMessage(1);
      }
    }
    if (paramCharSequence == null) {}
    for (paramCharSequence = "null";; paramCharSequence = paramCharSequence.toString())
    {
      QLog.d("OnlineStatusLyricView", 1, new Object[] { "setText:", paramCharSequence });
      return;
    }
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    getPaint().setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.mUIHandler.sendEmptyMessage(1);
  }
  
  public static abstract interface a
  {
    public abstract void dDA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView
 * JD-Core Version:    0.7.0.1
 */