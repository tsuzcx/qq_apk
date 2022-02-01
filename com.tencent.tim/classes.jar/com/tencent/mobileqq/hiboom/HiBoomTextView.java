package com.tencent.mobileqq.hiboom;

import ahxo;
import ahxo.a;
import ahxp;
import ahxq;
import ahxq.a;
import ahxs;
import ahxx;
import ahxy;
import ahxz;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import ankt;
import com.etrump.mixlayout.EMCollection;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import ku;
import n;

public class HiBoomTextView
  extends ImageView
{
  public static c a;
  public static Handler cX;
  private static QQLruCache<String, EMEmoticon> j = new ahxy(2014, 10);
  private static Bitmap mSwapBitmap;
  public int EP = -1;
  private boolean HK;
  public ahxo.a a;
  private ahxp jdField_a_of_type_Ahxp;
  private EMEmoticon jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon;
  private MessageForHiBoom jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom;
  public final a a;
  public d a;
  private n b;
  private String bMo;
  private String bMp;
  private boolean ciR;
  public boolean ciS;
  private ETFont d;
  public int dbW;
  private int dbX;
  private int dbY;
  private int dbZ;
  public int dca;
  private boolean mDecorRunning;
  private ETFont mFont;
  GestureDetector mGestureDetector = new GestureDetector(getContext(), new ahxx(this));
  private int mHeight;
  private int mMaxSize;
  private long mMsgId;
  private Paint mPaint;
  private SessionInfo mSessionInfo;
  private String mText;
  private int mWidth;
  private long qM;
  public float wH = 1.0F;
  
  public HiBoomTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a = new a(null);
    init();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a = new a(null);
    init();
  }
  
  public HiBoomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a = new a(null);
    init();
  }
  
  public static boolean aov()
  {
    return ETTextView.enableAnimation;
  }
  
  public static void dqR()
  {
    if (cX != null)
    {
      cX.removeCallbacksAndMessages(null);
      cX.sendEmptyMessage(260);
    }
    if (jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$c != null) {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$c.removeCallbacksAndMessages(null);
    }
    j.evictAll();
  }
  
  public static int i(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return (paramInt1 + "_" + str + "_" + paramInt2).hashCode();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setFilterBitmap(true);
    setImageResource(2130848033);
    setScaleType(ImageView.ScaleType.CENTER);
    initHandler();
  }
  
  public static void initHandler()
  {
    if (cX == null)
    {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$c = new c(null);
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        ku localku = (ku)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(42);
        if ((localku != null) && (localku.mHandlerThread != null)) {
          cX = new ahxz(localku.mHandlerThread.getLooper());
        }
      }
    }
  }
  
  public void KI(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.HK = bool;
      this.ciS = paramBoolean;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
      {
        jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$c.obtainMessage(257, b.a(this)).sendToTarget();
        if ((paramBoolean) && (!this.HK) && (!this.mDecorRunning) && (aov())) {
          this.mDecorRunning = true;
        }
      }
      return;
    }
  }
  
  public boolean aot()
  {
    if ((this.dbW == 0) || (this.EP < 0) || (this.jdField_a_of_type_Ahxo$a == null)) {
      return false;
    }
    return ahxo.a().b(this.dbW, this.EP, this.jdField_a_of_type_Ahxo$a).cX.get();
  }
  
  public boolean aou()
  {
    if ((this.dbW == 0) || (this.EP < 0) || (this.jdField_a_of_type_Ahxo$a == null)) {
      return false;
    }
    return ahxo.a().b(this.dbW, this.EP, this.jdField_a_of_type_Ahxo$a).cZ.get();
  }
  
  public boolean aow()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null;
  }
  
  public void dqQ()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom.getExtInfoFromExtStr("font_animation_played"))) {
        break label76;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom.saveExtInfoToExtStr("font_animation_played", "1");
      ThreadManager.excute(new HiBoomTextView.2(this), 128, null, true);
    }
    label76:
    for (bool1 = bool2;; bool1 = false)
    {
      this.ciS = bool1;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null) {
        KI(bool1);
      }
      return;
    }
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.ciR = false;
    if (!aot())
    {
      if (aou()) {
        setImageResource(2130848032);
      }
      setScaleX(this.wH);
      setScaleY(this.wH);
      super.onDraw(paramCanvas);
      return;
    }
    setScaleX(1.0F);
    setScaleY(1.0F);
    if ((!TextUtils.isEmpty(this.bMo)) && (this.bMo.startsWith("#")) && (this.bMo.length() == 9))
    {
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(Color.parseColor(this.bMo));
      paramCanvas.drawRoundRect(new RectF(1.0F, 1.0F, getMeasuredWidth() - 1, getMeasuredHeight() - 1), ankt.dip2px(4.0F), ankt.dip2px(4.0F), this.mPaint);
    }
    if ((!TextUtils.isEmpty(this.bMp)) && (this.bMp.startsWith("#")) && (this.bMp.length() == 9))
    {
      this.mPaint.setColor(Color.parseColor(this.bMp));
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(1.0F);
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), ankt.dip2px(4.0F), ankt.dip2px(4.0F), this.mPaint);
    }
    ahxp localahxp = ahxo.a().b(this.dbW, this.EP, this.jdField_a_of_type_Ahxo$a);
    int i = (getMeasuredWidth() - this.dbX) / 2;
    int k = (getMeasuredHeight() - this.dbY) / 2;
    if ((i > 0) || (k > 0)) {
      paramCanvas.translate(i, k);
    }
    if (localahxp.mType == 2) {}
    for (;;)
    {
      try
      {
        if (localahxp.jY(this.mText.length()))
        {
          i = Math.max(getMeasuredHeight(), getMeasuredWidth());
          localahxp.a(this.mText, i, paramCanvas);
        }
        if (!this.ciR) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("HiBoomFont.TextView", 2, "hiboom draw failed, fontId = " + this.dbW);
        }
        setImageResource(2130848032);
        setScaleX(this.wH);
        setScaleY(this.wH);
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception localException)
      {
        this.ciR = true;
        continue;
      }
      if ((localException.mType == 1) || (localException.mType == 3))
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
        {
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a.getBitmap();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            synchronized (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a)
            {
              paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
            }
          }
          setImageResource(2130848033);
          setScaleX(this.wH);
          setScaleY(this.wH);
          super.onDraw(paramCanvas);
        }
        else
        {
          this.ciR = true;
        }
      }
      else if (???.mType == 4) {
        if (this.b != null)
        {
          if (!this.b.onDraw(paramCanvas)) {
            this.ciR = true;
          }
          if (!aov()) {
            this.b.V();
          }
        }
        else
        {
          this.ciR = true;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    if ((this.mMaxSize > 0) && (i1 == 1073741824) && (k > this.mMaxSize)) {
      k = this.mMaxSize;
    }
    for (;;)
    {
      int i = m;
      if (this.mMaxSize > 0)
      {
        i = m;
        if (n == 1073741824)
        {
          i = m;
          if (m > this.mMaxSize) {
            i = this.mMaxSize;
          }
        }
      }
      if (!aot()) {
        if (this.mMaxSize > 0)
        {
          paramInt1 = this.mMaxSize;
          if (i1 != 1073741824) {
            break label191;
          }
          paramInt2 = k;
          label126:
          this.dbX = paramInt2;
          if (n == 1073741824) {
            paramInt1 = i;
          }
          this.dbY = paramInt1;
          label146:
          break label251;
        }
      }
      for (;;)
      {
        if (i1 != 1073741824) {
          k = this.dbX;
        }
        if (n != 1073741824) {
          i = this.dbY;
        }
        setMeasuredDimension(k, i);
        return;
        paramInt1 = ahxs.dbR;
        break;
        label191:
        paramInt2 = paramInt1;
        break label126;
        Object localObject = ahxo.a().b(this.dbW, this.EP, this.jdField_a_of_type_Ahxo$a);
        if (((ahxp)localObject).mType == 2)
        {
          if (((ahxp)localObject).a.Cl == null) {
            continue;
          }
          localObject = ((ahxp)localObject).a.Cl.iterator();
          label251:
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          ahxq.a locala = (ahxq.a)((Iterator)localObject).next();
          if (this.mText.length() != locala.cMZ) {
            break label146;
          }
          paramInt1 = locala.lx[0];
          paramInt2 = locala.lx[1];
          double d1 = paramInt1 / paramInt2;
          if ((i1 == 1073741824) && (n == 1073741824)) {
            if (k / i > d1)
            {
              this.dbX = ((int)(d1 * i));
              this.dbY = i;
            }
          }
          for (;;)
          {
            if (this.mMaxSize <= 0) {
              break label473;
            }
            if (paramInt1 <= paramInt2) {
              break label475;
            }
            this.dbY = (paramInt2 * this.mMaxSize / paramInt1);
            this.dbX = this.mMaxSize;
            break;
            this.dbY = ((int)(k / d1));
            this.dbX = k;
            continue;
            if (i1 == 1073741824)
            {
              this.dbX = k;
              this.dbY = ((int)(k / d1));
            }
            else if (n == 1073741824)
            {
              this.dbY = i;
              this.dbX = ((int)(d1 * i));
            }
            else
            {
              this.dbX = paramInt1;
              this.dbY = paramInt2;
            }
          }
          label473:
          continue;
          label475:
          this.dbX = (paramInt1 * this.mMaxSize / paramInt2);
          this.dbY = this.mMaxSize;
          continue;
        }
        if ((((ahxp)localObject).mType == 1) || (((ahxp)localObject).mType == 3))
        {
          paramInt1 = ahxs.dbR;
          if (this.mMaxSize > 0)
          {
            paramInt1 = this.mMaxSize;
            if (this.mFont == null)
            {
              this.dbY = paramInt1;
              this.dbX = paramInt1;
              if (i1 != 1073741824) {
                k = this.dbX;
              }
              if (n != 1073741824) {
                i = this.dbY;
              }
              setMeasuredDimension(k, i);
            }
          }
          else
          {
            if ((i1 == 1073741824) && (n == 1073741824)) {
              paramInt1 = Math.min(k, i);
            }
            for (;;)
            {
              paramInt1 = Math.min(paramInt1, ahxs.dbR);
              break;
              if (i1 == 1073741824) {
                paramInt1 = k;
              } else if (n == 1073741824) {
                paramInt1 = i;
              }
            }
          }
          this.mFont.setSize(paramInt1);
          if ((this.qM != this.mMsgId) || (!this.mFont.equals(this.d)))
          {
            this.mDecorRunning = false;
            if (this.d == null) {
              this.d = new ETFont(0, null, 0.0F);
            }
            this.d.copy(this.mFont);
            this.qM = this.mMsgId;
            this.mWidth = 0;
            this.mHeight = 0;
            if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
            {
              this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.deleteDescriptor();
              this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
            }
            this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = EMEmoticon.createEmoticon(ahxo.a().e, this.mText, this.dbZ, this.mFont);
            if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
            {
              this.mWidth = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getWidth();
              this.mHeight = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getHeight();
              if ((this.mWidth < 1) || (this.mHeight < 1))
              {
                this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.deleteDescriptor();
                this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon = null;
              }
            }
            a.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a, this.mWidth, this.mHeight);
            dqQ();
          }
          if (this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null)
          {
            this.dbX = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getWidth();
            this.dbY = this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon.getHeight();
          }
          else
          {
            this.dbY = paramInt1;
            this.dbX = paramInt1;
          }
        }
        else if (((ahxp)localObject).mType == 4)
        {
          if (this.b == null)
          {
            if (this.mMaxSize > 0)
            {
              paramInt1 = this.mMaxSize;
              label932:
              if (i1 != 1073741824) {
                break label974;
              }
            }
            label974:
            for (paramInt2 = k;; paramInt2 = paramInt1)
            {
              this.dbX = paramInt2;
              if (n == 1073741824) {
                paramInt1 = i;
              }
              this.dbY = paramInt1;
              break;
              paramInt1 = ahxs.dbR;
              break label932;
            }
          }
          localObject = this.b.a(paramInt1, paramInt2, this.mMaxSize);
          this.dbX = localObject[0];
          this.dbY = localObject[1];
          if (this.d == null) {
            this.d = new ETFont(0, null, 0.0F);
          }
          if ((this.qM != this.mMsgId) || (!this.mFont.equals(this.d)))
          {
            this.d.copy(this.mFont);
            this.qM = this.mMsgId;
            dqQ();
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refresh()
  {
    ahxp localahxp;
    Object localObject;
    if (aot())
    {
      localahxp = ahxo.a().b(this.dbW, this.EP, this.jdField_a_of_type_Ahxo$a);
      if ((localahxp == null) || ((localahxp.mType != 3) && (localahxp.mType != 1))) {
        break label266;
      }
      if ((this.mFont == null) || (this.mFont.mFontId != this.dbW))
      {
        localObject = ".hy3";
        if (localahxp.mType == 1) {
          localObject = ".hy";
        }
        localObject = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.dbW + File.separator + this.dbW + (String)localObject;
        this.mFont = new ETFont(this.dbW, (String)localObject, this.mMaxSize);
      }
      localObject = new EMCollection(ahxo.a().e);
      if ((localObject == null) || (TextUtils.isEmpty(this.mText)) || (this.mFont == null)) {
        break label258;
      }
      bool = ((EMCollection)localObject).retrieve(this.mText, this.mFont);
      i = ((EMCollection)localObject).getEmoticonCount();
      if ((!bool) || (i <= 0)) {
        break label250;
      }
      i = ((EMCollection)localObject).getEmoticonIndex(0);
      if (this.dbZ != i)
      {
        this.dbZ = i;
        this.ciS = true;
      }
    }
    label250:
    while ((localahxp == null) || (localahxp.mType != 4)) {
      for (;;)
      {
        boolean bool;
        int i;
        requestLayout();
        invalidate();
        return;
        this.dbZ = 0;
        continue;
        this.dbZ = 0;
      }
    }
    label258:
    label266:
    if ((this.mFont == null) || (this.mFont.mFontId != this.dbW))
    {
      localObject = this.jdField_a_of_type_Ahxo$a.getFontPath() + this.dbW + File.separator + this.dbW + ".fz4";
      this.mFont = new ETFont(this.dbW, (String)localObject, this.mMaxSize);
    }
    this.mFont.mText = getText();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null) {}
    for (this.mFont.mAnimationId = this.dca;; this.mFont.mAnimationId = this.mMsgId)
    {
      if (this.b == null) {
        this.b = new n(this);
      }
      this.b.a(this.mFont);
      break;
    }
  }
  
  public void restartAnimation()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutEMEmoticon != null) && (!this.HK))
    {
      jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$c.obtainMessage(259, b.a(this)).sendToTarget();
      if ((aov()) && (this.ciS)) {
        this.mDecorRunning = true;
      }
    }
    if (this.b != null) {
      this.b.W();
    }
  }
  
  public void setBGStrokeColor(String paramString)
  {
    this.bMp = paramString;
  }
  
  public void setBackgroundColor(String paramString)
  {
    this.bMo = paramString;
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, @Nonnull ahxo.a parama)
  {
    this.EP = paramInt2;
    this.jdField_a_of_type_Ahxo$a = parama;
    this.jdField_a_of_type_Ahxp = ahxo.a().b(paramInt1, paramInt2, parama);
    this.jdField_a_of_type_Ahxp.a(this);
    if (this.dbW != paramInt1)
    {
      this.dbW = paramInt1;
      this.dca = i(this.mText, this.dbW, 0);
      if (aot()) {
        refresh();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null) && (this.mMsgId != this.dca))
    {
      this.mMsgId = this.dca;
      this.ciS = true;
    }
  }
  
  public void setHiBoom(int paramInt1, int paramInt2, MessageForHiBoom paramMessageForHiBoom, SessionInfo paramSessionInfo, @Nonnull ahxo.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom = paramMessageForHiBoom;
    this.mSessionInfo = paramSessionInfo;
    if (this.mMsgId != paramMessageForHiBoom.uniseq)
    {
      this.mMsgId = paramMessageForHiBoom.uniseq;
      this.ciS = true;
    }
    setHiBoom(paramInt1, paramInt2, parama);
  }
  
  public void setLoadingScale(float paramFloat)
  {
    this.wH = paramFloat;
  }
  
  public void setMaxSize(int paramInt)
  {
    this.mMaxSize = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    do
    {
      return;
      CharSequence localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 20) {
        localCharSequence = paramCharSequence.subSequence(0, 20);
      }
      this.mText = localCharSequence.toString();
      this.dca = i(this.mText, this.dbW, 0);
      if ((this.mMsgId != this.dca) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForHiBoom == null))
      {
        this.mMsgId = this.dca;
        this.ciS = true;
      }
    } while (!aot());
    refresh();
  }
  
  public class a
  {
    private Bitmap bitmap;
    
    private a() {}
    
    /* Error */
    private void x(int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_1
      //   3: iconst_1
      //   4: if_icmplt +8 -> 12
      //   7: iload_2
      //   8: iconst_1
      //   9: if_icmpge +6 -> 15
      //   12: aload_0
      //   13: monitorexit
      //   14: return
      //   15: aload_0
      //   16: getfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   19: ifnull +37 -> 56
      //   22: aload_0
      //   23: getfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   26: invokevirtual 35	android/graphics/Bitmap:getWidth	()I
      //   29: iload_1
      //   30: if_icmplt +14 -> 44
      //   33: aload_0
      //   34: getfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   37: invokevirtual 38	android/graphics/Bitmap:getHeight	()I
      //   40: iload_2
      //   41: if_icmpge +15 -> 56
      //   44: aload_0
      //   45: getfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   48: invokevirtual 41	android/graphics/Bitmap:recycle	()V
      //   51: aload_0
      //   52: aconst_null
      //   53: putfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   56: aload_0
      //   57: getfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   60: ifnonnull +15 -> 75
      //   63: aload_0
      //   64: iload_1
      //   65: iload_2
      //   66: getstatic 47	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   69: invokestatic 51	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
      //   72: putfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   75: aload_0
      //   76: getfield 29	com/tencent/mobileqq/hiboom/HiBoomTextView$a:bitmap	Landroid/graphics/Bitmap;
      //   79: iconst_0
      //   80: invokevirtual 55	android/graphics/Bitmap:eraseColor	(I)V
      //   83: aload_0
      //   84: monitorexit
      //   85: return
      //   86: astore_3
      //   87: aload_0
      //   88: monitorexit
      //   89: aload_3
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	a
      //   0	91	1	paramInt1	int
      //   0	91	2	paramInt2	int
      //   86	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	14	86	finally
      //   15	44	86	finally
      //   44	56	86	finally
      //   56	75	86	finally
      //   75	85	86	finally
      //   87	89	86	finally
    }
    
    Bitmap getBitmap()
    {
      return this.bitmap;
    }
  }
  
  public static class b
  {
    private long aZ;
    private ETFont b;
    private Bitmap bitmap;
    private int dcb;
    private int frameIndex;
    private WeakReference<HiBoomTextView> hd;
    private long msgId = -1L;
    private String text;
    
    static b a(HiBoomTextView paramHiBoomTextView)
    {
      if (paramHiBoomTextView != null)
      {
        b localb = new b();
        localb.msgId = HiBoomTextView.a(paramHiBoomTextView);
        localb.text = HiBoomTextView.a(paramHiBoomTextView);
        localb.b = new ETFont(0, null, 0.0F);
        localb.b.copy(HiBoomTextView.a(paramHiBoomTextView));
        localb.bitmap = paramHiBoomTextView.a.getBitmap();
        localb.dcb = HiBoomTextView.a(paramHiBoomTextView);
        localb.frameIndex = HiBoomTextView.a(paramHiBoomTextView).currentFrameIndex();
        localb.hd = new WeakReference(paramHiBoomTextView);
        localb.aZ = System.currentTimeMillis();
        return localb;
      }
      return null;
    }
  }
  
  public static class c
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      HiBoomTextView.b localb = (HiBoomTextView.b)paramMessage.obj;
      if (localb == null) {}
      label277:
      label299:
      label322:
      label344:
      label377:
      label380:
      label381:
      for (;;)
      {
        return;
        HiBoomTextView localHiBoomTextView = (HiBoomTextView)HiBoomTextView.b.a(localb).get();
        if ((localHiBoomTextView != null) && (HiBoomTextView.a(localHiBoomTextView) != null)) {
          switch (paramMessage.what)
          {
          case 258: 
          default: 
            return;
          case 257: 
            if ((localHiBoomTextView.getVisibility() == 0) && (HiBoomTextView.cX != null))
            {
              HiBoomTextView.cX.obtainMessage(258, HiBoomTextView.b.a(localHiBoomTextView)).sendToTarget();
              return;
            }
            break;
          case 259: 
            if ((localHiBoomTextView != null) && (HiBoomTextView.a(localHiBoomTextView) != null) && (localHiBoomTextView.getVisibility() == 0) && (localb != null) && (HiBoomTextView.a(localHiBoomTextView) == HiBoomTextView.b.a(localb)) && (localHiBoomTextView.a.getBitmap() == HiBoomTextView.b.a(localb)) && (HiBoomTextView.a(localHiBoomTextView).currentFrameIndex() == HiBoomTextView.b.b(localb)) && (HiBoomTextView.a(localHiBoomTextView) != null) && (HiBoomTextView.a(localHiBoomTextView).equals(HiBoomTextView.b.a(localb))))
            {
              localHiBoomTextView.invalidate();
              boolean bool;
              int i;
              if ((HiBoomTextView.b(localHiBoomTextView)) && (!HiBoomTextView.c(localHiBoomTextView)) && (HiBoomTextView.aov()))
              {
                bool = true;
                if (!bool) {
                  break label380;
                }
                paramMessage = HiBoomTextView.a(localHiBoomTextView);
                if (!paramMessage.nextFrame()) {
                  break label344;
                }
                i = paramMessage.getFrameDelay();
                long l = System.currentTimeMillis() - HiBoomTextView.b.b(localb);
                if (l <= 0L) {
                  break label377;
                }
                i = (int)(i - l);
                if (i > 1) {
                  break label322;
                }
                sendMessage(obtainMessage(257, HiBoomTextView.b.a(localHiBoomTextView)));
                bool = true;
              }
              for (;;)
              {
                if (localHiBoomTextView.aow()) {
                  break label381;
                }
                HiBoomTextView.b(localHiBoomTextView, bool);
                return;
                bool = false;
                break;
                sendMessageDelayed(obtainMessage(257, HiBoomTextView.b.a(localHiBoomTextView)), i);
                break label299;
                HiBoomTextView.a(localHiBoomTextView, true);
                HiBoomTextView.b(localHiBoomTextView, false);
                if (localHiBoomTextView.aow()) {
                  localHiBoomTextView.KI(true);
                }
                bool = false;
                continue;
                break label277;
              }
            }
            break;
          }
        }
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void R(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView
 * JD-Core Version:    0.7.0.1
 */