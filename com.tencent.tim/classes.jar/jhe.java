import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jhe
  extends jhd
{
  boolean Zm = true;
  Paint at = new Paint(1);
  private int azJ;
  private int azK;
  private int azL;
  private int azM;
  private int azN;
  jhc.a b;
  private Bitmap bx;
  private Bitmap by;
  private Canvas f = new Canvas();
  Paint mBitmapPaint = new Paint(2);
  Handler mHandler = new jhe.a(this.TAG, this);
  private int mMaxWidth;
  private int mPadding;
  private long pw;
  
  public jhe(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.mPadding = ((int)paramContext.getResources().getDimension(2131298137));
    this.mMaxWidth = (this.azH - this.mPadding * 2);
    this.azJ = (this.azH / 6);
  }
  
  private void awo()
  {
    if ((xm()) || (xn()))
    {
      int i = mv();
      int j = super.getWidth() - this.mMaxWidth;
      if ((xm()) && (j > this.azN))
      {
        this.azN += i;
        if (j < this.azM) {
          this.azM = j;
        }
      }
      j = mx() - this.mMaxWidth;
      if ((xn()) && (j > this.azM))
      {
        this.azM = (i + this.azM);
        if (j < this.azM) {
          this.azM = j;
        }
      }
    }
  }
  
  private void awp()
  {
    if (!this.mLoop)
    {
      this.Zm = false;
      requestRender();
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt)
  {
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setColor(this.jdField_a_of_type_Jhc$a.azG);
    this.mPaint.setStrokeWidth(this.jdField_a_of_type_Jhc$a.hX);
    float f1 = -this.mPaint.getFontMetrics().ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_Ijn.l, paramInt, f1, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPaint.setColor(this.jdField_a_of_type_Jhc$a.azF);
    this.mPaint.setStrokeWidth(0.0F);
    this.mPaint.setFakeBoldText(false);
    paramCanvas.drawText((String)this.jdField_a_of_type_Ijn.l, paramInt, f1, this.mPaint);
  }
  
  private void e(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    if (this.bx != null)
    {
      if (!this.bx.isRecycled())
      {
        paramCanvas.save();
        if (!xm()) {
          break label138;
        }
        paramInt2 = -this.azN;
        paramCanvas.translate(paramInt2, 0.0F);
        paramCanvas.drawBitmap(this.bx, 0.0F, 0.0F, this.mBitmapPaint);
        paramCanvas.restore();
      }
      if ((this.by != null) && (!this.by.isRecycled()))
      {
        paramInt2 = this.bx.getHeight();
        if (!xn()) {
          break label150;
        }
      }
    }
    label138:
    label150:
    for (paramInt1 = -this.azM;; paramInt1 = paramInt1 - mx() >> 1)
    {
      paramCanvas.save();
      paramCanvas.translate(paramInt1, 0.0F);
      paramCanvas.drawBitmap(this.by, 0.0F, paramInt2, this.mBitmapPaint);
      paramCanvas.restore();
      return;
      paramInt2 = paramInt1 - super.getWidth() >> 1;
      break;
    }
  }
  
  private void f(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    paramInt2 = super.getWidth();
    int i = super.getHeight();
    b(paramCanvas, paramInt1 - paramInt2 >> 1);
    g(paramCanvas, paramInt1 - mx() >> 1, i);
  }
  
  private void g(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.at.setStyle(Paint.Style.FILL_AND_STROKE);
    this.at.setColor(this.b.azG);
    this.at.setStrokeWidth(this.b.hX);
    Paint.FontMetrics localFontMetrics = this.at.getFontMetrics();
    float f1 = paramInt2 - localFontMetrics.ascent;
    paramCanvas.drawText((String)this.jdField_a_of_type_Ijn.m, paramInt1, f1, this.at);
    this.at.setStyle(Paint.Style.FILL_AND_STROKE);
    this.at.setColor(this.b.azF);
    this.at.setStrokeWidth(0.0F);
    this.at.setFakeBoldText(false);
    paramCanvas.drawText((String)this.jdField_a_of_type_Ijn.m, paramInt1, f1, this.at);
  }
  
  public Bitmap I()
  {
    awo();
    if ((this.bd == null) || (this.bd.isRecycled()))
    {
      if ((xm()) || (xn()))
      {
        M();
        N();
      }
      this.bd = H();
    }
    for (;;)
    {
      return this.bd;
      d(this.mCanvas, getWidth(), getHeight());
    }
  }
  
  Bitmap M()
  {
    try
    {
      this.bx = Bitmap.createBitmap(super.getWidth(), super.getHeight(), Bitmap.Config.ARGB_8888);
      this.f.setBitmap(this.bx);
      b(this.f, 0);
      return this.bx;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, localException.getMessage());
        }
      }
    }
  }
  
  Bitmap N()
  {
    if ((this.jdField_a_of_type_Ijn == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Ijn.m))) {
      return null;
    }
    try
    {
      this.by = Bitmap.createBitmap(mx(), mw(), Bitmap.Config.ARGB_8888);
      this.f.setBitmap(this.by);
      g(this.f, 0, 0);
      return this.by;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, localException.getMessage());
        }
      }
    }
  }
  
  public void a(ijn paramijn)
  {
    super.a(paramijn);
    if (this.jdField_a_of_type_Ijn != null) {}
    for (paramijn = this.jdField_a_of_type_Ijn.m;; paramijn = null)
    {
      paramijn = (String)paramijn;
      this.azK = b(this.at, paramijn);
      int i = getWidth();
      this.mCurrentX = ((this.azH - i) / 2);
      if ((this.jdField_a_of_type_Ijn != null) && (this.jdField_a_of_type_Ijn.isEnd()))
      {
        paramijn = this.mHandler.obtainMessage(0);
        this.mHandler.sendMessageDelayed(paramijn, 2000L);
      }
      return;
    }
  }
  
  public void b(Typeface paramTypeface, int paramInt, jhc.a parama)
  {
    if (paramTypeface != null) {
      this.at.setTypeface(paramTypeface);
    }
    this.b = parama;
    this.at.setTextSize(paramInt);
    if (this.jdField_a_of_type_Ijn != null) {}
    for (paramTypeface = this.jdField_a_of_type_Ijn.m;; paramTypeface = null)
    {
      paramTypeface = (String)paramTypeface;
      this.azK = b(this.at, paramTypeface);
      this.azL = c(this.at);
      return;
    }
  }
  
  protected void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    int i;
    if ((xm()) || (xn()))
    {
      i = 1;
      if (i == 0) {
        break label77;
      }
      e(paramCanvas, paramInt1, paramInt2);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      igd.aJ(this.TAG, "onDraw film:|" + (l2 - l1));
      return;
      i = 0;
      break;
      label77:
      f(paramCanvas, paramInt1, paramInt2);
    }
  }
  
  public int getHeight()
  {
    return (int)this.mContext.getResources().getDimension(2131298135);
  }
  
  public int getWidth()
  {
    return Math.min(Math.max(super.getWidth(), mx()), this.mMaxWidth);
  }
  
  public boolean isValidate()
  {
    return this.Zm;
  }
  
  int mv()
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    if (this.pw != 0L) {
      l1 = (l2 - this.pw) * this.azJ >> 10;
    }
    this.pw = l2;
    return (int)l1;
  }
  
  int mw()
  {
    if (this.azL == 0) {
      this.azL = c(this.at);
    }
    return this.azL;
  }
  
  int mx()
  {
    if (this.azK == 0) {
      if (this.jdField_a_of_type_Ijn == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = this.jdField_a_of_type_Ijn.m;; localObject = null)
    {
      localObject = (String)localObject;
      this.azK = b(this.at, (String)localObject);
      return this.azK;
    }
  }
  
  public void release()
  {
    super.release();
    this.mHandler.removeMessages(0);
  }
  
  void releaseBitmap()
  {
    super.releaseBitmap();
    if (this.bx != null)
    {
      this.bx.recycle();
      this.bx = null;
    }
    if (this.by != null)
    {
      this.by.recycle();
      this.by = null;
    }
  }
  
  public int x(long paramLong)
  {
    return 0;
  }
  
  boolean xm()
  {
    return super.getWidth() > this.mMaxWidth;
  }
  
  boolean xn()
  {
    return mx() > this.mMaxWidth;
  }
  
  public boolean xo()
  {
    return ((xm()) && (super.getWidth() - this.mMaxWidth > this.azN)) || ((xn()) && (mx() - this.mMaxWidth > this.azM));
  }
  
  static class a
    extends Handler
  {
    final String TAG;
    WeakReference<jhe> bK;
    
    a(String paramString, jhe paramjhe)
    {
      this.TAG = paramString;
      this.bK = new WeakReference(paramjhe);
    }
    
    public void handleMessage(Message paramMessage)
    {
      jhe localjhe = (jhe)this.bK.get();
      if (localjhe != null) {}
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      jhe.a(localjhe);
      igd.aJ(this.TAG, "ITEM_DISPEAR");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhe
 * JD-Core Version:    0.7.0.1
 */