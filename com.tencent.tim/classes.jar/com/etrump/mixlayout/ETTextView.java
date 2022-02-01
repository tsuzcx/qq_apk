package com.etrump.mixlayout;

import acej;
import adxp;
import adyk;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aofy;
import aqrh;
import aqri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import e;
import f;
import h;
import i;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import k;
import k.a;
import ko;
import ks;
import ku;
import kx;
import l;
import la;
import lc;
import lf;
import r;
import wja;
import xmj.a;
import xov.a;

public class ETTextView
  extends AnimationTextView
{
  public static final int MSG_DECORATION_RENDER = 2;
  public static final int MSG_DECORATION_TRIGGER = 0;
  public static final int MSG_DECORATION_UPDATE = 1;
  public static final int MSG_RECYCLE_BITMAP = 3;
  static final String TAG = "ETTextView";
  public static boolean enableAnimation = true;
  public static Handler mCreateDecorationHandler;
  private static boolean mReportError;
  private static Bitmap mSwapBitmap;
  private static Handler mUIHandler;
  private boolean hasComplexScript;
  private boolean hasComputeComplexScript;
  public boolean isFounderAnimating;
  public boolean isParsingMagicFont;
  public e mAnimationListener;
  private final a mBitmapLocker = new a(null);
  private boolean mCacheMeasureResult = true;
  public int mClickEpId = -1;
  public int mClickcEId = -1;
  private MotionEvent mCurrentDownEvent;
  private boolean mDecorAnimating;
  private boolean mDecorRunning;
  private ETDecoration mDecoration;
  int mEmojiX = -1;
  int mEmojiY = -1;
  private int[] mFZColor = new int[4];
  public ETFont mFont;
  public k mFounderColorLayout;
  public boolean mHasClickedArkSpan;
  public ko mLayout;
  private int mLinkBackcolor;
  public boolean mMagicFont;
  public int mMaxWidth = 2147483647;
  public ChatMessage mMessage;
  private int mMinHeight;
  private int mMinWidth;
  public long mMsgId;
  private d mOnBeforeTextOrFontChangeListener;
  private boolean mPauseAnimation;
  private MotionEvent mPreviousUpEvent;
  private Paint mSelectPaint;
  public SessionInfo mSessionInfo;
  private int mShadowColor;
  private float mShadowDx;
  private float mShadowDy;
  private float mShadowRadius;
  private lc mTextGraphMap;
  private ks mTextSelection;
  Runnable mTimerForSecondClick = new ETTextView.1(this);
  public boolean shouldStartAnimation;
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
    initHandler();
    init();
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initHandler();
    init();
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initHandler();
    init();
  }
  
  public static void clearCache()
  {
    if (mUIHandler != null) {
      mUIHandler.removeCallbacksAndMessages(null);
    }
    if (mCreateDecorationHandler != null)
    {
      mCreateDecorationHandler.removeCallbacksAndMessages(null);
      mCreateDecorationHandler.sendEmptyMessage(3);
    }
  }
  
  private void createFounderLayout(Class<? extends k> paramClass)
  {
    if ((this.mFounderColorLayout == null) || (this.mFounderColorLayout.getClass() != paramClass))
    {
      if (paramClass == l.class) {
        this.mFounderColorLayout = new l(this, this.mFont);
      }
    }
    else {
      return;
    }
    if (paramClass == r.class)
    {
      this.mFounderColorLayout = new r(this, this.mFont);
      return;
    }
    if (paramClass == e.class)
    {
      this.mFounderColorLayout = new e(this, this.mFont);
      return;
    }
    if (paramClass == f.class)
    {
      this.mFounderColorLayout = new f(this, this.mFont);
      return;
    }
    throw new RuntimeException("Unkown class: " + paramClass.getName());
  }
  
  private void dealSmallEmojiClick(int paramInt1, int paramInt2)
  {
    adxp localadxp;
    Object localObject;
    Resources localResources;
    boolean bool;
    if (this.mLayout.a(paramInt1, paramInt2) != null)
    {
      localadxp = (adxp)getTag(2131364051);
      localObject = (ChatMessage)getTag(2131364546);
      localResources = getResources();
      bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      localObject = getBackground();
      if ((localObject == null) || (!(localObject instanceof adyk))) {
        break label83;
      }
      ((adyk)localObject).bSa = true;
    }
    label83:
    while ((localObject == null) || (localadxp == null)) {
      return;
    }
    if (bool) {}
    for (paramInt1 = 2130851000;; paramInt1 = 2130850823)
    {
      localadxp.a(this, localResources.getDrawable(paramInt1));
      return;
    }
  }
  
  private boolean hasDecorAnimation()
  {
    if (this.mLayout == null) {}
    while ((this.mDecoration == null) || (this.mDecoration.getFrameNum() <= 0)) {
      return false;
    }
    return true;
  }
  
  private static void initHandler()
  {
    Object localObject;
    if (mCreateDecorationHandler == null)
    {
      mUIHandler = new f(null);
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label86;
      }
      localObject = (ku)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(42);
      if ((localObject != null) && (((ku)localObject).mHandlerThread != null) && (((ku)localObject).mHandlerThread.getLooper() != null)) {
        mCreateDecorationHandler = new b(((ku)localObject).mHandlerThread.getLooper());
      }
    }
    label86:
    do
    {
      do
      {
        return;
      } while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof ToolAppRuntime));
      localObject = kx.a();
    } while (localObject == null);
    mCreateDecorationHandler = new b(((kx)localObject).mHandlerThread.getLooper());
  }
  
  private void setFont(ETFont paramETFont, long paramLong, int paramInt)
  {
    if (this.mMsgId != paramLong) {
      this.hasComputeComplexScript = false;
    }
    if (this.mFont == null)
    {
      this.mFont = new ETFont(paramETFont.mFontId, paramETFont.mFontPath, getTextSize(), paramETFont.mFontType, paramETFont.mTypeface);
      this.mFont.copy(paramETFont);
      this.mFont.setSize(getTextSize());
    }
    for (;;)
    {
      this.mFont.m_comboIndex = paramInt;
      if ((this.mFont.mFontType != 1) && (this.mFont.mTypeface != null)) {
        setTypeface(this.mFont.mTypeface);
      }
      if (this.mFont.mFontId == 0) {
        setTypeface(null);
      }
      this.mMsgId = paramLong;
      if (this.mLayout == null) {
        this.mLayout = new ko();
      }
      this.mFont.setColor(getCurrentTextColor());
      if (this.mOnBeforeTextOrFontChangeListener != null) {
        this.mOnBeforeTextOrFontChangeListener.a(this);
      }
      return;
      this.mFont.copy(paramETFont);
      this.mFont.mAnimationId = paramLong;
      this.mFont.mText = paramETFont.mText;
      if (paramETFont.mFontType != 1) {
        this.mFont.mTypeface = paramETFont.mTypeface;
      }
      this.mFont.m_diyHandle = paramETFont.m_diyHandle;
    }
  }
  
  public void clearFounderAnimation()
  {
    if (this.mFounderColorLayout != null)
    {
      this.mMsgId = System.currentTimeMillis();
      this.mFounderColorLayout.clearAnimation();
    }
  }
  
  public void clearHighlightContent()
  {
    if (isUsingFZColorFont2()) {
      if ((this.mFounderColorLayout instanceof k.a)) {
        ((k.a)this.mFounderColorLayout).clearHighlightContent();
      }
    }
    do
    {
      return;
      if (!isUsingHYFont()) {
        break;
      }
    } while (this.mTextSelection == null);
    this.mTextSelection.clearHighlightContent();
    return;
    super.clearHighlightContent();
  }
  
  public ko getETLayout()
  {
    return this.mLayout;
  }
  
  public lc getTextGraphMap()
  {
    if (this.mTextGraphMap == null) {
      this.mTextGraphMap = new lc(getText());
    }
    return this.mTextGraphMap;
  }
  
  public boolean hasFounderAnimationFont()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mFont != null)
    {
      bool1 = bool2;
      if (this.mFont.mFontId != 0)
      {
        bool1 = bool2;
        if (this.mFont.mFontType == 4)
        {
          int i = h.h(this.mFont.mFontId);
          if ((i != 3) && (i != 7))
          {
            bool1 = bool2;
            if (i != 8) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean hasHYFont()
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (((this.mFont != null) && (this.mFont.mFontId != 0) && (this.mFont.mFontType == 1)) || (isDrawDefaultByHY())) {
      if (ETEngine.getInstance().native_containComplexScript(getText().toString())) {
        break label61;
      }
    }
    label61:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void highlightContent()
  {
    if (isUsingFZColorFont2()) {
      if ((this.mFounderColorLayout instanceof k.a))
      {
        i = getTextGraphMap().y(startIndex());
        j = getTextGraphMap().y(endIndex());
        ((k.a)this.mFounderColorLayout).f(i, j);
      }
    }
    do
    {
      return;
      if (!isUsingHYFont()) {
        break;
      }
    } while (this.mTextSelection == null);
    int i = getTextGraphMap().y(startIndex());
    int j = getTextGraphMap().y(endIndex() - 1);
    this.mTextSelection.f(i, j);
    return;
    super.highlightContent();
  }
  
  protected void init()
  {
    this.mSelectPaint = new Paint();
    setTypeface(null);
  }
  
  public boolean isCacheMeasureResult()
  {
    return this.mCacheMeasureResult;
  }
  
  public boolean isDrawDefaultByHY()
  {
    return (this.mFont != null) && (this.mFont.mFontId == 9999) && (!TextUtils.isEmpty(this.mFont.mFontPath)) && (lf.iN == 4);
  }
  
  public boolean isUseExpressFont()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isUsingFZColorFont2())
    {
      int i = h.h(this.mFont.mFontId);
      int j = h.i(this.mFont.mFontId);
      bool1 = bool2;
      if (i == 8) {
        if (j != 3)
        {
          bool1 = bool2;
          if (j != 4) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isUsingFZColorFont2()
  {
    if (!this.hasComputeComplexScript)
    {
      this.hasComplexScript = aofy.pV(getText().toString());
      this.hasComputeComplexScript = true;
    }
    return (this.mFont != null) && (this.mFont.mFontId != 0) && (this.mFont.mFontType == 4) && (!this.hasComplexScript);
  }
  
  public boolean isUsingFounderAnimationFont()
  {
    return hasFounderAnimationFont();
  }
  
  public boolean isUsingHYFont()
  {
    return (hasHYFont()) && (this.mLayout != null) && (this.mLayout.z.get());
  }
  
  public boolean isViewVisible()
  {
    if ((getContext() instanceof FragmentActivity))
    {
      Object localObject1 = ((FragmentActivity)getContext()).getChatFragment();
      if ((localObject1 != null) && (((ChatFragment)localObject1).a() != null) && (((ChatFragment)localObject1).a().b != null))
      {
        localObject1 = ((ChatFragment)localObject1).a().b;
        localObject1 = wja.a((ListView)localObject1, wja.a(this.mMsgId, ((XListView)localObject1).getAdapter()));
        Object localObject2;
        if ((localObject1 != null) && ((((View)localObject1).getTag() instanceof xov.a)))
        {
          localObject2 = (xov.a)((View)localObject1).getTag();
          if ((((xov.a)localObject2).mText == null) || (((xov.a)localObject2).mText.getTop() + ((View)localObject1).getBottom() < getContext().getResources().getDimensionPixelSize(2131299627))) {}
        }
        else
        {
          do
          {
            return true;
            if ((localObject1 == null) || (!(wja.a((View)localObject1) instanceof xmj.a))) {
              break;
            }
            localObject2 = (xmj.a)wja.a((View)localObject1);
          } while (((View)localObject1).getTop() + ((View)localObject1).getBottom() >= getContext().getResources().getDimensionPixelSize(2131299627));
        }
      }
    }
    if (((getContext() instanceof QQBrowserActivity)) || ((getContext() instanceof PublicFragmentActivity)) || ((getContext() instanceof FriendProfileCardActivity))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void locationByIndex(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (isUsingFZColorFont2()) {
      if ((this.mFounderColorLayout instanceof k.a))
      {
        paramInt = getTextGraphMap().y(paramInt);
        ((k.a)this.mFounderColorLayout).locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
      }
    }
    do
    {
      return;
      if (!isUsingHYFont()) {
        break;
      }
    } while (this.mTextSelection == null);
    paramInt = getTextGraphMap().y(paramInt);
    this.mTextSelection.locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
    return;
    super.locationByIndex(paramInt, paramArrayOfInt, paramBoolean);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mFounderColorLayout != null) {
      this.mFounderColorLayout.release();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(getText()))
    {
      super.onDraw(paramCanvas);
      return;
    }
    if ((!isUsingHYFont()) && (!isUsingFZColorFont2()))
    {
      if ((this.mFont != null) && (this.mFont.mFontId != 0))
      {
        if ((this.mFont.mFontType != 1) || (!ETEngine.getInstance().native_isColorVariantFont(this.mFont))) {
          break label123;
        }
        setTextColor(ETEngine.getInstance().native_getTextColor(this.mFont));
      }
      for (;;)
      {
        try
        {
          super.onDraw(paramCanvas);
          return;
        }
        catch (Exception paramCanvas)
        {
          QLog.e("ETTextView", 1, "onDraw failed of:" + getText(), paramCanvas);
          return;
        }
        label123:
        if (this.mFont.mFontType == 4)
        {
          ??? = this.mFZColor;
          if (i.a().getFontColor(this.mFont.mFontId, this.mFont.m_comboIndex, (int[])???) == 1) {
            setTextColor(Color.argb(???[3], ???[0], ???[1], ???[2]));
          }
        }
      }
    }
    long l1;
    int j;
    int i;
    if (isUsingHYFont())
    {
      l1 = System.currentTimeMillis();
      if (this.shouldStartAnimation) {
        startDecorAnimation(false, false);
      }
      if (this.mTextSelection != null)
      {
        ??? = this.mTextSelection.b();
        this.mSelectPaint.setColor(highlightBackgroundColor());
        if (??? != null)
        {
          j = ((SparseArray)???).size();
          i = 0;
          while (i < j)
          {
            paramCanvas.drawRect((Rect)((SparseArray)???).valueAt(i), this.mSelectPaint);
            i += 1;
          }
        }
      }
      this.mLayout.mFont.setColor(getCurrentTextColor());
    }
    for (;;)
    {
      long l2;
      synchronized (this.mBitmapLocker)
      {
        Object localObject2 = this.mBitmapLocker.getBitmap();
        int m;
        int k;
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          m = getPaddingLeft();
          k = getPaddingTop();
          if ((this.mDecorRunning) && (this.mDecoration != null))
          {
            paramCanvas.drawBitmap((Bitmap)localObject2, m, k, null);
            j = k;
            i = m;
            if (this.mDecoration.getDecorationType() == 1)
            {
              this.mLayout.a(paramCanvas, m, k);
              i = m;
              j = k;
            }
            this.mLayout.b(paramCanvas, i, j);
          }
        }
        else
        {
          l2 = System.currentTimeMillis();
          la.a("action_draw", this.mFont.mFontId, this.mFont.mFontType, getText().length(), l2 - l1);
          return;
        }
        ETEngine localETEngine = ETEngine.getInstance();
        if ((this.mDecoration == null) || (this.mDecoration.isLastFrame())) {
          break label677;
        }
        bool = true;
        ((Bitmap)localObject2).eraseColor(0);
        this.mLayout.a(localETEngine, (Bitmap)localObject2, this.mDecoration, bool);
        this.mLayout.a(paramCanvas, m, k, (Bitmap)localObject2);
        j = k;
        i = m;
        if (this.mDecoration != null)
        {
          localObject2 = this.mDecoration.mMargins;
          j = k;
          i = m;
          if (localObject2 != null)
          {
            i = m + ((Rect)localObject2).left;
            j = k + ((Rect)localObject2).top;
          }
        }
        this.mLayout.a(paramCanvas, i, j);
      }
      if (!isUsingFZColorFont2()) {
        break;
      }
      l1 = System.currentTimeMillis();
      if ((this.mFounderColorLayout != null) && (!this.mFounderColorLayout.onDraw(paramCanvas))) {
        super.onDraw(paramCanvas);
      }
      while (hasFounderAnimationFont())
      {
        startFounderDecorAnimation(false, false);
        return;
        l2 = System.currentTimeMillis();
        la.a("action_draw", this.mFont.mFontId, 4, getText().length(), l2 - l1);
      }
      break;
      label677:
      boolean bool = false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(getText()))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i;
    int j;
    for (;;)
    {
      try
      {
        if (!isUsingFZColorFont2()) {
          break label366;
        }
        i = h.h(this.mFont.mFontId);
        j = h.i(this.mFont.mFontId);
        if (i != 8) {
          break label334;
        }
        if ((j == 1) || (j == 2))
        {
          createFounderLayout(r.class);
          if (QLog.isColorLevel()) {
            QLog.d("ETTextView", 2, "createFounderLayout: " + this.mFont.mFontId + "," + i + "," + j + "," + this.mFounderColorLayout);
          }
          int[] arrayOfInt = this.mFounderColorLayout.a(paramInt1, paramInt2, this.mMsgId, this.mMagicFont, this.mFont);
          if ((arrayOfInt == null) || (arrayOfInt[0] <= 0) || (arrayOfInt[1] <= 0)) {
            break;
          }
          setMeasuredDimension(arrayOfInt[0], arrayOfInt[1]);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ETTextView", 1, "measure fail ", localThrowable);
        localThrowable.printStackTrace();
        this.mFont.mFontId = 0;
        this.mLayout.mMsgId = -1L;
        if ((!mReportError) && (localThrowable.getMessage().contains("textlayout")))
        {
          aqri.a(null, "individual_v2_font_measure_error", "font_measure_error", localThrowable.getMessage(), localThrowable.getMessage(), 0.0F);
          aqrh.is("individual_v2_font_measure_error", "font_measure_error");
          mReportError = true;
        }
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      if ((j == 3) || (j == 4) || (j == 5))
      {
        createFounderLayout(f.class);
      }
      else
      {
        createFounderLayout(l.class);
        continue;
        label334:
        if (i == 7) {
          createFounderLayout(e.class);
        } else {
          createFounderLayout(l.class);
        }
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    return;
    label366:
    if (!hasHYFont())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    boolean bool1;
    Object localObject1;
    if ((this.mLayout == null) || (this.mLayout.mMsgId != this.mMsgId) || ((this.mFont != null) && (!this.mFont.equals(this.mLayout.mFont))) || (!this.mCacheMeasureResult) || (this.mLayout.mMagicFont != this.mMagicFont))
    {
      this.mDecorRunning = false;
      this.mLayout = new ko();
      this.mTextSelection = new ks(this, this.mLayout);
      if (this.mDecoration != null)
      {
        this.mDecoration.deleteDescriptor();
        this.mDecoration = null;
      }
      int i2 = getLinkTextColors().getDefaultColor();
      if (this.mFont != null)
      {
        this.mFont.setColor(getCurrentTextColor());
        this.mFont.setSize(getTextSize());
        if ((getPaint().getFlags() & 0x20) <= 0) {
          break label1397;
        }
        bool1 = true;
        this.mFont.setBold(bool1);
        if (this.mShadowRadius <= 0.0F) {
          break label1005;
        }
        this.mFont.setShadow(true, this.mShadowColor, (int)this.mShadowDx, (int)this.mShadowDy, (int)this.mShadowRadius);
      }
      for (;;)
      {
        localObject1 = ETEngine.getInstance();
        Object localObject2 = getPaint().getFontMetrics();
        float f1 = ((Paint.FontMetrics)localObject2).descent;
        float f2 = ((Paint.FontMetrics)localObject2).ascent;
        float f3 = ((Paint.FontMetrics)localObject2).leading;
        this.mLayout.hU = ((int)(f3 + (f1 - f2)));
        this.mLayout.mMsgId = this.mMsgId;
        this.mLayout.mMagicFont = this.mMagicFont;
        this.mLayout.Q(this.mLinkBackcolor);
        localObject2 = new ETFont(this.mFont.mFontId, this.mFont.mFontPath, getTextSize());
        ((ETFont)localObject2).copy(this.mFont);
        boolean bool2 = false;
        i = this.mMaxWidth;
        if ((i1 == -2147483648) || (i1 == 1073741824)) {
          i = Math.min(this.mMaxWidth, m);
        }
        j = i - (getPaddingLeft() + getPaddingRight());
        i = j;
        if (i1 == -2147483648) {
          i = Math.min(m, j);
        }
        if (this.mLayout.mMagicFont)
        {
          f1 = ku.X;
          if (acej.aV() == 18.0F) {
            f1 = ku.Z;
          }
          ((ETFont)localObject2).setSize(f1 * getTextSize());
        }
        j = ((ETEngine)localObject1).native_getHorizontalMarginThreshold((ETFont)localObject2, i);
        ((ETFont)localObject2).setSize(getTextSize());
        bool1 = bool2;
        if (j > 0)
        {
          bool1 = bool2;
          if (j < i)
          {
            bool1 = this.mLayout.a((ETEngine)localObject1, i - j, getText(), (ETFont)localObject2, i2, true, i);
            this.mDecoration = this.mLayout.a((ETEngine)localObject1, true);
          }
        }
        if (this.mDecoration == null)
        {
          bool1 = this.mLayout.a((ETEngine)localObject1, i, getText(), (ETFont)localObject2, i2, false, i);
          this.mDecoration = this.mLayout.a((ETEngine)localObject1, true);
        }
        if (bool1) {
          break;
        }
        this.mFont.mFontId = 0;
        this.mLayout.mMsgId = -1L;
        super.onMeasure(paramInt1, paramInt2);
        return;
        label1005:
        this.mFont.setShadow(false, 0, 0, 0, 0);
      }
      if ((this.mLayout.mWidth >= 2048) || (this.mLayout.mHeight >= 2048)) {
        throw new Exception("large bitmap width=" + 0 + ", height=" + 0);
      }
      if (this.mLayout.cr) {
        throw new Exception("no text use system measure2");
      }
      i = this.mLayout.mWidth;
      j = this.mLayout.mHeight;
      if (this.mDecoration != null)
      {
        localObject1 = this.mDecoration.mMargins;
        int i4 = ((Rect)localObject1).left;
        int i5 = ((Rect)localObject1).right;
        i2 = ((Rect)localObject1).top;
        int i3 = ((Rect)localObject1).bottom;
        i += i4 + i5;
        j += i2 + i3;
        label1187:
        a.a(this.mBitmapLocker, i, j);
        label1198:
        if (this.mDecoration != null)
        {
          localObject1 = this.mDecoration.mMargins;
          break label1403;
        }
      }
    }
    for (;;)
    {
      label1217:
      m = Math.min(i, this.mMaxWidth);
      if (n == 1073741824)
      {
        j = k;
        label1240:
        setMeasuredDimension(Math.max(m, this.mMinWidth), Math.max(j, this.mMinHeight));
        return;
      }
      label1397:
      label1403:
      do
      {
        j = this.mLayout.mWidth + getPaddingLeft() + getPaddingRight();
        i = j;
        if (localObject1 == null) {
          break label1217;
        }
        i = j + (((Rect)localObject1).left + ((Rect)localObject1).right);
        break label1217;
        j = this.mLayout.mHeight + getPaddingTop() + getPaddingBottom();
        i = j;
        if (localObject1 != null)
        {
          i = ((Rect)localObject1).top;
          i = j + (((Rect)localObject1).bottom + i);
        }
        j = i;
        if (n != -2147483648) {
          break label1240;
        }
        j = Math.min(i, k);
        break label1240;
        continue;
        localObject1 = null;
        break label1187;
        localObject1 = null;
        break label1198;
        bool1 = false;
        break;
      } while (i1 != 1073741824);
      i = m;
    }
  }
  
  public boolean onPreDraw()
  {
    if ((!isUsingHYFont()) && (!isUsingFZColorFont2()))
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      return super.onPreDraw();
    }
    getViewTreeObserver().removeOnPreDrawListener(this);
    return true;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mTextGraphMap = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isUsingHYFont()) && (!isUsingFZColorFont2())) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.onDoubleClick != null)
    {
      int n;
      int i1;
      if ((this.mPreviousUpEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = getScrollX();
        i1 = getScrollY();
        this.mClickEpId = -1;
        this.mClickcEId = -1;
        if (isUsingHYFont()) {
          dealSmallEmojiClick(i - k + n, j - m + i1);
        }
        this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.mPreviousUpEvent != null) && (this.mCurrentDownEvent != null) && (isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, paramMotionEvent)))
        {
          this.isSingleClick = false;
          this.mCurrentDownEvent = null;
          this.mPreviousUpEvent = null;
          if (this.onDoubleClick != null)
          {
            this.doublleClicked = true;
            this.onDoubleClick.R(this);
            return true;
          }
        }
      }
      else
      {
        if ((this.mPreviousUpEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label331;
        }
        this.isSingleClick = true;
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = getScrollX();
        i1 = getScrollY();
        this.mClickEpId = -1;
        this.mClickcEId = -1;
        if (isUsingHYFont()) {
          dealSmallEmojiClick(i - k + n, j - m + i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "reserve to initial status");
        }
      }
    }
    label331:
    while (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ETTextView", 2, "action up");
    }
    int k = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    int m = getPaddingLeft();
    int j = getPaddingTop();
    k = k - m + getScrollX();
    i = i - j + getScrollY();
    this.mEmojiX = k;
    this.mEmojiY = i;
    if (isUsingHYFont()) {
      i = this.mLayout.i(k, i) + 1;
    }
    for (;;)
    {
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spannable)getText()).getSpans(i, i, ClickableSpan.class);
      if (arrayOfClickableSpan.length != 0)
      {
        arrayOfClickableSpan[0].onClick(this);
        return true;
        if (isUsingFZColorFont2()) {
          i = this.mFounderColorLayout.a(k, i, getTextGraphMap());
        }
      }
      else
      {
        this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
        if ((isUsingHYFont()) && (!this.mDecorRunning) && (this.mDecoration != null)) {
          this.mDecoration.gotoLastFrame();
        }
        if (this.doublleClicked)
        {
          this.doublleClicked = false;
          this.mPreviousUpEvent = null;
        }
        postDelayed(this.mTimerForSecondClick, 200L);
        break;
      }
      i = 0;
    }
  }
  
  public void pauseAnimation()
  {
    this.mPauseAnimation = true;
  }
  
  public void pauseFounderColorFontAnimation()
  {
    if (this.mFounderColorLayout != null) {
      this.mFounderColorLayout.V();
    }
  }
  
  public void restartFounderColorFontAnimation()
  {
    if (this.mFounderColorLayout != null) {
      this.mFounderColorLayout.W();
    }
  }
  
  public void setCacheMeasureResult(boolean paramBoolean)
  {
    if (this.mCacheMeasureResult != paramBoolean)
    {
      this.mCacheMeasureResult = paramBoolean;
      requestLayout();
    }
  }
  
  public void setDefaultFont(Typeface paramTypeface, long paramLong)
  {
    setTypeface(paramTypeface);
    if (lf.iN == 4) {
      if (this.mFont == null)
      {
        this.mFont = new ETFont(9999, lf.V(), getTextSize());
        this.mMsgId = paramLong;
        this.mFont.mFontType = -1;
      }
    }
    for (;;)
    {
      if (this.mOnBeforeTextOrFontChangeListener != null) {
        this.mOnBeforeTextOrFontChangeListener.a(this);
      }
      return;
      this.mFont.mFontId = 9999;
      this.mFont.setPath(lf.V());
      this.mFont.setSize(getTextSize());
      break;
      this.mFont = null;
    }
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    if (this.mFont == null) {
      this.mFont = new ETFont(paramInt, "", getTextSize());
    }
    for (;;)
    {
      if (this.mFont.mFontId == 0) {
        setTypeface(null);
      }
      if (this.mMsgId != paramLong) {
        this.hasComputeComplexScript = false;
      }
      this.mMsgId = paramLong;
      return;
      this.mFont.mFontId = paramInt;
    }
  }
  
  public void setFont(ETFont paramETFont, long paramLong)
  {
    setFont(paramETFont, paramLong, 0);
  }
  
  public void setFont(ETFont paramETFont, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    Object localObject;
    if ((paramETFont.mText == null) && ((paramChatMessage instanceof MessageForText)))
    {
      localObject = (MessageForText)paramChatMessage;
      if (TextUtils.isEmpty(((MessageForText)localObject).sb)) {
        break label114;
      }
      if (TextUtils.isEmpty(((MessageForText)localObject).sb2)) {
        break label104;
      }
      localObject = ((MessageForText)localObject).sb2;
    }
    for (;;)
    {
      paramETFont.mText = ((CharSequence)localObject);
      localObject = paramChatMessage.getExtInfoFromExtStr("vip_sub_font_id");
      int i = 0;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i = Integer.parseInt((String)localObject);
      }
      setFont(paramETFont, paramChatMessage.uniseq, i);
      this.mMessage = paramChatMessage;
      this.mSessionInfo = paramSessionInfo;
      return;
      label104:
      localObject = ((MessageForText)localObject).sb;
      continue;
      label114:
      localObject = null;
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    super.setMaxWidth(paramInt);
  }
  
  public void setMinHeight(int paramInt)
  {
    this.mMinHeight = paramInt;
    super.setMinHeight(paramInt);
  }
  
  public void setMinWidth(int paramInt)
  {
    this.mMinWidth = paramInt;
    super.setMinWidth(paramInt);
  }
  
  public void setOnTextOrFontChangeListener(d paramd)
  {
    this.mOnBeforeTextOrFontChangeListener = paramd;
  }
  
  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
    this.mShadowRadius = paramFloat1;
    this.mShadowDx = paramFloat2;
    this.mShadowDy = paramFloat3;
    this.mShadowColor = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.mOnBeforeTextOrFontChangeListener != null) {
      this.mOnBeforeTextOrFontChangeListener.a(this, paramCharSequence);
    }
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public void setTextAnimationListener(e parame)
  {
    this.mAnimationListener = parame;
  }
  
  public final void setTextMsg(CharSequence paramCharSequence)
  {
    if (getText() != null) {}
    for (String str = getText().toString();; str = "")
    {
      if ((paramCharSequence != null) && (!paramCharSequence.toString().equals(str)))
      {
        setText(paramCharSequence);
        this.mMsgId = System.currentTimeMillis();
        requestLayout();
        invalidate();
      }
      return;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Typeface localTypeface = paramTypeface;
    if (paramTypeface == null) {}
    try
    {
      localTypeface = Typeface.DEFAULT;
      super.setTypeface(localTypeface);
      return;
    }
    catch (Exception paramTypeface)
    {
      QLog.e("ETTextView", 1, "fail to setTypeface", paramTypeface);
    }
  }
  
  public void startAnimation(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isUsingHYFont()) {
      startDecorAnimation(paramBoolean1, paramBoolean2);
    }
    while (!hasFounderAnimationFont()) {
      return;
    }
    startFounderDecorAnimation(paramBoolean1, paramBoolean2);
  }
  
  public void startDecorAnimation(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mPauseAnimation = false;
    if ((!hasDecorAnimation()) || (!isViewVisible()) || (this.isParsingMagicFont)) {
      return;
    }
    if ((enableAnimation) && (!this.mPauseAnimation)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mDecorAnimating = bool;
      if ((!this.mDecorAnimating) || (this.mDecorRunning) || ((paramBoolean2) && (this.mDecoration.isLastFrame()))) {
        break;
      }
      this.mDecorRunning = true;
      this.shouldStartAnimation = false;
      mUIHandler.obtainMessage(0, c.a(this)).sendToTarget();
      if ((paramBoolean2) || (this.mAnimationListener == null)) {
        break;
      }
      this.mAnimationListener.a(this.mMessage, paramBoolean1, this.mFont.mFontId);
      return;
    }
  }
  
  public void startFounderColorFontAnimation()
  {
    if (this.mFounderColorLayout != null) {
      this.mFounderColorLayout.O();
    }
  }
  
  public void startFounderDecorAnimation(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mPauseAnimation = false;
    if ((this.mFont == null) || (!isViewVisible())) {}
    int i;
    int j;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
                    break;
                  }
                  localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                  if (localObject == null) {
                    break;
                  }
                  localObject = (ku)((QQAppInterface)localObject).getManager(42);
                } while ((localObject != null) && (!((ku)localObject).az()));
                if ((!enableAnimation) || (this.mPauseAnimation)) {
                  break;
                }
              } while ((this.mFounderColorLayout == null) || ((!this.shouldStartAnimation) && (!paramBoolean1) && (!paramBoolean2)));
              i = this.mFounderColorLayout.frameIndex;
              localObject = this.mFounderColorLayout.M;
            } while (localObject == null);
            j = localObject[0];
          } while ((paramBoolean2) && (i == 0));
          if (i == 0) {
            startFounderColorFontAnimation();
          }
          for (this.isFounderAnimating = true;; this.isFounderAnimating = true)
          {
            do
            {
              this.shouldStartAnimation = false;
              if ((paramBoolean2) || (this.mAnimationListener == null)) {
                break;
              }
              this.mAnimationListener.a(this.mMessage, paramBoolean1, this.mFont.mFontId);
              return;
            } while ((i <= 0) || (i >= j));
            restartFounderColorFontAnimation();
          }
        } while (this.mFounderColorLayout == null);
        i = this.mFounderColorLayout.frameIndex;
        localObject = this.mFounderColorLayout.M;
      } while (localObject == null);
      j = localObject[0];
    } while ((i <= 0) || (i >= j));
    pauseFounderColorFontAnimation();
  }
  
  public void stopAllDecorAnimation()
  {
    if (mUIHandler != null)
    {
      mUIHandler.removeMessages(0);
      mUIHandler.removeMessages(1);
    }
    if (mCreateDecorationHandler != null) {
      mCreateDecorationHandler.removeMessages(2);
    }
    this.mDecorAnimating = false;
    if (hasDecorAnimation()) {
      this.mDecoration.gotoLastFrame();
    }
  }
  
  public void stopFounderColorFontAnimation()
  {
    if (this.mFounderColorLayout != null) {
      this.mFounderColorLayout.u(true);
    }
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    int i = -1;
    if (isUsingFZColorFont2()) {
      if ((this.mFounderColorLayout instanceof k.a))
      {
        paramInt1 = ((k.a)this.mFounderColorLayout).touchIndex(paramInt1, paramInt2);
        i = getTextGraphMap().z(paramInt1);
      }
    }
    do
    {
      return i;
      if (!isUsingHYFont()) {
        break;
      }
    } while (this.mTextSelection == null);
    paramInt1 = this.mTextSelection.touchIndex(paramInt1, paramInt2);
    return getTextGraphMap().z(paramInt1);
    return super.touchIndex(paramInt1, paramInt2);
  }
  
  class a
  {
    private Bitmap bitmap;
    
    private a() {}
    
    private void x(int paramInt1, int paramInt2)
    {
      try
      {
        int j = ETTextView.this.mFont.getSize() * 4;
        int i = paramInt2;
        if (paramInt2 < j) {
          i = j;
        }
        if ((this.bitmap != null) && ((this.bitmap.getHeight() < i) || (this.bitmap.getWidth() < paramInt1) || (this.bitmap.getHeight() > j + i)))
        {
          this.bitmap.recycle();
          this.bitmap = null;
        }
        if (this.bitmap == null) {
          this.bitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
        }
        if (this.bitmap != null) {
          this.bitmap.setDensity(ETTextView.this.getResources().getDisplayMetrics().densityDpi);
        }
        return;
      }
      finally {}
    }
    
    Bitmap getBitmap()
    {
      return this.bitmap;
    }
  }
  
  static class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i;
      ETEngine localETEngine;
      Bitmap localBitmap;
      switch (paramMessage.what)
      {
      default: 
      case 2: 
        do
        {
          return;
          paramMessage = (ETTextView.c)paramMessage.obj;
        } while (paramMessage == null);
        i = paramMessage.bitmap.getWidth();
        int j = paramMessage.bitmap.getHeight();
        if ((ETTextView.mSwapBitmap != null) && ((ETTextView.mSwapBitmap.getWidth() < i) || (ETTextView.mSwapBitmap.getHeight() < j)))
        {
          ETTextView.mSwapBitmap.recycle();
          ETTextView.access$302(null);
        }
        if (ETTextView.mSwapBitmap == null)
        {
          ETTextView.access$302(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
          localETEngine = ETEngine.getInstanceForAnimation();
          ??? = paramMessage.a.a(localETEngine, false);
          if (??? != null) {
            ((ETDecoration)???).gotoFrame(paramMessage.frameIndex);
          }
          paramMessage.a.a(localETEngine, ETTextView.mSwapBitmap, (ETDecoration)???, true);
          if (??? != null) {
            ((ETDecoration)???).deleteDescriptor();
          }
          localBitmap = paramMessage.bitmap;
          if (paramMessage.l.get() == null) {
            break label308;
          }
        }
        break;
      }
      for (;;)
      {
        synchronized (((ETTextView)paramMessage.l.get()).mBitmapLocker)
        {
          if ((localBitmap.isRecycled()) || (((ETTextView)paramMessage.l.get()).mMsgId != paramMessage.msgId)) {
            break label303;
          }
          localBitmap.eraseColor(0);
          localETEngine.native_cloneBitmap(ETTextView.mSwapBitmap, localBitmap);
          i = 1;
          if (i == 0) {
            break;
          }
          ETTextView.mUIHandler.obtainMessage(1, paramMessage).sendToTarget();
          return;
          ETTextView.mSwapBitmap.eraseColor(0);
        }
        if (ETTextView.mSwapBitmap == null) {
          break;
        }
        ETTextView.mSwapBitmap.recycle();
        ETTextView.access$302(null);
        return;
        label303:
        i = 0;
        continue;
        label308:
        i = 0;
      }
    }
  }
  
  public static class c
  {
    public ko a;
    public long aZ;
    public Bitmap bitmap;
    public int frameIndex = -1;
    public WeakReference<ETTextView> l;
    public long msgId;
    
    static c a(ETTextView paramETTextView)
    {
      if (paramETTextView.mDecoration == null) {
        return null;
      }
      c localc = new c();
      localc.l = new WeakReference(paramETTextView);
      localc.msgId = paramETTextView.mMsgId;
      localc.a = paramETTextView.mLayout;
      localc.frameIndex = paramETTextView.mDecoration.currentFrameIndex();
      localc.bitmap = paramETTextView.mBitmapLocker.getBitmap();
      localc.aZ = System.currentTimeMillis();
      return localc;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(ETTextView paramETTextView);
    
    public abstract void a(ETTextView paramETTextView, CharSequence paramCharSequence);
  }
  
  public static abstract class e
  {
    public abstract void a(ChatMessage paramChatMessage, int paramInt);
    
    public abstract void a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt);
  }
  
  static class f
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      ETTextView.c localc = (ETTextView.c)paramMessage.obj;
      if (localc == null) {}
      ETTextView localETTextView;
      do
      {
        do
        {
          do
          {
            return;
            localETTextView = (ETTextView)localc.l.get();
          } while ((localETTextView == null) || (localETTextView.mDecoration == null));
          switch (paramMessage.what)
          {
          default: 
            return;
          }
        } while ((!localETTextView.isViewVisible()) || (ETTextView.mCreateDecorationHandler == null));
        ETTextView.mCreateDecorationHandler.obtainMessage(2, ETTextView.c.a(localETTextView)).sendToTarget();
        return;
      } while (!localETTextView.isViewVisible());
      boolean bool;
      int i;
      if ((localETTextView.mBitmapLocker.getBitmap() == localc.bitmap) && (localETTextView.mMsgId == localc.msgId) && (localETTextView.mDecoration != null) && (localETTextView.mDecoration.currentFrameIndex() == localc.frameIndex) && (localETTextView.mFont != null) && (localETTextView.mFont.equals(localc.a.mFont))) {
        if ((localETTextView.mDecorRunning) && (localETTextView.mDecorAnimating) && (ETTextView.enableAnimation) && (!localETTextView.mPauseAnimation))
        {
          bool = true;
          if (!bool) {
            break label388;
          }
          localETTextView.postInvalidate();
          paramMessage = localETTextView.mDecoration;
          if (!paramMessage.nextFrame()) {
            break label319;
          }
          i = paramMessage.getFrameDelay();
          int j = (int)(System.currentTimeMillis() - localc.aZ);
          if (j <= 0) {
            break label385;
          }
          i -= j;
          label268:
          paramMessage = obtainMessage(0, ETTextView.c.a(localETTextView));
          if (i > 1) {
            break label308;
          }
          sendMessage(paramMessage);
          label290:
          bool = true;
        }
      }
      label385:
      label388:
      for (;;)
      {
        ETTextView.access$702(localETTextView, bool);
        return;
        bool = false;
        break;
        label308:
        sendMessageDelayed(paramMessage, i);
        break label290;
        label319:
        localETTextView.shouldStartAnimation = false;
        localETTextView.postInvalidateDelayed(100L);
        if ((localETTextView.mAnimationListener != null) && (localETTextView.mFont != null)) {
          localETTextView.mAnimationListener.a(localETTextView.mMessage, localETTextView.mFont.mFontId);
        }
        bool = false;
        continue;
        QLog.e("ETTextView", 2, "this textView reused!");
        return;
        break label268;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView
 * JD-Core Version:    0.7.0.1
 */