import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class rgb
  extends rgf
{
  public static int PADDING;
  public static final int bqW = Color.parseColor("#80000000");
  public static int bqX;
  public static int bqY = 270;
  public final long BX = 270L;
  public rgb.a a;
  public rgb.b a;
  public riy a;
  public boolean aHE;
  private rgb.b b;
  public int bqZ;
  public int bra = bqW;
  public int brb;
  public int mItemHeight;
  public int mMode;
  public Paint mRectPaint;
  public int mScreenWidth;
  public int mStartY;
  
  public rgb(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    init();
  }
  
  private boolean Lq()
  {
    return ("vivo Xplay3S".equalsIgnoreCase(Build.MODEL)) || ("G3226".equalsIgnoreCase(Build.MODEL));
  }
  
  private void btU()
  {
    setMode(6);
    this.b = new rgb.b(this.jdField_a_of_type_Rgb$b);
    rgb.b.a(this.b);
  }
  
  private void init()
  {
    this.mItemHeight = wja.dp2px(50.0F, this.context.getResources());
    this.mScreenWidth = riw.getWindowScreenWidth(this.context);
    this.bqZ = 1;
    this.mMode = 1;
    this.jdField_a_of_type_Rgb$b = new rgb.b();
    this.mRectPaint = new Paint();
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectPaint.setColor(this.bra);
    this.jdField_a_of_type_Riy = new riy();
    riy localriy = this.jdField_a_of_type_Riy;
    if (Lq()) {}
    for (float f = 3.0F;; f = 6.0F)
    {
      localriy.setMaxScale(f);
      this.jdField_a_of_type_Riy.setMinScale(0.2F);
      this.jdField_a_of_type_Riy.tP(true);
      bqX = ViewConfiguration.get(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getContext()).getScaledTouchSlop();
      return;
    }
  }
  
  private void setMode(int paramInt)
  {
    ram.d("TextLayer", "setMode:" + paramInt + ",preMode:" + this.bqZ);
    this.bqZ = this.mMode;
    this.mMode = paramInt;
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i;
    int j;
    if (isVisible())
    {
      i = (int)paramMotionEvent.getY();
      j = Math.abs(i - this.mStartY);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        this.jdField_a_of_type_Riy.a(paramMotionEvent, false);
        if (this.jdField_a_of_type_Rgb$b != null) {
          this.jdField_a_of_type_Rgb$a.b(this.jdField_a_of_type_Rgb$b.aIq, this.jdField_a_of_type_Rgb$b.nI, (int)this.jdField_a_of_type_Rgb$b.translateXValue, (int)this.jdField_a_of_type_Rgb$b.translateYValue, this.jdField_a_of_type_Rgb$b.centerP, this.jdField_a_of_type_Rgb$b.aHC, 2);
        }
        break;
      }
    }
    for (;;)
    {
      bool = true;
      return bool;
      if (this.jdField_a_of_type_Rgb$b != null)
      {
        this.jdField_a_of_type_Rgb$b.aHC = false;
        this.jdField_a_of_type_Rgb$b.aIq = false;
        this.jdField_a_of_type_Rgb$b.startAnimator();
      }
      this.jdField_a_of_type_Riy.d(this.jdField_a_of_type_Rgb$b);
      this.mStartY = i;
      break;
      if (this.jdField_a_of_type_Rgb$b == null) {
        break;
      }
      this.jdField_a_of_type_Rgb$b.aHC = true;
      this.jdField_a_of_type_Rgb$b.cancelAnimator();
      break;
      if (this.jdField_a_of_type_Rgb$b != null)
      {
        this.jdField_a_of_type_Rgb$b.aIq = true;
        if (this.mMode == 3) {
          this.jdField_a_of_type_Rgb$b.cancelAnimator();
        }
      }
      if (j <= bqX) {
        break;
      }
      setMode(3);
      break;
      if (this.jdField_a_of_type_Rgb$b != null)
      {
        this.jdField_a_of_type_Rgb$b.aIq = false;
        this.jdField_a_of_type_Rgb$b.cancelAnimator();
      }
      a(this, false);
      if (j < bqX)
      {
        btT();
        break;
      }
      if (this.mMode != 3) {
        break;
      }
      setMode(4);
      break;
      if (this.jdField_a_of_type_Rgb$b == null) {
        break;
      }
      this.jdField_a_of_type_Rgb$b.aHC = false;
      break;
      this.jdField_a_of_type_Rgb$a.b(false, 0.0F, 0, 0, null, false, 0);
    }
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    boolean bool1 = bool2;
    if (isVisible())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Riy.a(this.jdField_a_of_type_Rgb$b, f1, f2, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean J(MotionEvent paramMotionEvent)
  {
    if (!isVisible()) {}
    while (paramMotionEvent.getPointerCount() < 2) {
      return false;
    }
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    return this.jdField_a_of_type_Riy.a(this.jdField_a_of_type_Rgb$b, f1, f2, f3, f4);
  }
  
  public rgm a()
  {
    return this.jdField_a_of_type_Rgb$b.a();
  }
  
  public void a(rgb.a parama)
  {
    this.jdField_a_of_type_Rgb$a = parama;
  }
  
  public void a(rgm paramrgm)
  {
    if (paramrgm == null)
    {
      ram.e("TextLayer", "textInfo is null.");
      return;
    }
    ram.d("TextLayer", "setTextInfo:" + paramrgm.text);
    this.jdField_a_of_type_Rgb$b.a(paramrgm);
    super.notifyChange();
  }
  
  protected void an(Canvas paramCanvas)
  {
    if (this.aHE) {}
    do
    {
      return;
      if ((this.mMode == 6) && (this.b != null))
      {
        this.b.draw(paramCanvas);
        return;
      }
    } while ((this.mMode != 4) && (this.mMode != 3));
    this.jdField_a_of_type_Rgb$b.draw(paramCanvas);
  }
  
  public void ao(Canvas paramCanvas)
  {
    b(paramCanvas, this.scaleValue);
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    this.jdField_a_of_type_Rgb$b.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void btT()
  {
    if ((this.jdField_a_of_type_Rgb$a != null) && (this.jdField_a_of_type_Rgb$a.a(this.jdField_a_of_type_Rgb$b))) {
      this.aHE = true;
    }
  }
  
  public void btV()
  {
    this.aHE = false;
    if (this.jdField_a_of_type_Rgb$b != null) {
      this.jdField_a_of_type_Rgb$b.aIp = false;
    }
  }
  
  public void clear()
  {
    this.mMode = 1;
    this.bqZ = 1;
    this.bra = bqW;
    this.brb = 0;
    this.jdField_a_of_type_Rgb$b.clear();
    this.mRectPaint.setColor(this.bra);
    this.jdField_a_of_type_Riy.e(this.jdField_a_of_type_Rgb$b);
    btV();
    ram.d("TextLayer", "clear over");
    if (this.jdField_a_of_type_Rgb$a != null) {
      this.jdField_a_of_type_Rgb$a.btX();
    }
  }
  
  public String getTag()
  {
    return "TextLayer";
  }
  
  public boolean isEmpty()
  {
    return this.mMode == 1;
  }
  
  public boolean isVisible()
  {
    return (this.mMode == 4) || (this.mMode == 3);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    super.setSize(paramInt1, paramInt2);
    this.jdField_a_of_type_Rgb$b.rect.set(0, this.drawRect.height() / 2 - this.mItemHeight / 2, this.drawRect.right, this.drawRect.height() / 2 + this.mItemHeight / 2);
    this.jdField_a_of_type_Rgb$b.centerP.x = (paramInt1 / 2);
    this.jdField_a_of_type_Rgb$b.centerP.y = (0.42F * paramInt2);
    PADDING = (int)(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getBitmapWidth() * 0.04F);
  }
  
  public void startAnimate()
  {
    if (!isEmpty()) {
      btU();
    }
    while (this.jdField_a_of_type_Rgb$a == null) {
      return;
    }
    this.jdField_a_of_type_Rgb$a.ad(1.0F);
  }
  
  public void tI(boolean paramBoolean)
  {
    ram.d("TextLayer", "setKeyboardState:" + paramBoolean);
    if (paramBoolean) {}
    for (;;)
    {
      super.notifyChange();
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Rgb$b.a.text)) {
        setMode(1);
      } else {
        setMode(4);
      }
    }
  }
  
  public int tp()
  {
    if (isVisible()) {
      return 1;
    }
    return 0;
  }
  
  public void xm(int paramInt)
  {
    if (paramInt < 0)
    {
      ram.e("TextLayer", "setTextTop:" + paramInt);
      return;
    }
    ram.d("TextLayer", "setTextTop:" + paramInt);
    this.brb = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(rgb.b paramb);
    
    public abstract void ad(float paramFloat);
    
    public abstract void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3);
    
    public abstract void btW();
    
    public abstract void btX();
  }
  
  public class b
    extends riy.a
  {
    public rgm a;
    StaticLayout b;
    public TextPaint e;
    float mS;
    protected float mT;
    protected float mU;
    protected float mV;
    protected float mZ;
    protected float mf;
    protected float mg;
    protected float na;
    protected float nb;
    Rect rect;
    
    public b()
    {
      super(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, true);
      this.rect = new Rect();
      this.jdField_a_of_type_Rgm = new rgm();
      this.jdField_a_of_type_Rgm.text = "";
      this.jdField_a_of_type_Rgm.color = -1;
      this.jdField_a_of_type_Rgm.size = rgb.this.context.getResources().getDimensionPixelSize(2131299590);
      this.jdField_a_of_type_Rgm.state = 2;
      this.jdField_a_of_type_Rgm.brg = -1;
      this.e = new TextPaint();
      this.e.setTypeface(Typeface.DEFAULT);
      this.e.setTextAlign(Paint.Align.CENTER);
      this.e.setAntiAlias(true);
      this.e.setStyle(Paint.Style.FILL_AND_STROKE);
      this.e.setTextSize(this.jdField_a_of_type_Rgm.size);
      this.e.setColor(this.jdField_a_of_type_Rgm.color);
      this.e.setTextAlign(Paint.Align.LEFT);
      this.b = new StaticLayout("", this.e, rgb.this.mScreenWidth - rgb.PADDING * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      this.bsp = rpq.dip2px(BaseApplicationImpl.getContext(), 7.5F);
    }
    
    public b(@NonNull b paramb)
    {
      super(1.0F);
      this.rect = new Rect(paramb.rect);
      this.jdField_a_of_type_Rgm = new rgm();
      this.jdField_a_of_type_Rgm.b(paramb.jdField_a_of_type_Rgm);
      this.e = new TextPaint();
      this.e.setTypeface(Typeface.DEFAULT);
      this.e.setTextAlign(Paint.Align.CENTER);
      this.e.setAntiAlias(true);
      this.e.setStyle(Paint.Style.FILL_AND_STROKE);
      this.e.setTextAlign(Paint.Align.LEFT);
      this.e.setTextSize(paramb.jdField_a_of_type_Rgm.size);
      this.e.setColor(paramb.jdField_a_of_type_Rgm.color);
      this.mS = paramb.mS;
      this.b = new StaticLayout(paramb.jdField_a_of_type_Rgm.text, paramb.e, rgb.this.mScreenWidth - rgb.PADDING * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      this.mT = paramb.mT;
      this.mU = paramb.mU;
      this.mV = paramb.mV;
      this.mZ = paramb.mZ;
      this.mf = paramb.mf;
      this.mg = paramb.mg;
      this.na = paramb.na;
      this.nb = paramb.nb;
      this.bsp = rpq.dip2px(BaseApplicationImpl.getContext(), 7.5F);
    }
    
    private void btU()
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        btY();
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        localValueAnimator.setDuration(270L);
        localValueAnimator.addUpdateListener(new rgc(this));
        localValueAnimator.start();
      }
    }
    
    public rgm a()
    {
      rgm localrgm = new rgm();
      localrgm.b(this.jdField_a_of_type_Rgm);
      return localrgm;
    }
    
    public void a(rgm paramrgm)
    {
      this.jdField_a_of_type_Rgm.text = paramrgm.text;
      this.jdField_a_of_type_Rgm.color = paramrgm.color;
      this.jdField_a_of_type_Rgm.brg = paramrgm.brg;
      this.e.setColor(paramrgm.color);
      this.e.setAlpha(255);
      this.b = new StaticLayout(this.jdField_a_of_type_Rgm.text, this.e, this.jdField_a_of_type_Rgb.mScreenWidth - rgb.PADDING * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      if (this.b.getLineCount() == 1) {
        this.width = this.e.measureText(this.jdField_a_of_type_Rgm.text);
      }
      for (this.height = (this.e.descent() - this.e.ascent());; this.height = this.b.getHeight())
      {
        this.mS = rgb.PADDING;
        return;
        this.width = this.b.getWidth();
      }
    }
    
    protected void btY()
    {
      this.mV = this.translateXValue;
      this.mZ = this.translateYValue;
      this.mT = this.scaleValue;
      this.mU = this.nI;
      this.mf = (-this.centerP.x + this.width / 2.0F + this.mS - this.mV);
      this.mg = (this.jdField_a_of_type_Rgb.brb + this.height / 2.0F - this.centerP.y - this.mZ);
      this.na = (1.0F - this.mT);
      if (this.mU < 180.0F)
      {
        this.nb = (0.0F - this.mU);
        return;
      }
      this.nb = (360.0F - this.mU);
    }
    
    public void cancelAnimator()
    {
      if ((this.N != null) && (this.aIo)) {
        this.N.cancel();
      }
    }
    
    public void clear()
    {
      this.jdField_a_of_type_Rgm.color = -1;
      this.jdField_a_of_type_Rgm.brg = -1;
      this.jdField_a_of_type_Rgm.text = "";
      this.e.setColor(this.jdField_a_of_type_Rgm.color);
      this.b = new StaticLayout(this.jdField_a_of_type_Rgm.text, this.e, this.jdField_a_of_type_Rgb.mScreenWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      this.centerP.x = (this.jdField_a_of_type_Rgb.drawRect.width() / 2);
      this.centerP.y = (this.jdField_a_of_type_Rgb.drawRect.height() / 2);
    }
    
    public void draw(Canvas paramCanvas)
    {
      if (this.b == null) {
        return;
      }
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Rgb.a.a(this));
      if (this.b.getLineCount() == 1)
      {
        this.e.setTextAlign(Paint.Align.CENTER);
        float f = -((this.e.descent() + this.e.ascent()) / 2.0F);
        paramCanvas.drawText(this.jdField_a_of_type_Rgm.text, 0.0F, f, this.e);
      }
      for (;;)
      {
        paramCanvas.restore();
        if (!this.aIp) {
          break;
        }
        riw.a(paramCanvas, this.jdField_a_of_type_Rgb.a, this, 0, 2130845494, 2130845501);
        return;
        this.e.setTextAlign(Paint.Align.LEFT);
        paramCanvas.translate(-this.width / 2.0F, -this.height / 2.0F);
        this.b.draw(paramCanvas);
      }
    }
    
    public void startAnimator()
    {
      if (this.N == null)
      {
        this.N = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
        this.N.setDuration(200L);
        this.N.setInterpolator(new LinearInterpolator());
        this.N.addUpdateListener(new rgd(this));
        this.N.addListener(new rge(this));
      }
      if (!this.aIo) {
        this.N.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgb
 * JD-Core Version:    0.7.0.1
 */